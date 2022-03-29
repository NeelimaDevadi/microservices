package com.car.application.carapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.application.carapp.beans.Car;


import com.car.application.carapp.service.ICarService;


@RestController
@RequestMapping("/carApi")
public class CarController {

     @Autowired
     ICarService carService;
	
	
	@GetMapping("/getAllCar")
	public List<Car> getAllCar(){
		List<Car> carList = carService.getAllCars();
		return carList;	
	}
	
	@GetMapping("/getcarbyId/{id}")
	public Car getCarById(@PathVariable int id) {
         Car car = carService.getCarbyId(id);
         return car;
	}
	
}
