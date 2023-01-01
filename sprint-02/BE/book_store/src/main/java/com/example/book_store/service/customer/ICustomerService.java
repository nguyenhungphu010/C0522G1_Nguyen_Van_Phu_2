package com.example.book_store.service.customer;

import com.example.book_store.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable, String searchName);

    Page<Customer> findAllCustomer(Pageable pageable, String searchName, String searchAddress);

    Optional<Customer> findById(Integer id);

    void deleteById(Integer id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
