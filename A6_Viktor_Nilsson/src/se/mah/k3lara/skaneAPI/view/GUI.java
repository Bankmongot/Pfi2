package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;


import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

@SuppressWarnings("Serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	JTextField searchField;
	JTextField sokFran;
	JTextField sokTill;

	JTextArea resultat1 = new JTextArea();
	JTextArea resultatArea = new JTextArea();
	

	GUI g = this;
	
	private Parser p = new Parser();
	
		Thread t1 = new JourneysThread(p, this);
		Thread t2 = new StationsThread(p, this);

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
		setTitle("Skånetrafiken: Sök resa.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 11, 190, 239);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		searchField = new JTextField();
		searchField.setText("");
		searchField.setBounds(45, 26, 86, 20);
		panel1.add(searchField);
		searchField.setColumns(10);
		
		JButton sokKnapp1 = new JButton("Sök");
		sokKnapp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t2 = new StationsThread(p, g);
				t2.start();
			}
		});
		sokKnapp1.setBounds(45, 78, 89, 23);
		panel1.add(sokKnapp1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 159, 97);
		panel1.add(scrollPane);
		
		
		scrollPane.setViewportView(resultat1);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(210, 11, 214, 239);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		sokFran = new JTextField();
		sokFran.setBounds(61, 30, 86, 20);
		panel2.add(sokFran);
		sokFran.setColumns(10);
		
		sokTill = new JTextField();
		sokTill.setBounds(61, 99, 86, 20);
		panel2.add(sokTill);
		sokTill.setColumns(10);
		
		JLabel lblTill = new JLabel("Till:");
		lblTill.setHorizontalAlignment(SwingConstants.CENTER);
		lblTill.setBounds(81, 81, 46, 14);
		panel2.add(lblTill);
		
		JLabel lblNewLabel = new JLabel("Fr\u00E5n:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 11, 86, 14);
		panel2.add(lblNewLabel);
		
		JButton sokKnapp2 = new JButton("Sok");
		sokKnapp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new JourneysThread(p, g);
				t1.start();
			}
		});
		sokKnapp2.setBounds(61, 142, 89, 23);
		panel2.add(sokKnapp2);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 174, 194, 54);
		panel2.add(scrollPane_1);
		
		scrollPane_1.setViewportView(resultatArea);
	}
}
