package creator;

import java.util.ArrayList;
import java.util.Scanner;
import manager.Airport;

public class AirportManagementSystem {
	Airport airport;
	private static ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private String airportCodename;
	private String airportFullname;
	private String airportType;
	private String airportCity;
	private String airportCountry;
	private final int AIRPORT_CODENAME_LENGTH = 3;

	public void createAirline() {

		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Please type airport codename!");
			airportCodename = scan.next();
			System.out.println("Please type airport fullname!");
			airportFullname = scan.next();
			System.out.println("Please type airport type!");
			airportType = scan.next();
			System.out.println("Please type airport city!");
			airportCity = scan.next();
			System.out.println("Please type airport country!");
			airportCountry = scan.next();

			Airport airport = new Airport(airportCodename, airportFullname, airportType, airportCity, airportCountry);
			if (isAirportDataUnique()) {
				listOfAirports.add(airport);
			} else {
				System.out.println("Data not unique");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		} finally {
			scan.close();
		}

	}

	private boolean isAirportDataUnique() {

		for (int i = 0; i < listOfAirports.size(); i++) {

			String airportCodenameFromList = listOfAirports.get(i).getAirportCodename();
			if ((!listOfAirports.isEmpty()) && (airportCodenameFromList.equals(airportCodename))) {

				return false;
			}
		}
		return true;
	}

	private boolean isAirportCodenameValid() {

		if (airportCodename.length() == AIRPORT_CODENAME_LENGTH
				&& airportCodename.chars().allMatch(Character::isLetter)) {
			return true;
		}
		return false;
	}

	public ArrayList<Airport> getListOfAirlines() {

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

	public void addAirportToDatabase() {

	}

	public void removeAirportFromDatabase() {

	}
}
