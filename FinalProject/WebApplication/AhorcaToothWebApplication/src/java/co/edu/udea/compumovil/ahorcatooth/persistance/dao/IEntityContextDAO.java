package co.edu.udea.compumovil.ahorcatooth.persistance.dao;

import co.edu.udea.compumovil.ahorcatooth.persistance.exception.AhorcaToothDatabaseException;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.IEntityContext;
import java.util.List;

public interface IEntityContextDAO {

    @SuppressWarnings(value = {"rawtypes"})
    public Long count(Class clazz) throws AhorcaToothDatabaseException;

    public IEntityContext delete(IEntityContext entityContext)
            throws AhorcaToothDatabaseException;

    public List<IEntityContext> executeNamedQuery(String namedQuery,
            String where, Object whereArg) throws AhorcaToothDatabaseException;

    @SuppressWarnings(value = {"rawtypes"})
    public Object findAll(Class clazz) throws AhorcaToothDatabaseException;

    @SuppressWarnings(value = {"rawtypes"})
    public Object findByAttributes(Class clazz, Object... attributesArgs)
            throws AhorcaToothDatabaseException;

    @SuppressWarnings(value = {"rawtypes"})
    public IEntityContext find(Class clazz, Object key)
            throws AhorcaToothDatabaseException;

    public Object save(IEntityContext entity)
            throws AhorcaToothDatabaseException;

    public IEntityContext update(IEntityContext entityContext)
            throws AhorcaToothDatabaseException;
}