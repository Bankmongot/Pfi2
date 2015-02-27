package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class TestClass {

	public static void main(String[] args) {
		// Nedanst�ende kod h�mtar tv� stationer (Malm� = 80000, Lund C = 81216), samt visar 20 rese-resultat.
		String searchURL = Constants.getURL("80000","81216",20); //Malm� C = 80000,  Lund C, 81216
		System.out.println(searchURL);
		System.out.println("// Results when searching:");
		
		
		// H�mtar resor fr�n Sk�netrafikens API, och matchar det med stationerna ovan.
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			System.out.println(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		} 
		
	   System.out.println("// Stations when searching for stations containing \"Malm\"");
	   // Skapar en arrayList av stationer som l�ggs in beroende p� s�kresultatet nedan.
		ArrayList<Station> searchStations = new ArrayList<Station>(); 
		// H�mtar alla stationer som b�rjar p� "Malm" och l�gger de i Arraylisten.
		searchStations.addAll(Parser.getStationsFromURL("Malm"));
		for (Station s: searchStations){
			System.out.println(s.getStationName() +" number:" +s.getStationNbr());
		}
	}
}

