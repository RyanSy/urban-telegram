package com.example.Urbantelegram.controllers;

import com.example.Urbantelegram.models.User;
import com.example.Urbantelegram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/")
    @ResponseBody
    public void createUser(@RequestBody User user){ userService.createUser(user); }

    @PostMapping("/login")
    @ResponseBody
    public User getUserByUsernameAndPassword(@RequestBody User user) {
        return userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());}

    @PutMapping
    @ResponseBody
    public void updateUser(@RequestBody User user) { userService.updateUser(user); }

    @DeleteMapping
    @ResponseBody
    public void deleteUser(@RequestBody User user) { userService.deleteUser(user); }
}
