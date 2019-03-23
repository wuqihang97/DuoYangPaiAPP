package cn.tedu.wqhtest.frag;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.adapter.GuideLabelAdapter;
import cn.tedu.wqhtest.ui.MainActivity;

public class GuideLabelFragment extends Fragment implements
		AdapterView.OnItemClickListener, View.OnClickListener {
	private ImageView ivGuideLabel;
	// 声明列表
	private GridView gvContents;
	private GuideLabelAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_guide_label, null);

		// 初始化控件
		setViews(view);

		List<String> contacts = new ArrayList<String>();
		contacts.add("休闲娱乐");
		contacts.add("艺术展览");
		contacts.add("学术论坛");
		contacts.add("社会公益");
		contacts.add("运动健身");
		contacts.add("舞台剧");
		contacts.add("旅游");
		contacts.add("美食");
		contacts.add("画展");
		contacts.add("聚会");
		contacts.add("亲子互动");
		contacts.add("马拉松");

		// 创建Adapter对象
		adapter = new GuideLabelAdapter(getActivity(), contacts);

		// 为ListView配置Adapter
		gvContents.setAdapter(adapter);

		// 添加监听
		setListeners();

		return view;
	}

	private void setListeners() {
		gvContents.setOnItemClickListener(this);
		ivGuideLabel.setOnClickListener(this);
	}

	private void setViews(View view) {
		gvContents = (GridView) view.findViewById(R.id.gv_guide_label);
		ivGuideLabel = (ImageView) view.findViewById(R.id.iv_guide_label);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Button item = (Button) view.getTag();
		item.setTextColor(R.color.home_main_color);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_guide_label:
			// 销毁当前Activity
			getActivity().finish();
			Intent intent = new Intent(getActivity(), MainActivity.class);
			startActivity(intent);
			break;
		}
	}
}
