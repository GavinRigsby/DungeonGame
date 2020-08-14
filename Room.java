
public class Room {

	private int[] Coordinates;
	private String room = "";
	private boolean[] contents;
	private String contentstring;
	
	public Room(boolean pit, boolean monster, boolean entrance, boolean exit, boolean visionpotion, boolean healingpotion, int pillar, int size, int x, int y){
		Coordinates = new int[] {x,y};
		String content = "";
		boolean haspillar = false;
		if (pillar != -1) {
			haspillar = true;
			content = Integer.toString(pillar);
		}
		contents = new boolean[] {pit, monster, entrance, exit, visionpotion, healingpotion, haspillar};
		if ((pit || monster || entrance || exit || visionpotion || healingpotion || haspillar) == false) {
			content = "E";
		}
		else {
			if(pit) {
				content = "P";
			}
			if(monster) {
				if(content == "") {
					content = "X";
				}
				else {
					content = "M";
				}
			}
			if(entrance) {
				if(content == "") {
					content = "I";
				}
			}
			if(exit) {
				if(content == "") {
					content = "O";
				}
			}
			if(visionpotion) {
				if(content == "") {
					content = "V";
				}
				else {
					content = "M";
				}
			}
			if(healingpotion) {
				if(content == "") {
					content = "H";
				}
				else {
					content = "M";
				}
			}	
		}
		
		//top wall
		if (x == 0) {
			room += "***\n";
		}else {
			room += "*-*\n";
		}
		//middle section
		if (y == 0){
			room += "*" + content + "|\n";
		}
		else if (y == size-1){
			room += "|" + content + "*\n";
		}
		else {
			room += "|" + content + "|\n";
		}
			
		//bottom wall
		if (x == size-1) {
			room += "***\n";
		}else {
			room += "*-*\n";
		}
		contentstring = content;
	}
	
	public int[] getCoordinates() {
		return Coordinates;
	}
	
	public String getContentString() {
		return contentstring;
	}
	
	public String getRoom() {
		return room;
	}
	
	public String getItemContents(){
		String itemstring = "This room contains ";
		if (contents[2]) {
			return itemstring + "the enterance";
		}
		if (contents[3]) {
			
			return itemstring + "the exit";
		}
		if (contents[6]) {
			
			return itemstring + "a pillar of OO";
		}
		
		String items = "";
		if (contents[0]) {
			items += "a pit";
		}
		//can specify monster later
		if (contents[1]) {
			if (items != "") {
				items += ",";
			}
			items += "a monster";
		}
		if (contents[4]) {
			if (items != "") {
				items += ",";
			}
			items += "a vision potion";
		}
		if (contents[5]) {
			if (items != "") {
				items += ",";
			}
			items += "a healing potion";
		}
		if (items == "") {
			items = "nothing";
		}
		if (items.contains(",")){
			int lastcomma = items.lastIndexOf(',');
			items = items.substring(0, lastcomma) + " and " + items.substring(lastcomma + 1);
		}
		return itemstring + items + "\n";
	}
	
	public String toString(){
		return room + "\n" + getItemContents();
	}
}
