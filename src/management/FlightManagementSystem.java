package management;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import booking.BookingFlightTicket;
import database.AirlineDatabase;
import database.AirportDatabase;
import database.FlightDatabase;
import models.Airline;
import models.Flight;
import models.Seat;

public class FlightManagementSystem {

	private static ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Seat> listOfSeats = new ArrayList<Seat>();
//	private static ArrayList<Flight> listOfBookedFlights = BookingFlightTicket.getListOfBookedFlights();
	AirlineManagementSystem airlinems = new AirlineManagementSystem();
	AirportManagementSystem airportms = new AirportManagementSystem();

	FlightDatabase fd = new FlightDatabase();

	public void createFlight() {

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please type airline codename!");
			String airlineCodename = scan.next();
			System.out.println("Please type airport codename!");
			String airportCodename = scan.next();
			System.out.println("Please type destination airport codename!");
			String destinationAirportCodename = scan.next();
			System.out.println("Please type flight class!");
			String flightClass = scan.next();
			System.out.println("Please type seat row!");
			char flightSeatRows = scan.next().charAt(0);
			System.out.println("Please type seat number!");
			int flightNumberOfSeatsPerRow = scan.nextInt();
			System.out.println("Please type flight price!");
			double flightPrice = scan.nextDouble();
			System.out.println("Please type date of flight!");
			System.out.println("YEAR");
			int year = scan.nextInt();
			System.out.println("MONTH");
			int month = scan.nextInt();
			System.out.println("DAY");
			int day = scan.nextInt();
			System.out.println("HOURS");
			int hourOfDay = scan.nextInt();
			System.out.println("MIN");
			int minute = scan.nextInt();
			Calendar dateOfFlight = Calendar.getInstance();
			dateOfFlight.set(year, month - 1, day, hourOfDay, minute);
			System.out.println(dateOfFlight.getTime());

			Flight flight = new Flight(airlinems.getAirlineFromCodename(airlineCodename),
					airportms.getAirportFromCodename(airportCodename),
					airportms.getAirportFromCodename(destinationAirportCodename), flightClass, dateOfFlight,
					flightSeatRows, flightNumberOfSeatsPerRow, flightPrice);

			if (isFlightDataUnique(flight) && isSeatRowValid(flightSeatRows) && isAirlineCodenameValid(airlineCodename)
					&& isAirportCodenameValid(airportCodename) && isAirportCodenameValid(destinationAirportCodename)) {
				listOfFlights.add(flight);
				createSeats(flight, flightSeatRows, flightNumberOfSeatsPerRow);
			} else {
				System.out.println("Data is not unique or seat row not valid.");
			}
			scan.close();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	

	private void createSeats(Flight flight, char seatRow, int numberOfSeatsPerRow) {

		for (int i = 'A'; i <= seatRow; i++) { // int i=65
			for (int j = 1; j <= numberOfSeatsPerRow; j++) {
				char seatRows = (char) i;
				Seat seat = new Seat(Flight.getFlight_id(), seatRows, j, true);
				flight.addToListOfSeats(seat);
			}
		}
	}

	private boolean isFlightDataUnique(Flight flight) {

		if (!listOfFlights.isEmpty() && listOfFlights.contains(flight)) {
			return false;
		}

		return true;
	}

	private boolean isAirlineCodenameValid(String airlineCodename) {
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

	public void removeFlightFromArrayList(int flightId) {

		for (int i = 0; i < listOfFlights.size(); i++) {
			listOfFlights.get(i);
			int flightIdFromList = Flight.getFlight_id();

			if (flightIdFromList == flightId) {
				listOfFlights.remove(i);
			}
		}

	}

	public static ArrayList<Flight> getListOfFlights() {

		return listOfFlights;
	}
	public ArrayList<Seat> getListOfSeats() {
		return listOfSeats;
	}

	public void setListOfSeats(ArrayList<Seat> listOfSeats) {
		this.listOfSeats = listOfSeats;
	}
	public void addFlightToDatabase(Flight flight) {

//		fd.storeToDatabase(flight);

	}

	public void removeFlightFromDatabase() {

	}
}
