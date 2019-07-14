package exercises;

/** Exercise: 8.2: Random Numbers. Write a program to display 10 random numbers using a loop.
 *  Use the library class Random to obtain integer random numbers in the range 0 to 9.
 *   Display the numbers in a text field.         
Filename:   Exercise8_2.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
public class Exercise8_2 {

	private JFrame frmExercise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise8_2 window = new Exercise8_2();
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
	public Exercise8_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise8_2");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 116, 175);
		frmExercise.getContentPane().add(textArea);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				for(int i=0;i<10;i++) {
				//uses a text area to print the random numbers into multiple lines
				textArea.append(Integer.toString(rand.nextInt(10)));
				textArea.append("\n");
				}
			}
		});
		btnGenerate.setBounds(20, 197, 89, 23);
		frmExercise.getContentPane().add(btnGenerate);
	}
}
