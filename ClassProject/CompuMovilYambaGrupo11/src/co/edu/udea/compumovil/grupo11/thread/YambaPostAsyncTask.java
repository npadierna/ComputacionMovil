package co.edu.udea.compumovil.grupo11.thread;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class YambaPostAsyncTask extends AsyncTask<String, Void, String> {

	public static String FAIL_RESULT = "Posted Fail";
	public static String OK_RESULT = "Posted Ok";

	private ProgressDialog progressDialog;

	public YambaPostAsyncTask(ProgressDialog progressDialog) {
		super();

		this.progressDialog = progressDialog;
	}

	@Override()
	protected String doInBackground(String... args) {
		// FIXME: Checking the args[0] must be a String instance and not null and not empty.

		return (null);
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