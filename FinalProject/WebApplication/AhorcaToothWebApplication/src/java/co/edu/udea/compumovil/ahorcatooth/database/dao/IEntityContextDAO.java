package co.edu.udea.compumovil.ahorcatooth.database.dao;

import co.edu.udea.compumovil.ahorcatooth.database.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.entity.IEntityContext;
import java.util.List;

public interface IEntityContextDAO {

    @SuppressWarnings(value = {"rawtypes"})
    public Long countEntities(Class clazz);

    public IEntityContext deleteEntity(IEntityContext entityContext)
            throws AhorcaToothDatabaseException;

    public List<IEntityContext> executeNamedQueryForEntities(String namedQuery,
            String where, Object whereArg) throws AhorcaToothDatabaseException;

    @SuppressWarnings(value = {"rawtypes"})
    public Object findAllEntities(Class clazz)
            throws AhorcaToothDatabaseException;

    @SuppressWarnings(value = {"rawtypes"})
    public Object findEntitiesByAttributes(Class clazz,
            Object... attributesArgs) throws AhorcaToothDatabaseException;

    @SuppressWarnings(value = {"rawtypes"})
    public IEntityContext findEntity(Class clazz, Object key)
            throws AhorcaToothDatabaseException;

    public Object saveEntity(IEntityContext entity)
            throws AhorcaToothDatabaseException;

    public IEntityContext updateEntity(IEntityContext entityContext)
            throws AhorcaToothDatabaseException;
}