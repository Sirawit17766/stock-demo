package com.demo.stock.service;

import com.demo.stock.model.User;
import com.demo.stock.repository.UserRepository;
import com.demo.stock.error.MissingParameterException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserByStudentId(String studentId) {
        return repository.findByStudentId(studentId);
    }

    public void createUser(Integer id, String studentId, String firstName, String lastName) {
        if (id == null) {
            throw new MissingParameterException("id");
        }
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("studentId is required");
        }
        repository.createUser(id, studentId, firstName, lastName);
    }
}