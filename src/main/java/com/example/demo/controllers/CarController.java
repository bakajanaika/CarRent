package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.models.DTO.CarDto;
import com.example.demo.repos.CarDtoMapper;
import com.example.demo.repos.CarRepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CarController {
    private final CarRepo carRepo;
    private final UserRepo userRepo;
    private final UserService userService;
    private final CarDtoMapper carDtoMapper;



    public CarController(CarRepo carRepo, UserRepo userRepo, UserService userService, CarDtoMapper carDtoMapper) {
        this.carRepo = carRepo;
        this.userRepo = userRepo;
        this.userService = userService;
        this.carDtoMapper = carDtoMapper;
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
    public CarDto getById(@RequestParam int id){
        return carDtoMapper.carDTO(carRepo.findCarById(id));
    }
}
