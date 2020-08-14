public class DungeonAdventure
{
   private static int Size = 7;
   private static Dungeon dungeon = new Dungeon(Size);
   private static Hero theHero;
   
   
   public static void main(String[] args)
	{
		Monster theMonster;
		//number in dungeon is size eg: 7 = 7x7 dungeon
		
		//print full map and rooms
		System.out.println(dungeon.toString());
		
		//choose character
		theHero = chooseHero();
        //start in room
        int ex = dungeon.getEntrance()[0];
        int ey = dungeon.getEntrance()[1];
        theHero.setCoords(ex, ey);
        System.out.println("You start in a room at " + ex + "," + ey);
		do{
         ChooseDirection();
         int x = theHero.getCoords()[0];
         int y = theHero.getCoords()[1];
         Room currentroom = dungeon.getRoom(x, y);
         String content = currentroom.getItemContents();
         
         
         
		 theMonster = generateMonster();
			battle(theHero, theMonster);
      }while (playAgain());

    }//end main method
   
    public static void ChooseDirection(){
    	int[] coords = theHero.getCoords();
    	int x = coords[0];
    	int y = coords[1];
    	
    	
    	System.out.println("Choose where to go:\n");
    	if (x != 0) {
    		System.out.println("North");
    	}
    	if (x != Size) {
    		System.out.println("South");
    	}
    	if (y != Size) {
    		System.out.println("East");
    	}
    	if (y != 0) {
    		System.out.println("West");
    	}
    	
    	String choice = Keyboard.readWord().toLowerCase();
    	if (choice == "north" || choice == "n") {
    		if (x == 0) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x - 1, y);
        	}
    	}
    	
    	if (choice == "south" || choice == "s") {
    		if (x == Size) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x + 1, y);
        	}
    	}
    	
    	if (choice == "east" || choice == "e") {
    		if (y == Size) {
    			System.out.println("That is not a valid option\n");
				ChooseDirection();
        	}else {
        		theHero.setCoords(x, y + 1);
        	}
    	}
    	
    	if (choice == "west" || choice == "w") {
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


	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		if (again == 'n' || again == 'N')
			System.out.println("Thank you for playing!");
			System.out.println("Goodbye");
		return (again == 'Y' || again == 'y');
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

         if(theMonster.getHitPoints() > 0 && theHero.getHitPoints() > 0){
            System.out.println("--------------------------------------------------");
			   System.out.print("-->q to quit, anything else to continue: ");
			   pause = Keyboard.waitTillEnter(); //used to be Keyboard.readChar();
            System.out.println("--------------------------------------------------\n");
         }   
		}

		if (theMonster.getHitPoints() == 0)
		    System.out.println(theHero.getName() + " was victorious!\n");
		else if (theHero.getHitPoints() == 0)
			System.out.println(theHero.getName() + " was defeated :-(\n");
		else
			System.out.println("Quitters never win ;-)\n");
	}
}