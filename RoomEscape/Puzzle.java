import java.util.Scanner;

public class Puzzle extends Item{
    private final String answer;
    private final String smessage;
    private boolean solved = false;
   

    public Puzzle(String name, String descript, String ans, String s){
	super (name, descript, false);
	answer = ans;
	smessage = s;
    }

    public String getAnswer(){
	return answer;
    }

    public boolean getSolved(){
	return solved;
    }

    public String check(String attempt, String newDescript){
	if (attempt.compareTo(answer) == 0){
	    solved = true;
	    this.changeDescript(newDescript);	    
	    return smessage;
	}
	else {
	    return "Son, you have failed. Try again.";
	}
    }
}
