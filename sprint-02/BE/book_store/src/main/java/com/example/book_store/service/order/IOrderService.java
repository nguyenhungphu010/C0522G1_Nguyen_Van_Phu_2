package com.example.book_store.service.order;

import com.example.book_store.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Page<Order> findAllOrder(Pageable pageable, String searchDate, Integer orderId);

    Optional<Order> findOrderById(Integer id);

    List<Order> findAllOrder();

    void saveOrder(Order order);

    Integer findMaxOrderId();
}
