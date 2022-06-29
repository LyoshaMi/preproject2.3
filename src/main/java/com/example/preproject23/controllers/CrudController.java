package com.example.preproject23.controllers;

import com.example.preproject23.models.User;
import com.example.preproject23.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class CrudController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String findAll(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("AllUsers",users);
        return "all-show1";
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user-show";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "new-user";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable("id")Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "update-user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id){
        User user1 = userService.getUser(id);
        userService.addUser(user1);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
