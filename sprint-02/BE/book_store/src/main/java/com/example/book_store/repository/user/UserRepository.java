package com.example.book_store.repository.user;

import com.example.book_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);

    @Query(value = "SELECT username from  user where username = ?1", nativeQuery = true)
    String existsByUserName(String username);


    @Modifying
    @Transactional
    @Query(value = "update user set password =:newPassword where username =:username", nativeQuery = true)
    void saveNewPassword(@Param("newPassword") String newPassword, @Param("username") String username);

    @Query(value = "select * from user where user.username =:username", nativeQuery = true)
    Optional<User> showUsername(@Param("username") String username);

    @Query(value = "select * from user where username like %:username%", nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = " update user set password =:#{#u.password} where username =:username", nativeQuery = true)
    void saveUser(@Param("u") User user, @Param("username") String username);

    @Query(value = "select email from customers join user on user.customer_id = customers.id where user.username=:username", nativeQuery = true)
    String findEmail(@RequestParam String username);
}
