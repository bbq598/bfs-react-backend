package com.bfs.authserver.repository;

import com.bfs.authserver.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsernameAndAndPassword(String username, String password);
    User findFirst1ByUsername(String username);
}

