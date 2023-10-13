package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.models.Orders;
import com.example.demo.services.MailSenderService;
import com.example.demo.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final MailSenderService mailSenderService;

    public OrderController(OrderService orderService, MailSenderService mailSenderService) {
        this.orderService = orderService;
        this.mailSenderService = mailSenderService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Orders orders) {

        return ResponseEntity.ok(orderService.createOrder(orders));
    }
}
