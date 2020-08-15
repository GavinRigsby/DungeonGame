public class Healer extends Hero {

    public Healer() {
        super("Healer", Details.getHealerDetails());
    }

    public void heal() {
        int hp;
        int[] healRange = Details.getHealerDetails().getHealRange();

        hp = (int) (Math.random() * (healRange[1] - healRange[0] + 1)) + healRange[0];
        System.out.println(super.getName() + " added [" + hp + "] points.");
        super.addHitPoints(hp);
        System.out.println();
    }

    public void Attack(DungeonCharacter opponent) {
        if (opponent == null)
            throw new IllegalArgumentException("Opponent passed as null...");

        System.out.println(super.getName() + " brings a mace down to smite " + opponent.getName() + ":");
        super.attack(opponent);
    }

    public void battleChoices(DungeonCharacter opponent) {
        if (opponent == null)
            throw new IllegalArgumentException("Opponent passed as null...");

        super.battleChoices(opponent);
        int choice;

        do {
            System.out.println("1) Attack Opponent");
            System.out.println("2) Cast Heal");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();
            System.out.println("--------------------------------------------------\n");

            switch (choice)
		    {
			    case 1: this.attack(opponent);
			        break;
			    case 2: this.heal();
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