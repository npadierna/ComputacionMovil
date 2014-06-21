package co.edu.udea.compumovil.ahorcatooth.process.impl;

import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl.HangmanWordDAOImpl;
import co.edu.udea.compumovil.ahorcatooth.process.IHangmanWordProcess;

public class HangmanWordProcessImpl implements IHangmanWordProcess {

	private static final String TAG = HangmanWordProcessImpl.class
			.getSimpleName();

	private IHangmanWordDAO hangmanWordDAO;

	public HangmanWordProcessImpl(Context context) {
		super();

		this.hangmanWordDAO = HangmanWordDAOImpl.getInstance(context);
	}
}