package com.application.showroom.service;

import java.util.List;

import com.application.showroom.beans.Showroom;

public interface IShowroom {

	List<Showroom> getAllShowroom();

	Showroom getById(int id, int carId);


}
