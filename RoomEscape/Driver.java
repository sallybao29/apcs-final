import java.util.Scanner;
import java.io.File;

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

	System.out.println("\nYou take a look around. Your bed is a visible mess, with tossed clothes peeking out of haphazardly strewn sheets. A poster looms over the bed like a nagging mother, reminding you to study every day. A desk of carved oak rests by your bed, its neatness a stark contrast to your pigsty of a bed. You are assaulted with the smell of rotting fruit coming from the trash can under the desk and quickly move on. Your deformed bag sits on the floor next to your desk, some of its contents spilled onto the burned fringes of the circular rug that lies in the center of the room. There is a decrepit bookshelf in the corner that threatens to fall apart as soon as a book is removed. You also see the sliding doors of your closet and the door to the bathroom.");
    
	System.out.println("\nNow that you've taken a good look at your room, what do you want to do?");

	boolean endGame = false;

	while (g.gameWon() == false && endGame == false){

	    int r = d.AskUser("\n[1]Inspect an object, [2]Look at Inventory, [3]Exit Game, [4]See Walkthrough\n");
	    switch(r){
	    case 1:
		int i = 0;
		while (i != 1 && g.gameWon() == false){
		    int inspect = d.AskUser("\nYou want to inspect... \n[0]Bed\n[1]Desk\n[2]Bag\n[3]Rug\n[4]Trash can\n[5]Bookshelf\n[6]Poster\n[7]Closet\n[8]Bathroom door\n[9]Ceiling\n[10]Door\n[11]Nothing. Let's go back to the main menu\n");
		    if (inspect >= 0 && inspect < 10){
			System.out.println(g.getRoom().get(inspect).getDescript());	      
			g.interact(g.getRoom().get(inspect).getName());
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
		break;
	    case 2:
		int c = 0;
		while (c != 4){
		    System.out.println(stuff + "\n");
		    c = d.AskUser("\n[1]Inspect an item, [2]Combine items, [3]Equip items, [4]Exit Inventory\n");
		    switch(c){
		    case 1:
			int choice = d.AskUser("\nWhich item would you like to inspect?\n");
			try{
			    System.out.println(stuff.get().get(choice).getDescript());
			}
			catch(Exception e){
			    System.out.println(g.getM());
			}
			break;
		    case 2:
			g.toCombine();
			break;
		    case 3:
			g.toEquip();
			break;
		    }
		}
		break;
	    case 3:
		endGame = true;
		break;
	    case 4:
		showWalkthrough("Walkthrough.txt");
		break;
	    default:
		System.out.println(g.getM());
	    }	
	}

	if (endGame){
	    System.out.println("\nWhat?! You Quit? Such a disappointment.");
	}
	else{
	    System.out.println("\nYes! You're finally free!");
	    g.Scenario();
	}
    }

    public static void showWalkthrough(String f){
	Scanner sc = null;
	try {
	    sc = new Scanner(new File(f));
	} catch (Exception e) {
	    System.out.println("File not found");
	    System.exit(0);
	}
	while (sc.hasNext()){
	    String s = sc.next();
	    System.out.println(s);
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
