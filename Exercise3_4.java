package exercises;

/** Exercise: 3.4: Design a simple house and draw it.    
Filename:   Exercise3_4.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/

import java.awt.*;
import javax.swing.*;
import java.applet.*;

public class Exercise3_4 extends Applet{
	
	public void paint(Graphics g) {
		int a[]= {150,300,225};
		int b[]= {150,150,25};
		
		
		g.setColor(Color.blue);
		g.fillRect(150, 150, 150, 200);
		
		g.setColor(Color.black);
		g.fillRect(190, 220, 70, 130);
		
		g.setColor(Color.red);
		g.fillPolygon(a, b, 3);
		
		g.setColor(Color.yellow);
		g.fillOval(200, 75, 50, 50);
		
		g.setColor(Color.red);
		g.fillRect(300, 150, 250, 200);
		
		g.setColor(Color.black);
		g.fillRect(390, 210, 80, 80);
		//The Window partitions
		g.setColor(Color.blue);
		g.drawLine(430, 210, 430, 290);
		
		g.setColor(Color.blue);
		g.drawLine(470, 250, 390, 250);
		
		g.setColor(Color.red);
		g.drawLine(460, 26, 226, 26);
		
		g.setColor(Color.red);
		g.drawLine(460, 25, 550, 150);
		
		
	}

	public static void main(String[] args) {
		//create a jframe to house the applet
		JFrame jp1 = new JFrame();
		//instatiated the class
		Exercise3_4 exe = new Exercise3_4();
		jp1.getContentPane().add(exe, BorderLayout.CENTER);
		jp1.setSize(new Dimension(700,500));
		jp1.setVisible(true);
	}

}
