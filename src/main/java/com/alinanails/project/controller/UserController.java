package com.alinanails.project.controller;

import com.alinanails.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @GetMapping
     public User sayHello(){
        return new User(1L, "26395758","yevgeniy.tolks@gmail.com");
    }
}
