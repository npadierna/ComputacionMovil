package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.LanguagesAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.LanguagesWSImpl;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class LanguagesWSProcess {

	public static final int FIND_ALL = 1;

	private Context context;
	private ProgressDialog progressDialog;

	public LanguagesWSProcess(Context context, ProgressDialog progressDialog) {
		super();

		this.context = context;
		this.progressDialog = progressDialog;
	}

	public List<Languages> findAll() throws AhorcaToothBusinessException {
		LanguagesAsyncTask languagesAsyncTask = new LanguagesAsyncTask(
				LanguagesWSImpl.getInstance(this.context), this.progressDialog);

		try {
			languagesAsyncTask
					.execute(new Object[] { Integer.valueOf(FIND_ALL) });
			
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