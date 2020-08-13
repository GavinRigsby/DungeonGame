public class HeroFactory {
	public Hero createHero(final int choice)
	{
		if(choice < 1 || choice > 5)
			throw new IllegalArgumentException("Please choose a proper class.");
         
		if(choice == 1)
			return new Warrior();
		else if (choice == 2)
			return new Sorceress();
		else if(choice == 3)
			return new Thief();
		else if (choice == 4)
			return new ArcherQueen();
		else if (choice == 5)
			return new Healer();
		return new Thief();
	}
}