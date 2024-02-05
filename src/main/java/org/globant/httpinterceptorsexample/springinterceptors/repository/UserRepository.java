package org.globant.httpinterceptorsexample.springinterceptors.repository;

import org.globant.httpinterceptorsexample.springinterceptors.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findById(Integer id);

    Optional<User> findByEmailAndPassword(String email, String password);
}
