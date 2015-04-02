package com.example.xutilsdbdemo;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this); // 注入view和事件
	}

	@ViewInject(R.id.db_test_btn)
	private Button stopBtn;

	@ViewInject(R.id.result_txt)
	private TextView resultText;

	@OnClick(R.id.db_test_btn)
	private void insert(View view) {

		DbUtils db = DbUtils.create(this);
		User user = new User();
		for (int i = 0; i < 20; i++) {
			user.setName("李鹏飞+" + i);
			user.setPasword("8612345" + i);
			user.setUserId("1" + i);
			try {
				db.save(user);
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@OnClick(R.id.btn_select)
	private void select(View view) {
		String temp = "";
		DbUtils db = DbUtils.create(this);
		try {
			User user = db.findFirst(Selector.from(User.class));
			temp += "测试数据:" + user.toString() + "\n";
			resultText.setText(temp);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@OnClick(R.id.btn_selectall)
	private void selectAll(View view) {
		String temp = "";
		DbUtils db = DbUtils.create(this);
		try {
			List<User> user = db.findAll(Selector.from(User.class));
			temp += "测试数据:" + user+ "\n";
			resultText.setText(temp);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
