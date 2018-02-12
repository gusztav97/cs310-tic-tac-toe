package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {

    private static final int DEFAULT_WIDTH = 3;
	
	/*private static void GUI(){
			JFrame frame = new JFrame("Tic-Tac-Toe");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		
	}*/

    public static void main(String[] args) {
        
        /* Set initial size of game board (default is 3x3) */

        int width = DEFAULT_WIDTH;
        /* If a different size is provided as a command-line argument, use it instead */
		/*javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				GUI();
			}
		});
		*/
		

        if(args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
        
        /* Create MVC Objects */

        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
        //TicTacToeController controller = new TicTacToeController(model, view);
		
		
		JFrame win = new JFrame("Tic-Tac-Toe");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.add(view);
		win.pack();
		win.setVisible(true);
        
        /* MAIN LOOP */
		
		

        /*while (!model.isGameover()){
            
            view.viewModel();
			
            //controller.controlModel();
			
            
        }
		*/
        
        /* Game is over; show the final board and the winner */

        view.viewModel();

        view.showResult(model.getResult().toString());

    }
}