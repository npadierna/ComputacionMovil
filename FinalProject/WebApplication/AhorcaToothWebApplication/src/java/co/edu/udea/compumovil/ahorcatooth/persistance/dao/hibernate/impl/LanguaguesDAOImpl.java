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
public class LanguaguesDAOImpl extends AbstractEntityContext
        implements ILanguagesDAO {

    public LanguaguesDAOImpl() {
        super();
    }

    @Override()
    public Long countLanguagess() {

        return (super.countEntities(Languages.class));
    }

    @Override()
    public List<Languages> executeNamedQueryForLanguages(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException {
        List<Languages> languagesFoundsList = new ArrayList<>();
        List<IEntityContext> entitiesContextList = super.executeNamedQueryForEntities(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitiesContextList) {
            languagesFoundsList.add((Languages) entityContext);
        }

        return (languagesFoundsList);
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Languages deleteLanguages(Languages languages)
            throws AhorcaToothDatabaseException {

        return ((Languages) super.deleteEntity(languages));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Languages> findAllLanguages()
            throws AhorcaToothDatabaseException {

        return ((List<Languages>) super.findAllEntities(Languages.class));
    }

    @Override()
    public Languages findLanguages(String key)
            throws AhorcaToothDatabaseException {

        return ((Languages) super.findEntity(Languages.class, key));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<Languages> findLanguagesByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException {

        return ((List<Languages>) super.findEntitiesByAttributes(Languages.class,
                attributesArgs));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public String saveLanguages(Languages languages)
            throws AhorcaToothDatabaseException {

        return ((String) super.saveEntity(languages));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Languages updateLanguages(Languages languages)
            throws AhorcaToothDatabaseException {

        return ((Languages) super.updateEntity(languages));
    }
}