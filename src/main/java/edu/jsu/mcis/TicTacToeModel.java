package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		
        /* INSERT YOUR CODE HERE */
		grid = new Mark[width][width];
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
		for (int i = 0; i < width; i++){
			for (int j = 0; j < width; j++){
				grid[i][j] = Mark.EMPTY;
			}
		}
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        if(isValidSquare(row,col) == true && isSquareMarked(row,col) == false){
			if(isXTurn() == true){
				grid[row][col] = Mark.X;
				xTurn = !xTurn;
				return true;
			}
			else{
				grid[row][col] = Mark.O;
				xTurn = !xTurn;
				return true;
			}
		}
		else
			return false;
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		if((row < width) && (row >= 0)){
			if((col < width) && (col >= 0)){
				return true;
			}
		}
		
		return false;
		
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
		if (grid[row][col] == Mark.EMPTY)
			return false;
		else
			return true;
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
		return grid[row][col];
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
		   
		if (isMarkWin(Mark.O)){
			return Result.O;
		}
		if (isMarkWin(Mark.X)){
			return Result.X;
		}
		   
		if(isTie()){
			return Result.TIE;
		}
		if(!isTie()){
			return Result.NONE;
		}
		
		return null;
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
		/*X0X
		  X00
		  X 
		*/
		boolean flag = true;
		//Columns
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(grid[j][i] != mark)
					break;
				
				if(j == (width - 1) && grid[j][i] == mark)
					flag = false;
			}
		}
		
		
		//Rows
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(grid[i][j] != mark)
					break;
				
				if(j == (width - 1) && grid[i][j] == mark)
					flag = false;
			}
		}
		
			
		//Diagonal BottomLeft to TopRight
		
		int ctr = 0;
		 for (int i = (width - 1); i > -1; i--){
			 if(grid[i][ctr] != mark)
				 break;
			 
			 if(i == 0 && ctr == (width - 1) && grid[i][ctr] == mark)
				 flag = false;
			ctr++;
		 }
		
		
		//Diagonal TopLeft to BottomRight
		for(int i = 0; i < width; i++){
			if(grid[i][i] != mark)
				break;
			if(i == (width - 1) && grid[i][i] == mark){
				flag = false;
			}
		}
		
		
		if(flag == false)
			return true;
		
		return false;

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
			for(int i = 0; i < width; i++){
				for (int j = 0; j < width; j++){
					if (grid[i][j] == Mark.EMPTY){
						return false;
					}
				}
			}
		

        return true; /* remove this line! */
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}