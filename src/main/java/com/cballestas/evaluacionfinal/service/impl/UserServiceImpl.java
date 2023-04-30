package com.cballestas.evaluacionfinal.service.impl;

import com.cballestas.evaluacionfinal.dto.UserDTO;
import com.cballestas.evaluacionfinal.model.User;
import com.cballestas.evaluacionfinal.repository.IGenericRepo;
import com.cballestas.evaluacionfinal.repository.IUserRepo;
import com.cballestas.evaluacionfinal.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CrudImpl<User, UserDTO, Integer> implements IUserService {

    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserDTO> getDtoClass() {
        return UserDTO.class;
    }
}
