package org.kk.tirelist.api;

import org.apache.catalina.User;
import org.kk.tirelist.model.UserModel;
import org.kk.tirelist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void createUser(@Validated @NonNull @RequestBody UserModel user) {
        userService.createUser(user);
    }
    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(path = "{id}")
    public UserModel getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") int id, @Validated @NonNull @RequestBody UserModel newUser) {
        userService.updateUser(id, newUser);
    }
}
