import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;




public class HouseGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseGUI frame = new HouseGUI();
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
	public HouseGUI() {
		setTitle("Assignment 2 Parts 1.2-1.4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		// Konsoldelen av uppgift 1.2
		
		System.out.println("Assignment 2 part 1.2:\n");
		
		House house = new House (1932, 200);
		House house2 = new House (1999, 35);
		House house3 = new House (2012, 68);
		
		System.out.println(house.getYearBuilt() + ", " + house.getSize());
		System.out.println(house2.getYearBuilt() + ", " + house2.getSize());
		System.out.println(house3.getYearBuilt() + ", " + house3.getSize());
		
		
	// TextArea-delen av uppgift 1.2
		textArea.append("Assignment 2 part 1.2\n");
		textArea.append(house.getYearBuilt() + ", " + house.getSize()+ "\n");
		textArea.append(house2.getYearBuilt() + ", " + house2.getSize()+ "\n");
		textArea.append(house3.getYearBuilt() + ", " + house3.getSize()+ "\n");
		
	// Konsol och TextArea-delarna av uppgift 1.3
		System.out.println("Assignment 2 part 1.3\n");
		textArea.append("\nAssignment 2 part 1.3\n");
		
		House[] houseInfo = new House[10];
		houseInfo[	0	] = new House (	1912	, 	300	);
		houseInfo[	1	] = new House (	1929	, 	15	);
		houseInfo[	2	] = new House (	1914	,	31	);
		houseInfo[	3	] = new House (	2003	, 	45	);
		houseInfo[	4	] = new House (	1777	, 	89	);
		houseInfo[	5	] = new House (	2008	, 	236	);
		houseInfo[	6	] = new House (	1846	, 	180	);
		houseInfo[	7	] = new House (	2009	, 	120	);
		houseInfo[	8	] = new House (	2014	, 	75	);
		houseInfo[	9	] = new House (	1992	, 	275	);
		
		for ( int i = 0; i < houseInfo.length; i++){
			System.out.println(houseInfo[i].getYearBuilt() + ", " + houseInfo[i].getSize()+ "\n");
			textArea.append(houseInfo[i].getYearBuilt() + ", " + houseInfo[i].getSize()+ "\n");
			
		}
		
		// Konsol och TextArea-delarna av uppgift 1.4
		ArrayList<House> houseList = new ArrayList<House>();
		Random random = new Random();
		
		System.out.println("Assignment 2 part 1.4\n");
		textArea.append("\nAssignment 2 part 1.4\n");
		
		for (int i = 0; i < 100; i++) {
			houseList.add(new House (random.nextInt(2015 - 1800 + 1)+ 1800, random.nextInt(1000 - 10 + 1) + 12));
		}
		
		for (House housePart2 : houseList) {
			System.out.println(housePart2.getYearBuilt() + ", " + housePart2.getSize());
			textArea.append("Ett hus är byggt år " + housePart2.getYearBuilt() + ", och är  " + housePart2.getSize() + " kvm stort." + "\n");
		}
		
		
	}
}
