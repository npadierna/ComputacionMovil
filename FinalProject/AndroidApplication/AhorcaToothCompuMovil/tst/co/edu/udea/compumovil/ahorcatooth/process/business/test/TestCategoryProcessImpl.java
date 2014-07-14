package co.edu.udea.compumovil.ahorcatooth.process.business.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.process.business.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.CategoryProcessImpl;
import android.test.AndroidTestCase;

public class TestCategoryProcessImpl extends AndroidTestCase {

	private CategoryProcessImpl categoryProcessImpl;

	public TestCategoryProcessImpl() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		this.categoryProcessImpl = new CategoryProcessImpl(getContext());
		Category category = new Category(new CategoryPK("Sports4", "02"),
				"sports_image.png");
		try {
			assertNotNull(this.categoryProcessImpl.save(category));
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testUpdate() {
		this.categoryProcessImpl = new CategoryProcessImpl(getContext());
		Category category = new Category();
		category.setCategoryPK(new CategoryPK("Sports4", "12"));
		category.setDescription("Sports in this category");
		category.setImageName("New Sports");
		try {
			assertNotNull(this.categoryProcessImpl.update(category));
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testFindAll() {
		this.categoryProcessImpl = new CategoryProcessImpl(getContext());
		try {
			assertNotSame(this.categoryProcessImpl.findAll().size(), 0);
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

	@Test
	public void testFindByLanguageIsoCode() {
		this.categoryProcessImpl = new CategoryProcessImpl(getContext());
		try {
			assertNotSame(this.categoryProcessImpl.findByLanguageIsoCode("12").size(), 0);
		} catch (AhorcaToothBusinessException e) {
			fail();
		}
	}

}
