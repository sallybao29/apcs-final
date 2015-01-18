import java.util.*;

public class MineSweeper {
    private String[][] board = new String[9][9];
    private String[][] ans = new String[9][9];
    private boolean[][] show = new boolean[9][9]; //tracks squares user has checked
    private String rows = "ABCDEFGHI";
    private boolean solved = false;
    private boolean quit = false;
    private boolean skip = false;
    private boolean lost = false;
    private int mineNum = 10; //difficulty level based on number of mines
    private int adjacent = 0; //number of mines nearby
	
    public void setMineNum(int n){
	mineNum = n;
    }
	
    public void generateGame(){
	//set up mines
	int r, c;		
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
		    if (i != 0){
			if (j != 0){
			    hintHelper(i-1,j-1);
			}
			if (j != board[i].length-1){
			    hintHelper(i-1,j+1);
			}
			hintHelper(i-1,j);
		    }
		    if (i != board.length-1){
			if (j != 0){
			    hintHelper(i+1, j-1);
			}
			if (j != board[i].length-1){
			    hintHelper(i+1, j+1);	
			}
			hintHelper(i+1,j);
		    }
		    if (j != 0){
			hintHelper(i,j-1);
		    }
		    if (j != board[i].length-1){
			hintHelper(i,j+1);
		    }
					
		    //if no mines nearby...
		    if (adjacent == 0){
			board[i][j] = " ";
		    }
					
		    //if there are mines...
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
	if (board[a][b] == "*"){
	    adjacent += 1;
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
	String s = "    1   2   3   4   5   6   7   8   9\n  -------------------------------------\n";
	for (int i = 0; i < board.length; i++) {
	    s += rows.substring(i,i+1) + " ";
	    for (int j = 0; j < board[i].length; j++) {
		if (show[i][j] == true){
		    s = s + "| " + board[i][j] + " ";
		}
		else{
		    s += "|:::";
		}
	    }
	    s = s + "|\n  -------------------------------------\n";
	}
	return s;
    }
	
    public void userInteract(){
	System.out.println(ansToString());
	while (solved == false && lost == false && quit == false && skip == false){
	    System.out.println("Current Board: \n" + toString());
	    String c = this.AskUser("Location (or skip, or quit): ");
			
	    // allows the user to temporarily quit the puzzle
	    if (c.equals("quit")){
		quit = true;
	    }
			
	    // allows the user to permanently skip the puzzle
	    else if (c.equals("skip")){
		skip = true;
	    }
			
	    else if (checkPossible(c) == true){
		int choicex = rows.indexOf(c.substring(0,1).toUpperCase());
		int choicey = Integer.parseInt(c.substring(1,2))-1;
		show[choicex][choicey] = true;
				
		//if mine found
		if (ans[choicex][choicey] == "*"){
		    lost = true;
		}
				
		//if empty found
		else if (ans[choicex][choicey] == " "){
		    revealEmpties(choicex, choicey);
		}
	    }
			
	    else{
		System.out.println("The format of your choice should be: Letter# (Example: A1)");
	    }
	}
	if (lost == true){
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
	System.out.println("\nAnswer: \n");
	System.out.println(ansToString());
    }
	
    //show all the empty squares next to the one chosen
    public void revealEmpties(int x, int y){
	int a = x;
	int b = y;
	boolean goingDown = true;
		
	while (a >= 0){
			
	    if (goingDown == true && a == board.length-1){
		revealRowEmpties(a,b,x,y);
		goingDown = false;
		a = x;
	    }
			
	    else if (emptyHelper(a,b) == true && goingDown == true){
		revealRowEmpties(a,b,x,y);
		a++;
	    }
			
	    else if (emptyHelper(a,b) == true && goingDown == false){
		revealRowEmpties(a,b,x,y);
		a--;
	    }
			
	    else if (goingDown == true && b < board.length-1){
		//revealRowEmpties(a,b,x,y);
		System.out.println("[1]Next hints revealed");
		revealEmptyHints(a,b,x,y,a-1);
		goingDown = false;
		b = y;
	    }
			
	    else if (goingDown == false && b > 0){
		System.out.println("[2]Next hints revealed");
		revealEmptyHints(a,b,x,y,a+1);
		break;
	    }
			
	}
    }
	
    public void revealRowEmpties(int a, int b, int x, int y){
	//reveal empty squares in each row
	boolean goingRight = true;
	while(b >= 0){
	    //if end of board reached
	    if (goingRight == true && b == board[x].length-1){
		show[a][b] = true;
		goingRight = false;
		b = y;
	    }
			
	    //reveals if empty
	    else if (emptyHelper(a,b) == true && goingRight == true){
		show[a][b] = true;
		b++;
	    }
	    else if (emptyHelper(a,b) == true && goingRight == false){
		show[a][b] = true;
		b--;
	    }
			
	    //reveals hint next to empty square
	    else if (goingRight == true && b < board[x].length-1){
		show[a][b] = true;
		goingRight = false;
		b = y;
	    }
			
	    //finished row
	    else if (goingRight == false && b >= 0){
		show[a][b] = true;
		break;
	    }
	}
    }
	
    public void revealEmptyHints(int a, int b, int x, int y, int check){
	boolean goingRight = true;

	while (b > 0){
	    System.out.println(b);
			
	    if (goingRight == true && b == board[x].length-1){
		show[a][b] = true;
		goingRight = false;
		b = y;
	    }
			
	    else if (emptyHelper(check,b) == true && goingRight == true){
		show[a][b] = true;
		b++;
	    }
	    else if (emptyHelper(check,b) == true && goingRight == false){
		show[a][b] = true;
		b--;
	    }
			
	    else if (goingRight == true && b < board[x].length-1){
		show[a][b] = true;
		goingRight = false;
		b = y;
	    }
			
	    else if (goingRight == false && b >= 0){
		show[a][b] = true;
		break;
	    }
	}
    }
	
    public boolean emptyHelper(int a, int b){
	return board[a][b] == " ";
    }
	
    //checks if user input is a possible choice
    public boolean checkPossible(String c){
	if (c.length() != 2){
	    return false;
	}
	for (int i = 0; i < rows.length(); i++){
	    if ((c.substring(0,1).toUpperCase()).equals(rows.substring(i,i+1)) == true){
		int num;
		try{
		    num = Integer.parseInt(c.substring(1,2));
		}
		catch(NumberFormatException e){
		    num = -1;
		}
		if (num > 0 && num <= 9){
		    return true;
		}
	    }
	}
	return false; 
    }
	
    //user input
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
