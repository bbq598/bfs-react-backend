package com.bfs.authserver.service;


import com.bfs.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkUser(String userName, String password) {
        return userRepository.existsByUsernameAndAndPassword(userName, password);
    }

}
