package com.example.demo.services;

import com.example.demo.models.Price;

import java.time.LocalDate;

public interface PriceService {
    Price save(Price price);
}
