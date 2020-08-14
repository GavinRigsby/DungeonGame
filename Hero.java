public abstract class Hero extends DungeonCharacter{

    private int numTurns;
    private int[] inventory; //[healthPotions, visionPotions]
    private int pillarsFound;
    private Details herodetails;
    private int[] coords;
    private String steps = "";

    public Hero(final String name, final Details details) {
    	super(name, details);
        herodetails = details;
        setInventory();
        setPillars();
    }
    
    public void setCoords(int x, int y) {
    	coords = new int[] {x,y};
    	if (steps != "") {
    		int oldx = Integer.parseInt(steps.substring(steps.length() - 3, steps.length() - 2));
        	int oldy = Integer.parseInt(steps.substring(steps.length() - 1, steps.length()));
        	if (oldx > x) {
        		steps += "\nmoved north to room at " + x + "," + y;
        	}else if(oldx < x) {
        		steps += "\nmoved south to room at " + x + "," + y;
        	}
        	if (oldy > y) {
        		steps += "\nmoved east to room at " + x + "," + y;
        	}else if(oldy < y) {
        		steps += "\nmoved west to room at " + x + "," + y;
        	}
        	
    	}
    	
    }
    
    public void stepStart(int x, int y) {
    	steps = "started at room at " + x + "," + y;
    }
    
    public int[] getCoords(){
    	return coords;
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
        return Math.random() <= herodetails.getChanceToBlock();
    }

    public void battleChoices(final DungeonCharacter opponent) {
        if (opponent == null)
            throw new IllegalArgumentException("Opponent passed as null...");

        setNumTurns(herodetails.getAttackSpeed() / opponent.getAttackSpeed());
        if (getNumTurns() == 0) {
            setNumTurns(getNumTurns() + 1);
        }
        System.out.println("Number of turns this round is: " + getNumTurns());
    }

    public void subtractHitPoints(final int hp, final DungeonCharacter opponent) {
        if (defend()) {
            System.out.println(super.getName() + " Blocked the attack!");
        } else {
            super.subtractHitPoints(hp, opponent);
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
            //random value between 15 and 25
            int randomincrease = (int) (Math.random()*(25-15))+15;
            System.out.println("You used a healing potion and healed [" + randomincrease + "] hitpoints");
            this.addHitPoints(randomincrease);
        }else
            System.out.println("Whoops...No Health Potions in your Inventory!\n");
    }
    
    public void traceMySteps() {
    	System.out.println(steps + " (you are here now)\n");
    }

    public void addVisionPotion() {
        this.inventory[1]++;
    }

    public boolean useVisionPotion () {

    	if(this.inventory[1] > 0) {
            this.inventory[1]--;
            return true;
        }else {
        	System.out.println("Whoops...No Vision Potions in your Inventory!\n");
        	return false;
        } 
    }

    @Override
    public String toString() {
        return "Hero name: " + getName() + "\n"
                + "Hitpoints: " + super.getHitPoints() + "\n"
                + "Total Healing Potions: " + this.inventory[0] + "\n"
                + "Total Vision Potions: " + this.inventory[1] + "\n"
                + "Total Pillars of OO Found: " + this.pillarsFound + "/4\n";
    }
}