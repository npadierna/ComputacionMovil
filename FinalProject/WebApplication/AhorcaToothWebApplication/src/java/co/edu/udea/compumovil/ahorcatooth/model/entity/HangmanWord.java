package co.edu.udea.compumovil.ahorcatooth.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity()
@NamedQueries({
    @NamedQuery(name = "HangmanWord.findAll",
            query = "SELECT h FROM HangmanWord h"),
    @NamedQuery(name = "HangmanWord.findById",
            query = "SELECT h FROM HangmanWord h WHERE h.id = :id")})
@Table(name = "HANGMAN_WORD")
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement()
public class HangmanWord implements IEntityContext, Serializable {

    private static final long serialVersionUID = 6812014168916091904L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "category_name", referencedColumnName = "category_name")
    @ManyToOne(optional = false)
    private Category categoryName;
    @JoinColumn(name = "word_name", referencedColumnName = "word_name")
    @ManyToOne(optional = false)
    private Word wordName;
    @JoinColumn(name = "iso_code", referencedColumnName = "iso_code")
    @ManyToOne(optional = false)
    private Languages isoCode;

    public HangmanWord() {
        super();
    }

    public HangmanWord(Long id) {
        this.id = id;
    }

    public Long getId() {

        return (this.id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategoryName() {

        return (this.categoryName);
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

    public Word getWordName() {

        return (this.wordName);
    }

    public void setWordName(Word wordName) {
        this.wordName = wordName;
    }

    public Languages getIsoCode() {

        return (this.isoCode);
    }

    public void setIsoCode(Languages isoCode) {
        this.isoCode = isoCode;
    }

    @Override()
    public Long getKey() {

        return (this.getId());
    }

    @Override()
    public void setKey(Object key) {
        this.setId((Long) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getId() != null) ? this.getId().hashCode() : 0);

        return hash;
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof HangmanWord)) {

            return (false);
        }

        HangmanWord other = (HangmanWord) object;
        if (((this.getId() == null) && (other.getId() != null))
                || ((this.getId() != null)
                && !(this.getId().equals(other.getId())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.compumovil.ahorcatooth.model.entity.HangmanWord[ id="
                + this.getId() + " ]");
    }
}