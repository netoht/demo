package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Para mais informacoes sobre essa classe:
 * http://docs.spring.io/spring-data/jpa/docs/1.8.0.RELEASE/reference/html/#repositories.definition-tuning
 */
@NoRepositoryBean
interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    /**
     * Para criar queries:
     * http://docs.spring.io/spring-data/jpa/docs/1.8.0.RELEASE/reference/html/#repositories.query-methods.query-creation
     */
    T findOne(ID id);

    T save(T entity);
}