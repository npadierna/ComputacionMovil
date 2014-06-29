package co.edu.udea.compumovil.ahorcatooth.persistance.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.persistance.dao.IHangmanWordDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.IEntityContext;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class HangmanWordDAOImpl extends AbstractEntityContextDAO
        implements IHangmanWordDAO {

    public HangmanWordDAOImpl() {
        super();
    }

    @Override()
    public Long count() throws AhorcaToothDatabaseException {

        return (super.count(HangmanWord.class));
    }

    @Override()
    public List<HangmanWord> executeNamedQuery(String namedQuery, String where,
            String whereArg) throws AhorcaToothDatabaseException {
        List<HangmanWord> hangmanWordsFoundList = new ArrayList<>();
        List<IEntityContext> entitesContextList = super.executeNamedQuery(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitesContextList) {
            hangmanWordsFoundList.add((HangmanWord) entityContext);
        }

        return (hangmanWordsFoundList);
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord delete(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.delete(hangmanWord));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<HangmanWord> findAll() throws AhorcaToothDatabaseException {

        return ((List<HangmanWord>) super.findAll(HangmanWord.class));
    }

    @Override()
    public HangmanWord find(Long key)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.find(HangmanWord.class, key));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<HangmanWord> findByAttributes(Object... attributesArgs)
            throws AhorcaToothDatabaseException {

        return ((List<HangmanWord>) super.findByAttributes(
                HangmanWord.class, attributesArgs));
    }

    @Override()
    public List<HangmanWord> findByCategoryName(String categoryName)
            throws AhorcaToothDatabaseException {

        return (this.findByAttributes(
                "category.categoryPK.categoryName", categoryName));
    }

    @Override()
    public List<HangmanWord> findByLanguagesIsoCode(String languagesIsoCode)
            throws AhorcaToothDatabaseException {

        return (this.findByAttributes(
                "category.categoryPK.languagesIsoCode", languagesIsoCode));
    }

    /*
     * SELECT * FROM HANGMAN_WORD AS h WHERE h.languages_iso_code = ? AND
     * h.category_name = ? ORDER BY h.id DESC LIMIT ?
     */
    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<HangmanWord> findLatestWithLimit(String categoryName,
            String languagesIsoCode, Integer amount)
            throws AhorcaToothDatabaseException {
        try {
            CriteriaBuilder criteriaBuilder = super.getEntityManager()
                    .getCriteriaBuilder();
            CriteriaQuery<HangmanWord> criteriaQuery = criteriaBuilder
                    .createQuery(HangmanWord.class);
            Root<HangmanWord> root = criteriaQuery.from(HangmanWord.class);

            criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(
                    root.get("category").get("categoryPK").get("categoryName"),
                    categoryName), criteriaBuilder.equal(root.get("category")
                    .get("categoryPK").get("languagesIsoCode"), languagesIsoCode)));
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));

            Query query = super.getEntityManager().createQuery(criteriaQuery)
                    .setMaxResults(amount.intValue());

            return ((List<HangmanWord>) query.getResultList());
        } catch (Exception ex) {
            throw new AhorcaToothDatabaseException(ex);
        }
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Long save(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((Long) super.save(hangmanWord));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord update(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.update(hangmanWord));
    }
}