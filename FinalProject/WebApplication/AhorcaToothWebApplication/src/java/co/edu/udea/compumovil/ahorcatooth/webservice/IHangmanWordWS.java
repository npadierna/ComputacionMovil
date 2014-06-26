package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface IHangmanWordWS {

    public List<HangmanWord> findHangmansWordsByCategoryName(
            String categoryName);

    public List<HangmanWord> findHangmansWordsByLanguagesIsoCode(
            String languagesIsoCode);

    public List<HangmanWord> findLastestHangmansWords(String categoryName,
            String languagesIsoCode, Integer amount);
}