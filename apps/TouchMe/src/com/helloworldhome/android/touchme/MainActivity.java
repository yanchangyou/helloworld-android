package com.helloworldhome.android.touchme;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new View(this) {
			
			float x;
			float y;
			Paint paint = new Paint();

			@Override
			protected void onDraw(Canvas canvas) {

				canvas.drawCircle(x, y, 60, paint);

				super.onDraw(canvas);
			}

			@Override
			public boolean onTouchEvent(MotionEvent event) {
				x = event.getX();
				y = event.getY();
				invalidate();
				setTitle("(" + x + ", " + y + ")");
				return true;
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
