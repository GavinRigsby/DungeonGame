public class Thief extends Hero
{

    public Thief()
	{
    	
		super("Thief", Details.getThiefDetails());



    }//end constructor

	public void Attack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		int numTurns = super.getNumTurns();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								getName() + " gets an additional turn.");
			super.setNumTurns(numTurns + 1);
			Attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    Attack(opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;
		int numTurns = super.getNumTurns();

		do
		{          
          System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();
          System.out.println("--------------------------------------------------\n");

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: Attack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0 )
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }
}