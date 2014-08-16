package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public interface ICategoryProcess {

	public List<Category> findAll() throws AhorcaToothBusinessException;

	public List<Category> findByLanguageIsoCode(String languageIsoCode)
			throws AhorcaToothBusinessException;

	public Category save(Category category) throws AhorcaToothBusinessException;

	public Category update(Category category)
			throws AhorcaToothBusinessException;
}