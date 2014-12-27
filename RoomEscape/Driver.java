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
	System.out.println("It says: "+ g.getRoom().get(9).getDescript());
	wait(5000);
	System.out.println("...alright, let's get out of here.");
	stuff.take(Letter);

	//Scanner sc = new Scanner(System.in());
	//String choice = sc.nextLine();

	System.out.println("What do you want to look at?");
        String r = new Driver().AskUser("\n[1]Look around");
	if (r.equals("1")){
	    System.out.println("\nYou take a look around. Your bed seems very messy now that you can see it. Your desk is next to your bed, with a trash can underneath it... <Continue with description>");
	}
	System.out.println("\nNow that you've taken a good look at your room, what do you want to do?");

	while (g.gameWon() == false){
	    
	    r = new Driver().AskUser("\n[1]Inspect an object, [2]Look at Inventory: ");
	    if (r.equals("1")){
		int i = 0;
		while (i != 1){
		    String inspect = new Driver().AskUser("\nYou want to inspect... [Bed], [Desk], [Bag], [Trash can], [Rug], [Bookshelf], [Poster], [Closet], [Bathroom door]");
		    if (inspect.equals("Bed") || 
			inspect.equals("Desk") || 
			inspect.equals("Bag") || 
			inspect.equals("Trash can") ||
			inspect.equals("Rug") || 
			inspect.equals("Bookshelf") || 
			inspect.equals("Poster") || 
			inspect.equals("Closet") || 
			inspect.equals("Bathroom door")){
			g.getRoom().((Item)inspect).getDescript();
			i = 1;
		    }
		    else {
			System.out.println("\nPlease enter the name of an item.");
		    }
		}
		System.out.println("\nWhat do you want to do?");
		i = 0;
		while (i != 1){
		    String c = new Driver().AskUser("\n[1]Inspect further, [2]Move on");
		    if (c.equals("1")){
			g.interact(g.getRoom().get(inspect));
			i = 1;
		    }
		    else if (c.equals("2")){
		        i = 1;
		    }
		    else{
			System.out.println("\nPlease enter the number of your choice");
		    }
		}
	    }
	    else if (r.equals("2")){
		System.out.println(stuff.list());
		String c = new Driver().AskUser("\n[1]Inspect an item, [2]Exit Inventory");
		if (c.equals("1")){
		    String inspect = new Driver().AskUser("\nWhich item would you like to inspect?");
		    stuff.inspect.getDescript();
		}
		else if (c.equals("2")){
		}
	    }
	}

	for (int i = 0;i < g.getRoom().size();i++){
	    System.out.println(g.getRoom().get(i));
	}

	System.out.println("Yes! You're finally free!");
    }

    public String AskUser(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.print(mToUser);
	s = sc.nextLine();
	return s.toLowerCase();
    }
}
