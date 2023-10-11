package com.example.demo.services.impl;

import com.example.demo.models.Car;
import com.example.demo.models.Orders;
import com.example.demo.repos.OrderRepo;
import com.example.demo.repos.PriceRepo;
import com.example.demo.services.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final PriceRepo priceRepo;


    public OrderServiceImpl(OrderRepo orderRepo, PriceRepo priceRepo) {
        this.orderRepo = orderRepo;
        this.priceRepo = priceRepo;
    }

    @Override
    public Orders createOrder(Orders orders) {

        orders.setPrice(priceRepo.priceFinder(orders.getPrice().getCar().getId()));
        orders.setDate(LocalDate.now());
        orders.setSum(orders.getDates().size()* orders.getPrice().getPrice());
        orders.setCar(orders.getPrice().getCar());
        return orderRepo.save(orders);
    }
}
