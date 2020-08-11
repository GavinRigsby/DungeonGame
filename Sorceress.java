
public class Sorceress extends Hero
{
// 	public final int MIN_ADD = 25;
// 	public final int MAX_ADD = 50;
//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);

    }//end constructor
    
//This method calls: nothing
//This method is called by: heal method of monsters and Sorceress
/*---------------------------------------------------------*/
// public void addHitPoints(int hitPoints)
// {
// 	if (hitPoints <=0)
// 		System.out.println("Hitpoint amount must be positive.");
// 	else
// 	{
// 		this.hitPoints += hitPoints;
// 		//System.out.println("Remaining Hit Points: " + hitPoints);
// 
// 	}
// }//end addHitPoints method

//-----------------------------------------------------------------
	public void increaseHitPoints()
    {
	    int hPoints;
      int MAX_ADD = 50;
      int MIN_ADD = 25;
		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ getHitPoints());
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void Attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
          System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();
          System.out.println("--------------------------------------------------\n");
          
		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: increaseHitPoints();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		   if (numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0 )//changed this so it wouldnt show when displaying win or loss
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

}//end class