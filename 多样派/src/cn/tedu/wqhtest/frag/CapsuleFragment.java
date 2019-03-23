package cn.tedu.wqhtest.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import cn.tedu.wqhtest.R;

public class CapsuleFragment extends Fragment implements OnPageChangeListener,
		OnClickListener, RadioGroup.OnCheckedChangeListener {

	private RadioGroup rgCapsule;
	private ViewPager vpContainer;
	private FragmentPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_capsule, null);
		// 初始化控件
		setViews(view);

		adapter = new InnerFragmentPagerAdapter(getChildFragmentManager());
		vpContainer.setAdapter(adapter);

		// 添加监听
		setListeners();

		return view;
	}

	private void setListeners() {
		rgCapsule.setOnCheckedChangeListener(this);
		vpContainer.setOnPageChangeListener(this);
	}

	private void setViews(View view) {

		rgCapsule = (RadioGroup) view.findViewById(R.id.rg_capsule);
		vpContainer = (ViewPager) view.findViewById(R.id.vp_capsule_container);
	}

	@Override
	public void onClick(View v) {
		
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
				fragment = new CapsulePopularFragment();
				break;
			case 1:
				fragment = new CapsuleNaturalFragment();
				break;

			case 2:
				fragment = new CapsuleCureFragment();
				break;

			case 3:
				fragment = new CapsuleEmotionFragment();
				break;

			case 4:
				fragment = new CapsuleOtherFragment();
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
		switch (checkedId) {
		case R.id.rb_capsule_popular:
			vpContainer.setCurrentItem(0);
			break;

		case R.id.rb_capsule_natural:
			vpContainer.setCurrentItem(1);
			break;

		case R.id.rb_capsule_cure:
			vpContainer.setCurrentItem(2);
			break;

		case R.id.rb_capsule_emotion:
			vpContainer.setCurrentItem(3);
			break;

		case R.id.rb_capsule_other:
			vpContainer.setCurrentItem(4);
			break;

		}
	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			rgCapsule.check(R.id.rb_capsule_popular);
			break;

		case 1:
			rgCapsule.check(R.id.rb_capsule_natural);
			break;

		case 2:
			rgCapsule.check(R.id.rb_capsule_cure);
			break;

		case 3:
			rgCapsule.check(R.id.rb_capsule_emotion);
			break;

		case 4:
			rgCapsule.check(R.id.rb_capsule_other);
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {

	}

}
