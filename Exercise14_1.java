package exercises;

/** Exercise 14.1:Data handler Write a program that uses a 4 * 7 array of numbers similar to the rainfall 
 * program (with output as shown in Figure 14.2). Extend the program to carry out the following operations: 
 * When a button marked ‘sums’ is pressed, add up the values for each of the seven columns and add up all
 * the values of each of the four rows and display them. When a button marked ‘largest’ is pressed,
 * find the largest value in each row, the largest in each column and the largest value in the complete array. 
 * When a button marked ‘scale’ is pressed, multiply every number in the array by a number
 * entered into a text field. (This could be used to convert from centimetres to inches. (p274 – 6th Edition)  

Filename:   Exercise14_1.java
@author:    Â© Gary Hill (200WXYZ) 
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

public class Exercise14_1 {

	private JFrame frmExercise;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	int[][] number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise14_1 window = new Exercise14_1();
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
	public Exercise14_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise14_1");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblInsert = new JLabel("Insert");
		lblInsert.setBounds(10, 25, 48, 14);
		frmExercise.getContentPane().add(lblInsert);
		
		textField = new JTextField();
		textField.setBounds(68, 25, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 119, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 119, 96, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(249, 119, 96, 20);
		frmExercise.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblColumns = new JLabel("Columns");
		lblColumns.setBounds(131, 103, 66, 14);
		frmExercise.getContentPane().add(lblColumns);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(158, 78, 201, 14);
		frmExercise.getContentPane().add(lblNewLabel);
		
		JLabel lblRows = new JLabel("Rows");
		lblRows.setBounds(10, 103, 66, 14);
		frmExercise.getContentPane().add(lblRows);
		
		number = new int[4][7];
		for(int i =0;i<4;i++) {
			for(int j=0; j<7;j++) {
				number[i][j] = 0;
			}	
		}
		
		JLabel lblArra = new JLabel("Array");
		lblArra.setBounds(258, 103, 66, 14);
		frmExercise.getContentPane().add(lblArra);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(number.length<28) {
					for(int i=0;i<4;i++) {
						for(int j=0;j<7;j++) {
							if(number[i][j]== 0) {
								number[i][j] = Integer.parseInt(textField.getText());
								break;
							} 
						}break;
					}
				}
				textField.setText(null);
				for(int i =0;i<4;i++) {
					for(int j=0; j<7;j++) {
						lblNewLabel.setText(Integer.toString(number[i][j]));
					}
					
				}
				
			}
		});
		btnInsert.setBounds(20, 56, 89, 23);
		frmExercise.getContentPane().add(btnInsert);
		
		JButton btnSums = new JButton("Sums");
		btnSums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum =0, csum=0, rsum=0;
				for (int i =0;i<4;i++) {
					for (int j=0;j<7;j++) {
						csum += number[j][i];
						break;
					}
				}
				for (int i =0;i<4;i++) {
					for (int j=0;j<7;j++) {
						rsum += number[i][j];
						break;
					}
				}
				for(int i =0;i<4;i++) {
					for(int j=0; j<7;j++) {
						sum += number[i][j];
					}
				}
				textField_3.setText(Integer.toString(sum));
				textField_2.setText(Integer.toString(rsum));
				textField_1.setText(Integer.toString(csum));
			}
		});
		btnSums.setBounds(10, 169, 89, 23);
		frmExercise.getContentPane().add(btnSums);
		
		JButton btnLargest = new JButton("Largest");
		btnLargest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int big =0, cbig=0, rbig=0;
				for (int i =0;i<4;i++) {
					for (int j=0;j<7;j++) {
						if(number[i][j]>cbig) {
							cbig = number[i][j];
						}
					}break;
				}
				for (int i =0;i<4;i++) {
					for (int j=0;j<7;j++) {
						if(number[i][j]>rbig) {
							rbig = number[i][j];
							break;
						}
					}
				}
				for(int i =0;i<4;i++) {
					for(int j=0; j<7;j++) {
						if(number[i][j]>big) {
							big = number[i][j];
					}
				}
				textField_3.setText(Integer.toString(big));
				textField_2.setText(Integer.toString(rbig));
				textField_1.setText(Integer.toString(cbig));
			}
			}
		});
		btnLargest.setBounds(126, 169, 89, 23);
		frmExercise.getContentPane().add(btnLargest);
		
		JButton btnScale = new JButton("Scale");
		btnScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int scale = Integer.parseInt(textField.getText());
				 int[][] mux = new int [4][7];
					for(int i =0;i<4;i++) {
						for(int j=0; j<7;j++) {
							mux[i][j] = scale * number[i][j];
						}
					}
			}
		});
		btnScale.setBounds(235, 169, 89, 23);
		frmExercise.getContentPane().add(btnScale);

	}

}
