package co.edu.udea.compumovil.ahorcatooth.process.business.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.business.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.HangmanWordProcessImpl;
import android.test.AndroidTestCase;

public class TestHangmanWordProcessImpl extends AndroidTestCase {

	private HangmanWordProcessImpl hangmanWordProcessImpl;

	public TestHangmanWordProcessImpl() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(getContext());
		HangmanWord hangmanWord = new HangmanWord(3L, "Volley");
		hangmanWord.setCategory(new Category(
				new CategoryPK("Sports3", "12"), "sports_image.png"));
		try {
			assertNotNull(this.hangmanWordProcessImpl.save(hangmanWord));
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testDelete() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(getContext());
		try {
			int result = this.hangmanWordProcessImpl.delete(2L);
			assertEquals(1, result);
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testFindOneByCategoryNameAndLanguageIsoCode() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(getContext());
		try {
			assertNotNull(this.hangmanWordProcessImpl
					.findOneByCategoryNameAndLanguageIsoCode("Sports3", "12"));
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testFindByCategoryNameAndLanguageIsoCode() {
		this.hangmanWordProcessImpl = new HangmanWordProcessImpl(getContext());
		try {
			assertNotNull(this.hangmanWordProcessImpl
					.findByCategoryNameAndLanguageIsoCode("Sports", "123456"));
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

}
