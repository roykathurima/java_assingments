package exercises;

/** Exercise: 15.2: Write a program which inputs one string and determines whether or not it is a palindrome.
 *  A palindrome reads the same backwards and forwards, so "abba" is a palindrome. 
Filename:   Exercise15_2.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
  */

import java.util.Scanner;
import java.lang.String;

public class Exercise15_2{
    public static void main(String []args){
        // String @name = new String(@value);
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a string value");
        //stores a string entered via standard input in a string buffer object
        //this is to allow us to utilize the reverse method of the class 
        StringBuffer istring = new StringBuffer();
        istring.append(scan.nextLine());
        //make a copy of the istring
        StringBuffer cstring = new StringBuffer(istring);
        //reverse the copy then compare the two for similarity
        cstring.reverse();
        int result = cstring.compareTo(istring);
        if (result == 0){
            System.out.println("String is a palindrome");
        } else{
            System.out.println("String not a palindrome");
        }

    }
}