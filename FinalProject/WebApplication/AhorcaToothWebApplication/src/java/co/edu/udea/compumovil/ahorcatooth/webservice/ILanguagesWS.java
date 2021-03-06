package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface ILanguagesWS {

    public Languages findLanguages(String isoCode);

    public List<Languages> findAllLanguages();
}