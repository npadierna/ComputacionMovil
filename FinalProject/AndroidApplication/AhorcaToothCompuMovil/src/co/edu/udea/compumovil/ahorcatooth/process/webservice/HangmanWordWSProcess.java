package co.edu.udea.compumovil.ahorcatooth.process.webservice;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.thread.HangmanWordAsyncTask;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl.HangmanWordWSImpl;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class HangmanWordWSProcess {

	public static final int FIND_LATEST_WITH_LIMIT = 1;

	private Context context;
	private ProgressDialog progressDialog;

	public HangmanWordWSProcess(Context context, ProgressDialog progressDialog) {
		super();

		this.context = context;
	}

	public List<HangmanWord> findLatestWithLimit(String categoryName,
			String languageIsoCode, Integer limit)
			throws AhorcaToothBusinessException {
		HangmanWordAsyncTask hangmanWordAsyncTask = new HangmanWordAsyncTask(
				HangmanWordWSImpl.getInstance(this.context),
				this.progressDialog);

		try {
			hangmanWordAsyncTask.execute(new Object[] {
					Integer.valueOf(FIND_LATEST_WITH_LIMIT), categoryName,
					languageIsoCode, limit });

			List<HangmanWord> hangmanWordsList = hangmanWordAsyncTask.get();
			if (hangmanWordsList == null) {
				throw new AhorcaToothBusinessException(
						String.format(
								"Error while procedure: \"%s\" was in execution.",
								"findLatestWithLimit(String, String, Integer):List<HangmanWord>"));
			}

			return (hangmanWordsList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}