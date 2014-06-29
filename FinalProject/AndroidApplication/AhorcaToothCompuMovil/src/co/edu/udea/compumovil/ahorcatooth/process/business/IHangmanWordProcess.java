package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.business.exception.AhorcaToothBusinessException;

public interface IHangmanWordProcess {

	public Integer delete(Long id) throws AhorcaToothBusinessException;

	public List<HangmanWord> findByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode)
			throws AhorcaToothBusinessException;

	public HangmanWord findOneByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode)
			throws AhorcaToothBusinessException;

	public HangmanWord save(HangmanWord hangmanWord)
			throws AhorcaToothBusinessException;
}