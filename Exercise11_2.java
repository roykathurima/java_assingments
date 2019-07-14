package exercises;
/** Exercise 11.2: Measurement Conversion.
 * Write a program to input a measurement expressed in feet and inches via two text fields.
 *	When a button is clicked, convert the measurement to centimetres and display it in a text field,
 * correct to two decimal places. There are 12 inches in a foot; 1 inch is 2.54 centimetres.
Filename:   Exercise11_2.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise11_2 {

	private JFrame frmExercise;
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
					Exercise11_2 window = new Exercise11_2();
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
	public Exercise11_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise11_2");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblFeet = new JLabel("Feet");
		lblFeet.setBounds(10, 36, 48, 14);
		frmExercise.getContentPane().add(lblFeet);
		
		textField = new JTextField();
		textField.setBounds(68, 33, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblInches = new JLabel("Inches");
		lblInches.setBounds(10, 74, 48, 14);
		frmExercise.getContentPane().add(lblInches);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 71, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCentimeters = new JLabel("centimeters");
		lblCentimeters.setBounds(20, 169, 77, 14);
		frmExercise.getContentPane().add(lblCentimeters);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 194, 118, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double feet = Double.parseDouble(textField.getText());
				double inches = Double.parseDouble(textField_1.getText());
				//convert both inches and feet to cm
				double inch2cm = inches*2.54;
				double foot2cm = feet*(2.54*12);
				double t_cm = inch2cm + foot2cm;
				//use the format method to correct the double to 2 decimal places
				String fVal = String.format("%.2f", t_cm);
				textField_2.setText(fVal);
			}
		});
		btnConvert.setBounds(20, 135, 89, 23);
		frmExercise.getContentPane().add(btnConvert);
	}

}
