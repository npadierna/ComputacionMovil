package co.edu.udea.compumovil.ahorcatooth.process.webservice.thread;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.text.TextUtils;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.HangmanWordWSProcess;
import co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public class HangmanWordAsyncTask extends
		AsyncTask<Object, Void, List<HangmanWord>> {

	private IHangmanWordWS hangmanWordWS;

	public HangmanWordAsyncTask(IHangmanWordWS hangmanWordWS) {
		super();

		this.hangmanWordWS = hangmanWordWS;
	}

	@Override()
	protected List<HangmanWord> doInBackground(Object... args) {
		if (!this.checkParameters(args)) {

			return (null);
		}

		List<HangmanWord> hangmanWordsList = new ArrayList<HangmanWord>();
		int type = ((Integer) args[0]).intValue();

		try {
			switch (type) {
			case HangmanWordWSProcess.FIND_LATEST_WITH_LIMIT:
				if ((args.length != 4) || !(args[1] instanceof String)
						|| !(args[2] instanceof String)
						|| !(args[3] instanceof Integer)
						|| (TextUtils.isEmpty((String) args[1]))
						|| (TextUtils.isEmpty((String) args[2]))) {

					return (null);
				}

				hangmanWordsList = this.hangmanWordWS.findLatestWithLimit(
						(String) args[1], (String) args[2], (Integer) args[3]);
				break;
			}
		} catch (AhorcaToothWebServiceException e) {
			e.printStackTrace();
		}

		return (hangmanWordsList);
	}

	private boolean checkParameters(Object... args) {
		if ((args == null) || (args.length == 0)
				|| !(args[0] instanceof Integer)) {

			return (false);
		}

		return (true);
	}
}