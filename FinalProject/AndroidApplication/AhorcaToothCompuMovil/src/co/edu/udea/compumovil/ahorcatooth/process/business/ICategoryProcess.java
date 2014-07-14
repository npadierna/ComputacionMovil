package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

public interface ICategoryProcess {

	public List<Category> findAll() throws AhorcaToothBusinessException;

	public List<Category> findByLanguageIsoCode(String languageIsoCode)
			throws AhorcaToothBusinessException;

	public Category save(Category category) throws AhorcaToothBusinessException;

	public Category update(Category category)
			throws AhorcaToothBusinessException;
}