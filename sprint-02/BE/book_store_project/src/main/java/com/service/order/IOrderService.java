package com.service.order;

import com.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrderService {

    Page<Order> findAllOrder(Pageable pageable, String searchDate, Integer customerId );

    Optional<Order> findOrderById(Integer id);

    void saveOrder(Order order);

}
