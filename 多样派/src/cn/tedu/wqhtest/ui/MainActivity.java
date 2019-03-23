package cn.tedu.wqhtest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.frag.CapsuleFragment;
import cn.tedu.wqhtest.frag.DynamicFragment;
import cn.tedu.wqhtest.frag.HomeFragment;
import cn.tedu.wqhtest.frag.ListFragment;
import cn.tedu.wqhtest.frag.UserFragment;
import cn.tedu.wqhtest.login.LoginActivity;

public class MainActivity extends FragmentActivity implements
		OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
	// �����ؼ�
	private RadioGroup rgTabMenu;
	private MyViewPager vpContainer;
	private FragmentPagerAdapter adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		// ��ʼ���ؼ�
		setViews();

		adapter = new InnerFragmentPagerAdapter(getSupportFragmentManager());
		vpContainer.setAdapter(adapter);
		vpContainer.setOnPageChangeListener(this);

		// ��ӵ�������¼�
		rgTabMenu.setOnCheckedChangeListener(this);
	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			rgTabMenu.check(R.id.rb_tab_item_home);
			break;

		case 1:
			rgTabMenu.check(R.id.rb_tab_item_capsule);
			break;

		case 2:
			rgTabMenu.check(R.id.rb_tab_item_dynamic);
			break;

		case 3:
			rgTabMenu.check(R.id.rb_tab_item_list);
			break;

		case 4:
			rgTabMenu.check(R.id.rb_tab_item_user);
			break;
		}
	}

	private void setViews() {
		rgTabMenu = (RadioGroup) findViewById(R.id.rg_bottom_menu);
		vpContainer = (MyViewPager) findViewById(R.id.vp_container);
	}

	private long lastBackDownTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// ����
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (System.currentTimeMillis() - lastBackDownTime < 2000) {
				// 2�ΰ��µ�ʱ����1�룬�������������£����˳�
				return super.onKeyDown(keyCode, event);
			} else {
				// 2�ΰ��µ�ʱ����̫�����������������£����¼�˴ΰ��µ�ʱ��
				lastBackDownTime = System.currentTimeMillis();
				// ����Toast
				Toast.makeText(this, "�ٰ�һ�η��ؼ��˳�", Toast.LENGTH_SHORT).show();
				// ����
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	private class InnerFragmentPagerAdapter extends FragmentPagerAdapter {

		public InnerFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new HomeFragment();
				break;

			case 1:
				fragment = new CapsuleFragment();
				break;

			case 2:
				fragment = new DynamicFragment();
				break;

			case 3:
				fragment = new ListFragment();
				break;
				
			case 4:
				fragment = new UserFragment();
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return 5;
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		String token = Config.getCachedToken(MainActivity.this);
		
		switch (checkedId) {
		case R.id.rb_tab_item_home:
			vpContainer.setCurrentItem(0);
			break;

		case R.id.rb_tab_item_capsule:
			vpContainer.setCurrentItem(1);
			break;

		case R.id.rb_tab_item_dynamic:
			vpContainer.setCurrentItem(2);
			break;
		case R.id.rb_tab_item_list:
			if (token != null) {
				vpContainer.setCurrentItem(3);
			} else {
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
			}
			break;
		case R.id.rb_tab_item_user:
			if (token != null) {
				vpContainer.setCurrentItem(4);
			} else {
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
			}
			break;
		}
	}
	

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
