package com.example.aduzhenko.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

	private MediaPlayer mPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPlayer = MediaPlayer.create(this, R.raw.song);

		Button thePlayButton = findViewById(R.id.play_button);
		thePlayButton.setOnClickListener(onPlay);

		Button thePauseButton = findViewById(R.id.pause_button);
		thePauseButton.setOnClickListener(onPause);
	}

	private View.OnClickListener onPlay = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
		mPlayer.start();
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				Toast theToast = Toast.makeText(MainActivity.this,
						"I'm done", Toast.LENGTH_SHORT);
				theToast.show();
			}
		});
		}
	};

	private View.OnClickListener onPause = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mPlayer.pause();
		}
	};
}
