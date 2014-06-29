package co.edu.udea.compumovil.ahorcatooth.process.business.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.CategoryContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.CategoryDAOImpl;
import co.edu.udea.compumovil.ahorcatooth.process.business.ICategoryProcess;
import co.edu.udea.compumovil.ahorcatooth.process.business.exception.AhorcaToothBusinessException;

public class CategoryProcessImpl implements ICategoryProcess {

	private static final String TAG = CategoryProcessImpl.class.getSimpleName();

	private ICategoryDAO categoryDAO;

	public CategoryProcessImpl(Context context) {
		super();

		this.categoryDAO = CategoryDAOImpl.getInstance(context);
	}

	private ContentValues convertCategoryToContentValues(Category category) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(CategoryContract.Column.CATEGORY_NAME, category
				.getCategoryPK().getCategoryName());
		contentValues.put(CategoryContract.Column.LANGUAGES_ISO_CODE, category
				.getCategoryPK().getLanguagesIsoCode());
		contentValues.put(CategoryContract.Column.IMAGE_NAME,
				category.getImageName());
		contentValues.put(CategoryContract.Column.DESCRIPTION,
				category.getDescription());

		return (contentValues);
	}

	private Category convertContentValuesToCategory(ContentValues contentValues) {
		CategoryPK categoryPK = new CategoryPK(
				contentValues
						.getAsString(CategoryContract.Column.CATEGORY_NAME),
				contentValues
						.getAsString(CategoryContract.Column.LANGUAGES_ISO_CODE));
		Category category = new Category(categoryPK,
				contentValues.getAsString(CategoryContract.Column.IMAGE_NAME));
		category.setDescription(contentValues
				.getAsString(CategoryContract.Column.DESCRIPTION));

		return (category);
	}

	private boolean isValidCategory(Category category) {
		if (category == null) {

			return (false);
		}

		return (this.isValidCategoryPK(category.getCategoryPK()));
	}

	private boolean isValidCategoryPK(CategoryPK categoryPK) {
		if (categoryPK == null) {

			return (false);
		}

		return (!(TextUtils.isEmpty(categoryPK.getCategoryName())) && !(TextUtils
				.isEmpty(categoryPK.getLanguagesIsoCode())));
	}

	@Override()
	public List<Category> findAll() throws AhorcaToothBusinessException {
		Log.i(TAG, "findAll():List<Category>");

		try {
			List<ContentValues> contentValuesList = this.categoryDAO.findAll();
			List<Category> categoriesList = new ArrayList<Category>();

			for (ContentValues contentValues : contentValuesList) {
				categoriesList.add(this
						.convertContentValuesToCategory(contentValues));
			}

			return (categoriesList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	@Override()
	public List<Category> findByLanguageIsoCode(String languageIsoCode)
			throws AhorcaToothBusinessException {
		Log.i(TAG, "findByLanguageIsoCode(String):List<Category>");

		try {
			List<Category> categoriesList = new ArrayList<Category>();

			if (!TextUtils.isEmpty(languageIsoCode)) {
				List<ContentValues> contentValuesList = this.categoryDAO
						.findByLanguageIsoCode(languageIsoCode);

				for (ContentValues contentValues : contentValuesList) {
					categoriesList.add(this
							.convertContentValuesToCategory(contentValues));
				}
			}

			return (categoriesList);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	@Override()
	public Category save(Category category) throws AhorcaToothBusinessException {
		Log.i(TAG, "save(Category):Category");

		try {
			if (this.isValidCategory(category)) {

				return ((this.categoryDAO.save(this
						.convertCategoryToContentValues(category)) != null) ? category
						: null);
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}

	@Override()
	public Category update(Category category)
			throws AhorcaToothBusinessException {
		Log.i(TAG, "update(Category):Category");

		try {
			if (this.isValidCategory(category)) {

				return ((this.categoryDAO.update(this
						.convertCategoryToContentValues(category)) != null) ? category
						: null);
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothBusinessException(e);
		}
	}
}