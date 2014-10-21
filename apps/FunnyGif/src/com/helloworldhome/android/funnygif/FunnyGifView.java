package com.helloworldhome.android.funnygif;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/**
 * funny gif view
 * 
 * @author yanchangyou@gmail.com
 *
 */
public class FunnyGifView extends View {

	private int[] PICITURES = new int[] { R.drawable.id2, R.drawable.id5,
			R.drawable.id6, R.drawable.id8, R.drawable.id10, R.drawable.id11,
			R.drawable.id12, R.drawable.id13, R.drawable.id14, R.drawable.id15,
			R.drawable.id16 };
	private long currentTime;
	private int currentIndex;
	private Movie movie;

	public FunnyGifView(Context context) {
		super(context);
		currentIndex = Integer.MAX_VALUE / 2;// 初始化为中间数据
		movie = Movie
				.decodeStream(getResources().openRawResource(PICITURES[0]));
		currentTime = SystemClock.uptimeMillis();
	}

	public FunnyGifView(Context context, AttributeSet attrs) {
		super(context, attrs);
		movie = Movie
				.decodeStream(getResources().openRawResource(PICITURES[0]));
		currentTime = SystemClock.uptimeMillis();
	}

	public void showPreImage() {
		showImage(--currentIndex);
	}

	public void showNextImage() {
		showImage(++currentIndex);
	}

	public void showImage(int index) {
		index = (index < 0) ? 0 : index;
		index = index % PICITURES.length;
		movie = Movie.decodeStream(getResources().openRawResource(
				PICITURES[index]));
		currentTime = SystemClock.uptimeMillis();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		long time = SystemClock.uptimeMillis();
		int duration = movie.duration();
		int movieTime = (int) ((time - currentTime) % duration);
		movie.setTime(movieTime);
		movie.draw(canvas, 0, 0);
		invalidate();
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

}
