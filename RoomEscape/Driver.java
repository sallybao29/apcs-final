import java.util.Scanner;

public class Driver{

    public static void wait(int num){
	try{
	    Thread.sleep(num);
	}
	catch (Exception e){}
    }

    public static void main(String[] args){
	Game g = new Game();
	Inventory stuff = new Inventory();
	Driver d = new Driver();

	System.out.println("...Huh? Where is this?");
	wait(2000);
	System.out.println("You are lying in bed...Is this your room?");
	wait(2000);
	System.out.println("It's too dark to see. You go to flip the lights on, but nothing happens.");
	wait(2000);
	System.out.println("Instead, you turn on your lamp. At least you can see now.");
	wait(2000);
	System.out.println("It really is your room. For some reason, the door is now a large metal one with no visible handle in sight.");
	wait(2000);
	System.out.println("There is a piece of paper taped to the door.");
	wait(2000);
	System.out.println("It says: "+ g.getRoom().get(10).getDescript());
	wait(5000);
	System.out.println("...alright, let's get out of here.");
	stuff.take(g.getRoom().get(10));



	System.out.println("\nYou take a look around. Your bed seems very messy now that you can see it. Your desk is next to your bed, with a trash can underneath it... <Continue with description>");
    
	System.out.println("\nNow that you've taken a good look at your room, what do you want to do?");

	boolean endGame = false;

	while (g.gameWon() == false && endGame == false){

	    int r = d.AskUser("\n[1]Inspect an object, [2]Look at Inventory, [3]Exit Game\n");
	    if (r == 1){
		int i = 0;
		int inspect = d.AskUser("\nYou want to inspect... \n[0]Bed\n[1]Desk\n[2]Bag\n[3]Trash can\n[4]Rug\n[5]Bookshelf\n[6]Poster\n[7]Closet\n[8]Bathroom door\n[9]Ceiling\n");
		while (i != 1){
		    if (inspect >= 0 && inspect < 10){
			System.out.println(g.getRoom().get(inspect).getDescript());
			i = 1;
		    }
		    else {
			System.out.println("\nPlease enter the number of an item.");
		    }
		}
		System.out.println("\nWhat do you want to do with it?");
		i = 0;
		while (i != 1){
		    int c = d.AskUser("\n[1]Inspect further, [2]Move on\n");
		    if (c == 1){
			g.interact(g.getRoom().get(inspect));
			i = 1;
		    }
		    else if (c == 2){
			i = 1;
		    }
		    else{
			System.out.println("\nPlease enter the number of your choice\n");
		    }
		}
	    }
	    else if (r == 2){
		System.out.println(stuff.list());
		int c = 0;
		while (c != 2){		   
		    c = d.AskUser("\n[1]Inspect an item, [2]Exit Inventory\n");
		    if (c == 1){
			int choice = d.AskUser("\nWhich item would you like to inspect?");
			System.out.println(stuff.getInventory().get(choice).getDescript());		
		    }
		}
	    }
	    else if (r == 3){
		endGame = true;
	    }
	    else {
		System.out.println("Please enter the number of your choice");
	    }
	}
	
	if (endGame){
	    System.out.println("What?! You Quit? Such a disappointment.");
	}
	else{
	    System.out.println("Yes! You're finally free!");
	}
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
}
