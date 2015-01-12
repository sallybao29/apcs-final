import java.util.*;
import java.io.*;

public class EightGamePuzzle{
    
    private int[][] board = new int[3][3];
    private int[][] ans = new int[3][3];
    private ArrayList<Integer> moves = new ArrayList<Integer>();
    private boolean solved = false;
    private boolean quit = false;
    private boolean skip = false;

    public boolean getSkip(){
	return skip;
    }

    public void generateGame(int numScram){
	int current = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = current;
		current += 1;
	    }
	}
	current = 0;
	for (int i = 0; i < ans.length; i++) {
	    for (int j = 0; j < ans[i].length; j++) {
	        ans[i][j] = current;
		current += 1;
	    }
	}
	boardScrambler(numScram);
    }

    private int zposh = 0;
    private int zposv = 0;
    public void boardScrambler(int numScram){
	Random r = new Random();
	int n = numScram;
	int prevc = 0;
	int c;
        while (n > 0){
	    c = r.nextInt(4);
	    if (c-prevc != 2 || c-prevc != -2){
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
    public void check(){
	if (Arrays.equals(board[0], ans[0])&&
	    Arrays.equals(board[1], ans[1])&&
	    Arrays.equals(board[2], ans[2])){
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

	    if (c.equals("quit")){
		quit = true;
	    }
	    else if (c.equals("skip")){
		skip = true;
	    }
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
	if (solved == true){
	    System.out.println("\nCongrats! :) You have unlocked your phone!");
	}
	else if (skip == true){
	    System.out.println("\n:( You skipped? Oh well... Your phone is unlocked anyways.");
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

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~Testing~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args){
    	EightGamePuzzle p = new EightGamePuzzle();
    	p.generateGame(5);
	boolean a = p.userSteps();
	if (!a){
	    System.out.println("done");
	}
    }
}
