package co.edu.udea.compumovil.ahorcatooth.beans;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.ILanguagesProcess;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothProcessException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller()
@Scope(value = "session")
public class LanguagesBean implements Serializable {

    private static final long serialVersionUID = 1938227488649633792L;
    private static final String TAG = LanguagesBean.class.getSimpleName();
    @Autowired()
    private ILanguagesProcess languagesProcess;
    private List<Languages> languagesList;
    private SelectItem[] languagesSelectItems;

    public LanguagesBean() {
        super();
    }

    public List<Languages> getLanguagesList() {

        return (this.languagesList);
    }

    private void setLanguagesList(List<Languages> languagesList) {
        this.languagesList = languagesList;
    }

    public SelectItem[] getLanguagesSelectItems() {

        return (this.languagesSelectItems);
    }

    private void setLanguagesSelectItems(SelectItem[] languagesSelectItems) {
        this.languagesSelectItems = languagesSelectItems;
    }

    @PostConstruct()
    private void initComponents() {
        List<Languages> languagesFoundList = new ArrayList<>();

        try {
            languagesFoundList = this.languagesProcess.findAllLanguages();
        } catch (AhorcaToothProcessException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "initComponents():void",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        } finally {
            this.setLanguagesList(languagesFoundList);
        }

        SelectItem[] languagesFountSelectItems =
                new SelectItem[languagesFoundList.size() + 1];
        languagesFountSelectItems[0] = new SelectItem("", "Select one");

        Languages languages;
        for (int position = 1; position <= languagesFoundList.size();
                position++) {
            languages = languagesFoundList.get(position - 1);
            languagesFountSelectItems[position] = new SelectItem(
                    languages.getIsoCode(), languages.getIsoCode());
        }

        this.setLanguagesSelectItems(languagesFountSelectItems);
    }
}