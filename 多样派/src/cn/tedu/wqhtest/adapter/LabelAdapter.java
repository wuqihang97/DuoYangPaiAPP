package cn.tedu.wqhtest.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

public class LabelAdapter extends BaseAdapter<String> {

	public LabelAdapter(Context context, List<String> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1. ��ȡ����
		String avatarResId = getData().get(position);
		
		// 2. ���convertView
		Button btn;
		if (convertView == null) {
			convertView = getLayoutInflater().inflate(R.layout.label_contents,
					null);
			btn = (Button) convertView
					.findViewById(R.id.btn_label_contents);
			convertView.setTag(btn);
		} else {
			btn = (Button) convertView.getTag();
		}

		// 4. ��ʾ����
		btn.setText(avatarResId);
		// 5. ����
		return convertView;
	}
}
