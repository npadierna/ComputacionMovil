package co.edu.udea.compumovil.ahorcatooth.database.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.database.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.model.entity.Languages;
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
            String where, String whereArg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Languages deleteLanguages(Languages languages) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Languages> findAllLanguages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public Languages findLanguages(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Languages> findLanguagesByAttributes(String... attributesArgs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public String saveLanguages(Languages languages) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Languages updateLanguages(Languages languages) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}