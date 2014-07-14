package co.edu.udea.compumovil.ahorcatooth.process.business;

import org.junit.Test;

import android.test.AndroidTestCase;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.CategoryProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

public class TestCategoryProcessImpl extends AndroidTestCase {

	private CategoryProcessImpl categoryProcessImpl;

	public TestCategoryProcessImpl() {
		super();
	}

	@Test()
	public void testSave() {
		this.categoryProcessImpl = new CategoryProcessImpl(super.getContext());

		Category category = new Category(new CategoryPK("Sports4", "02"),
				"sports_image.png");

		try {
			assertNotNull(this.categoryProcessImpl.save(category));
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testUpdate() {
		this.categoryProcessImpl = new CategoryProcessImpl(super.getContext());

		Category category = new Category();
		category.setCategoryPK(new CategoryPK("Sports4", "12"));
		category.setDescription("Sports in this category");
		category.setImageName("New Sports");

		try {
			assertNotNull(this.categoryProcessImpl.update(category));
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindAll() {
		this.categoryProcessImpl = new CategoryProcessImpl(super.getContext());

		try {
			assertNotSame(this.categoryProcessImpl.findAll().size(), 0);
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void testFindByLanguageIsoCode() {
		this.categoryProcessImpl = new CategoryProcessImpl(super.getContext());

		try {
			assertNotSame(this.categoryProcessImpl.findByLanguageIsoCode("12")
					.size(), 0);
		} catch (AhorcaToothBusinessException e) {
			fail(e.getMessage());
		}
	}
}