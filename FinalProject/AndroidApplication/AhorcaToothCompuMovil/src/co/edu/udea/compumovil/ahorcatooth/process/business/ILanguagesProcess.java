package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;

public interface ILanguagesProcess {

	public List<Languages> findAllLanguages();

	public Languages saveLanguages(Languages languages);
}