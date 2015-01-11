public class Item{
    private String name, description, compatible, newform, newDescript;
    private boolean used;
    private final boolean takeable;


    public Item(String n, String descript, String nd, boolean a){
	name = n;
	description = descript;
	takeable = a;
	newDescript = nd;
	used = false;
	compatible = "None";
	newform = "None";
    }

    public Item(String n, String descript, boolean a){
	this(n, descript, "None", a);
    }

    public String getName(){
	return name;
    }

    public void setName(String n){
	name = n;
    }

    public String toString(){
	return getName(); 
    }

    public String getDescript(){
	return description;
    }

    public void changeDescript(String s){
	description = s;
    }

    public String getNDescript(){
	return newDescript;
    }

    public void setNDescript(String s){
	newDescript = s;
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

    public boolean getStatus(){
	return used;
    }

    public boolean canGet(){
	return takeable;
    }

    public void changeStatus(){
	used = true;
    }

    public boolean toUse(Item other, String message){
	if (other == null){
	    return false;
	}
	if (this.compatible.equals(other.name)){
	    System.out.println(message);
	    if (!this.newDescript.equals("None")){
		this.description = this.newDescript;
	    }
	    this.used = true;
	    other.used = true;
	}
	return this.used;
    }


}
