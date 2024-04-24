package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserDetailsServiceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class MainPagesController {

    private UserDetailsServiceImpl userDetailsServiceImpl;
    private UserRepository userRepository;

    @Autowired
    public MainPagesController(UserDetailsServiceImpl userDetailsServiceImpl, UserRepository userRepository) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "/admin/users/admin";
        } else {
            // Обработайте ошибку (пользователь не найден)
            return "error"; // Или перенаправьте на другую страницу
        }
    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "/admin/users/user";
        } else {
            // Обработайте ошибку (пользователь не найден)
            return "error"; // Или перенаправьте на другую страницу
        }
    }

}
