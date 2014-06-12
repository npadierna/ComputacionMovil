package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import co.edu.udea.compumovil.ahorcatooth.database.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.model.entity.Category;
import co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.contract.WebServicePathsContract;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Path(WebServicePathsContract.CategoryContract.ROOT_PATH)
@Service()
@WebService(endpointInterface = WebServicePathsContract.CategoryContract.END_POINT_INTERFACE)
public class CategoryWSimpl implements ICategoryWS {

    @Autowired()
    private ICategoryDAO categoryDAO;

    public CategoryWSimpl() {
        super();
    }

    @GET()
    @Path(WebServicePathsContract.CategoryContract.ALL_CATEGORIES_PATH)
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Override()
    public List<Category> findAllCategories() {
        List<Category> categoriesFoundList = null;

        try {
            categoriesFoundList = this.categoryDAO.findAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (categoriesFoundList);
    }

    @Override()
    public Category findCategory(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}