package cn.tedu.wqhtest;

import java.util.ArrayList;
import java.util.List;

import cn.tedu.wqhtest.adapter.LabelAdapter;
import cn.tedu.wqhtest.adapter.SortAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class LabelActivity extends Activity implements View.OnClickListener,
		AdapterView.OnItemClickListener {
	private Button btnLabelBack;
	private Button btnLabelSubmit;
	private TextView tvLabelDisplay;
	private GridView gvLabelContents;
	private LabelAdapter labeladapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_label);

		// 初始化控件
		setViews();

		List<String> contacts = new ArrayList<String>();
		contacts.add("休闲");
		contacts.add("艺术");
		contacts.add("教育");
		contacts.add("公益");
		contacts.add("体育");
		contacts.add("旅行");
		contacts.add("美食");
		contacts.add("电影");
		contacts.add("唱歌");
		contacts.add("养生");
		contacts.add("画展");
		contacts.add("舞台剧");
		contacts.add("摄影");
		contacts.add("书法");
		contacts.add("雕塑");
		contacts.add("讲座");
		contacts.add("乐器");
		contacts.add("二日游");
		contacts.add("马拉松");
		contacts.add("毅行");
		contacts.add("篮球");
		contacts.add("瑜伽");

		// 创建Adapter对象
		labeladapter = new LabelAdapter(this, contacts);

		// 为ListView配置Adapter
		gvLabelContents.setAdapter(labeladapter);

		// 添加监听
		setListeners();
	}

	private void setListeners() {
		btnLabelBack.setOnClickListener(this);
		btnLabelSubmit.setOnClickListener(this);
		tvLabelDisplay.setOnClickListener(this);
		gvLabelContents.setOnItemClickListener(this);
	}

	private void setViews() {
		btnLabelBack = (Button) findViewById(R.id.btn_label_back);
		btnLabelSubmit = (Button) findViewById(R.id.btn_label_submit);
		tvLabelDisplay = (TextView) findViewById(R.id.tv_label_display);
		gvLabelContents = (GridView) findViewById(R.id.gv_label_contents);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_label_back:
			finish();
			break;
		case R.id.btn_label_submit:
			// TODO
			break;
		case R.id.tv_label_display:
			// TODO
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}
}
