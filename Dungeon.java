
public class Dungeon {
	private Room[][] dungeon;
	private int Size; 
	private int[] EntranceCoords;
	private int[] ExitCoords;
	
	public Dungeon(int size) {
		dungeon = new Room[size][size];
		Size = size;
		//Sets up entrance, exit, and pillars of OO
		int entrancex = (int) (Math.random() * size);
		int entrancey = (int) (Math.random() * size);
		EntranceCoords = new int[] {entrancex, entrancey};
		int exitx = (int) (Math.random() * size);
		int exity = (int) (Math.random() * size);
		ExitCoords = new int[] {exitx,exity};
		int pillar1x = (int) (Math.random() * size);
		int pillar1y = (int) (Math.random() * size);
		int pillar2x = (int) (Math.random() * size);
		int pillar2y = (int) (Math.random() * size);
		int pillar3x = (int) (Math.random() * size);
		int pillar3y = (int) (Math.random() * size);
		int pillar4x = (int) (Math.random() * size);
		int pillar4y = (int) (Math.random() * size);
		String[] specrooms = {entrancex + ","+ entrancey, exitx + "," + exity, pillar1x + "," +pillar1y, pillar2x + "," + pillar2y, pillar3x + "," + pillar3y, pillar4x + "," + pillar4y};
		specrooms = VerifyItemSpecificRooms(specrooms, size);
		entrancex = Integer.parseInt(specrooms[0].substring(0, 1));
		entrancey = Integer.parseInt(specrooms[0].substring(2, 3));
		exitx = Integer.parseInt(specrooms[1].substring(0, 1));
		exity = Integer.parseInt(specrooms[1].substring(2, 3));
		pillar1x = Integer.parseInt(specrooms[2].substring(0, 1));
		pillar1y = Integer.parseInt(specrooms[2].substring(2, 3));
		pillar2x = Integer.parseInt(specrooms[3].substring(0, 1));
		pillar2y = Integer.parseInt(specrooms[3].substring(2, 3));
		pillar3x = Integer.parseInt(specrooms[4].substring(0, 1));
		pillar3y = Integer.parseInt(specrooms[4].substring(2, 3));
		pillar4x = Integer.parseInt(specrooms[5].substring(0, 1));
		pillar4y = Integer.parseInt(specrooms[5].substring(2, 3));
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				//make entrance
				if (i == entrancex && j == entrancey) {
					dungeon[i][j] = new Room(false, false, true, false, false, false, -1, size, i, j);	
				}
				//make exit
				else if (i == exitx && j == exity) {
					dungeon[i][j] = new Room(false, false, false, true, false, false, -1, size, i, j);
				}
				//make pillars
				else if (i == pillar1x && j == pillar1y) {
					dungeon[i][j] = new Room(false, false, false, false, false, false, 1, size, i, j);
				}
				else if (i == pillar2x && j == pillar2y) {
					dungeon[i][j] = new Room(false, false, false, false, false, false, 2, size, i, j);
				}
				else if (i == pillar3x && j == pillar3y) {
					dungeon[i][j] = new Room(false, false, false, false, false, false, 3, size, i, j);
				}
				else if (i == pillar4x && j == pillar4y) {
					dungeon[i][j] = new Room(false, false, false, false, false, false, 4, size, i, j);
				}
				
				//make other room
				else {
					//Chance of item spawn change decimal to change rates
					boolean monsterchance = (Math.random() > .75);
					boolean pitchance = (Math.random() > .9);
					boolean healingchance = (Math.random() > .9);
					boolean visionchance = (Math.random() > .9);
					dungeon[i][j] = new Room(pitchance, monsterchance, false, false, visionchance, healingchance, -1, size, i, j);
				}
			}
		}
	}
	
	public Room getRoom(int x, int y){
		return dungeon[x][y];
	}
	
	public void setRoom (int x, int y, Room room){
		dungeon[x][y] = room;
	}
	
	public int[] getEntrance(){
		return EntranceCoords;
	}
	public int[] getExit() {
		return ExitCoords;
	}
	
	private String[] VerifyItemSpecificRooms(String[] specificrooms, int size) {
		String test = "";
		for (int i = 0; i < specificrooms.length; i++) {
			if (test.contains(specificrooms[i])) {
				switch(i) {
					case 0:
						int entrancex = (int) (Math.random() * size);
						int entrancey = (int) (Math.random() * size);
						specificrooms[0] = entrancex + "," + entrancey;
					case 1:
						int exitx = (int) (Math.random() * size);
						int exity = (int) (Math.random() * size);
						specificrooms[1] = exitx + "," + exity;
					case 2:
						int pillar1x = (int) (Math.random() * size);
						int pillar1y = (int) (Math.random() * size);
						specificrooms[2] = pillar1x + "," + pillar1y;
					case 3:
						int pillar2x = (int) (Math.random() * size);
						int pillar2y = (int) (Math.random() * size);
						specificrooms[3] = pillar2x + "," + pillar2y;
					case 4:
						int pillar3x = (int) (Math.random() * size);
						int pillar3y = (int) (Math.random() * size);
						specificrooms[4] = pillar3x + "," + pillar3y;
					case 5:
						int pillar4x = (int) (Math.random() * size);
						int pillar4y = (int) (Math.random() * size);
						specificrooms[5] = pillar4x + "," + pillar4y;
				}
				return VerifyItemSpecificRooms(specificrooms, size);
			}
			test += "   ";
		}
		return specificrooms;
	}
	
	public void Vision(int x, int y) {
		String vision= "";
		for (int i = -1; i < 2; i++) {
			String topstring = "";
			String middlestring = "";
			String bottomstring = "";
			for (int j = -1; j < 2; j++){
				String content = "";
				try {
					content = dungeon[x + i][y + j].getRoom();
					String[] split = content.split("\n");
					for (int h = 0; h < 3; h++) {
						String sub =  split[h].substring(0,2);
						if (h == 0) {
							topstring += sub;
						}
						if (h == 1) {
							middlestring += sub;
						}
						//System.out.println(split[h].substring(0,2));
					}
					if(i == 1 && x == Size - 2) {
						bottomstring += "**";
					}
					else if (i == 0 && x == Size - 1){
						bottomstring += "**";
					}
					else{
						bottomstring += "*-";
					}
					
				}
				catch(Exception e) {}
			}
			String middleend = "";
			if(y == Size - 2) {
				try {
					if (dungeon[x][y+1].getRoom().split("\n")[1].substring(1).contains("|")) {
						middleend = "|";
					}
					else {
						middleend = "*";
					}
				}
				catch (Exception e) {
					middleend = "*";
				}
			}
			else if (y == Size - 1) {
				try {
					if (dungeon[x][y].getRoom().split("\n")[1].substring(1).contains("|")) {
						middleend = "|";
					}
					else {
						middleend = "*";
					}
				}
				catch (Exception e) {
					middleend = "*";
				}
			}else {
				middleend = "|";
			}
			
			vision += topstring;
			if (topstring != "") {
				vision += "*" + "\n" + middlestring + middleend + "\n";
			}
			if (i == 1 || (i == 0 && x == Size - 1)) {
				if (i == 0 && x == Size - 1 && (y == Size - 1 || y == Size - 2)) {
					vision += bottomstring;
				}else {
					vision += bottomstring + "*";
				}
				
			}
			
		}
		System.out.println("\n"+vision+"\n");
	}
	
	
	//prints all the rooms and their contents as well as full map of dungeon
	public String toString() {
		String fullmap = "";
		String roomcontents = "";
		String separator = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
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
				roomcontents += dungeon[i][j].toString() + "\n" + separator;
			}
			//bottomline is only set on very bottom
			//every other is taken care of by topstring
			if (bottomstring != "") {
				bottomstring += "*\n";
			}
			//adds last * at end of every line then adds new line;
			fullmap += topstring + "* \n" + middlestring + "* \n" + bottomstring;
		}
		return roomcontents + fullmap;
	}
}
