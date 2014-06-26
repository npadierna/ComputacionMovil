package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
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

@Path(WebServicePathsContract.LanguagesContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.LanguagesContract.END_POINT_INTERFACE)
public class LanguagesWSImpl implements ILanguagesWS {

    private static final String TAG = LanguagesWSImpl.class.getSimpleName();
    @Autowired()
    private ILanguagesDAO languagesDAO;

    public LanguagesWSImpl() {
        super();
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.LanguagesContract.FIND_ALL_LANGUAGES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Languages> findAllLanguages() {
        List<Languages> languagesesFoundList = null;

        try {
            languagesesFoundList = this.languagesDAO.findAllLanguages();
        } catch (AhorcaToothDatabaseException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "findAllLanguages():List<Languages>",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        }

        return (languagesesFoundList);
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.LanguagesContract.FIND_ONE_LANGUAGES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Languages findLanguages(
            @QueryParam(WebServicePathsContract.LanguagesContract.LANGUAGES_ISO_CODE_QUERY) String isoCode) {
        Languages languages = null;

        if (!TextUtils.isEmpty(isoCode)) {
            try {
                languages = this.languagesDAO.findLanguages(TextUtils
                        .toLowerCase(isoCode));
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findLanguages(String):Languages",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (languages);
    }
}