package com.example.book_store.controller;

import com.example.book_store.model.Cart;
import com.example.book_store.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("")
    public ResponseEntity<List<Cart>> getCart(@RequestParam(value = "username", defaultValue = "") String username) {
        List<Cart> cartList = this.cartService.getCartList(username);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveCart(@RequestBody Cart cart) {
        this.cartService.saveCart(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteCart(@RequestBody Cart cart) {
        this.cartService.deleteCart(cart.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartById(@PathVariable Integer id) {
        this.cartService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update-all")
    public ResponseEntity<Void> updateAll(@RequestBody List<Cart> cartList) {
        this.cartService.updateCartList(cartList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/pay")
    public ResponseEntity<Void> updateCart(@RequestBody List<Cart> selectedCarts) {
        this.cartService.payCart(selectedCarts);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
