package co.edu.udea.compumovil.ahorcatooth.webservice;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import java.util.List;
import javax.jws.WebService;

@WebService()
public interface ICategoryWS {

    public List<Category> findAll();

    public List<Category> findByLanguagesIsoCode(String languagesIsoCode);

    public Category find(String categoryName, String languagesIsoCode);
}