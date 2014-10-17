package com.helloworldhome.android.switchme;

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
 * 主界面
 * 
 * @author yanchangyou@gmail.com
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 点击按钮，切换颜色
		final TextView text = (TextView) findViewById(R.id.text);

		((Button) findViewById(R.id.button_red))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						text.setBackgroundColor(Color.RED);
					}
				});
		((Button) findViewById(R.id.button_green))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						text.setBackgroundColor(Color.GREEN);
					}
				});
		((Button) findViewById(R.id.button_blue))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						text.setBackgroundColor(Color.BLUE);
					}
				});

		((Button) findViewById(R.id.button_next_page))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent();
						intent.setClass(MainActivity.this,
								TouchMeActivity.class);
						startActivityForResult(intent, 0);
					}
				});
	}

	@Override
	/**
	 * ToutchMe界面还回
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		final TextView text = (TextView) findViewById(R.id.text);
		text.setBackgroundColor(Color.YELLOW);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		final TextView text = (TextView) findViewById(R.id.text);

		int id = item.getItemId();

		// 颜色切换
		if (id == R.id.action_red) {
			text.setBackgroundColor(Color.RED);
		} else if (id == R.id.action_green) {
			text.setBackgroundColor(Color.GREEN);
		} else if (id == R.id.action_blue) {
			text.setBackgroundColor(Color.BLUE);
		}

		// 到下一页
		if (R.id.action_next_page == id) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, TouchMeActivity.class);
			startActivity(intent);
		}

		// 关于信息
		if (R.id.action_about == id) {
			LayoutInflater inflater = getLayoutInflater();
			View layout = inflater.inflate(R.layout.about,
					(ViewGroup) findViewById(R.layout.about));

			new AlertDialog.Builder(this).setTitle(R.string.about)
					.setView(layout).setPositiveButton(R.string.about_ok, null)
					.show();

		}

		return super.onOptionsItemSelected(item);
	}
}
