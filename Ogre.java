
public class Ogre extends Monster
{

    public Ogre()
	{
		super("Oscar the Ogre", Details.getOgreDetails());


    }//end constructor

	public void Attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack

}//end Monster class