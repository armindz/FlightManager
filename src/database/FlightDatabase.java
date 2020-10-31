	package database;

	import java.sql.*;
	import java.util.ArrayList;

import models.Flight;

	public class FlightDatabase {
		/*
		private static String statementToStoreDataIntoFlights = "INSERT INTO flights"
				+ "(flightID, Airline, Airport_Codename, Flightclass, Date_of_flight, seatRow, seatNumber, flight_Price) values " + " (?,?,?,?,?,?,?,?);";
		private static String statementToDisplayDataOfFlights = "SELECT * FROM flights";
		
		
		public void storeToDatabase(Flight flight) {
			try {
				
				Connection conn = DatabaseConnection.getConnection();
				PreparedStatement preparedStmt = conn.prepareStatement(statementToStoreDataIntoFlights);
				Date date = null;
				preparedStmt.setInt(1, flight.getFlight_id()); // Airport_Codename Column
				preparedStmt.setString(2, flight.getAirlineCodename()); // Airport_Fullname Column
				preparedStmt.setString(3, flight.getAirportCodename()); // Airport_Type Column
				preparedStmt.setString(4, flight.getFlightClass()); // Airport_City Column
				preparedStmt.setDate(5, date, flight.getDateOfFlight()); // Airport_Country Column
				preparedStmt.setString(6, String.valueOf(flight.getSeatRow())); // Airport_City Column
				preparedStmt.setInt(7, flight.getSeatNumber()); // Airport_Country Column
				preparedStmt.setDouble(8, flight.getFlightPrice()); // Airport_City Column
		
				preparedStmt.execute();

				conn.close();
				preparedStmt.close();

			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
		private int generateFlightId() {			// mechanism for generating flight ID

			try {

				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(statementToDisplayDataOfFlights);
				int flightID = 0;
				while (rs.next()) {
					
					if (rs.isLast()) {
						flightID = rs.getInt("flightID");
						flightID++;
					}
				}

				return flightID;

			}

			catch (Exception e) {
				System.out.println("Something went wrong with generating Flight_ID");
				e.printStackTrace();
			}

			return 0;

		}*/
	}


