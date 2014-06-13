package co.edu.udea.compumovil.ahorcatooth.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable()
public class CategoryPK implements Serializable {

    private static final long serialVersionUID = 4154606141448857600L;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 3)
    @Column(name = "languages_iso_code")
    private String languagesIsoCode;

    public CategoryPK() {
        super();
    }

    public CategoryPK(String categoryName, String languagesIsoCode) {
        this.categoryName = categoryName;
        this.languagesIsoCode = languagesIsoCode;
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

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getCategoryName() != null)
                ? this.getCategoryName().hashCode() : 0);
        hash += ((this.getLanguagesIsoCode() != null)
                ? this.getLanguagesIsoCode().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof CategoryPK)) {

            return (false);
        }

        CategoryPK other = (CategoryPK) object;
        if (((this.getCategoryName() == null)
                && (other.getCategoryName() != null))
                || ((this.getCategoryName() != null)
                && !(this.getCategoryName().equals(other.getCategoryName())))) {

            return (false);
        }

        if (((this.getLanguagesIsoCode() == null)
                && (other.getLanguagesIsoCode() != null))
                || ((this.getLanguagesIsoCode() != null)
                && !(this.getLanguagesIsoCode().equals(
                other.getLanguagesIsoCode())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.compumovil.ahorcatooth.model.entity.CategoryPK[ categoryName="
                + this.getCategoryName() + ", languagesIsoCode="
                + this.getLanguagesIsoCode() + " ]");
    }
}