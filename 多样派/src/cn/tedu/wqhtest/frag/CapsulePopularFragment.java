package cn.tedu.wqhtest.frag;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import cn.tedu.wqhtest.R;
import cn.tedu.wqhtest.adapter.CapsuleAdapter;
import cn.tedu.wqhtest.entity.Capsule;

public class CapsulePopularFragment extends Fragment implements
		AdapterView.OnItemClickListener {

	// 声明列表
	private ListView lvContents;
	private CapsuleAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page_capsule_popular, null);
		// 列表
		lvContents = (ListView) view
				.findViewById(R.id.lv_capsule_popular_contents);

		List<Capsule> contacts = new ArrayList<Capsule>();
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor1, "#自然#",
				"秋天,写着相思", "秋的声音,从远方匆匆地来,向远方匆匆地去..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor2, "#情感#",
				"直击心灵的故事", "说出来的都是故事,藏起来的才是人生..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor3, "#自然#",
				"森林中的演唱会", "稀疏的鸟叫声仿佛置身清新的森林中..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor4, "#恐怖#",
				"来自地狱的脚步声", "科学家都无法解释的毛骨悚然..."));
		contacts.add(new Capsule(R.drawable.bg8_img_content_nor5, "#自然#",
				"海浪拍打着礁石", "闭上眼睛,带上耳机,感受海浪的声音..."));

		// 创建Adapter对象
		adapter = new CapsuleAdapter(getActivity(), contacts);

		// 为ListView配置Adapter
		lvContents.setAdapter(adapter);

		lvContents.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}
}
