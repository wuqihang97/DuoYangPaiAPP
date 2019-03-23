package cn.tedu.wqhtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class NewsActivity extends Activity implements View.OnClickListener{
	
	private Button btnNewsBack;
	private Button btnNewsSubmit;
	private Button btnNewsPhoto;
	private LinearLayout llNewsLabel;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		// 初始化控件
		setViews();

		// 添加监听
		setListeners();
	}

	private void setListeners() {
		btnNewsBack.setOnClickListener(this);
		llNewsLabel.setOnClickListener(this);
	}

	private void setViews() {
		btnNewsBack = (Button) findViewById(R.id.btn_news_back);
		btnNewsSubmit = (Button) findViewById(R.id.btn_news_submit);
		btnNewsPhoto = (Button) findViewById(R.id.btn_news_photo);
		llNewsLabel = (LinearLayout) findViewById(R.id.ll_news_label);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_news_back:
			finish();
			break;
		case R.id.btn_news_photo:
			//TODO
			break;
		case R.id.btn_news_submit:
			//TODO
			break;
		case R.id.ll_news_label:
			Intent intent = new Intent(this, LabelActivity.class);
			startActivity(intent);
			break;
		}
	}
}
