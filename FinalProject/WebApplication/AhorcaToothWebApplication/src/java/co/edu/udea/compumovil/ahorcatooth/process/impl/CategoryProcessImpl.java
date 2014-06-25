package co.edu.udea.compumovil.ahorcatooth.process.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.process.ICategoryProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryProcessImpl implements ICategoryProcess, Serializable {

    private static final long serialVersionUID = 2915088641135538176L;
    @Autowired()
    private ICategoryDAO categoryDAO;

    public CategoryProcessImpl() {
        super();
    }

    public ICategoryDAO getCategoryDAO() {

        return (this.categoryDAO);
    }

    public void setCategoryDAO(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override()
    public List<Category> findAllCategories() throws AhorcaToothProcessException {
        List<Category> categoriesFoundList = new ArrayList<>();

        try {
            categoriesFoundList = this.categoryDAO.findAllCategories();
        } catch (AhorcaToothDatabaseException ex) {
            throw new AhorcaToothProcessException(ex);
        }

        return (categoriesFoundList);
    }
}