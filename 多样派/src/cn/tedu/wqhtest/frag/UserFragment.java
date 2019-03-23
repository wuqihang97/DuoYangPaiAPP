package cn.tedu.wqhtest.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import cn.tedu.wqhtest.MyorderActivity;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.ui.Config;

public class UserFragment extends Fragment implements View.OnClickListener {
	private TextView tvUserPersonality1;
	private TextView tvUserPersonality2;
	private TextView tvUserPersonality3;
	private TextView tvUserPersonality4;
	private Button btnUserMyorder;
	private Button btnUserWallet;
	private Button btnUserTicket;
	private Button btnUserBills;
	private Button btnUserSign;
	private Button btnUserTheme;
	private Button btnUserInvite;
	private Button btnUserService;
	private Button btnUserMore;
	private Button btnUserDrop;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_user, null);

		// 初始化控件
		setViews(view);

		// 气泡浮动
		Animation translateAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.user_translate);
		tvUserPersonality1.startAnimation(translateAnim);
		Animation translateAnim2 = AnimationUtils.loadAnimation(getActivity(),
				R.anim.user_translate2);
		tvUserPersonality2.startAnimation(translateAnim2);
		Animation translateAnim3 = AnimationUtils.loadAnimation(getActivity(),
				R.anim.user_translate3);
		tvUserPersonality3.startAnimation(translateAnim3);
		Animation translateAnim4 = AnimationUtils.loadAnimation(getActivity(),
				R.anim.user_translate4);
		tvUserPersonality4.startAnimation(translateAnim4);

		// 添加监听
		setListeners();

		return view;
	}

	private void setListeners() {
		btnUserMyorder.setOnClickListener(this);
		btnUserWallet.setOnClickListener(this);
		btnUserTicket.setOnClickListener(this);
		btnUserBills.setOnClickListener(this);
		btnUserSign.setOnClickListener(this);
		btnUserTheme.setOnClickListener(this);
		btnUserInvite.setOnClickListener(this);
		btnUserService.setOnClickListener(this);
		btnUserMore.setOnClickListener(this);
		btnUserDrop.setOnClickListener(this);
	}

	private void setViews(View view) {
		tvUserPersonality1 = (TextView) view
				.findViewById(R.id.tv_user_personality1);
		tvUserPersonality2 = (TextView) view
				.findViewById(R.id.tv_user_personality2);
		tvUserPersonality3 = (TextView) view
				.findViewById(R.id.tv_user_personality3);
		tvUserPersonality4 = (TextView) view
				.findViewById(R.id.tv_user_personality4);
		btnUserMyorder = (Button) view.findViewById(R.id.btn_user_myorder);
		btnUserWallet = (Button) view.findViewById(R.id.btn_user_wallet);
		btnUserTicket = (Button) view.findViewById(R.id.btn_user_ticket);
		btnUserBills = (Button) view.findViewById(R.id.btn_user_bills);
		btnUserSign = (Button) view.findViewById(R.id.btn_user_sign);
		btnUserTheme = (Button) view.findViewById(R.id.btn_user_theme);
		btnUserInvite = (Button) view.findViewById(R.id.btn_user_invite);
		btnUserService = (Button) view.findViewById(R.id.btn_user_service);
		btnUserMore = (Button) view.findViewById(R.id.btn_user_more);
		btnUserDrop = (Button) view.findViewById(R.id.btn_user_drop);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_user_myorder:
			Intent intent = new Intent(getActivity(), MyorderActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_user_wallet:
			// TODO
			break;
		case R.id.btn_user_ticket:
			// TODO
			break;
		case R.id.btn_user_bills:
			// TODO
			break;
		case R.id.btn_user_sign:
			// TODO
			break;
		case R.id.btn_user_theme:
			// TODO
			break;
		case R.id.btn_user_invite:
			// TODO
			break;
		case R.id.btn_user_service:
			// TODO
			break;
		case R.id.btn_user_more:
			// TODO
			break;
		case R.id.btn_user_drop:
			Config.cacheToken(getActivity(), null);
			break;
		}
	}

}
