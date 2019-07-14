package exercises;

/** Exercise 7.4 Betting A group of people are betting on the outcome of three throws of the dice.
 * A person bets $1 on predicting the outcome of the three throws.
 * Write a program that uses the random number method to simulate three throws of a die and 
 * displays the winnings according to the following rules:  
• all three throws are sixes: win $20;  • all three throws are the same (but not sixes): win $10;  
• any two of the three throws are the same: win $5.  
Filename:   Exercise7_4.java
@author:    Â© Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
  */

import java.util.Random;

public class Exercise7_4{
    public static void main(String []args){
        int a, b, c;
        Random rand = new Random();
        a = rand.nextInt(6)+1;
        b = rand.nextInt(6)+1;
        c = rand.nextInt(6)+1;
        //prints out the random numbers to the console
        System.out.println(String.format("a=%d\nb=%d\nc=%d\n", a,b,c));
        //checks whether all the numbers are the same and are sixes and prints $20 if so
        if(a==b && b==c && b==6){
            System.out.println("You have won $20");
            //checks whether all are similar but not sixes and prints $10 winning
        }else if(a==b && b==c && b!=6){
            System.out.println("You have won $10");
            //checks whether whether two of them are similar and prints a $5 winning
        }else if(a==b || b==c || c==a){
            System.out.println("You have won $5");
            //else the system asks the players to bet once more
        }else {
            System.out.println("Try Again");
        }
    }
}