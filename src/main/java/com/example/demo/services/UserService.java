package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User insertUser(User user){
        return userDao.save(user);
    }

    public List<User> listUsers(){
        return userDao.findAll();
    }
}
