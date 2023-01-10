package com.example.contact.controller;

import com.example.contact.entity.User;
import com.example.contact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get_all")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/get_id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        if (id == null) {
            throw new RuntimeException("id cannot be null");
        }
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        if (user == null) {
            throw new RuntimeException("user cannot be null");
        }
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
        if (user == null) {
            throw new RuntimeException("User cannot be null");
        }
        if (id == null) throw new RuntimeException("id cannot be null");
        return ResponseEntity.ok(userService.updateUser(user, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        if (id == null) {
            throw new RuntimeException("id cannot be null");
        }
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
