package cn.tedu.wqhtest.frag;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.adapter.DynamicAdapter;

public class DynamicNearFragment extends Fragment implements
		AdapterView.OnItemClickListener {

	// 声明列表
	private ListView lvContents;
	private DynamicAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_dynamic_near, null);
		// 列表
		lvContents = (ListView) view
				.findViewById(R.id.lv_dynamic_near_contents);

		List<Integer> contacts = new ArrayList<Integer>();
		contacts.add(R.drawable.bg6_img_content_nor4);
		contacts.add(R.drawable.bg6_img_content_nor5);
		contacts.add(R.drawable.bg6_img_content_nor6);

		// 创建Adapter对象
		adapter = new DynamicAdapter(getActivity(), contacts);

		// 为ListView配置Adapter
		lvContents.setAdapter(adapter);

		lvContents.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}
}
