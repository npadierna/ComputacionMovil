package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Languages;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.contract.WebServicePathsContract;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.stereotype.Service;

@Path(WebServicePathsContract.LanguagesContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.LanguagesContract.END_POINT_INTERFACE)
public class LanguagesWSImpl implements ILanguagesWS {

    public LanguagesWSImpl() {
        super();
    }

    @Override()
    public List<Languages> findAllLanguages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}