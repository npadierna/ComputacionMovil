package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Word;
import co.edu.udea.compumovil.ahorcatooth.webservice.IWordWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.contract.WebServicePathsContract;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.stereotype.Service;

@Path(WebServicePathsContract.WordContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.WordContract.END_POINT_INTERFACE)
public class WordWSImpl implements IWordWS {

    public WordWSImpl() {
        super();
    }

    @Override()
    public List<Word> findAllWords() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}