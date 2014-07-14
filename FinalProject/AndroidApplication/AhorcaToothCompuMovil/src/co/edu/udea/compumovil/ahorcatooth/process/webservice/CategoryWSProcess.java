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

	private CategoryAsyncTask categoryAsyncTask;

	private ProgressDialog progressDialog;

	public CategoryWSProcess(Context context, ProgressDialog progressDialog) {
		super();

		this.progressDialog = progressDialog;
		this.categoryAsyncTask = new CategoryAsyncTask(
				CategoryWSImpl.getInstance(context), this.getProgressDialog());
	}

	public ProgressDialog getProgressDialog() {

		return (this.progressDialog);
	}

	public void setProgressDialog(ProgressDialog progressDialog) {
		this.progressDialog = progressDialog;
	}

	public List<Category> findAll() throws AhorcaToothBusinessException {
		this.categoryAsyncTask.setProgressDialog(this.getProgressDialog());
		this.categoryAsyncTask
				.execute(new Object[] { Integer.valueOf(FIND_ALL) });

		try {
			List<Category> categoriesList = this.categoryAsyncTask.get();
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
		this.categoryAsyncTask.setProgressDialog(this.getProgressDialog());
		this.categoryAsyncTask
				.execute(new Object[] {
						Integer.valueOf(FIND_BY_LANGUAGES_ISO_CODE),
						languagesIsoCode });

		try {
			List<Category> categoriesList = this.categoryAsyncTask.get();
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