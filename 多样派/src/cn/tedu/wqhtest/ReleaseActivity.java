package cn.tedu.wqhtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReleaseActivity extends Activity implements View.OnClickListener{
	private Button btnReleaseBack;
	private Button btnReleaseSubmit;
	private Button btnReleasePhoto;
	private Button btnReleaseLeisure;
	private Button btnReleaseEducation;
	private Button btnReleaseWelfare;
	private Button btnReleaseTravel;
	private Button btnReleaseArt;
	private TextView tvReleaseLabel;
	private TextView tvReleaseLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_release);

		// 初始化控件
		setViews();

		// 添加监听
		setListeners();
	}

	private void setListeners() {
		btnReleaseBack.setOnClickListener(this);
		btnReleaseSubmit.setOnClickListener(this);
		btnReleasePhoto.setOnClickListener(this);
		btnReleaseLeisure.setOnClickListener(this);
		btnReleaseEducation.setOnClickListener(this);
		btnReleaseWelfare.setOnClickListener(this);
		btnReleaseTravel.setOnClickListener(this);
		btnReleaseArt.setOnClickListener(this);
		tvReleaseLabel.setOnClickListener(this);
		tvReleaseLocation.setOnClickListener(this);
	}

	private void setViews() {
		btnReleaseBack = (Button) findViewById(R.id.btn_release_back);
		btnReleaseSubmit = (Button) findViewById(R.id.btn_release_submit);
		btnReleasePhoto = (Button) findViewById(R.id.btn_release_photo);
		btnReleaseLeisure = (Button) findViewById(R.id.btn_release_leisure);
		btnReleaseEducation = (Button) findViewById(R.id.btn_release_education);
		btnReleaseWelfare = (Button) findViewById(R.id.btn_release_welfare);
		btnReleaseTravel = (Button) findViewById(R.id.btn_release_travel);
		btnReleaseArt = (Button) findViewById(R.id.btn_release_art);
		tvReleaseLabel = (TextView) findViewById(R.id.tv_release_label);
		tvReleaseLocation = (TextView) findViewById(R.id.tv_release_location);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_release_back:
			finish();
			break;
		case R.id.btn_release_submit:
			//TODO
			break;
		case R.id.btn_release_photo:
			//TODO
			break;
		case R.id.btn_release_leisure:
			//TODO
			break;
		case R.id.btn_release_education:
			//TODO
			break;
		case R.id.btn_release_welfare:
			//TODO
			break;
		case R.id.btn_release_travel:
			//TODO
			break;
		case R.id.btn_release_art:
			//TODO
			break;
		case R.id.tv_release_label:
			Intent intent = new Intent(this, LabelActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_release_location:
			//TODO
			break;
		}
	}
}
