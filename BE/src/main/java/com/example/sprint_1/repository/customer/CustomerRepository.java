package com.example.sprint_1.repository.customer;

import com.example.sprint_1.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, " +
            "customer_phone,customer_company,status, delete_flag from customer" +
            " where customer.customer_id like %?1% and " +
            "customer.customer_name like %?2% and customer.delete_flag = 0",
            countQuery = "select count(*) " +
                    "from customer where customer.customer_id like %?1% and " +
                    "customer.customer_name like %?2% and customer.delete_flag = 0", nativeQuery = true)
    Page<Customer> findAllCustomerWithPagination(String id, String name, Pageable pageable);

    @Query(value = "select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, " +
            "customer_phone,customer_company,status, delete_flag from customer where customer_id = :id and delete_flag = 0", nativeQuery = true)
    Customer findCustomerByCustomerId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "update customer set customer.delete_flag = true where customer.customer_id = :id", nativeQuery = true)
    void deleteCustomer(@Param("id") String id);

}