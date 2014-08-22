package co.edu.udea.compumovil.ahorcatooth.activity.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import co.edu.udea.compumovil.ahorcatooth.R;

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
		
		return (this.activity);
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
				android.R.drawable.ic_menu_info_details));
		builder.setMessage(message);
		builder.setPositiveButton("OK", new OnClickListener() {

			@Override()
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

		return (builder);
	}
}