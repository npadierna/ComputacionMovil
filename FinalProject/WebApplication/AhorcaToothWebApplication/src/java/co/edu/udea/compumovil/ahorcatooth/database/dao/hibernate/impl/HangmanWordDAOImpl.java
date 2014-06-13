package co.edu.udea.compumovil.ahorcatooth.database.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.database.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.database.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.entity.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.model.entity.IEntityContext;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class HangmanWordDAOImpl extends AbstractEntityContext
        implements IHangmanWordDAO {

    public HangmanWordDAOImpl() {
        super();
    }

    @Override()
    public Long countHangmanWords() {

        return (super.countEntities(HangmanWord.class));
    }

    @Override()
    public List<HangmanWord> executeNamedQueryForHangmanWords(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException {
        List<HangmanWord> hangmanWordsFoundList = new ArrayList<>();
        List<IEntityContext> entitesContextList = super.executeNamedQueryForEntities(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitesContextList) {
            hangmanWordsFoundList.add((HangmanWord) entityContext);
        }

        return (hangmanWordsFoundList);
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord deleteHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.deleteEntity(hangmanWord));
    }

    @Override()
    public List<HangmanWord> findAllHangmanWords()
            throws AhorcaToothDatabaseException {

        return ((List<HangmanWord>) super.findAllEntities(HangmanWord.class));
    }

    @Override()
    public HangmanWord findHangmanWord(String key)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.findEntity(HangmanWord.class, key));
    }

    @Override()
    public List<HangmanWord> findHangmanWordsByAttributes(
            Object... attributesArgs) throws AhorcaToothDatabaseException {

        return ((List<HangmanWord>) super.findEntitiesByAttributes(
                HangmanWord.class, attributesArgs));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public String saveHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((String) super.saveEntity(hangmanWord));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord updateHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.updateEntity(hangmanWord));
    }
}