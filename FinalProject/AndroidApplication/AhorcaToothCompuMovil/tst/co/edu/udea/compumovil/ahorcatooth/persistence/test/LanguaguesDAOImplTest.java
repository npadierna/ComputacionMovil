package co.edu.udea.compumovil.ahorcatooth.persistence.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.compumovil.ahorcatooth.persistence.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.exception.AhorcaToothPersistenceException;
import co.edu.udea.compumovil.ahorcatooth.persistence.sqlite.dao.impl.LanguaguesDAOImpl;
import android.content.ContentValues;
import android.test.AndroidTestCase;

public class LanguaguesDAOImplTest extends AndroidTestCase {

	private LanguaguesDAOImpl languaguesDAOImpl;

	public LanguaguesDAOImplTest() {
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
		contentValues.put(LanguagesContract.Column.DESCRIPTION,
				"English language");
		contentValues.put(LanguagesContract.Column.ISO_CODE, "2");
		contentValues.put(LanguagesContract.Column.TONGUE, "English");
		try {
			this.languaguesDAOImpl = LanguaguesDAOImpl
					.getInstance(getContext());
			assertNotNull(this.languaguesDAOImpl.save(contentValues));
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

	@Test
	public void testFindAll() {
		try {
			this.languaguesDAOImpl = LanguaguesDAOImpl
					.getInstance(getContext());
			assertNotNull(this.languaguesDAOImpl.findAll());
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

	@Test
	public void testCount() {
		try {
			this.languaguesDAOImpl = LanguaguesDAOImpl
					.getInstance(getContext());
			long count = this.languaguesDAOImpl.count();
			assertEquals(1, count);
		} catch (AhorcaToothPersistenceException e) {
			fail();
		}
	}

}
