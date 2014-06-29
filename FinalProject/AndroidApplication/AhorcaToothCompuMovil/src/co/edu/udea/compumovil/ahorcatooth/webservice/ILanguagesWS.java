package co.edu.udea.compumovil.ahorcatooth.webservice;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public interface ILanguagesWS {

	public List<Languages> findAll() throws AhorcaToothWebServiceException;
}