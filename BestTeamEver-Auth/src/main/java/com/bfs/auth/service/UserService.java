package com.bfs.auth.service;

import com.bfs.auth.dao.UserDAO;
import com.bfs.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User checkUser(String userName, String password) {
        return userDAO.checkUser(userName, password);
    }

}
