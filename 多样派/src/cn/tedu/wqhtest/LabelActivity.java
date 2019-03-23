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

		// ��ʼ���ؼ�
		setViews();

		List<String> contacts = new ArrayList<String>();
		contacts.add("����");
		contacts.add("����");
		contacts.add("����");
		contacts.add("����");
		contacts.add("����");
		contacts.add("����");
		contacts.add("��ʳ");
		contacts.add("��Ӱ");
		contacts.add("����");
		contacts.add("����");
		contacts.add("��չ");
		contacts.add("��̨��");
		contacts.add("��Ӱ");
		contacts.add("�鷨");
		contacts.add("����");
		contacts.add("����");
		contacts.add("����");
		contacts.add("������");
		contacts.add("������");
		contacts.add("����");
		contacts.add("����");
		contacts.add("�٤");

		// ����Adapter����
		labeladapter = new LabelAdapter(this, contacts);

		// ΪListView����Adapter
		gvLabelContents.setAdapter(labeladapter);

		// ��Ӽ���
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
