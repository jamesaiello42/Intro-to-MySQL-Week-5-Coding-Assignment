package dao;
import entity.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
	private Connection connection;
	private final String GET_CARS_QUERY_BY_MAKE = "SELECT * FROM car WHERE car_make = ?";
	private final String GET_CARS_QUERY_BY_YEAR = "SELECT * FROM car WHERE car_year = ?";
	private final String GET_CARS_QUERY_ALL = "SELECT * FROM car WHERE car_year";
	private final String DELETE_CARS_QUERY_BY_IDS = "DELETE FROM car WHERE id = ?";
	private final String UPDATE_CARS_QUERY_BY_ID = "UPDATE car SET car_model = ? WHERE id = ?";
	private final String CREATE_CARS_QUERY = "INSERT INTO CAR (CAR_MAKE, CAR_MODEL, CAR_YEAR) VALUES (?, ?, ?)";
	
	public CarDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Car> getCarMake(String make) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CARS_QUERY_BY_MAKE);
		ps.setString(1, make);
		ResultSet rs = ps.executeQuery();
		
		List<Car> carsByMake = new ArrayList<Car>();
		
		while (rs.next()) {
			carsByMake.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
			
		return carsByMake;
	}
	
	public List<Car> getCarYear(int year) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CARS_QUERY_BY_YEAR);
		ps.setInt(1, year);
		ResultSet rs = ps.executeQuery();
		
		List<Car> carsByYear = new ArrayList<Car>();
		
		while (rs.next()) {
			carsByYear.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
			
		return carsByYear;
	}
	
	public List<Car> getCarAll() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CARS_QUERY_ALL);
		ResultSet rs = ps.executeQuery();
		
		List<Car> carsByYear = new ArrayList<Car>();
		
		while (rs.next()) {
			carsByYear.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
			
		return carsByYear;
	}
	
	public void deleteCarsByMultipleIds(List<Integer> ids) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CARS_QUERY_BY_IDS);
		
		for (Integer id : ids) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}
		
	public void updateCarModelById(String updateValue, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CARS_QUERY_BY_ID);
		ps.setString(1, updateValue);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void createNewCarEntry(String carMake, String carModel, int carYear) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CARS_QUERY);
		ps.setString(1, carMake);
		ps.setString(2, carModel);
		ps.setInt(3, carYear);
		ps.executeUpdate();
	}
	
}
