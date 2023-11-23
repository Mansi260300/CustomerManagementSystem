package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Customer;
import com.customer.repository.CustomerRespository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRespository customerRepository;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();

	}

	public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


	public boolean deleteCustomer(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

	public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }




	public Object updateCustomer(int id, Customer updatedCustomer) {
		// TODO Auto-generated method stub
		return customerRepository.save(updatedCustomer);
	}

}


	

	

