package cn.tedu.wqhtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListSetActivity extends Activity implements View.OnClickListener{

	// �����ؼ�
	private ImageView ivListSetBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_set);
		// ��ʼ���ؼ�
		setViews();
		// ��Ӽ���
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
