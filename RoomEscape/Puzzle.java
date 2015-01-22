public class Puzzle extends Item{
    private final String answer, smessage;
    private boolean solved;
   

    public Puzzle(String name, String descript, String ans, String s){
	super (name, descript, false);
	answer = ans;
	smessage = s;
	solved = false;
    }

    public boolean getSolved(){
	return solved;
    }

    //if player enters correct answer or "skip", puzzle will be solved
    //if player skips, dire repercussions will be in store
    public int check(String attempt){
	if (attempt.equals(answer) || attempt.equals("skip")){
	    solved = true;
	    if (!this.getNDescript().equals("None")){
		this.changeDescript(this.getNDescript());
	    }
	    System.out.println(smessage);
	    if (attempt.equals("skip")){
		return 2;
	    }
	    return 1;
	}
	else {
	    System.out.println("Son, you have failed. Try again.");
	    return 3;
	}
    }
}
