public abstract class Monster extends DungeonCharacter{

	private Details monsterdetails;
    public Monster(final String name, final Details details) {
        super(name, details);
        monsterdetails = details;
    }

    public void heal() {
        boolean canHeal = (Math.random() <= monsterdetails.getChanceToHeal()) && (monsterdetails.getHealthPoints() > 0);
        int hp = 0;
        int[] healRange = monsterdetails.getHealRange();
        if (canHeal) {
            hp = (int) (Math.random() * (healRange[1] - healRange[0] + 1)) + healRange[0];
            this.addHitPoints(hp);
        }
    }

    public void addHitPoints(final int hp) {
    	System.out.println(super.getName() + " healed themself for [" + hp + "] points.\n");
        super.addHitPoints(hp);
        System.out.println();
    }

    public void subtractHitPoints(final int hp, final DungeonCharacter opponent) {
        super.subtractHitPoints(hp, opponent);
        this.heal();
    }

	public void randomDrop(Hero opponent) {
		if (Math.random() > .9) {
			System.out.println(this.getName() + "dropped a healing potion!");
			opponent.addHealthPotion();
		}
	}
}
