package co.edu.udea.compumovil.ahorcatooth.persistance.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.IEntityContext;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class CategoryDAOImpl extends AbstractEntityContext
        implements ICategoryDAO {

    public CategoryDAOImpl() {
        super();
    }

    @Override()
    public Long countCategories() {

        return (super.countEntities(Category.class));
    }

    @Override()
    public List<Category> executeNamedQueryForCategories(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException {
        List<Category> categoriesFoundList = new ArrayList<>();
        List<IEntityContext> entitesContextList = super.executeNamedQueryForEntities(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitesContextList) {
            categoriesFoundList.add((Category) entityContext);
        }

        return (categoriesFoundList);
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Category> findAllCategories()
            throws AhorcaToothDatabaseException {

        return ((List<Category>) super.findAllEntities(Category.class));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Category> findCategoriesByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException {

        return ((List<Category>) super.findEntitiesByAttributes(Category.class,
                attributesArgs));
    }

    @Override()
    public List<Category> findCategoriesByLanguagesIsoCode(
            String languagesIsoCode) throws AhorcaToothDatabaseException {

        return (this.executeNamedQueryForCategories(
                "Category.findByLanguagesIsoCode", "languagesIsoCode",
                languagesIsoCode));
    }

    @Override()
    public Category findCategory(CategoryPK key)
            throws AhorcaToothDatabaseException {

        return ((Category) super.findEntity(Category.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Category updateCategory(Category category)
            throws AhorcaToothDatabaseException {

        return ((Category) super.updateEntity(category));
    }
}