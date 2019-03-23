package cn.tedu.wqhtest.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

public class DynamicAdapter extends BaseAdapter<Integer> {

	public DynamicAdapter(Context context, List<Integer> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1. ��ȡ����
		int avatarResId = getData().get(position);
		
		// 2. ���convertView
		ImageView ivImage;
		if (convertView == null) {
			convertView = getLayoutInflater().inflate(R.layout.dynamic_contents,
					null);
			ivImage = (ImageView) convertView
					.findViewById(R.id.iv_dynamic_contents);
			convertView.setTag(ivImage);
		} else {
			ivImage = (ImageView) convertView.getTag();
		}

		// 4. ��ʾ����

		ivImage.setImageResource(avatarResId);
		// 5. ����
		return convertView;
	}
}
