package com.example.demo.controllerapi;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    public User insertUserController(@RequestBody User user){
        return userService.insertUser(user);
    }

    @GetMapping("get/all")
    public List<User> getAllUsersController(){
        return userService.listUsers();
    }

    @GetMapping("get/one/{id}")
    public Optional<User> getOneUserController(@PathVariable("id") int id){
        return userService.getOneUser(id);
    }

    @DeleteMapping("delete/one/{id}")
    public  int deleteOneUserController(@PathVariable("id") int id){
        return userService.deleteOneUser(id);
    }

    @PutMapping("update/one")
    public int updateUserController(@RequestBody User userToUpdate){
        return userService.updateUser(userToUpdate);
    }

}
