package exercises;

/** Exercise 13.4: Rain data Complete the program to handle rainfall data by including the following operations:
 * Add up the values and display the total. Find the smallest value and display it.
 * ind the index of the largest value.
Filename:   Exercise13_4.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Exercise13_4 {

	private JFrame frmExercise;
	ArrayList lst = new ArrayList();
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
					Exercise13_4 window = new Exercise13_4();
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
	public Exercise13_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise13_4");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(58, 23, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(12, 26, 48, 14);
		frmExercise.getContentPane().add(lblData);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 132, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 132, 96, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(266, 132, 96, 20);
		frmExercise.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum =0;
				//iterates through the data structure to get the sum
				for(int i =0; i<lst.size(); i++) {
					sum += (int) lst.get(i);
				}
				textField_1.setText(Integer.toString(sum));
			}
		});
		btnTotal.setBounds(10, 167, 105, 23);
		frmExercise.getContentPane().add(btnTotal);
		
		JButton btnSmallest = new JButton("Smallest");
		btnSmallest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initializes the small variable with the first element of the data structure
				int small = (int) lst.get(0);
				//iterates through the structure to find the smallest element
				for(int i =0; i<lst.size(); i++) {
					int tsmall= (int) lst.get(i);
					if (tsmall<small) {
						small = tsmall;
					}
				}
				textField_2.setText(Integer.toString(small));
			}
		});
		btnSmallest.setBounds(132, 167, 99, 23);
		frmExercise.getContentPane().add(btnSmallest);
		
		JButton btnIndexOfLargest = new JButton("Index of Largest");
		btnIndexOfLargest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int big = (int) lst.get(0);
				for(int i =0; i<lst.size(); i++) {
					int tbig = (int) lst.get(i);
					if (tbig > big) {
						big = tbig;
					}
				}
				int id = lst.indexOf(big);
				textField_3.setText(Integer.toString(id));
			}
		});
		btnIndexOfLargest.setBounds(252, 167, 150, 23);
		frmExercise.getContentPane().add(btnIndexOfLargest);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val = Integer.parseInt(textField.getText());
				lst.add(val);
				textField.setText(null);
			}
		});
		btnInsert.setBounds(58, 63, 89, 23);
		frmExercise.getContentPane().add(btnInsert);
	}

}
