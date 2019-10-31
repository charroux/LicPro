package com.example.CarRental;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalService {
	
	private List<Car> cars = new ArrayList<Car>();
	
	public CarRentalService() {
		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){
		return cars;
	}
	
	@RequestMapping(value="/cars/{plateNumber}", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Car getListOfCars(@PathVariable(value="plateNumber") String plateNumber){
		for(Car car: cars) {
			if(car.getPlateNumber().equals(plateNumber)) {
				return car;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/cars/{plateNumber}", method=RequestMethod.PUT) 
	@ResponseStatus(HttpStatus.OK) 
	public void rent(@PathVariable(value="plateNumber") String plateNumber, 
			@RequestParam(value="rent") boolean rent,
			@RequestBody Date date){
		for(Car car: cars) {
			if(car.getPlateNumber().equals(plateNumber)) {
				if(rent == true) {
					car.setRent(true);
					car.setDate(date);
				} else {
					car.setRent(false);
					car.setDate(null);
				}
			}
		}
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Car addCar(@RequestBody Car car) throws Exception{
		System.out.println(car);
		cars.add(car);
		return car;
	}

}
