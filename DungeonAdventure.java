public class DungeonAdventure
{
   private static int Size = 7;
   private static Dungeon dungeon = new Dungeon(Size);
   private static Hero theHero;
   private static boolean playagain = true;
   
   
   public static void main(String[] args)
	{
	   	
		Monster theMonster;
		//number in dungeon is size eg: 7 = 7x7 dungeon
		
		//print full map and rooms
		//System.out.println(dungeon.toString());
		
		//choose character
		theHero = chooseHero();
        //start in room
        int ex = dungeon.getEntrance()[0];
        int ey = dungeon.getEntrance()[1];
        theHero.setCoords(ex, ey);
        System.out.println("\n" + dungeon.getRoom(ex, ey).toString());
        System.out.println("You start in a room at " + ex + "," + ey + "\n");
        
        //testing vision potion
        //theHero.addVisionPotion();
		
        do{
		 System.out.println("What would you like to do?\n"
		 		+ "1. Move Rooms\n"
				+ "2. Inpect self\n"
		 		+ "3. Use Vision Potion\n"
				+ "4. Use Healing Potion\n");
		 
		 int choice = Keyboard.readInt();
		 if (choice == 1){
			 ChooseDirection();
	         int x = theHero.getCoords()[0];
	         int y = theHero.getCoords()[1];
	         System.out.println("\nYou move to room " + x + "," + y + "\n");
	         Room currentroom = dungeon.getRoom(x, y);
	         String contents = currentroom.getItemContents();
	         System.out.println(currentroom.getRoom());
	         Room room;
	         if (contents.contains("pillar of OO")){
	        	 System.out.println("You found one of the pillars of OO");
	        	 theHero.addPillar();
	         }
	         if (contents.contains("a vision potion")) {
	        	 System.out.println("You found one of the pillars of OO");
	        	 theHero.addVisionPotion();
	         }
	         if (contents.contains("a healing potion")) {
	        	 System.out.println("You found one of the pillars of OO");
	        	 theHero.addHealthPotion();
	         }
	         if (contents.contains("a monster")) {
	        	 System.out.println("This room contains a monster!!");
	    		theMonster = generateMonster();
	 			battle(theHero, theMonster);
	         }
	         if (contents.contains("a pit")) {
	        	 //implement pit damage function
	        	 room = new Room(true, false, false, false, false, false, -1, Size, x, y);
	         }
	         else if (contents.contains("the enterance")) {
	        	 room = new Room(false, false, true, false, false, false, -1, Size, x, y);
	         }
	         else if (contents.contains("the exit")) {
	        	 CheckForPillars();
	        	 room = new Room(false, false, true, false, false, false, -1, Size, x, y);
	         }
	         
	         else{
	        	 room = new Room(false, false, false, false, false, false, -1, Size, x, y);
	         }
	         
	         dungeon.setRoom(x, y, room);
		 }
		 if (choice == 2) {
			 System.out.println(theHero.toString());
		 }
		 if (choice == 3) {
			 if(theHero.useVisionPotion()) {
				 int x = theHero.getCoords()[0];
		         int y = theHero.getCoords()[1];
				 dungeon.Vision(x , y);
			 }
		 }
		 if (choice == 4) {
			 theHero.useHealthPotion();
		 }
		 
      }while (theHero.getHitPoints() > 0 && playagain);

    }//end main method
   
   	public static void CheckForPillars() {
   		int pillars = theHero.getPillarsFound();
   		if (pillars == 4) {
   			playAgain();
   		}else {
   			System.out.println("You need to find " + (4 - theHero.getPillarsFound()) + " more pillars before leaving" );
   		}
   	}
   
   
    public static void ChooseDirection(){
    	int[] coords = theHero.getCoords();
    	int x = coords[0];
    	int y = coords[1];
    	
    	
    	System.out.println("Choose where to go:\n");
    	if (x != 0) {
    		System.out.println("North (n)");
    	}
    	if (x != Size) {
    		System.out.println("South (s)");
    	}
    	if (y != Size) {
    		System.out.println("East (e)");
    	}
    	if (y != 0) {
    		System.out.println("West (w)");
    	}
    	
    	char choice = Keyboard.readChar();
    	if (choice == 'n' || choice == 'N'){
    		if (x == 0) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x - 1, y);
        	}
    	}
    	
    	if (choice == 'S' || choice == 's') {
    		if (x == Size) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x + 1, y);
        	}
    	}
    	
    	if (choice == 'E' || choice == 'e') {
    		if (y == Size) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x, y + 1);
        	}
    	}
    	
    	if (choice == 'W' || choice == 'w') {
    		if (y == 0) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x, y - 1);
        	}
    	}
    }

	public static Hero chooseHero(){
		int choice;
      HeroFactory factory = new HeroFactory();
      
		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "4. Archer Queen\n" +
						   "5. Healer");
		choice = Keyboard.readInt();
      
      return factory.createHero(choice);
	}//end chooseHero method


	public static Monster generateMonster()
	{
		int choice;
      MonsterFactory factory =  new MonsterFactory();
      
		choice = (int)(Math.random() * 5) + 1;
      return factory.createMonster(choice);
		
	}//end generateMonster method


	public static void playAgain()
	{
		char again;
		System.out.println("Congrats you won!");
		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		if (again == 'n' || again == 'N')
			System.out.println("Thank you for playing!");
			System.out.println("Goodbye");
			playagain = false;
		if (again == 'y' || again == 'Y') {
			playagain = true;
		}
	}//end playAgain method


	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("--------------------------------------------------\n");


		while (theHero.getHitPoints() > 0 && theMonster.getHitPoints() > 0 && pause != 'q')
		{
			theHero.battleChoices(theMonster);

			if (theMonster.getHitPoints() > 0)
			    theMonster.attack(theHero);   
		}

		if (theMonster.getHitPoints() == 0)
		    System.out.println(theHero.getName() + " was victorious!\n");
		else if (theHero.getHitPoints() == 0)
			System.out.println(theHero.getName() + " was defeated :-(\n");
		else
			System.out.println("Quitters never win ;-)\n");
	}
	
	
}