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

public class GuideRecommendFragment extends Fragment {

	private ImageView ivGuideRecommend;
	private ImageView ivGuideRecommend2;
	private ImageView ivGuideRecommend3;
	private ImageView ivGuideRecommend4;
	private ImageView ivGuideRecommend5;
	private ImageView ivGuideRecommend6;
	private ImageView ivGuideRecommend7;
	private ImageView ivGuideRecommend8;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_guide_recommend, null);

		// ³õÊ¼»¯¿Ø¼þ
		setViews(view);

		AnimationSet anim = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set);
		anim.setFillAfter(true);
		ivGuideRecommend.startAnimation(anim);

		AnimationSet anim2 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set2);
		anim2.setFillAfter(true);
		ivGuideRecommend2.startAnimation(anim2);

		AnimationSet anim3 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set3);
		anim3.setFillAfter(true);
		ivGuideRecommend3.startAnimation(anim3);

		AnimationSet anim4 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set4);
		anim4.setFillAfter(true);
		ivGuideRecommend4.startAnimation(anim4);

		AnimationSet anim5 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set5);
		anim5.setFillAfter(true);
		ivGuideRecommend5.startAnimation(anim5);

		AnimationSet anim6 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set6);
		anim6.setFillAfter(true);
		ivGuideRecommend6.startAnimation(anim6);

		AnimationSet anim7 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set7);
		anim7.setFillAfter(true);
		ivGuideRecommend7.startAnimation(anim7);

		AnimationSet anim8 = (AnimationSet) AnimationUtils.loadAnimation(
				getActivity(), R.anim.guide_recommend_set8);
		anim8.setFillAfter(true);
		ivGuideRecommend8.startAnimation(anim8);

		return view;
	}

	private void setViews(View view) {
		ivGuideRecommend = (ImageView) view
				.findViewById(R.id.iv_guide_recommend);
		ivGuideRecommend2 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend2);
		ivGuideRecommend3 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend3);
		ivGuideRecommend4 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend4);
		ivGuideRecommend5 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend5);
		ivGuideRecommend6 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend6);
		ivGuideRecommend7 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend7);
		ivGuideRecommend8 = (ImageView) view
				.findViewById(R.id.iv_guide_recommend8);

	}
}
