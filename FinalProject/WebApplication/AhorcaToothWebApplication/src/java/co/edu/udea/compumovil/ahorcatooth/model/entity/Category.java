package co.edu.udea.compumovil.ahorcatooth.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
            query = "SELECT c FROM Category c WHERE c.categoryName = :categoryName"),
    @NamedQuery(name = "Category.findByImageName",
            query = "SELECT c FROM Category c WHERE c.imageName = :imageName"),
    @NamedQuery(name = "Category.findByDescription",
            query = "SELECT c FROM Category c WHERE c.description = :description")})
@Table(name = "CATEGORY")
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement()
public class Category implements IEntityContext, Serializable {

    private static final long serialVersionUID = 2350741601449118720L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "image_name")
    private String imageName;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryName")
    private List<HangmanWord> hangmanWordList;

    public Category() {
        super();
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, String imageName) {
        this.categoryName = categoryName;
        this.imageName = imageName;
    }

    public String getCategoryName() {

        return (this.categoryName);
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @XmlTransient()
    public List<HangmanWord> getHangmanWordList() {

        return (this.hangmanWordList);
    }

    public void setHangmanWordList(List<HangmanWord> hangmanWordList) {
        this.hangmanWordList = hangmanWordList;
    }

    @Override()
    public String getKey() {

        return (this.getCategoryName());
    }

    @Override()
    public void setKey(Object key) {
        this.setCategoryName((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getCategoryName() != null)
                ? this.getCategoryName().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Category)) {

            return (false);
        }

        Category other = (Category) object;
        if (((this.getCategoryName() == null)
                && (other.getCategoryName() != null))
                || ((this.getCategoryName() != null)
                && !(this.getCategoryName().equals(other.getCategoryName())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.compumovil.ahorcatooth.model.entity.Category[ categoryName="
                + this.getCategoryName() + " ]");
    }
}