package co.edu.udea.compumovil.ahorcatooth.process.webservice.thread;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.text.TextUtils;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.CategoryWSProcess;
import co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public class CategoryAsyncTask extends AsyncTask<Object, Void, List<Category>> {

	private ICategoryWS categoryWS;

	public CategoryAsyncTask(ICategoryWS categoryWS) {
		super();

		this.categoryWS = categoryWS;
	}

	@Override()
	protected List<Category> doInBackground(Object... args) {
		if (!this.checkParameters(args)) {

			return (null);
		}

		List<Category> categoriesList = new ArrayList<Category>();
		int type = ((Integer) args[0]).intValue();

		try {
			switch (type) {
			case CategoryWSProcess.FIND_ALL:
				categoriesList = this.categoryWS.findAll();
				break;

			case CategoryWSProcess.FIND_BY_LANGUAGES_ISO_CODE:
				if ((args.length != 2) || !(args[1] instanceof String)
						|| (TextUtils.isEmpty((String) args[1]))) {

					return (null);
				}

				categoriesList = this.categoryWS
						.findByLanguagesIsoCode((String) args[1]);
				break;
			}
		} catch (AhorcaToothWebServiceException e) {
			e.printStackTrace();
		}

		return (categoriesList);
	}

	private boolean checkParameters(Object... args) {
		if ((args == null) || (args.length == 0)
				|| !(args[0] instanceof Integer)) {

			return (false);
		}

		return (true);
	}
}