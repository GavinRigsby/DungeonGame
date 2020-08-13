public class Bowler extends Monster {

    public Bowler() {
        super("Benny the Bowler", Details.getBowlerDetails());
    }

    public void Attack(DungeonCharacter opponent) {
        System.out.println(super.getName() + " hucks a big boulder at " + opponent.getName() + ":");
        super.attack(opponent);
    }
}