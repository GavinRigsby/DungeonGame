public class Golem extends Monster {

    public Golem() {
        super("Greg the Golem", Details.getGolemDetails());
    }

    public void Attack(DungeonCharacter opponent) {
        System.out.println(super.getName() + " rises and slams his fist at " + opponent.getName() + ":");
        super.attack(opponent);
    }
}