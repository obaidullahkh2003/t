package com.example.web.controllers;

import com.example.web.dtos.UserDto;
import com.example.web.models.User;
import com.example.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/auth")
    public String showAuthForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "auth";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") UserDto userDTO, Model model) {
        UserDto loggedInUser = userService.loginUser(userDTO.getUsername(), userDTO.getPassword());
        if (loggedInUser != null) {
            return "redirect:/profile";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "auth";
        }
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDto userDTO, Model model) {
        if (userService.userExists(userDTO.getUsername())) {
            model.addAttribute("registerError", "Username already exists");
            return "auth";
        }

        if (userService.emailExists(userDTO.getEmail())) {
            model.addAttribute("registerError", "Email already exists");
            return "auth";
        }

        userService.registerUser(userDTO);
        return "redirect:/auth";
    }
    @GetMapping("/users")
    public String userlist(Model model) {
        List<UserDto> users= userService.getAllUsers();
        model.addAttribute("users",users );
        return "users";
    }
}
