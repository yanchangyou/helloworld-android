package com.helloworldhome.android.switchme;

import com.helloworldhome.android.swtichme.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class TouchMeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);

		layout.addView(new TouchMeView(this));

		setContentView(layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.touchme, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int id = item.getItemId();
		if (R.id.action_go_back == id) {// ·µ»Ø²Ëµ¥
			setResult(RESULT_OK, (new Intent()).setAction("ok"));
			finish();
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
