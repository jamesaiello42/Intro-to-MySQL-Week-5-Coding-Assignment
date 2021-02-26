package entity;

public class Car {
	private int id;
	private String model;
	private String make;
	private int year;
	
	public Car(int id, String make, String model, int year) {
		this.id = id;
		this.model = model;
		this.make = make;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getMake() {
		return make;
	}
	
	public int getYear() {
		return year;
	}

	public int getId() {
		return id;
	}

	
}
