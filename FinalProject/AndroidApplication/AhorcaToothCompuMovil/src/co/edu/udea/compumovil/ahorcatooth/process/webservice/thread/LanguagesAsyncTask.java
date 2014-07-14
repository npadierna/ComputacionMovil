package co.edu.udea.compumovil.ahorcatooth.process.webservice.thread;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.LanguagesWSProcess;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public class LanguagesAsyncTask extends AsyncTask<Object, Void, List<Languages>> {

	private ILanguagesWS languagesWS;

	public LanguagesAsyncTask(ILanguagesWS languagesWS) {
		super();

		this.languagesWS = languagesWS;
	}

	@Override()
	protected List<Languages> doInBackground(Object... args) {
		if (!this.checkParameters(args)) {

			return (null);
		}

		List<Languages> languagesList = new ArrayList<Languages>();
		int type = ((Integer) args[0]).intValue();

		try {
			switch (type) {
			case LanguagesWSProcess.FIND_ALL:
				languagesList = this.languagesWS.findAll();
				break;
			}
		} catch (AhorcaToothWebServiceException e) {
			e.printStackTrace();
		}

		return (languagesList);
	}

	private boolean checkParameters(Object... args) {
		if ((args == null) || (args.length == 0)
				|| !(args[0] instanceof Integer)) {

			return (false);
		}

		return (true);
	}
}