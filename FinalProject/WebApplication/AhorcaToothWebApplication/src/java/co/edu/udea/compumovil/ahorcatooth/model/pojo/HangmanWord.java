package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity()
@NamedQueries({
    @NamedQuery(name = "HangmanWord.findAll",
            query = "SELECT h FROM HangmanWord h"),
    @NamedQuery(name = "HangmanWord.findById",
            query = "SELECT h FROM HangmanWord h WHERE h.id = :id"),
    @NamedQuery(name = "HangmanWord.findByWordName",
            query = "SELECT h FROM HangmanWord h WHERE h.wordName = :wordName"),
    @NamedQuery(name = "HangmanWord.findByDescription",
            query = "SELECT h FROM HangmanWord h WHERE h.description = :description")})
@Table(name = "HANGMAN_WORD")
@XmlRootElement()
public class HangmanWord implements IEntityContext, Serializable {

    private static final long serialVersionUID = 6812014168916091904L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    @Column(name = "word_name")
    private String wordName;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @JoinColumns({
        @JoinColumn(name = "category_name",
                referencedColumnName = "category_name"),
        @JoinColumn(name = "languages_iso_code",
                referencedColumnName = "languages_iso_code")})
    @ManyToOne(optional = false)
    private Category category;

    public HangmanWord() {
        super();
    }

    public HangmanWord(Long id, String wordName) {
        this.id = id;
        this.wordName = wordName;
    }

    public Long getId() {

        return (this.id);
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {

        return (this.category);
    }

    public void setCategory(Category category) {
        this.category = category;
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

        return (hash);
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