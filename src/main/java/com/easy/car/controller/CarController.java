package com.easy.car.controller;

import com.easy.car.dto.CarDTO;
import com.easy.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/carrental")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public CarDTO addCar(@RequestBody CarDTO carDTO) {
        return  carService.addCar(carDTO);
    }
    @GetMapping("/getAllCars")
    public List<CarDTO> getAllCars(){
        return carService.getAllCars();
    }

    @PutMapping("/updateCar")
    public CarDTO updateCar(@RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO);
    }

    @DeleteMapping("/deleteCar")
    public boolean deleteCar(@RequestBody CarDTO carDTO){
        return carService.deleteCar(carDTO);
    }
}
