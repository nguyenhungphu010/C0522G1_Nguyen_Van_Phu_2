package com.example.book_store.repository.order;

import com.example.book_store.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where customer_id =:id and date_prcess = %:searchDate%", nativeQuery = true,
            countQuery = "select count(*) from (select * from orders where customer_id =:id and date_prcess = %:searchDate%) orders")
    public Page<Order> findAllOrder(Pageable pageable, String searchDate, Integer id);

    @Query(value = "select max(id) from orders where status = 0", nativeQuery = true)
    public Integer findMaxOrderId();
}
