package cn.tedu.wqhtest.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.entity.Capsule;

public class CapsuleAdapter extends BaseAdapter<Capsule> {

	public CapsuleAdapter(Context context, List<Capsule> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1. 获取数据
		Capsule capsule = getData().get(position);

		// 2. 检查convertView
		ViewHolder holder;
		if (convertView == null) {
			convertView = getLayoutInflater().inflate(
					R.layout.capsule_contents, null);
			holder = new ViewHolder();
			holder.tvSubtitle = (TextView) convertView
					.findViewById(R.id.tv_capsule_subtitle);
			holder.tvTheme = (TextView) convertView
					.findViewById(R.id.tv_capsule_theme);
			holder.tvDetail = (TextView) convertView
					.findViewById(R.id.tv_capsule_detail);
			holder.ivImage = (ImageView) convertView
					.findViewById(R.id.iv_capsule_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// 4. 显示数据
		holder.ivImage.setImageResource(capsule.getIcon());
		holder.tvSubtitle.setText(capsule.getSubtitle());
		holder.tvTheme.setText(capsule.getTheme());
		holder.tvDetail.setText(capsule.getDetail());

		// 5. 返回
		return convertView;
	}

	class ViewHolder {
		ImageView ivImage;
		TextView tvSubtitle;
		TextView tvTheme;
		TextView tvDetail;
	}
}
