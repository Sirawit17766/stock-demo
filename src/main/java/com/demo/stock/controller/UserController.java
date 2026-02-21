package com.demo.stock.controller;

import com.demo.stock.dto.CreateUserRequest;
import com.demo.stock.model.User;
import com.demo.stock.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // GET /users
    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    // GET /users/{studentId}
    @GetMapping("/{studentId}")
    public User getUser(@PathVariable String studentId) {
        return service.getUserByStudentId(studentId);
    }

    // POST /users
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) {
        service.createUser(
            request.getId(),
            request.getStudentId(),
            request.getFirstName(),
            request.getLastName()
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
