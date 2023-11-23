package com.customer.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
