import java.util.Scanner;
import java.util.ArrayList;

public class Inventory{
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public void take(Item a){
	if (a.canGet() == true){
	    inventory.add(a);
	    System.out.println("You put the " + a + " away.");
	}
	else {
	    System.out.println("What the devil would you do with a " + a + "? Leave it.");
	}
    }

    public ArrayList<Item> getInventory(){
	return inventory;
    }
    

    public String list(){
	String s = "";
	for (int i = 0;i < inventory.size();i++){
	    s += "[" + i + "]";
	    s += inventory.get(i);
	    s += "\n";
	}
	return s;
    }

    /*--------------------------------- TEST ----------------------------*/

    public static void main(String[] args){
	Inventory bob = new Inventory();
	Item a = new Item("Potato", "A potato", false);
	Item b = new Item("Physics Regents Textbook", "A Physics Regents Textbook", true);

	System.out.println("You found " + b + ".");
	System.out.println("What do you want to do with it?\n1)Take it\n2)Leave it");
	Scanner sc = new Scanner(System.in);
	String choice = sc.nextLine();
	if (choice.equals("1")){
	    bob.take(b);
	}
	else{
	    System.out.println("You left it.");
	}

	System.out.println(bob.list());
   
    }
}
