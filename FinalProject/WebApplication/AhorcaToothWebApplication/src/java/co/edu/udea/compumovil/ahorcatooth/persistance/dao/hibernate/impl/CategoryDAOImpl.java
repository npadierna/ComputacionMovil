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
public class CategoryDAOImpl extends AbstractEntityContextDAO
        implements ICategoryDAO {

    public CategoryDAOImpl() {
        super();
    }

    @Override()
    public Long count() throws AhorcaToothDatabaseException {

        return (super.count(Category.class));
    }

    @Override()
    public List<Category> executeNamedQuery(String namedQuery, String where,
    String whereArg) throws AhorcaToothDatabaseException {
        List<Category> categoriesFoundList = new ArrayList<>();
        List<IEntityContext> entitesContextList = super.executeNamedQuery(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitesContextList) {
            categoriesFoundList.add((Category) entityContext);
        }

        return (categoriesFoundList);
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Category> findAll() throws AhorcaToothDatabaseException {

        return ((List<Category>) super.findAll(Category.class));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Category> findByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException {

        return ((List<Category>) super.findByAttributes(Category.class,
                attributesArgs));
    }

    @Override()
    public List<Category> findByLanguagesIsoCode(String languagesIsoCode)
            throws AhorcaToothDatabaseException {

        return (this.executeNamedQuery(
                "Category.findByLanguagesIsoCode", "languagesIsoCode",
                languagesIsoCode));
    }

    @Override()
    public Category find(CategoryPK key) throws AhorcaToothDatabaseException {

        return ((Category) super.find(Category.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Category update(Category category)
            throws AhorcaToothDatabaseException {

        return ((Category) super.update(category));
    }
}