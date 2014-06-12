package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Languages;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface ILanguagesWS {

    public List<Languages> findAllLanguages();
}