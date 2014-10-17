package com.helloworldhome.android.switchme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * ªÊª≠ ”Õº¿‡<br>
 * 
 * @author yanchangyou@gmail.com
 *
 */
public class TouchMeView extends View {

	int action;
	float x;
	float y;
	Paint paint = new Paint();

	public TouchMeView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		if (MotionEvent.ACTION_DOWN == action) {
			paint.setColor(Color.RED);
		} else if (MotionEvent.ACTION_MOVE == action) {
			paint.setColor(Color.GREEN);
		} else if (MotionEvent.ACTION_UP == action) {
			paint.setColor(Color.BLUE);
		}

		canvas.drawCircle(x, y, 30, paint);

		super.onDraw(canvas);
	}

	@Override
	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent event) {
		x = event.getX();
		y = event.getY();
		action = event.getAction();
		invalidate();
		return true;
	}
}
