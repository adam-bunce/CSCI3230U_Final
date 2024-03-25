package com.webdev.project.controller;

import com.webdev.project.model.Customer;
import com.webdev.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        model.addAttribute("customers", this.customerService.getAllCustomers());
        return "/customers/list";
    }

    @GetMapping("/create-customer")
    public String viewCreateCustomer(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "/customers/create";
    }

    @PostMapping("/create-new-customer")
    public String createCustomer(Customer newCustomer, Model model) {
        this.customerService.saveOrUpdateCustomer(newCustomer);
        return "redirect:/customers/list";
    }


}
