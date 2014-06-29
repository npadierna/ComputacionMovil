package co.edu.udea.compumovil.ahorcatooth.process.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.ILanguagesDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.process.ILanguagesProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class LanguagesProcessImpl implements ILanguagesProcess, Serializable {

    private static final long serialVersionUID = 2901939557872617472L;
    @Autowired()
    private ILanguagesDAO languagesDAO;

    public LanguagesProcessImpl() {
        super();
    }

    public ILanguagesDAO getLanguagesDAO() {

        return (this.languagesDAO);
    }

    public void setLanguagesDAO(ILanguagesDAO languagesDAO) {
        this.languagesDAO = languagesDAO;
    }

    @Override()
    public List<Languages> findAll() throws AhorcaToothProcessException {
        List<Languages> languagesFoundList = new ArrayList<>();

        try {
            languagesFoundList = this.languagesDAO.findAll();
        } catch (AhorcaToothDatabaseException ex) {
            throw new AhorcaToothProcessException(ex);
        }

        return (languagesFoundList);
    }
}