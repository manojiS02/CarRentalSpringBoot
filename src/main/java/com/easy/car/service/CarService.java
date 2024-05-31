package com.easy.car.service;

import com.easy.car.dto.CarDTO;
import com.easy.car.entity.Car;
import com.easy.car.repo.CarRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepo carRepository;

    @Autowired
    ModelMapper modelMapper;

    public CarDTO addCar(CarDTO carDTO) {
        carRepository.save(modelMapper.map(carDTO, Car.class));
        return carDTO;
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return modelMapper.map(cars, new TypeToken<List<CarDTO>>() {}.getType());
    }

    public CarDTO updateCar(CarDTO carDTO) {
        carRepository.save(modelMapper.map(carDTO, Car.class));
        return carDTO;
    }

    public boolean deleteCar(CarDTO carDTO) {
        carRepository.delete(modelMapper.map(carDTO, Car.class));
        return true;
    }
}
