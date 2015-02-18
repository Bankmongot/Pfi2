import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.util.Date;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.EventListener;
import java.awt.Image;
import javax.swing.Timer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;



public class DigitalClockGUI extends JFrame implements ActionListener {
	
	
	
	private JPanel contentPane;
	private ClockLogic clockLogic;
	Timer timer;
	
	// Makes you able to call upon a specific date format. Also used with import.
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	private JLabel labelTime = new JLabel("");
	
	private JTextField textField;
	private JTextField textField_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DigitalClockGUI() {
		setMinimumSize(new Dimension(650, 350));
		setMaximumSize(new Dimension(650, 350));
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		
		// sets a new timer that ever 0,5 seconds repeats itself.
		timer = new Timer(500,this);
		timer.setRepeats(true);
		timer.start();
		
		pack();
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetAlarmMinutes = new JLabel("Set alarm minutes:");
		lblSetAlarmMinutes.setForeground(Color.WHITE);
		lblSetAlarmMinutes.setFont(new Font("Open Sans Light", Font.PLAIN, 16));
		lblSetAlarmMinutes.setBounds(318, 125, 165, 23);
		contentPane.add(lblSetAlarmMinutes);
		
		JLabel lblSetAlarmHours = new JLabel("Set alarm hours:");
		lblSetAlarmHours.setFont(new Font("Open Sans Light", Font.PLAIN, 16));
		lblSetAlarmHours.setForeground(Color.WHITE);
		lblSetAlarmHours.setBounds(330, 77, 145, 23);
		contentPane.add(lblSetAlarmHours);
		
		// labelTime (the ticking clock) has a setText value that prints the computer systems current time.
		
		labelTime.setForeground(Color.WHITE);
		labelTime.setFont(new Font("Open Sans Light", Font.PLAIN, 38));
		labelTime.setBounds(26, 11, 174, 63);
		labelTime.setText(sdf.format(new Date(System.currentTimeMillis())));
		contentPane.add(labelTime);
		
		textField = new JTextField();
		textField.setBounds(459, 78, 78, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(459, 129, 78, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		// All "final" parts are used to get their values changed in some way.
		// Error Message, Ok message, alarm time, status of alarm and the clock icon.
		
		final JLabel errorMsg = new JLabel("");
		errorMsg.setForeground(new Color(204, 0, 0));
		errorMsg.setBounds(367, 210, 191, 14);
		contentPane.add(errorMsg);
		
		final JLabel okMsg = new JLabel("");
		okMsg.setFont(new Font("Open Sans Semibold", Font.PLAIN, 14));
		okMsg.setForeground(new Color(51, 204, 102));
		okMsg.setBounds(413, 210, 165, 37);
		contentPane.add(okMsg);
		
		
		final JLabel statusAlarm = new JLabel("");
		statusAlarm.setForeground(Color.WHITE);
		statusAlarm.setFont(new Font("Open Sans Light", Font.PLAIN, 16));
		statusAlarm.setBounds(26, 80, 105, 16);
		contentPane.add(statusAlarm);
		
		final JLabel alarmTime = new JLabel("");
		alarmTime.setFont(new Font("Open Sans Light", Font.PLAIN, 17));
		alarmTime.setForeground(Color.WHITE);
		alarmTime.setBounds(26, 101, 86, 28);
		contentPane.add(alarmTime);
		
		final JLabel clockIcon = new JLabel("New label");
		clockIcon.setBounds(194, 0, 70, 90);
		contentPane.add(clockIcon);

		
		JButton btnNewButton_1 = new JButton("SET ALARM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				int hourCheck = Integer.parseInt(textField.getText());
				int minuteCheck = Integer.parseInt(textField_1.getText());
				
				// Checks if entered hour and minute values entered in textfields are
				// extends over 23 hrs or 59 minutes.
				if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
						|| minuteCheck > 59) {
					errorMsg.setText("Please enter realistic values.");
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
					alarmTime.setText(addZero + hourCheck + ":" + addZero1
							+ minuteCheck);

				

					addZero = "";
					addZero1 = "";
					
					// On pressing this button, this also happens:
					errorMsg.setText("");
					okMsg.setText("*Alarm has been set.");
					statusAlarm.setText("New alarm:");
					clockIcon.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/clock.PNG")));

				}

			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 204, 102));
		btnNewButton_1.setFont(new Font("Open Sans Semibold", Font.PLAIN, 14));
		btnNewButton_1.setBounds(413, 176, 124, 23);
		contentPane.add(btnNewButton_1);
		
		
		// Adds a clear button that when pressed, erases set 
		// alarms and also entered values in hours and minutes textfields.
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alarmTime.setText("");
				textField.setText("");
				textField_1.setText("");
				statusAlarm.setText("");
				okMsg.setText("");
				clockIcon.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("")));
			}
		});
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Open Sans Semibold", Font.PLAIN, 9));
		btnNewButton.setBounds(547, 177, 78, 23);
		contentPane.add(btnNewButton);
		
		
	
		// Background image
		JLabel lblNewLabel_1 = new JLabel("Nighttime");
		lblNewLabel_1.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/nighttime.jpg")));
		lblNewLabel_1.setBounds(0, 0, 634, 311);
		contentPane.add(lblNewLabel_1);
		
		
	}

	public void setTimeOnLabel(String time) {
		labelTime.setText(time);
		
		
	}
	
	
	public void alarm(boolean activate){
		
	}
	// Updates the ticking clock value by checking if 
	//the current time matches the value of the timer. If not it does, print the current system time clock again.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(timer)) {
			labelTime.setText(sdf.format(new Date(System.currentTimeMillis())));
		}
		
	}
}
