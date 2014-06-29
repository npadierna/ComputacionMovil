package co.edu.udea.compumovil.ahorcatooth.persistance.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.IEntityContext;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class LanguaguesDAOImpl extends AbstractEntityContextDAO
        implements ILanguagesDAO {

    public LanguaguesDAOImpl() {
        super();
    }

    @Override()
    public Long count() throws AhorcaToothDatabaseException {

        return (super.count(Languages.class));
    }

    @Override()
    public List<Languages> executeNamedQuery(String namedQuery, String where,
            String whereArg) throws AhorcaToothDatabaseException {
        List<Languages> languagesFoundsList = new ArrayList<>();
        List<IEntityContext> entitiesContextList = super.executeNamedQuery(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitiesContextList) {
            languagesFoundsList.add((Languages) entityContext);
        }

        return (languagesFoundsList);
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Languages delete(Languages languages)
            throws AhorcaToothDatabaseException {

        return ((Languages) super.delete(languages));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Languages> findAll() throws AhorcaToothDatabaseException {

        return ((List<Languages>) super.findAll(Languages.class));
    }

    @Override()
    public Languages find(String key)
            throws AhorcaToothDatabaseException {

        return ((Languages) super.find(Languages.class, key));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Languages> findByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException {

        return ((List<Languages>) super.findByAttributes(Languages.class,
                attributesArgs));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public String save(Languages languages)
            throws AhorcaToothDatabaseException {

        return ((String) super.save(languages));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Languages update(Languages languages)
            throws AhorcaToothDatabaseException {

        return ((Languages) super.update(languages));
    }
}