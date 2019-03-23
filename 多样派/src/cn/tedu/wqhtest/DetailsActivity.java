package cn.tedu.wqhtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class DetailsActivity extends Activity implements View.OnClickListener {
	private Button btnDetailsShare;
	private CheckBox cbDetailsAttention;
	private CheckBox cbDetailsConcern;
	private Button btnDetailsSecret;
	private Button btnDetailsJoin;
	private Button btnDetailsDiscount;
	private ImageView ivDetailsBack;
	private ImageView ivDetailsAvatar;

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	int concern;

	// private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		// ��ʼ���ؼ�
		setViews();

		sp = getSharedPreferences("concern", MODE_PRIVATE); // ��������������򴴽��µ�Preferences
		concern = sp.getInt("concern", 1); // ȡ������

		// ��ȡ��ʾ�ڼ���
		// position = getIntent().getIntExtra("position", 0);

		// ��Ӽ���
		setListeners();
	}

	private void setListeners() {
		cbDetailsAttention.setOnClickListener(this);
		cbDetailsConcern.setOnClickListener(this);
		btnDetailsShare.setOnClickListener(this);
		btnDetailsSecret.setOnClickListener(this);
		btnDetailsJoin.setOnClickListener(this);
		btnDetailsDiscount.setOnClickListener(this);
		ivDetailsBack.setOnClickListener(this);
		ivDetailsAvatar.setOnClickListener(this);
	}

	private void setViews() {
		btnDetailsShare = (Button) findViewById(R.id.btn_details_share);
		btnDetailsSecret = (Button) findViewById(R.id.btn_details_secret);
		cbDetailsConcern = (CheckBox) findViewById(R.id.cb_details_concern);
		cbDetailsAttention = (CheckBox) findViewById(R.id.cb_details_attention);
		btnDetailsJoin = (Button) findViewById(R.id.btn_details_join);
		btnDetailsDiscount = (Button) findViewById(R.id.btn_details_discount);
		ivDetailsBack = (ImageView) findViewById(R.id.iv_details_back);
		ivDetailsAvatar = (ImageView) findViewById(R.id.iv_details_avatar);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_details_back:
			finish();
			break;
		case R.id.btn_details_share:
			// TODO
			break;
		case R.id.cb_details_attention:
			// TODO
			break;
		case R.id.iv_details_avatar:
			Intent intent = new Intent(this, CharacterActivity.class);
			startActivity(intent);
			break;
		case R.id.cb_details_concern:
			if (concern == 1) {
				cbDetailsConcern.setText("�ѹ�ע");
			} else {
				cbDetailsConcern.setText("+��ע");
			}
			editor = sp.edit();
			concern = (concern + 1) % 2;
			// ��������
			editor.putInt("concern", concern);
			// �ύ�޸�
			editor.commit();
			break;
		case R.id.btn_details_join:
			Intent intent3 = new Intent(this, OrderActivity.class);
			startActivity(intent3);
			break;
		case R.id.btn_details_discount:
			Intent intent4 = new Intent(this, OrderActivity.class);
			startActivity(intent4);
			break;
		case R.id.btn_details_secret:
			Intent intent2 = new Intent(this, SecretActivity.class);
			startActivity(intent2);
			break;
		}
	}

}
