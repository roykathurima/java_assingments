package exercises;
/** Exercise 9.4: Scorekeeper Design and write a class that acts as a scorekeeper for a computer game.
 *  It maintains a single integer, the score. It provides a method to initialize the score to zero,
 *  a method to increase the score, a method to decrease the score, and a method to return the score.
 *  Write a program to create a single object and use it.
 *  The current score is always on display in a text field.
 *  Buttons are provided to increase, decrease and initialize thescore by an amount entered into a text field.         
Filename:   Exercise9_4.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/

import java.awt.EventQueue;

import javax.swing.JFrame;

//import exercises.Scorekeeper.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise9_4 {

	private JFrame frmExercise;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise9_4 window = new Exercise9_4();
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
	public Exercise9_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise9_4");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JButton btnInitScore = new JButton("Init Score");
		btnInitScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scorekeeper sk = new Scorekeeper();
				sk.initZero();
				textField.setText("0");
			}
		});
		btnInitScore.setBounds(44, 130, 89, 23);
		frmExercise.getContentPane().add(btnInitScore);
		
		JButton btnIncrement = new JButton("Increment");
		btnIncrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scorekeeper sk = new Scorekeeper();
				int inc = Integer.parseInt(textField_1.getText());
				textField_1.setText(null);
				sk.incScore(inc);
				int fscore=sk.retScore();
				textField.setText(Integer.toString(fscore));
			}			
		});
		btnIncrement.setBounds(156, 130, 106, 23);
		frmExercise.getContentPane().add(btnIncrement);
		
		JButton btnDecrement = new JButton("Decrement");
		btnDecrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scorekeeper sk = new Scorekeeper();
				int dec = Integer.parseInt(textField_1.getText());
				textField_1.setText(null);
				sk.decScore(dec);
				int fscore = sk.retScore();
				textField.setText(Integer.toString(fscore));
			}
		});
		btnDecrement.setBounds(290, 130, 106, 23);
		frmExercise.getContentPane().add(btnDecrement);
		
		textField = new JTextField();
		textField.setBounds(138, 39, 185, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCurrentScore = new JLabel("Current Score");
		lblCurrentScore.setBounds(41, 42, 89, 14);
		frmExercise.getContentPane().add(lblCurrentScore);
		
		JLabel lblAlterScore = new JLabel("Alter Score");
		lblAlterScore.setBounds(41, 73, 69, 14);
		frmExercise.getContentPane().add(lblAlterScore);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 70, 185, 20);
		frmExercise.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	//inner score to manipulate the score variable
	public static class Scorekeeper {
		private static int score;
		
		public void initZero() {
			score=0;
		}
		public void incScore(int inc) {
			score += inc;
		}
		public void decScore(int dec) {
			score -= dec;
		}
		public int retScore() {
			return score;
		}
	}

}
