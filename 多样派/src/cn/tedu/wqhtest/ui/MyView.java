package cn.tedu.wqhtest.ui;

import android.content.Context;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

class MyView extends ImageView {
	public MyView(Context context, float x, float y) {
		super(context);
		setBackgroundResource(R.anim.home_rotate);
	}

	// 定义一个方法，该方法用于控制MyView的显示位置
	public void setLocation(int top, int left) {
		this.setFrame(left, top, left + 40, top + 40);
	}
}