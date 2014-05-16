package co.edu.udea.compumovil.grupo11.yamba2.thread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.marakana.android.yamba.clientlib.YambaClient;

public class YambaPostAsyncTask extends AsyncTask<String, Void, String> {

	private static final String TAG = YambaPostAsyncTask.class.getSimpleName();

	public static final String FAIL_RESULT = "Posted Fail";
	public static final String OK_RESULT = "Posted Ok";

	private ProgressDialog progressDialog;

	public YambaPostAsyncTask(ProgressDialog progressDialog) {
		super();

		this.progressDialog = progressDialog;
	}

	@Override()
	protected String doInBackground(String... args) {
		YambaClient yambaClient = new YambaClient("grupo11", "grupo11");

		if ((args == null) || (args.length != 1)
				|| !(args[0] instanceof String)) {

			return (FAIL_RESULT);
		}

		String message = args[0].trim();
		if (!message.equals("")) {
			try {
				yambaClient.postStatus(message);

				return (OK_RESULT);
			} catch (Exception e) {
				Log.e(TAG, "A exception was thrown while posting process", e);

				return (FAIL_RESULT);
			}
		}

		return (FAIL_RESULT);
	}

	@Override()
	protected void onCancelled() {
		super.onCancelled();

		this.progressDialog.dismiss();
	}

	@Override()
	protected void onPostExecute(String result) {
		super.onPostExecute(result);

		this.progressDialog.dismiss();

	}

	@Override()
	protected void onPreExecute() {
		super.onPreExecute();

		this.progressDialog.show();
	}
}