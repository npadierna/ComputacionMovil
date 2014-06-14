package co.edu.udea.compumovil.grupo11.example1.activity.create.util;

import android.app.Activity;
import android.app.AlertDialog;

public class AlertDialogMessage  {
	
	private Activity activity;

	public AlertDialogMessage(Activity activity) {
		super();
		this.setActivity(activity);
	}
	
	public Activity getActivity() {
		return activity;
	}
	
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public AlertDialog.Builder createAlertDialog(String title, String message){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.getActivity());
		
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setTitle(title);
		
		return (alertDialogBuilder);
	}


}
