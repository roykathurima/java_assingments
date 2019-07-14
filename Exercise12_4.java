package exercises;

/** Exercise 12.4: Write a program that allows items to be inserted into or removed from any 
 * position within an array list, using suitable buttons.
Filename:   Exercise12_4.java
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

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise12_4 {

	private JFrame frmExercise;
	private JTextField textField;
	private JTextField textField_1;
	//declare and instantiate the arraylist object
	ArrayList al = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise12_4 window = new Exercise12_4();
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
	public Exercise12_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise12_4");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setBounds(10, 21, 48, 14);
		frmExercise.getContentPane().add(lblIndex);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(10, 64, 48, 14);
		frmExercise.getContentPane().add(lblValue);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(68, 92, 273, 14);
		frmExercise.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(68, 18, 175, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 61, 175, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				try {
					int fval = (int) al.get(id);
					textField_1.setText(Integer.toString(fval));
				} catch(IndexOutOfBoundsException e1) {
					lblNewLabel.setText("Item doesn't exist at that index");
					textField.setText(null);
				}
			}
		});
		btnView.setBounds(54, 130, 89, 23);
		frmExercise.getContentPane().add(btnView);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				int val = Integer.parseInt(textField_1.getText());
				try {
					al.add(id, val);
					lblNewLabel.setText("Item Added");
					textField.setText(null);
					textField_1.setText(null);
				} catch (Exception e2){
					lblNewLabel.setText("Something went wrong");
					textField.setText(null);
					textField_1.setText(null);
				}
			}
		});
		btnInsert.setBounds(54, 177, 89, 23);
		frmExercise.getContentPane().add(btnInsert);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				//int val = Integer.parseInt(textField_1.getText());
				try {
					al.remove(id);
					lblNewLabel.setText("Item Removed");
					textField.setText(null);
					textField_1.setText(null);
				} catch (Exception e2){
					lblNewLabel.setText("Something went wrong");
					textField.setText(null);
					textField_1.setText(null);
				}
			}
		});
		btnRemove.setBounds(154, 130, 89, 23);
		frmExercise.getContentPane().add(btnRemove);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.clear();
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnClear.setBounds(154, 177, 89, 23);
		frmExercise.getContentPane().add(btnClear);
		
	}

}
