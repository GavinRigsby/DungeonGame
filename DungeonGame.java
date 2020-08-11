public class DungeonGame
{
   public static void main(String[] args)
	{
		Hero theHero;
		Monster theMonster;

		do{
         theHero = chooseHero();
		   theMonster = generateMonster();
			battle(theHero, theMonster);
      }while (playAgain());

    }//end main method

	public static Hero chooseHero(){
		int choice;
      HeroFactory factory = new HeroFactory();
      
		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		choice = Keyboard.readInt();
      
      return factory.createHero(choice);
	}//end chooseHero method


	public static Monster generateMonster()
	{
		int choice;
      MonsterFactory factory =  new MonsterFactory();
      
		choice = (int)(Math.random() * 3) + 1;
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