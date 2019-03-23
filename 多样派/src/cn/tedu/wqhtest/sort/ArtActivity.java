package cn.tedu.wqhtest.sort;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.GridView;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.adapter.SortAdapter;

public class ArtActivity extends SortActivity{

	// �����б�
	private GridView gvContents;
	private SortAdapter sortadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ��ʼ���б�
		gvContents = (GridView) findViewById(R.id.gv_sort_contents);

		List<Integer> contacts = new ArrayList<Integer>();
		contacts.add(R.drawable.bg2_img_content_nor1);
		contacts.add(R.drawable.bg2_img_content_nor2);
		contacts.add(R.drawable.bg2_img_content_nor3);
		contacts.add(R.drawable.bg2_img_content_nor4);
		contacts.add(R.drawable.bg2_img_content_nor5);
		contacts.add(R.drawable.bg2_img_content_nor6);
		contacts.add(R.drawable.bg2_img_content_nor7);
		contacts.add(R.drawable.bg2_img_content_nor8);

		// ����Adapter����
		sortadapter = new SortAdapter(this, contacts);

		// ΪListView����Adapter
		gvContents.setAdapter(sortadapter);

	}

	
}
