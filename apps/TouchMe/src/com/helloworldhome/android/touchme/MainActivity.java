package com.helloworldhome.android.touchme;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
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
			
			int action;
			float x;
			float y;
			Paint paint = new Paint();

			@Override
			protected void onDraw(Canvas canvas) {

				if (MotionEvent.ACTION_DOWN == action) {
					paint.setColor(Color.RED);
				} else if (MotionEvent.ACTION_MOVE == action) {
					paint.setColor(Color.GREEN);
				}  else if (MotionEvent.ACTION_UP == action) {
					paint.setColor(Color.BLUE);
				}
				
				canvas.drawCircle(x, y, 30, paint);

				super.onDraw(canvas);
			}

			@Override
			public boolean onTouchEvent(MotionEvent event) {
				x = event.getX();
				y = event.getY();
				action = event.getAction();
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
}
