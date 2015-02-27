import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class GUI extends JFrame {
	ArrayList<Animal> animalList;
	private Dog dogs;
	private Cat cats;
	private Snake snakes;

	private JPanel contentPane;

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
		setTitle("List of different animal species.");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);

		animalList = new ArrayList<Animal>();
		animalList.add(snakes = new Snake("Petrificus lotade",false));
		animalList.add(dogs = new Dog("Niklas","Hundus Sk‰llikus", 3,true));
		animalList.add(cats = new Cat("Missan",6,2));
		animalList.add(cats = new Cat("Snuggles",7,3));
		animalList.add(dogs = new Dog("Barkeley", "Barkaal", 4,true));
		animalList.add(cats = new Cat("Olof",6,9));
		animalList.add(dogs = new Dog("Bengt","Hundus", 7,true));
		animalList.add(cats = new Cat("Cuddlepuss",9,1));
		animalList.add(snakes = new Snake("Potrilinae merriculae",false));
		animalList.add(cats = new Cat("Kelis",1,2));
		animalList.add(snakes = new Snake("Sir V‰‰s",false));

		for(Animal a: animalList){
			textArea.append((a.getInfo())+"\n");
		}
	}
}
