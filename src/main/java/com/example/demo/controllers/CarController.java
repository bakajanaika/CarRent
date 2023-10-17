package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.repos.CarRepo;
import com.example.demo.repos.ClientRepo;
import com.example.demo.services.CarService;
import com.example.demo.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CarController {
    private final CarRepo carRepo;

    private final CarService carService;



    public CarController(CarRepo carRepo, ClientRepo clientRepo, ClientService clientService, CarService carService) {
        this.carRepo = carRepo;
        this.carService = carService;
    }

    @GetMapping("/car/{name}")
    public Car filterCars(@PathVariable String name){

        return carRepo.findCarByName(name);

    }
    @GetMapping("/car/mnf/{name}")
    public List<Car> filterCarsByMnf(@PathVariable String name){
        return carRepo.findCarByManufacturer_Name(name);
    }
    @GetMapping("/car/country/{name}")
    public List<Car> filterCarsByCountry(@PathVariable String name){
        return carRepo.findCarByManufacturer_Country(name);
    }


    @PostMapping("/car/save")
    public  Car saveCar(@RequestBody Car car){
       return carRepo.save(car);
    }



    @GetMapping("car/id")
    public ResponseEntity<?> findCAr(@RequestParam Long id){
        return carService.isCarAvailable(id);
    }
}
