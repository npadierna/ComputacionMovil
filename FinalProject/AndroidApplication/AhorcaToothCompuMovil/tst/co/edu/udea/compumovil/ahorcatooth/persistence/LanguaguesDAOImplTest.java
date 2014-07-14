package co.edu.udea.compumovil.ahorcatooth.persistence;

import org.junit.Test;

import android.content.ContentValues;
import android.test.AndroidTestCase;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.LanguaguesDAOImpl;

public class LanguaguesDAOImplTest extends AndroidTestCase {

	private LanguaguesDAOImpl languaguesDAOImpl;

	public LanguaguesDAOImplTest() {
		super();
	}

	@Test()
	public void testSave() {
		this.languaguesDAOImpl = LanguaguesDAOImpl.getInstance(super
				.getContext());

		ContentValues contentValues = new ContentValues();
		contentValues.put(LanguagesContract.Column.DESCRIPTION,
				"English language");
		contentValues.put(LanguagesContract.Column.ISO_CODE, "2");
		contentValues.put(LanguagesContract.Column.TONGUE, "English");

		try {
			assertNotNull(this.languaguesDAOImpl.save(contentValues));
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindAll() {
		this.languaguesDAOImpl = LanguaguesDAOImpl.getInstance(super
				.getContext());

		try {
			assertNotNull(this.languaguesDAOImpl.findAll());
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testCount() {
		this.languaguesDAOImpl = LanguaguesDAOImpl.getInstance(super
				.getContext());

		try {
			long count = this.languaguesDAOImpl.count();

			assertEquals(1, count);
		} catch (AhorcaToothPersistenceException e) {
			fail(e.getMessage());
		}
	}
}