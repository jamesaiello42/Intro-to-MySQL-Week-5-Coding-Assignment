package application;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CarDao;
import entity.Car;

public class Menu {
	private CarDao carDao;
	private Scanner scanner = new Scanner(System.in);
	private Scanner scanner2 = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display All Cars", 
			"Display Cars By Make", 
			"Display Cars By Year", 
			"Update a Car's Model By ID",
			"Create New Car Entry",
			"Delete One or more Cars by IDs"
	);
	
	public Menu() {
		carDao = new CarDao();
	}
	
	public void start() throws SQLException {
		String selection = "";
		
		String carMake = "";
		String carModel = "";
		int carYear;
		int carID;
		
		List<Integer> delList = new ArrayList<Integer>();
		
		do {
			printMenu();
			selection = scanner.nextLine();
			switch (selection) {
				case "1":
					displayCarAll();
					System.out.println();
					break;
				case "2":
					System.out.println("\nEnter in the Make name of the car: ");
					carMake = scanner.nextLine();
					System.out.println("\n");
					displayCarByMake(carMake);
					break;
				case "3":
					System.out.println("\nEnter in the Year of the car: ");
					carYear = scanner2.nextInt();
					System.out.println();	
					displayCarYear(carYear);
					break;
				case "4":
					System.out.println("\nEnter in the ID of the car and then enter the Model of the car: ");
					carID = scanner2.nextInt();
					carModel = scanner.nextLine();
					updateCarModelById(carModel, carID);
					break;
				case "5":
					System.out.println("\nEnter the Make, Model, and Year of the car: ");
					carMake = scanner.nextLine();
					carModel = scanner.nextLine();
					carYear = scanner2.nextInt();
					createCarEntry(carMake, carModel, carYear);
					break;
				case "6":
					System.out.println("\nEnter one or more IDs of cars to delete (enter choices, then -1): ");
					carID = scanner2.nextInt();
					
					while (carID != -1) {
						delList.add(carID);
						carID = scanner2.nextInt();
					}
					
					deleteCarByMultipleIds(delList);
					break;
					
					
			}
			System.out.println();
			
		} while (!selection.equals("-1"));
		
	}


	private void displayCarByMake(String make) throws SQLException {
		List<Car> cars = carDao.getCarMake(make);
		
		for (Car car : cars) {
			System.out.println("Car ID: " + car.getId() + " - Car Make: " + car.getMake() + " - Car Model: " + car.getModel() + " - Car Year: " + car.getYear());
		}
		
		if (cars.size() == 0)
			System.out.println("Results of Car Make query \"" + make + "\" not found.");
		
	}
	
	private void displayCarYear(int year) throws SQLException {
		List<Car> cars = carDao.getCarYear(year);
		
		for (Car car : cars) {
			System.out.println("Car ID: " + car.getId() + " - Car Make: " + car.getMake() + " - Car Model: " + car.getModel() + " - Car Year: " + car.getYear());
		}
		
		if (cars.size() == 0)
			System.out.println("Result of Car Year query \"" + year + "\" not found.");
		
	}	
	
	private void displayCarAll() throws SQLException {
		List<Car> cars = carDao.getCarAll();
		
		for (Car car : cars) {
			System.out.println("Car ID: " + car.getId() + " - Car Make: " + car.getMake() + " - Car Model: " + car.getModel() + " - Car Year: " + car.getYear());
		}
		
	}	
	
	private void deleteCarByMultipleIds(List <Integer> ids) throws SQLException {
		carDao.deleteCarsByMultipleIds(ids);		
	}	
	
	private void updateCarModelById(String updateValue, int id) throws SQLException {
		carDao.updateCarModelById(updateValue, id);		
	}
	
	private void createCarEntry(String carMake, String carModel, int carYear) throws SQLException {
		carDao.createNewCarEntry(carMake, carModel, carYear);	
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-------------------------------------");
		for (int i = 0; i < options.size(); i++)
			System.out.println((i + 1) + ") " + options.get(i));
		
		System.out.println("\nSelection: ");
	}
}
