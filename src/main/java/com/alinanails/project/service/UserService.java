package com.alinanails.project.service;

import com.alinanails.project.model.User;
import com.alinanails.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String sayHello() {
        return "Hello Appointment API";
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .filter(user -> user.getUserId().equals(id))
                .orElseThrow(() -> new IllegalStateException("User by this id " + id + " not found"));
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();

    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> modifyUserById(Long id, User user) {
        return userRepository.findById(id)
                .filter(u ->
                        u.getUserId().equals(id))
                .map(user1 -> {
                    user1.setEmail(user.getEmail());
                    user1.setPhoneNumber(user.getPhoneNumber());
                    user1.setPassword(user.getPassword());
                    return userRepository.save(user1);
                });
    }
}
