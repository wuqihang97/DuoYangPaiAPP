package cn.tedu.wqhtest.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.tedu.wqhtest.R;

public class SplashActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		String count = Config.getCachedCount(this);

		/**
		 * 如果用户不是第一次使用则直接调转到显示界面,否则调转到引导界面
		 */
		if (count == null) {
			Intent intent1 = new Intent(SplashActivity.this, GuideActivity.class);
			startActivity(intent1);
		} else {
			Intent intent2 = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent2);
		}
		finish();

		Config.cacheCount(this, Config.KEY_COUNT);
	}
}