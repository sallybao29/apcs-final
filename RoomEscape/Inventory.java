import java.util.Scanner;
import java.util.ArrayList;

public class Inventory{
    private static ArrayList<Item> inventory = new ArrayList<Item>();

    public void take(Item a){
	if (a.canGet() == true){
	    inventory.add(a);
	    System.out.println("<< Added " + a + " to your inventory >>");
	}
	else {
	    System.out.println("<< What the devil would you do with a " + a + "? Leave it >>");
	}
    }

    public ArrayList<Item> getInventory(){
	return inventory;
    }

    public Item find(String name){
	for (int i = 0;i < inventory.size();i++){
	    if (name.equals(inventory.get(i).getName())){
		return inventory.get(i);
	    }
	}
	return null;
    }

<<<<<<< HEAD
    public void combine(Item a, Item b){
=======
    /*
    public String combine(Item a, Item b){
>>>>>>> ba821f6f9b013d3cffd8da25192b53c951a2f4a5
	if (a.getCompat().equals(b.getName())){
	    System.out.println("Created " + a.getNewForm() + " from " + a " and " + b);
	}
	else {
	    System.out.println("Are you crazy? What could you make from " + a " and " + b + "?!");
	}
    }
    */

    public String list(){
	String s = "";
	for (int i = 0;i < inventory.size();i++){
	    s += "[" + i + "]";
	    s += inventory.get(i);
	    if (inventory.get(i).getStatus() == true){
		s += " - used";
	    }
	    s += "\n";
	}
	return s;

    }
}
