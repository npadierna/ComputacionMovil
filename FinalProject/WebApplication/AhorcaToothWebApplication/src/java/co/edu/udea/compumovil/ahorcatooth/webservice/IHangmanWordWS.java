package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.entity.HangmanWord;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface IHangmanWordWS {

    public List<HangmanWord> findAllHangmanWords();
}