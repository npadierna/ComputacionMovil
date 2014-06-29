package co.edu.udea.compumovil.ahorcatooth.webservice;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

public interface IHangmanWordWS {

	public List<HangmanWord> findLatestWithLimit(String categoryName,
			String languageIsoCode, Integer limit)
			throws AhorcaToothWebServiceException;
}