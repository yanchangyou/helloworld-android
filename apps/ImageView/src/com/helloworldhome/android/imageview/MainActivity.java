package com.helloworldhome.android.imageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final GifView gifView = (GifView) findViewById(R.id.imageView1);
		((Button) findViewById(R.id.btn_pre))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						gifView.showPreImage();
					}
				});
		((Button) findViewById(R.id.btn_next))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						gifView.showNextImage();
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
