package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getOneUser(int id){
        return userDao.findById(id);
    }

    public int deleteOneUser(int id){
        try{
            userDao.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateUser(User userToUpdate){
        int idOfUserToUpdate = userToUpdate.getId();
        User existingUser = userDao.findById(idOfUserToUpdate).orElse(null);
        if(existingUser.equals(null)){
            return 0;
        }
        else{
            existingUser.setName(userToUpdate.getName());
            existingUser.setEmail(userToUpdate.getEmail());
            existingUser.setPhone(userToUpdate.getPhone());
            userDao.save(existingUser);
            return 1;
        }
    }
}
