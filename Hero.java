public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
   protected int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, 
		  int damageMin, int damageMax, double chanceToBlock)
  {
      super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
      setChanceToBlock(chanceToBlock);
      readName();
  }
  
  public void setChanceToBlock(final double chanceToBlock) {
        this.chanceToBlock = chanceToBlock;  
  }
  
   public double getChanceToBlock(){
        return this.chanceToBlock;
   }

   public int getNumTurns(){
        return this.numTurns;    
   }
  
    
    public void readName(){
        System.out.print("Enter character name: ");
		  setName(Keyboard.readString());
    }
  
  // public String getName()
// 	{
// 		return name;
// 	}//end getName
// 
// //-----------------------------------------------------------------
// 	public int getHitPoints()
// 	{
// 		return hitPoints;
// 	}//end getHitPoints
// //-----------------------------------------------------------------
// 	public int getAttackSpeed()
// 	{
// 		return attackSpeed;
//}//end getAttackSpeed

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  // public void SetName()
//   {
// 		System.out.print("Enter character name: ");
// 		name = Keyboard.readString();
//}//end readName method
  
  /*-------------------------------------------------------
  attack allows character to attempt attack on opponent.  First, chance to hit
  is considered.  If a hit can occur, then the damage is calculated based on
  character's damage range.  This damage is then applied to the opponenet.

  Receives: opponent being attacked
  Returns: nothing

  This method calls: Math.random(), subtractHitPoints()
  This method is called by: overridden versions of the method in monster and
  hero classes and externally
  ---------------------------------------------------------*/
// public void attack(Monster opponent)
// {
// 	boolean canAttack;
// 	int damage;
// 
// 	canAttack = Math.random() <= chanceToHit;
// 
// 	if (canAttack)
// 	{
// 		damage = (int)(Math.random() * (damageMax - damageMin + 1))
// 					+ damageMin ;
// 		opponent.subtractHitPoints(damage, this);
// 
// 
// 
// 		System.out.println();
// 	}//end if can attack
// 	else
// 	{
// 
// 		System.out.println(getName() + "'s attack on " + opponent.getName() +
// 							" failed!");
// 		System.out.println("--------------------------------------------------\n");
// 	}//end else
// 
// }//end attack method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method


  /*-------------------------------------------------------
  addHitPoints is used to increment the hitpoints a dungeon character has

  Receives: number of hit points to add
  Returns: nothing



/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise decrement the hitpoints a character has.
It also reports the damage and remaining hit points

Receives: hit points to subtract
Returns: nothing

This method calls: defend()
This method is called by: attack()
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking hit points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------*/
// public boolean isAlive()
// {
//   return (hitPoints > 0);
//}//end isAlive method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed() / opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class