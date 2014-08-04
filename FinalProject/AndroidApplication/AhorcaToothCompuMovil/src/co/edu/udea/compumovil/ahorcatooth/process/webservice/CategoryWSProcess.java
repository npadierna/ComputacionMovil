package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.interfaces.ICategoryWSResultListener;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.CategoryAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.CategoryWSImpl;

public class CategoryWSProcess {

	public static final int FIND_ALL = 1;
	public static final int FIND_BY_LANGUAGES_ISO_CODE = 2;

	private Context context;

	public CategoryWSProcess(Context context) {
		super();

		this.context = context;
	}

	public void findAll(ICategoryWSResultListener categoryWSResultListener,
			ProgressDialog progressDialog) throws AhorcaToothBusinessException {
		CategoryAsyncTask categoryAsyncTask = new CategoryAsyncTask(
				CategoryWSImpl.getInstance(this.context),
				categoryWSResultListener, progressDialog);

		try {
			categoryAsyncTask
					.execute(new Object[] { Integer.valueOf(FIND_ALL) });
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	public void findByLanguagesIsoCode(
			ICategoryWSResultListener categoryWSResultListener,
			ProgressDialog progressDialog, String languagesIsoCode)
			throws AhorcaToothBusinessException {
		CategoryAsyncTask categoryAsyncTask = new CategoryAsyncTask(
				CategoryWSImpl.getInstance(this.context),
				categoryWSResultListener, progressDialog);

		try {
			categoryAsyncTask.execute(new Object[] {
					Integer.valueOf(FIND_BY_LANGUAGES_ISO_CODE),
					languagesIsoCode });
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}