package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;

public interface ICategoryProcess {

	public List<Category> findAllCategories();

	public List<Category> findCategoriesByLanguageIsoCode(String languageIsoCode);

	public Category saveCategory(Category category);

	public Category updateCategory(Category category);
}