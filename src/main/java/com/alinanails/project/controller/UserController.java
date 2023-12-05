package com.alinanails.project.controller;

import com.alinanails.project.model.User;
import com.alinanails.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
     public String hello(){
        return userService.sayHello();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsersFromDb(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createNewUser (@Valid @RequestBody User user){
       return userService.createNewUser(user);
    }
    @PutMapping("{id}")
    Optional<User> updateUser (@PathVariable("id") Long id,  @RequestBody  User user){
       return userService.modifyUserById(id,user);
    }

    @DeleteMapping("{id}")
    public void deleteUser (@PathVariable("id")Long id){
        userService.deleteUserById(id);
    }
}
