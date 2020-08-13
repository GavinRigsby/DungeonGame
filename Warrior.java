public class Warrior extends Hero
{

    public Warrior()
	{

		super("Warrior", Details.getWarriorDetails());


    }//end constructor


	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints, this);
		}//end blow succeeded
		else
		{
			System.out.println(getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void Attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;
		int numTurns = super.getNumTurns();
		super.battleChoices(opponent);

		do
		{            
          System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();
          System.out.println("--------------------------------------------------\n");
          
		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: crushingBlow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0 )
			    System.out.println("Number of turns remaining is: " + numTurns);



		} while(numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end battleChoices method

}