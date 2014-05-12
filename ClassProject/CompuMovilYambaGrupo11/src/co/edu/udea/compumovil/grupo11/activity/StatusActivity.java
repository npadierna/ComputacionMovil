package co.edu.udea.compumovil.grupo11.activity;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import co.edu.udea.compumovil.grupo11.R;
import co.edu.udea.compumovil.grupo11.activity.util.ProgressBarCustomized;
import co.edu.udea.compumovil.grupo11.thread.YambaPostAsyncTask;

public class StatusActivity extends Activity {

	private static final String TAG = StatusActivity.class.getSimpleName();

	private int defaultTextColor;

	private EditText statusEditText;
	private TextView counterTextView;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_status);

		this.createComponents();
	}

	private void createComponents() {
		this.counterTextView = (TextView) super
				.findViewById(R.id.counterTextView);

		this.defaultTextColor = this.counterTextView.getTextColors()
				.getDefaultColor();

		this.statusEditText = (EditText) super
				.findViewById(R.id.statusEditText);
		this.statusEditText.addTextChangedListener(new TextWatcher() {

			@Override()
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override()
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override()
			public void afterTextChanged(Editable s) {
				int counter = getResources().getInteger(
						R.integer.maximun_chars_for_status)
						- statusEditText.length();

				counterTextView.setText(Integer.toString(counter));
				counterTextView.setTextColor(Color.GREEN);

				if (counter < 10) {
					counterTextView.setTextColor(Color.RED);
				} else {
					counterTextView.setTextColor(defaultTextColor);
				}
			}
		});
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater().inflate(R.menu.status, menu);

		return (true);
	}

	public void onLetsYamba(View view) {
		String statusText = this.statusEditText.getText().toString();

		Log.v(TAG, "Let's Yamba my Nigga!! -> " + statusText);

		ProgressDialog progressDialog = (new ProgressBarCustomized(this))
				.createProgressDialog(
						super.getResources().getString(
								R.string.post_title_progress_dialog),
						super.getResources().getString(
								R.string.post_text_progress_dialog),
						ProgressDialog.STYLE_SPINNER, false);

		YambaPostAsyncTask yambaPostAsyncTask = new YambaPostAsyncTask(
				progressDialog);
		yambaPostAsyncTask.execute(statusText);
		try {
			String resultForTask = yambaPostAsyncTask.get();

			if (resultForTask.equals(YambaPostAsyncTask.OK_RESULT)) {
				Toast.makeText(super.getApplicationContext(),
						R.string.post_successful_toast_text, Toast.LENGTH_LONG)
						.show();

				this.statusEditText.setText("");
			} else {
				Toast.makeText(super.getApplicationContext(),
						R.string.post_failure_toast_text, Toast.LENGTH_LONG)
						.show();
			}
		} catch (InterruptedException e) {
			Log.e(TAG,
					"A exception was thrown while the results for Thread were requested",
					e);
		} catch (ExecutionException e) {
			Log.e(TAG,
					"A exception was thrown while the results for Thread were requested",
					e);
		}
	}
}