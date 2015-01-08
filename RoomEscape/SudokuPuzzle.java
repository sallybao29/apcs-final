import java.util.*;

public class SudokuPuzzle{
    private int[][] board = new int[9][9];
    private int[][] ans = new int[9][9];
    private boolean solved = false;
    private boolean quit = false;
    private int[][] sections = new int[9][9];
    private ArrayList<Integer> r = new ArrayList<Integer>();
    private ArrayList<Integer> c = new ArrayList<Integer>();


    public void generateGame(){
	Random r = new Random();
	int j = 0;
	int c;
	for (int i = 0; i < 9; i++){
	    while (j < 9){
		c = r.nextInt(9) + 1;
		if (possible()){
		    board[i][j] == c;
		    j += 1;
		}
	    } 
	}
    }
}
