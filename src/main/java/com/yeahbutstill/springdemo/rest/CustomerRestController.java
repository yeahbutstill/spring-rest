package com.yeahbutstill.springdemo.rest;

import com.yeahbutstill.springdemo.entity.Customer;
import com.yeahbutstill.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {

    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();

    }

    // add mapping for GET /customers/{customerId}

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        // throw exception if null
        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id  - " + customerId + ", not found");
        }

        return theCustomer;
    }

    // add mapping for POST /customer - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;

    }

    // add mapping for PUT /customers - update existing customers
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return theCustomer;

    }

    // add mapping for DELETE /customers - delete customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);

        // throw exception if null
        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer id  - " + customerId + ", not found");
        }

        customerService.deleteCustomer(customerId);

        return "Delete customer id - " + customerId;

    }


}


















