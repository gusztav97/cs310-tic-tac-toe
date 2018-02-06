package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		System.out.println("\n  012");
        for(int i = 0; i < model.getWidth(); i++){
            System.out.println("");
            System.out.print(i + " ");
            for (int j = 0; j < model.getWidth(); j++){
                System.out.print(model.getMark(i, j));
            }
        }

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
		if (model.isXTurn())
            System.out.println("\n\nPlayer 1 (X) Move: ");
        else
            System.out.println("\n\nPlayer 2 (O) Move: ");
        
        System.out.print("Enter the row and column numbers, separated by a space: ");

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
		System.out.println("Input is Invalid");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println("\n\n" + r + "!");

    }
	
}