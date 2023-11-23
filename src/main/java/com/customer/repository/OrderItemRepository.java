package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entities.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderId(int orderId);
    // You can add custom query methods if needed
}
