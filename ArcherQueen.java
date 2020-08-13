public class ArcherQueen extends Hero {

    public ArcherQueen() {
        super("Archer Queen", Details.getArcherQueenDetails());
    }

    public void createHealthPotion() {

        System.out.println(super.getName() + " attempts to create a health potion!");
        if (Math.random() < .4) {
            super.addHealthPotion();
            System.out.println("Success!\n");
        } else {
            System.out.println("Whoops...Attempt failed!\n");
        }
    }

    public void createVisionPotion() {

        System.out.println(super.getName() + " attempts to create a vision potion!");
        if (Math.random() < .05) {
            super.addVisionPotion();
            System.out.println("Success!\n");
        } else {
            System.out.println("Whoops...Attempt failed!\n");
        }
    }

    public void Attack(DungeonCharacter opponent) {
        if (opponent == null)
            throw new IllegalArgumentException("Opponent passed as null...");

        System.out.println(super.getName() + " shoots an arrow at " + opponent.getName() + ":");
        super.attack(opponent);
    }

    public void battleChoices(DungeonCharacter opponent) {
        if (opponent == null)
            throw new IllegalArgumentException("Opponent passed as null...");

        super.battleChoices(opponent);
        int choice;

        do {
            System.out.println("1) Attack Opponent");
            System.out.println("2) Create a Health Potion");
            System.out.println("3) Create a Vision Potion");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();
            System.out.println("--------------------------------------------------\n");

            switch (choice)
		    {
			    case 1: this.attack(opponent);
			        break;
			    case 2: this.createHealthPotion();
			        break;
             case 3: this.createVisionPotion();
                 break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

            super.setNumTurns(super.getNumTurns() - 1);
            if (super.getNumTurns() > 0)
                System.out.println("Number of turns remaining is: " + super.getNumTurns());
        } while (super.getNumTurns() > 0);

    }
}