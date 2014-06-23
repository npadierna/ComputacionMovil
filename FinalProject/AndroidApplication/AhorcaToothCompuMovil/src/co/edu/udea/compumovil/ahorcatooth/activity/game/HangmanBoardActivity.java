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
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;

public class HangmanBoardActivity extends Activity {

	private static final String TAG = HangmanBoardActivity.class
			.getSimpleName();

	public static final String HANGMAN_WORD_SELECTED = "Hangman Word for Game";

	private HangmanWord hangmanWord;

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
		this.hiddenWordTextView.setText(this.maskWord(this.hangmanWord
				.getWordName()));

		ArrayAdapter<String> arrayAdapter = new KeyboardKeyArrayAdapter(this,
				R.layout.keyboard_key, super.getResources().getStringArray(
						R.array.keyboard_keys_texts_array));

		GridView keyboardGridView = (GridView) super
				.findViewById(R.id.keyboard_grid_view);
		keyboardGridView.setAdapter(arrayAdapter);
	}

	private void extractHangmanWord(Intent intent) {
		Bundle bundle = intent.getExtras();
		if ((bundle != null) && (bundle.containsKey(HANGMAN_WORD_SELECTED))) {
			this.hangmanWord = bundle.getParcelable(HANGMAN_WORD_SELECTED);
		} else {
			// FIXME: Show a dialog and finish this activity.
			this.hangmanWord = new HangmanWord(0L, "MOCK");
		}
	}

	private String maskWord(String text) {
		StringBuilder stringBuilder = new StringBuilder(text);
		String mask = super.getString(R.string.mask_char_for_words);

		for (int i = 0; i < stringBuilder.length(); i++) {
			stringBuilder.setCharAt(i, mask.charAt(0));
		}

		return (stringBuilder.toString());
	}

	private void revealLetter(char c) {
		Log.i(TAG, "revealLetter(chart):void");
		Log.i(TAG, String.format("Char: %s", c));

		
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