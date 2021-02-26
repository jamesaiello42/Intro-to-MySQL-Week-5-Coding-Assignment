package application;

import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated m
		Menu menu = new Menu();
		try {
			menu.start();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
