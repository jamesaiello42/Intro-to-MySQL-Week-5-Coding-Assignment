package dao;
import entity.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
	// Variables for SQL connection and CRUD queries
	private Connection connection;
	private final String GET_CARS_QUERY_BY_MAKE = "SELECT * FROM car WHERE car_make = ?";
	private final String GET_CARS_QUERY_BY_YEAR = "SELECT * FROM car WHERE car_year = ?";
	private final String GET_CARS_QUERY_ALL = "SELECT * FROM car WHERE car_year";
	private final String DELETE_CARS_QUERY_BY_IDS = "DELETE FROM car WHERE id = ?";
	private final String UPDATE_CARS_QUERY_BY_ID = "UPDATE car SET car_model = ? WHERE id = ?";
	private final String CREATE_CARS_QUERY = "INSERT INTO CAR (CAR_MAKE, CAR_MODEL, CAR_YEAR) VALUES (?, ?, ?)";
	
	// Get connection for cars database and create car data access object
	public CarDao() {
		connection = DBConnection.getConnection();
	}
	
	// Method queries database by car model
	public List<Car> getCarMake(String make) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CARS_QUERY_BY_MAKE);
		ps.setString(1, make);
		ResultSet rs = ps.executeQuery();
		
		// Stores car database info in a list
		List<Car> carsByMake = new ArrayList<Car>();
		
		// Loop through all rows and store in Car list 
		while (rs.next()) {
			carsByMake.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		// Return car list
		return carsByMake;
	}
	
	// Method queries database by car year
	public List<Car> getCarYear(int year) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CARS_QUERY_BY_YEAR);
		ps.setInt(1, year);
		ResultSet rs = ps.executeQuery();
		
		// Stores car database info in a list
		List<Car> carsAll = new ArrayList<Car>();
		
		// Loop through all rows and store in Car list 
		while (rs.next()) {
			carsAll.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
			
		// Return car list
		return carsAll;
	}
	
	// Method queries database by all cars
	public List<Car> getCarAll() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CARS_QUERY_ALL);
		ResultSet rs = ps.executeQuery();
		
		// Stores car database info in a list
		List<Car> carsByYear = new ArrayList<Car>();
		
		// Loop through all rows and store in Car list 
		while (rs.next()) {
			carsByYear.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		// Return car list
		return carsByYear;
	}
	
	// Method deletes multiple rows from the db via a loop
	public void deleteCarsByMultipleIds(List<Integer> ids) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CARS_QUERY_BY_IDS);
		
		// Loop through out all rows matching the passed in list are gone
		for (Integer id : ids) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}
		
	// Method takes in an update value and id to filter by, then makes the update
	public void updateCarModelById(String updateValue, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CARS_QUERY_BY_ID);
		ps.setString(1, updateValue);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	// Takes in a Car Make, Car Model, and Car Year to directly insert into the database
	public void createNewCarEntry(String carMake, String carModel, int carYear) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CARS_QUERY);
		ps.setString(1, carMake);
		ps.setString(2, carModel);
		ps.setInt(3, carYear);
		ps.executeUpdate();
	}
	
}
