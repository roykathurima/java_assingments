/** Exercise: 4.1: Write a program to compute the volume of a box, given its three dimensions.

Filename:   Exercise4_1.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
 */
package exercises;

import java.util.Scanner;
public class Exercise4_1{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int dim1, dim2, dim3, volume;
        System.out.println("Enter the three dimensions of the box");
        //read the values entered into the console into the variables
        dim1 = scan.nextInt();
        dim2 = scan.nextInt();
        dim3 = scan.nextInt();
        volume = dim1*dim2*dim3;
        //print to the console
        System.out.println(String.format("Volume = %d", volume));
    }
}