package management;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import database.AirlineDatabase;
import database.AirportDatabase;
import database.FlightDatabase;
import database.SeatDatabase;
import models.Airport;
import models.Flight;
import models.Seat;

public class FlightManagementSystem {

	Flight flight;
	private static ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Seat> listOfSeats = new ArrayList<Seat>();

	AirlineManagementSystem airlinems = new AirlineManagementSystem();
	AirportManagementSystem airportms = new AirportManagementSystem();
	
	AirlineDatabase airlinedb = new AirlineDatabase();
	AirportDatabase airportdb = new AirportDatabase();
	SeatDatabase seatdb = new SeatDatabase();
	FlightDatabase flightdb = new FlightDatabase();

	public void createFlight() {
		Scanner scan = new Scanner(System.in);
		try {

			System.out.println("Please type airline codename!");
			String airlineCodename = "WIZZ"; // scan.next();
			System.out.println("Please type airport codename!");
			String airportCodename = "SJJ"; // scan.next();
			System.out.println("Please type destination airport codename!");
			String destinationAirportCodename = "TZZ"; // scan.next();
			System.out.println("Please type flight class!");
			String flightClass = "EC"; // scan.next();
			System.out.println("Please type seat row!");
			char flightSeatRows = 'C'; // scan.next().charAt(0);
			System.out.println("Please type seat number!");
			int flightNumberOfSeatsPerRow = 5; // scan.nextInt();
			System.out.println("Please type flight price!");
			double flightPrice = 22; // scan.nextDouble();
			System.out.println("Please type date of flight!");
			System.out.println("YEAR");
			int year = 2020; // scan.nextInt();
			System.out.println("MONTH");
			int month = 2; // scan.nextInt();
			System.out.println("DAY");
			int day = 20; // scan.nextInt();
			System.out.println("HOURS");
			int hourOfDay = 12; // scan.nextInt();
			System.out.println("MIN");
			int minute = 24; // scan.nextInt();

			Calendar dateOfFlight = Calendar.getInstance();
			dateOfFlight.set(year, month - 1, day, hourOfDay, minute);
			System.out.println(dateOfFlight.getTime());

			flight = new Flight(airlinems.getAirlineFromCodename(airlineCodename),
					airportms.getAirportFromCodename(airportCodename),
					airportms.getAirportFromCodename(destinationAirportCodename), flightClass, dateOfFlight,
					flightSeatRows, flightNumberOfSeatsPerRow, flightPrice);

			if (isFlightDataUnique(flight) && isSeatRowValid(flightSeatRows) && isAirlineCodenameValid(airlineCodename)
					&& isAirportCodenameValid(airportCodename) && isAirportCodenameValid(destinationAirportCodename)) {
				listOfFlights.add(flight);
				createSeatsAndStoreToDatabase(flight, flightSeatRows, flightNumberOfSeatsPerRow);
				addFlightToDatabase();

				System.out.println("Flight successfully created!");
			} else {
				System.out.println("Data is not unique or seat row not valid.");
			}

		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	private void createSeatsAndStoreToDatabase(Flight flight, char seatRow, int numberOfSeatsPerRow) {

		for (int i = 'A'; i <= seatRow; i++) {
			for (int j = 1; j <= numberOfSeatsPerRow; j++) {
				char seatRows = (char) i;
				Seat seat = new Seat(Flight.getFlight_id(), seatRows, j, true);
				System.out.println(seat);

				flight.addToListOfSeats(seat);
				addSeatToDatabase(seat);

			}

		}
		System.out.println("List" + flight.getListOfSeats());
	}

	public void displayAvailableSeatsInSpecificFlight(int flight_id) {
		fetchSeatDatabaseContentToList();

		for (int i = 0; i < listOfSeats.size(); i++) {

			if ((listOfSeats.get(i).getFlightId() == flight_id) && listOfSeats.get(i).isSeatAvailable()) {
				System.out.println(listOfSeats.get(i));
			}
		}
	}

	public void markSeatAsAvailable(int flightId, char seatRow, int seatNumber) {

		boolean isSeatAvailable = true;
		seatdb.updateDatabaseContent(flightId, seatRow, seatNumber, isSeatAvailable);

	}

	public void markSeatAsUnavailable(int flightId, char seatRow, int seatNumber) {

		boolean isSeatAvailable = false;
		seatdb.updateDatabaseContent(flightId, seatRow, seatNumber, isSeatAvailable);

	}

	private boolean isFlightDataUnique(Flight flight) {

		flightdb.fetchDatabaseContent(listOfFlights); // return flight database content through given ArrayList
		if (!listOfFlights.isEmpty() && listOfFlights.contains(flight)) {
			return false;
		}

		return true;
	}

	private boolean isAirlineCodenameValid(String airlineCodename) {

		airlinedb.fetchDatabaseContent(airlinems.getListOfAirlines()); // // return airline database content through
																		// given ArrayList
		for (int i = 0; i < airlinems.getListOfAirlines().size(); i++) {
			String airlineCodenameFromList = airlinems.getListOfAirlines().get(i).getAirlineCodename();
			if (airlineCodenameFromList.equals(airlineCodename)) {
				return true;
			}
		}
		System.out.println("Airline codename is not in database.");
		return false;
	}

	private boolean isAirportCodenameValid(String airportCodename) {

		airportdb.fetchDatabaseContent(airportms.getListOfAirports());

		for (int i = 0; i < airportms.getListOfAirports().size(); i++) {
			String airportCodenameFromList = airportms.getListOfAirports().get(i).getAirportCodename();

			if (airportCodenameFromList.equals(airportCodename)) {
				return true;
			}
		}
		System.out.println("Airport codename is not in database.");
		return false;
	}

	private boolean isSeatRowValid(char seatRow) {

		if (seatRow == 'A' || seatRow == 'B' || seatRow == 'C' || seatRow == 'D' || seatRow == 'E' || seatRow == 'F') {
			return true;
		}
		return false;
	}

	public Flight getFlightFromFlightID(int flightID) {

		flightdb.fetchDatabaseContent(listOfFlights); // return flight database content through given ArrayList

		for (int i = 0; i < listOfFlights.size(); i++) {

			int flightIDFromList = listOfFlights.get(i).getFlight_id();

			if (flightID == flightIDFromList) {
				Flight flight = new Flight(listOfFlights.get(i).getAirline(), listOfFlights.get(i).getAirport(),
						listOfFlights.get(i).getDestinationAirport(), listOfFlights.get(i).getFlightClass(),
						listOfFlights.get(i).getDateOfFlight(), listOfFlights.get(i).getSeatRow(),
						listOfFlights.get(i).getSeatNumber(), listOfFlights.get(i).getFlightPrice());
				return flight;

			}
		}

		return null;

	}

	public ArrayList<Flight> getListOfFlights() {
		fetchFlightDatabaseContentToList();
		return listOfFlights;
	}

	public ArrayList<Seat> getListOfSeats() {
		fetchSeatDatabaseContentToList();
		return listOfSeats;
	}

	public void setListOfSeats(ArrayList<Seat> listOfSeats) {
		this.listOfSeats = listOfSeats;
	}

	public void addFlightToDatabase() {

		flightdb.storeToDatabase(flight);

	}

	public ArrayList<Seat> fetchSeatDatabaseContentToList() {

		seatdb.fetchDatabaseContent(listOfSeats);
		if (listOfSeats.isEmpty()) {
			System.out.println("There's no seats stored in database!");
			return null;
		}
		return listOfSeats;
	}

	public ArrayList<Flight> fetchFlightDatabaseContentToList() {

		flightdb.fetchDatabaseContent(listOfFlights);
		if (listOfFlights.isEmpty()) {
			System.out.println("There's no flights stored in database!");
			return null;
		}
		return listOfFlights;
	}

	public void removeFlightFromDatabase(int flight_ID) {

		flightdb.deleteContentFromDatabase(flight_ID);
	}

	private void addSeatToDatabase(Seat seat) {

		seatdb.storeToDatabase(seat);
	}
}
