import java.util.Scanner;

public class Puzzle extends Item{
    private final String answer;
    private final String smessage;
    private boolean solved;
   

    public Puzzle(String name, String descript, String ans, String s){
	super (name, descript, false);
	answer = ans;
	smessage = s;
	solved = false;
    }

    public String getAnswer(){
	return answer;
    }

    public boolean getSolved(){
	return solved;
    }

    public boolean check(String attempt, String newDescript){
	if (attempt.equals(answer)){
	    solved = true;
	    this.changeDescript(newDescript);	    
	    System.out.println(smessage);
	}
	else {
	    System.out.println("Son, you have failed. Try again.");
	}
	return solved;
    }
}
