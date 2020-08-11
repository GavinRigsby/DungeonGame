public class MonsterFactory {
	public Monster createMonster(final int choice) {
		if(choice < 1 || choice > 3)
			throw new IllegalArgumentException("Please provide a supported monster type."); 
         
		if(choice == 1)
			return new Ogre();
		else if(choice == 2)
			return new Gremlin();
		else if(choice == 3)
			return new Skeleton();
		return new Skeleton();
	}
}