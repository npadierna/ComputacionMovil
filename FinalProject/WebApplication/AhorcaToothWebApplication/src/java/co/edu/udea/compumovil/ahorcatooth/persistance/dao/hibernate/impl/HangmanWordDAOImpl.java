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
public class HangmanWordDAOImpl extends AbstractEntityContext
        implements IHangmanWordDAO {

    public HangmanWordDAOImpl() {
        super();
    }

    @Override()
    public Long countHangmansWords() {

        return (super.countEntities(HangmanWord.class));
    }

    @Override()
    public List<HangmanWord> executeNamedQueryForHangmansWords(String namedQuery,
            String where, String whereArg) throws AhorcaToothDatabaseException {
        List<HangmanWord> hangmanWordsFoundList = new ArrayList<>();
        List<IEntityContext> entitesContextList = super.executeNamedQueryForEntities(
                namedQuery, where, whereArg);

        for (IEntityContext entityContext : entitesContextList) {
            hangmanWordsFoundList.add((HangmanWord) entityContext);
        }

        return (hangmanWordsFoundList);
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord deleteHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.deleteEntity(hangmanWord));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<HangmanWord> findAllHangmansWords()
            throws AhorcaToothDatabaseException {

        return ((List<HangmanWord>) super.findAllEntities(HangmanWord.class));
    }

    @Override()
    public HangmanWord findHangmanWord(Long key)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.findEntity(HangmanWord.class, key));
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<HangmanWord> findHangmansWordsByAttributes(
            Object... attributesArgs) throws AhorcaToothDatabaseException {

        return ((List<HangmanWord>) super.findEntitiesByAttributes(
                HangmanWord.class, attributesArgs));
    }

    @Override()
    public List<HangmanWord> findHangmansWordsByCategoryName(
            String categoryName) throws AhorcaToothDatabaseException {

        return (this.findHangmansWordsByAttributes(
                "category.categoryPK.categoryName", categoryName));
    }

    @Override()
    public List<HangmanWord> findHangmansWordsByLanguagesIsoCode(
            String languagesIsoCode) throws AhorcaToothDatabaseException {

        return (this.findHangmansWordsByAttributes(
                "category.categoryPK.languagesIsoCode", languagesIsoCode));
    }

    /**
     *
     * SELECT * FROM HANGMAN_WORD AS h WHERE h.languages_iso_code = ? AND
     * h.category_name = ? ORDER BY h.id DESC LIMIT ?
     *
     * @param categoryName
     * @param languagesIsoCode
     * @param amount
     * @return
     * @throws AhorcaToothDatabaseException
     */
    @Override()
    public List<HangmanWord> findLastestHangmansWords(String categoryName,
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
    public Long saveHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((Long) super.saveEntity(hangmanWord));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public HangmanWord updateHangmanWord(HangmanWord hangmanWord)
            throws AhorcaToothDatabaseException {

        return ((HangmanWord) super.updateEntity(hangmanWord));
    }
}