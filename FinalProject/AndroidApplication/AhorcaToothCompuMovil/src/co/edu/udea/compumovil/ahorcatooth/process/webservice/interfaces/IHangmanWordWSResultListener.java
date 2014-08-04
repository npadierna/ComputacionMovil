package co.edu.udea.compumovil.ahorcatooth.process.webservice.interfaces;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;

public interface IHangmanWordWSResultListener {

	public List<HangmanWord> hangmanWordWSResultListener(
			List<HangmanWord> hangmansWordsList);
}