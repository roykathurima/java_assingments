package exercises;

/** Exercise: 9.2 Thermometer. Some thermometers record the maximum and minimum temperatures 
 * that have been reached.  Write a program that simulates a thermometer using a slider.
 *  It displays in text fields the maximum and minimum values that the slider has been set to.
 *   Write a class that remembers the largest and smallest values and compares new values.
 *    This class has methods setNewValue, getLowestValue and getHighestValue.         
Filename:   Exercise9_2.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise9_2 {

	private JFrame frmExercise;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	Thermometer therm = new Thermometer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise9_2 window = new Exercise9_2();
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
	public Exercise9_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise9_2");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int val = slider.getValue();
				textField_2.setText(Integer.toString(val));
			}
		});
		slider.setBounds(67, 32, 300, 32);
		frmExercise.getContentPane().add(slider);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(246, 130, 48, 14);
		frmExercise.getContentPane().add(lblMax);
		
		textField = new JTextField();
		textField.setBounds(304, 127, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(31, 133, 48, 14);
		frmExercise.getContentPane().add(lblMin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 130, 96, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSetMin = new JButton("set min");
		btnSetMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int min = Integer.parseInt(textField_2.getText());
				int l_min = therm.getLowestValue(min);
				if (l_min == 0) {
					therm.setMinNewValue(min);
					textField_1.setText(Integer.toString(min));
					therm.setMinNewValue(l_min);
				}
				
			}
		});
		btnSetMin.setBounds(48, 174, 89, 23);
		frmExercise.getContentPane().add(btnSetMin);
		
		JButton btnNewButton = new JButton("set max");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int max = Integer.parseInt(textField_2.getText());
				int h_max = therm.getHighestValue(max);
				textField.setText(Integer.toString(h_max));
				therm.setMaxNewValue(h_max);
			}
		});
		btnNewButton.setBounds(311, 174, 89, 23);
		frmExercise.getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 75, 96, 20);
		frmExercise.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
	//inner class to store, retrieve and maninulate the max and min temperature values
	public class Thermometer {
		private int min_val;
		private int max_value;
		
		public void setMinNewValue(int value) {
			min_val = value;
		}
		public void setMaxNewValue(int value) {
			max_value = value;
		}
		
		public int getLowestValue(int value) {
			if((value-min_val)<0) {
				return value;
			} else if((value-min_val)>0){
				return min_val;
			} else return 0;
		}
		
		public int getHighestValue(int value) {
			if((value-max_value)<0) {
				return max_value;
			}else if((value-max_value)>0) {
				return value;
			} else return 0;
		}
		

	}
}
