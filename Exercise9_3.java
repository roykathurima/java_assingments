package exercises;

/** Exercise 9.3: Bank account Write a program that simulates a bank account.
 * A button allows a deposit to be made into the account.
 * The amount is entered into a text field. A second button allows a withdrawal to be made.
 * The amount (the balance) and the state of the account is continually displayed - 
 * it is either OK or overdrawn. Create a class named Account to represent bank accounts.
 * It has methods deposit, withdraw, getCurrentBalance and setCurrentbalance.    
Filename:   Exercise9_3.java
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

public class Exercise9_3 {

	private JFrame frmExercise;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise9_3 window = new Exercise9_3();
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
	public Exercise9_3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExercise = new JFrame();
		frmExercise.setTitle("Exercise4_2");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		JLabel lblAmountToWithdraw = new JLabel("Amount");
		lblAmountToWithdraw.setBounds(10, 29, 54, 24);
		frmExercise.getContentPane().add(lblAmountToWithdraw);
		
		textField = new JTextField();
		textField.setBounds(60, 31, 129, 20);
		frmExercise.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setBounds(54, 64, 109, 33);
		frmExercise.getContentPane().add(lblBalance);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account ac = new Account();
				double value = Double.parseDouble(textField.getText());
				textField.setText(null);
				double initBal = ac.getCurrentBalance();
				double finBal = value+initBal;
				ac.setCurrentBalance(finBal);
				lblBalance.setText(Double.toString(finBal));
				}
		});
		btnDeposit.setBounds(10, 122, 89, 23);
		frmExercise.getContentPane().add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account ac = new Account();
				double value = Double.parseDouble(textField.getText());
				textField.setText(null);
				double initBal = ac.getCurrentBalance();
				double finBal = initBal-value;
				if(finBal>=0) {
					ac.setCurrentBalance(finBal);
					lblBalance.setText(Double.toString(finBal));
				}else {
					lblBalance.setText("Overdrawn");
				}
			}
		});
		btnWithdraw.setBounds(131, 122, 89, 23);
		frmExercise.getContentPane().add(btnWithdraw);
	}
	//inner class that models the bank account
	public static class Account {
		private static double balance;
		public void deposit(double value) {
			balance += value;
		}
		public void withdraw(double value) {
			balance -= value;
		}
		public double getCurrentBalance() {
			return balance;
		}
		public void setCurrentBalance(double value) {
			balance = value;		
		}
	}

	
	
}
