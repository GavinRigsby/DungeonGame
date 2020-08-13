public class Bowler extends Monster {

    public Bowler() {
        super("Benny the Bowler", Details.getBowlerDetails());
    }

    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(super.getName() + " hucks a big boulder at " + opponent.getName() + ":");
        super.attack(opponent);
    }
}