package co.edu.udea.compumovil.ahorcatooth.persistence;

import org.junit.Test;

import android.content.ContentValues;
import android.test.AndroidTestCase;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.CategoryContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.CategoryDAOImpl;

public class CategoryDAOImplTest extends AndroidTestCase {

	private CategoryDAOImpl categoryDAOImpl;

	public CategoryDAOImplTest() {
		super();
	}

	@Test()
	public void testCount() {
		this.categoryDAOImpl = CategoryDAOImpl.getInstance(super.getContext());

		try {
			long count = this.categoryDAOImpl.count();

			assertEquals(3, count);
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindAll() {
		this.categoryDAOImpl = CategoryDAOImpl.getInstance(super.getContext());

		try {
			assertNotNull(this.categoryDAOImpl.findAll());
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindByLanguageIsoCode() {
		this.categoryDAOImpl = CategoryDAOImpl.getInstance(super.getContext());

		try {
			assertNotNull(this.categoryDAOImpl.findByLanguageIsoCode("12345"));
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testSave() {
		this.categoryDAOImpl = CategoryDAOImpl.getInstance(super.getContext());

		ContentValues contentValues = new ContentValues();
		contentValues.put(CategoryContract.Column.CATEGORY_NAME, "Fruits");
		contentValues.put(CategoryContract.Column.DESCRIPTION,
				"Fruits of the nature");
		contentValues.put(CategoryContract.Column.IMAGE_NAME, "fruit_image");
		contentValues.put(CategoryContract.Column.LANGUAGES_ISO_CODE, "12345");

		try {
			this.categoryDAOImpl.save(contentValues);
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testUpdate() {
		this.categoryDAOImpl = CategoryDAOImpl.getInstance(super.getContext());

		ContentValues contentValues = new ContentValues();
		contentValues.put(CategoryContract.Column.CATEGORY_NAME, "Fruits");
		contentValues.put(CategoryContract.Column.LANGUAGES_ISO_CODE, "12345");
		contentValues.put(CategoryContract.Column.IMAGE_NAME, "new_image.jpg");
		contentValues.put(CategoryContract.Column.DESCRIPTION,
				"This is a new description for the category");
		try {
			assertNotNull(this.categoryDAOImpl.update(contentValues));
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}
}