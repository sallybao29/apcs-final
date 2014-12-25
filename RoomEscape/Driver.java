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

	Scanner sc = new Scanner(System.in());
	String choice = sc.nextLine();
	while (g.gameWon
	System.out.println("What do you want to look at?")

	for (int i = 0;i < g.getRoom().size();i++){
	    System.out.println(g.getRoom().get(i));
	}
    }
}
