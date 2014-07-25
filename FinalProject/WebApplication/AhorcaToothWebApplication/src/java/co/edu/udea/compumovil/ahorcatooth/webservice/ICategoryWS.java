package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface ICategoryWS {

    public Category findCategory(String categoryName, String languagesIsoCode);

    public List<Category> findAllCategories();

    public List<Category> findCategoriesByLanguagesIsoCode(
            String languagesIsoCode);
}