package com.cballestas.evaluacionfinal.service.impl;

import com.cballestas.evaluacionfinal.dto.RoleDTO;
import com.cballestas.evaluacionfinal.model.Role;
import com.cballestas.evaluacionfinal.repository.IGenericRepo;
import com.cballestas.evaluacionfinal.repository.IRoleRepo;
import com.cballestas.evaluacionfinal.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CrudImpl<Role, RoleDTO, Integer> implements IRoleService {

    private final IRoleRepo repo;

    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    protected Class<RoleDTO> getDtoClass() {
        return RoleDTO.class;
    }
}
