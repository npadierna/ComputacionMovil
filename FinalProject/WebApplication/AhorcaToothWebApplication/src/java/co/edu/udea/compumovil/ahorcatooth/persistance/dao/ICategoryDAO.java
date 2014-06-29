package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import java.util.List;

public interface ICategoryDAO {

    public Long count() throws AhorcaToothDatabaseException;

    public List<Category> executeNamedQuery(String namedQuery, String where,
            String whereArg) throws AhorcaToothDatabaseException;

    public List<Category> findAll() throws AhorcaToothDatabaseException;

    public List<Category> findByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    public List<Category> findByLanguagesIsoCode(String languagesIsoCode)
            throws AhorcaToothDatabaseException;

    public Category find(CategoryPK primaryKey)
            throws AhorcaToothDatabaseException;

    public Category update(Category category)
            throws AhorcaToothDatabaseException;
}