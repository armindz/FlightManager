package management;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Airline;

public class AirlineManagementSystem {

	Airline airline;
	private static ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	private String airlineCodename;
	private String airlineCallsign;
	private String airlineCountry;
	final int AIRLINE_CODENAME_MAX_LENGTH = 6;

	public void createAirline() {

		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Please type airline codename!");
			airlineCodename = scan.next();
			System.out.println("Please type airline callsign!");
			airlineCallsign = scan.next();
			System.out.println("Please type airline country!");
			airlineCountry = scan.next();

			

			if (isAirlineDataUnique() && isAirlineCodenameValid()) {
				Airline airline = new Airline(airlineCodename, airlineCallsign, airlineCountry);
				listOfAirlines.add(airline);
			} else {
				System.out.println("Data not unique or airline codename not valid.");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private boolean isAirlineDataUnique() {

		for (int i = 0; i < listOfAirlines.size(); i++) {

			String airlineCodenameFromList = listOfAirlines.get(i).getAirlineCodename();
			if ((!listOfAirlines.isEmpty()) && (airlineCodenameFromList.equals(airlineCodename))) {

				return false;
			}
		}
		return true;
	}

	private boolean isAirlineCodenameValid() {

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

	public void addAirlineToDatabase() {

	}

	public void removeAirlineFromDatabase() {

	}
}
