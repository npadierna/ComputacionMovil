package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
import co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS;
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

@Path(WebServicePathsContract.CategoryContract.ROOT_PATH)
@Scope(value = "singleton")
@Service()
@WebService(endpointInterface = WebServicePathsContract.CategoryContract.END_POINT_INTERFACE)
public class CategoryWSImpl implements ICategoryWS {

    private static final String TAG = CategoryWSImpl.class.getSimpleName();
    @Autowired()
    private ICategoryDAO categoryDAO;

    public CategoryWSImpl() {
        super();
    }

    /*
     * http://127.0.0.1:8080/ahorcatooth/rest/categories/find/all
     */
    @GET()
    @Override()
    @Path(WebServicePathsContract.CategoryContract.FIND_ALL_CATEGORIES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Category> findAll() {
        List<Category> categoriesFoundList = null;

        try {
            categoriesFoundList = this.categoryDAO.findAll();
        } catch (AhorcaToothDatabaseException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "findAll():List<Category>",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        }

        return (((categoriesFoundList == null)
                || (categoriesFoundList.isEmpty())) ? null
                : categoriesFoundList);
    }

    /*
     * http://127.0.0.1:8080/ahorcatooth/rest/categories/find/languagesisocode?languagesisocode=
     */
    @GET()
    @Override()
    @Path(WebServicePathsContract.CategoryContract.FIND_CATEGORIES_BY_LANGUAGES_ISO_CODE_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Category> findByLanguagesIsoCode(
            @QueryParam(WebServicePathsContract.CategoryContract.LANGUAGES_ISO_CODE_QUERY) String languagesIsoCode) {
        List<Category> categoriesFoundList = null;

        if (!TextUtils.isEmpty(languagesIsoCode)) {
            try {
                categoriesFoundList = this.categoryDAO
                        .findByLanguagesIsoCode(TextUtils.toLowerCase(
                        languagesIsoCode));
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findByLanguagesIsoCode(String):List<Category>",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (((categoriesFoundList == null)
                || (categoriesFoundList.isEmpty())) ? null
                : categoriesFoundList);
    }

    /*
     * http://127.0.0.1:8080/ahorcatooth/rest/categories/find?categoryname=&languagesisocode=
     */
    @GET()
    @Override()
    @Path(WebServicePathsContract.CategoryContract.FIND_ONE_CATEGORY_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Category find(
            @QueryParam(WebServicePathsContract.CategoryContract.CATEGORY_NAME_QUERY) String categoryName,
            @QueryParam(WebServicePathsContract.CategoryContract.LANGUAGES_ISO_CODE_QUERY) String languagesIsoCode) {
        Category category = null;

        if ((!TextUtils.isEmpty(categoryName))
                && (!TextUtils.isEmpty(languagesIsoCode))) {
            CategoryPK categoryPK = new CategoryPK(TextUtils.toUpperCase(
                    categoryName), TextUtils.toLowerCase(languagesIsoCode));

            try {
                category = this.categoryDAO.find(categoryPK);
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "find(String, String):Category",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (category);
    }
}