public abstract class Monster extends DungeonCharacter
{
	protected double chanceToHeal;
	protected int minHeal, maxHeal;
	// protected String name;
// 	protected int hitPoints;
// 	protected int attackSpeed;
// 	protected double chanceToHit;
// 	protected int damageMin, damageMax;

//-----------------------------------------------------------------
  public Monster(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax,
					 int minHeal, int maxHeal){
	  // this.name = name;
// 	  this.hitPoints = hitPoints;
// 	  this.attackSpeed = attackSpeed;
// 	  this.chanceToHit = chanceToHit;
// 	  this.damageMin = damageMin;
// 	  this.damageMax = damageMax;
         super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
         setChanceToHeal(chanceToHeal);
         setHealRange(minHeal,maxHeal);
  }//end monster constructor
  
//-----------------------------------------------------------------
// 	public String getName()
// 	{
// 		return name;
	//}//end getName

//-----------------------------------------------------------------
// 	public int getHitPoints()
// 	{
// 		return hitPoints;
// 	}//end getHitPoints
//-----------------------------------------------------------------
// 	public int getAttackSpeed()
// 	{
// 		return attackSpeed;
// 	}//end getAttackSpeed


//-----------------------------------------------------------------
   public void setChanceToHeal(final double chanceToHeal) { 
      this.chanceToHeal = chanceToHeal; 
   }
   public void setHealRange(final int minHeal,final int maxHeal) { 
      this.minHeal = minHeal; this.maxHeal = maxHeal; 
   }
   public double getChanceToHeal() { 
      return this.chanceToHeal; 
   }
  
  public void heal()
  {
	   boolean canHeal;
	   int healPoints;

	   canHeal = (Math.random() <= chanceToHeal) && (getHitPoints() > 0);

	   if (canHeal)
	   {
		   healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		   addHitPoints(healPoints);
		   System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
							      + "Total hit points remaining are: " + getHitPoints());
		   System.out.println("---------------------------------------------\n");
	}//end can heal


  }//end heal method

  /*-------------------------------------------------------
  addHitPoints is used to increment the hitpoints a dungeon character has

  Receives: number of hit points to add
  Returns: nothing

  This method calls: nothing
  This method is called by: heal method of monsters and Sorceress
  ---------------------------------------------------------*/
  	// public void addHitPoints(int hitPoints)
//   	{
//   		if (hitPoints <=0)
//   			System.out.println("Hitpoint amount must be positive.");
//   		else
//   		{
//   			this.hitPoints += hitPoints;
//   			//System.out.println("Remaining Hit Points: " + hitPoints);
// 
//   		}
//   	}//end addHitPoints method

  
//-----------------------------------------------------------------
//  public void subtractHitPoints(int hitPoints, Hero opponent)
//  {
// 	 if (hitPoints < 0)
// 			System.out.println("Hitpoint amount must be positive.");
// 		else if (hitPoints > 0)
// 		{
// 			this.hitPoints -= hitPoints;
// 			if (this.hitPoints < 0)
// 				this.hitPoints = 0;
// 			System.out.println(opponent.getName() + " hit " + getName() +
// 								" for <" + hitPoints + "> points damage.");
// 			System.out.println(getName() + " now has " +
// 								getHitPoints() + " hit points remaining.");
// 			System.out.println("---------------------------------------------");
// 		}//end else if
// 
// 		if (this.hitPoints == 0)
// 			System.out.println("\n" + name + " has been killed :-(");
// 		heal();
// 
//  }//end method

    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        heal();
    }
 
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
// public void attack(Hero opponent)
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
// 							" failed!\n");
// }//end else
// 
//  	}//end attack method
 
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
// }//end isAlive method


}//end Monster class