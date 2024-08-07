package com.backend.tes.api;

import com.backend.tes.domain.Customer;
import com.backend.tes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;

    /*
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository repository) { this.customerRepository = repository; }

    @GetMapping("/api/customers")
    List<Customer> all(){
        return customerRepository.findAll();
    }

    @GetMapping("/api/customers/search/{firstName}")
    List<Customer> search(@PathVariable String firstName){
        return customerRepository.findByFirstNameContainsIgnoreCase(firstName);
    }

    @GetMapping("/api/customers/search2/{lastName}")
    List<Customer> search2(@PathVariable String lastName) {
        return customerRepository.findByLastNameContainsIgnoreCase(lastName);
    }

    @GetMapping("/api/customers/search3/{firstName}/{lastName}")
    List<Customer> search3(@PathVariable String firstName, @PathVariable String lastName) {
        return customerRepository.findByFirstNameOrLastName(firstName, lastName);
    }
*/
}
