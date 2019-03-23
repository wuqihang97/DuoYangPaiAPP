package cn.tedu.wqhtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import cn.tedu.wqhtest.Util.Utility;
import cn.tedu.wqhtest.adapter.CharacterAdapter;

public class CharacterActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener{
	// 声明控件
	private ImageView ivCharacterBack;
	private ImageView ivCharacterAlbum;
	private ImageView ivCharacterAvater;
	private Button btnCharacterSecret;
	private CheckBox cbCharacterConcern;
	// 声明列表
	private ListView lvContents;
	private CharacterAdapter characteradapter;
	
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	int concern;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character);
		// 初始化控件
		setViews();
		
		List<Integer> contacts = new ArrayList<Integer>();
		contacts.add(R.drawable.home_img_content_nor1);
		contacts.add(R.drawable.home_img_content_nor4);
		
		// 创建Adapter对象
		characteradapter = new CharacterAdapter(this, contacts);
		
		sp = getSharedPreferences("concern", MODE_PRIVATE); // 存在则打开它，否则创建新的Preferences
		concern = sp.getInt("concern", 1); // 取出数据

		// 为ListView配置Adapter
		lvContents.setAdapter(characteradapter);
		Utility.setListViewHeightBasedOnChildren(lvContents);
		//设置没有焦点
		lvContents.setFocusable(false);
		// 添加监听
		setListeners();
		
	}
	
	private void setListeners() {
		ivCharacterBack.setOnClickListener(this);
		ivCharacterAlbum.setOnClickListener(this);
		ivCharacterAvater.setOnClickListener(this);
		btnCharacterSecret.setOnClickListener(this);
		cbCharacterConcern.setOnClickListener(this);
		lvContents.setOnItemClickListener(this);
	}

	private void setViews() {
		ivCharacterBack = (ImageView) findViewById(R.id.iv_character_back);
		ivCharacterAlbum = (ImageView) findViewById(R.id.iv_character_album);
		ivCharacterAvater = (ImageView) findViewById(R.id.iv_character_avater);
		btnCharacterSecret = (Button) findViewById(R.id.btn_character_secret);
		cbCharacterConcern = (CheckBox) findViewById(R.id.cb_character_concern);
		lvContents = (ListView) findViewById(R.id.lv_character_content);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_character_back:
			finish();
			break;
		case R.id.iv_character_album:
			//TODO
			break;
		case R.id.iv_character_avater:
			//TODO
			break;
		case R.id.btn_character_secret:
			//TODO
			break;
		case R.id.cb_character_concern:
			if(concern==1){
				cbCharacterConcern.setText("已关注");
			}else{
				cbCharacterConcern.setText("+关注");
			}
			editor = sp.edit();
			concern = (concern+1)%2;
			// 存入数据
			editor.putInt("concern", concern);
			// 提交修改
			editor.commit();
			break;
		}
	}
}
