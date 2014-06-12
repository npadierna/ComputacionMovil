package co.edu.udea.compumovil.ahorcatooth.database.dao;

import co.edu.udea.compumovil.ahorcatooth.model.entity.HangmanWord;
import java.util.List;

public interface IHangmanWordDAO {

    public Long countHangmanWords();

    public List<HangmanWord> executeNamedQueryForHangmanWords(String namedQuery,
            String where, String whereArg);

    public HangmanWord deleteHangmanWord(HangmanWord hangmanWord);

    public List<HangmanWord> findAllHangmanWords();

    public HangmanWord findHangmanWord(String key);

    public List<HangmanWord> findHangmanWordsByAttributes(String... attributesArgs);

    public String saveHangmanWord(HangmanWord hangmanWord);

    public HangmanWord updateHangmanWord(HangmanWord hangmanWord);
}