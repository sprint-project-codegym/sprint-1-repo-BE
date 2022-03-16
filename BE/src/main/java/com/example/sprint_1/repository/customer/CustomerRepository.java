package com.example.sprint_1.repository.customer;

import com.example.sprint_1.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value="select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, customer_phone,customer_company,status, delete_flag from customer ", nativeQuery = true)
    List<Customer> findAllCustomer();

    @Query(value="select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, customer_phone,customer_company,status, delete_flag from customer where customer_id = :id", nativeQuery = true)
    Customer findCustomerByCustomerId(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "update customer set customer.delete_flag = 0 where customer.customer_id = :id",nativeQuery = true)
    void deleteCustomer (@Param("id") String id);

    @Query(value= "select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, customer_phone,customer_company,status, delete_flag from customer where customer.customer_id like %?1%",nativeQuery = true)
    List<Customer> searchCustomerById(String id);

    @Query(value= "select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, customer_phone,customer_company,status, delete_flag from customer where customer.customer_name like %?1%",nativeQuery = true)
    List<Customer> searchCustomerByName(String name );

    @Query(value= "select customer_id, customer_name, customer_birthday, customer_id_card, customer_email, customer_address, customer_phone,customer_company,status, delete_flag from customer where customer.customer_id like %?1% and customer.customer_name like %?2%",nativeQuery = true)
    List<Customer> searchCustomerByIdAndName(String id, String name );


}

