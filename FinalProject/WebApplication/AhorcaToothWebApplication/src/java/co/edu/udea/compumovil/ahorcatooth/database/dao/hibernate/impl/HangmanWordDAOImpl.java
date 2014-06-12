package co.edu.udea.compumovil.ahorcatooth.database.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.database.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.model.entity.HangmanWord;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class HangmanWordDAOImpl implements IHangmanWordDAO {

    public HangmanWordDAOImpl() {
        super();
    }

    @Override()
    public Long countHangmanWords() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<HangmanWord> executeNamedQueryForHangmanWords(String namedQuery,
            String where, String whereArg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord deleteHangmanWord(HangmanWord hangmanWord) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<HangmanWord> findAllHangmanWords() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public HangmanWord findHangmanWord(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<HangmanWord> findHangmanWordsByAttributes(String... attributesArgs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public String saveHangmanWord(HangmanWord hangmanWord) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord updateHangmanWord(HangmanWord hangmanWord) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}