package com.webdev.project.service;

import com.webdev.project.model.Customer;
import com.webdev.project.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo repo) {
        super();
        this.customerRepo = repo;
    }

    // create or update customer in db
    public Customer saveOrUpdateCustomer(Customer customer) {
        return this.customerRepo.save(customer);
    }

    // get all customers in db
    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }

    // remove customer from db
    public void deleteCustomerById(Long id) {
        this.customerRepo.deleteById(id);
    }

    // get specific customer based on id
    public Customer getCustomerById(Long id) {return this.customerRepo.getReferenceById(id);}

}
