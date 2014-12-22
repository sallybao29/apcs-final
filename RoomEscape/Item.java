public class Item{
    private final String name;
    private String description;
    private boolean used;

    public Item(String n, String descript){
	name = n;
	description = descript;
	used = false;
    }

    public String getName(){
	return name;
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

    public void setStatus(){
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
