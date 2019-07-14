package exercises;

/** Exercise: 5.4: code a method which draws a circle,
 * given the coordinates of the centre and the radius its header should be:
 * private void drawCircle(graphics drawingArea, int xCenter, int yCenter, int radius)      
Filename:   Exercise5_4.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise5_4 {

	private JFrame frmExercise;
	private drawCircle panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise5_4 window = new Exercise5_4();
					window.frmExercise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exercise5_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise5_4");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		//instantiates the drawcircle circle and adds it to the container
		panel = new drawCircle();
		panel.setPreferredSize(new Dimension(450,200));
		panel.setBounds(0, 0, 450, 200);
		frmExercise.getContentPane().add(panel);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(10, 208, 19, 14);
		frmExercise.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setBounds(10, 233, 29, 14);
		frmExercise.getContentPane().add(lblY);
		
		textField = new JTextField();
		textField.setBounds(20, 205, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 230, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setBounds(126, 208, 48, 14);
		frmExercise.getContentPane().add(lblRadius);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 205, 96, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		//code to instantiate the enter button
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//takes the string in the textfield converts it into an integer and stores it in
				//a variable
				int x = Integer.parseInt(textField.getText());
				int y = Integer.parseInt(textField_1.getText());
				int radius = Integer.parseInt(textField_2.getText());
				//creates a null graphics object and passses it to drawCircle method
				Graphics g = null;
				panel.drawCircle(g, x, y, radius);
			}
		});
		btnEnter.setBounds(170, 229, 89, 23);
		frmExercise.getContentPane().add(btnEnter);
	}
	///**
	//inner class to allow memebers to inherit the Graphics class
	class drawCircle extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);		
		}
		//The method that is called to draw the circle
		public void drawCircle(Graphics drawingArea, int xCenter, int yCenter, int radius) {
			drawingArea = this.getGraphics();
			drawingArea.drawOval(xCenter, yCenter, radius, radius);
		}
	}
	//*/
	
}
