import java.util.Scanner;

public abstract class DungeonCharacter
{

   private String name;
   private int hitPoints;
   private int attackSpeed;
   private double chanceToHit;
   private int damageMin, damageMax;



//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	protected DungeonCharacter(String name, Details details)
	{
	  if (this instanceof Hero) {
		  setHeroName();
	  }
	  else {
		  setName(name);  
	  }
      setHitPoints(details.getHealthPoints());
      setAttackSpeed(details.getAttackSpeed());
      setChanceToHit(details.getChanceToHit());
      int mindamage = details.getDamageRange()[0];
      int maxdamage = details.getDamageRange()[1];
      setDamageRange(mindamage,maxdamage);

	}//end constructor

   public void setHitPoints(final int hitPoints) { 
        this.hitPoints = hitPoints; 
    }

   public void setName(String name) {
        this.name = name;
    }
   
   public void setHeroName() {
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your hero's name: ");
		String name = sc.nextLine();
		setName(name);
   }

   public void setAttackSpeed(final int attackSpeed) { 
        this.attackSpeed = attackSpeed; 
    }
    
    public void setChanceToHit(final double chanceToHit) { 
        this.chanceToHit = chanceToHit; 
    }
    
    public void setDamageRange(final int damageMin, final int damageMax){ 
        this.damageMin = damageMin; 
        this.damageMax = damageMax; 
    }

//-----------------------------------------------------------------
	public String getName()
	{
		return name;
	}//end getName

//-----------------------------------------------------------------
	public int getHitPoints()
	{
		return hitPoints;
	}//end getHitPoints
//-----------------------------------------------------------------
	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed


/*-------------------------------------------------------
addHitPoints is used to increment the hitpoints a dungeon character has

Receives: number of hit points to add
Returns: nothing

This method calls: nothing
This method is called by: heal method of monsters and Sorceress
---------------------------------------------------------*/
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
			System.out.println(this.getName() + " now has " + this.getHitPoints() + " hitpoints\n");
		}
	}//end addHitPoints method

/*-------------------------------------------------------
subtractHitPoints is used to decrement the hitpoints a dungeon character has.
It also reports the damage and remaining hit points (these things could be
done in separate methods to make code more modular ;-)

Receives: number of hit points to subtract
Returns: nothing

This method calls: nothing
This method is called by: overridden versions in Hero and Monster
---------------------------------------------------------*/
	public void subtractHitPoints(int hitPoints, DungeonCharacter opponent)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(opponent.getName() + " hit " + getName() +
								" for <" + hitPoints + "> points damage.");
			System.out.println( getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");


	}//end method

/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking hit points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------*/
//     public boolean isAlive()
// 	{
// 	  return (hitPoints > 0);
// 	}//end isAlive method

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
	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageMax - damageMin + 1))
						+ damageMin ;
                  
			opponent.subtractHitPoints(damage, this);
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

//-----------------------------------------------------------------



}//end class Character