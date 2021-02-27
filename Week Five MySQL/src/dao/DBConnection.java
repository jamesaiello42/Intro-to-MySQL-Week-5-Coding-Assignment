package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// These variables and objects are used to establish a connection to the cars database
	private final static String URL = "jdbc:mysql://localhost:3306/cars";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private static Connection connection;
	private static DBConnection instance;
	
	// Private constructor to create one and other one connection (know as a singleton class)
	private DBConnection(Connection connection) {
		this.connection = connection;
	}
	
	// Method is used by the CarDao class for db connection
	public static Connection getConnection() {
		if (instance == null) {
			try { 
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Welcome to my menu program.\n");			
			} 
			// Let the user know something went wrong with db connection
			catch(SQLException e) {
				System.out.println("Something went wrong with the connection\n");
				e.printStackTrace();
			}
		}
		
		// Return connection
		return DBConnection.connection;
			
	}
	
}