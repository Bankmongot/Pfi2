import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField humanName;
	private JTextField dogName;
	private JTextArea textArea_1;
	private JTextArea textArea;
	private JTextField fieldInfo;
	private JTextField fieldError;
	static Human human;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton humanBtn = new JButton("New human");
		humanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(humanName.getText().length() >= 3)
				{ fieldError.setText("");
					human = (new Human (humanName.getText()));
				}
				else { 
					fieldError.setText("Personens namn måste innehålla mer än 3 bokstäver.");
				}
			}
		});
		
		humanBtn.setBounds(215, 57, 108, 26);
		contentPane.add(humanBtn);
		
		
		JButton dogBtn = new JButton("Buy dog");
		dogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dogName.getText().length() > 0) {
					fieldError.setText(" "); 
					if (human == null) {
						fieldError.setText("Hunden måste ha en ägare.");
					}
					else { 
						fieldError.setText("");
						human.buyDog(new Dog(dogName.getText()));
					}
				
			}
		}
		});
		dogBtn.setBounds(215, 100, 108, 23);
		contentPane.add(dogBtn);
		
			
		
		JButton printBtn = new JButton("PRINT INFO");
		printBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human !=null) {
					fieldError.setText("");
					fieldInfo.setText(human.getInfo());
				}
				else { 
					fieldError.setText("Det finns ingen information.");
					
				}
			}
		});
		printBtn.setBounds(65, 142, 231, 23);
		contentPane.add(printBtn);
		
		JLabel lblHumansAndDogs = new JLabel("HUMANS AND DOGS");
		lblHumansAndDogs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHumansAndDogs.setHorizontalAlignment(SwingConstants.CENTER);
		lblHumansAndDogs.setBounds(140, 11, 214, 35);
		contentPane.add(lblHumansAndDogs);
		
		humanName = new JTextField();
		humanName.setBounds(38, 63, 86, 20);
		contentPane.add(humanName);
		humanName.setColumns(10);
		
		dogName = new JTextField();
		dogName.setBounds(38, 101, 86, 20);
		contentPane.add(dogName);
		dogName.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("INFO:");
		lblNewLabel.setBounds(24, 175, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblErrorMessages = new JLabel("Error messages:");
		lblErrorMessages.setBounds(24, 228, 100, 14);
		contentPane.add(lblErrorMessages);
		
		fieldInfo = new JTextField();
		fieldInfo.setForeground(Color.GREEN);
		fieldInfo.setBounds(24, 200, 379, 20);
		contentPane.add(fieldInfo);
		fieldInfo.setColumns(10);
		
		fieldError = new JTextField();
		fieldError.setForeground(Color.RED);
		fieldError.setBounds(24, 248, 379, 20);
		contentPane.add(fieldError);
		fieldError.setColumns(10);
		
	
	}
}
