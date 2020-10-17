package objects;

import java.util.Calendar;

public class Flight {
	
	private Airline airline;
	private Airport airport;
	private String flightClass;
	private Calendar dateOfFlight;
	private char seatRow;
	private int seatNumber;
	private double flightPrice;
	private static int flightId = 0;
	
	public Flight (Airline airline, Airport airport, String flightClass, Calendar dateOfFlight, char seatRow, int seatNumber, double flightPrice) {
		
		this.airline = airline;
		this.airport = airport;
		this.flightClass = flightClass;
		this.dateOfFlight = dateOfFlight;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.flightPrice = flightPrice;
		flightId++;
	}

	public static int getFlight_id() {
		return flightId;
	}

	public static void setFlight_id(int flight_id) {
		Flight.flightId = flight_id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public Calendar getDateOfFlight() {
		return dateOfFlight;
	}

	public void setDateOfFlight(Calendar dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}

	public char getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(char seatRow) {
		this.seatRow = seatRow;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public double getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}

	@Override
	public String toString() {
		return "\nFlight [airline=" + airline + "\nairport=" + airport + "\nflightClass=" + flightClass
				+ ", \ndateOfFlight=" + dateOfFlight.getTime() + ", \nseatRow=" + seatRow + ", \nseatNumber=" + seatNumber
				+ ", \nflightPrice=" + flightPrice + "]";
	}
	
}
