package exercises;

/** Exercise: 5.3: write a method named displayEarnings with two integer 
    parameters representing an employee’s salary and the number of years they have worked.
    The method should display their total earnings in a message dialog,
    assuming that they earned the same amount every year.
    The program should obtain values via input dialogs prior to calling displayEarnings
Filename:   Exercise5_3.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
  */
import javax.swing.*;

public class Exercise5_3 {
    public static void main(String []args){
      String salary, years;
      //Takes the string entered into the dialog and stores it in the variables
      salary = JOptionPane.showInputDialog("Enter the salary");
      years = JOptionPane.showInputDialog("Enter number of years");
      displayEarnings(salary, years);
    }
    public static void displayEarnings(String salary, String years){
    	//constructs the string to pass to the dialog
    	String message = "Salary = "+salary+"\nYears = "+years;
    	JOptionPane.showMessageDialog(null, message);
    }
}