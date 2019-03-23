package cn.tedu.wqhtest.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.net.Login;
import cn.tedu.wqhtest.tools.MD5Tool;
import cn.tedu.wqhtest.ui.Config;

public class LoginActivity extends Activity implements View.OnClickListener {

	private Button btnLoginForget;
	private Button btnLoginRegistered;
	private Button btnLoginSubmit;
	private ImageView ivWeiXin;
	private ImageView ivQQ;
	private ImageView ivWeiBo;
	private ImageView ivLoginBack;
	private EditText etLoginPhone;
	private EditText etLoginPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// ��ʼ���ؼ�
		setViews();

		// ��Ӽ���
		setListeners();

	}

	private void setListeners() {
		btnLoginForget.setOnClickListener(this);
		btnLoginRegistered.setOnClickListener(this);
		btnLoginSubmit.setOnClickListener(this);
		ivWeiXin.setOnClickListener(this);
		ivQQ.setOnClickListener(this);
		ivWeiBo.setOnClickListener(this);
		ivLoginBack.setOnClickListener(this);
	}

	private void setViews() {
		btnLoginForget = (Button) findViewById(R.id.btn_login_forget);
		btnLoginRegistered = (Button) findViewById(R.id.btn_login_registered);
		btnLoginSubmit = (Button) findViewById(R.id.btn_login_submit);
		ivWeiXin = (ImageView) findViewById(R.id.iv_login_weixin);
		ivQQ = (ImageView) findViewById(R.id.iv_login_qq);
		ivWeiBo = (ImageView) findViewById(R.id.iv_login_weibo);
		ivLoginBack = (ImageView) findViewById(R.id.iv_login_back);
		etLoginPhone = (EditText) findViewById(R.id.et_login_phone);
		etLoginPassword = (EditText) findViewById(R.id.et_login_password);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login_forget:
			Intent intent = new Intent(this, ForgetActivity.class);
			startActivityForResult(intent, 100);
			break;
		case R.id.btn_login_registered:
			Intent intent2 = new Intent(this, RegisteredActivity.class);
			startActivityForResult(intent2, 100);
			break;
		case R.id.btn_login_submit:
			// ����Ϊ��¼״̬
			Config.cacheToken(LoginActivity.this,
					Config.KEY_TOKEN);
			finish();
//			if (TextUtils.isEmpty(etLoginPhone.getText())) {
//				Toast.makeText(LoginActivity.this, "�绰���벻��Ϊ��",
//						Toast.LENGTH_SHORT).show();
//				return;
//			}
//
//			if (TextUtils.isEmpty(etLoginPassword.getText())) {
//				Toast.makeText(LoginActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT)
//						.show();
//				return;
//			}
//			new Login(MD5Tool.md5(etLoginPhone.getText().toString()),
//					etLoginPassword.getText().toString(),
//					new Login.SuccessCallback() {
//
//						@Override
//						public void onSuccess(int status) {
//
//							switch (status) {
//							case Config.RESULT_STATUS_LOGIN_OK:
//
//								Toast.makeText(LoginActivity.this, "��¼�ɹ�",
//										Toast.LENGTH_SHORT).show();
//								// ����Ϊ��¼״̬
//								Config.cacheToken(LoginActivity.this,
//										Config.KEY_TOKEN);
//
//								finish();
//								break;
//							case Config.RESULT_STATUS_LOGIN_FAIL:
//								Toast.makeText(LoginActivity.this, "�˻����������",
//										Toast.LENGTH_SHORT).show();
//								break;
//
//							}
//
//						}
//					}, new Login.FailCallback() {
//
//						@Override
//						public void onFail() {
//
//							Toast.makeText(LoginActivity.this, "��¼ʧ��(������δ����)",
//									Toast.LENGTH_SHORT).show();
//						}
//					});
			break;
		case R.id.iv_login_weixin:
			Toast.makeText(LoginActivity.this, "�ù���δ����", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.iv_login_qq:
			Toast.makeText(LoginActivity.this, "�ù���δ����", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.iv_login_weibo:
			Toast.makeText(LoginActivity.this, "�ù���δ����", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.iv_login_back:
			finish();
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 100) {
			if (resultCode == Activity.RESULT_OK) {
				etLoginPhone.setText(data.getStringExtra(Config.KEY_PHONE_NUM));
				etLoginPassword.setText(data
						.getStringExtra(Config.KEY_PASSWORD));
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
