package com.demo.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Customer;
import com.demo.repository.CustomerRepository;

@RestController
/**
 * Para mais configurações sobre o MVC:
 * http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-spring-mvc
 */
public class MyControllerJPA {

    @Autowired CustomerRepository repository;
    private final static AtomicLong counter = new AtomicLong();

    /**
     * Para mais configurações de retorno e mapeamento consulte:
     * http://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-mvc.html
     **/
    @RequestMapping("/customer/save")
    public Customer save() {
        Customer customer = new Customer("Client " + counter.addAndGet(10), "Cool " + counter.get());
        repository.save(customer);
        return customer;
    }

    @RequestMapping("/customer/list")
    public Iterable<Customer> list() {
        return repository.findAll();
    }

    @RequestMapping("/customer/find/{id}")
    public Iterable<Customer> list(@PathVariable Long id) {
        return repository.findByLastName("Cool " + id);
    }

    @RequestMapping("/customer/list/{limit}")
    public Iterable<Customer> list(@PathVariable int limit) {
        return repository.findAllLimit(limit);
    }

}