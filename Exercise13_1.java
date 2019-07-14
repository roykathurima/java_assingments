package exercises;
/** Exercise 13.1: Nim. A human plays against the computer.
 * At the start of the game there are three piles of matches.
 * In each pile there is a random number of matches in the range 1 to 20.
 * The three piles are displayed throughout the game. A random choice determines who goes first.
 * Players take it in turns to remove as many matches as they like from any one pile, but only from one pile.
 * A player must remove at least one match.
 * The winner is the player who makes the other player take the last match.
 * Make the computer play randomly: that is,
 * it chooses a pile randomly and then a number of matches randomly from those available.
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
import javax.swing.JButton;
import java.awt.Font;

import java.util.Random;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise13_1 {

	private JFrame frmExercise;
	private JTextField textField;
	private static int remain;
	JButton btnB;
	JButton btnC;
	JButton btnA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise13_1 window = new Exercise13_1();
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
	public Exercise13_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	// the random class is instantiated
	Random rand = new Random();
	// rno is created who starts the game between the player and the machine
	final int rno = rand.nextInt(2)+1;
	int rmatch, gvalue;
	public void machines() {
		rmatch = rand.nextInt(20)+1;
		gvalue = rand.nextInt(rmatch)+1;
	}
	private void initialize() {
		
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise13_1");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblPiles = new JLabel("PILES");
		lblPiles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPiles.setBounds(183, 24, 58, 28);
		frmExercise.getContentPane().add(lblPiles);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(109, 147, 230, 14);
		frmExercise.getContentPane().add(lblNewLabel);
		
		btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnB.setEnabled(false);
				btnC.setEnabled(false);
				int val1 = Integer.parseInt(textField.getText());
				int smatch = rand.nextInt(20)+1;
				int remain = smatch - val1;
				if(remain == 0) {
					lblNewLabel.setText("You have Won");
				}
				if((rmatch-gvalue)==0) {
					lblNewLabel.setText("The machine has Won");
				}
			}
		});
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnA.setBounds(66, 98, 89, 34);
		frmExercise.getContentPane().add(btnA);
		
		btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnA.setEnabled(false);
				btnC.setEnabled(false);
				int val = Integer.parseInt(textField.getText());
				//smatch determines the number of matches in the pile
				int smatch = rand.nextInt(20)+1;
				//remain contains the number of matches that remain when the pile is subtracted
				remain = smatch - val;
				if(remain == 0) {
					lblNewLabel.setText("You have Won");
				}
				if((rmatch-gvalue)==0) {
					lblNewLabel.setText("The machine has Won");
				}
			}
		});
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnB.setBounds(165, 98, 89, 34);
		frmExercise.getContentPane().add(btnB);
		
		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnB.setEnabled(false);
				btnA.setEnabled(false);
				int val = Integer.parseInt(textField.getText());
				int smatch = rand.nextInt(20)+1;
				int remain = smatch - val;
				if(remain == 0) {
					lblNewLabel.setText("You have Won");
				}
				if((rmatch-gvalue)==0) {
					lblNewLabel.setText("The machine has Won");
				}
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnC.setBounds(265, 98, 89, 34);
		frmExercise.getContentPane().add(btnC);
		
		
		textField = new JTextField();
		textField.setBounds(158, 63, 96, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		//rno is checked to determine who begins; 1 for machine and 2 for the player
		if (rno == 1) {
			lblNewLabel.setText("The machine begins");
			//rpile is created so as to ensure that the machine chooses a pile randomly
			int rpile = rand.nextInt(3)+1;
			if (rpile == 1) {
				//code for pile A
				lblNewLabel.setText("The machine has chosen pile A");
				//the pile that the machine chooses is then disabled so that the user does not choose it again
				btnA.setEnabled(false);
				rmatch = rand.nextInt(20)+1;
				gvalue = rand.nextInt(rmatch)+1;
				if((rmatch-gvalue)==0) {
					lblNewLabel.setText("The machine has Won");
				}
			} else if(rpile == 2) {
				//code for pile B
				lblNewLabel.setText("The machine has chosen pile B");
				btnB.setEnabled(false);
				rmatch = rand.nextInt(20)+1;
				gvalue = rand.nextInt(rmatch)+1;
				if((rmatch-gvalue)==0) {
					lblNewLabel.setText("The machine has Won");
				}
			} else if (rpile ==3 ) {
				//code for pile C
				lblNewLabel.setText("The machine has chosen pile C");
				btnC.setEnabled(false);
				rmatch = rand.nextInt(20)+1;
				gvalue = rand.nextInt(rmatch)+1;
				if((rmatch-gvalue)==0) {
					lblNewLabel.setText("The machine has Won");
				}
			}
		} else if (rno == 2) {
			lblNewLabel.setText("You begin, pick a pile");
		}
		
	}

}
