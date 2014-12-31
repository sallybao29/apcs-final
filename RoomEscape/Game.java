import java.util.*;

public class Game{
    private int stage;
    private boolean gameWon;
    private ArrayList<Item> room = new ArrayList<Item>();
    private ArrayList<Item> closet = new ArrayList<Item>();
    private ArrayList<Item> bathroom = new ArrayList<Item>();
    private ArrayList<String> bookshelf = new ArrayList<String>(Arrays.asList("The Count of Monte Cristo", "Physics Regents Textbook", "300 Most Difficult SAT Words", "Hamlet", "For the Love of Physics", "The Charm of Quarks", "Romeo and Juliet", "How to Beat this Game", "The Cake is a Lie", "Philosophiæ Naturalis Principia Mathematica", "Chickens"));
    private Item[] compartment = new Item[4];
    Inventory inventory = new Inventory();
    EightGamePuzzle eightGame;

    public Game(){
	gameWon = false;
	stage = 1;
	room.add(new Item("Bed", "Your bed. There's a blanket and a pillow and not much else.", false));        //0
	room.add(new Item("Desk", "A relatively clean desk with a laptop and a pencil holder on it. It has two drawers.", false));   //1
	room.add(new Item("Bag", "A bag filled to the brim with notes and school supplies. There is a small pocket on the front and a waterbottle holder on the side.", false));   //2
	room.add(new Item("Rug", "A hideous Pikachu rug you bought when you were ten. Maybe there's something under it?", false));  //3
	room.add(new Item("Trash can", "Something stinks. You haven't taken the trash out for a while.", false));  //4
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
	room.add(new Item("Phone", "Oh look, your phone. Its screen displays an 8-game puzzle", true));  //20
	room.add(new Item("Apple", "A shiny red Fuji apple", true));  //21
	room.add(new Puzzle("Safe", "The safe where you stash your loot. There is a keypad.\nIt seems the password is three characters long.", "666", "The door swings open.\nAnd people said the stuff they did on detective movies was fake."));  //22
	room.add(new Item("Note1", "A description is pending", true));   //23
	room.add(new Item("Note2", "Note", true)); //24
	room.add(new Item("Note3", "Note", true)); //25
	room.add(new Item("Note4", "Note", true)); //26
	room.add(new Item("Note5", "Note", true)); //27
	room.add(new Item("Acid", "A nice bottle of 100% Hydrochloric Acid", true));  //28
	room.add(new Item("Blue Index Card", "A blue index card with the number 8", true)); //29
	room.add(new Item("Scissors", "A pair of scissors", true)); // 30
	room.add(new Item("Philosophiæ Naturalis Principia Mathematica", "A cool book", true)); //31
  

	room.add(new Puzzle("Door1", "", "1238359", ""));  //32
	room.add(new Puzzle("Door2", "", "6890", ""));  //33
	room.add(new Puzzle("Door3", "", "Newton", ""));  //34
	room.add(new Puzzle("Door4", "", "", ""));  //35
	room.add(new Puzzle("Door5", "", "", ""));  //36
  

	closet.add(new Item("Screwdriver", "A Phillips screwdriver. This might come in handy", true));  //0
	closet.add(new Item("Paperclips", "Some colorful paperclips. You know what they are!", true));  //1
	closet.add(new Item("Tin Box", "A silver tin box used for storing cookies", false));            //2
	closet.add(new Item("Hoodie", "A spiffy hoodie", false));   //3
	closet.add(new Item("Marble", "A dirty marble caked in grease", true));  //4
	closet.add(new Item("Tissues", "A pack of tissues like the kind you get from Chinese vendors", true));  //5
	closet.add(new Item("Index card", "An index card with four colored dots: Red, Blue, Green, Purple", true)); //6
	closet.add(new Item("Books", "Some old books", false)); //7
	
	
	bathroom.add(new Item("Metal box", "A tiny metal box. Hm... It looks like you'll have to pick the lock.", false)); //0
	bathroom.add(new Item("Forceps", "Just some forceps", true)); //1
	bathroom.add(new Item("Green Index Card", "A green index card with the number 9", true)); //2
	bathroom.add(new Item("Purple Index Card", "A purple index card with the number 0", true)); //3
	bathroom.add(new Item("Bathroom rug", "There is definitely not something under this rug", false)); //4
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

    public void checkDoor(){
	int i = 0;
	String ans;
	while (i != 1 && stage < 6){
	    System.out.println(room.get(stage + 31).getDescript()); 
	    int c = this.AskUser("\nTry to solve the puzzle?\n[1]Yes\n[2]No\n");
	    if (c == 1){
		if (((Puzzle)room.get(stage + 31)).getSolved() == false){
		    ans = "" + this.AskUser("\nKey-in the passcode: ");
		    System.out.println(((Puzzle)room.get(stage + 31)).check(ans, ""));
		}
		if (((Puzzle)room.get(stage + 31)).getSolved() == true){
		    System.out.println("\nThe door opens. Alas, there is another door behind it\n");
		    stage++;
		    System.out.println(room.get(stage + 31).getDescript());       
		}
	    }
	    else if (c == 2){
		i = 1;
	    }
	    else {
		System.out.println("\nPlease enter the number of your choice");
	    }
	}
    }
    
        

    public void interact(Item thing){
	int c;
	int i;
	
	if (thing.equals(room.get(0))){
	    i = 0;
	    while (i != 1){
		c = this.AskUser("\n[1]Check under the blankets\n[2]Check pillow\n[3]Already saw the bed\n");
		if (c == 1){
		    System.out.println("\nThere's nothing there\n");
		}
		else if (c == 2){
		    System.out.println(room.get(15).getDescript());
		    if (room.get(15).getStatus() == false){
			System.out.println("You took the note");
			inventory.take(room.get(23));
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
		c = this.AskUser("\n[1]Check laptop\n[2]Check pencil holder\n[3]Check drawer\n[4]Nope\n"); 
		if (c == 1){
		    System.out.println(room.get(11).getDescript()); 
		    if (((Puzzle)room.get(11)).getSolved() == false){
			String ans = "" + this.AskUser("\nEnter Password: ");
			System.out.println(((Puzzle)room.get(11)).check(ans, "An emacs file is open. There is a piece of code on it:\n\nRandom r = new Random();\ndouble stress = r.nextDouble();\nboolean codeWorks = (r.nextInt(2) == 1);\npublic void writeCode()\n\tif (codeWorks){\n\t\tSystem.out.println(\"I am a GOD\");\n\t}\n\telse{\n\t\tif (stress > 0.7){\n\t\t\tsystem.out.println(\"RAGE QUIT\")\n\t\t\tSystem.exit(0);\n\t\t}\n\t\tcry();\n\t}\n}\n\nWhat could it mean?"));	       
			System.out.println(room.get(11).getDescript());
		    }
		}
		else if (c == 2){
		    System.out.println(room.get(12).getDescript());
		    if (room.get(12).getStatus() == false){
			System.out.println("\nYou took a pencil");
			inventory.take(room.get(16));
			room.get(16).changeStatus();
			room.get(12).changeStatus();
		    }
		}
		else if (c == 3){
		    System.out.println(room.get(13).getDescript());
		    if (room.get(13).getStatus() == false){
			if (inventory.getInventory().contains(room.get(17))){
			    System.out.println("\nYou unlocked the desk drawer with the key you found.\nIt slides open to reveal some goodies");
			    System.out.println("\nYou find a Blue index card with the number 8 on it.");
			    inventory.take(room.get(29));
			    room.get(13).changeDescript("Look at all the nice stuff you have in here.");
			    room.get(13).changeStatus();
			    room.get(17).changeStatus();
			} 	   
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
		c = this.AskUser("\n[1]Open small pocket\n[2]Look through notes\n[3]Move on\n");
		int i2;
		int c2;
		if (c == 1){
		    if (room.get(20).getStatus() == false){
			System.out.println("\nYou find your student metrocard, your student ID, your phone, and a few TicTacs");
			i2 = 0;
			while (i2 != 1){
			    c2 = this.AskUser("\n[1]Inspect phone, [2]Take the Tictacs, [3]Eh, I'll move on\n");
			    if (c2 == 1){
				System.out.println("\nYour phone displays an 8-Game Puzzle");
				int i3 = 0;
				while (i3 != 1){
				    int c3 = this.AskUser("\n[1]I want to play!\n[2]No thanks\n");
				    if (c3 == 1 && room.get(20).getStatus() == false){
					System.out.println("\nEver played the 8-Game Puzzle? Well either way, here are the directions: \n   Your goal is to get the numbers to be in order from 0 to 9 \n   (with 0-2 in the first row, 3-5 in the second, and 6-8 in the third) \n   by moving the zero in any of the four directions \n   (left, up, right, down). Let's go! :)");
					eightGame = new EightGamePuzzle();
					eightGame.generateGame(5);
					boolean solved = eightGame.userSteps();
					if (solved == true){
					    System.out.println("\n\n You see a Red 6.");
					    room.get(20).changeStatus();
					    room.get(20).changeDescript("\nA phone displaying a Red 6");
					    inventory.take(room.get(20));
					    i2 = 1;
					    i3 = 1;
					}
					else if(solved == false){
					    System.out.println("\n\n Maybe next time.");
					}
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
		    else if (room.get(20).getStatus() == true){
			System.out.println("\nYou find your student metrocard, your student ID, and a few TicTacs");
		    }
		}
		else if (c == 2){
		    System.out.println("\nLooking at these grades is depressing.");
		    if (room.get(19).getStatus() == false){
			System.out.println("\nYou find the evil math test that has landed you in this mess!");
			inventory.take(room.get(19));
			room.get(19).changeStatus();
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
	if (thing.equals(room.get(3))){
	    i = 0;
	    while (i != 1){
		c = this.AskUser("\n[1]Flip rug\n[2]Nah\n");
		if (c == 1){
		    if (room.get(3).getStatus() == false){
			System.out.println("\nYou find a pair of scissors.");
			inventory.take(room.get(30));
			room.get(3).changeStatus();
			room.get(3).changeDescript("An ugly Pikachu rug.");
		    }
		    else {
			System.out.println("How disappoinging. There's nothing under it");
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
	if (thing.equals(room.get(4))){
	    i = 0;
	    while (i != 1){
		c = this.AskUser("\n[1]Rummage through trash can\n[2]How unsanitary!\n");
		if (c == 1){
		    if (room.get(4).getStatus() == false){
		    System.out.println("\nYou found a rotten fig");
		    inventory.take(room.get(18));
		    room.get(4).changeStatus();
		    }
		    else {
			System.out.println("\nThere's only trash");
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
	    String booklist = "";
	    for (int a = 0;a < bookshelf.size();a++){
		booklist += "[" + (a + 1) + "]";
		booklist += bookshelf.get(a);
		booklist += "\n";
	    }
		c = this.AskUser("\n[1]Look at books\n[2]Now's not the time!\n");
		if (c == 1){
		    int book = this.AskUser(booklist);
		    if (book == 10){
			System.out.println("\nAh, a classic. Good choice");
			inventory.take(room.get(31));
			bookshelf.remove(9);
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
	if(thing.equals(room.get(6))){
	    i = 0;
	    while (i != 1){
		c = this.AskUser("\n[1]Inspect poster\n[2]Flip poster\n[3]Leave it\n");
		if (c == 1){
		    System.out.println("Something");
		}
		else if (c == 2){      
		    System.out.println("\nThere's a safe behind the poster!");
		    System.out.println(room.get(22).getDescript());
		    if (((Puzzle)room.get(22)).getSolved() == false){
			if (inventory.getInventory().contains(room.get(16)) && inventory.getInventory().contains(room.get(30))){
			    System.out.println("\nYou use the scissors to shave the pencil.\nThen, you blow the graphite shavings onto the keypad.\nThe fingerprints on the six key become visible");
			}
			else {
			    System.out.println("\nIf only there were a way to see what had been previously typed...");
			}
		        String ans  = "" + this.AskUser("\nEnter password: ");
			System.out.println(((Puzzle)room.get(22)).check(ans, "The safe where you stash your loot"));
		    }
		    if (((Puzzle)room.get(22)).getSolved() == true && room.get(22).getStatus() == false){
			System.out.println("You find a bottle of acid in the safe");
			inventory.take(room.get(28));
			room.get(28).changeStatus();
			room.get(22).changeStatus();
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
	if(thing.equals(room.get(7))){
	    i = 0;
	    while (i != 1){
		c = this.AskUser("\n[1]Slide open left door\n[2]Slide open right door\n[3]Move on\n"); 
		if (c == 1){
		    if (room.get(28).getStatus() == false){
			System.out.println("\nThe door is stuck. It's been a while since you last greased it.\n");
			if (inventory.getInventory().contains(room.get(28))){
			    System.out.println("\nYou use the acid to melt the hinge\n");
			    room.get(28).changeStatus();
			    room.get(7).changeDescript("A closet with sliding doors. There is a gaping hole on the left door and the burning smell of acid");
			}
		    }
		    else {
			System.out.println("\nYour clothes hang neatly in the closet, with a few storage boxes below it and a pile of books. A silver tin box sits on top of the pile");
			int i2 = 0;
			while (i2 != 1){
			    int c2 = this.AskUser("\n[1]Check the pockets of your hoodie\n[2]Open storage boxes\n[3]Flip through books\n[4]Open tin box\n[5]Move on\n");
			    if (c2 == 1){
				System.out.println(closet.get(3).getDescript());
				if (closet.get(3).getStatus() == false){
				    System.out.println("\nYou find a marble and a pack of tissues");
				    inventory.take(closet.get(4));
				    inventory.take(closet.get(5));
				    closet.get(3).changeStatus();
				    closet.get(3).changeDescript("A spiffy hoody. You have already taken everything in the pockets.");
				}
			    }
			    else if (c2 == 2){System.out.println("\nNothing interesting. Just some old clothes you plan to donate");}
			    else if (c2 == 3){
				System.out.println(closet.get(7).getDescript());
				if (closet.get(7).getStatus() == false){
				    System.out.println("\nYou find an index card with four colored dots: Red, Blue, Green, and Purple");
				    inventory.take(closet.get(6));
				    closet.get(7).changeStatus();
				    closet.get(7).changeDescript("Some old books. That's all");
				}
			    }
			    else if (c2 == 4){
				System.out.println(closet.get(2).getDescript());
				if (closet.get(2).getStatus() == false){
				    System.out.println("\nYou find a screwdriver and some paper clips");
				    inventory.take(closet.get(0));
				    inventory.take(closet.get(1));
				    closet.get(2).changeStatus();
				}
			    }
			    else if (c2 == 5){i2 = 1;}
			    else{System.out.println("\nPlease enter the number of your choice");}
			}
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
		c = this.AskUser("\n[1]Open door\n[2]Don't need the toilet right now\n");
		if (c == 1){
		    System.out.println("\nYou have entered the bathroom. There is a medicine cabinet above the sink and a rug at your feet.");
		    int i2 = 0;
		    while (i2 != 1){
			int c2 = this.AskUser("\n[1]Open medicine cabinet doors\n[2]Turn on faucet\n[3]Lift rug\n[4]Leave bathroom");
			if (c2 == 1){
			    System.out.println("You see a little metal box, a bunch of toothpaste, and various medicine");
			    int i3 = 0;
			    while (i3 != 1){
				int c3 = this.AskUser("\n[1]Open metal box\n[2]Close medicine cabinet door");
				if (c3 == 1){
				    if (bathroom.get(0).getStatus() == false){
					System.out.println(bathroom.get(0).getDescript());
					if (inventory.getInventory().contains(closet.get(1))){
					    System.out.println("\nYou have unlocked the box using the paperclips! You find forceps and a Green index card with the number 9");
					    inventory.take(bathroom.get(1));
					    inventory.take(bathroom.get(2));
					    bathroom.get(0).changeDescript("\nYou've already unlocked the box and taken the items. There is nothing left inside");
					    bathroom.get(0).changeStatus();
					}
				    }
				}
				else if (c3 == 2){
				    i3 = 1;
				}
			    }
			}
			else if (c2 == 2){
			    System.out.println("\nThe water is running.");
			    if (inventory.getInventory().contains(closet.get(4)) && inventory.find("Marble").getStatus() == false){
				System.out.println("\nYou washed off the dirt on the marble. There are letters scrawled across it.");
				inventory.find("Marble").changeStatus();
				inventory.find("Marble").changeDescript("A lustrous marble. The word Python is written on it.");
			    }
			}
			else if (c2 == 3){
			    System.out.println(bathroom.get(4).getDescript());
			    if (bathroom.get(4).getStatus() == false){
				System.out.println("\nYou flip the rug and find a Purple index card with the number 0.\n");
				inventory.take(bathroom.get(3));
				bathroom.get(4).changeStatus();
				bathroom.get(4).changeDescript("\nA fuzzy bathroom rug. There is nothing under it\n");
			    }
			}
			else if (c2 == 4){
			    System.out.println("\nYou are back in your room");
			    i2 = 1;
			}
			else{
			    System.out.println("\nPlease enter the number of your choice");
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
	if(thing.equals(room.get(9))){
	    i = 0;
	    while (i != 1){
		c = this.AskUser("\n[1]Check vent\n[2]Who cares?\n");
		if (c == 1){
		    System.out.println(room.get(14).getDescript());
		    if (room.get(14).getStatus() == false){
			if (inventory.getInventory().contains(closet.get(0))){
			    System.out.println("\nYou used the Phillips screwdriver to unscrew the cover.\nYou find a key and an apple inside\n");
			    inventory.take(room.get(17));
			    inventory.take(room.get(21));
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
