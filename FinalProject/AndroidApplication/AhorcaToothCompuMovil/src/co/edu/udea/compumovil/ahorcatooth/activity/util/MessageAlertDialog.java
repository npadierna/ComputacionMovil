package co.edu.udea.compumovil.ahorcatooth.activity.util;

import co.edu.udea.compumovil.ahorcatooth.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */

public class MessageAlertDialog {

	private Activity activity;

	public MessageAlertDialog(Activity activity) {
		super();

		this.activity = activity;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public AlertDialog.Builder createAlertDialog(String title, String message,
			final int option) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				this.getActivity());

		builder.setTitle(title);
		builder.setIcon(activity.getResources().getDrawable(
				R.drawable.ic_launcher));
		builder.setMessage(message);
		builder.setPositiveButton("OK", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (option) {
				case 0:
					getActivity().finish();
					break;
				default:
					break;
				}
			}
		});
		builder.show();

		return builder;
	}

}
