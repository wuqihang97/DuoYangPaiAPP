package cn.tedu.wqhtest.frag;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import cn.tedu.wqhtest.DetailsActivity;
import cn.tedu.wqhtest.NewsActivity;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.Util.Utility;
import cn.tedu.wqhtest.adapter.HomeAdapter;
import cn.tedu.wqhtest.sort.ArtActivity;
import cn.tedu.wqhtest.sort.EducationActivity;
import cn.tedu.wqhtest.sort.ExerciseActivity;
import cn.tedu.wqhtest.sort.PlayActivity;
import cn.tedu.wqhtest.sort.SocietyActivity;

public class HomeFragment extends Fragment implements View.OnClickListener,
		AdapterView.OnItemClickListener {

	// 声明控件
	private Button btnHomeItemPlay;
	private Button btnHomeItemArt;
	private Button btnHomeItemEducation;
	private Button btnHomeItemSociety;
	private Button btnHomeItemExercise;
	private Button btnHomeToolLocation;
	private ImageView ivHomeToolSearch;
	private Button btnHomeToolCode;
	private ImageView ivHomeRotate;
	private ImageView ivHomeBanners;
	private EditText etHomeToolSearch;
	// 声明列表
	private ListView lvContents;
	private HomeAdapter adapter;
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_home, null);
		// 初始化控件
		setViews(view);
		// 静态数据
		List<Integer> contacts = new ArrayList<Integer>();
		contacts.add(R.drawable.home_img_content_nor1);
		contacts.add(R.drawable.home_img_content_nor2);
		contacts.add(R.drawable.home_img_content_nor3);
		contacts.add(R.drawable.home_img_content_nor4);
		contacts.add(R.drawable.home_img_content_nor5);
		contacts.add(R.drawable.home_img_content_nor6);

		// 创建Adapter对象
		adapter = new HomeAdapter(getActivity(), contacts);

		// 为ListView配置Adapter
		lvContents.setAdapter(adapter);
		
		// 嵌套滑动
		Utility.setListViewHeightBasedOnChildren(lvContents);
		
		// 补间动画
		Animation setAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.home_rotate);
		ivHomeRotate.startAnimation(setAnim);

		// 添加监听
		setListeners();
		
		return view;
	}

	private void setListeners() {
		btnHomeItemPlay.setOnClickListener(this);
		btnHomeItemArt.setOnClickListener(this);
		btnHomeItemEducation.setOnClickListener(this);
		btnHomeItemSociety.setOnClickListener(this);
		btnHomeItemExercise.setOnClickListener(this);
		btnHomeToolLocation.setOnClickListener(this);
		ivHomeToolSearch.setOnClickListener(this);
		btnHomeToolCode.setOnClickListener(this);
		etHomeToolSearch.setOnClickListener(this);
		ivHomeRotate.setOnClickListener(this);
		ivHomeBanners.setOnClickListener(this);
		lvContents.setOnItemClickListener(this);
	}

	private void setViews(View view) {
		// home菜单
		btnHomeItemPlay = (Button) view.findViewById(R.id.btn_home_item_play);
		btnHomeItemArt = (Button) view.findViewById(R.id.btn_home_item_art);
		btnHomeItemEducation = (Button) view
				.findViewById(R.id.btn_home_item_education);
		btnHomeItemSociety = (Button) view
				.findViewById(R.id.btn_home_item_society);
		btnHomeItemExercise = (Button) view
				.findViewById(R.id.btn_home_item_exercise);
		// 顶部
		btnHomeToolLocation = (Button) view
				.findViewById(R.id.btn_home_tool_location);
		ivHomeToolSearch = (ImageView) view
				.findViewById(R.id.iv_home_tool_search);
		btnHomeToolCode = (Button) view.findViewById(R.id.btn_home_tool_code);
		etHomeToolSearch = (EditText) view
				.findViewById(R.id.et_home_tool_search);
		// 列表
		lvContents = (ListView) view.findViewById(R.id.lv_home_contents);
		ivHomeRotate = (ImageView) view.findViewById(R.id.iv_home_rotate);
		ivHomeBanners = (ImageView) view.findViewById(R.id.iv_home_banners);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_home_rotate:
			Intent intent = new Intent(getActivity(), NewsActivity.class);
			startActivity(intent);
			break;
		case R.id.et_home_tool_search:
			// TODO
			break;
		case R.id.iv_home_banners:
			// TODO
			break;
		case R.id.btn_home_item_play:
			Intent intent2 = new Intent(getActivity(), PlayActivity.class);
			startActivity(intent2);
			break;
		case R.id.btn_home_item_art:
			Intent intent3 = new Intent(getActivity(), ArtActivity.class);
			startActivity(intent3);
			break;
		case R.id.btn_home_item_education:
			Intent intent4 = new Intent(getActivity(), EducationActivity.class);
			startActivity(intent4);
			break;
		case R.id.btn_home_item_society:
			Intent intent5 = new Intent(getActivity(), SocietyActivity.class);
			startActivity(intent5);
			break;
		case R.id.btn_home_item_exercise:
			Intent intent6 = new Intent(getActivity(), ExerciseActivity.class);
			startActivity(intent6);
			break;
		case R.id.btn_home_tool_location:
			Toast.makeText(getActivity(), "暂未开放",Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_home_tool_search:
			Toast.makeText(getActivity(), "暂未开放",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_home_tool_code:
			Toast.makeText(getActivity(), "暂未开放",Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getActivity(), DetailsActivity.class);
		intent.putExtra("position", position);
		startActivity(intent);
	}

}
