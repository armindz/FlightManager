	package database;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.*;
	import java.util.ArrayList;
	import objects.Airport;

	public class AirportDatabase {
		
		private static String statementToStoreDataIntoAirports = "INSERT INTO airports"
				+ "(Airport_Codename, Airport_Fullname, Airport_Type, Airport_City, Airport_Country) values " + " (?,?,?, ?, ?);";
		private static String statementToDisplayDataOfAirports = "SELECT * FROM airports";
		
		
		public void storeToDatabase(Airport airport) {
			try {
				
				Connection conn = DatabaseConnection.getConnection();
				PreparedStatement preparedStmt = conn.prepareStatement(statementToStoreDataIntoAirports);
			
				
				preparedStmt.setString(1, airport.getAirportCodename()); // Airport_Codename Column
				preparedStmt.setString(2, airport.getAirportFullname()); // Airport_Fullname Column
				preparedStmt.setString(3, airport.getAirportType()); // Airport_Type Column
				preparedStmt.setString(4, airport.getAirportCity()); // Airport_City Column
				preparedStmt.setString(5, airport.getAirportCountry()); // Airport_Country Column

				preparedStmt.execute();

				conn.close();
				preparedStmt.close();

			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}


