import java.util.Calendar;
import java.util.Timer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.EventListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.ImageIcon;

public class ClockThread extends Thread {
	


	// links Clockthread class with interface class of ClockInterface
	ClockInterface clockInterface;
	DigitalClockGUI gui;
	

	public ClockThread ( ClockInterface ci, DigitalClockGUI g) {
		this.clockInterface = ci;
		this.gui = g;
		
	}

	



	private boolean active = true;

	
	
	
	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		int hourCheck = Integer.parseInt(gui.textField.getText());
		int minuteCheck = Integer.parseInt(gui.textField_1.getText());
		
		
		if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
				|| minuteCheck > 59) {
			gui.errorMsg.setText("Please enter realistic values.");
		// Else if the values are below 10, it adds a zero to the single value.
		// prints it like for example "03" instead of "3".
		} else {
			String addZero = "";
			String addZero1 = "";

			if (hourCheck < 10) {
				addZero = "0";
			}
			if (minuteCheck < 10) {
				addZero1 = "0";
			}

			// Applies zeros to alarm label.
			gui.alarmTime.setText(addZero + hourCheck + ":" + addZero1
					+ minuteCheck);

		

			addZero = "";
			addZero1 = "";
			
			// On pressing this button, this also happens:
			gui.errorMsg.setText("");
			gui.okMsg.setText("*Alarm has been set.");
			gui.statusAlarm.setText("New alarm:");
			gui.clockIcon.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/clock.PNG")));

		}

	}
	
	
	
		
	}




