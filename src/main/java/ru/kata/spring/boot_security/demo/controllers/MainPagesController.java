package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserDetailsServiceImpl;

import java.security.Principal;
import java.util.Optional;

@RestController
public class MainPagesController {

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public MainPagesController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/admin")
    public String adminPage(){

        return "users/admin";
    }

    @GetMapping("/user")
    public String userPage(Principal principal){
        Optional<User> user = userDetailsService.findByUsername(principal.getName());
        user.get().getId();
        return "users/user";
    }

    @GetMapping("/home")
    public String homePage(Principal principal) {
        return "home" + principal.getName();
    }


}
