package co.edu.udea.compumovil.ahorcatooth.database.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.database.dao.IWordDAO;
import co.edu.udea.compumovil.ahorcatooth.model.entity.Word;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class WordDAOImpl implements IWordDAO {

    public WordDAOImpl() {
        super();
    }

    @Override()
    public Long countWords() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Word> executeNamedQueryForWords(String namedQuery, String where,
            String whereArg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Word deleteWord(Word word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Word> findAllWords() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public Word findWord(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    public List<Word> findWordsByAttributes(String... attributesArgs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public String saveWord(Word word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Word updateWord(Word word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}