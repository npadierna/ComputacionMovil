package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.CategoryAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.CategoryWSImpl;

public class CategoryWSProcess {

	public static final int FIND_ALL = 1;
	public static final int FIND_BY_LANGUAGES_ISO_CODE = 2;

	private Context context;
	private ProgressDialog progressDialog;

	public CategoryWSProcess(Context context, ProgressDialog progressDialog) {
		super();

		this.context = context;
		this.progressDialog = progressDialog;
	}

	public List<Category> findAll() throws AhorcaToothBusinessException {
		CategoryAsyncTask categoryAsyncTask = new CategoryAsyncTask(
				CategoryWSImpl.getInstance(this.context), this.progressDialog);

		try {
			categoryAsyncTask
					.execute(new Object[] { Integer.valueOf(FIND_ALL) });

			List<Category> categoriesList = categoryAsyncTask.get();
			if (categoriesList == null) {
				throw new AhorcaToothBusinessException(String.format(
						"Error while procedure: \"%s\" was in execution.",
						"findAll():List<Category>"));
			}

			return (categoriesList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	public List<Category> findByLanguagesIsoCode(String languagesIsoCode)
			throws AhorcaToothBusinessException {
		CategoryAsyncTask categoryAsyncTask = new CategoryAsyncTask(
				CategoryWSImpl.getInstance(this.context), this.progressDialog);

		try {
			categoryAsyncTask.execute(new Object[] {
					Integer.valueOf(FIND_BY_LANGUAGES_ISO_CODE),
					languagesIsoCode });

			List<Category> categoriesList = categoryAsyncTask.get();
			if (categoriesList == null) {
				throw new AhorcaToothBusinessException(String.format(
						"Error while procedure: \"%s\" was in execution.",
						"findByLanguagesIsoCode(String):List<Category>"));
			}

			return (categoriesList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}