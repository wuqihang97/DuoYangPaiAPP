package cn.tedu.wqhtest.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioGroup;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.frag.GuideCapsuleFragment;
import cn.tedu.wqhtest.frag.GuideLabelFragment;
import cn.tedu.wqhtest.frag.GuideRecommendFragment;

public class GuideActivity extends FragmentActivity implements
		OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

	// 声明控件
	private RadioGroup rgTabMenu;
	private ViewPager vpContainer;
	private FragmentPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		// 初始化控件
		setViews();
		
		adapter = new InnerGuideFragmentPagerAdapter(
				getSupportFragmentManager());
		vpContainer.setAdapter(adapter);
		vpContainer.setOnPageChangeListener(this);

		// 添加点击监听事件
		rgTabMenu.setOnCheckedChangeListener(this);
	}

	private void setViews() {
		rgTabMenu = (RadioGroup) findViewById(R.id.rg_guide_menu);
		vpContainer = (ViewPager) findViewById(R.id.vp_guide_container);
	}

	private class InnerGuideFragmentPagerAdapter extends FragmentPagerAdapter {

		public InnerGuideFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new GuideRecommendFragment();
				break;

			case 1:
				fragment = new GuideCapsuleFragment();
				break;

			case 2:
				fragment = new GuideLabelFragment();
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return 3;
		}

	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			rgTabMenu.check(R.id.rb_guide_recommend);
			break;

		case 1:
			rgTabMenu.check(R.id.rb_guide_capsule);
			break;

		case 2:
			rgTabMenu.check(R.id.rb_guide_label);
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_guide_recommend:
			vpContainer.setCurrentItem(0);
			break;

		case R.id.rb_guide_capsule:
			vpContainer.setCurrentItem(1);
			break;

		case R.id.rb_guide_label:
			vpContainer.setCurrentItem(2);
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
