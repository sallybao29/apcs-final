import java.util.*;

public class MineSweeper {
    private String[][] board = new String[9][9];
    private String[][] ans = new String[9][9];
    private boolean[][] show = new boolean[9][9]; //tracks squares user has checked
    private boolean solved = false;
    private boolean quit = false;
    private boolean skip = false;
    private boolean lost = false;
    private int mineNum = 5; //difficulty level based on number of mines
    private int adjacent = 0; //number of mines nearby
	
    public void setMineNum(int n){
	mineNum = n;
    }
	
    public void generateGame(){
	//set up mines
	int r, c;
	int prevAdj = -1;
		
	Random rand = new Random();
		
	while (mineNum > 0){
	    r = rand.nextInt(9);
	    c = rand.nextInt(9);
			
	    if (board[r][c] == null){
		board[r][c] = "*";
		mineNum -= 1;
	    }
	}
		
	//set up number hints
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == null){
			
		    //count number of mines nearby		
		    hintHelper(i,j+1);
		    hintHelper(i,j-1);
		    hintHelper(i-1,j);
		    hintHelper(i+1,j);
		    hintHelper(i-1,j-1);
		    hintHelper(i-1,j+1);
		    hintHelper(i+1,j-1);
		    hintHelper(i+1,j+1);
					
		    if (adjacent == 0){
			board[i][j] = " ";
		    }
		    else{
			board[i][j] = "" + adjacent;
			adjacent = 0;
		    }
		}
	    }
	}
	ans = board;
    }
	
    public void hintHelper(int a, int b){
	try{
	    if (board[a][b] == "*"){
		adjacent += 1;
	    }
	}
	catch(Exception e){
	}
    }
	
    public String ansToString(){
	String s = "-------------------------------------\n";
	for (int i = 0; i < ans.length; i++) {
	    for (int j = 0; j < ans[i].length; j++) {
		s = s + "| " + ans[i][j] + " ";
	    }
	    s = s + "|\n-------------------------------------\n";
	}
	return s;
    }
	
    public String toString(){
	String s = "-------------------------------------\n";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (show[i][j] == true){
		    s = s + "| " + board[i][j] + " ";
		}
		else{
		    s += "|:::";
		}
	    }
	    s = s + "|\n-------------------------------------\n";
	}
	return s;
    }
	
    public void userInteract(){
	while (solved == false && lost == false && quit == false && skip == false){
	    System.out.println("Current Board: \n" + toString());
	    String c = this.AskUser("x-coordinate, y-coordinate (or skip, or quit): ");
	    int choicex = Integer.parseInt(c.substring(0,1));
	    int choicey = Integer.parseInt(c.substring(2,3));
			
	    // allows the user to temporarily quit the puzzle
	    if (c.equals("quit")){
		quit = true;
	    }
			
	    // allows the user to permanently skip the puzzle
	    else if (c.equals("skip")){
		skip = true;
	    }
			
	    show[choicex][choicey] = true;
	    
	    //if mine found
	    if (ans[choicex][choicey] == "*"){
		lost = true;
	    }
	}
	if (lost == true){
	    System.out.println("\nFinal Board: \n" + toString());
	    System.out.println("\nSorry, you have lost!");
	}
	else if (quit == true){
	    System.out.println("\nOh well. You'll still try again later, right?");
	}
	else if (skip == true){
	    System.out.println("\nWHAT? You've skipped? But you're so close!");
	}
	else{
	    System.out.println("\nYay, you've won! Good job clearing the field.");
	}
    }
		 
    public String AskUser(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.print(mToUser);
	s = sc.nextLine();
	return s;
    }
	
    public static void main(String[] args){
    	MineSweeper d = new MineSweeper();
    	d.generateGame();
    	d.userInteract();
    }
}
