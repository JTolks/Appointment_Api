package com.alinanails.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import java.util.List;

@Entity
public class User {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Phone number must not be empty")
    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @NotBlank
    @Email()
    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    private Role role;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    public User(Long userId, String phoneNumber, String email, String password) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
