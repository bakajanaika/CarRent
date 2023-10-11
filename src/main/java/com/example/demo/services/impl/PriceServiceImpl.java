package com.example.demo.services.impl;

import com.example.demo.models.Price;
import com.example.demo.repos.PriceRepo;
import com.example.demo.services.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class PriceServiceImpl implements PriceService {


    private final PriceRepo priceRepo;

    public PriceServiceImpl(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    @Override
    public Price save(Price price) {
        Price priceDb = priceRepo.priceFinder(price.getCar().getId());
        if(priceDb != null){
            priceDb.setEndDate(LocalDate.now());
            priceRepo.save(priceDb);
        }
        price.setStartDate(LocalDate.now());
        price.setEndDate(price.getStartDate().plusYears(100));
        priceRepo.save(price);
        return price;
    }
}
