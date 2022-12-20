package com.repository.customer;

import com.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customers where name like %:searchName% and address like %:searchAddress% and is_delete = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from customers where name like %:searchName% and address like %:searchAddress% and is_delete = 0) customers")
    Page<Customer> findCustomerByAll(Pageable pageable,
                                     @RequestParam(value = "searchName") String searchName,
                                     @RequestParam(value = "searchAddress") String searchAddress);

    @Modifying
    @Transactional
    @Query(value = "update customers set customers.is_delete = 1 where id =:id", nativeQuery = true)
    void deleteCustomerById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update `user` set `user`.is_delete = 1 where `user`.username in (select customers.username  from customers where customers.id =:id)", nativeQuery = true)
    void deleteUserById(Integer id);

    @Modifying
    @Query(value = "call insert_customer (:#{#c.name}, :#{#c.phoneNumber}), :#{#c.dayOfBirth}, " +
            ":#{#c.email}, :#{#c.gender}, :#{#c.address}, :#{#c.user.username}, :#{#c.user.password}", nativeQuery = true)
    void saveCustomer(@Param("c") Customer customer);

}
