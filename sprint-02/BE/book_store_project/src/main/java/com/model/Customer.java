package com.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "day_of_birth")
    private String dayOfBirth;
    private String email;
    private Integer gender;
    private String address;
    @Column(name = "is_delete")
    private boolean isDelete;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Customer() {
    }

    public Customer(Integer id, String name, String phoneNumber, String dayOfBirth, String email, Integer gender,
                    String address, boolean isDelete, User user) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.isDelete = isDelete;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
