package co.edu.udea.compumovil.ahorcatooth.activity.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.game.resume.HangmanResumeActivity;
import co.edu.udea.compumovil.ahorcatooth.process.game.GameStatusEnum;
import co.edu.udea.compumovil.ahorcatooth.process.game.HangmanGameProcess;

public class HangmanBoardActivity extends Activity {

	private static final String TAG = HangmanBoardActivity.class
			.getSimpleName();

	public static final String HANGMAN_WORD_NAME_SELECTED = "Hangman Word for Game";

	private HangmanGameProcess hangmanGameProcess;

	private AlertDialog.Builder errorAlertDialogBuilder;
	private AlertDialog.Builder warningAlertDialogBuilder;
	private ImageView hangingProcessImageView;
	private TextView hiddenWordTextView;

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
	}

	private void createViewComponents() {
		Log.i(TAG, "createViewComponents():void");

		this.hangingProcessImageView = (ImageView) super
				.findViewById(R.id.hanging_process_image_view);

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

		this.hangmanGameProcess = new HangmanGameProcess(Long.MAX_VALUE,
				hangmanWordName, super.getString(R.string.mask_char_for_words));

		Log.d(TAG, String.format("Hangman Word Name: %s",
				this.hangmanGameProcess.getHangmanWordName().toString()));
	}

	private void revealLetter(char letter) {
		String currentHangmanWordStatus = this.hiddenWordTextView.getText()
				.toString();
		String nextHangmanWordStatus = this.hangmanGameProcess.revealLetter(
				currentHangmanWordStatus, letter);

		if (currentHangmanWordStatus.equals(nextHangmanWordStatus)) {
			// FIXME: Do a punishment.
		} else {
			this.hiddenWordTextView.setText(nextHangmanWordStatus);
		}

		if (this.hangmanGameProcess.getGameStatusEnum().equals(
				GameStatusEnum.FINISHED_GAME)) {
			// FIXME: Do we need pass some parameters?
			super.startActivity(new Intent(super.getApplicationContext(),
					HangmanResumeActivity.class));

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