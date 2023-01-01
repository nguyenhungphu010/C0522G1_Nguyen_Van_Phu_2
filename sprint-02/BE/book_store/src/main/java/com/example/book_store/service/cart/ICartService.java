package com.example.book_store.service.cart;

import com.example.book_store.model.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICartService {
    List<Cart> getCartList(String username);

    void saveCart(Cart cart);

    void deleteCart(Integer id);

    void updateCartList(List<Cart> cartList);

    Cart findByUserIdAndBookId(Integer userId, Integer bookId);

    void payCart(List<Cart> selectedCarts);
}
