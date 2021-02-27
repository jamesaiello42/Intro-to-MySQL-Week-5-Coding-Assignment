package application;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CarDao;
import entity.Car;

public class Menu {
	// Object is responsible for directly touching the db. 
	// There is allow two scanner objects to get input from the commandline
	private CarDao carDao;
	private Scanner scanner = new Scanner(System.in);
	private Scanner scanner2 = new Scanner(System.in);
	
	// These are options that the user can select from the menu
	private List<String> options = Arrays.asList(
			"Display All Cars", 
			"Display Cars By Make", 
			"Display Cars By Year", 
			"Update a Car's Model By ID",
			"Create New Car Entry",
			"Delete One or more Cars by IDs"
	);
	
	// Create a data access object to allow getting data from the db via a layer
	public Menu() {
		carDao = new CarDao();
	}
	
	// Function serves as the main driver of the Menu object
	public void start() throws SQLException {
		String selection = "";
		
		// These are variables are initialized the by scanner objects and passed to the dao object
		String carMake = "";
		String carModel = "";
		int carYear;
		int carID;
		
		// This is a list of id with values the user passed in through command line
		List<Integer> delList = new ArrayList<Integer>();
		
		do {
			
			// Print menu and receive user's menu selection
			printMenu();
			selection = scanner.nextLine();
			
			// Determine which operation
			switch (selection) {
				// Display all cars in the db
				case "1":
					displayCarAll();
					System.out.println();
					break;
				// Display all cars by the make that the user enters
				case "2":
					System.out.println("\nEnter in the Make name of the car: ");
					carMake = scanner.nextLine();
					System.out.println("\n");
					displayCarByMake(carMake);
					break;
				// Display all cars by the year that the user enters
				case "3":
					System.out.println("\nEnter in the Year of the car: ");
					carYear = scanner2.nextInt();
					System.out.println();	
					displayCarYear(carYear);
					break;
				// Update a car by database id by what the user enters and update the Model by what the user enters
				case "4":
					System.out.println("\nEnter in the ID of the car and then enter the Model of the car: ");
					carID = scanner2.nextInt();
					carModel = scanner.nextLine();
					updateCarModelById(carModel, carID);
					break;
				// Create a new car entry based what user enters (make, model, year)
				case "5":
					System.out.println("\nEnter the Make, Model, and Year of the car: ");
					carMake = scanner.nextLine();
					carModel = scanner.nextLine();
					carYear = scanner2.nextInt();
					createCarEntry(carMake, carModel, carYear);
					break;
				// User is allowed enter as many ids until -1 is entered and then it will delete all of the rows by the ids provided
				case "6":
					System.out.println("\nEnter one or more IDs of cars to delete (enter choices, then -1): ");
					carID = scanner2.nextInt();
					
					// Loop for input until -1 is provides
					while (carID != -1) {
						delList.add(carID);
						carID = scanner2.nextInt();
					}
					
					deleteCarByMultipleIds(delList);
					break;
					
					
			}
			
			// Line for neatness
			System.out.println();
			
		} while (!selection.equals("-1"));
		
	}

	// Function displays all cars by the make passed in
	private void displayCarByMake(String make) throws SQLException {
		List<Car> cars = carDao.getCarMake(make);
		
		// Show all the data for the passed in parameter
		for (Car car : cars) {
			System.out.println("Car ID: " + car.getId() + " - Car Make: " + car.getMake() + " - Car Model: " + car.getModel() + " - Car Year: " + car.getYear());
		}
		
		// If there are zero rows, tell the user nothing is found
		if (cars.size() == 0)
			System.out.println("Results of Car Make query \"" + make + "\" not found.");
		
	}
	
	// Function displays all cars by the year passed in
	private void displayCarYear(int year) throws SQLException {
		List<Car> cars = carDao.getCarYear(year);
		
		// Show all the data for the passed in parameter
		for (Car car : cars) {
			System.out.println("Car ID: " + car.getId() + " - Car Make: " + car.getMake() + " - Car Model: " + car.getModel() + " - Car Year: " + car.getYear());
		}
		
		// If there are zero rows, tell the user nothing is found
		if (cars.size() == 0)
			System.out.println("Result of Car Year query \"" + year + "\" not found.");
		
	}	
	
	// Function displays all cars (no filters)
	private void displayCarAll() throws SQLException {
		List<Car> cars = carDao.getCarAll();
		
		// Show all the data for the passed in parameter
		for (Car car : cars) {
			System.out.println("Car ID: " + car.getId() + " - Car Make: " + car.getMake() + " - Car Model: " + car.getModel() + " - Car Year: " + car.getYear());
		}
		
		// No rows in the table
		if (cars.size() == 0)
			System.out.println("There is nothing in this table.");
		
	}	
	
	// Takes in a list of ids and then calls the function deleteCarsByMultipleIds to delete from the car table
	private void deleteCarByMultipleIds(List <Integer> ids) throws SQLException {
		carDao.deleteCarsByMultipleIds(ids);		
	}	
	
	// Takes an value to that is the update value and id to filter for that row
	private void updateCarModelById(String updateValue, int id) throws SQLException {
		carDao.updateCarModelById(updateValue, id);		
	}
	
	// Takes in Car Make, Car Model, and Car Year to passed to the function createNewCarEntry to insert a row with that data into the db
	private void createCarEntry(String carMake, String carModel, int carYear) throws SQLException {
		carDao.createNewCarEntry(carMake, carModel, carYear);	
	}
	
	// Loops through list of options that output to the user's screen
	private void printMenu() {
		System.out.println("Select an Option (-1 to terminate program):\n-------------------------------------");
		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + ") " + options.get(i));
		
		System.out.println("\nSelection: ");
	}
}