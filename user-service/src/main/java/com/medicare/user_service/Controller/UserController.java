package com.medicare.user_service.Controller;

import java.util.*;
import com.medicare.user_service.Model.User;
import com.medicare.user_service.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }



    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping("/user/")
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }
    @PutMapping("/user/")
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }
    @DeleteMapping("/user/{id}")
    public void createUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

}
