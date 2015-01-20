import java.util.*;

public class Game{
    private int stage;
    private boolean gameWon;
    Inventory inventory = new Inventory();
    EightGamePuzzle eightGame;
    private ArrayList<Item> room = new ArrayList<Item>();
    private ArrayList<Item> closet = new ArrayList<Item>();
    private ArrayList<Item> bathroom = new ArrayList<Item>();
    private ArrayList<Item> bookshelf = new ArrayList<Item>();
    private ArrayList<Item> compartment = new ArrayList<Item>();
    private ArrayList<String> answer = new ArrayList<String>(Arrays.asList("Apple", "Forceps", "Fig", "Philosophiae Naturalis Principia Mathematica"));
    private String msg = "\nPlease enter a valid choice", qsg = "Type 'return' to exit current option", ssg = "Type 'skip' to bypass a puzzle";
    private String equip = "None";
    private int grade = 100, sgrade = -10, fgrade = -1;

    public Game(){   ///Setting up every single item in the room, labeled for convenience
	gameWon = false;
	stage = 1;
	
	/*------------------------------ The Main Room Stuff -----------------------------------------*/
	
	room.add(new Item("Bed", "Your bed. There's a blanket and a pillow and not much else.", false));        //0
	room.add(new Item("Desk", "A relatively clean desk with a laptop and a pencil holder on it. It has two drawers.", false));   //1
	room.add(new Item("Bag", "A bag filled to the brim with notes and school supplies. There is a small pocket on the front and a waterbottle holder on the side.", false));   //2
	room.add(new Item("Rug", "A hideous Pikachu rug you bought when you were ten. Maybe there's something under it?", false));  //3
	room.add(new Item("Trash can", "Something stinks. You haven't taken the trash out for a while.", false));  //4
	room.add(new Item("Bookshelf", "It's full of test prep books and encyclopedias.", false));  //5
	room.add(new Item("Poster", "A poster of the periodic table of elements.",false));   //6
	room.add(new Item("Closet", "A closet with sliding doors", "A closet with sliding doors. There is a gaping hole on the left door and the burning smell of acid.", false));   //7
	room.add(new Item("Bathroom door", "The door to the bathroom", false));  //8
	room.add(new Item("Ceiling", "There's a vent on the ceiling. Even in the dark, something glistens.", false));  //9


	room.add(new Item("Letter", "\n\nSon, we saw your last math test score.\nYou have brought shame to your family.\n\"A man must be bIg enough to admit his miStakes, smart enough to profIt from them, and strong enough to Correct them.\"Reflect on your actions for another two days.\nBy then, you will surely have been able to realize the error of your ways and find the solution to your demise.\n\nSincerely, Your Parents", true));   //10
	room.add(new Puzzle("Laptop", "You can't log on. It seems your parents have changed the password.", "Python", "The display changes to your homescreen. Alright, you're finally on!"));    //11
	room.add(new Item("Pencil Holder", "Ohh, shiny pencils", false));  //12
	room.add(new Item("Drawer", "It's locked. You need to find a key", "Look at all the nice stuff you have in here.", false));   //13
	room.add(new Item("Vent", "It's stuck. You're gonna need a screwdriver", "The vent cover has been removed. There is only darkness within.", false));   //14
	room.add(new Item("Pillow", "A fluffy fluff pillow. There's a note inside the cover", false));   //15
	room.add(new Item("Pencil", "A 2B Ticonderoga pencil", "A pile of pencil shavings.", true));  //16
	room.add(new Item("Key", "The key to the desk drawer", true));  //17
	room.add(new Item("Fig", "A dried up fig", true));     //18
	room.add(new Item("Math test", "The math test you failed", true));  //19
	room.add(new Item("Phone", "Oh look, your phone. Its screen displays an 8-game puzzle", true));  //20
	room.add(new Item("Apple", "A shiny red Fuji apple", true));  //21
	room.add(new Puzzle("Safe", "There is a keypad.\nIt seems the password is three characters long.", "666", "The door swings open.\nAnd people said the stuff they did on detective movies was fake."));  //22

	/*------------------------------ Notes  -----------------------------------------*/
	room.add(new Item("Note for Door 1", "\nI carry the world between my covers\nYou carry me between your hands\nOf letters I have many\nOf pages I have none\n", true));   //23
	room.add(new Item("Note for Door 2", "The answer lies within four cards", true)); //24
	room.add(new Item("Note for Door 3", "\nHidden flower\nForbidden fruit\nConvenient tool\nInstructive mute\n", true)); //25
	room.add(new Item("Note for Door 4", "\nFind the clues between white sleeves\nThough in their form, they may decieve\nForsake the ones that cannot be\nAnd in the end there will be three\n\nReplace the three where spaces lie\nBeware that rules may not apply\nTake the first of each and try\nTo solve the door or, failing, cry\n\n", true)); //26
	room.add(new Item("Note for Door 5", "Note", true)); //27
	
	room.add(new Item("Acid", "A nice bottle of 100% Hydrochloric Acid", true));  //28
	room.add(new Item("Blue Index Card", "A blue index card with the number 8", true)); //29
	room.add(new Item("Scissors", "A pair of scissors", true)); // 30

	/*------------------------------ The Doors -----------------------------------------*/
	
	room.add(new Puzzle("Door1", "A high-tech metal door. Gears and rivets run down its center.\nThere is no handle.\n", "1238359", "The password lights up in green and a confirming beep is heard.\nThe gears on the door spin rapidly, and the two sides part."));  //31
	room.add(new Puzzle("Door2", "The sign on the door reads 'Color Code'.\n", "6890", "\nThe door slides upwards, revealing...?!\n"));  //32
	room.add(new Puzzle("Door3", "A large set of imposing, stone doors.\nThere are graphic images carved onto its surface of people being impaled and defenestrated.\nFour small compartments rest at the foot of the door.\n", "Newton", "Without warning, the doors come crashing down. You manage to jump out of the way just they impact the floor and shatter into a milion pieces."));  //33
	room.add(new Puzzle("Door4", "The door is divided into four separate sections that fit together like puzzle pieces. Mounted at their intersection is a shiny interface that displays some text:\n\nCaptain: What happen?\nMechanic: Somebody set up us the bomb.\nOperator: We get signal.\nCaptain: What!\nOperator: ---- ------ turn on.\nCaptain: It's you!!\nCATS: How are you gentlemen!!\nCATS: --- ---- ---- --- ------ -- --\nCATS: You are on the way to destruction.\nCaptain: What you say!!\nCATS: You have no chance to survive make your time.\nCATS: Ha ha ha ha...\nOperator: -------!!\nCaptain: Take off every 'ZIG'!!\nCaptain: You know what you doing.\nCaptain: Move 'ZIG'.\nCaptain: For great justice.\n\n", "Mac", "You easily slide the door open."));  //34
	room.add(new Puzzle("Door5", "A door with random math symbols carved into it.\n", "", "You hear a click and slowly slide the door open."));  //35

      
	/*------------------------------ The Closet -----------------------------------------*/
	
	closet.add(new Item("Screwdriver", "A Phillips screwdriver. This might come in handy", true));  //0
	closet.add(new Item("Paperclips", "Some colorful paperclips. You know what they are!", true));  //1
	closet.add(new Item("Tin Box", "A silver tin box used for storing cookies", false));            //2
	closet.add(new Item("Hoodie", "A spiffy hoodie", false));   //3
	closet.add(new Item("Marble", "A dirty marble caked in grease", "A lustrous marble. The word Python is written on it", true));  //4
	closet.add(new Item("Tissues", "A pack of tissues like the kind you get from Chinese people on the street", "A pack of slightly wet tissues", true));  //5
	closet.add(new Item("Index card", "An index card with four colored dots: Red, Blue, Green, Purple", true)); //6
	closet.add(new Item("Books", "Some old books", false)); //7
	
	/*------------------------------ The Bathroom -----------------------------------------*/
	
	bathroom.add(new Item("Metal box", "A tiny metal box. Hm... It looks like you'll have to pick the lock.", "You've already unlocked the box and taken the items. There is nothing left inside.", false)); //0
	bathroom.add(new Item("Forceps", "Just some forceps", true)); //1
	bathroom.add(new Item("Green Index Card", "A green index card with the number 9", true)); //2
	bathroom.add(new Item("Purple Index Card", "A purple index card with the number 0", true)); //3
	bathroom.add(new Item("Bathroom rug", "There is definitely not something under this rug", "A fuzzy bathroom rug. There is nothing under it", false)); //4
	bathroom.add(new Item("Faucet", "The water is running", false));    //5

	/*------------------------------ The Bookshelf -----------------------------------------*/
	
	bookshelf.add(new Item("For the Love of Physics", "\nFrom the End of the Rainbow to the Edge of Time\nA Journey Through\nthe Wonders of Physics\nThe title page has been ripped out. The words 'sincere man' are scrawled across the first page\n", false));  //0
	bookshelf.add(new Item("The Oedipus Cycle", "\nThe ancient myth of Oedipus, which still reverberates\nto this day, provided Sophocles with material for three\ngrea tragedies Oedipus Rex, Oedipus at Colonus and Antigone that\ntogether show how nobles are outragously lab, by\nrecounting the downfall of Oedipus, king of Thebes, his\ndeath in exile, and the action carried out after his death by his\ndaughter Antigone.\n", true));  //1
	bookshelf.add(new Item("Principles of Quantum Mechanics", "It's full of equations and greek letters\n", true)); //3
	bookshelf.add(new Item("Hamlet", "Readers have for the first time, a unique\nopportunity to study the three surviving texts of Hamlet\nexperienced by Shakespeare's contemporaries, fully\nmodernized and edited by leading scholars.\n", true));  //4
	bookshelf.add(new Item("Philosophiae Naturalis Principia Mathematica", "\nRational Mechanics will be the science of motions resulting\nfrom any forces whatsoever, and of the forces\nrequired to produce any motions, accurately proposed\nand demonstrated. And therefore we offer this work\nas mathematical principles of philosophy. For all the\ndifficulty of philosophy seems to consist in this: from the\nphenomena of motions to investigate the forces of\ncat pain, and then from these forces to\ndemonstrate the other phenomena.\n", true));  //5
	bookshelf.add(new Item("How to Beat this Game", "\nStop reading this and take your mime.\n", true));  //6

	room.get(7).setCompat("Acid");      //Closet
	room.get(11).setNDescript("An emacs file is open. There is a piece of code on it:\n\nRandom r = new Random();\ndouble stress = r.nextDouble();\nboolean codeWorks = (r.nextInt(2) == 1);\npublic void writeCode()\n\tif (codeWorks){\n\t\tSystem.out.println(\"I am a GOD\");\n\t}\n\telse{\n\t\tif (stress > 0.7){\n\t\t\tsystem.out.println(\"RAGE QUIT\")\n\t\t\tSystem.exit(0);\n\t\t}\n\t\tcry();\n\t}\n}\n\nWhat could it mean?");   //Laptop
	room.get(13).setCompat("Key");       //Drawer
	room.get(16).setCompat("Scissors");   // Pencil
	room.get(16).setNewForm("Pencil Shavings");   
	room.get(30).setCompat("Pencil");     //Scissors
	room.get(22).setCompat("Pencil Shavings");   //Safe
	room.get(22).setNDescript("There are distinctive fingerprint marks on the six key");
	room.get(14).setCompat("ScrewDriver");   //Vent
	room.get(0).setCompat("Forceps");    //Bed
	closet.get(5).setCompat("Marble");    //Tissues
	closet.get(5).setNewForm("Wet Tissues");  
	closet.get(4).setCompat("Wet Tissues");       //Marble
	bathroom.get(0).setCompat("Paperclips");         
	bathroom.get(5).setCompat("Tissues");	
    }

