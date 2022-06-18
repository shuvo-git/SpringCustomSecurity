package com.jobayed.customsecurity.employee.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

public interface IBaseRepository {
    <T> void save(T t);
    <T> void save(String sql, Map<String, Object> params,Class<T> entity);
}
