package management;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import booking.BookingFlightTicket;

import objects.Flight;

public class FlightManagementSystem {

	private Flight flight;
	private static ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private static ArrayList<Flight> listOfAvailableFlights = new ArrayList<Flight>();
	private static ArrayList<Flight> listOfBookedFlights = BookingFlightTicket.getListOfBookedFlights();
	AirlineManagementSystem airlinems = new AirlineManagementSystem();
	AirportManagementSystem airportms = new AirportManagementSystem();
	private String airlineCodename;
	private String airportCodename;
	private String destinationAirportCodename;
	private String flightClass;
	private Calendar dateOfFlight;
	private char seatRow;
	private int seatNumber;
	private double flightPrice;
	private int flightId = Flight.getFlight_id();

	public void createFlight() {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.println("Please type airline codename!");
			airlineCodename = scan.next();
			System.out.println("Please type airport codename!");
			airportCodename = scan.next();
			System.out.println("Please type destination airport codename!");
			destinationAirportCodename = scan.next();
			System.out.println("Please type flight class!");
			flightClass = scan.next();
			System.out.println("Please type seat row!");
			seatRow = scan.next().charAt(0);
			System.out.println("Please type seat number!");
			seatNumber = scan.nextInt();
			System.out.println("Please type flight price!");
			flightPrice = scan.nextDouble();
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
			dateOfFlight = Calendar.getInstance();
			dateOfFlight.set(year, month - 1, day, hourOfDay, minute);
			System.out.println(dateOfFlight.getTime());
			Flight flight = new Flight(airlineCodename, airportCodename, destinationAirportCodename, flightClass,
					dateOfFlight, seatRow, seatNumber, flightPrice);
			
			if (isFlightDataUnique(flight) && isSeatRowValid(seatRow) && isAirlineCodenameValid(airlineCodename)
					&& isAirportCodenameValid(airportCodename) && isAirportCodenameValid(destinationAirportCodename)) {
				listOfFlights.add(flight);
			} else {
				System.out.println("Data is not unique or seat row not valid.");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}

		finally {
			scan.close();
		}
	}

	private boolean isFlightDataUnique(Flight flight) {

		if (!listOfFlights.isEmpty() && listOfFlights.contains(flight)) {
			return false;
		}

		return true;
	}

	private boolean isAirlineCodenameValid(String airlineCodename) {
		for (int i = 1; i < airlinems.getListOfAirlines().size(); i++) {
			String airlineCodenameFromList = airlinems.getListOfAirlines().get(i).getAirlineCodename();
			if (airlineCodenameFromList.equals(airlineCodename)) {
				return true;
			}
		}
		System.out.println("Airline codename is not in database.");
		return false;
	}

	private boolean isAirportCodenameValid(String airportCodename) {
		for (int i = 1; i < airportms.getListOfAirports().size(); i++) {
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

	public void removeFlightFromAvailableFlights(int flightId) {
		for (int i = 0; i < listOfAvailableFlights.size(); i++) {
			listOfAvailableFlights.get(i);
			int flightIdFromList = Flight.getFlight_id();

			if (flightIdFromList == flightId) {
				// listOfBookedFlights.add(i, flight);
				listOfAvailableFlights.remove(i);
			}
		}

	}

	public static ArrayList<Flight> getListOfFlights() {

		return listOfFlights;
	}

	public static ArrayList<Flight> getListOfAvailableFlights() {
		return listOfAvailableFlights;
	}

	public static void setListOfAvailableFlights(ArrayList<Flight> listOfAvailableFlights) {
		FlightManagementSystem.listOfAvailableFlights = listOfAvailableFlights;
	}

	public void addFlightToDatabase() {

	}

	public void removeFlightFromDatabase() {

	}
}
