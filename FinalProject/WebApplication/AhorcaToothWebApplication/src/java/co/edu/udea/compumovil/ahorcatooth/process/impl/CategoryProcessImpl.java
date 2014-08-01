package co.edu.udea.compumovil.ahorcatooth.process.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ICategoryDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.process.ICategoryProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
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
    public List<Category> findAll() throws AhorcaToothProcessException {
        List<Category> categoriesFoundList = new ArrayList<>();

        try {
            categoriesFoundList = this.categoryDAO.findAll();
        } catch (AhorcaToothDatabaseException ex) {
            throw new AhorcaToothProcessException(ex);
        }

        return (categoriesFoundList);
    }

    @Override()
    public List<Category> findByLanguageIsoCOde(String languageIsoCode)
            throws AhorcaToothProcessException {
        List<Category> categoriesFoundList = new ArrayList<>();

        if ((TextUtils.isEmpty(languageIsoCode))
                || (TextUtils.isEmpty(languageIsoCode.trim()))) {

            return (categoriesFoundList);
        }

        try {
            categoriesFoundList = this.categoryDAO.findByLanguagesIsoCode(
                    TextUtils.toLowerCase(languageIsoCode));
        } catch (AhorcaToothDatabaseException ex) {
            throw new AhorcaToothProcessException(ex);
        }

        return (categoriesFoundList);
    }
}