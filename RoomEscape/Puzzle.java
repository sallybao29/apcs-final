import java.util.Scanner;

public class Puzzle extends Item{
    private final String answer;
    private final String smessage;
    private boolean solved;
   

    public Puzzle(String name, String descript, String ans, String s){
	super (name, descript, false);
	answer = ans;
	smessage = s;
    }

    public String getAnswer(){
	return answer;
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

    /*-------------------------------- Test --------------------------------*/

    public static void main(String[] args){
	Puzzle p = new Puzzle("Riddle", "Forwards I am heavy, backwards, I am not.", "ton", "Congratulations, you have solved the riddle");
	Scanner sc = new Scanner(System.in);
	System.out.println(p.getDescript());
	System.out.println("What is your answer?");
	String ans = sc.nextLine();
	System.out.println(p.check(ans));
    }

}
