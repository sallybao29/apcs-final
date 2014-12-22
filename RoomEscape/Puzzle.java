public class Puzzle extends Item{
    private final String answer;
    private final String smessage;
    private boolean solved;
   

    public Puzzle(String name, String descript, String ans, String s){
	super (name, descript);
	answer = ans;
	smessage = s;
    }

    public String check(String attempt){
	if (attempt.compareTo(answer) == 0){
	    solved = true;	    
	    return smessage;
	}
	else {
	    return "Son, you have failed. Try again.";
	}
    }

    public static void main(String[] args){
    
    }


}
