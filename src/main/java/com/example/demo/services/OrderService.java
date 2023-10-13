package com.example.demo.services;

import com.example.demo.models.Orders;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    public ResponseEntity<?> createOrder(Orders orders);
}
