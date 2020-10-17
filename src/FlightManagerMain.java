import java.util.Calendar;
import java.util.Date;

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
		Flight tzbg = new Flight(wizz, tuzla, "Economy", cal, 'A', 22, 34);
		FlightManagementSystem fms = new FlightManagementSystem();
		FlightManagementSystem.getListOfFlights().add(tzbg);

		System.out.println(ams.getListOfAirlines());
		System.out.println(aams.getListOfAirlines());
		System.out.println(fms.getListOfFlights());

	}
}
