package co.edu.udea.compumovil.ahorcatooth.activity.game.resume;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import co.edu.udea.compumovil.ahorcatooth.R;

public class HangmanBoardResumeActivity extends Activity {

	private static final String TAG = HangmanBoardResumeActivity.class
			.getSimpleName();

	public static final String RESUME_GAME_KEY = "Key for the Resume Game Object";

	private ResumeGame resumeGame;

	private ImageView resumeGameImageView;
	private TextView finalScoreTextView;
	private TextView finalTimeTextView;
	private TextView hangmanWordTextView;
	private TextView mainTitleTextView;

	@Override()
	public void onBackPressed() {
		super.onBackPressed();
		Log.i(TAG, "Back Button Pressed; do nothing.");
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_hangman_board_resume);

		// this.createComponents();
		this.extractGameResume(super.getIntent());
		this.createViewComponents();
		this.fillResumeComponents();
	}

	private void createViewComponents() {
		Log.i(TAG, "createViewComponents():void");

		this.resumeGameImageView = (ImageView) super
				.findViewById(R.id.resume_game_image_view);

		this.finalScoreTextView = (TextView) super
				.findViewById(R.id.final_score_text_view);

		this.finalTimeTextView = (TextView) super
				.findViewById(R.id.final_time_text_view);

		this.hangmanWordTextView = (TextView) super
				.findViewById(R.id.hidden_hangman_word_text_view);

		this.mainTitleTextView = (TextView) super
				.findViewById(R.id.resume_game_main_title_text_view);
	}

	private void extractGameResume(Intent intent) {
		Log.i(TAG, "extractGameResume(Intent):void");

		if ((intent != null) && (intent.hasExtra(RESUME_GAME_KEY))) {
			this.resumeGame = (ResumeGame) intent
					.getParcelableExtra(RESUME_GAME_KEY);
		} else {
			// this.errorAlertDialogBuilder
			// .setMessage(R.string.cannot_obtain_hangman_word_message_alert_dialog);
			// this.errorAlertDialogBuilder
			// .setTitle(R.string.cannot_obtain_hangman_word_title_alert_dialog);
			// this.errorAlertDialogBuilder.show();

			return;
		}
	}

	private void fillResumeComponents() {
		Log.i(TAG, "fillResumeComponents(Intent):void");

		if (this.resumeGame.isWon()) {
			this.mainTitleTextView
					.setText(R.string.won_game_main_title_text_view);

			// this.resumeGameImageView.setImageDrawable(drawable);
		} else {
			this.mainTitleTextView
					.setText(R.string.lost_game_main_title_text_view);

			// this.resumeGameImageView.setImageDrawable(drawable);
		}

		this.hangmanWordTextView.setText(this.resumeGame.getHangmanWord());

		this.finalScoreTextView.setText(String.valueOf(this.resumeGame
				.getFinalScore()));

		this.finalTimeTextView.setText(DateFormat.format("mm:ss", new Date(
				this.resumeGame.getFinalTime())));
	}
}