package com.webdev.project.repo;

import com.webdev.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/2.7.9/api/
    // we get these functions for free, if we need more we do
    // @Query("whatever")
    // Return<Type> functionName(@Param("query_input") InputType query_input)
}
