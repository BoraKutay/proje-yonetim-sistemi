
package com.example.crud_example.controller;

import com.example.crud_example.model.User;
import com.example.crud_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Giriş ekranında gerekli olan mappingler
/*
 * login -> login ekranına yönlendirir.
 * saveUser -> partner service ile kayıt işlemi
 * newUser -> kayıt işlemi
 * */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/newUser")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){

        userService.saveUser(user);

        return"redirect:/";
    }



}
