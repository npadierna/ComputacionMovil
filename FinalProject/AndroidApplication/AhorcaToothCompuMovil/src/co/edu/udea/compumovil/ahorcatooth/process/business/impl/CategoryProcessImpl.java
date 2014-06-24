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

public class CategoryProcessImpl implements ICategoryProcess {

	private static final String TAG = CategoryProcessImpl.class.getSimpleName();

	private ICategoryDAO categoryDAO;

	public CategoryProcessImpl(Context context) {
		super();

		this.categoryDAO = CategoryDAOImpl.getInstance(context);
	}

	@Override()
	public List<Category> findAllCategories() {
		Log.i(TAG, "findAllCategories():List<Category>");

		List<ContentValues> contentValuesList = this.categoryDAO
				.findAllCategories();
		List<Category> categoriesList = new ArrayList<Category>();

		for (ContentValues contentValues : contentValuesList) {
			categoriesList.add(this
					.convertContentValuesToCategory(contentValues));
		}

		return (categoriesList);
	}

	@Override()
	public List<Category> findCategoriesByLanguageIsoCode(String languageIsoCode) {
		Log.i(TAG, "findCategoriesByLanguageIsoCode(String):List<Category>");

		List<Category> categoriesList = new ArrayList<Category>();

		if (!TextUtils.isEmpty(languageIsoCode)) {
			List<ContentValues> contentValuesList = this.categoryDAO
					.findCategoriesByLanguageIsoCode(languageIsoCode);

			for (ContentValues contentValues : contentValuesList) {
				categoriesList.add(this
						.convertContentValuesToCategory(contentValues));
			}
		}

		return (categoriesList);
	}

	@Override()
	public Category saveCategory(Category category) {
		Log.i(TAG, "saveCategory(Category):Category");

		if (this.isValidCategory(category)) {

			return ((this.categoryDAO.saveCategory(this
					.convertCategoryToContentValues(category)) != null) ? category
					: null);
		}

		return (null);
	}

	@Override()
	public Category updateCategory(Category category) {
		Log.i(TAG, "updateCategory(Category):Category");

		if (this.isValidCategory(category)) {

			return ((this.categoryDAO.updateCategory(this
					.convertCategoryToContentValues(category)) != null) ? category
					: null);
		}

		return (null);
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
}