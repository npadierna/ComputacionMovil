package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import java.util.List;

public interface IHangmanWordDAO {

    public Long countHangmanWords();

    public List<HangmanWord> executeNamedQueryForHangmanWords(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException;

    public HangmanWord deleteHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findAllHangmanWords()
            throws AhorcaToothDatabaseException;

    public HangmanWord findHangmanWord(String key)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findHangmanWordsByAttributes(
            Object... attributesArgs) throws AhorcaToothDatabaseException;

    public String saveHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;

    public HangmanWord updateHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;
}