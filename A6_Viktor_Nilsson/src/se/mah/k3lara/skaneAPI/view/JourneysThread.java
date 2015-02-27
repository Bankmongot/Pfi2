package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread {

	Parser parser;
	private GUI gui;

	public JourneysThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}
@Override
	public void run() {

		gui.resultatArea.setText(null);
		
		gui.resultatArea.setText("Loading...");

		String searchURL1 = Constants.getURL(gui.sokFran.getText(),
				gui.sokTill.getText(), 1);

		Journeys journeys1 = Parser.getJourneys(searchURL1);
		
		gui.resultatArea.setText(null);
		
		for (Journey journey : journeys1.getJourneys()) {
			gui.resultatArea.append(journey.getStartStation() + " - "
					+ journey.getEndStation());
			String time1 = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
					+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
			gui.resultatArea.append(" Avgår " + time1 + " som är om "
					+ journey.getTimeToDeparture() + " minuter. Den är "
					+ journey.getDepTimeDeviation() + " minuter försenad.");
		}

	}


}
