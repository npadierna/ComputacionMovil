package co.edu.udea.compumovil.ahorcatooth.persistence.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.compumovil.ahorcatooth.persistence.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.HangmanWordDAOImpl;
import android.content.ContentValues;
import android.test.AndroidTestCase;

public class HangmanWordDAOImplTest extends AndroidTestCase {

	private HangmanWordDAOImpl hangmanWordDAOImpl;

	public HangmanWordDAOImplTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		ContentValues contentValues = new ContentValues();
		contentValues.put(HangmanWordContract.Column.CATEGORY_NAME, "Fruits");
		contentValues.put(HangmanWordContract.Column.DESCRIPTION,
				"Words in category Fruits");
		contentValues.put(HangmanWordContract.Column.ID, "1");
		contentValues.put(HangmanWordContract.Column.LANGUAGES_ISO_CODE,
				"12345");
		contentValues.put(HangmanWordContract.Column.WORD_NAME, "Apple");

		try {
			this.hangmanWordDAOImpl = HangmanWordDAOImpl
					.getInstance(getContext());
			assertNotNull(this.hangmanWordDAOImpl.save(contentValues));
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

	@Test
	public void testCount() {
		this.hangmanWordDAOImpl = HangmanWordDAOImpl.getInstance(getContext());
		try {
			long count = this.hangmanWordDAOImpl.count();
			assertEquals(1, count);
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

	@Test
	public void testFindByCategoryNameAndLanguageIsoCode() {
		try {
			this.hangmanWordDAOImpl = HangmanWordDAOImpl
					.getInstance(getContext());
			assertNotNull(this.hangmanWordDAOImpl
					.findByCategoryNameAndLanguageIsoCode("Fruits", "12345"));
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

	@Test
	public void testDelete() {
		try {
			this.hangmanWordDAOImpl = HangmanWordDAOImpl
					.getInstance(getContext());
			int columnsDeleted = this.hangmanWordDAOImpl.delete(1L);
			assertEquals(1, columnsDeleted);
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

}
