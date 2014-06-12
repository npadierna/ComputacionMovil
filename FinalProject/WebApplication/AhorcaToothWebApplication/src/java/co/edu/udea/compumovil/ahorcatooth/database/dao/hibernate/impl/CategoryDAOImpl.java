package co.edu.udea.compumovil.ahorcatooth.database.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.database.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.model.entity.Category;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class CategoryDAOImpl implements ICategoryDAO {

    public CategoryDAOImpl() {
        super();
    }

    @Override()
    public Long countCategories() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Category> executeNamedQueryForCategories(String namedQuery,
            String where, String whereArg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Category> findAllCategories() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Category> findCategoriesByAttributes(String... attributesArgs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public Category findCategory(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Category updateCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}