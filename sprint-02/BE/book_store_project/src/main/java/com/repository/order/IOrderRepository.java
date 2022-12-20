package com.repository.order;

import com.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository {

    @Query(value = "select * from orders where customer_id =:id and date_prcess = %:searchDate%", nativeQuery = true,
    countQuery = "select count(*) from (select * from orders where customer_id =:id and date_prcess = %:searchDate%) orders")
    public Page<Order> findAllOrder (Pageable pageable, String searchDate, Integer id );

}
