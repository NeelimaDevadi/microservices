package com.application.showroom.resttemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.application.showroom.beans.Car;
@Component
public class RestServices {
	
	public List<Car> getAllCar(){
		   
	    RestTemplate restTemplate = new RestTemplate();
	    Car[] carList = restTemplate.getForObject("http://localhost:8888/carApi/getAllCar",Car[].class);
	    List<Car> carList1 = Arrays.asList(carList);
	    return carList1;

	}
	public Car getCarByid(int id) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Car> response = restTemplate.getForEntity("http://localhost:8888/carApi/getcarbyId/"+id,Car.class);
		return response.getBody();
	}
}
