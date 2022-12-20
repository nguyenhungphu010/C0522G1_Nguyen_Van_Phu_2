package com.service.order;

import com.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class IOrderServiceImpl implements IOrderService{

    @Override
    public Page<Order> findAllOrder(Pageable pageable, String searchDate, Integer customerId) {
        return null;
    }

    @Override
    public Optional<Order> findOrderById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveOrder(Order order) {

    }
}
