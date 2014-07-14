package co.edu.udea.compumovil.ahorcatooth.process.business;

import org.junit.Test;

import android.test.AndroidTestCase;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.HangmanWordProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

public class TestHangmanWordProcessImpl extends AndroidTestCase {

	private HangmanWordProcessImpl hangmanWordProcessImpl;

	public TestHangmanWordProcessImpl() {
		super();
	}

	@Test()
	public void testSave() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(
				super.getContext());

		HangmanWord hangmanWord = new HangmanWord(3L, "Volley");
		hangmanWord.setCategory(new Category(new CategoryPK("Sports3", "12"),
				"sports_image.png"));

		try {
			assertNotNull(this.hangmanWordProcessImpl.save(hangmanWord));
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testDelete() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(
				super.getContext());

		try {
			int result = this.hangmanWordProcessImpl.delete(2L);

			assertEquals(1, result);
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindOneByCategoryNameAndLanguageIsoCode() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(
				super.getContext());

		try {
			assertNotNull(this.hangmanWordProcessImpl
					.findOneByCategoryNameAndLanguageIsoCode("Sports3", "12"));
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindByCategoryNameAndLanguageIsoCode() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(
				super.getContext());

		try {
			assertNotNull(this.hangmanWordProcessImpl
					.findByCategoryNameAndLanguageIsoCode("Sports", "123456"));
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}
}