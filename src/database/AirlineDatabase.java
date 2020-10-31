
	package database;

	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import java.sql.*;
	import java.util.ArrayList;

import models.Airline;


	public class AirlineDatabase {
		
		private static String statementToStoreDataIntoAirlines = "INSERT INTO airlines"
				+ "(Airline_Codename, Airline_Callsign, Airline_Country) values " + " (?,?,?);";
		private static String statementToDisplayDataOfAirlines = "SELECT * FROM airlines";
		
		
		public void storeToDatabase(Airline airline) {
			try {
				
				Connection conn = DatabaseConnection.getConnection();
				PreparedStatement preparedStmt = conn.prepareStatement(statementToStoreDataIntoAirlines);
			
				
				preparedStmt.setString(1, airline.getAirlineCodename()); // Airport_Codename Column
				preparedStmt.setString(2, airline.getAirlineCallsign()); // Airport_CallSign Column
				preparedStmt.setString(3, airline.getAirlineCountry()); // Airport_Country Column
			

				preparedStmt.execute();

				conn.close();
				preparedStmt.close();

			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}



