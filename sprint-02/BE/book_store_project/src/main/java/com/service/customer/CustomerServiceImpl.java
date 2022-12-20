package com.service.customer;

import com.model.Customer;
import com.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String searchName) {
        return null;
    }

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String searchName, String searchAddress) {
        return this.customerRepository.findCustomerByAll(pageable, searchName, searchAddress);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.customerRepository.deleteCustomerById(id);
        this.customerRepository.deleteUserById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }
}
