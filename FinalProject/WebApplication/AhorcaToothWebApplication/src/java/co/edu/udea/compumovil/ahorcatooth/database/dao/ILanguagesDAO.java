package co.edu.udea.compumovil.ahorcatooth.database.dao;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Languages;
import java.util.List;

public interface ILanguagesDAO {

    public Long countLanguagess();

    public List<Languages> executeNamedQueryForLanguages(String namedQuery,
            String where, String whereArg);

    public Languages deleteLanguages(Languages languages);

    public List<Languages> findAllLanguages();

    public Languages findLanguages(String key);

    public List<Languages> findLanguagesByAttributes(String... attributesArgs);

    public String saveLanguages(Languages languages);

    public Languages updateLanguages(Languages languages);
}