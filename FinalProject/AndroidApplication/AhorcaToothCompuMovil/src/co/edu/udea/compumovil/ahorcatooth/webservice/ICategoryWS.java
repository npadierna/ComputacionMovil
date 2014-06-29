package co.edu.udea.compumovil.ahorcatooth.webservice;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public interface ICategoryWS {

	public List<Category> findAll() throws AhorcaToothWebServiceException;

	public List<Category> findByLanguagesIsoCode(String languesIsoCode)
			throws AhorcaToothWebServiceException;
}