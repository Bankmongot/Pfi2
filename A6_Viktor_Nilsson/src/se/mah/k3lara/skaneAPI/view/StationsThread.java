
package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread {

	private Parser parser;
	private GUI gui;

	public StationsThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}

	public void run() {

		gui.resultat1.setText(null);

		gui.resultat1.setText("Loading...");

		
		ArrayList<Station> searchStations1 = new ArrayList<Station>();

		searchStations1.addAll(Parser.getStationsFromURL(gui.searchField
				.getText()));
		
		gui.resultat1.setText(null);
		
		for (Station s : searchStations1) {
			gui.resultat1.append(s.getStationName() + " number:"
					+ s.getStationNbr() + " latitude: " + s.getLatitude()
					+ " longitude: " + s.getLongitude() + "\n");
		}

	}

}