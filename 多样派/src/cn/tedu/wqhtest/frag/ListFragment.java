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
	// 声明列表
	private ListView lvContents;
	private MyListAdapter adapter;

	private Button btnListSet;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_list, null);

		// 初始化控件
		setViews(view);

		// 静态数据
		List<User> contacts = new ArrayList<User>();
		contacts.add(new User(R.drawable.bg_img_user_nor1, "汪星银",
				"具体的到时候再通知你哦.", "17:23", "1"));
		contacts.add(new User(R.drawable.bg_photo_user_nor2, "青年歌唱大会",
				"请问这个活动地点是在哪里呢?", "昨天", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor3, "系统消息",
				"您的活动已成功发布,请等待更多的人的参与...", "星期二", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor4, "pop",
				"请你一定要带票入场哦~", "星期二", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor5, "超超超shuai的哦",
				"请问这个活动主要是干什么的呢=.=", "星期日", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor6, "音乐罐头",
				"请问这个票可以退回的吗,我这个星期临时有事...", "星期五", null));
		contacts.add(new User(R.drawable.bg_photo_user_nor8, "真真真的累",
				"好的,谢谢呀2333", "2017/10/26", null));

		// 创建Adapter对象
		adapter = new MyListAdapter(getActivity(), contacts);

		// 为ListView配置Adapter
		lvContents.setAdapter(adapter);

		// 添加监听
		setListeners();

		return view;
	}

	private void setListeners() {
		btnListSet.setOnClickListener(this);
	}

	private void setViews(View view) {
		// 列表
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
