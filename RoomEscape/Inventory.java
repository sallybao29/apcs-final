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

    public void combine(Item a, Item b){
	String name;
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
	    System.out.println("Created " + name + " from " + a + " and " + b);
	}
	else {
	    System.out.println("Why would you combine " + a + " and " + b + "?");
	}
    }


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
