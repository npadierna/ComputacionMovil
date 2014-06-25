package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import java.util.List;

public interface ICategoryDAO {

    public Long countCategories();

    public List<Category> executeNamedQueryForCategories(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException;

    public List<Category> findAllCategories()
            throws AhorcaToothDatabaseException;

    public List<Category> findCategoriesByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    public List<Category> findCategoriesByLanguagesIsoCode(
            String languagesIsoCode) throws AhorcaToothDatabaseException;
    
    public Category findCategory(CategoryPK key)
            throws AhorcaToothDatabaseException;

    public Category updateCategory(Category category)
            throws AhorcaToothDatabaseException;
}