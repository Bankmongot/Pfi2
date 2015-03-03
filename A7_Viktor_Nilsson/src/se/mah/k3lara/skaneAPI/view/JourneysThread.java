package se.mah.k3lara.skaneAPI.view;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.control.Helpers;



public class JourneysThread extends Thread {
	private Parser parser;
	private TrafficGUI gui;
	public boolean running = true;
	
	public JourneysThread (Parser p, TrafficGUI g) {
		this.parser = p;
		this.gui = g;
	
	}
	
	public void run() {
		while(running) {
			Lines lines = Parser.getStationResults(new Station("80046")); // Initiate the type Journeys and give it the value of the search.
			gui.textLine.setText(null);
			gui.textDest.setText(null);
			gui.textDep.setText(null);
			gui.textRemark.setText(null);
			// gui.textAreaDepart.setText(null);
			for (Line l : lines.getLines()) { //Iterate through the list of journeys available
		
				gui.textLine.append(l.getLine()+"\n");
				gui.textDest.append(l.getTowards()+"\n");
				int inHour = l.getDepTime().get(Calendar.HOUR_OF_DAY);
				int inMinute = l.getDepTime().get(Calendar.MINUTE);
				
				gui.textDep.append(String.format("%02d", inHour)+ ":" + String.format("%02d", inMinute)+ "\n");
				
				
				// This checks if there's any deviations from the standard department time. If it is,
				// it will be printed to the "Anmärkningar" textArea. Also updates delays in realtime.
				if (!l.depTimeDeviation.equals("")) {
					 gui.textRemark.append(l.getDepTimeDeviation()+ " Min försenad. \n");
						
					}
				
				
				}
				}	try {
						Thread.sleep(2000);}		
					catch(InterruptedException ex){
							
				
				}
			} 

	}


