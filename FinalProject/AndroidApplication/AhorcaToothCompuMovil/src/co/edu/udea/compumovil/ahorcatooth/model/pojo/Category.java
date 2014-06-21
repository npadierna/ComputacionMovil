package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;
import java.util.List;

public class Category implements  Serializable {

    private static final long serialVersionUID = 2350741601449118720L;

    protected CategoryPK categoryPK;
    private String imageName;
    private String description;
    private Languages languages;
    private List<HangmanWord> hangmanWordList;

    public Category() {
        super();
    }

    public Category(CategoryPK categoryPK) {
        this.categoryPK = categoryPK;
    }

    public Category(CategoryPK categoryPK, String imageName) {
        this.categoryPK = categoryPK;
        this.imageName = imageName;
    }

    public Category(String categoryName, String languagesIsoCode) {
        this.categoryPK = new CategoryPK(categoryName, languagesIsoCode);
    }

    public CategoryPK getCategoryPK() {

        return (this.categoryPK);
    }

    public void setCategoryPK(CategoryPK categoryPK) {
        this.categoryPK = categoryPK;
    }

    public String getImageName() {

        return (this.imageName);
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {

        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Languages getLanguages() {

        return (this.languages);
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public List<HangmanWord> getHangmanWordList() {

        return (this.hangmanWordList);
    }

    public void setHangmanWordList(List<HangmanWord> hangmanWordList) {
        this.hangmanWordList = hangmanWordList;
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getCategoryPK() != null)
                ? this.getCategoryPK().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Category)) {

            return (false);
        }

        Category other = (Category) object;
        if (((this.getCategoryPK() == null) && (other.getCategoryPK() != null))
                || ((this.getCategoryPK() != null)
                && !(this.getCategoryPK().equals(other.getCategoryPK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.compumovil.ahorcatooth.model.entity.Category[ categoryPK="
                + this.getCategoryPK() + " ]");
    }
}