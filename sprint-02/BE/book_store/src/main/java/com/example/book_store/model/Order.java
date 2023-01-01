package com.example.book_store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @OneToMany(mappedBy = "order")
    @JsonBackReference
    List<Cart> cartList;

    public Order() {
    }

    public Order(Integer id, String payment, String dateProcess, boolean status, boolean isDelete, Shipping shipping, List<Cart> cartList) {
        this.id = id;
        this.payment = payment;
        this.dateProcess = dateProcess;
        this.status = status;
        this.isDelete = isDelete;
        this.shipping = shipping;
        this.cartList = cartList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDateProcess() {
        return dateProcess;
    }

    public void setDateProcess(String dateProcess) {
        this.dateProcess = dateProcess;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
