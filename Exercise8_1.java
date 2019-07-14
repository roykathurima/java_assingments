package exercises;

/** Exercise: 8.1: Write a program that uses a loop to display the integer 
    numbers 1 to 10 together with the cubes of each of their values
Filename:   Exercise8_1.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
  */
  
import java.util.Scanner;

public class Exercise8_1{
    public static void main(String []args){
    	//uses a for loop to iterate from 1...10 printing the index and its cube
        for(int i =1; i<=10; i++){
            System.out.println(i);
            System.out.println(i*i*i);
            System.out.println("");
        }
    }
}