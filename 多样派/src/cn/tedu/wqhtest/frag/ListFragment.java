package cn.tedu.wqhtest.frag;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import cn.tedu.wqhtest.ListSetActivity;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.adapter.MyListAdapter;
import cn.tedu.wqhtest.entity.User;

public class ListFragment extends Fragment implements View.OnClickListener {
	// �����б�
	private ListView lvContents;
	private MyListAdapter adapter;

	private Button btnListSet;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_list, null);

		// ��ʼ���ؼ�
		setViews(view);

		// ��̬����
		List<User> contacts = new ArrayList<User>();
		contacts.add(new User(R.drawable.bg_img_user_nor1, "������",
				"����ĵ�ʱ����֪ͨ��Ŷ.", "17:23", "1"));
		contacts.add(new User(R.drawable.bg_photo_user_nor2, "����質���",
				"���������ص�����������?", "����", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor3, "ϵͳ��Ϣ",
				"���Ļ�ѳɹ�����,��ȴ�������˵Ĳ���...", "���ڶ�", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor4, "pop",
				"����һ��Ҫ��Ʊ�볡Ŷ~", "���ڶ�", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor5, "������shuai��Ŷ",
				"����������Ҫ�Ǹ�ʲô����=.=", "������", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor6, "���ֹ�ͷ",
				"�������Ʊ�����˻ص���,�����������ʱ����...", "������", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor8, "���������",
				"�õ�,ллѽ2333", "2017/10/26", null));

		// ����Adapter����
		adapter = new MyListAdapter(getActivity(), contacts);

		// ΪListView����Adapter
		lvContents.setAdapter(adapter);

		// ��Ӽ���
		setListeners();

		return view;
	}

	private void setListeners() {
		btnListSet.setOnClickListener(this);
	}

	private void setViews(View view) {
		// �б�
		lvContents = (ListView) view.findViewById(R.id.lv_list_contents);

		btnListSet = (Button) view.findViewById(R.id.btn_list_set);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_list_set:
			Intent intent = new Intent(getActivity(), ListSetActivity.class);
			startActivity(intent);
			break;
		}
	}
}
