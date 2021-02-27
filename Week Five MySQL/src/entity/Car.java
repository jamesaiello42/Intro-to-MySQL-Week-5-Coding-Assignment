package entity;

public class Car {
	// Member variables for car
	private int id;
	private String model;
	private String make;
	private int year;
	
	// Create a car object and set values
	// This is used for holding db data
	public Car(int id, String make, String model, int year) {
		this.id = id;
		this.model = model;
		this.make = make;
		this.year = year;
	}
	
	// Getter for Car model
	public String getModel() {
		return model;
	}
	
	// Getter for Car make
	public String getMake() {
		return make;
	}
	
	// Getter for Car year
	public int getYear() {
		return year;
	}

	// Getter for Car id
	public int getId() {
		return id;
	}

	
}
