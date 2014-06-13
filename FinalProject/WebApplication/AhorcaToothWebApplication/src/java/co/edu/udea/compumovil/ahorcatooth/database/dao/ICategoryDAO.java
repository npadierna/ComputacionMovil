package co.edu.udea.compumovil.ahorcatooth.database.dao;

import co.edu.udea.compumovil.ahorcatooth.database.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.entity.Category;
import co.edu.udea.compumovil.ahorcatooth.model.entity.CategoryPK;
import java.util.List;

public interface ICategoryDAO {

    public Long countCategories();

    public List<Category> executeNamedQueryForCategories(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException;

    public List<Category> findAllCategories()
            throws AhorcaToothDatabaseException;

    public List<Category> findCategoriesByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    public Category findCategory(CategoryPK key)
            throws AhorcaToothDatabaseException;

    public Category updateCategory(Category category)
            throws AhorcaToothDatabaseException;
}