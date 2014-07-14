package co.edu.udea.compumovil.ahorcatooth.persistence;

import org.junit.Test;

import android.content.ContentValues;
import android.test.AndroidTestCase;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.HangmanWordDAOImpl;

public class HangmanWordDAOImplTest extends AndroidTestCase {

	private HangmanWordDAOImpl hangmanWordDAOImpl;

	public HangmanWordDAOImplTest() {
		super();
	}

	@Test()
	public void testSave() {
		this.hangmanWordDAOImpl = HangmanWordDAOImpl.getInstance(super
				.getContext());

		ContentValues contentValues = new ContentValues();
		contentValues.put(HangmanWordContract.Column.CATEGORY_NAME, "Fruits");
		contentValues.put(HangmanWordContract.Column.DESCRIPTION,
				"Words in category Fruits");
		contentValues.put(HangmanWordContract.Column.ID, "1");
		contentValues.put(HangmanWordContract.Column.LANGUAGES_ISO_CODE,
				"12345");
		contentValues.put(HangmanWordContract.Column.WORD_NAME, "Apple");

		try {
			assertNotNull(this.hangmanWordDAOImpl.save(contentValues));
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testCount() {
		this.hangmanWordDAOImpl = HangmanWordDAOImpl.getInstance(super
				.getContext());

		try {
			long count = this.hangmanWordDAOImpl.count();

			assertEquals(1, count);
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindByCategoryNameAndLanguageIsoCode() {
		this.hangmanWordDAOImpl = HangmanWordDAOImpl.getInstance(super
				.getContext());

		try {
			assertNotNull(this.hangmanWordDAOImpl
					.findByCategoryNameAndLanguageIsoCode("Fruits", "12345"));
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testDelete() {
		this.hangmanWordDAOImpl = HangmanWordDAOImpl.getInstance(super
				.getContext());

		try {
			int columnsDeleted = this.hangmanWordDAOImpl.delete(1L);

			assertEquals(1, columnsDeleted);
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}
}