package cn.tedu.wqhtest.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

public class GuideCapsuleFragment extends Fragment {

	private ImageView ivGuideCapsule;
	private ImageView ivGuideCapsule2;
	private ImageView ivGuideCapsule3;
	private ImageView ivGuideCapsule4;
	private ImageView ivGuideCapsule5;
	private ImageView ivGuideCapsule6;
	private ImageView ivGuideCapsule7;
	private ImageView ivGuideCapsule8;
	private ImageView ivGuideCapsule9;
	private ImageView ivGuideCapsule10;
	private ImageView ivGuideCapsule11;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_guide_capsule, null);

		// 初始化控件
		setViews(view);

		return view;
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		if (getUserVisibleHint()) {
			// 用户可见状态下,实现延迟加载
			lazyload();

		} else {
		}
	}

	private void setViews(View view) {
		ivGuideCapsule = (ImageView) view.findViewById(R.id.iv_guide_capsule);
		ivGuideCapsule2 = (ImageView) view.findViewById(R.id.iv_guide_capsule2);
		ivGuideCapsule3 = (ImageView) view.findViewById(R.id.iv_guide_capsule3);
		ivGuideCapsule4 = (ImageView) view.findViewById(R.id.iv_guide_capsule4);
		ivGuideCapsule5 = (ImageView) view.findViewById(R.id.iv_guide_capsule5);
		ivGuideCapsule6 = (ImageView) view.findViewById(R.id.iv_guide_capsule6);
		ivGuideCapsule7 = (ImageView) view.findViewById(R.id.iv_guide_capsule7);
		ivGuideCapsule8 = (ImageView) view.findViewById(R.id.iv_guide_capsule8);
		ivGuideCapsule9 = (ImageView) view.findViewById(R.id.iv_guide_capsule9);
		ivGuideCapsule10 = (ImageView) view
				.findViewById(R.id.iv_guide_capsule10);
		ivGuideCapsule11 = (ImageView) view
				.findViewById(R.id.iv_guide_capsule11);

	}

	private void lazyload() {
		AnimationSet anim = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set);
		anim.setFillAfter(true);
		ivGuideCapsule.startAnimation(anim);

		AnimationSet anim2 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set2);
		anim2.setFillAfter(true);
		ivGuideCapsule2.startAnimation(anim2);

		AnimationSet anim3 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set3);
		anim3.setFillAfter(true);
		ivGuideCapsule3.startAnimation(anim3);

		AnimationSet anim4 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set4);
		anim4.setFillAfter(true);
		ivGuideCapsule4.startAnimation(anim4);

		AnimationSet anim5 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set5);
		anim5.setFillAfter(true);
		ivGuideCapsule5.startAnimation(anim5);

		AnimationSet anim6 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set6);
		anim6.setFillAfter(true);
		ivGuideCapsule6.startAnimation(anim6);

		AnimationSet anim7 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set7);
		anim7.setFillAfter(true);
		ivGuideCapsule7.startAnimation(anim7);

		AnimationSet anim8 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set8);
		anim8.setFillAfter(true);
		ivGuideCapsule8.startAnimation(anim8);

		AnimationSet anim9 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set9);
		anim9.setFillAfter(true);
		ivGuideCapsule9.startAnimation(anim9);

		AnimationSet anim10 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set10);
		anim10.setFillAfter(true);
		ivGuideCapsule10.startAnimation(anim10);

		AnimationSet anim11 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_capsule_set11);
		anim11.setFillAfter(true);
		ivGuideCapsule11.startAnimation(anim11);

	}
}
