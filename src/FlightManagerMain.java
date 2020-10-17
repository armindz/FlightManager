import java.util.Calendar;
import java.util.Date;

import booking.BookingFlightTicket;
import management.AirlineManagementSystem;
import management.AirportManagementSystem;
import management.FlightManagementSystem;
import objects.Airline;
import objects.Airport;
import objects.Flight;

public class FlightManagerMain {

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		BookingFlightTicket bft = new BookingFlightTicket();
		AirlineManagementSystem ams = new AirlineManagementSystem();

		Airline wizz = new Airline("WZZ", "Wizzair", "HUNGARY");
		Airline turkish = new Airline("TAA", "TurkishAirlines", "Turkey");
		ams.getListOfAirlines().add(wizz);
		ams.getListOfAirlines().add(turkish);

		AirportManagementSystem aams = new AirportManagementSystem();
		Airport sarajevo = new Airport("SJJ", "SarajevoInternational", "Large", "Sarajevo", "Bosnia and Herzegovina");
		Airport tuzla = new Airport("TZL", "TuzlaInternational", "Medium", "Tuzla", "Bosnia and Herzegovina");
		aams.getListOfAirlines().add(sarajevo);
		aams.getListOfAirlines().add(tuzla);
		Flight tzbg = new Flight(wizz, tuzla, "Economy", cal, 'A', 1, 34);
		Flight tzbg1 = new Flight(wizz, tuzla, "Economy", cal, 'A', 2, 34);
		Flight tzbg2= new Flight(wizz, tuzla, "Economy", cal, 'A', 3, 34);
		Flight tzbg3= new Flight(wizz, tuzla, "Economy", cal, 'A', 4, 34);
		Flight tzbg4= new Flight(wizz, tuzla, "Economy", cal, 'A', 5, 34);
		Flight tzbg5= new Flight(wizz, tuzla, "Economy", cal, 'A', 6, 34);
		Flight tzbg6= new Flight(wizz, tuzla, "Economy", cal, 'A', 7, 34);
		Flight tzbg7= new Flight(wizz, tuzla, "Economy", cal, 'B', 1, 34);
		Flight tzbg8= new Flight(wizz, tuzla, "Economy", cal, 'B', 2, 34);
		Flight tzbg9= new Flight(wizz, tuzla, "Economy", cal, 'B', 3, 34);
		Flight tzbg10= new Flight(wizz, tuzla, "Economy", cal, 'B', 4, 34);
		Flight tzbg11= new Flight(wizz, tuzla, "Economy", cal, 'B', 5, 34);
		Flight tzbg12= new Flight(wizz, tuzla, "Economy", cal, 'B', 6, 34);
		Flight tzbg13= new Flight(wizz, tuzla, "Economy", cal, 'B', 7, 34);
		Flight tzbg14= new Flight(wizz, tuzla, "Economy", cal, 'C', 1, 34);
		Flight tzbg15= new Flight(wizz, tuzla, "Economy", cal, 'D', 2, 34);
		
		FlightManagementSystem fms = new FlightManagementSystem();
		fms.getListOfAvailableFlights().add(tzbg);
		fms.getListOfAvailableFlights().add(tzbg1);
		fms.getListOfAvailableFlights().add(tzbg2);
		fms.getListOfAvailableFlights().add(tzbg3);
		FlightManagementSystem.getListOfFlights().add(tzbg);
		FlightManagementSystem.getListOfFlights().add(tzbg1);
		FlightManagementSystem.getListOfFlights().add(tzbg2);
		FlightManagementSystem.getListOfFlights().add(tzbg3);
		FlightManagementSystem.getListOfFlights().add(tzbg4);
		FlightManagementSystem.getListOfFlights().add(tzbg5);
		FlightManagementSystem.getListOfFlights().add(tzbg6);
		FlightManagementSystem.getListOfFlights().add(tzbg7);
		FlightManagementSystem.getListOfFlights().add(tzbg8);
		FlightManagementSystem.getListOfFlights().add(tzbg9);
		FlightManagementSystem.getListOfFlights().add(tzbg10);
		FlightManagementSystem.getListOfFlights().add(tzbg11);
		FlightManagementSystem.getListOfFlights().add(tzbg12);
		FlightManagementSystem.getListOfFlights().add(tzbg13);
		FlightManagementSystem.getListOfFlights().add(tzbg14);
		FlightManagementSystem.getListOfFlights().add(tzbg15);

		System.out.println(ams.getListOfAirlines());
		System.out.println(aams.getListOfAirlines());
		System.out.println(fms.getListOfFlights());
		bft.bookAFlight(1, "Economy", 'A', 2);
		System.out.println(bft.getListOfBookedFlights());
		

	}
}
