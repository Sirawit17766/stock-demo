package com.demo.stock.model;

public class User {
    private String studentId;
    private String firstName;
    private String lastName;

    public User(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}