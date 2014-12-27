import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    private boolean gameWon;
    private ArrayList<Item> room = new ArrayList<Item>();
    private ArrayList<Item> closet = new ArrayList<Item>();
    private ArrayList<Item> bathroom = new ArrayList<Item>();

    public Game(){
	gameWon = false;
	room.add(new Item("Bed", "Your bed. There's a blanket and a pillow and not much else.", false));
	room.add(new Item("Desk", "A relatively clean desk with a laptop and a pencil holder on it. It has two drawers.", false));
	room.add(new Item("Bag", "A bag filled to the brim with notes and school supplies. There is a small pocket on the front and a waterbottle holder on the side.", false));
	room.add(new Item("Trash can", "Something stinks. You haven't taken the trash out for a while.", false));
	room.add(new Item("Rug", "A hideous Pikachu rug you bought when you were ten. Maybe there's something under it?", false));
	room.add(new Item("Bookshelf", "It's full of test prep books and encyclopedias. Looks like your parents threw out all your manga.", false));
	room.add(new Item("Poster", "A poster of the periodic table of elements.",false));
	room.add(new Item("Closet", "A closet with sliding doors", false));
	room.add(new Item("Bathroom door", "The door to the bathroom", false));
	room.add(new Item("Letter", "Son, we saw your last math test score.\nYou have brought shame to your family.\nBut it's alright, everyone makes mistakes.\nA great man once said, \"A man must be bIg enough to admit his miStakes, smart enough to profIt from them, and strong enough to Correct them.\" So just stay in your room and reflect on your actions for another two days.\nBy then, you will surely have been able to realize the error of your ways and find the solution to your demise.\nSincerely, Your Parents", true));
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
	//Scanner sc = new Scanner(System.in);
	//String input = sc.nextLine();
        //int choice = Integer.parseInt(input);
	int c;
	int i = 0;
	
	if (thing.equals(room.get(0))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Check under the blankets\n[2]Check pillow\n[3]Already saw the bed");
		if (c == 1){

		}
		else if (c == 2){

		}
		else if (c == 3){
		    i = 1;
		}
	    }
	}
	if (thing.equals(room.get(1))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Check laptop\n[2]Check pencil holder\n[3]Check drawer\n[4]Nope"); 
		if (c == 1){}
		else if (c == 2){}
		else if (c == 3){}
		else if (c == 4){
		    i = 1;
		}
	    }
	}
	if (thing.equals(room.get(2))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Open small pocket\n[2]Look through notes\n[3]Move on");
		if (c == 1){
		    System.out.println("\nYou find your student metrocard, your student ID, and a few tictacs");
		}
		else if (c == 2){
		    System.out.println("\nYou find the evil math test that has landed you in this mess");
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
		if (c == 1){}
		else if (c == 2){
		    i = 1;
		}
	    }
	}
	if (thing.equals(room.get(4))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Rummage through trash can\n[2]How unsanitary!");
		if (c == 1){}
		else if (c == 2){
		    i = 1;
		}
	    }
	}
	if (thing.equals(room.get(5))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Look at books\n[2]Now's not the time!");
		if (c == 1){}
		else if (c == 2){
		    i = 1;
		}
	    }
	}
	if(thing.equals(room.get(6))){
	    i = 0;
	    while (i != 1){
		c = new Game().AskUser("\n[1]Inspect Poster\n[2]Take poster\n[3]Leave it. It looks nice there");
		if (c == 1){}
		else if (c == 2){
		    
		}
		else if (c == 3){
		    i = 1;
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
	    c = new Game().AskUser("\n[1]Open door\n[2]Don't need the toilet right now");
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
