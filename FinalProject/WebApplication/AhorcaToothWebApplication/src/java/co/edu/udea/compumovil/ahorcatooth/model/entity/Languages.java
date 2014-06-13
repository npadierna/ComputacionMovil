package co.edu.udea.compumovil.ahorcatooth.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity()
@NamedQueries({
    @NamedQuery(name = "Languages.findAll", query = "SELECT l FROM Languages l"),
    @NamedQuery(name = "Languages.findByIsoCode",
            query = "SELECT l FROM Languages l WHERE l.isoCode = :isoCode"),
    @NamedQuery(name = "Languages.findByTongue",
            query = "SELECT l FROM Languages l WHERE l.tongue = :tongue"),
    @NamedQuery(name = "Languages.findByDescription",
            query = "SELECT l FROM Languages l WHERE l.description = :description")})
@Table(name = "LANGUAGES")
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement()
public class Languages implements IEntityContext, Serializable {

    private static final long serialVersionUID = 1880614879702762208L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 3)
    @Column(name = "iso_code")
    private String isoCode;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "tongue")
    private String tongue;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "languages")
    private Category category;

    public Languages() {
        super();
    }

    public Languages(String isoCode) {
        this.isoCode = isoCode;
    }

    public Languages(String isoCode, String tongue) {
        this.isoCode = isoCode;
        this.tongue = tongue;
    }

    public String getIsoCode() {

        return (this.isoCode);
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getTongue() {

        return (this.tongue);
    }

    public void setTongue(String tongue) {
        this.tongue = tongue;
    }

    public String getDescription() {

        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {

        return (this.category);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override()
    public String getKey() {

        return (this.getIsoCode());
    }

    @Override()
    public void setKey(Object key) {
        this.setIsoCode((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getIsoCode() != null) ? this.getIsoCode().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Languages)) {

            return (false);
        }

        Languages other = (Languages) object;
        if (((this.getIsoCode() == null) && (other.getIsoCode() != null))
                || ((this.getIsoCode() != null)
                && !(this.getIsoCode().equals(other.getIsoCode())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.compumovil.ahorcatooth.model.entity.Languages[ isoCode="
                + this.getIsoCode() + " ]");
    }
}