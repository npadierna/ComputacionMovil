package co.edu.udea.compumovil.ahorcatooth.beans;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.process.ICategoryProcess;
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
public class CategoryBean implements Serializable {

    private static final long serialVersionUID = 3457147504987197440L;
    private static final String TAG = CategoryBean.class.getSimpleName();
    @Autowired()
    private ICategoryProcess categoryProcess;
    private List<Category> categoriesList;
    private SelectItem[] categoriesSelectItems;

    public CategoryBean() {
        super();
    }

    public List<Category> getCategoriesList() {

        return (this.categoriesList);
    }

    private void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public SelectItem[] getCategoriesSelectItems() {

        return (this.categoriesSelectItems);
    }

    private void setCategoriesSelectItems(SelectItem[] categoriesSelectItems) {
        this.categoriesSelectItems = categoriesSelectItems;
    }

    @PostConstruct()
    private void initComponents() {
        List<Category> categoriesFoundList = new ArrayList<>();

        try {
            categoriesFoundList = this.categoryProcess.findAllCategories();
        } catch (AhorcaToothProcessException ex) {
            Logger.getLogger(TAG).logp(Level.SEVERE, TAG,
                    "initComponents():void",
                    String.format("DATE: %s\nCAUSE: %s", (new Date()).toString(),
                    ex.getMessage()), ex);
        } finally {
            this.setCategoriesList(categoriesFoundList);
        }

        SelectItem[] categoriesFoundSelectItems =
                new SelectItem[categoriesFoundList.size()];

        Category category;
        for (int position = 0; position < categoriesFoundList.size();
                position++) {
            category = categoriesFoundList.get(position);
            categoriesFoundSelectItems[position] = new SelectItem(
                    category.getCategoryPK().getCategoryName(),
                    category.getCategoryPK().getCategoryName());
        }

        this.setCategoriesSelectItems(categoriesFoundSelectItems);
    }
}