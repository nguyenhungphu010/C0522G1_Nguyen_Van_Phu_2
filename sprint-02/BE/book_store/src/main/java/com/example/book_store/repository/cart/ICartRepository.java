package com.example.book_store.repository.cart;

import com.example.book_store.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "select cart.id, cart.status, cart.book_id, cart.user_id, cart.quantity, cart.order_id from cart join user on user.id = cart.user_id where user.username = ?1 and cart.status = false order by cart.id desc", nativeQuery = true)
    List<Cart> findByUser(String username);

    Cart findByUser_IdAndBook_IdAndStatus(Integer userId, Integer bookId, boolean status);

    @Modifying
    @Transactional
    @Query(value = "update cart set status = true where id =?1", nativeQuery = true)
    void changeCartStatus(Integer id);
}
