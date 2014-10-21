package com.helloworldhome.android.switchme;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.helloworldhome.android.swtichme.R;

/**
 * 主界面<br>
 * 重构去掉重复代码
 * 
 * @author yanchangyou@gmail.com
 *
 */
public class MainActivity extends Activity {

	int[] COLOR_BUTTONS = new int[] { R.id.button_red, R.id.button_green,
			R.id.button_blue };

	@SuppressLint("UseSparseArrays")
	Map<Integer, Integer> BUTTONS_COLOR_MAP = new HashMap<Integer, Integer>();
	{
		BUTTONS_COLOR_MAP.put(R.id.button_red, Color.RED);
		BUTTONS_COLOR_MAP.put(R.id.button_green, Color.GREEN);
		BUTTONS_COLOR_MAP.put(R.id.button_blue, Color.BLUE);
	}
	@SuppressLint("UseSparseArrays")
	Map<Integer, Integer> ACTIONS_COLOR_MAP = new HashMap<Integer, Integer>();
	{
		ACTIONS_COLOR_MAP.put(R.id.action_red, Color.RED);
		ACTIONS_COLOR_MAP.put(R.id.action_green, Color.GREEN);
		ACTIONS_COLOR_MAP.put(R.id.action_blue, Color.BLUE);
	}

	/**
	 * 色彩按钮监听器，集成事件绑定和事件处理
	 * 
	 * @author yanchangyou@gmail.com
	 *
	 */
	class OnColorButtonClickListener implements OnClickListener {

		private int buttonId;

		public OnColorButtonClickListener(int buttonId) {
			this.buttonId = buttonId;

			((Button) findViewById(buttonId)).setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			setTextColor(BUTTONS_COLOR_MAP.get(buttonId));
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		for (int i = 0; i < COLOR_BUTTONS.length; i++) {
			new OnColorButtonClickListener(COLOR_BUTTONS[i]);
		}

		findViewById(R.id.button_next_page).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						gotoTouchMePage();
					}
				});
	}

	/**
	 * ToutchMe界面还回
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();

		if (ACTIONS_COLOR_MAP.containsKey(id)) {// 颜色切换
			setTextColor(ACTIONS_COLOR_MAP.get(id));
		} else if (R.id.action_next_page == id) { // 到下一页
			gotoTouchMePage();
		} else if (R.id.action_about == id) {// 关于信息
			showAbout();
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * 设置文本颜色
	 * 
	 * @param color
	 */
	private void setTextColor(int color) {
		final TextView text = (TextView) findViewById(R.id.text);
		text.setBackgroundColor(color);
	}

	/**
	 * 转到TouchMe页面
	 */
	private void gotoTouchMePage() {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, TouchMeActivity.class);
		startActivity(intent);
	}

	/**
	 * 关于页面
	 */
	private void showAbout() {
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.about,
				(ViewGroup) findViewById(R.layout.about));

		new AlertDialog.Builder(this).setTitle(R.string.about).setView(layout)
				.setPositiveButton(R.string.about_ok, null).show();
	}

}
