package co.edu.udea.compumovil.ahorcatooth.process.business;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;

public interface IHangmanWordProcess {

	public Integer deleteHangmanWord(Long id);

	public List<HangmanWord> findHangmanWordsByCategoryNameAndLanguageIsoCode(
			String categoryName, String languageIsoCode);

	public HangmanWord saveHangmanWord(HangmanWord hangmanWord);
}