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

public class CapsulePopularFragment extends Fragment implements
		AdapterView.OnItemClickListener {

	// �����б�
	private ListView lvContents;
	private CapsuleAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_capsule_popular, null);
		// �б�
		lvContents = (ListView) view
				.findViewById(R.id.lv_capsule_popular_contents);

		List<Capsule> contacts = new ArrayList<Capsule>();
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor1, "#��Ȼ#",
				"����,д����˼", "�������,��Զ���Ҵҵ���,��Զ���Ҵҵ�ȥ..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor2, "#���#",
				"ֱ������Ĺ���", "˵�����Ķ��ǹ���,�������Ĳ�������..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor3, "#��Ȼ#",
				"ɭ���е��ݳ���", "ϡ���������·��������µ�ɭ����..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor4, "#�ֲ�#",
				"���Ե����ĽŲ���", "��ѧ�Ҷ��޷����͵�ë���Ȼ..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor5, "#��Ȼ#",
				"�����Ĵ��Ž�ʯ", "�����۾�,���϶���,���ܺ��˵�����..."));

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
