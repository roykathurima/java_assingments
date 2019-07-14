package exercises;

/**Exercise: 15.1: Write a program which inputs two strings from text fields,
 * and which joins them together. Show the resulting string in a text field.  
Filename:   Exercise15_1.java
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

public class Exercise15_1 {

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
					Exercise15_1 window = new Exercise15_1();
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
	public Exercise15_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise15_1");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblString = new JLabel("String 1");
		lblString.setBounds(10, 25, 48, 14);
		frmExercise.getContentPane().add(lblString);
		
		JLabel lblString_1 = new JLabel("String 2");
		lblString_1.setBounds(10, 64, 48, 14);
		frmExercise.getContentPane().add(lblString_1);
		
		textField = new JTextField();
		textField.setBounds(67, 22, 167, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 61, 166, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnConcatenate = new JButton("Concatenate");
		btnConcatenate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = textField.getText();
				String str2 = textField_1.getText();
				//gets the two strings and concatenates them
				textField_2.setText(str1.concat(str2));
			}
		});
		btnConcatenate.setBounds(81, 119, 125, 23);
		frmExercise.getContentPane().add(btnConcatenate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 153, 167, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(10, 156, 48, 14);
		frmExercise.getContentPane().add(lblResult);
	}

}