    /*----------------------------------------- GETS AND SETS ---------------------------------------------------*/
    public ArrayList<Item> getRoom(){
	return room;
    }

    public boolean gameWon(){
	return gameWon;
    }		
    
    public void editStatus(){
	gameWon = true;
    }

    public String getM(){
	return msg;
    }
    public String getQ(){
	return qsg;
    }

    public static void wait(int num){
	try{
	    Thread.sleep(num);
	}
	catch (Exception e){}
    }

    public String getBooks(){
	String booklist = "";
	for (int a = 0;a < bookshelf.size();a++){
	    booklist += "[" + (a + 1) + "]";
	    booklist += bookshelf.get(a);
	    booklist += "\n";
	}
	return booklist;
    }

    public String getComp(){
	int count = 0;
	String list = "<< The Compartments >>\n\n";
	for (int a = 0;a < compartment.size();a++){
	    list += "[" + (count + 1) + "]" + compartment.get(a) + "\n";
	    count++;
	}
	for (int b = count;b < 4;b++){
	    list += "[" + (b + 1) + "]";
	    list += "empty";
	    list += "\n";
	}
	return list;
    }

    /*------------------------------------------- GETS AND SETS ---------------------------------------------------*/


    //determines whether points should be deducted from player's grade
    //calls check method for puzzles
    //if player answers incorrectly (3), they lose fgrade
    //if player chooses to skip (2), they lose sgrade
    public boolean evaluate(int num, String ans){
	int choice = ((Puzzle)room.get(num)).check(ans);
	if (choice == 2){
	    grade += sgrade;
	}
	else if(choice == 3){
	    grade += fgrade;
	}
	return choice < 3;
    }

