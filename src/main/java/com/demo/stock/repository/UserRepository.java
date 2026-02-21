package com.demo.stock.repository;

import com.demo.stock.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        String sql = "SELECT student_id, first_name, last_name FROM users";
        return jdbcTemplate.query(
            sql,
            (rs, rowNum) -> new User(
                rs.getString("student_id"),
                rs.getString("first_name"),
                rs.getString("last_name")
            )
        );
    }

    public User findByStudentId(String studentId) {
    String sql = "SELECT student_id, first_name, last_name FROM users WHERE student_id = ?";

    return jdbcTemplate.queryForObject(
        sql,
        (rs, rowNum) -> new User(
            rs.getString("student_id"),
            rs.getString("first_name"),
            rs.getString("last_name")
        ),
        studentId
    );
    }

    public int createUser(Integer id, String studentId, String firstName, String lastName) {
    String sql = "INSERT INTO users (id, student_id, first_name, last_name) VALUES (?, ?, ?, ?)";
    return jdbcTemplate.update(sql, id, studentId, firstName, lastName);
    }
}