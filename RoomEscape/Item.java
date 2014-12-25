public class Item{
    private final String name;
    private String description;
    private boolean used = false;
    private boolean usable;

    public Item(String n, String descript, boolean a){
	name = n;
	description = descript;
	usable = a;
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

    public void changeDescript(String s){
	description = s;
    }

    public boolean getStatus(){
	return used;
    }

    public boolean canGet(){
	return usable;
    }

    public void changeStatus(){
	used = true;
    }

    /* public static void main(String[] args){
	Item book = new Item("Physics Regents Textbook", "A Physics Regents textbook. The cover is ripped off. Look! There's a note on page 120. Want to check it out?");
	System.out.println(book.getName());
	System.out.println(book.getDescript());
	System.out.println(book.getStatus());
    }
    */
}
