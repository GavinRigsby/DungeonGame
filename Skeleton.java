
public class Skeleton extends Monster
{

    public Skeleton()
	{
		super("Sargath the Skeleton", Details.getSkeletonDetails());

    }//end constructor

	public void Attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " slices his rusty blade at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Skeleton