package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import java.util.List;

public interface ILanguagesDAO {

    public Long countLanguagess();

    public List<Languages> executeNamedQueryForLanguages(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException;

    public Languages deleteLanguages(Languages languages)
            throws AhorcaToothDatabaseException;

    public List<Languages> findAllLanguages()
            throws AhorcaToothDatabaseException;

    public Languages findLanguages(String key)
            throws AhorcaToothDatabaseException;

    public List<Languages> findLanguagesByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    public String saveLanguages(Languages languages)
            throws AhorcaToothDatabaseException;

    public Languages updateLanguages(Languages languages)
            throws AhorcaToothDatabaseException;
}