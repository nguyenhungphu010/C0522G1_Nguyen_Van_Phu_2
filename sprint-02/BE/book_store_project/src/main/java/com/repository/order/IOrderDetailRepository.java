//package com.repository.order;
//
//import com.model.Order;
//import com.model.OrderDetail;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.Optional;
//
//public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Order> {
//
//    @Query(value = "select order_detail.order_id as OrderId, order_detail.quantity  as bookQuantity, books.name as " +
//            "books.price as price, order_detail.quantity * books.price as bookMoney" +
//            " from order_detail  join orders on orders.id = order_detail.order_id" +
//            " join books on books.id = order_detail.book_id" +
//            "where orders.id = :id", nativeQuery = true)
//    public Optional<OrderDetail> findOrderDetailById(Integer id);
//}
