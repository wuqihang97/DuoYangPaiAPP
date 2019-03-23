

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
import cn.tedu.wqhtest.net.Forget;
import cn.tedu.wqhtest.net.GetCode;
import cn.tedu.wqhtest.tools.MD5Tool;
import cn.tedu.wqhtest.ui.Config;

public class ForgetActivity extends Activity implements View.OnClickListener {

	private Button btnForgetSubmit;
	private Button btnForgetCode;
	private ImageView btnForgetBack;
	private EditText etForgetPhone;
	private EditText etForgetCode;
	private EditText etForgetPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget);

		btnForgetSubmit = (Button) findViewById(R.id.btn_forget_submit);
		btnForgetCode = (Button) findViewById(R.id.btn_forget_code);
		btnForgetBack = (ImageView) findViewById(R.id.iv_forget_back);
		etForgetPhone = (EditText) findViewById(R.id.et_forget_phone);
		etForgetCode = (EditText) findViewById(R.id.et_forget_code);
		etForgetPassword = (EditText) findViewById(R.id.et_forget_password);

		btnForgetSubmit.setOnClickListener(this);
		btnForgetCode.setOnClickListener(this);
		btnForgetBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_forget_back:
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btn_forget_code:
			if (TextUtils.isEmpty(etForgetPhone.getText())) {
				Toast.makeText(ForgetActivity.this, "电话号码不能为空",
						Toast.LENGTH_SHORT).show();
				return;
			}

			if (etForgetPhone.length() != 11) {
				Toast.makeText(ForgetActivity.this, "电话号码位数不正确(只能为中国内地手机号)",
						Toast.LENGTH_SHORT).show();
				return;
			}

			new GetCode(MD5Tool.md5(etForgetPhone.getText().toString()),
					new GetCode.SuccessCallback() {

						@Override
						public void onSuccess(int status) {
							switch (status) {
							case Config.RESULT_STATUS_USER_EXIST:
								btnForgetCode.setEnabled(false);
								setText();
								Toast.makeText(ForgetActivity.this,
										"短信验证码已发送请查看短信(该功能未实现,统一验证码为1111)",
										Toast.LENGTH_LONG).show();
								break;

							case Config.RESULT_STATUS_SUCCESS:
								Toast.makeText(ForgetActivity.this, "该手机号未注册",
										Toast.LENGTH_SHORT).show();
								break;
							}
						}
					}, new GetCode.FailCallback() {

						@Override
						public void onFail() {

							Toast.makeText(ForgetActivity.this,
									"获取验证码失败(服务器未启动)", Toast.LENGTH_SHORT)
									.show();
						}
					});
			break;
		case R.id.btn_forget_submit:
			if (TextUtils.isEmpty(etForgetPhone.getText())) {
				Toast.makeText(ForgetActivity.this, "电话号码不能为空",
						Toast.LENGTH_SHORT).show();
				return;
			}

			if (etForgetPhone.length() != 11) {
				Toast.makeText(ForgetActivity.this, "电话号码位数不正确(只能为中国内地手机号)",
						Toast.LENGTH_SHORT).show();
				return;
			}

			if (TextUtils.isEmpty(etForgetCode.getText())) {
				Toast.makeText(ForgetActivity.this, "验证码不能为空",
						Toast.LENGTH_SHORT).show();
				return;
			}

			if (TextUtils.isEmpty(etForgetPassword.getText())) {
				Toast.makeText(ForgetActivity.this, "密码不能为空",
						Toast.LENGTH_SHORT).show();
				return;
			}

			// 取消计时
			asyn.cancel(true);

			new Forget(MD5Tool.md5(etForgetPhone.getText().toString()),
					etForgetCode.getText().toString(), etForgetPassword
							.getText().toString(),
					new Forget.SuccessCallback() {

						@Override
						public void onSuccess(int status) {
							switch (status) {
							case Config.RESULT_STATUS_MODIFY_OK:
								// 返回登录界面
								Intent intent = new Intent();
								intent.putExtra(Config.KEY_PHONE_NUM,
										etForgetPhone.getText().toString());
								intent.putExtra(Config.KEY_PASSWORD,
										etForgetPassword.getText().toString());
								setResult(RESULT_OK, intent);

								Toast.makeText(ForgetActivity.this, "修改成功",
										Toast.LENGTH_SHORT).show();
								finish();

								break;

							case Config.RESULT_STATUS_CODE_ERROR:
								Toast.makeText(ForgetActivity.this, "验证码错误",
										Toast.LENGTH_SHORT).show();

								// 继续计时
								setText();
								break;
							}
						}
					}, new Forget.FailCallback() {

						@Override
						public void onFail() {
							Toast.makeText(ForgetActivity.this,
									"修改密码失败(服务器未启动)", Toast.LENGTH_SHORT)
									.show();
							// 继续计时
							setText();

						}
					});
			break;
		}
	}

	private AsyncTask<Void, String, Void> asyn;
	private int n = 0;

	private void setText() {
		asyn = new AsyncTask<Void, String, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				int i = 59;
				if (n != 0) {
					i = n;
				}
				for (; i > 0; i--) {
					if (isCancelled()) {
						n = i;
						break;
					}
					try {
						publishProgress("获取验证码" + i);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (i == 0) {
					n = 0;
				}
				return null;
			}

			@Override
			protected void onProgressUpdate(String... str) {
				if (isCancelled()) {
					return;
				}
				super.onProgressUpdate(str);
				btnForgetCode.setText(str[0]);
			};

			@Override
			protected void onPostExecute(Void result) {
				btnForgetCode.setText("获取验证码");
				btnForgetCode.setEnabled(true);
			}

		}.execute();
	}

}
