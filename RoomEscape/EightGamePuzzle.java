import java.util.*;
import java.io.*;

public class EightGamePuzzle{
    
    private int[][] board = new int[3][3];
    private int[][] ans = new int[3][3];
    private ArrayList<Integer> moves = new ArrayList<Integer>();
    private boolean solved = false;
    private boolean quit = false;
    private boolean skip = false;
    private int zposh = 0; //horizontal position of user
    private int zposv = 0; //vertical position of user


    public boolean getSkip(){
	return skip;
    }

    public void generateGame(int numScram){
    	//creates the unscrambled board that every random board given to the user is based on
	//creates answer which is unscrambled board
	int current = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = current;
		ans[i][j] = current;
		current += 1;
	    }
	}
	boardScrambler(numScram); //scrambles the board for every new play
    }

    //scrambles the board by moving the zero random directions
    public void boardScrambler(int numScram){
	Random r = new Random();
	int n = numScram; //chooses around how many moves are needed to solve (changes difficulty)
	int prevc = 0;
	int c;
        while (n > 0){
	    c = r.nextInt(4);
	    if (c-prevc != 2 || c-prevc != -2){ 
	    	// ^ prevents each random movement from cancelling out the previous one 
	    	// (ex: move right, then move left is not allowed)
	    	
		if (c == 0 && zposv != 0){
		    board[zposh][zposv] = board[zposh][zposv-1];
		    board[zposh][zposv-1] = 0;
		    zposv -= 1;
		    n -= 1;
		    moves.add(0);
		}
		else if (c == 1 && zposh != 0){
		    board[zposh][zposv] = board[zposh-1][zposv];
		    board[zposh-1][zposv] = 0;
		    zposh -= 1;
		    n -= 1;
		    moves.add(1);
		}
		else if (c == 2 && zposv != 2){
		    board[zposh][zposv] = board[zposh][zposv+1];
		    board[zposh][zposv+1] = 0;
		    zposv += 1;
		    n -= 1;
		    moves.add(2);
		}
		else if (c == 3 && zposh != 2){
		    board[zposh][zposv] = board[zposh+1][zposv];
		    board[zposh+1][zposv] = 0;
		    zposh += 1;
		    n -= 1;
		    moves.add(3);
		}
		prevc = c;
	    }
	}
    }
    
    //checks to see if the board is unscrambled after the user's new move
    public void check(){
	if (Arrays.deepEquals(board, ans)){
	    System.out.println("\nFinal board: \n" + toString());
	    solved = true;
	}
    }

    public boolean userSteps(){
    	int zposh2 = zposh;
    	int zposv2 = zposv;
    	while (solved == false && quit == false && skip == false){
	    System.out.println("Current Board: \n" + toString());
    	    String c = this.AskUser("Enter your move here(left, up, down, or right) or quit: ");
	    System.out.println("\nYour move: " + c);
	    
	    // allows the user to temporarily quit the puzzle
	    if (c.equals("quit")){
		quit = true;
	    }
	    
	    // allows the user to permanently skip the puzzle
	    else if (c.equals("skip")){
	        solved = true;
		skip = true;
	    }
	    
	    //board movements
	    else if (c.equals("left") && zposv2 != 0){
		board[zposh2][zposv2] = board[zposh2][zposv2 - 1];
		board[zposh2][zposv2 - 1] = 0;
		zposv2 -= 1;
		check();
	    }
	    else if (c.equals("up") && zposh2 != 0){
		board[zposh2][zposv2] = board[zposh2 - 1][zposv2];
		board[zposh2 - 1][zposv2] = 0;
		zposh2 -= 1;
	        check();
	    }
	    else if (c.equals("right") && zposv2 != 2){
		board[zposh2][zposv2] = board[zposh2][zposv2 + 1];
		board[zposh2][zposv2 + 1] = 0;
		zposv2 += 1;
		check();
	    }
	    else if (c.equals("down") && zposh2 != 2){
		board[zposh2][zposv2] = board[zposh2 + 1][zposv2];
		board[zposh2 + 1][zposv2] = 0;
		zposh2 += 1;
		check();
	    }
	    else{
		System.out.println("Invalid Move. Please try again.");
	    }
	}
	if (skip == true){
	    System.out.println("\n:( You skipped? Oh well... Your phone is unlocked anyways.");
	}
	else if (solved == true){
	    System.out.println("\nCongrats! :) You have unlocked your phone!");
	}
	else if (quit == true){
	    System.out.println("\nSeriously? You've quit already? :(");
	}
	return solved;
    }

    public String toString(){
	String s = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		s = s + board[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }

    public String AskUser(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.print(mToUser);
	s = sc.nextLine();
	return s;
    }
    
}
