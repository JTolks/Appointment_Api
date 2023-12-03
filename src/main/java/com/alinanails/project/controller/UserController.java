package com.alinanails.project.controller;

import com.alinanails.project.model.User;
import com.alinanails.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
     public String hello(){
        return userService.sayHello();
    }

    @GetMapping("user/{userId}")
    public User getUserById(@PathVariable("userId") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsersFromDb(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createNewUser (@Valid @RequestBody User user){
       return userService.createNewUser(user);
    }
    @PutMapping("user/{userId}")
    Optional<User> updateUser (@PathVariable("userId") Long id,  @RequestBody  User user){
       return userService.modifyUserById(id,user);
    }

    @DeleteMapping(path = "/user/{userId}")
    void deleteUser (@PathVariable("userId")Long id){
        userService.deleteUserById(id);
    }
}
