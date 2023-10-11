package com.example.demo.controllers;

import com.example.demo.models.Price;
import com.example.demo.services.PriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/save")
    public Price priceTest(@RequestBody Price price){
        return priceService.save(price);
    }
}
