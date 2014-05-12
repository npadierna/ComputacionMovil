package co.edu.udea.compumovil.grupo11.thread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import co.edu.udea.compumovil.grupo11.activity.StatusActivity;

import com.marakana.android.yamba.clientlib.YambaClient;

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
		YambaClient yambaCloud = new YambaClient("Grupo11", "password");
		
		if((args[0] instanceof String) && (args[0] != null)
				&& (args[0] != "")){
			try {
				yambaCloud.postStatus(args[0]);
				return OK_RESULT;
			} catch (Exception e) {
				e.printStackTrace();
				return FAIL_RESULT;
			}
		}
		
		return FAIL_RESULT;
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