package cn.tedu.wqhtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import cn.tedu.wqhtest.frag.MyorderAllFragment;
import cn.tedu.wqhtest.frag.MyorderPaymentFragment;
import cn.tedu.wqhtest.frag.MyorderRefundFragment;
import cn.tedu.wqhtest.frag.MyorderUseFragment;

public class MyorderActivity extends FragmentActivity implements View.OnClickListener,
		OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

	// 声明控件
	private RadioGroup rgTabMenu;
	private ViewPager vpContainer;
	private FragmentPagerAdapter adapter;
	private ImageView ivMyorderBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myorder);

		// 初始化控件
		setViews();

		adapter = new InnerMyorderFragmentPagerAdapter(
				getSupportFragmentManager());
		vpContainer.setAdapter(adapter);
		vpContainer.setOnPageChangeListener(this);

		// 添加监听
		setListeners();
	}

	private void setListeners() {
		ivMyorderBack.setOnClickListener(this);
		rgTabMenu.setOnCheckedChangeListener(this);
	}

	private void setViews() {
		ivMyorderBack = (ImageView) findViewById(R.id.iv_myorder_back);
		rgTabMenu = (RadioGroup) findViewById(R.id.rg_myorder);
		vpContainer = (ViewPager) findViewById(R.id.vp_myorder_container);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_myorder_back:
			finish();
			break;
		}
	}

	private class InnerMyorderFragmentPagerAdapter extends FragmentPagerAdapter {

		public InnerMyorderFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new MyorderAllFragment();
				break;

			case 1:
				fragment = new MyorderPaymentFragment();
				break;

			case 2:
				fragment = new MyorderUseFragment();
				break;
				
			case 3:
				fragment = new MyorderRefundFragment();
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return 4;
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_myorder_all:
			vpContainer.setCurrentItem(0);
			break;

		case R.id.rb_myorder_payment:
			vpContainer.setCurrentItem(1);
			break;

		case R.id.rb_myorder_use:
			vpContainer.setCurrentItem(2);
			break;
			
		case R.id.rb_myorder_refund:
			vpContainer.setCurrentItem(3);
			break;
		}
	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			rgTabMenu.check(R.id.rb_myorder_all);
			break;

		case 1:
			rgTabMenu.check(R.id.rb_myorder_payment);
			break;

		case 2:
			rgTabMenu.check(R.id.rb_myorder_use);
			break;

		case 3:
			rgTabMenu.check(R.id.rb_myorder_refund);
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
