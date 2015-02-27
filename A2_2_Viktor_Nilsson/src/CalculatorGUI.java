import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;


public class CalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Calculator calculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
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
	public CalculatorGUI() {
		setTitle("Calculator Assignment 2, Part 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(UIManager.getColor("Button.light"));
		textField.setEditable(false);
		textField.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		textField.setBounds(0, 0, 434, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		calculator = new Calculator();
		


		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(1);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn1.setBounds(116, 178, 65, 65);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(2);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn2.setBounds(178, 178, 65, 65);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(3);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn3.setBounds(241, 178, 65, 65);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(4);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn4.setBounds(116, 115, 65, 65);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(5);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn5.setBounds(178, 115, 65, 65);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(6);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn6.setBounds(241, 115, 65, 65);
		contentPane.add(btn6);
		
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculator.numberButtonPressed(7);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn7.setBounds(116, 53, 65, 65);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(8);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn8.setBounds(178, 53, 65, 65);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(9);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn9.setBounds(241, 53, 65, 65);
		contentPane.add(btn9);
		
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(0);
				textField.setText(String.valueOf(calculator.getOperand()));
			}
		});
		btn0.setBounds(116, 242, 127, 36);
		contentPane.add(btn0);
		
		JButton btnComma = new JButton(",");
		btnComma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComma.setBounds(241, 242, 65, 36);
		contentPane.add(btnComma);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.plus();
			}
		});
		btnPlus.setBounds(0, 53, 118, 65);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.minus();
			}
		});
		btnMinus.setBounds(0, 115, 118, 65);
		contentPane.add(btnMinus);
		
		JButton btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.mult();
			}
		});
		btnMulti.setBounds(0, 178, 118, 53);
		contentPane.add(btnMulti);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDivide.setBounds(0, 230, 118, 48);
		contentPane.add(btnDivide);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.clear();
				textField.setText(null);
			}
		});
		btnClear.setBounds(303, 53, 131, 94);
		contentPane.add(btnClear);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.equals();
				textField.setText(String.valueOf(calculator.getResult()));
			}
		});
		btnEquals.setBounds(303, 144, 131, 134);
		contentPane.add(btnEquals);
		
		
		
	}
}
