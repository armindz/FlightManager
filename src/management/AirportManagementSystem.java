package management;

import java.util.ArrayList;
import java.util.Scanner;

import database.AirportDatabase;
import models.Airline;
import models.Airport;

public class AirportManagementSystem {
	
	private static ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	AirportDatabase ad = new AirportDatabase();
	private final int AIRPORT_CODENAME_LENGTH = 3;

	public void createAirport() {

		

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please type airport codename!");
			String airportCodename = scan.next();
			System.out.println("Please type airport fullname!");
			String airportFullname = scan.next();
			System.out.println("Please type airport type!");
			String airportType = scan.next();
			System.out.println("Please type airport city!");
			String airportCity = scan.next();
			System.out.println("Please type airport country!");
			String airportCountry = scan.next();

			
			if (isAirportDataUnique(airportCodename) && isAirportCodenameValid(airportCodename)) {
				Airport airport = new Airport(airportCodename, airportFullname, airportType, airportCity, airportCountry);
				listOfAirports.add(airport);
			} else {
				System.out.println("Data not unique or airport codename not valid");
			}
			
			scan.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		} 

	}

	
 public Airport getAirportFromCodename (String airportCodename) {
		
		for( int i=0; i<listOfAirports.size(); i++) {
			String airportCodenameFromList = listOfAirports.get(i).getAirportCodename();
			String airportFullnameFromList = listOfAirports.get(i).getAirportFullname();
			String airportTypeFromList = listOfAirports.get(i).getAirportType();
			String airportCityFromList = listOfAirports.get(i).getAirportCity();
			String airportCountryFromList = listOfAirports.get(i).getAirportCountry();
			if (airportCodenameFromList.equals(airportCodename)) {
				Airport airport = new Airport(airportCodenameFromList, airportFullnameFromList, airportTypeFromList, airportCityFromList, airportCountryFromList);
				return airport;
				
			}
		}
		
		return null;
		
	}
	private boolean isAirportDataUnique(String airportCodename) {

		for (int i = 0; i < listOfAirports.size(); i++) {

			String airportCodenameFromList = listOfAirports.get(i).getAirportCodename();
			if ((!listOfAirports.isEmpty()) && (airportCodenameFromList.equals(airportCodename))) {

				return false;
			}
		}
		return true;
	}

	private boolean isAirportCodenameValid(String airportCodename) {

		if (airportCodename.length() == AIRPORT_CODENAME_LENGTH
				&& airportCodename.chars().allMatch(Character::isLetter)) {
			return true;
		}
		return false;
	}

	public ArrayList<Airport> getListOfAirports() {

		return listOfAirports;
	}

	public void removeAirportFromArrayList(String airportCodename) {

		for (int i = 0; i < listOfAirports.size(); i++) {
			String airlineCodenameFromList = listOfAirports.get(i).getAirportCodename();

			if (airlineCodenameFromList.equals(airportCodename)) {
				listOfAirports.remove(i);
			}
		}

	}

	public void addAirportToDatabase(Airport airport) {

		ad.storeToDatabase(airport);
	}

	public void removeAirportFromDatabase() {

	}
}
