
public class Dungeon {
	private Room[][] dungeon;
	private int Size; 
	public Dungeon(int size) {
		dungeon = new Room[size][size];
		Size = size;
		int entrancex = (int) (Math.random() * size);
		int entrancey = (int) (Math.random() * size);
		int exitx = (int) (Math.random() * size);
		int exity = (int) (Math.random() * size);
		while(entrancex == exitx && entrancey == exity) {
			exitx = (int) (Math.random() * size);
			exity = (int) (Math.random() * size);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == entrancex && j == entrancey) {
					dungeon[i][j] = new Room(false, false, true, false, false, false, size, i, j);
				}
				else if (i == exitx && j == exity) {
					dungeon[i][j] = new Room(false, false, false, true, false, false, size, i, j);
				}
				else {
					boolean monsterchance = (Math.random() > .8);
					boolean pitchance = (Math.random() > .9);
					boolean healingchance = (Math.random() > .9);
					boolean visionchance = (Math.random() > .9);
					dungeon[i][j] = new Room(pitchance, monsterchance, false, false, visionchance, healingchance, size, i, j);
				}
			}
		}
	}
	
	public void GetFullMap() {
		String fullmap = "";
		for (int i = 0; i < Size; i++) {
			String topstring = "";
			String middlestring = "";
			String bottomstring = "";
			//go through arrays of dungeon
			//removes 3rd character for tiling
			for (int j = 0; j < Size; j++) {
				String content = dungeon[i][j].getContentString();
				//creates the horizontal spacing between all rooms
				if (i == 0) {
					topstring += "**";
				}
				else {
					topstring += "*-";
				}
				//creates bottom border of dungeon
				if(i == Size - 1) {
					bottomstring += "**";
				}
				
				//shows what content is in the rooms
				if (j == 0){
					middlestring += "*" + content;
				}
				else {
					middlestring += "|" + content;
				}
			}
			//bottomline is only set on very bottom
			//every other is taken care of by topstring
			if (bottomstring != "") {
				bottomstring += "*\n";
			}
			//adds last * at end of every line then adds new line;
			fullmap += topstring + "* \n" + middlestring + "* \n" + bottomstring;
		}
		System.out.println(fullmap);
	}
}
