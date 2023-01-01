package com.example.book_store.controller;

import com.example.book_store.dto.CustomerDto;
import com.example.book_store.model.Customer;
import com.example.book_store.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getAll(@PageableDefault(size = 5) Pageable pageable,
                                                 @RequestParam(value = "name", defaultValue = "") String searchName,
                                                 @RequestParam(value = "address", defaultValue = "") String searchAddress) {
        Page<Customer> customerPage = this.customerService.findAllCustomer(pageable, searchName, searchAddress);
        if (customerPage.hasContent()) {
            return new ResponseEntity<>(customerPage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = this.customerService.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Integer id) {
        this.customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDto customerDto,
                                          BindingResult bindingResult,
                                          String username) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
//        customer.getUser().setPassword(new BCryptPasswordEncoder().encode(customerDto.getUser().getPassword()));
        this.customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
