package com.example.book_store.service.order;

import com.example.book_store.model.Order;
import com.example.book_store.repository.order.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Page<Order> findAllOrder(Pageable pageable, String searchDate, Integer customerId) {
        return null;
    }

    @Override
    public Optional<Order> findOrderById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAllOrder() {
        return this.orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public Integer findMaxOrderId() {
        return this.orderRepository.findMaxOrderId();
    }
}
