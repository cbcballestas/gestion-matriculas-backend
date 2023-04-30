package com.cballestas.evaluacionfinal.service;

import java.util.List;

public interface ICrud<T, ID> {
    List<T> getAll() throws Exception;

    T getById(ID id) throws Exception;

    T save(T obj) throws Exception;

    T update(T obj, ID id) throws Exception;

    void delete(ID id) throws Exception;

}
