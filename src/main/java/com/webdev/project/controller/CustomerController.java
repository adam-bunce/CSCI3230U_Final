package com.webdev.project.controller;

import com.webdev.project.model.Customer;
import com.webdev.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String viewCustomers(Model model) {
        model.addAttribute("customers", this.customerService.getAllCustomers());
        return "/customers/list";
    }

    @GetMapping("/create")
    public String viewCreateCustomer(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "/customers/create";
    }

    @PostMapping("/create")
    public String createCustomer(Customer newCustomer, Model model) {
        this.customerService.saveOrUpdateCustomer(newCustomer);
        return "redirect:/customers/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(Long customerId, Model model) {
        this.customerService.deleteCustomerById(customerId);
        return "redirect:/customers/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEditCustomer(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.getCustomerById(id);
        System.out.println(customer);
        model.addAttribute("selectedCustomer", customer);
        return "/customers/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer, Model model) {
        this.customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customers/list";
    }

}
