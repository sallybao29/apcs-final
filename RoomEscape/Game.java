import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    private boolean gameWon;
    private ArrayList<Item> room = new ArrayList<Item>();
    private ArrayList<Item> closet = new ArrayList<Item>();
    private ArrayList<Item> bathroom = new ArrayList<Item>();
    Inventory inventory = new Inventory();
    EightGamePuzzle eightGame = new EightGamePuzzle();

    public Game(){
	gameWon = false;
	room.add(new Item("Bed", "Your bed. There's a blanket and a pillow and not much else.", false));        //0
	room.add(new Item("Desk", "A relatively clean desk with a laptop and a pencil holder on it. It has two drawers.", false));   //1
	room.add(new Item("Bag", "A bag filled to the brim with notes and school supplies. There is a small pocket on the front and a waterbottle holder on the side.", false));   //2
	room.add(new Item("Trash can", "Something stinks. You haven't taken the trash out for a while.", false));  //3
	room.add(new Item("Rug", "A hideous Pikachu rug you bought when you were ten. Maybe there's something under it?", false));  //4
	room.add(new Item("Bookshelf", "It's full of test prep books and encyclopedias. Looks like your parents threw out all your manga.", false));  //5
	room.add(new Item("Poster", "A poster of the periodic table of elements.",false));   //6
	room.add(new Item("Closet", "A closet with sliding doors", false));   //7
	room.add(new Item("Bathroom door", "The door to the bathroom", false));  //8
	room.add(new Item("Ceiling", "There's a vent on the ceiling. Even in the dark, something glistens.", false));  //9
	room.add(new Item("Letter", "\n\nSon, we saw your last math test score.\nYou have brought shame to your family.\nBut it's alright, everyone makes mistakes.\nA great man once said, \"A man must be bIg enough to admit his miStakes, smart enough to profIt from them, and strong enough to Correct them.\" So just stay in your room and reflect on your actions for another two days.\nBy then, you will surely have been able to realize the error of your ways and find the solution to your demise.\n\nSincerely, Your Parents", true));   //10
	room.add(new Puzzle("Laptop", "You can't log on. It seems your parents have changed the password.", "1234", "The display changes to your homescreen. Alright, you're finally on!"));    //11
	room.add(new Item("Pencil Holder", "Ohh, shiny pencils", false));  //12
	room.add(new Item("Drawer", "It's locked. You need to find a key", false));   //13
	room.add(new Item("Vent", "It's stuck. You're gonna need a screwdriver", false));   //14
	room.add(new Item("Pillow", "A fluffy fluff pillow. There's a note inside the cover", false));   //15
	room.add(new Item("Pencil", "A 2B Ticonderoga pencil", true));  //16
	room.add(new Item("Key", "The key to the desk drawer", true));  //17
	room.add(new Item("Fig", "A dried up fig", true));     //18
	room.add(new Item("Math test", "The math test you failed", true));  //19
	room.add(new Item("Phone", "Oh look, your phone. Its screen displays an 8-game puzzle", true));
  

	closet.add(new Item("Screwdriver", "A Phillips screwdriver. This might come in handy", true));
	closet.add(new Item("Paperclips", "Some colorful paperclips. You know what they are!", true));
    }

    public ArrayList<Item> getRoom(){
	return room;
    }	

    public boolean gameWon(){
	return gameWon;
    }		
    
    public void editStatus(){
	gameWon = true;
    }

    public void interact(Item thing){
	int c;
	int i = 0;
	
	if (thing.equals(room.get(0))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Check under the blankets\n[2]Check pillow\n[3]Already saw the bed");
		if (c == 1){
		    System.out.println("\nThere's nothing there");
		}
		else if (c == 2){
		    System.out.println(room.get(15).getDescript());
		    if (room.get(15).getStatus() == false){
			System.out.println("You took the note");
			room.get(15).changeDescript("A fluffy fluff pillow. Just looking at it makes you want to lie down in bed");
			room.get(15).changeStatus();
		    }	    
		}
		else if (c == 3){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if (thing.equals(room.get(1))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Check laptop\n[2]Check pencil holder\n[3]Check drawer\n[4]Nope"); 
		if (c == 1){
		    if (((Puzzle)room.get(11)).getSolved() == true){
			room.get(11).changeDescript("An emacs file is open. There is a piece of code on it:\n\nRandom r = new Random();\ndouble stress = r.nextDouble();\nboolean codeWorks = (r.nextInt(2) == 1);\npublic void writeCode()\n\tif (codeWorks){\n\t\tSystem.out.println(\"I am a GOD\");\n\t}\n\telse{\n\t\tif (stress > 0.7){\n\t\t\tsystem.out.println(\"RAGE QUIT\")\n\t\t\tSystem.exit(0);\n\t\t}\n\t\tcry();\n\t}\n}\n\nWhat could it mean?");
			System.out.println(room.get(11).getDescript());
		    }
		    else {   
			System.out.println(room.get(11).getDescript()); 
			String ans = "" + this.AskUser("\nEnter Password: ");
			((Puzzle)room.get(11)).check(ans);
		    }
		}
		else if (c == 2){
		    System.out.println(room.get(12).getDescript());
		    if (room.get(12).getStatus() == false){
			System.out.println("You took a pencil");
			room.get(12).changeStatus();
		    }
		}
		else if (c == 3){
		    if (room.get(13).getStatus() == false){
			System.out.println(room.get(13).getDescript());     
		    } 
		}
		else if (c == 4){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if (thing.equals(room.get(2))){
	    System.out.println(room.get(2).getDescript());
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Open small pocket\n[2]Look through notes\n[3]Move on");
		int i2;
		int c2;
		if (c == 1){
		    System.out.println("\nYou find your student metrocard, your student ID, your phone, and a few TicTacs");
		    i2 = 0;
		    while (i2 != 1){
			c2 = this.AskUser("\n[1]Inspect phone, [2]Take the Tictacs, [3]Eh, I'll move on");
			if (c2 == 1){
			    System.out.println("\nYour phone displays an 8-Game Puzzle");
			    int i3 = 0;
			    while (i3 != 1){
				int c3 = this.AskUser("\n[1]I want to play!, [2]No thanks");
				if (c3 == 1){
				    eightGame.generateGame(3);
				    System.out.println(eightGame);
				}
				else if (c3 == 2){i3 = 1;}
				else{System.out.println("\nPlease enter the number of your choice");}
			    }
			}
			else if (c2 == 2){System.out.println("\nEw, these are a few years old. Maybe you should leave them.");}
			else if (c2 == 3){i2 = 1;}
			else {System.out.println("\nPlease enter the number of your choice");}
		    }
		}
		else if (c == 2){
		    System.out.println("\nYou find the evil math test that has landed you in this mess!");
		}
		else if (c == 3){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if (thing.equals(room.get(3))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Flip rug\n[2]Nah");
		if (c == 1){
		    System.out.println("How disappointing. There's nothing there.");
		}
		else if (c == 2){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if (thing.equals(room.get(4))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Rummage through trash can\n[2]How unsanitary!");
		if (c == 1){
		    if (room.get(4).getStatus() == false){
		    System.out.println("You found a rotten fig");
		    room.get(4).changeStatus();
		    }
		    else {
			System.out.println("There's only trash");
		    }
		}
		else if (c == 2){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if (thing.equals(room.get(5))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Look at books\n[2]Now's not the time!");
		if (c == 1){
		    int book = this.AskUser("\nWhich book do you want?\n[1]The Count of Monte Cristo\n[2]Physics Regents Textbook\n[3]300 Most Difficult SAT Words\n[4]Hamlet\n[5]For the Love of Physics\n[6]The Charm of Quarks: Understanding Subatomic Particles\n[7]Romeo and Juliet\n[8]How to Win this Game\n[9]The Cake is a Lie");
	 
		}
		else if (c == 2){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if(thing.equals(room.get(6))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Inspect Poster\n[2]Leave it.");
		if (c == 1){
		    System.out.println("There's a safe behind the poster!");
		}
		else if (c == 2){
		    i = 1;
		}     
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if(thing.equals(room.get(7))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Slide open left door\n[2]Slide open right door\n[3]Move on"); 
		if (c == 1){
		    System.out.println("\nYour clothes hang neatly in the closet, with a few storage boxes below it and a pile of books. A silver tin box sits on top of the pile");
		    int i2 = 0;
		    while (i2 != 1){
			int c2 = new Game().AskUser("\n[1]Check the pockets of your hoodies, [2]Open storage boxes, [3]Flip through books, [4]Open tin box, [5]Move on");
			if (c2 == 1){System.out.println("\nYou find a marble and a pack of tissues");}
			else if (c2 == 2){System.out.println("\nNothing interesting. Just some old clothes you plan to donate");}
			else if (c2 == 3){System.out.println("\nYou find an index card with four colored dots: Red, Blue, Green, and Purple");}
			else if (c2 == 4){System.out.println("\nYou find a screwdriver and some paper clips");}
			else if (c2 == 5){i2 = 1;}
			else{System.out.println("\nPlease enter the number of your choice");}
		    }
		}
		else if (c == 2){
		    System.out.println("The door is stuck.");
		}
		else if (c == 3){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if(thing.equals(room.get(8))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Open door\n[2]Don't need the toilet right now\n");
		if (c == 1){

		}
		else if (c == 2){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
	}
	if(thing.equals(room.get(9))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Check vent\n[2]Who cares?\n");
		if (c == 1){
		    System.out.println(room.get(14).getDescript());
		    if (room.get(14).getStatus() == false){
			if (inventory.getInventory().contains(closet.get(0))){
			    System.out.println("\nYou used the Phillips screwdriver to unscrew the cover.\nYou find a key and an apple inside\n");
			    room.get(14).changeDescript("\nThe vent cover has been removed. There is only darkness within.\n");
			    room.get(14).changeStatus();
			}	        
		    }
		}
		else if (c == 2){
		    i = 1;
		}
		else{
		    System.out.println("\nPlease enter the number of your choice");
		}
	    }
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
