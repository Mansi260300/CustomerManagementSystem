package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Order;
import com.customer.entities.OrderItem;
import com.customer.repository.OrderItemRepository;
import com.customer.repository.OrderRepository;

@Service
public class OrderItemService {
	@Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderItem> getOrderItemsForOrder() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(int orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    public OrderItem createOrderItemForOrder(int orderId, OrderItem orderItem) throws ClassNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderItem.setOrder(order);
            return orderItemRepository.save(orderItem);
        } else {
            throw new ClassNotFoundException("Order with ID " + orderId + " not found");
        }
    }

    public Optional<OrderItem> updateOrderItem(int orderItemId, OrderItem updatedOrderItem) {
        return orderItemRepository.findById(orderItemId);
    }

    public boolean deleteOrderItem(int orderItemId) {
        if (orderItemRepository.existsById(orderItemId)) {
            orderItemRepository.deleteById(orderItemId);
            return true;
        } else {
            return false;
        }
    }

	
	


}
