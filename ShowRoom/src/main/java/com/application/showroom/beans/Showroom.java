package com.application.showroom.beans;

public class Showroom {

	private int showroomId;
	
	private String showroomName;
	
	private Car car;

	public Showroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Showroom(int showroomId, String showroomName, Car car) {
		super();
		this.showroomId = showroomId;
		this.showroomName = showroomName;
		this.car = car;
	}

	public int getShowroomId() {
		return showroomId;
	}

	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}

	public String getShowroomName() {
		return showroomName;
	}

	public void setShowroomName(String showroomName) {
		this.showroomName = showroomName;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
