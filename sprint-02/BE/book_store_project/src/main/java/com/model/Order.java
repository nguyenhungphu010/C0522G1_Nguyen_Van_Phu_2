package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "payment_method")
    private String payment;

    @Column(name = "date_process")
    private String dateProcess;

    @Column(name = "status")
    private boolean status;

    @Column(name = "is_delete")
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "shipping_id", referencedColumnName = "id")
    private Shipping shipping;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_detail", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> bookList;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    public Order() {
    }

}
