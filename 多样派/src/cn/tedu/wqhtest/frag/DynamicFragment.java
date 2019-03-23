package cn.tedu.wqhtest.frag;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.ReleaseActivity;

public class DynamicFragment extends Fragment implements OnPageChangeListener,
		OnClickListener, RadioGroup.OnCheckedChangeListener {
	// 声明控件
	private RadioGroup rgDynamic;
	private ImageView ivDynamicExpand;

	private PopupWindow mPopWindow = null;
	private View mPopWindowView;

	private ViewPager vpContainer;
	private FragmentPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_dynamic, null);
		// 初始化控件
		setViews(view);

		adapter = new InnerFragmentPagerAdapter(getChildFragmentManager());
		vpContainer.setAdapter(adapter);

		// 添加点击监听事件
		ivDynamicExpand.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showPopupWindow();
			}
		});
		rgDynamic.setOnCheckedChangeListener(this);
		vpContainer.setOnPageChangeListener(this);
		return view;
	}

	protected void showPopupWindow() {
		if (mPopWindow == null) {
			// 不重复创建,减小内存消耗
			mPopWindow = new PopupWindow(mPopWindowView);
			// 获取显示的对象
			View contentView = LayoutInflater.from(getActivity()).inflate(
					R.layout.popup, null);
			TextView tv1 = (TextView) contentView
					.findViewById(R.id.pop_relative);
			TextView tv2 = (TextView) contentView
					.findViewById(R.id.pop_attention);
			tv1.setOnClickListener(this);
			tv2.setOnClickListener(this);

			mPopWindow.setContentView(contentView);
			// 显示的宽高
			mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
			mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
			// 设置显示背景
			mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
			// 设置返回键也能取消弹框
			mPopWindow.setFocusable(true);
			// 点击弹框外部隐藏此弹窗
			mPopWindow.setOutsideTouchable(true);
			// 隐藏时将背景透明度调回
			mPopWindow.setOnDismissListener(new OnDismissListener() {
				@Override
				public void onDismiss() {
					setBackgroundAlpha(1.0f);
				}
			});
		}
		// 设置背景透明度
		setBackgroundAlpha(0.5f);
		// 显示View的正下方
		mPopWindow.showAsDropDown(ivDynamicExpand);
	}

	private void setViews(View view) {
		rgDynamic = (RadioGroup) view.findViewById(R.id.rg_dynamic);
		ivDynamicExpand = (ImageView) view.findViewById(R.id.iv_dynamic_expand);
		vpContainer = (ViewPager) view.findViewById(R.id.vp_dynamic_container);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pop_relative:
			Intent intent = new Intent(getActivity(), ReleaseActivity.class);
			startActivity(intent);
			break;
		case R.id.pop_attention:
			Toast.makeText(getActivity(), "暂未开放", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	// 设置背景透明度
	private void setBackgroundAlpha(float f) {
		WindowManager.LayoutParams lp = getActivity().getWindow()
				.getAttributes();
		lp.alpha = f;
		getActivity().getWindow().setAttributes(lp);
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
				fragment = new DynamicAttentionFragment();
				break;
			case 1:
				fragment = new DynamicNearFragment();
				break;

			}
			return fragment;
		}

		@Override
		public int getCount() {
			return 2;
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_dynamic_attention:
			vpContainer.setCurrentItem(0);
			break;

		case R.id.rb_dynamic_near:
			vpContainer.setCurrentItem(1);
			break;

		}
	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			rgDynamic.check(R.id.rb_dynamic_attention);
			break;

		case 1:
			rgDynamic.check(R.id.rb_dynamic_near);
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
