package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.contract.WebServicePathsContract;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Path(WebServicePathsContract.LanguagesContract.ROOT_PATH)
@Scope(value = "singleton")
@Service()
@WebService(endpointInterface = WebServicePathsContract.LanguagesContract.END_POINT_INTERFACE)
public class LanguagesWSImpl implements ILanguagesWS {

    private static final String TAG = LanguagesWSImpl.class.getSimpleName();
    @Autowired()
    private ILanguagesDAO languagesDAO;

    public LanguagesWSImpl() {
        super();
    }

    /*
     * http://127.0.0.1:8080/ahorcatooth/rest/languages/find?isocode=
     */
    @GET()
    @Override()
    @Path(WebServicePathsContract.LanguagesContract.FIND_ONE_LANGUAGES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Languages findLanguages(
            @QueryParam(WebServicePathsContract.LanguagesContract.ISO_CODE_QUERY) String isoCode) {
        Languages languages = null;

        if (!TextUtils.isEmpty(isoCode)) {
            try {
                languages = this.languagesDAO.find(TextUtils
                        .toLowerCase(isoCode));
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "find(String):Languages",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (languages);
    }

    /*
     * http://127.0.0.1:8080/ahorcatooth/rest/languages/find/all
     */
    @GET()
    @Override()
    @Path(WebServicePathsContract.LanguagesContract.FIND_ALL_LANGUAGES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Languages> findAllLanguages() {
        List<Languages> languagesesFoundList = null;

        try {
            languagesesFoundList = this.languagesDAO.findAll();
        } catch (AhorcaToothDatabaseException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "findAll():List<Languages>",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        }

        return (((languagesesFoundList == null)
                || (languagesesFoundList.isEmpty())) ? null
                : languagesesFoundList);
    }
}