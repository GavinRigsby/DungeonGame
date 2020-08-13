public abstract class Hero extends DungeonCharacter implements Attack {

    private int numTurns;
    private int[] inventory; //[healthPotions, visionPotions]
    private int pillarsFound;

    public Hero(final String name, final Details details) {
        super(name, details);
        setInventory();
        setPillars();
    }

    public String getName() {
        return super.getName();
    }

    public void setNumTurns(final int numTurns) {
        this.numTurns = numTurns;
    }

    public int getNumTurns() {
        return this.numTurns;
    }

    public boolean defend() {
        return Math.random() <= super.getDetails().getChanceToBlock();
    }

    public void attack(DungeonCharacter opponent) {
        super.attack(opponent);
    }

    public void battleChoices(final DungeonCharacter opponent) {
        if (opponent == null)
            throw new IllegalArgumentException("Opponent passed as null...");

        setNumTurns(super.getDetails().getAttackSpeed() / opponent.getDetails().getAttackSpeed());
        if (getNumTurns() == 0) {
            setNumTurns(getNumTurns() + 1);
        }
        System.out.println("Number of turns this round is: " + getNumTurns());
    }

    public void subtractHitPoints(final int hp) {
        if (defend()) {
            System.out.println(super.getName() + " Blocked the attack!");
        } else {
            super.subtractHitPoints(hp);
        }
    }

    public void addHitPoints(final int hp) {
        super.addHitPoints(hp);
    }

    private void setInventory() {
        this.inventory = new int[]{0, 0};
    }

    public int[] getInventory() {
        return this.inventory;
    }

    private void setPillars() {
        this.pillarsFound = 0;
    }

    public int getPillarsFound() {
        return this.pillarsFound;
    }

    public void addPillar() {
        this.pillarsFound++;
    }


    public void addHealthPotion() {
        this.inventory[0]++;
    }

    public void useHealthPotion() {
        if(this.inventory[0] > 0) {
            this.inventory[0]--;
            this.addHitPoints(15);
        }else
            System.out.println("Whoops...No Health Potions in your Inventory!");
    }

    public void addVisionPotion() {
        this.inventory[1]++;
    }

    public void useVisionPotion () {

        System.out.println("Whoops...No Vision Potions in your Inventory!");
        
    }// Needs Work...

    @Override
    public String toString() {
        return "Hero name: " + getName() + "\n"
                + "Hitpoints: " + super.getHitPoints() + "\n"
                + "Total Healing Potions: " + this.inventory[0] + "\n"
                + "Total Vision Potions: " + this.inventory[1] + "\n"
                + "Total Pillars of OO Found: " + getFoundPillars();
    }
}