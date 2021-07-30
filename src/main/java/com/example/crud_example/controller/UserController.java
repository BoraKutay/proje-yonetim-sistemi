
package com.example.crud_example.controller;

import com.example.crud_example.model.User;
import com.example.crud_example.service.ProjectService;
import com.example.crud_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    //kullanıcı listesini görüntüleme
    @GetMapping("/users")
    public String viewUserPage(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";
    }


    @PostMapping("/saveUserAdmin")
    public String saveUser(@ModelAttribute("user") User user){
        //kullanıcı kayıt veritabanına

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model){
        //servisten user'a erişim
        User user = userService.getUserById(id);

        model.addAttribute("user",user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") int id){
        //user sil
        this.userService.deleteUserById(id);
        return "redirect:/users";
    }



}


