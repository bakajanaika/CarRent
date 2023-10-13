package com.example.demo.services.impl;

import com.example.demo.models.Car;
import com.example.demo.models.Orders;
import com.example.demo.repos.CarRepo;
import com.example.demo.repos.OrderRepo;
import com.example.demo.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;
    private final OrderRepo orderRepo;

    public CarServiceImpl(CarRepo carRepo, OrderRepo orderRepo) {
        this.carRepo = carRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public ResponseEntity<?> isCarAvailable(Long id) {
        Car car = carRepo.findCarById(id);
        if (car == null) {
            return ResponseEntity.notFound().build();
        }
        LocalDate now = LocalDate.now();
        List<Orders> orders = orderRepo.findAllByCar_IdAndDatesContaining(id, now);
        List<LocalDate> unavailableDates = new ArrayList<>();

        for (Orders order : orders) {
            unavailableDates.addAll(order.getDates());
        }

        List<LocalDate> availableDates = new ArrayList<>();
        LocalDate currentDate = now;
        while (availableDates.size() < 3) {
            currentDate = currentDate.plusDays(1);
            if (!unavailableDates.contains(currentDate)) {
                availableDates.add(currentDate);
            }
        }
        if (availableDates.isEmpty()) {
            return ResponseEntity.ok("This car is unavailable for the next 3 days.");
        } else {
            return ResponseEntity.ok("This car is unavailable for today. Closest dates are: " + availableDates);
        }
    }
}