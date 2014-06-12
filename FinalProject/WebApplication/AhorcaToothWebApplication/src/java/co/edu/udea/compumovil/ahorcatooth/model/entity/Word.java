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
    @NamedQuery(name = "Word.findAll", query = "SELECT w FROM Word w"),
    @NamedQuery(name = "Word.findByWordName",
            query = "SELECT w FROM Word w WHERE w.wordName = :wordName"),
    @NamedQuery(name = "Word.findByDescription",
            query = "SELECT w FROM Word w WHERE w.description = :description")})
@Table(name = "WORD")
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement()
public class Word implements IEntityContext, Serializable {

    private static final long serialVersionUID = 5456220630421951488L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 15)
    @Column(name = "word_name")
    private String wordName;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wordName")
    private List<HangmanWord> hangmanWordList;

    public Word() {
        super();
    }

    public Word(String wordName) {
        this.wordName = wordName;
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

    @XmlTransient()
    public List<HangmanWord> getHangmanWordList() {

        return (this.hangmanWordList);
    }

    public void setHangmanWordList(List<HangmanWord> hangmanWordList) {
        this.hangmanWordList = hangmanWordList;
    }

    @Override()
    public String getKey() {

        return (this.getWordName());
    }

    @Override()
    public void setKey(Object key) {
        this.setWordName((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += ((this.getWordName() != null) ? this.getWordName().hashCode()
                : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Word)) {

            return (false);
        }

        Word other = (Word) object;
        if (((this.getWordName() == null) && (other.getWordName() != null))
                || ((this.getWordName() != null)
                && !(this.getWordName().equals(other.getWordName())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.compumovil.ahorcatooth.model.entity.Word[ wordName="
                + this.getWordName() + " ]");
    }
}