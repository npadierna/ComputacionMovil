package co.edu.udea.compumovil.ahorcatooth.webservice;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public interface ILanguagesWS {

	public List<Languages> findAll() throws AhorcaToothWebServiceException;
}