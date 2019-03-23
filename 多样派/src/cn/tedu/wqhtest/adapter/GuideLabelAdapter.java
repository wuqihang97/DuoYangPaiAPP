package cn.tedu.wqhtest.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import cn.tedu.wqhtest.R;

public class GuideLabelAdapter extends BaseAdapter<String> {

	public GuideLabelAdapter(Context context, List<String> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1. ��ȡ����
		String avatarResId = getData().get(position);

		// 2. ���convertView
		Button button;
		if (convertView == null) {
			convertView = getLayoutInflater().inflate(
					R.layout.guide_label_contents, null);
			button = (Button) convertView
					.findViewById(R.id.btn_guide_label_contents);
			convertView.setTag(button);
		} else {
			button = (Button) convertView.getTag();
		}

		// 4. ��ʾ����

		button.setText(avatarResId);
		// 5. ����
		return convertView;
	}
}
