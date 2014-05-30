package co.edu.udea.compumovil.grupo11.yamba4.activity.status;

import java.util.concurrent.ExecutionException;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import co.edu.udea.compumovil.grupo11.yamba4.R;
import co.edu.udea.compumovil.grupo11.yamba4.activity.setting.SettingsActivity;
import co.edu.udea.compumovil.grupo11.yamba4.activity.util.ProgressBarCustomized;
import co.edu.udea.compumovil.grupo11.yamba4.thread.YambaPostAsyncTask;

public class StatusFragment extends Fragment implements OnClickListener {

	private static final String TAG = StatusFragment.class.getSimpleName();

	private int defaultTextColor;

	private EditText statusEditText;
	private TextView counterTextView;
	private Button yambaButton;

	@Override()
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "onCreateView(LayoutInflater, ViewGroup, Bundle)");

		View view = inflater
				.inflate(R.layout.fragment_status, container, false);

		this.createComponents(view);

		return (view);
	}

	private void createComponents(View view) {
		Log.i(TAG, "createComponents(View)");

		this.yambaButton = (Button) view.findViewById(R.id.yambaButton);
		this.yambaButton.setOnClickListener(this);

		this.counterTextView = (TextView) view
				.findViewById(R.id.counterTextView);

		this.defaultTextColor = this.counterTextView.getTextColors()
				.getDefaultColor();

		this.statusEditText = (EditText) view.findViewById(R.id.statusEditText);
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
	public void onClick(View view) {
		String statusText = this.statusEditText.getText().toString();

		Log.v(TAG, "onLetsYamba(View) -> " + statusText);

		ProgressDialog progressDialog = (new ProgressBarCustomized(
				super.getActivity())).createProgressDialog(super.getResources()
				.getString(R.string.post_title_progress_dialog), super
				.getResources().getString(R.string.post_text_progress_dialog),
				ProgressDialog.STYLE_SPINNER, false);

		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(super.getActivity());
		String userName = sharedPreferences.getString("userName", "");
		String password = sharedPreferences.getString("password", "");
		String apiRoot = sharedPreferences.getString("apiRoot",
				"http://yamba.marakana.com/api");

		if ((TextUtils.isEmpty(userName)) || (TextUtils.isEmpty(password))
				|| (TextUtils.isEmpty(apiRoot))) {
			super.getActivity().startActivity(
					new Intent(super.getActivity(), SettingsActivity.class));

			return;
		}

		YambaPostAsyncTask yambaPostAsyncTask = new YambaPostAsyncTask(
				progressDialog);
		yambaPostAsyncTask.execute(new String[] { userName, password,
				statusText, apiRoot });
		try {
			String resultForTask = yambaPostAsyncTask.get();

			if (resultForTask.equals(YambaPostAsyncTask.OK_RESULT)) {
				Toast.makeText(super.getActivity().getApplicationContext(),
						R.string.post_successful_toast_text, Toast.LENGTH_LONG)
						.show();

				this.statusEditText.setText("");
			} else {
				Toast.makeText(super.getActivity().getApplicationContext(),
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