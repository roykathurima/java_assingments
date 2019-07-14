package exercises;

/** Exercise: 4.3: Write a program that inputs three integer exam marks, 
    which displays the mean (average) mark as a double value. 
    Check your answer with a calculator.
Filename:   Exercise4_3.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
  */
import java.util.Scanner;
import java.lang.Math;
public class Exercise4_3 {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int mark1, mark2, mark3;
        double mean;
        //prompts the user to enter the marks
        System.out.println("Enter the three marks");
        //takes values from the console and puts them into the variables
        mark1 = scan.nextInt();
        mark2 = scan.nextInt();
        mark3 = scan.nextInt();
        mean = Math.round(((mark1+mark2+mark3)/3));
        //Average is printed into the console
        System.out.println("Average = " + mean);
    }
}