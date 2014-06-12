package co.edu.udea.compumovil.ahorcatooth.database.dao;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Word;
import java.util.List;

public interface IWordDAO {

    public Long countWords();

    public List<Word> executeNamedQueryForWords(String namedQuery,
            String where, String whereArg);

    public Word deleteWord(Word word);

    public List<Word> findAllWords();

    public Word findWord(String key);

    public List<Word> findWordsByAttributes(String... attributesArgs);

    public String saveWord(Word word);

    public Word updateWord(Word word);
}