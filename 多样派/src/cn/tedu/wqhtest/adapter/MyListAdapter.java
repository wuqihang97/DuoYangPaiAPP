package cn.tedu.wqhtest.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.entity.User;

public class MyListAdapter extends BaseAdapter<User> {

	public MyListAdapter(Context context, List<User> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1. 获取数据
		User user = getData().get(position);

		// 2. 检查convertView
		ViewHolder holder;
		if (convertView == null) {
			convertView = getLayoutInflater().inflate(
					R.layout.list_contents, null);
			holder = new ViewHolder();
			holder.tvName = (TextView) convertView
					.findViewById(R.id.tv_list_name);
			holder.tvNews = (TextView) convertView
					.findViewById(R.id.tv_list_news);
			holder.tvTime = (TextView) convertView
					.findViewById(R.id.tv_list_time);
			holder.tvAmount = (TextView) convertView
					.findViewById(R.id.tv_list_amount);
			holder.ivImage = (ImageView) convertView
					.findViewById(R.id.iv_list_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// 4. 显示数据
		holder.ivImage.setImageResource(user.getIcon());
		holder.tvName.setText(user.getName());
		holder.tvNews.setText(user.getNews());
		holder.tvTime.setText(user.getTime());
		if(user.getAmount()==null){
			holder.tvAmount.setBackgroundResource(R.color.none);
		}else{
			holder.tvAmount.setText(user.getAmount());			
		}
		

		// 5. 返回
		return convertView;
	}

	class ViewHolder {
		ImageView ivImage;
		TextView tvName;
		TextView tvNews;
		TextView tvTime;
		TextView tvAmount;
	}
}
