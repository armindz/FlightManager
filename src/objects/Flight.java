package objects;

import java.util.Calendar;

public class Flight {
	
	private String airlineCodename;
	private String airportCodename;
	private String destinationAirportCodename;
	private String flightClass;
	private Calendar dateOfFlight;
	private char seatRow;
	private int seatNumber;
	private double flightPrice;
	private static int flightId = 0;
	
	public Flight (String airlineCodename, String airportCodename, String destinationAirportCodename, String flightClass, Calendar dateOfFlight, char seatRow, int seatNumber, double flightPrice) {
		
		this.airlineCodename = airlineCodename;
		this.airportCodename = airportCodename;
		this.destinationAirportCodename = destinationAirportCodename;
		this.flightClass = flightClass;
		this.dateOfFlight = dateOfFlight;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.flightPrice = flightPrice;
		flightId++;
	}

	public String getAirlineCodename() {
		return airlineCodename;
	}

	public void setAirlineCodename(String airlineCodename) {
		this.airlineCodename = airlineCodename;
	}

	public String getAirportCodename() {
		return airportCodename;
	}

	public void setAirportCodename(String airportCodename) {
		this.airportCodename = airportCodename;
	}

	public String getDestinationAirportCodename() {
		return destinationAirportCodename;
	}

	public void setDestinationAirportCodename(String destinationAirportCodename) {
		this.destinationAirportCodename = destinationAirportCodename;
	}

	public static int getFlight_id() {
		return flightId;
	}

	public static void setFlight_id(int flight_id) {
		Flight.flightId = flight_id;
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
		return "Flight [airlineCodename=" + airlineCodename + ", airportCodename=" + airportCodename
				+ ", destinationAirportCodename=" + destinationAirportCodename + ", flightClass=" + flightClass
				+ ", dateOfFlight=" + dateOfFlight.getTime() + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber
				+ ", flightPrice=" + flightPrice + "]";
	}


	
}
