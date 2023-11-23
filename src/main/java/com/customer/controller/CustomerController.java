package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entities.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customers")

public class CustomerController {
	 @Autowired
	  CustomerService customerService ;
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() {
		
		return customerService.getAllCustomers();
		
		
	}
	
	@GetMapping("get/{id}") 
	  public Optional<Customer> getCustomerById( @PathVariable int id) 
	  { 
		return (Optional<Customer>) customerService.getCustomerById(id);
	   }

	@PostMapping("/create") public Customer createCustomer(@RequestBody Customer customer)
	{ 
		return customerService.createCustomer(customer);
	  
	  }
	  
	  @PutMapping("update/{id}")
	    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
	        return (Customer) customerService.updateCustomer(id, updatedCustomer);
	                
	    }
	  
	  @DeleteMapping("delete/{id}") 
	  public void deleteCustomer(@PathVariable int id) 
	  {
	  customerService.deleteCustomer(id);
	  }
	  
	  
	  
	 
	  
	  
	  
	  
	  
	 

	
}
	



