package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.contract.WebServicePathsContract;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Path(WebServicePathsContract.HangmanWordContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.HangmanWordContract.END_POINT_INTERFACE)
public class HangmanWordWSImpl implements IHangmanWordWS {

    private static final String TAG = HangmanWordWSImpl.class.getSimpleName();
    @Autowired()
    private IHangmanWordDAO hangmanWordDAO;

    public HangmanWordWSImpl() {
        super();
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.HangmanWordContract.FIND_HANGMANS_WORDS_BY_CATEGORY_NAME_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<HangmanWord> findAllHangmanWordsByCategoryName(
            @QueryParam(WebServicePathsContract.HangmanWordContract.CATEGORY_NAME_QUERY) String categoryName) {
        List<HangmanWord> hangmanWordsFoundList = null;

        try {
            hangmanWordsFoundList = this.hangmanWordDAO.
                    findHangmansWordsByCategoryName(categoryName);
        } catch (AhorcaToothDatabaseException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "findAllHangmanWords():List<HangmanWord>",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        }

        return (hangmanWordsFoundList);
    }
}