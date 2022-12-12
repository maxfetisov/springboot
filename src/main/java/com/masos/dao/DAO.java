package com.masos.dao;

import java.util.List;

public interface DAO<T, E> {
    void create(T entity);
    List<T> getAll();
    T getById(E id);
    void update(T entity);
    void delete(E id);
}
