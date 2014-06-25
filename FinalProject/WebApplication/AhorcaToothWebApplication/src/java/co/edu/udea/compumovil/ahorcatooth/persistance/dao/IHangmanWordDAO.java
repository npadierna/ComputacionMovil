package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import java.util.List;

public interface IHangmanWordDAO {

    public Long countHangmansWords();

    public List<HangmanWord> executeNamedQueryForHangmansWords(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException;

    public HangmanWord deleteHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findAllHangmansWords()
            throws AhorcaToothDatabaseException;

    public HangmanWord findHangmanWord(Long key)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findHangmansWordsByAttributes(
            Object... attributesArgs) throws AhorcaToothDatabaseException;

    public List<HangmanWord> findHangmansWordsByCategoryName(
            String categoryName) throws AhorcaToothDatabaseException;

    public List<HangmanWord> findHangmansWordsByLanguagesIsoCode(
            String languagesIsoCode) throws AhorcaToothDatabaseException;

    public Long saveHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;

    public HangmanWord updateHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;
}