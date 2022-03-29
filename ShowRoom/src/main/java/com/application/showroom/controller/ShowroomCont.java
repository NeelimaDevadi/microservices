package com.application.showroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.showroom.beans.Showroom;

import com.application.showroom.service.IShowroom;


	@RestController
	@RequestMapping("/ShowroomApi")
	public class ShowroomCont {
	
	@Autowired
	IShowroom showroomService;
	
		
	@GetMapping("/getAllShowRoom")
	public List<Showroom> getAllShowroom(){
				  
	List<Showroom> showroomList = showroomService.getAllShowroom();
	return showroomList;

				}

	@GetMapping("/getShowRoomById/{id}/{carId}")
	public Showroom getShowRoomById(@PathVariable int id,@PathVariable int carId){

	Showroom show = showroomService.getById(id,carId);
    return show; 
				}
		

	}



