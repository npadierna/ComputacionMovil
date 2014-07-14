package co.edu.udea.compumovil.ahorcatooth.process.webservice.thread;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.LanguagesWSProcess;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public class LanguagesAsyncTask extends
		AsyncTask<Object, Void, List<Languages>> {

	private ILanguagesWS languagesWS;

	private ProgressDialog progressDialog;

	public LanguagesAsyncTask(ILanguagesWS languagesWS,
			ProgressDialog progressDialog) {
		super();

		this.languagesWS = languagesWS;
		this.progressDialog = progressDialog;
	}

	public ProgressDialog getProgressDialog() {

		return (this.progressDialog);
	}

	public void setProgressDialog(ProgressDialog progressDialog) {
		this.progressDialog = progressDialog;
	}

	private boolean checkParameters(Object... args) {
		if ((args == null) || (args.length == 0)
				|| !(args[0] instanceof Integer)) {

			return (false);
		}

		return (true);
	}

	@Override()
	protected List<Languages> doInBackground(Object... args) {
		if (!this.checkParameters(args)) {

			return (null);
		}

		List<Languages> languagesList = new ArrayList<Languages>();
		int type = ((Integer) args[0]).intValue();

		try {
			switch (type) {
			case LanguagesWSProcess.FIND_ALL:
				languagesList = this.languagesWS.findAll();
				break;
			}
		} catch (AhorcaToothWebServiceException e) {
			e.printStackTrace();
		}

		return (languagesList);
	}

	@Override()
	protected void onCancelled() {
		super.onCancelled();

		if (this.progressDialog != null) {
			this.progressDialog.dismiss();
		}
	}

	@Override()
	protected void onPostExecute(List<Languages> result) {
		super.onPostExecute(result);

		if (this.progressDialog != null) {
			this.progressDialog.dismiss();
		}
	}

	@Override()
	protected void onPreExecute() {
		super.onPreExecute();

		if (this.progressDialog != null) {
			this.progressDialog.show();
		}
	}
}