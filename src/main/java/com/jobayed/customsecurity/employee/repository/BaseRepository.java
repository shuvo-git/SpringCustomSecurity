package com.jobayed.customsecurity.employee.repository;

import com.jobayed.customsecurity.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BaseRepository implements IBaseRepository {

    private final EntityManager em;

    @Override
    @Transactional
    public <T> void save(T t) {
        em.persist(t);
    }

    @Override
    @Transactional
    public <T> void save(String sql, Map<String, Object> params, Class<T> entity){
        Query query = em.createNativeQuery(sql,entity);

        if(params !=null && params.size()>0){
            params.forEach((k,v)->query.setParameter(k,v));
        }

        query.executeUpdate();
    }

    @Override
    @Transactional
    public <T> T findOneById(String sql, Map<String, Object> params){
        Query query = em.createNativeQuery(sql);

        if(params !=null && params.size()>0){
            params.forEach((k,v)->query.setParameter(k,v));
        }

        query.setFirstResult(0).setMaxResults(1);
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException ne) {
            return null;
        }
    }

    @Override
    @Transactional
    public <T> T findByIdDynamicEntityGraph(String id, Class<T> entity){
        EntityGraph graph = this.em.createEntityGraph(entity);
        Subgraph itemGraph = graph.addSubgraph("designationId");

        Map hints = new HashMap();
        hints.put("javax.persistence.loadgraph", graph);

        T t = (T) this.em.find(entity, id, hints);

        return t;
    }

    @Override
    @Transactional
    public <T> T findByIdLazy(Class<T> entity, String id){

        T t = em.find(entity,id);
        if(!Hibernate.isPropertyInitialized(t,"designationId"))
            Hibernate.initialize(t);
        System.out.println(t);

        return t;
    }


}
