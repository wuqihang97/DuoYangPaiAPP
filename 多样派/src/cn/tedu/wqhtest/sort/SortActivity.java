package cn.tedu.wqhtest.sort;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import cn.tedu.wqhtest.R;

public class SortActivity extends Activity implements View.OnClickListener {
	// 声明控件
	private Button btnSortSpecies;
	private Button btnSortPlace;
	private Button btnSortOrder;
	private ImageView ivToolBack;
	private ImageView ivToolSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sort);

		// 初始化控件
		setViews();

		// 添加监听
		setListeners();
	}

	private void setListeners() {
		btnSortSpecies.setOnClickListener(this);
		btnSortPlace.setOnClickListener(this);
		btnSortOrder.setOnClickListener(this);
		ivToolBack.setOnClickListener(this);
		ivToolSearch.setOnClickListener(this);
	}

	private void setViews() {
		btnSortSpecies = (Button) findViewById(R.id.btn_sort_species);
		btnSortPlace = (Button) findViewById(R.id.btn_sort_place);
		btnSortOrder = (Button) findViewById(R.id.btn_sort_order);
		ivToolBack = (ImageView) findViewById(R.id.iv_tool_back);
		ivToolSearch = (ImageView) findViewById(R.id.iv_tool_search);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_tool_back:
			// 销毁当前Activity
			finish();
			break;
		}
	}
}
