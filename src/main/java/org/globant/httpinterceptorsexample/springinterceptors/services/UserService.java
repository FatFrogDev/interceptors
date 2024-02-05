package org.globant.httpinterceptorsexample.springinterceptors.services;

import java.util.Optional;

import org.globant.httpinterceptorsexample.springinterceptors.models.User;
import java.util.List;

public interface UserService {

    void save(User user);

    Optional<User> findById(Integer id);
    
    void edit(User user);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findAll();
}
