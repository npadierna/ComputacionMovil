package co.edu.udea.compumovil.ahorcatooth.persistance.dao.hibernate.impl;

import co.edu.udea.compumovil.ahorcatooth.persistance.dao.IEntityContextDAO;
import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.IEntityContext;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AbstractEntityContext implements IEntityContextDAO {

    @PersistenceContext(unitName = "AhorcaToothWebApplicationPU")
    protected EntityManager entityManager;

    public AbstractEntityContext() {
        super();
    }

    public EntityManager getEntityManager() {

        return (this.entityManager);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    public Long countEntities(Class clazz) {
        CriteriaQuery criteriaQuery = this.getEntityManager()
                .getCriteriaBuilder().createQuery();
        Root<IEntityContext> root = criteriaQuery.from(clazz);
        criteriaQuery.select(this.getEntityManager().getCriteriaBuilder()
                .count(root));
        Query query = this.getEntityManager().createQuery(criteriaQuery);

        return ((Long) query.getSingleResult());
    }

    @Override()
    public IEntityContext deleteEntity(IEntityContext entity)
            throws AhorcaToothDatabaseException {
        IEntityContext found = null;

        try {
            found = this.findEntity(entity.getClass(),
                    entity.getKey());
            this.getEntityManager().remove(found);
        } catch (Exception e) {
            throw new AhorcaToothDatabaseException(
                    "Fatal error while the DAO was trying delete a entity", e);
        } finally {
            this.getEntityManager().flush();
        }

        return (found);
    }

    @Override()
    @SuppressWarnings(value = {"unchecked"})
    public List<IEntityContext> executeNamedQueryForEntities(String namedQuery,
            String where, Object whereArg) throws AhorcaToothDatabaseException {
        List<IEntityContext> resultList = null;

        try {
            Query query = this.getEntityManager().createNamedQuery(namedQuery);
            query.setParameter(where, whereArg);
            resultList = query.getResultList();
        } catch (Exception e) {
            throw new AhorcaToothDatabaseException(
                    "Fatal error while the DAO was trying to execute the named query.",
                    e);
        }

        return (resultList);
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    public Object findAllEntities(Class clazz)
            throws AhorcaToothDatabaseException {
        Query query;
        List<IEntityContext> entities = null;

        try {
            query = this.getEntityManager().createQuery("FROM "
                    + clazz.getSimpleName());
            entities = (List<IEntityContext>) query.getResultList();
        } catch (Exception e) {
            throw new AhorcaToothDatabaseException(
                    "Fatal error while the DAO was trying to recover a list of entities from Database",
                    e);
        }

        return (entities);
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes"})
    public Object findEntitiesByAttributes(Class clazz,
            Object... attributesArgs) throws AhorcaToothDatabaseException {
        if (attributesArgs.length % 2 != 0) {
            throw new AhorcaToothDatabaseException(String.format("%s: %d",
                    "The number of the arguments for attributes is incorrect: ",
                    attributesArgs.length));
        }

        StringBuilder queryDetail = new StringBuilder();
        for (int pos = 0; pos < attributesArgs.length; pos += 2) {
            if (pos >= 2) {
                queryDetail.append(" AND ");
            } else {
                queryDetail.append(" WHERE ");
            }

            queryDetail.append("o.").append(attributesArgs[pos]);
            if (attributesArgs[pos + 1] instanceof Boolean) {
                queryDetail.append(" = :");
            } else {
                queryDetail.append(" LIKE :");
            }
            queryDetail.append(this.removeDot((String) attributesArgs[pos]));
        }

        Query query = this.getEntityManager().createQuery("FROM "
                + clazz.getSimpleName() + " AS o" + queryDetail.toString());

        for (int pos = 0; pos < attributesArgs.length; pos += 2) {
            query.setParameter(this.removeDot((String) attributesArgs[pos]),
                    attributesArgs[pos + 1]);
        }

        return (query.getResultList());
    }

    @Override()
    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    public IEntityContext findEntity(Class clazz, Object key)
            throws AhorcaToothDatabaseException {
        IEntityContext entity = null;

        try {
            entity = (IEntityContext) this.getEntityManager().find(clazz, key);
        } catch (Exception e) {
            throw new AhorcaToothDatabaseException(
                    "Fatal error while the DAO was trying to find or search an entity.",
                    e);
        }

        return (entity);
    }

    @Override()
    public Object saveEntity(IEntityContext entity)
            throws AhorcaToothDatabaseException {
        try {
            this.getEntityManager().persist(entity);
            this.getEntityManager().flush();
        } catch (Exception e) {
            throw new AhorcaToothDatabaseException(
                    "Fatal error while the DAO was trying to persist or save a entity.",
                    e);
        }

        return (entity.getKey());
    }

    @Override()
    public IEntityContext updateEntity(IEntityContext entityContext)
            throws AhorcaToothDatabaseException {
        try {
            this.getEntityManager().merge(entityContext);
        } catch (Exception e) {
            throw new AhorcaToothDatabaseException(
                    "Fatal error while the DAO was trying to update or refresh a entity.",
                    e);
        } finally {
            this.getEntityManager().flush();
        }

        return (entityContext);
    }

    private String removeDot(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        int index = stringBuilder.indexOf(".");

        while (index > -1) {
            stringBuilder.deleteCharAt(index);
            index = stringBuilder.indexOf(".");
        }

        return (stringBuilder.toString());
    }
}