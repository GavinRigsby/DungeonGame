public abstract class Monster extends DungeonCharacter implements Attack {

    public Monster(final String name, final Details details) {
        super(name, details);
    }

    public void heal() {
        boolean canHeal = (Math.random() <= super.getDetails().getChanceToHeal()) && (super.getHealthPoints() > 0);
        int hp = 0;
        int[] healRange = super.getDetails().getHealRange();
        if (canHeal) {
            hp = (int) (Math.random() * (healRange[1] - healRange[0] + 1)) + healRange[0];
            this.addHitPoints(hp);
        }
    }

    public void addHitPoints(final int hp) {
        super.addHitPoints(hp);
        System.out.println(super.getName() + " healed theirself for " + hp + " points.\n" + "Total hit points remaining: " + super.getHitPoints());
        System.out.println();
    }

    public void subtractHitPoints(final int hp) {
        super.subtractHitPoints(hp);
        this.heal();
    }
}
