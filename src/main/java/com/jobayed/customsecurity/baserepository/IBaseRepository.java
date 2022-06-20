package com.jobayed.customsecurity.baserepository;

import com.jobayed.customsecurity.employee.model.Employee;

import java.util.List;
import java.util.Map;

public interface IBaseRepository {
    <T> void save(T t);
    <T> void save(String sql, Map<String, Object> params,Class<T> entity);


    /***
     * 
     * @param sql
     * @param params
     * @return
     * @param <T>
     */
    public <T> T findOneById(String sql, Map<String, Object> params);

    /***
     * Loads Sub-entity in a single query like FetchType.Eager
     * @param id
     * @param entity
     * @return
     * @param <T>
     */
    public <T> T findByIdDynamicEntityGraph(String id, Class<T> entity);

    /***
     *
     * @param entity
     * @param id
     * @return
     * @param <T>
     * @param <E>
     */
    public <T,E> T findByIdLazy(Class<T> entity, E id);

    /***
     *
     * @param queryStr
     * @param entity
     * @return
     * @param <T>
     */
    public <T> List<T> getAllByNamedNAtiveQuery(String queryStr, Class<T> entity);

}
