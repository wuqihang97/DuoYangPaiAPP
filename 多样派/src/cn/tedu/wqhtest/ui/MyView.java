package cn.tedu.wqhtest.ui;

import android.content.Context;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

class MyView extends ImageView {
	public MyView(Context context, float x, float y) {
		super(context);
		setBackgroundResource(R.anim.home_rotate);
	}

	// ����һ���������÷������ڿ���MyView����ʾλ��
	public void setLocation(int top, int left) {
		this.setFrame(left, top, left + 40, top + 40);
	}
}