package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Word;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface IWordWS {

    public List<Word> findAllWords();
}