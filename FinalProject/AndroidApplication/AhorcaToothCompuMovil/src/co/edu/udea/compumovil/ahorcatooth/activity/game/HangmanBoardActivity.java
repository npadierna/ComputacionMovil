package co.edu.udea.compumovil.ahorcatooth.activity.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.game.resume.HangmanBoardResumeActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.game.resume.ResumeGame;
import co.edu.udea.compumovil.ahorcatooth.process.game.GameStatusEnum;
import co.edu.udea.compumovil.ahorcatooth.process.game.HangmanGameProcess;

public class HangmanBoardActivity extends Activity {

	private static final String TAG = HangmanBoardActivity.class
			.getSimpleName();

	public static final String HANGMAN_WORD_NAME_SELECTED = "Hangman Word for Game";

	private int hitHangmanScore;
	private int missHangmanScore;

	private HangmanGameProcess hangmanGameProcess;

	private AlertDialog.Builder errorAlertDialogBuilder;
	private AlertDialog.Builder warningAlertDialogBuilder;
	private Chronometer timeChronometer;
	private ImageView hangingProcessImageView;
	private TextView hiddenWordTextView;
	private TextView scoreTextView;

	@Override()
	public void onBackPressed() {
		this.warningAlertDialogBuilder
				.setMessage(R.string.back_button_pressed_message_alert_dialog);
		this.warningAlertDialogBuilder
				.setTitle(R.string.back_button_pressed_title_alert_dialog);
		this.warningAlertDialogBuilder.show();
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_hangman_board);

		this.createComponents();
		this.extractHangmanWord(super.getIntent());
		this.createViewComponents();
	}

	@Override()
	protected void onStart() {
		super.onStart();

		this.timeChronometer.start();
	}

	private void createComponents() {
		Log.i(TAG, "createComponents():void");

		this.errorAlertDialogBuilder = new AlertDialog.Builder(this);
		this.errorAlertDialogBuilder.setPositiveButton(
				R.string.label_accept_button,
				new DialogInterface.OnClickListener() {

					@Override()
					public void onClick(DialogInterface dialog, int id) {
						HangmanBoardActivity.super.finish();
					}
				});

		this.warningAlertDialogBuilder = new AlertDialog.Builder(this);
		this.warningAlertDialogBuilder.setNegativeButton(
				R.string.label_cancel_button, null);
		this.warningAlertDialogBuilder.setPositiveButton(
				R.string.label_accept_button,
				new DialogInterface.OnClickListener() {

					@Override()
					public void onClick(DialogInterface dialog, int id) {
						HangmanBoardActivity.super.finish();
					}
				});

		this.hitHangmanScore = super.getResources().getInteger(
				R.integer.hit_hangman_score);
		this.missHangmanScore = super.getResources().getInteger(
				R.integer.miss_hangman_score);
	}

	private void createViewComponents() {
		Log.i(TAG, "createViewComponents():void");

		this.timeChronometer = (Chronometer) super
				.findViewById(R.id.time_chronometer);
		this.timeChronometer.setBase(SystemClock.elapsedRealtime());

		this.hangingProcessImageView = (ImageView) super
				.findViewById(R.id.hanging_process_image_view);

		this.scoreTextView = (TextView) super
				.findViewById(R.id.score_text_view);

		this.hiddenWordTextView = (TextView) super
				.findViewById(R.id.hidden_word_text_view);
		this.hiddenWordTextView.setText(this.hangmanGameProcess.maskWord());

		ArrayAdapter<String> arrayAdapter = new KeyboardKeyArrayAdapter(this,
				R.layout.keyboard_key, super.getResources().getStringArray(
						R.array.keyboard_keys_texts_array));

		GridView keyboardGridView = (GridView) super
				.findViewById(R.id.keyboard_grid_view);
		keyboardGridView.setAdapter(arrayAdapter);
	}

	private void extractHangmanWord(Intent intent) {
		Log.i(TAG, "extractHangmanWord(Intent):void");

		Bundle bundle = intent.getExtras();
		String hangmanWordName = null;

		if ((bundle != null)
				&& (bundle.containsKey(HANGMAN_WORD_NAME_SELECTED))) {
			hangmanWordName = bundle.getString(HANGMAN_WORD_NAME_SELECTED);
		} else {
			this.errorAlertDialogBuilder
					.setMessage(R.string.cannot_obtain_hangman_word_message_alert_dialog);
			this.errorAlertDialogBuilder
					.setTitle(R.string.cannot_obtain_hangman_word_title_alert_dialog);
			this.errorAlertDialogBuilder.show();

			return;
		}

		this.hangmanGameProcess = new HangmanGameProcess(super.getResources()
				.getInteger(R.integer.initial_hangman_score), hangmanWordName,
				super.getString(R.string.mask_char_for_words));

		Log.d(TAG, String.format("Hangman Word Name: %s",
				this.hangmanGameProcess.getHangmanWordName().toString()));
	}

	private void revealLetter(char letter) {
		String currentHangmanWordStatus = this.hiddenWordTextView.getText()
				.toString();
		String nextHangmanWordStatus = this.hangmanGameProcess.revealLetter(
				currentHangmanWordStatus, letter);
		long currentScore = Long.parseLong(this.scoreTextView.getText()
				.toString());

		if (currentHangmanWordStatus.equals(nextHangmanWordStatus)) {
			this.scoreTextView.setText(String.valueOf(currentScore
					- this.missHangmanScore));
		} else {
			this.hiddenWordTextView.setText(nextHangmanWordStatus);

			this.scoreTextView.setText(String.valueOf(currentScore
					+ this.hitHangmanScore));
		}

		if (this.hangmanGameProcess.isFinished()) {
			this.timeChronometer.stop();

			ResumeGame resumeGame = new ResumeGame(!this.hangmanGameProcess
					.getGameStatusEnum().equals(GameStatusEnum.LEFT_LEG),
					currentScore, this.timeChronometer.getBase(),
					this.hangmanGameProcess.getHangmanWordName());

			Intent intent = new Intent(super.getApplicationContext(),
					HangmanBoardResumeActivity.class);
			intent.putExtra(HangmanBoardResumeActivity.RESUME_GAME_KEY,
					(Parcelable) resumeGame);

			super.startActivity(intent);
			super.finish();
		}
	}

	public void onGuessLetter(View view) {
		Log.i(TAG, "onGuessLetter(View):void");

		Button button = (Button) view;

		this.revealLetter(button.getText().charAt(0));

		button.setEnabled(false);
		button.setTextColor(super.getResources().getColor(
				R.color.used_keyboard_key_button_text_color));
	}
}