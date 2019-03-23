package cn.tedu.wqhtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderActivity extends Activity implements View.OnClickListener{
	private ImageView ivOrederBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);

		// 初始化控件
		setViews();

		// 添加监听
		setListeners();
	}

	private void setListeners() {
		ivOrederBack.setOnClickListener(this);
	}

	private void setViews() {
		ivOrederBack = (ImageView) findViewById(R.id.iv_order_back);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_order_back:
			finish();
			break;

		}
	}
}
