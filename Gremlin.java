public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", Details.getGremlinDetails());

    }//end constructor

	public void Attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Gremlin