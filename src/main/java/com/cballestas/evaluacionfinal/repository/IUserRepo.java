package com.cballestas.evaluacionfinal.repository;

import com.cballestas.evaluacionfinal.model.User;

public interface IUserRepo extends IGenericRepo<User, Integer> {

    User findOneByUsername(String username);
}
