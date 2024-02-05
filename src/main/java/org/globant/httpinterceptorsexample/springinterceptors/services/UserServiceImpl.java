package org.globant.httpinterceptorsexample.springinterceptors.services;

import java.util.Optional;
import java.util.List;

import org.globant.httpinterceptorsexample.springinterceptors.models.User;
import org.globant.httpinterceptorsexample.springinterceptors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    };

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
