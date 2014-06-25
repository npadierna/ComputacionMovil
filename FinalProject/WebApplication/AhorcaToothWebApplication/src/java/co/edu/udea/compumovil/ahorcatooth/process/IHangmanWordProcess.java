package co.edu.udea.compumovil.ahorcatooth.process;

import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;

public interface IHangmanWordProcess {

    public String saveHangmanWord(String wordName, String categoryName,
            String langugesIsoCode, String description)
            throws AhorcaToothProcessException;
}