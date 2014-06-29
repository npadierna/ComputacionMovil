package co.edu.udea.compumovil.ahorcatooth.process;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import java.util.List;

public interface ILanguagesProcess {

    public List<Languages> findAll() throws AhorcaToothProcessException;
}