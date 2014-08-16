package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
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