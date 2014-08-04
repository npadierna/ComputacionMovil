package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.interfaces.ILanguagesWSResultListener;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.LanguagesAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.LanguagesWSImpl;

public class LanguagesWSProcess {

	public static final int FIND_ALL = 1;

	private Context context;

	public LanguagesWSProcess(Context context) {
		super();

		this.context = context;
	}

	public void findAll(ILanguagesWSResultListener languagesWSResultListener,
			ProgressDialog progressDialog) throws AhorcaToothBusinessException {
		LanguagesAsyncTask languagesAsyncTask = new LanguagesAsyncTask(
				LanguagesWSImpl.getInstance(this.context),
				languagesWSResultListener, progressDialog);

		try {
			languagesAsyncTask
					.execute(new Object[] { Integer.valueOf(FIND_ALL) });
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}