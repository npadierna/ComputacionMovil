package co.edu.udea.compumovil.ahorcatooth.process.business.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.business.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.LanguagesProcessImpl;
import android.test.AndroidTestCase;

public class TestLanguagesProcessImpl extends AndroidTestCase {

	private LanguagesProcessImpl languagesProcessImpl;

	public TestLanguagesProcessImpl() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		this.languagesProcessImpl = new LanguagesProcessImpl(getContext());
		Languages languages = new Languages("9", "Spanish");
		languages.setDescription("Spanish tongue for any category");
		try {
			assertNotNull(this.languagesProcessImpl.save(languages));
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testFindAll() {
		this.languagesProcessImpl = new LanguagesProcessImpl(getContext());
		try {
			assertNotNull(this.languagesProcessImpl.findAll());
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

}
