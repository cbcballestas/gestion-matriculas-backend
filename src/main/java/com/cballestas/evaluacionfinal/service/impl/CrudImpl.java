package com.cballestas.evaluacionfinal.service.impl;

import com.cballestas.evaluacionfinal.exception.ModelNotFoundException;
import com.cballestas.evaluacionfinal.repository.IGenericRepo;
import com.cballestas.evaluacionfinal.service.ICrud;
import com.cballestas.evaluacionfinal.util.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class CrudImpl<T, S, ID> implements ICrud<S, ID> {

    @Autowired
    private CommonMapper mapper;

    protected abstract IGenericRepo<T, ID> getRepo();

    protected abstract Class<T> getEntityClass();

    protected abstract Class<S> getDtoClass();

    @Override
    public List<S> getAll() throws Exception {
        return getRepo().findAll()
                .stream()
                .map(obj -> mapper.convertToDto(obj, getDtoClass()))
                .toList();
    }

    @Override
    public S getById(ID id) throws Exception {
       T entity = getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoundException(String.format("ID DOES NOT EXISTS: %d", id)));
        return mapper.convertToDto(entity, getDtoClass());
    }

    @Override
    @Transactional
    public S save(S obj) throws Exception {
        T entity = mapper.convertToEntity(obj, getEntityClass());
        return mapper.convertToDto(getRepo().save(entity), getDtoClass());
    }

    @Override
    @Transactional
    public S update(S obj, ID id) throws Exception {
        getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoundException(String.format("ID DOES NOT EXISTS: %d", id)));
        T entity = mapper.convertToEntity(obj, getEntityClass());
        return mapper.convertToDto(getRepo().save(entity), getDtoClass());
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoundException(String.format("ID DOES NOT EXISTS: %d", id)));
        getRepo().deleteById(id);
    }

}
