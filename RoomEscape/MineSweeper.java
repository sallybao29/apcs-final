import java.util.*;

public class MineSweeper {
    private String[][] board = new String[9][9];
    private String[][] ans = new String[9][9];
    private boolean[][] show = new boolean[9][9]; //tracks squares user has checked
    private String rows = "ABCDEFGHI";
    private boolean solved = false, 
	quit = false,
	lost = false,
	skip = false;
    private int mineNum = 12;
    private int adjacent = 0; //number of mines nearby

    public boolean getLost(){
	return lost;
    }
    public boolean getSkip(){
	return skip;
    }
	
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
	
    public boolean userInteract(){
	while (!solved && !lost && !quit && !skip){
	    System.out.println("\n           Current Board: \n\n" + toString());
	    String c = this.AskUser("Location, skip, quit, or check: ");
			
	    // allows the user to temporarily quit the puzzle
	    switch(c){
	    case "quit":
		quit = true;
		break;
	    case "skip":
		solved = true;
		skip = true;
		break;
	    case "check":
		solved = checkSolved();
		if (!solved){
	    	    System.out.println("\nSorry, keep trying!");
	    	}
		break;
	    }			
	    if (checkPossible(c) == true){
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
	    System.out.println("\n\nSorry, you have lost!");
	}
	else if (skip ==  true){
	    System.out.println("\n\nYou skipped? But you were so close!");
	}
	else if (quit == true){
	    System.out.println("\n\nOh well. You'll still try again later, right?");
	}
	else{
	    System.out.println("\n\n~***~ Yay, you've won! Good job clearing the field. ~***~");
	}
	wait(2000);
	System.out.println("\nAnswer: \n");
	System.out.println(ansToString());
	return solved;
    }
	
    //show all the empty squares next to the one chosen
    public void revealEmpties(int x, int y){
	int a = x;
	int b = y;
	boolean goingDown = true;
		
	while (a >= 0){
			
	    if (goingDown == true && a == board.length-1){
		revealRowEmpties(a,b,x,y,"n");
		goingDown = false;
		a = x;
	    }
			
	    else if (emptyHelper(a,b) == true && goingDown == true){
		revealRowEmpties(a,b,x,y,"n");
		a++;
	    }
			
	    else if (emptyHelper(a,b) == true && goingDown == false){
		revealRowEmpties(a,b,x,y,"n");
		a--;
	    }
  
	    else if (goingDown == true && a < board.length-1){
		revealRowEmpties(a,b,x,y,"down");
		goingDown = false;
		b = y;
	    }
			
	    else if (goingDown == false){
		revealRowEmpties(a,b,x,y,"up");
		break;
	    }
			
	}
    }
	
    public void revealRowEmpties(int a, int b, int x, int y, String h){
	int check;
	if (h == "up"){
	    check = a+1;
	}
	else if (h == "down"){
	    check = a-1;
	}
	else{
	    check = a;
	}
	    
	//reveal empty squares in each row
	boolean goingRight = true;
	while(b >= 0){

	    // if certain squares extend beyond the lowest 
	    if (h == "up"){
		if (emptyHelper(a,b) == true && a > 0 && show[a-1][b] == false){
		    revealEmpties(a,b);
		}
	    }
	    if (h == "down"){
		if (emptyHelper(a,b) == true && a < board.length-1 && show[a+1][b] == false){
		    revealEmpties(a,b);
		}
	    }

	    //if end of board reached
	    if (goingRight == true && b == board[x].length-1){
		if (a > 0 && check == a){
		    show[a-1][b] = true;
		}
		if (a < board.length-1 && check == a){
		    show[a+1][b] = true;
		}
		show[a][b] = true;
		goingRight = false;
		b = y;
	    }
			
	    //reveals if empty
	    else if (emptyHelper(check,b) == true && goingRight == true){
		if (a > 0 && check == a){
		    show[a-1][b] = true;
		}
		if (a < board.length-1 && check == a){
		    show[a+1][b] = true;
		}
		show[a][b] = true;
		b++;
	    }
	    else if (emptyHelper(check,b) == true && goingRight == false){
		if (a > 0 && check == a){
		    show[a-1][b] = true;
		}
		if (a < board.length-1 && check == a){
		    show[a+1][b] = true;
		}
		show[a][b] = true;
		b--;
	    }
			
	    //reveals hint next to empty square
	    else if (goingRight == true && b < board[x].length-1){
		if (a > 0 && check == a){
		    show[a-1][b] = true;
		}
		if (a < board.length-1 && check == a){
		    show[a+1][b] = true;
		}
		show[a][b] = true;
		goingRight = false;
		b = y;
	    }
			
	    //finished row
	    else if (goingRight == false){
		if (a > 0 && check == a){
		    show[a-1][b] = true;
		}
		if (a < board.length-1 && check == a){
		    show[a+1][b] = true;
		}
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
	
	
    //checks if board has been solved (checks if only mines are left unrevealed)
    public boolean checkSolved(){
	int unrevealed = 0;
	for (int i = 0; i < show.length; i++){
	    for (int j = 0; j < show[i].length; j++){
		if (unrevealed > mineNum){
		    return false;
		}
		else if (show[i][j] == false && !ans[i][j].equals("*")){
		    unrevealed += 1;
		}
	    }
	}
	return true;
    }

    public static void wait(int num){
	try{
	    Thread.sleep(num);
	}
	catch (Exception e){}
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
