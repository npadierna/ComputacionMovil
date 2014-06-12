package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.entity.Category;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface ICategoryWS {

    public List<Category> findAllCategories();

    public Category findCategory(String key);
}