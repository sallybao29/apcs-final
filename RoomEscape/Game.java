import java.util.ArrayList;

public class Game{
    private boolean gameWon;
    private ArrayList<Item> room = new ArrayList<Item>();

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
	if (thing.equals(room.get(0))){
	    System.out.println("1)Check under the blankets\n2)Check pillow");
	}
	if (thing.equals(room.get(1))){
	    System.out.println("1)Check laptop\n2)Check pencil holder\n3)Check drawer"); 
	}
	if (thing.equals(room.get(2))){
	    System.out.println("1)Open bag\n2)Move on");
	}
	if (thing.equals(room.get(3))){
	    System.out.println("1)Flip rug\n2)Nah");
	}
	if (thing.equals(room.get(4))){
	    System.out.println("1)Rummage through trash can\n2)How uncivilized!");
	}
	if (thing.equals(room.get(5))){
	    System.out.println("1)Look at books\n2)Now's not the time!");
	}
	if(thing.equals(room.get(6))){
	    System.out.println("1)Take poster\n2)Leave it. It looks nice there");
	}
	if(thing.equals(room.get(7))){
	    System.out.println("1)Slide open left door\n2)Slide open right door"); 
	}
	if(thing.equals(room.get(8))){
	    System.out.println("1)Open door\n2)Inspect door");
	}
    }
}
