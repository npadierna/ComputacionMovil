package co.edu.udea.compumovil.ahorcatooth.process;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import java.util.List;

public interface ICategoryProcess {

    public List<Category> findAllCategories() throws AhorcaToothProcessException;
}