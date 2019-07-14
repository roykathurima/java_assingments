package exercises;

/** Exercise 6. 2. Write a program which produces a random number between 200 and 400
 * each time a button is clicked. The program should display this number,
 * and the sum and average of all the numbers so far. As you click again and again,
 * the average should converge on 300. If it doesn't, we would suspect the random number generator -
 * just as we would be suspicious of a coin that came out heads 100 times in a row!       
Filename:   Exercise6_2.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise6_2 {

	private JFrame frmExercise;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	ArrayList al = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise6_2 window = new Exercise6_2();
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
	public Exercise6_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise6_2");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(69, 11, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(69, 42, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(69, 73, 96, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRand = new JLabel("Rand");
		lblRand.setBounds(11, 14, 48, 14);
		frmExercise.getContentPane().add(lblRand);
		
		JLabel lblSum = new JLabel("Sum");
		lblSum.setBounds(11, 45, 48, 14);
		frmExercise.getContentPane().add(lblSum);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setBounds(11, 76, 48, 14);
		frmExercise.getContentPane().add(lblAverage);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
		        //rand.nextInt((max - min) + 1) + min;
				int number = rand.nextInt(199)+201;
				al.add(number);
				int sum=0;
				if(al.size()>=1) {
					for(int i=0;i<al.size();i++) {
						sum += (int)al.get(i);
					}
				}
				double Average = (double)(sum/(al.size()));
				textField.setText(Integer.toString(number));
				textField_1.setText(Integer.toString(sum));
				textField_2.setText(Double.toString(Average));
		        
			}
		});
		btnGenerate.setBounds(10, 114, 89, 23);
		frmExercise.getContentPane().add(btnGenerate);
	}

}
