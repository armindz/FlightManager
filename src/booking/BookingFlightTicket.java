package booking;

import java.util.ArrayList;
import java.util.Calendar;

import management.FlightManagementSystem;
import objects.Flight;

public class BookingFlightTicket {

	private Flight flight;
	private FlightManagementSystem fms;
	private ArrayList<Flight> listOfFlights = FlightManagementSystem.getListOfFlights();
	private ArrayList<Flight> listOfAvailableFlights = FlightManagementSystem.getListOfAvailableFlights();
	private static ArrayList<Flight> listOfBookedFlights = new ArrayList<>();

	public void bookAFlight(int flightId, String flightClass, char seatRow, int seatNumber) {

		if (isFlightAvailable(flightId, flightClass, seatRow, seatNumber)) {
			addToBookedFlightsList(flightId);
			System.out.println("Successfully booked!");

		} else {
			System.out.println("Problem with booking a flight. Be aware of typing mistakes! ");
		}
	}

	private boolean isFlightAvailable(int flightId, String flightClass, char seatRow, int seatNumber) {

		for (int i = 0; i < listOfAvailableFlights.size(); i++) {
			listOfAvailableFlights.get(i);
			int flightIdFromList = Flight.getFlight_id();
			String flightClassFromList = listOfAvailableFlights.get(i).getFlightClass();
			char seatRowFromList = listOfAvailableFlights.get(i).getSeatRow();
			int seatNumberFromList = listOfAvailableFlights.get(i).getSeatRow();
			if ((flightIdFromList == flightId) && (flightClass.equals(flightClassFromList))
					&& (seatRow != seatRowFromList) && (seatNumber != seatNumberFromList)) {
				return true;
			} else {
				System.out.println("Seat is not available");
			}

		}
		return false;
	}

	public void addToBookedFlightsList(int flightId) {

		for (int i = 0; i < listOfAvailableFlights.size(); i++) {
			listOfAvailableFlights.get(i);
			int flightIdFromList = Flight.getFlight_id();

			if (flightIdFromList == flightId) {
				listOfBookedFlights.add(i, flight);
				fms.removeFlightFromAvailableFlights(flightId);
			}
		}
	}
	
	public void displayAvailableSeatsInFlight (int flightId) {
		

		for (int i = 0; i < listOfAvailableFlights.size(); i++) {
			listOfAvailableFlights.get(i);
			int flightIdFromList = listOfAvailableFlights.get(i).getFlight_id();

			if (flightIdFromList == flightId) {
				System.out.println("Flight class:" + listOfAvailableFlights.get(i).getFlightClass());
				System.out.println("Seat row:" + listOfAvailableFlights.get(i).getSeatRow());
				System.out.println("Seat number:" + listOfAvailableFlights.get(i).getSeatNumber());
			}
	}
	}

	public static ArrayList<Flight> getListOfBookedFlights() {
		return listOfBookedFlights;
	}

	public static void setListOfBookedFlights(ArrayList<Flight> listOfBookedFlights) {
		BookingFlightTicket.listOfBookedFlights = listOfBookedFlights;
	}

}
