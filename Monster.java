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
        super.addHitPoints(hp);
        System.out.println(super.getName() + " healed themself for [" + hp + "] points.\n" + super.getName() + " has " + super.getHitPoints() + " hit points remaining");
        System.out.println();
    }

    public void subtractHitPoints(final int hp, final DungeonCharacter opponent) {
        super.subtractHitPoints(hp, opponent);
        this.heal();
    }
}
