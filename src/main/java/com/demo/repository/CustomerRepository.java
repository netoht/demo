package com.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.domain.Customer;

/**
 * Para mais informações sobre spring DATA
 * http://docs.spring.io/spring-data/jpa/docs/1.8.0.RELEASE/reference/html/
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query(nativeQuery = true, value = "select * from customer limit ?1")
    List<Customer> findAllLimit(int limit);
}