package com.example.JWTAuthentication.Controller;

import com.example.JWTAuthentication.Models.User;
import com.example.JWTAuthentication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("Hello, World!");
        return this.userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggingUser(Principal principal){
        return principal.getName();
    }
    @PostMapping("/create-user")
    public User createNewUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
