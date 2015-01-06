public class Item{
    private final String name;
    private String description;
    private boolean used = false;
    private final boolean takeable;
    private String compatible;
    private boolean changeable;
    private String newform;

    public Item(String n, String descript, boolean a){
	name = n;
	description = descript;
	takeable = a;
	compatible = "None";
	newform = "None";

    }

    public String getName(){
	return name;
    }

    public String toString(){
	return getName(); 
    }

    public String getDescript(){
	return description;
    }

    public String getCompat(){
	return compatible;
    }

    public void setCompat(String compat){
	compatible = compat;
    }

    public String getNewForm(){
	return newform;
    }

    public void setNewForm(String n){
	newform = n;
    }

    public boolean getChangeable(){
	return changeable;
    }

    public void setChangeable(boolean b){
	changeable = b;
    }
    
    public void changeDescript(String s){
	description = s;
    }

    public boolean getStatus(){
	return used;
    }

    public boolean canGet(){
	return takeable;
    }

    public void changeStatus(){
	used = true;
    }


}