    //checks if compartments are filled with correct objects
    public boolean checkComp(){
	if (compartment.size() == 4){
	    for (int i = 0;i < 4;i++){
		if (answer.contains(compartment.get(i).getName()) == false){
		    return false;
		}
	    }
	    return true;
	}
	else {
	    return false;
	}
    }

    //player can choose to place an item in a compartment
    //or take an item away
    public void fillComp(){
	int i = 0;
	int c, option, count;
	String list;;
        while (i != 1){	   
	    System.out.println(getComp());
	    c = this.AskUserI("\n[1]Place an object\n[2]Take an object\n[3]Back to door\n");
	    switch (c){
	    case 1:
		if (compartment.size() > 4){
		    System.out.println("\nAll spots are filled");
		}
		else {
		    System.out.println(inventory);
		    option = this.AskUserI("\nWhich object do you want to place?\n");
		    try {
			Item item = inventory.get().get(option);
			System.out.println("\nYou placed the " + item + " in the compartment");
			if (answer.contains(item.getName())){
			    System.out.println("\nThe compartment you place the " + item + " in glows faintly");
			}
			compartment.add(inventory.get().remove(option));
		    }
		    catch (Exception e){
			System.out.println(msg);
		    }
		}
		break;
	    case 2:
		if (compartment.isEmpty()){
		    System.out.println("\nThere's nothing to take");
		}
		else {
		    option = this.AskUserI("\nWhich object do you want to take?\n");
		    try {
		        inventory.take(compartment.remove(option));
		    }
		    catch (Exception e){
			System.out.println(msg);
		    }
		}
		break;
	    case 3:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    //prints description for door, checks answer
    //game is cleared when all five doors have been passed
    public void checkDoor(){
	int i = 0;
	String ans;
	while (i != 1 && stage < 6){
	    System.out.println("\nYou are at Door " + stage + "\n" + room.get(stage + 30).getDescript()); 
	    int c = this.AskUserI("\nTry to solve the puzzle?\n[1]Yes\n[2]No\n");
	    switch (c){
	    case 1:
	    	if (stage == 5){
	    	    MineSweeper m = new MineSweeper();
	    	    m.generateGame();
	    	    m.userInteract();
	    	}
		else if (((Puzzle)room.get(stage + 30)).getSolved() == false){
		    if (stage == 3 && checkComp() == false){
			System.out.println("\nIt looks like you'll have to fill the compartments first.");
			fillComp();
		    }
		    else {
			ans = this.AskUserS("\nKey-in the passcode: ");
			wait(1000);
		        if (evaluate(stage + 30, ans) == true){
			    if (stage < 5){
				wait(2000);
				System.out.println("\nAlas, there is another door behind it\n");
			    }
			    stage++;
			}
		    }
		}
		break;
	    case 2:
		i = 1; break;
	    default:
		System.out.println(msg);
	    }
	}
	if (stage > 5){
	    gameWon = true;
	}
    }

    //presents choices depending on what object the player initially chooses to interact with    
    public void interact(String thing){
	switch(thing){
	case "Bed":
	    interactBed();
	    break;
	case "Desk":
	    interactDesk();
	    break;
	case "Bag":
	    interactBag();	      
	    break;
	case "Rug":
	    interactRug(); 
	    break;
	case "Trash Can":
	    interactTrashCan();
	    break;
	case "Bookshelf":
	    interactBookShelf();
	    break;
	case "Poster":
	    interactPoster();
	    break;
	case "Closet":
	    interactCloset();
	    break;
	case "Bathroom":
	    interactBathroom();
	    break;
	case "Vent":
	    interactVent();
	}
    }


    public void interactBed(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Check under the blankets\n[2]Check pillow\n[3]Look under bed\n[4]Already saw the bed\n");
	    switch(c){
	    case 1:
		System.out.println("\nThere's nothing there\n");
		break;
	    case 2:
		System.out.println(room.get(15).getDescript());
		if (room.get(15).getStatus() == false){
		    inventory.take(room.get(24));
		    room.get(15).changeDescript("A fluffy fluff pillow. Just looking at it makes you want to lie down in bed");
		    room.get(15).changeStatus();
		}
		break;	    	      
	    case 3:
		System.out.println("\nA colony of dust bunnies is thriving under the bed");
		if (room.get(0).getStatus() == false){
		    System.out.println("There seems to be a piece of paper in the corner");
		    if (room.get(0).toUse(inventory.find(equip), "You used the forceps to grab the paper") == true){
			inventory.take(room.get(25));
		    }
		}
		else{
		    System.out.println("You can't seem to reach it");
		}
		break;
	    case 4:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void interactDesk(){
	int c;
	int i = 0;
	String s = "\nYou unlocked the desk drawer with the key.\nYou find a Blue index card with the number 8 on it and a note.";
	while (i != 1){
	    c = this.AskUserI("\n[1]Check laptop\n[2]Check pencil holder\n[3]Check drawer\n[4]Nope\n");
	    switch(c){
	    case 1:
		System.out.println(room.get(11).getDescript()); 
		if (((Puzzle)room.get(11)).getSolved() == false){
		    String ans = this.AskUserS("\nEnter Password: ");
		    wait(1000);
		    if (evaluate(11, ans) == true){
			System.out.println(room.get(11).getDescript());
		    }	       
		}
		break;
	    case 2:
		System.out.println(room.get(12).getDescript());
		if (room.get(12).getStatus() == false){
		    System.out.println("\nYou took a pencil");
		    inventory.take(room.get(16));
		    room.get(12).changeStatus();
		}
		break;
	    case 3:
		System.out.println(room.get(13).getDescript());
		if (room.get(13).getStatus() == false){
		    if (room.get(13).toUse(inventory.find(equip), s) == true){
			inventory.take(room.get(29));
			inventory.take(room.get(23));
		    } 	   
		}
		break;
	    case 4:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void playEightGame(){
	int c;
	int i = 0; 
	System.out.println("\nYour phone displays an 8-Game Puzzle");
	while (i != 1){
	    c = this.AskUserI("\n[1]I want to play!\n[2]No thanks\n");
	    switch(c){
	    case 1:
		System.out.println("\nEver played the 8-Game Puzzle? Here are the directions: \n   Your goal is to get the numbers to be in order from 0 to 9 \n   (with 0-2 in the first row, 3-5 in the second, and 6-8 in the third) \n   by moving the zero in any of the four directions \n   (left, up, right, down). Let's go! :)");
		eightGame = new EightGamePuzzle();
		eightGame.generateGame(5);
		boolean solved = eightGame.userSteps();
		if (solved == true){
		    System.out.println("\n\n You see a Red 6.");
		    room.get(20).changeStatus();
		    room.get(20).changeDescript("\nA phone displaying a Red 6");
		    inventory.take(room.get(20));
		    if (eightGame.getSkip()){
			grade += sgrade;
		    }
		    else {
			grade += fgrade;
		    }
		    i = 1;
		}
		else {
		    grade += fgrade;
		    System.out.println("\n\n Maybe next time.");
		}		
		break;
	    case 2: i = 1; break;
	    default: System.out.println(msg);
	    }
	}
    }
  

    public void interactBag(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Open small pocket\n[2]Look through notes\n[3]Move on\n");
	    int i2, c2;
	    String option;
	    switch(c){
	    case 1:
		System.out.println("\nYou find your student metrocard, your student ID, your phone, and a few TicTacs");
		i2 = 0;
		while (i2 != 1){
		    if (room.get(20).getStatus() == false){
			option = "\n[1]Inspect phone, [2]Take the Tictacs, [3]Eh, I'll move on\n";
		    }
		    else {
			option = "\n[1]Dig deeper, [2]Take the Tictacs, [3]Eh, I'll move on\n";
		    }
		    c2 = this.AskUserI(option);
		    switch(c2){
		    case 1:
			if (room.get(20).getStatus() ==  true){
			    System.out.println("\nThere is lint and a moldy sandwich at the bottom. You regret looking.");
			}
			else {
			    playEightGame();
			}
			break;
		    case 2:
			System.out.println("\nEw, these are a few years old. Maybe you should leave them.");
			break;
		    case 3:
			i2 = 1;
			break;
		    default:
			System.out.println(msg);
		    }
		}
		break;
	    case 2:
		System.out.println("\nLooking at these grades is depressing.");
		if (room.get(19).getStatus() == false){
		    System.out.println("\nYou find the evil math test that has landed you in this mess!");
		    inventory.take(room.get(19));
		    room.get(19).changeStatus();
		}
		break;
	    case 3:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void interactRug(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Flip rug\n[2]Nah\n");
	    switch(c){
	    case 1:
		if (room.get(3).getStatus() == false){
		    System.out.println("\nYou find a pair of scissors.");
		    inventory.take(room.get(30));
		    room.get(3).changeStatus();
		    room.get(3).changeDescript("An ugly Pikachu rug");
		}
		else {
		    System.out.println("How disappointing. There's nothing under it");
		}
		break;
	    case 2:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }
	    
    public void interactTrashCan(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Rummage through trash can\n[2]How unsanitary!\n");
	    switch(c){
	    case 1:
		if (room.get(4).getStatus() == false){
		    System.out.println("\nYou found a rotten fig");
		    inventory.take(room.get(18));
		    room.get(4).changeStatus();
		}
		else {
		    System.out.println("\nThere's only trash");
		}
		break;
	    case 2:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void interactBookShelf(){
	int c;
	int i = 0;
	while (i != 1){
	    String list = getBooks();
	    c = this.AskUserI("\n[1]Look at book\n[2]Now's not the time!\n");
	    switch(c){
	    case 1:
		int book = this.AskUserI(list);
		if (book >= 0 && book < bookshelf.size()){
		    System.out.println(bookshelf.get(book - 1).getDescript());
		    int c2;
		    int i2 = 0;
		    while (i2 != 1){
			c2 = this.AskUserI("\nTake book? [1]Yes, [2]No\n");
			switch(c2){
			case 1:
			    inventory.take(bookshelf.remove(book - 1));
			    i2 = 1;
			    break;
			case 2:
			    i2 = 1;
			    break;       
			default:
			    System.out.println(msg);
			}
		    }
		}
		break;		    		
	    case 2:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void interactPoster(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Inspect poster\n[2]Flip poster\n[3]Leave it\n");
	    switch(c){
	    case 1:
		System.out.println("It is a poster of the periodic table of elements.");
		break;
	    case 2:     
		System.out.println("\nThere's a safe behind the poster!");
		System.out.println(room.get(22).getDescript());
		if (room.get(22).getStatus() == false){
		    if (room.get(22).toUse(inventory.find(equip), "You blow the pencil shavings onto the keypad.\nThe fingerprints on the six key become visible") == false){
			System.out.println("\nIf only there were a way to see what had been previously typed...");
		    }
		    else {
			room.get(22).setNDescript("The safe where you stash your loot");
		    }
		}
		if (((Puzzle)room.get(22)).getSolved() == false){			
		    String ans  = this.AskUserS("\nEnter password: ");
		    wait(1000);
		    if (evaluate(22, ans) == true){
			System.out.println("You find a bottle of acid in the safe");
			inventory.take(room.get(28));
		    }
		}		   
		break;		
	    case 3:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void interactCloset(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Slide open left door\n[2]Slide open right door\n[3]Move on\n"); 
	    switch (c){
	    case 1:
		if (room.get(7).getStatus() == false){	      
		    if (room.get(7).toUse(inventory.find(equip), "You use the acid to melt the hinge.") == false){
			System.out.println("\nThe door is stuck. It's been a while since you last greased it.\n");
		    }
		}
		else {
		    System.out.println("\nYour clothes hang neatly in the closet, with a few storage boxes below it and a pile of books. A silver tin box sits on top of the pile");
		    int i2 = 0;
		    while (i2 != 1){
			int c2 = this.AskUserI("\n[1]Check the pockets of your hoodie\n[2]Open storage boxes\n[3]Flip through books\n[4]Open tin box\n[5]Move on\n");
			switch(c2){
			case 1:
			    System.out.println(closet.get(3).getDescript());
			    if (closet.get(3).getStatus() == false){
				System.out.println("\nYou find a marble and a pack of tissues");
				inventory.take(closet.get(4));
				inventory.take(closet.get(5));
				closet.get(3).changeStatus();
				closet.get(3).changeDescript("A spiffy hoody. You have already taken everything in the pockets.");
			    }
			    break;
			case 2: System.out.println("\nNothing interesting. Just some old clothes you plan to donate"); break;
			case 3:
			    System.out.println(closet.get(7).getDescript());
			    if (closet.get(7).getStatus() == false){
				System.out.println("\nYou find an index card with four colored dots: Red, Blue, Green, and Purple");
				inventory.take(closet.get(6));
				closet.get(7).changeStatus();
				closet.get(7).changeDescript("Some old books. That's all");
			    }
			    break;
			case 4:
			    System.out.println(closet.get(2).getDescript());
			    if (closet.get(2).getStatus() == false){
				System.out.println("\nYou find a screwdriver and some paper clips");
				inventory.take(closet.get(0));
				inventory.take(closet.get(1));
				closet.get(2).changeStatus();
			    }
			    break;
			case 5: i2 = 1; break;
			default: System.out.println(msg); break;
			}
		    }
		}
		break;
	    case 2:
		System.out.println("The door is stuck.");
		break;
	    case 3:
		i = 1;
		break;
	    default:
	    System.out.println(msg);
	    }
	}
    }

    public void interactBathroom(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Open door\n[2]Don't need the toilet right now\n");
	    switch(c){
	    case 1:
		System.out.println("\nYou have entered the bathroom. There is a medicine cabinet above the sink and a rug at your feet.");
		int i2 = 0;
		while (i2 != 1){
		    int c2 = this.AskUserI("\n[1]Open medicine cabinet doors\n[2]Turn on faucet\n[3]Lift rug\n[4]Leave bathroom");
		    switch(c2){
		    case 1:
			System.out.println("You see a little metal box, a bunch of toothpaste, and various medicine");
			int i3 = 0;
			while (i3 != 1){
			    int c3 = this.AskUserI("\n[1]Open metal box\n[2]Close medicine cabinet door");
			    switch(c3){
			    case 1:
				System.out.println(bathroom.get(0).getDescript());
				if (bathroom.get(0).getStatus() == false){	 
				    if (bathroom.get(0).toUse(inventory.find(equip), "You have unlocked the box using the paperclips! You find forceps and a Green index card with the number 9") == true){    
					inventory.take(bathroom.get(1));
					inventory.take(bathroom.get(2));
				    }
				}
				break;
			    case 2:
				i3 = 1;
				break;
			    }
			    break;
			}
		    case 2:
			System.out.println(bathroom.get(5).getDescript());
			if (bathroom.get(5).getStatus() == false){
			    if (bathroom.get(5).toUse(inventory.find(equip), "You soaked the tissues in the water.") == true){
				inventory.find(equip).setName(inventory.find(equip).getNewForm());
			    }
			}
			break;
		    case 3:
			System.out.println(bathroom.get(4).getDescript());
			if (bathroom.get(4).getStatus() == false){
			    System.out.println("\nYou flip the rug and find a Purple index card with the number 0.\n");
			    inventory.take(bathroom.get(3));
			    bathroom.get(4).changeStatus();
			    bathroom.get(4).changeDescript("\nA fuzzy bathroom rug. There is nothing under it\n");
			}
			break;
		    case 4:
			System.out.println("\nYou are back in your room");
			i2 = 1;
			break;
		    default:
			System.out.println(msg);
		    }
		}
		break;
	    case 2:
		i = 1;
	    default:
		System.out.println(msg);
	    }
	}
    }

    public void interactVent(){
	int c;
	int i = 0;
	while (i != 1){
	    c = this.AskUserI("\n[1]Check vent\n[2]Who cares?\n");
	    switch(c){
	    case 1:
		System.out.println(room.get(14).getDescript());
		if (room.get(14).getStatus() == false){
		    String s = "You used the Phillips screwdriver to unscrew the cover.\nYou find a key and an apple inside.";
		    if (room.get(14).toUse(inventory.find(equip), s)){
			inventory.take(room.get(17));
			inventory.take(room.get(21));
		    }	        
		}
		break;
	    case 2:
		i = 1;
		break;
	    default:
		System.out.println(msg);
	    }
	}
    }


    //allows player to choose two items to combine
    //if player chooses a valid object from inventory,
    //it is stored in a tempoaray arraylist
    public void toCombine(){
	if (inventory.get().size() < 2){
	    System.out.println("\nNot enough items in inventory");
	}
	else {
	    int i = 0;
	    int a;
	    ArrayList<String> temp = new ArrayList<String>();
	    while (i != 2){
		a = this.AskUserI("\nItem " + (i + 1) + ": ");
		if (a >= 0 && a < inventory.get().size()){
		    temp.add(inventory.get().get(a).getName());
		    i++;
		}
		else if (a == -2){
		    i = 2;
		}
		else {
		    System.out.println(msg);
		}
	    }
	    if (temp.size() == 2){
		inventory.combine(inventory.find(temp.get(0)), inventory.find(temp.get(1)));
	    }
	}
    }


    //equipped items will atomatically be used on any main object player explores
    //stores equipped item as string
    public void toEquip(){
	int i = 0;
	int c;
	while (i != 1){
	    if (equip.equals("None")){
		System.out.println("Nothing is equipped");
	    }
	    else {
		System.out.println("Currently Equipped: " + equip);
	    }
	    c = this.AskUserI("\nChoose an item: ");
	    if (c >= 0 && c < inventory.get().size()){
		equip = inventory.get().get(c).getName();
		System.out.println("<< Equipped " + equip + " >>"); 
		i = 1;
	    }
	    else if (c == -2){
		i = 1;
	    }
	    else {
		System.out.println(msg);
	    }
	}
    }

    public String finalGrade(){
	String letter = "";
	if (grade < 65){
	    letter = "F";
	}
	else if (grade < 75){
	    letter = "D";
	}
	else if (grade < 85){
	    letter = "C";
	}
	else if (grade < 95){
	    letter = "B";
	}
	else{
	    letter = "A";
	}
	return letter;
    }

    public void Scenario(){
	String g = finalGrade();
	System.out.println("Compiling score report...");
	wait(3000);
	System.out.println("You got a " + g);
	wait(2000);
	switch(g){
	case "A":
	    System.out.println("What an average grade. Well, it is adequate for now.");
	    break;
	case "B":
	    System.out.println("You have proven yourself a base and below par student, but we will accept you back, as you have just barely passed.");
	    break;
	case "C":
	    System.out.println("A catastrophic grade! Why do you even bother coming back?");
	    break;
	case "D":
	    System.out.println("Dost thou not feel ashamed for displaying such delinquency?");
	    break;
	case "F":
	    System.out.println("Son, you have failed for the final time. Forsake thy name and returneth from whence thy came.");
	}
    }

  
    //used for Puzzles
    public String AskUserS(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.println(mToUser);      //presents option to player
	s = sc.nextLine();
	return s;                        //returns player's choice
    }

    //used for all other interactions
    public int AskUserI(String mToUser){
	String s = "";
	Scanner sc = new Scanner(System.in);
	System.out.print(mToUser);
	s = sc.nextLine();
        try{
	    return Integer.parseInt(s);
	}
	catch(NumberFormatException e){
	    if (s.equals("return")){
		return -2;
	    }
	    return -1;
	}
    }
}
