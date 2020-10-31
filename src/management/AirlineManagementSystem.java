package management;

import java.util.ArrayList;
import java.util.Scanner;

import database.AirlineDatabase;
import models.Airline;

public class AirlineManagementSystem {

	private static ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	AirlineDatabase airlinedatabase = new AirlineDatabase();
	final int AIRLINE_CODENAME_MAX_LENGTH = 6;

	public void createAirline() {

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please type airline codename!");
			String airlineCodename = scan.next();
			System.out.println("Please type airline callsign!");
			String airlineCallsign = scan.next();
			System.out.println("Please type airline country!");
			String airlineCountry = scan.next();

			if (isAirlineDataUnique(airlineCodename) && isAirlineCodenameValid(airlineCodename)) {
				Airline airline = new Airline(airlineCodename, airlineCallsign, airlineCountry);
				listOfAirlines.add(airline);
			} else {
				System.out.println("Data not unique or airline codename not valid.");
			}
			scan.close();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private boolean isAirlineDataUnique(String airlineCodename) {

		for (int i = 0; i < listOfAirlines.size(); i++) {

			String airlineCodenameFromList = listOfAirlines.get(i).getAirlineCodename();
			if ((!listOfAirlines.isEmpty()) && (airlineCodenameFromList.equals(airlineCodename))) {

				return false;
			}
		}
		return true;
	}

	public Airline getAirlineFromCodename(String airlineCodename) {

		for (int i = 0; i < listOfAirlines.size(); i++) {
			String airlineCodenameFromList = listOfAirlines.get(i).getAirlineCodename();
			String airlineCallsignFromList = listOfAirlines.get(i).getAirlineCallsign();
			String airlineCountryFromList = listOfAirlines.get(i).getAirlineCountry();
			if (airlineCodenameFromList.equals(airlineCodename)) {
				Airline airline = new Airline(airlineCodenameFromList, airlineCallsignFromList, airlineCountryFromList);
				return airline;

			}
		}

		return null;

	}

	private boolean isAirlineCodenameValid(String airlineCodename) {

		if (airlineCodename.length() < AIRLINE_CODENAME_MAX_LENGTH
				&& airlineCodename.chars().allMatch(Character::isLetter)) {
			return true;
		}
		return false;
	}

	public void removeAirlineFromArrayList(String airlineCodename) {

		for (int i = 0; i < listOfAirlines.size(); i++) {
			String airlineCodenameFromList = listOfAirlines.get(i).getAirlineCodename();

			if (airlineCodenameFromList.equals(airlineCodename)) {
				listOfAirlines.remove(i);
			}
		}

	}

	public ArrayList<Airline> getListOfAirlines() {

		return listOfAirlines;
	}

	public void addAirlineToDatabase(Airline airline) {

		airlinedatabase.storeToDatabase(airline);
	}

	public void removeAirlineFromDatabase(Airline airline) {

	}
}
