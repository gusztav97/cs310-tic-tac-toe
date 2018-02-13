package edu.jsu.mcis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;
	JPanel squaresPanel;
	JButton[][] squares;
	JLabel resultLabel;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		squaresPanel = new JPanel(new GridLayout(model.getWidth(), model.getWidth()));
		
		squares = new JButton[model.getWidth()][model.getWidth()];
		for(int row = 0; row < model.getWidth(); row++){
			for(int col = 0; col < model.getWidth(); col++){
				squares[row][col] = new JButton();
				squares[row][col].setPreferredSize(new Dimension(64,64));
				squares[row][col].addActionListener(this);
				squares[row][col].setName("Square" + row + col);
				squaresPanel.add(squares[row][col]);
			}
		}
		resultLabel = new JLabel();
		resultLabel.setName("ResultLabel");
		resultLabel.setText("Hello");
		
        add(squaresPanel);
		add(resultLabel);
	}
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        for(int i = 0; i < model.getWidth(); i++){
            for (int j = 0; j < model.getWidth(); j++){
				squares[i][j].setText(model.getMark(i,j).toString());
			}
        }

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
		if (model.isXTurn())
            resultLabel.setText("Player 1 (x) Move");
        else
            resultLabel.setText("\n\nPlayer 2 (O) Move: ");
        
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
		System.out.println("Input is Invalid");

    }

    public void showResult(String r) {

        /* Display final winner */

		resultLabel.setText("\n\n" + r + "!");

    }

    public void actionPerformed(ActionEvent e) {
        
		for (int i = 0; i < model.getWidth(); i++){
			for(int j = 0; j < model.getWidth(); j++){
				if(e.getSource() == squares[i][j] && model.makeMark(i,j)){
					squares[i][j].setText(model.getMark(i,j).toString());
				}
			}
		}
		if(model.getResult() == TicTacToeModel.Result.X){
			resultLabel.setText("X");
			
			for(int row = 0; row < model.getWidth(); row++){
				for(int col = 0; col < model.getWidth(); col++){
					squares[row][col].setEnabled(false);
				}
			}
		}
		
		if(model.getResult() == TicTacToeModel.Result.O){
			resultLabel.setText("O");
			
			
			for(int row = 0; row < model.getWidth(); row++){
				for(int col = 0; col < model.getWidth(); col++){
					squares[row][col].setEnabled(false);
				}
			}
		}
		if(model.getResult() == TicTacToeModel.Result.TIE){
			resultLabel.setText("TIE");
			
			
			for(int row = 0; row < model.getWidth(); row++){
				for(int col = 0; col < model.getWidth(); col++){
					squares[row][col].setEnabled(false);
				}
			}
		}
		
	}
	
}