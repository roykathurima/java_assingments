package exercises;

/** Exercise: 9. Balloons Add to the class Balloon some additional data:
 *  a String that holds the name of the balloon and a Color variable that describes its color.
 *  Add code to initialize these values using a constructor method.
 *  Add the code to display the colored balloon and its name.
 *  Enhance the balloon program with buttons that move the balloon left, right, up and down.         
Filename:   Exercise9.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.awt.event.ActionEvent;

public class Exercise9 {

	private JFrame frmExercise;
	private Balloon panel;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise9 window = new Exercise9();
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
	public Exercise9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise9");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		panel = new Balloon();
		panel.setPreferredSize(new Dimension(450,175));
		panel.setBounds(0, 0, 450, 175);
		frmExercise.getContentPane().add(panel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 211, 48, 14);
		frmExercise.getContentPane().add(lblName);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 236, 48, 14);
		frmExercise.getContentPane().add(lblColor);
		
		textField = new JTextField();
		textField.setBounds(67, 208, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 233, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String color = textField.getText();
				panel.Balloon(name, color);
				label.setText(name);
			}
		});
		btnUpdate.setBounds(171, 232, 89, 23);
		frmExercise.getContentPane().add(btnUpdate);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calls the panel method
				panel.up();
			}
		});
		btnUp.setBounds(322, 183, 60, 23);
		frmExercise.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.down();
			}
		});
		btnDown.setBounds(322, 232, 76, 23);
		frmExercise.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.left();
			}
		});
		btnLeft.setBounds(275, 207, 71, 23);
		frmExercise.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.right();
			}
		});
		btnRight.setBounds(356, 207, 68, 23);
		frmExercise.getContentPane().add(btnRight);
		
		label = new JLabel("");
		label.setBounds(53, 187, 150, 14);
		frmExercise.getContentPane().add(label);
	}
	//inner class inorder to inherit the Graphics object
	class Balloon extends JPanel{
		private String name;
		private String color;
		//the superclass constructor
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);
			g.setColor(Color.blue);
			//g.fillOval(x, y, width, height);
			g.fillOval(185, 45, 50, 75);
		}
		public void Balloon(String name, String color) {
			Graphics g = this.getGraphics();
			//redraw the initial artifact
			repaint();
			this.name= name;
			this.color = color;
			setBackground(Color.WHITE);
			g.setColor(Color.getColor(this.color));
			g.fillOval(185, 45, 50, 75);
		}
		//method to move the balloon up
		public void up() {
			Graphics g = this.getGraphics();
			//g.clearRect(0, 0, 500, 500);
			//setBackground(Color.WHITE);
			//clear the canvas in order to redraw the artifact
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.black);
			g.fillOval(185, 2, 50, 75);
		}
		//method to move the balloon down
		public void down() {
			Graphics g = this.getGraphics();
			//g.clearRect(0, 0, 500, 500);
			//super.setBackground(Color.WHITE);
			//clear the canvas in order to redraw the artifact
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.black);
			g.fillOval(185, 100, 50, 75);
		}
		//method to move the balloon right
		public void right() {
			Graphics g = this.getGraphics();
			//g.clearRect(0, 0, 500, 500);
			super.setBackground(Color.WHITE);
			//g.fillOval(x, y, width, height);
			//clear the canvas in order to redraw the artifact
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.black);
			g.fillOval(350, 45, 50, 75);	
		}
		//method to move the balloon left
		public void left() {
			Graphics g = this.getGraphics();
			//g.clearRect(0, 0, 500, 500);
			//clear the canvas in order to redraw the artifact
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.black);
			g.fillOval(30, 45, 50, 75);	
		}
	}

}
