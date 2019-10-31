package com.example.CarRental;

public class Car {
	
	private String plateNumber;
	private String brand;
	private int price;
	private boolean rent;
	private Date date;
	
	public Car() {
		super();
	}
	
	public Car(String plateNumber, String brand, int price) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
	}

}
