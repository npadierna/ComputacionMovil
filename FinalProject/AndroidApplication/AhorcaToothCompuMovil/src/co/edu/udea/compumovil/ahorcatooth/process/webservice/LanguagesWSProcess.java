package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.LanguagesAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.LanguagesWSImpl;

public class LanguagesWSProcess {

	public static final int FIND_ALL = 1;

	private AsyncTask<Object, Void, List<Languages>> languagesAsyncTask;

	public LanguagesWSProcess(Context context) {
		super();

		this.languagesAsyncTask = new LanguagesAsyncTask(
				LanguagesWSImpl.getInstance(context));
	}

	public List<Languages> findAll() throws AhorcaToothBusinessException {
		this.languagesAsyncTask.execute(new Object[] { Integer
				.valueOf(FIND_ALL) });

		try {
			List<Languages> languagesList = this.languagesAsyncTask.get();
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