package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.contract.WebServicePathsContract;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.stereotype.Service;

@Path(WebServicePathsContract.HangmanWordContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.HangmanWordContract.END_POINT_INTERFACE)
public class HangmanWordWSImpl implements IHangmanWordWS {

    public HangmanWordWSImpl() {
        super();
    }

    @Override()
    public List<HangmanWord> findAllHangmanWords() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}