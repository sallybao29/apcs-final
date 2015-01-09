import java.util.*;

public class SudokuPuzzle{
    private int[][] board = new int[9][9];
    private int[][] ans = new int[9][9];
    private boolean solved = false;
    private boolean quit = false;
    private int[][] sections = new int[9][9];
    private int[][] rows = new int[9][9];
    private int[][] columns = new int[9][9];
    private int upTo = 0;

    public void generateGame(){
	Random r = new Random();
	int j = 0;
	int c;
	for (int i = 0; i < 9; i++){
	    while (j < 9){
		c = r.nextInt(9) + 1;
		if (possible(c,i,j)){

		    // add to board
		    board[i][j] = c;
		    j += 1;

		    // keeping track... 
		    rows[r][c] = c;
		    columns[c][r] = c;

		    sections[s][upTo] = c;
		    upTo += 1;

		    j += 1;
		}
	    } 
	}
    }

    public boolean possible(int num, int r, int c){
	//checking row
	for (int i = 0; i < 9; i++){
	    if (rows[r][i] == num){
		return false;
		break;
	    }
	}

	//checking columns
	for (int i = 0; i < 9; i++){
	    if (columns[c][i] == num){
		return false;
		break;
	    }
	}

	//checking 3 by 3 sections
	int s = findsection(r, c);

	for (int i = 0; i < 9; i++){
	    if (sections[s][i] == num){
		return false;
		break;
	    }
	}

	return true;
    }

    public int findsection(int r,int c){
	if (r < 3){
	    if (c < 3){return 0;}
	    else if (c < 6){return 1;}
	    else {return 2;}
	}
	else if (r < 6){
	    if (c < 3){return 3;}
	    else if (c < 6){return 4;}
	    else {return 5;}
	}
	else{
	    if (c < 3){return 6;}
	    else if (c < 6){return 7;}
	    else {return 8;}
	}
    }
}
