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
	// �����б�
	private GridView gvContents;
	private GuideLabelAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_guide_label, null);

		// ��ʼ���ؼ�
		setViews(view);

		List<String> contacts = new ArrayList<String>();
		contacts.add("��������");
		contacts.add("����չ��");
		contacts.add("ѧ����̳");
		contacts.add("��ṫ��");
		contacts.add("�˶�����");
		contacts.add("��̨��");
		contacts.add("����");
		contacts.add("��ʳ");
		contacts.add("��չ");
		contacts.add("�ۻ�");
		contacts.add("���ӻ���");
		contacts.add("������");

		// ����Adapter����
		adapter = new GuideLabelAdapter(getActivity(), contacts);

		// ΪListView����Adapter
		gvContents.setAdapter(adapter);

		// ��Ӽ���
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
			// ���ٵ�ǰActivity
			getActivity().finish();
			Intent intent = new Intent(getActivity(), MainActivity.class);
			startActivity(intent);
			break;
		}
	}
}
