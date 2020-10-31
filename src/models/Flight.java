package models;

import java.util.ArrayList;
import java.util.Calendar;

import models.Seat;

public class Flight {
	private ArrayList<Seat> listOfSeats = new ArrayList<Seat>();
	

	private Airline airline;
	private Airport airport;
	private Airport destinationAirport;
	private String flightClass;
	private Calendar dateOfFlight;
	private char seatRow;
	private int seatNumber;
	private double flightPrice;
	private static int flightId = 0;
	
	public Flight (Airline airline, Airport airport, Airport destinationAirport, String flightClass, Calendar dateOfFlight, char seatRow, int seatNumber, double flightPrice) {
		
		this.airline = airline;
		this.airport = airport;
		this.destinationAirport = destinationAirport;
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


	public ArrayList<Seat> getListOfSeats() {
		return listOfSeats;
	}

	public void addToListOfSeats (Seat seat) {
		
		listOfSeats.add(seat);
	}

	@Override
	public String toString() {
		return "Flight [listOfSeats=" + listOfSeats + ", airline=" + airline + ", airport=" + airport
				+ ", destinationAirport=" + destinationAirport + ", flightClass=" + flightClass + ", dateOfFlight="
				+ dateOfFlight + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber + ", flightPrice=" + flightPrice
				+ "]";
	}



	public void setListOfSeats(ArrayList<Seat> listOfSeats) {
		this.listOfSeats = listOfSeats;
	}

	
}
