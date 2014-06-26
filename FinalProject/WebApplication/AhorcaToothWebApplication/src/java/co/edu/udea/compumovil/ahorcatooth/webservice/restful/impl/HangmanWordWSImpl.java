package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
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
    public List<HangmanWord> findHangmansWordsByCategoryName(
            @QueryParam(WebServicePathsContract.HangmanWordContract.CATEGORY_NAME_QUERY) String categoryName) {
        List<HangmanWord> hangmanWordsFoundList = null;

        if (!TextUtils.isEmpty(categoryName)) {
            try {
                hangmanWordsFoundList = this.hangmanWordDAO.
                        findHangmansWordsByCategoryName(TextUtils.toUpperCase(
                        categoryName));
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findAllHangmanWordsByCategoryName(String):List<HangmanWord>",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (hangmanWordsFoundList);
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.HangmanWordContract.FIND_HANGMANS_WORDS_BY_LANGUAGES_ISO_CODE_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<HangmanWord> findHangmansWordsByLanguagesIsoCode(
            @QueryParam(WebServicePathsContract.HangmanWordContract.LANGUAGES_ISO_CODE_QUERY) String languagesIsoCode) {
        List<HangmanWord> hangmanWordsFoundList = null;

        if (!TextUtils.isEmpty(languagesIsoCode)) {
            try {
                hangmanWordsFoundList = this.hangmanWordDAO
                        .findHangmansWordsByLanguagesIsoCode(TextUtils
                        .toLowerCase(languagesIsoCode));
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findAllHangmanWordsByLanguagesIsoCode(String):List<HangmanWord>",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (hangmanWordsFoundList);
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.HangmanWordContract.FIND_LASTEST_HANGMANS_WORDS_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<HangmanWord> findLastestHangmansWords(
            @QueryParam(WebServicePathsContract.HangmanWordContract.CATEGORY_NAME_QUERY) String categoryName,
            @QueryParam(WebServicePathsContract.HangmanWordContract.LANGUAGES_ISO_CODE_QUERY) String languagesIsoCode,
            @QueryParam(WebServicePathsContract.HangmanWordContract.MAX_HANGMANS_WORDS_QUERY) Integer amount) {
        List<HangmanWord> hangmanWordsFoundList = null;

        if ((!TextUtils.isEmpty(categoryName))
                && (!TextUtils.isEmpty(languagesIsoCode)) && (this.isValidAmout(amount))) {
            try {
                hangmanWordsFoundList = this.hangmanWordDAO
                        .findLastestHangmansWords(categoryName,
                        languagesIsoCode, amount);
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findLastestHangmansWords(String, String, Integer):List<HangmanWord>",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (hangmanWordsFoundList);
    }

    private boolean isValidAmout(Integer amount) {
        if ((amount == null) || (amount.intValue() < 0)
                || (amount.intValue() >= Integer.MAX_VALUE)) {

            return (false);
        }

        return (true);
    }
}