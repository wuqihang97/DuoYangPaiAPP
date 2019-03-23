package cn.tedu.wqhtest.login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.net.GetCode;
import cn.tedu.wqhtest.net.Registered;
import cn.tedu.wqhtest.tools.MD5Tool;
import cn.tedu.wqhtest.ui.Config;

public class RegisteredActivity extends Activity implements
		View.OnClickListener {

	private Button btnRegisteredSubmit;
	private Button btnRegisteredCode;
	private ImageView btnRegisteredBack;
	private EditText etRegisteredPhone = null;
	private EditText etRegisteredCode = null;
	private EditText etRegisteredPassword = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registered);

		btnRegisteredSubmit = (Button) findViewById(R.id.btn_registered_submit);
		btnRegisteredCode = (Button) findViewById(R.id.btn_registered_code);
		btnRegisteredBack = (ImageView) findViewById(R.id.iv_registered_back);
		etRegisteredPhone = (EditText) findViewById(R.id.et_registered_phone);
		etRegisteredCode = (EditText) findViewById(R.id.et_registered_code);
		etRegisteredPassword = (EditText) findViewById(R.id.et_registered_password);

		btnRegisteredSubmit.setOnClickListener(this);
		btnRegisteredCode.setOnClickListener(this);
		btnRegisteredBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_registered_back:
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btn_registered_code:
			if (TextUtils.isEmpty(etRegisteredPhone.getText())) {
				Toast.makeText(RegisteredActivity.this, "�绰���벻��Ϊ��",
						Toast.LENGTH_SHORT).show();
				return;
			}

			if (etRegisteredPhone.length() != 11) {
				Toast.makeText(RegisteredActivity.this,
						"�绰����λ������ȷ(ֻ��Ϊ�й��ڵ��ֻ���)", Toast.LENGTH_SHORT).show();
				return;
			}

			new GetCode(MD5Tool.md5(etRegisteredPhone.getText().toString()),
					new GetCode.SuccessCallback() {

						@Override
						public void onSuccess(int status) {

							switch (status) {
							case Config.RESULT_STATUS_SUCCESS:
								btnRegisteredCode.setEnabled(false);
								setText();
								Toast.makeText(RegisteredActivity.this,
										"������֤���ѷ�����鿴����(�ù���δʵ��,ͳһ��֤��Ϊ1111)",
										Toast.LENGTH_LONG).show();
								break;

							case Config.RESULT_STATUS_USER_EXIST:
								Toast.makeText(RegisteredActivity.this,
										"���û��ѱ�ע��", Toast.LENGTH_SHORT).show();
								break;
							}

						}
					}, new GetCode.FailCallback() {

						@Override
						public void onFail() {

							Toast.makeText(RegisteredActivity.this,
									"��ȡ��֤��ʧ��(������δ����)", Toast.LENGTH_SHORT)
									.show();
						}

					});
			break;
		case R.id.btn_registered_submit:
			if (TextUtils.isEmpty(etRegisteredPhone.getText())) {
				Toast.makeText(RegisteredActivity.this, "�绰���벻��Ϊ��",
						Toast.LENGTH_SHORT).show();
				return;
			}
			
			if (etRegisteredPhone.length() != 11) {
				Toast.makeText(RegisteredActivity.this,
						"�绰����λ������ȷ(ֻ��Ϊ�й��ڵ��ֻ���)", Toast.LENGTH_SHORT).show();
				return;
			}

			if (TextUtils.isEmpty(etRegisteredCode.getText())) {
				Toast.makeText(RegisteredActivity.this, "��֤�벻��Ϊ��",
						Toast.LENGTH_SHORT).show();
				return;
			}

			if (TextUtils.isEmpty(etRegisteredPassword.getText())) {
				Toast.makeText(RegisteredActivity.this, "���벻��Ϊ��",
						Toast.LENGTH_SHORT).show();
				return;
			}
			//ȡ����ʱ
			asyn.cancel(true);
			new Registered(MD5Tool.md5(etRegisteredPhone.getText().toString()),
					etRegisteredCode.getText().toString(), etRegisteredPassword
							.getText().toString(),
					new Registered.SuccessCallback() {

						@Override
						public void onSuccess(int status) {
							switch (status) {
							case Config.RESULT_STATUS_REGISTERED_OK:
								Intent intent = new Intent();
								intent.putExtra(Config.KEY_PHONE_NUM,
										etRegisteredPhone.getText().toString());
								intent.putExtra(Config.KEY_PASSWORD,
										etRegisteredPassword.getText()
												.toString());
								setResult(RESULT_OK, intent);

								Toast.makeText(RegisteredActivity.this, "ע��ɹ�",
										Toast.LENGTH_SHORT).show();
								
								finish();
								break;

							case Config.RESULT_STATUS_CODE_ERROR:
								Toast.makeText(RegisteredActivity.this,
										"��֤�����", Toast.LENGTH_SHORT).show();
								
								//������ʱ
								setText();
								break;
							}
						}
					}, new Registered.FailCallback() {

						@Override
						public void onFail() {
							Toast.makeText(RegisteredActivity.this,
									"ע��ʧ��(������δ����)", Toast.LENGTH_SHORT).show();
							//������ʱ
							setText();
						}
					});
			break;
		}
	}
	
	private AsyncTask<Void, String, Void> asyn;
	private int n=0;
	private void setText() {
		asyn = new AsyncTask<Void, String, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				int i = 59;
				if(n!=0){
					i = n;
				}
				for (; i > 0; i--) {
					if(isCancelled()){
						n=i;
		                break;
		            }
					try {
						publishProgress("��ȡ��֤��" + i);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(i==0){
					n=0;
				}
				return null;
			}

			@Override
			protected void onProgressUpdate(String... str) {
				if(isCancelled()){
			            return;
			       }
				super.onProgressUpdate(str);
				btnRegisteredCode.setText(str[0]);
			};

			@Override
			protected void onPostExecute(Void result) {
				btnRegisteredCode.setText("��ȡ��֤��");
				btnRegisteredCode.setEnabled(true);
			}

		}.execute();
	}
}
