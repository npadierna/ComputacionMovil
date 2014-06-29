package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import java.util.List;

public interface ILanguagesDAO {

    public Long count() throws AhorcaToothDatabaseException;

    public List<Languages> executeNamedQuery(String namedQuery, String where,
            String whereArg) throws AhorcaToothDatabaseException;

    public Languages delete(Languages languages)
            throws AhorcaToothDatabaseException;

    public List<Languages> findAll() throws AhorcaToothDatabaseException;

    public Languages find(String primaryKey)
            throws AhorcaToothDatabaseException;

    public List<Languages> findByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    public String save(Languages languages) throws AhorcaToothDatabaseException;

    public Languages update(Languages languages)
            throws AhorcaToothDatabaseException;
}