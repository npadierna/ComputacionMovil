package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import java.util.List;

public interface IHangmanWordDAO {

    public Long count() throws AhorcaToothDatabaseException;

    public List<HangmanWord> executeNamedQuery(String namedQuery, String where,
            String whereArg) throws AhorcaToothDatabaseException;

    public HangmanWord delete(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findAll() throws AhorcaToothDatabaseException;

    public HangmanWord find(Long primaryKey)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findByCategoryName(String categoryName)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findByLanguagesIsoCode(String languagesIsoCode)
            throws AhorcaToothDatabaseException;

    public List<HangmanWord> findLatestWithLimit(String categoryName,
            String languagesIsoCode, Integer amount)
            throws AhorcaToothDatabaseException;

    public Long save(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;

    public HangmanWord update(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException;
}