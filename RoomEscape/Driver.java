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

	int player = d.AskUser("Are you a new player? [1]Yes [2]No\n");
	if (player == 1){
	    System.out.println("...Huh? Where is this?");
	    wait(2000);
	    System.out.println("You are lying in bed...Is this your room?");
	    wait(2000);
	    System.out.println("It's too dark to see. You go to flip the lights on, but nothing happens.");
	    wait(2000);
	    System.out.println("Instead, you turn on your lamp. The room is dimly lit.");
	    wait(2000);
	    System.out.println("There is a piece of paper taped to the door.");
	    wait(2000);
	    System.out.println("It says: "+ g.getRoom().get(10).getDescript());
	    wait(5000);
	}

	System.out.println("\n...alright, let's get out of here.\n");

	stuff.take(g.getRoom().get(10));

	System.out.println("\nYou take a look around. Your bed seems very messy now that you can see it. Your desk is next to your bed, with a trash can underneath it. Your bag sits on the floor next to your desk, and there is a large rug in the center of the room. There is a bookshelf in the corner and a poster on the wall. You also see your closet doors and the door to the bathroom.");
    
	System.out.println("\nNow that you've taken a good look at your room, what do you want to do?");

	boolean endGame = false;

	while (g.gameWon() == false && endGame == false){

	    int r = d.AskUser("\n[1]Inspect an object, [2]Look at Inventory, [3]Exit Game\n");
	    if (r == 1){
		int i = 0;
		while (i != 1 && g.gameWon() == false){
		    int inspect = d.AskUser("\nYou want to inspect... \n[0]Bed\n[1]Desk\n[2]Bag\n[3]Rug\n[4]Trash can\n[5]Bookshelf\n[6]Poster\n[7]Closet\n[8]Bathroom door\n[9]Ceiling\n[10]Door\n[11]Nothing. Let's go back to the main menu\n");
		    if (inspect >= 0 && inspect < 10){
			System.out.println(g.getRoom().get(inspect).getDescript());
			int i2 = 0;
			while (i2 != 1){
			    System.out.println("\nWhat do you want to do with it?");
			    int c = d.AskUser("[1]Inspect further, [2]Move on\n");
			    if (c == 1){
				g.interact(g.getRoom().get(inspect));
				i2 = 1;
			    }
			    else if (c == 2){
				i2 = 1;
			    }
			    else{
				System.out.println(g.getM());
			    }
			}
		    }
		    else if (inspect == 10){
			g.checkDoor();
		    }
		    else if (inspect == 11){
			i = 1;
		    }
		    else {
			System.out.println(g.getM());
		    }
		}
	    }
	    else if (r == 2){
		int c = 0;
		while (c != 4){
		    	System.out.println(stuff.list() + "\n");
		    c = d.AskUser("\n[1]Inspect an item, [2]Combine items, [3]Equip items, [4]Exit Inventory\n");
		    if (c == 1){
			int choice = d.AskUser("\nWhich item would you like to inspect?\n");
			try{
			System.out.println(stuff.get().get(choice).getDescript());
			}
			catch(Exception e){
			    System.out.println(g.getM());
			}
		    }
		    else if (c == 2){
			g.toCombine();
		    }
		    else if (c == 3){
			g.toEquip();
		    }
		}
	    }
	    else if (r == 3){
		endGame = true;
	    }
	    else {
		System.out.println(g.getM());
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
