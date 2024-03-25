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

    public Customer saveOrUpdateCustomer(Customer customer) {
        System.out.println(customer);
        return this.customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }

    public void deleteCustomerById(Long id) {
        this.customerRepo.deleteById(id);
    }

    public Customer getCustomerById(Long id) {return this.customerRepo.getReferenceById(id);}

}
