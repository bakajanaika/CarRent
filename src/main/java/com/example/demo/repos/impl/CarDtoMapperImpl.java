package com.example.demo.repos.impl;

import com.example.demo.models.Car;
import com.example.demo.models.DTO.CarDto;
import com.example.demo.repos.CarDtoMapper;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Mapper
@Component
public class CarDtoMapperImpl implements CarDtoMapper {
    @Override
    public CarDto carDTO(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setName(car.getName());
        carDto.setManufacturerName(car.getManufacturer().getName());
        return carDto;
    }
}
