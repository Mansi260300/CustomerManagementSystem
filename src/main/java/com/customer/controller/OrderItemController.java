package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entities.OrderItem;
import com.customer.service.OrderItemService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController
{

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("getAll/{orderId}")
    public List<OrderItem> getOrderItemsForOrder() {
      return orderItemService.getOrderItemsForOrder();
    }

    @GetMapping("/byid/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable int orderItemId) {
        return orderItemService.getOrderItemById(orderItemId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("create/{orderId}")
    public ResponseEntity<OrderItem> createOrderItemForOrder(@PathVariable int orderId,@RequestBody OrderItem orderItem) {
        try {
            OrderItem createdOrderItem = orderItemService.createOrderItemForOrder( orderId, orderItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable int orderItemId,
            @RequestBody OrderItem updatedOrderItem) {
        return orderItemService.updateOrderItem(orderItemId, updatedOrderItem)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable int orderItemId) {
        boolean deleted = orderItemService.deleteOrderItem(orderItemId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}



