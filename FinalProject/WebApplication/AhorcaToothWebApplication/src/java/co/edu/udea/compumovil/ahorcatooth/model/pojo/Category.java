package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity()
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryName",
            query = "SELECT c FROM Category c WHERE c.categoryPK.categoryName = :categoryName"),
    @NamedQuery(name = "Category.findByLanguagesIsoCode",
            query = "SELECT c FROM Category c WHERE c.categoryPK.languagesIsoCode = :languagesIsoCode"),
    @NamedQuery(name = "Category.findByImageName",
            query = "SELECT c FROM Category c WHERE c.imageName = :imageName"),
    @NamedQuery(name = "Category.findByDescription",
            query = "SELECT c FROM Category c WHERE c.description = :description")})
@Table(name = "CATEGORY")
@XmlRootElement()
public class Category implements IEntityContext, Serializable {

    private static final long serialVersionUID = 2350741601449118720L;
    @EmbeddedId()
    protected CategoryPK categoryPK;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "image_name")
    private String imageName;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "languages_iso_code", referencedColumnName = "iso_code",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languages languages;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<HangmanWord> hangmanWordList;

    public Category() {
        super();
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

    @XmlTransient()
    public List<HangmanWord> getHangmanWordList() {

        return (this.hangmanWordList);
    }

    public void setHangmanWordList(List<HangmanWord> hangmanWordList) {
        this.hangmanWordList = hangmanWordList;
    }

    @Override()
    public CategoryPK getKey() {

        return (this.getCategoryPK());
    }

    @Override()
    public void setKey(Object key) {
        this.setCategoryPK((CategoryPK) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getCategoryPK() != null) ? this.getCategoryPK().hashCode()
                : 0);

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