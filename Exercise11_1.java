package exercises;
/** Exercise 11.1: Cost of phone call. A phone call costs 10 cents per minute.
  	Write a program that inputs via text fields the duration of a phone call, expressed in hours,
  	minutes and seconds, and displays the cost of the phone call in cents, accurate to the nearest cent.
Filename:   Exercise11_1.java
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

public class Exercise11_1 {

	private JFrame frmExercise;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise11_1 window = new Exercise11_1();
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
	public Exercise11_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise11_1");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblHrs = new JLabel("HRS");
		lblHrs.setBounds(10, 31, 48, 14);
		frmExercise.getContentPane().add(lblHrs);
		
		textField = new JTextField();
		textField.setBounds(62, 28, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMin = new JLabel("MIN");
		lblMin.setBounds(10, 82, 48, 14);
		frmExercise.getContentPane().add(lblMin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 79, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSec = new JLabel("SEC");
		lblSec.setBounds(10, 136, 48, 14);
		frmExercise.getContentPane().add(lblSec);
		
		textField_2 = new JTextField();
		textField_2.setBounds(62, 130, 96, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCost = new JLabel("COST (cents)");
		lblCost.setBounds(274, 112, 96, 14);
		frmExercise.getContentPane().add(lblCost);
		
		textField_3 = new JTextField();
		textField_3.setBounds(274, 133, 121, 20);
		frmExercise.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double hrs = Double.parseDouble(textField.getText());
				double min = Double.parseDouble(textField_1.getText());
				double sec = Double.parseDouble(textField_2.getText());
				//convert the hours to mins and the seconds to mins so as to multiply by 10 cents
				double hrs2min = hrs*60;
				double sec2min = sec/60;
				double t_min = min + hrs2min + sec2min;
				double cost = t_min*10;
				String dcost = String.format("%.1f", cost);
				textField_3.setText(dcost);
			}
		});
		btnCalculate.setBounds(274, 78, 121, 23);
		frmExercise.getContentPane().add(btnCalculate);
	}

}
