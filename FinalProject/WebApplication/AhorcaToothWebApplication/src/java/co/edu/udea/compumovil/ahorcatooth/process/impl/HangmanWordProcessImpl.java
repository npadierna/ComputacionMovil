package co.edu.udea.compumovil.ahorcatooth.process.impl;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.persistance.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.process.IHangmanWordProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class HangmanWordProcessImpl implements IHangmanWordProcess, Serializable {

    private static final long serialVersionUID = 4901939557872617472L;
    @Autowired()
    private IHangmanWordDAO hangmanWordDAO;

    public HangmanWordProcessImpl() {
        super();
    }

    public IHangmanWordDAO getHangmanWordDAO() {

        return (this.hangmanWordDAO);
    }

    public void setHangmanWordDAO(IHangmanWordDAO hangmanWordDAO) {
        this.hangmanWordDAO = hangmanWordDAO;
    }

    private boolean isValidBundle(String wordName, String categoryName,
            String langugesIsoCode) {

        return ((!TextUtils.isEmpty(wordName))
                && (!TextUtils.isEmpty(categoryName))
                && (!TextUtils.isEmpty(langugesIsoCode)));
    }

    @Override()
    public String save(String wordName, String categoryName,
            String langugesIsoCode, String description)
            throws AhorcaToothProcessException {
        if (this.isValidBundle(wordName, categoryName, langugesIsoCode)) {
            try {
                List<HangmanWord> hangmansWordsFoundList = this.hangmanWordDAO
                        .findByAttributes(new Object[]{"wordName", wordName,
                    "category.categoryPK.categoryName", categoryName,
                    "category.categoryPK.languagesIsoCode",
                    langugesIsoCode});

                if (!hangmansWordsFoundList.isEmpty()) {
                    throw new AhorcaToothProcessException(
                            "Already exists a HangmanWord entity with the defined attributes.");
                }

                HangmanWord hangmanWord = new HangmanWord();
                hangmanWord.setWordName(TextUtils.toUpperCase(wordName));
                hangmanWord.setCategory(new Category(new CategoryPK(
                        TextUtils.toUpperCase(categoryName),
                        TextUtils.toLowerCase(langugesIsoCode)), null));
                hangmanWord.setDescription((!TextUtils.isEmpty(description))
                        ? description.trim() : null);

                return (this.hangmanWordDAO.save(hangmanWord).toString());
            } catch (AhorcaToothDatabaseException ex) {
                throw new AhorcaToothProcessException(ex);
            }
        }

        return (null);
    }
}