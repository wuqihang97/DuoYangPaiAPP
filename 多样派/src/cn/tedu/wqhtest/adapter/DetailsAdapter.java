package cn.tedu.wqhtest.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

public class DetailsAdapter extends BaseAdapter<Integer> {

	public DetailsAdapter(Context context, List<Integer> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1. 获取数据
		int avatarResId = getData().get(position);
		
		// 2. 检查convertView
		ImageView ivImage;
		if (convertView == null) {
			convertView = getLayoutInflater().inflate(R.layout.details_contents,
					null);
			ivImage = (ImageView) convertView
					.findViewById(R.id.iv_details_contents);
			convertView.setTag(ivImage);
		} else {
			ivImage = (ImageView) convertView.getTag();
		}

		// 4. 显示数据

		ivImage.setImageResource(avatarResId);
		// 5. 返回
		return convertView;
	}
}
