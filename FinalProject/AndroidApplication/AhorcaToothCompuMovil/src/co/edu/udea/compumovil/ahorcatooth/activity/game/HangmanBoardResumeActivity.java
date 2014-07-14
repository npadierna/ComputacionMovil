package co.edu.udea.compumovil.ahorcatooth.activity.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.R;

public class HangmanBoardResumeActivity extends Activity {

	private static final String TAG = HangmanBoardResumeActivity.class
			.getSimpleName();

	@Override()
	public void onBackPressed() {
		Log.i(TAG, "Back Button Pressed; do nothing.");
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_hangman_board_resume);
	}
}