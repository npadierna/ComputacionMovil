package co.edu.udea.compumovil.ahorcatooth.activity.util;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class ProgressBarCustomized {

	private Activity activity;

	public ProgressBarCustomized(Activity activity) {
		super();
		this.setActivity(activity);
	}

	public Activity getActivity() {

		return (this.activity);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public ProgressDialog createProgressDialog(String title, String message,
			boolean isCancelable) {
		ProgressDialog progressDialog = new ProgressDialog(this.getActivity());

		progressDialog.setCancelable(isCancelable);
		progressDialog.setIndeterminate(true);
		progressDialog.setMessage(message);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setTitle(title);

		return (progressDialog);
	}
}