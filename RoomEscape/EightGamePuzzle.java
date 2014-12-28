import java.util.*;
import java.io.*;

public class EightGamePuzzle{
    
    private int[][] board = new int[3][3];
    private ArrayList<Integer> moves = new ArrayList<Integer>();
    private boolean solved;

    public void generateGame(int numScram){
	int current = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = current;
		current += 1;
	    }
	}
	boardScrambler(numScram);
    }

    public void boardScrambler(int numScram){
	Random r = new Random();
	int n = numScram;
	int zposh = 0;
	int zposv = 0;
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

    // public void UserSteps(){
    // 	int zposh = 0;
    // 	int zposv = 0;
    // 	while (!solved){
    // 	    int c = this.AskUser("Enter your move here(l,u,r,d): ");
    // 	    if (c == 0 && zposh
    // 	}
    // }

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

    public int AskUser(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.print(mToUser);
	s = sc.nextLine();
	try{
	    return Integer.parseInt(s);
	}
	catch(NumberFormatException e){
	    return -1;
	}
    }

    // public static void main(String[] args){
    // 	EightGamePuzzle p = new EightGamePuzzle();
    // 	p.generateGame(3);
    // 	System.out.println(p);
    // }
}
