package com.jobayed.customsecurity.employee.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Map;

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
}
