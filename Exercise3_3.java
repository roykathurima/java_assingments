package exercises;

/**Exercise: 3.3: Draw an empty Tic Tac Toe (noughts and crosses) board.  
Filename:   Exercise3_3.java
@author:    © Gary Hill (200WXYZ) 
Course:     BSc Computing 
Module:     CSY1020 Problem Solving & Programming 
Tutor:      Gary Hill 
@version:   1.0
Date:       11/06/19 
*/
import java.awt.*;
import javax.swing.*;

public class Exercise3_3 extends JFrame{
	//Named constants for the game board
	public static final int ROWS =3;
	public static final int COLS =3;
	
	//constants for the board dimensions
	
	public static final int CELL_SIZE = 100;
	// cell width and height (square)
	public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
	// the drawing canvas
	public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
	public static final int GRID_WIDTH = 8;
	// Grid-line's width
	public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2;
	// Grid-line's half-width
	// Symbols (cross/nought) are displayed inside a cell, with padding from border
	public static final int CELL_PADDING = CELL_SIZE / 6;
	public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
	// width/height
	public static final int SYMBOL_STROKE_WIDTH = 8;
	//enum type either an empty, a cross or a nought
	public enum Seed { EMPTY, CROSS, NOUGHT }
	private Seed[][] board ; 
	private DrawCanvas canvas;
	
	public Exercise3_3() {
		//instantizte the inner class
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		repaint();
		//initialize the container to house the Board
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); //pack all the components in this JFrame
		setTitle("Tic Tac Toe");
		setVisible(true);
		
		board = new Seed[ROWS][COLS];
		//call initGame() to empty the grid
		
		initGame();
		//Some initial values are set after the grid is drawn
		//board[1][2] = Seed.CROSS;
		//board[2][1] = Seed.NOUGHT;
		//board[1][0] = Seed.CROSS;
		//board[1][1] = Seed.NOUGHT;
		//board[0][1] = Seed.CROSS;
	}
	public void initGame() {
		for (int row=0; row<ROWS; ++row) {
			for (int col = 0; col<COLS; ++col) {
				board[row][col] = Seed.EMPTY;
			}
		}
	}
	//inner class so as to be able to use the Graphics object
	class DrawCanvas extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);
			
			//Draw the grid lines
			g.setColor(Color.LIGHT_GRAY);
			for(int row = 1; row<ROWS; ++row) {
				g.fillRoundRect(0, CELL_SIZE*row - GRID_WIDTH_HALF, CANVAS_WIDTH-1 , 
						GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
			}
			for (int col =1 ; col<COLS; ++col) {
				g.fillRoundRect(CELL_SIZE*col - GRID_WIDTH_HALF,0,GRID_WIDTH, CANVAS_HEIGHT-1, GRID_WIDTH, GRID_WIDTH);
			}
			// Draw the Seeds of all the cells if they are not empty
			// Use Graphics2D which allows us to set the pen's stroke
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, 
					BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Graphics2D only
			for (int row = 0; row < ROWS; ++row) {
				for (int col = 0; col < COLS; ++col) {
					int x1 = col * CELL_SIZE + CELL_PADDING;
					int y1 = row * CELL_SIZE + CELL_PADDING;
					if (board[row][col] == Seed.CROSS) {
						g2d.setColor(Color.RED);
						int x2 = (col + 1) * CELL_SIZE - CELL_PADDING;
						int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
						g2d.drawLine(x1, y1, x2, y2);
						g2d.drawLine(x2, y1, x1, y2);
						} else if (board[row][col] == Seed.NOUGHT) {
							g2d.setColor(Color.BLACK);
							g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
							}
					}
				} 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Exercise3_3();
			}
		});
	}

}
