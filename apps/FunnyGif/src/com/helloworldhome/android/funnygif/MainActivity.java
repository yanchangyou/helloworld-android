package com.helloworldhome.android.funnygif;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final FunnyGifView gifView = (FunnyGifView) findViewById(R.id.funnyGifView);

		findViewById(R.id.btn_pre).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				gifView.showPreImage();
			}
		});

		findViewById(R.id.btn_next).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				gifView.showNextImage();
			}
		});

	}
}
