package cn.tedu.wqhtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListSetActivity extends Activity implements View.OnClickListener{

	// 声明控件
	private ImageView ivListSetBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_set);
		// 初始化控件
		setViews();
		// 添加监听
		setListeners();
	}

	private void setListeners() {
		ivListSetBack.setOnClickListener(this);
	}

	private void setViews() {
		ivListSetBack = (ImageView) findViewById(R.id.iv_list_set_back);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_list_set_back:
			finish();
			break;
		}
	}
}
