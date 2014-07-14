package co.edu.udea.compumovil.ahorcatooth.activity.game;

import android.app.Activity;
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

public class HangmanBoardActivity extends Activity {

	private static final String TAG = HangmanBoardActivity.class
			.getSimpleName();

	public static final String HANGMAN_WORD_NAME_SELECTED = "Hangman Word for Game";

	private String hangmanWordName;

	private ImageView hangingProcessImageView;
	private TextView hiddenWordTextView;

	@Override()
	public void onBackPressed() {
		super.onBackPressed();

		// FIXME: Show a dialog for confirmation the exit.
	}

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_hangman_board);

		this.extractHangmanWord(super.getIntent());
		this.createViewComponents();
	}

	private void createViewComponents() {
		this.hangingProcessImageView = (ImageView) super
				.findViewById(R.id.hanging_process_image_view);

		this.hiddenWordTextView = (TextView) super
				.findViewById(R.id.hidden_word_text_view);
		this.hiddenWordTextView.setText(this.maskWord(this.hangmanWordName));

		ArrayAdapter<String> arrayAdapter = new KeyboardKeyArrayAdapter(this,
				R.layout.keyboard_key, super.getResources().getStringArray(
						R.array.keyboard_keys_texts_array));

		GridView keyboardGridView = (GridView) super
				.findViewById(R.id.keyboard_grid_view);
		keyboardGridView.setAdapter(arrayAdapter);
	}

	private void extractHangmanWord(Intent intent) {
		Bundle bundle = intent.getExtras();
		if ((bundle != null)
				&& (bundle.containsKey(HANGMAN_WORD_NAME_SELECTED))) {
			this.hangmanWordName = bundle.getString(HANGMAN_WORD_NAME_SELECTED);
		} else {
			// FIXME: Show a dialog and finish this activity.
			this.hangmanWordName = "MOCK";
		}

		Log.d(TAG, String.format("Hangman Word Name: %s", this.hangmanWordName));
	}

	private String maskWord(String text) {
		StringBuilder stringBuilder = new StringBuilder(text);
		String mask = super.getString(R.string.mask_char_for_words);

		for (int i = 0; i < stringBuilder.length(); i++) {
			stringBuilder.setCharAt(i, mask.charAt(0));
		}

		return (stringBuilder.toString());
	}

	private void revealLetter(char letter) {
		Log.i(TAG, "revealLetter(chart):void");
		Log.i(TAG, String.format("Char: %s", letter));

		StringBuilder wordStringBuilder = new StringBuilder(
				this.hiddenWordTextView.getText().toString());

		boolean wasIn = false;
		int index = this.hangmanWordName.indexOf(letter, 0);
		while (index != -1) {
			wordStringBuilder.setCharAt(index, letter);
			index = this.hangmanWordName.indexOf(letter, (index + 1));
			wasIn = true;
		}

		if (wasIn) {
			this.hiddenWordTextView.setText(wordStringBuilder.toString());
		} else {
			// FIXME: Do a punishment for fail the letter.
		}

		if (wordStringBuilder.indexOf(super
				.getString(R.string.mask_char_for_words)) == -1) {
			// FIXME: Invocation for a resume Activity.
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