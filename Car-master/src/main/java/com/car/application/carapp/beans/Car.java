package com.car.application.carapp.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
	
	private long carId;
	
	private String carName;
	
	private double carLaunchedYear;
	
	private double cost;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

    

	public Car(long carId, String carName, double carLaunchedYear, Double cost) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carLaunchedYear = carLaunchedYear;
		this.cost = cost;
	}



	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public double getCarLaunchedYear() {
		return carLaunchedYear;
	}

	public void setCarLaunchedYear(double d) {
		this.carLaunchedYear = d;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double d) {
		this.cost = d;
	}
	
}
