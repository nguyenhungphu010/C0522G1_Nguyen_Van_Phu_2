package com.service.user.impl;

import com.model.User;
import com.repository.user.UserRepository;
import com.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String existsByUserName(String username) {
        return this.userRepository.existsByUserName(username);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findByUsername(String name) {
        return this.userRepository.findByUsername(name);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.saveNewPassword(encodedPassword, user.getUsername());
    }

    @Override
    public void saveCreateGmail(User user) {
        this.userRepository.save(user);
    }

    @Override
    public Optional<User> showUsername(String username) {
        return this.userRepository.showUsername(username);
    }

    @Override
    public void updateUser(User user, String username) {
        this.userRepository.saveUser(user, username);
    }
}
