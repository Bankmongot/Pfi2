package se.mah.k3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Circles extends JPanel implements ActionListener, MouseListener {
	private int width = 50;
	private int height = 50;
	Timer tm;
	int x = 0, velX = 1;
	int size = 0;
	
	int votes = 0;
	//private JPanel panel;
	int xPos = 0;
	int yPos = 0;

	
	
	public Circles(int xPos, int yPos, int votes) {
		addMouseListener(this);
		//panel = new JPanel();
		this.votes = votes;
		this.xPos = xPos;
		this.yPos = yPos;
		
	
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g.drawString("ScreenNbr: "+Constants.screenNbr, 10,  20);
		g2.fillOval(0,0,50+x,50+x);
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("suuuup");
		tm = new Timer(5,this);
		size += 10;
		tm.start();
		System.out.println(x);
		
		

	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		x = x + velX;
		repaint();
		
		if (x > size) {
			tm.stop();
		
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
//	public JPanel getPanel(){
//		return panel;
//	}

}
