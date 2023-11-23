package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entities.Customer;


public interface CustomerRespository extends JpaRepository<Customer,Integer>{
	

}
