package co.edu.udea.compumovil.ahorcatooth.beans;

import co.edu.udea.compumovil.ahorcatooth.process.IHangmanWordProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import co.edu.udea.compumovil.ahorcatooth.util.TextUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller()
@Scope(value = "session")
public class HangmanWordBean implements Serializable {

    private static final long serialVersionUID = 8958642437642201088L;
    private static final String TAG = HangmanWordBean.class.getSimpleName();
    @Autowired()
    private IHangmanWordProcess hangmanWordProcess;
    private String categoryName;
    private String languagesIsoCode;
    private String wordName;
    private String description;

    public HangmanWordBean() {
        super();
    }

    public String getCategoryName() {

        return (this.categoryName);
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLanguagesIsoCode() {

        return (this.languagesIsoCode);
    }

    public void setLanguagesIsoCode(String languagesIsoCode) {
        this.languagesIsoCode = languagesIsoCode;
    }

    public String getWordName() {

        return (this.wordName);
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getDescription() {

        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void saveHangmanWord() {
        FacesContext context = FacesContext.getCurrentInstance();
        String messageTitle = "Successfully Saved!!";
        String messageBody;

        try {
            String savingResult = this.hangmanWordProcess.save(
                    this.getWordName(), this.getCategoryName(),
                    this.getLanguagesIsoCode(),
                    (!TextUtils.isEmpty(this.getDescription()) ? this.getDescription().trim() : null));

            messageBody = String.format("The new \"Hangman Word\" has been saved successfully: %s",
                    savingResult);

            this.setCategoryName(null);
            this.setDescription(null);
            this.setLanguagesIsoCode(null);
            this.setWordName(null);
        } catch (AhorcaToothProcessException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "saveHangmanWord():void",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);

            messageTitle = "Fatal Exception...";
            messageBody = "A fatal error has been thrown while the new \"Hangman Word\" was trying to be saved.\n\nPlease, try it again later.";
        }

        context.addMessage(null, new FacesMessage(messageTitle, messageBody));
    }
}