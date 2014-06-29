package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.business.exception.AhorcaToothBusinessException;

public interface ILanguagesProcess {

	public List<Languages> findAll() throws AhorcaToothBusinessException;

	public Languages save(Languages languages)
			throws AhorcaToothBusinessException;
}