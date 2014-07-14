package co.edu.udea.compumovil.ahorcatooth.process.business;

import org.junit.Test;

import android.test.AndroidTestCase;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.LanguagesProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

public class TestLanguagesProcessImpl extends AndroidTestCase {

	private LanguagesProcessImpl languagesProcessImpl;

	public TestLanguagesProcessImpl() {
		super();
	}

	@Test()
	public void testSave() {
		this.languagesProcessImpl = new LanguagesProcessImpl(super.getContext());

		Languages languages = new Languages("9", "Spanish");
		languages.setDescription("Spanish tongue for any category");

		try {
			assertNotNull(this.languagesProcessImpl.save(languages));
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindAll() {
		this.languagesProcessImpl = new LanguagesProcessImpl(super.getContext());

		try {
			assertNotNull(this.languagesProcessImpl.findAll());
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}
}