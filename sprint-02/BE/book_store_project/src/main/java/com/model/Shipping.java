package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String method;

    private Double price;

    @OneToMany(mappedBy = "shipping")
    @JsonBackReference
    private List<Order> orderList = new ArrayList<>();

    public Shipping() {
    }

    public Shipping(Integer id, String method, Double price, List<Order> orderList) {
        this.id = id;
        this.method = method;
        this.price = price;
        this.orderList = orderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
