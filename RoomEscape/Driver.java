import java.util.Scanner;

public class Driver{
    public static void main(String[] args){
	Game g = new Game();
	Inventory stuff = new Inventory();

	public static void wait(int num){
	    try{
		Thread.sleep(num);
	    }
	    catch (Exception e){}
	}

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
	        String inspect = new Driver().AskUser("\nYou want to inspect... [0]Bed, [1]Desk, [2]Bag, [3]Trash can, [4]Rug, [5]Bookshelf, [6]Poster, [7]Closet, [8]Bathroom door");
		if (inspect.equals("0" || "1" || "2" || "3" || "4" || "5" || "6" || "7" || "8")){
		    g.getRoom().get(inspect).getDescript();
		}
		System.out.println("What do you want to do?");
		String c = new Driver().AskUser("[1]Inspect further, [2]Move on");
		if (c.equals("1")){
		    g.interact(g.getRoom().get(inspect));
		}
	    }
	}

	for (int i = 0;i < g.getRoom().size();i++){
	    System.out.println(g.getRoom().get(i));
	}
    }
    public String AskUser(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.print(mToUser);
	s = sc.nextLine();
	return s.toLowerCase();
    }
}
