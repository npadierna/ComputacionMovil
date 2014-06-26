package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
import co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS;
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

@Path(WebServicePathsContract.CategoryContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.CategoryContract.END_POINT_INTERFACE)
public class CategoryWSImpl implements ICategoryWS {

    private static final String TAG = CategoryWSImpl.class.getSimpleName();
    @Autowired()
    private ICategoryDAO categoryDAO;

    public CategoryWSImpl() {
        super();
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.CategoryContract.FIND_ALL_CATEGORIES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Category> findAllCategories() {
        List<Category> categoriesFoundList = null;

        try {
            categoriesFoundList = this.categoryDAO.findAllCategories();
        } catch (AhorcaToothDatabaseException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "findAllCategories():List<Category>",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        }

        return (categoriesFoundList);
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.CategoryContract.FIND_CATEGORIES_BY_LANGUAGES_ISO_CODE_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Category> findCategoriesByLanguagesIsoCode(
            @QueryParam(WebServicePathsContract.CategoryContract.LANGUAGES_ISO_CODE_QUERY) String languagesIsoCode) {
        List<Category> categoriesFoundList = null;

        if (!TextUtils.isEmpty(languagesIsoCode)) {
            try {
                categoriesFoundList = this.categoryDAO
                        .findCategoriesByLanguagesIsoCode(TextUtils.toLowerCase(
                        languagesIsoCode));
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findCategoriesByLanguagesIsoCode(String):List<Category>",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (categoriesFoundList);
    }

    @GET()
    @Override()
    @Path(WebServicePathsContract.CategoryContract.FIND_ONE_CATEGORY_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Category findCategory(
            @QueryParam(WebServicePathsContract.CategoryContract.CATEGORY_NAME_QUERY) String categoryName,
            @QueryParam(WebServicePathsContract.CategoryContract.LANGUAGES_ISO_CODE_QUERY) String languagesIsoCode) {
        Category category = null;

        if ((!TextUtils.isEmpty(categoryName))
                && (!TextUtils.isEmpty(languagesIsoCode))) {
            CategoryPK categoryPK = new CategoryPK(TextUtils.toUpperCase(
                    categoryName), TextUtils.toLowerCase(languagesIsoCode));

            try {
                category = this.categoryDAO.findCategory(categoryPK);
            } catch (AhorcaToothDatabaseException ex) {
                Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                        "findCategory(String, String):Category",
                        String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                        ex.getMessage()), ex);
            }
        }

        return (category);
    }
}