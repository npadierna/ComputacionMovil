package co.edu.udea.compumovil.ahorcatooth.activity.util;

import co.edu.udea.compumovil.ahorcatooth.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ProgressDialogFragment extends DialogFragment {

	public static ProgressDialogFragment newInstance() {

		return (new ProgressDialogFragment());
	}

	@Override()
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		ProgressDialog progressDialog = new ProgressDialog(super.getActivity());
		progressDialog.setCancelable(false);
		progressDialog.setIndeterminate(true);
		progressDialog.setMessage(super.getString(R.string.application_name));
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setTitle(R.string.application_name);
		progressDialog.show();

		return (progressDialog);
	}
}