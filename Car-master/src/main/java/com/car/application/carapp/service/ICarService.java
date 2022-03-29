package com.car.application.carapp.service;

import java.util.List;

import com.car.application.carapp.beans.Car;


public interface ICarService {

	Car getCarbyId(int id);

	List<Car> getAllCars();



}
