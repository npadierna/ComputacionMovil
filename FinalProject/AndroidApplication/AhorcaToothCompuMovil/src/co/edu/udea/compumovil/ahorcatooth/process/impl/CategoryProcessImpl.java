package co.edu.udea.compumovil.ahorcatooth.process.impl;

import android.content.Context;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao.impl.CategoryDAOImpl;
import co.edu.udea.compumovil.ahorcatooth.process.ICategoryProcess;

public class CategoryProcessImpl implements ICategoryProcess {

	private static final String TAG = CategoryProcessImpl.class.getSimpleName();

	private ICategoryDAO categoryDAO;

	public CategoryProcessImpl(Context context) {
		super();

		this.categoryDAO = CategoryDAOImpl.getInstance(context);
	}
}