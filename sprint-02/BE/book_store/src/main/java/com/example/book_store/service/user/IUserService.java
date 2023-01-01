package com.example.book_store.service.user;

import com.example.book_store.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    String existsByUserName(String username);

    Optional<User> findUserByUsername(String username);

    List<User> findAll();

    User findByUsername(String name);

    void updatePassword(User user, String newPassword);

    void saveCreateGmail(User user);

    Optional<User> showUsername(String username);

    void updateUser(User user, String username);

    String getCustomerEmail(String username);
}
