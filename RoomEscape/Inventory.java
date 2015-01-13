import java.util.ArrayList;

public class Inventory{
    private static ArrayList<Item> inventory = new ArrayList<Item>();

    //if item is takeable, add to inventory
    //otherwise print discouraging message
    public void take(Item a){
	if (a.canGet() == true){
	    inventory.add(a);
	    System.out.println("<< Added " + a + " to your inventory >>");
	}
	else {
	    System.out.println("<< What the devil would you do with a " + a + "? Leave it >>");
	}
    }

    public ArrayList<Item> get(){
	return inventory;
    }

    //retrieves item from inventory when only name is known
    public Item find(String name){
	for (int i = 0;i < inventory.size();i++){
	    if (name.equals(inventory.get(i).getName())){
		return inventory.get(i);
	    }
	}
	return null;
    }

    //checks for compatibility between two items
    //if compatible, changes description and name of items,
    //showing they have interacted with each other
    public void combine(Item a, Item b){
	String name;
	String aname = a.getName(),
	    bname = b.getName();
	if (a.getCompat().equals(b.getName())){
	    if (!a.getNewForm().equals("None")){
	        a.setName(a.getNewForm());
		a.changeDescript(a.getNDescript());
		name = a.getNewForm();
	    }
	    else {
	        b.setName(b.getNewForm());
		b.changeDescript(b.getNDescript());
		name = b.getNewForm();
	    }
	    System.out.println("Created " + name + " from " + aname + " and " + bname);
	}
	else {
	    System.out.println("Why would you combine " + aname + " and " + bname + "?");
	}
    }


    public String toString(){
	String s = "";
	for (int i = 0;i < inventory.size();i++){
	    s += "[" + i + "]";
	    s += inventory.get(i);
	    s += "\n";
	}
	return s;

    }
}
