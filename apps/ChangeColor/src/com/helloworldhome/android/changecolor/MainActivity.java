package com.helloworldhome.android.changecolor;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		final TextView text = (TextView) findViewById(R.id.text);

		int id = item.getItemId();
		if (id == R.id.action_red) {
			text.setBackgroundColor(Color.RED);
		} else if (id == R.id.action_green) {
			text.setBackgroundColor(Color.GREEN);
		} else if (id == R.id.action_blue) {
			text.setBackgroundColor(Color.BLUE);
		}

		return super.onOptionsItemSelected(item);
	}
}
