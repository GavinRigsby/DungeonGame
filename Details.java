public class Details {

    private int healthPoints;
    private int attackSpeed;
    private double chanceToHit;
    private int minDamage, maxDamage;
    private double chanceToBlock;
    private double chanceToHeal;
    private int minHeal, maxHeal;

    public Details(final int healthPoints, final int attackSpeed, final double chanceToHit, final int minDamage, final int maxDamage, final double chanceToBlock, final double chanceToHeal, final int minHeal, final int maxHeal) {
        setHealthPoints(healthPoints);
        setAttackSpeed(attackSpeed);
        setChanceToHit(chanceToHit);
        setDamageRange(minDamage, maxDamage);
        setChanceToBlock(chanceToBlock);
        setChanceToHeal(chanceToHeal);
        setHealRange(minHeal, maxHeal);
    }

    public void setHealthPoints(final int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setAttackSpeed(final int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setChanceToHit(final double chanceToHit) {
        this.chanceToHit = chanceToHit;
    }

    public void setDamageRange(final int minDamage, final int maxDamage) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public void setHealRange(final int minHeal, final int maxHeal) {
        this.minHeal = minHeal;
        this.maxHeal = maxHeal;
    }

    public void setChanceToHeal(final double chanceToHeal) {
        this.chanceToHeal = chanceToHeal;
    }

    public void setChanceToBlock(final double chanceToBlock) {
        this.chanceToBlock = chanceToBlock;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public double getChanceToHit() {
        return this.chanceToHit;
    }

    public int[] getDamageRange() {
        int[] range = {this.minDamage, this.maxDamage};
        return range;
    }

    public int[] getHealRange() {
        int[] range = {this.minHeal, this.maxHeal};
        return range;
    }

    public double getChanceToHeal() {
        return this.chanceToHeal;
    }

    public double getChanceToBlock() {
        return this.chanceToBlock;
    }

    // Details(healthPoints, attackSpeed, chanceToHit, minDamage, maxDamage, 
    //         minHeal, maxHeal, chanceToBlock, chanceToHeal)
    
    public static Details getWarriorDetails() {
        return new Details(125, 4, .8, 35, 60, 0.2, 0.0, 0.0, 0.0);
    }

    public static Details getArcherQueenDetails() {
        return new Details(68, 4, .6, 13, 28, 0.0, .6, 18, 50);
    }

    public static Details getHealerDetails() {
        return new Details(75, 4, .3, 19, 40, 0.0, .9, 30, 55);
    }

    public static Details getSorceressDetails() {
        return new Details(75, 5, .7, 25, 50, .3, 0.0, 25, 50);
    }

    public static Details getThiefDetails() {
        return new Details(75, 6, .8, 20, 40, .5, 0.0, 0, 0);
    }

    public static Details getOgreDetails() {
        return new Details(200, 2, .6, 30, 50, 0.0, .1, 30, 50);
    }

    public static Details getSkeletonDetails() {
        return new Details(100, 3, .8, 15, 25, 0.0, .3, 30, 50);
    }

    public static Details getGremlinDetails() {
        return new Details(70, 5, .8, 5, 15, 0.0, .4, 20, 40);
    }

    public static Details getGolemDetails() {
        return new Details(120, 4, .6, 20, 50, 0.0, 0.1, 20, 50);
    }

    public static Details getBowlerDetails() {
        return new Details(70, 5, .7, 15, 35, 0.0, .5, 15, 30);
    }
}