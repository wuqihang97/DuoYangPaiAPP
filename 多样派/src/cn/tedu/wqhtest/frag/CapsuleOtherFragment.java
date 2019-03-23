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
import cn.tedu.wqhtest.adapter.CapsuleAdapter;
import cn.tedu.wqhtest.entity.Capsule;

public class CapsuleOtherFragment extends Fragment implements
		AdapterView.OnItemClickListener {

	// �����б�
	private ListView lvContents;
	private CapsuleAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_capsule_other, null);
		// �б�
		lvContents = (ListView) view.findViewById(R.id.lv_capsule_other_contents);

		List<Capsule> contacts = new ArrayList<Capsule>();
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor4, "#�ֲ�#",
				"���Ե����ĽŲ���", "��ѧ�Ҷ��޷����͵�ë���Ȼ..."));
		// ����Adapter����
		adapter = new CapsuleAdapter(getActivity(), contacts);

		// ΪListView����Adapter
		lvContents.setAdapter(adapter);

		lvContents.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}
}
