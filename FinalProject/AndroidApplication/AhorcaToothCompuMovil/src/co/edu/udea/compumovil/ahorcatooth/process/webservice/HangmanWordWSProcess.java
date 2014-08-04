package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.interfaces.IHangmanWordWSResultListener;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.HangmanWordAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.HangmanWordWSImpl;

public class HangmanWordWSProcess {

	public static final int FIND_LATEST_WITH_LIMIT = 1;

	private Context context;

	public HangmanWordWSProcess(Context context) {
		super();

		this.context = context;
	}

	public void findLatestWithLimit(
			IHangmanWordWSResultListener hangmanWordWSResultListener,
			ProgressDialog progressDialog, String categoryName,
			String languageIsoCode, Integer limit)
			throws AhorcaToothBusinessException {
		HangmanWordAsyncTask hangmanWordAsyncTask = new HangmanWordAsyncTask(
				HangmanWordWSImpl.getInstance(this.context),
				hangmanWordWSResultListener, progressDialog);

		try {
			hangmanWordAsyncTask.execute(new Object[] {
					Integer.valueOf(FIND_LATEST_WITH_LIMIT), categoryName,
					languageIsoCode, limit });
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}