package co.edu.udea.compumovil.ahorcatooth.database.dao;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Category;
import java.util.List;

public interface ICategoryDAO {

    public Long countCategories();

    public List<Category> executeNamedQueryForCategories(String namedQuery,
            String where, String whereArg);

    public List<Category> findAllCategories();

    public List<Category> findCategoriesByAttributes(String... attributesArgs);

    public Category findCategory(String key);

    public Category updateCategory(Category category);
}