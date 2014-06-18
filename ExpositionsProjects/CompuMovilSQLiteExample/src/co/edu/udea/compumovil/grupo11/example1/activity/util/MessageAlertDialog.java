package co.edu.udea.compumovil.grupo11.example1.activity.util;

import android.app.Activity;
import android.app.AlertDialog;

public class MessageAlertDialog {

	private Activity activity;

	public MessageAlertDialog(Activity activity) {
		super();

		this.setActivity(activity);
	}

	public Activity getActivity() {

		return (this.activity);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public AlertDialog.Builder createAlertDialog(String title, String message) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				this.getActivity());

		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setTitle(title);

		return (alertDialogBuilder);
	}
}