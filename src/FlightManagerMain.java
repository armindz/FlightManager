import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import booking.BookingFlightTicket;
import database.AirlineDatabase;
import database.AirportDatabase;
import database.FlightDatabase;
import database.SeatDatabase;
import management.AirlineManagementSystem;
import management.AirportManagementSystem;
import management.FlightManagementSystem;
import models.Seat;

public class FlightManagerMain {

	public static void displayMenu() {
		System.out.println("\n 1) Create airline \n 2) Create airport \n 3) Create flight \n 4) Book a flight "
				+ "\n 5) List of airlines \n 6) List of airports \n 7) List of flights \n 8) Seat availability enquiry \n 9) List of available seats for specific flight \n 0) EXIT");
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		FlightManagementSystem fms = new FlightManagementSystem();
		AirlineManagementSystem airlinems = new AirlineManagementSystem();
		AirportManagementSystem airportms = new AirportManagementSystem();
		BookingFlightTicket bft = new BookingFlightTicket();
		AirlineDatabase airlinedb = new AirlineDatabase();
		AirportDatabase airportdb = new AirportDatabase();
		FlightDatabase flightdb = new FlightDatabase();
		SeatDatabase seatdb = new SeatDatabase();
		Scanner scan = new Scanner(System.in);
		String keyboard = "-144";
		
		int year = 2020;
		System.out.println("MONTH");
		int month = 2;
		System.out.println("DAY");
		int day = 20;
		System.out.println("HOURS");
		int hourOfDay = 20;
		System.out.println("MIN");
		int minute = 22;

		Calendar dateOfFlight = Calendar.getInstance();
		dateOfFlight.set(year, month - 1, day, hourOfDay, minute);
		System.out.println(dateOfFlight.getTime());
		Date date = new Date(dateOfFlight.getTimeInMillis());
		System.out.println(date.getTime());
		System.out.println(date);
		
		
		
		
		while (1 > 0) {
			
			
			while (keyboard != "0") {
				
				displayMenu();
				keyboard = scan.next();
				
				
				switch (keyboard) {

				case "1":
					System.out.println("Create airline");
					airlinems.createAirline();
					break;
					
				case "2":
					System.out.println("Create airport");
					airportms.createAirport();
					break;
					
				case "3":
					System.out.println("Create flight");
					fms.createFlight();
					break;
					
				case "4":
					System.out.println("Book a flight");
					System.out.println("Type FlightID!");
					int flightID = scan.nextInt();
					System.out.println("Type flight class!");
					String flightClass = scan.next();
					System.out.println("Type  seat row!");
					char seatRow = scan.next().charAt(0);
					System.out.println("Type seat number");
					int seatNumber = scan.nextInt();
					bft.bookAFlight(flightID, flightClass, seatRow, seatNumber);
					break;
					
				case "5":
					System.out.println("List of airlines");
					System.out.println(airlinems.fetchDatabaseContentToList());
					break;
					
					
				case "6":
					System.out.println("List of airports");
					System.out.println(airportms.fetchDatabaseContentToList());
					break;
					
				case "7" :
					System.out.println("List of flights");
					System.out.println(fms.fetchFlightDatabaseContentToList());
					break;
					
				case "8" :
					System.out.println("Seat availability enquiry");
					System.out.println("Type flight ID");
					int flight_ID = scan.nextInt();
					System.out.println("Type seatrow");
					char seat_Row = scan.next().charAt(0);
					System.out.println("Type seat number");
					int seat_Number = scan.nextInt();
					if (bft.isSeatAvailable(flight_ID, seat_Row, seat_Number)) {
						System.out.println("Seat is available");
					}
					else {
						System.out.println("Seat is not available");
					}
					break;
					
				case "9" :
					System.out.println("List of available seats for specific flight ");
					System.out.println("Please enter flight ID");
					int id_of_flight = scan.nextInt();
					fms.displayAvailableSeatsInSpecificFlight(id_of_flight);
					break;
				}
				
			}
		}
		}}


