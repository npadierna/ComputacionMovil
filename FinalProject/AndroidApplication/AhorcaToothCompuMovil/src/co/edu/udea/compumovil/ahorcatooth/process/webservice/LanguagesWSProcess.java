package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.LanguagesAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.LanguagesWSImpl;

public class LanguagesWSProcess {

	public static final int FIND_ALL = 1;

	// private LanguagesAsyncTask languagesAsyncTask;

	private Context context;
	private ProgressDialog progressDialog;

	public LanguagesWSProcess(Context context, ProgressDialog progressDialog) {
		super();

		this.context = context;
		this.progressDialog = progressDialog;
	}

	public ProgressDialog getProgressDialog() {

		return (this.progressDialog);
	}

	public void setProgressDialog(ProgressDialog progressDialog) {
		this.progressDialog = progressDialog;
	}

	public List<Languages> findAll() throws AhorcaToothBusinessException {
		LanguagesAsyncTask languagesAsyncTask = new LanguagesAsyncTask(
				LanguagesWSImpl.getInstance(this.context),
				this.getProgressDialog(), this.context);
		languagesAsyncTask.setProgressDialog(this.getProgressDialog());
		languagesAsyncTask.execute(new Object[] { Integer.valueOf(FIND_ALL) });

		try {
			List<Languages> languagesList = languagesAsyncTask.get();
			if (languagesList == null) {
				throw new AhorcaToothBusinessException(String.format(
						"Error while procedure: \"%s\" was in execution.",
						"findAll():List<Languages>"));
			}

			return (languagesList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}