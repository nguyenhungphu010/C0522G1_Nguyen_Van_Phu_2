package com.example.book_store.controller;

import com.example.book_store.model.Order;
import com.example.book_store.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveOrder(@RequestBody Order order) {
        this.orderService.saveOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> orderList = this.orderService.findAllOrder();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/max-id")
    public ResponseEntity<Integer> getMaxId() {
        Integer maxId = this.orderService.findMaxOrderId();
        return new ResponseEntity<>(maxId, HttpStatus.OK);
    }
}
