public class Driver{
    public static void main(String[] args){
	Game g = new Game();
	for (int i = 0;i < g.getRoom().size();i++){
	    System.out.println(g.getRoom().get(i));
	}
    }
}
