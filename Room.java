
public class Room {

	private int[] Coordinates;
	private String room = "";
	private boolean[] contents;
	private String contentstring;
	
	public Room(boolean pit, boolean monster, boolean entrance, boolean exit, boolean visionpotion, boolean healingpotion, int size, int x, int y){
		Coordinates = new int[] {x,y};
		contents = new boolean[] {pit, monster, entrance, exit, visionpotion, healingpotion};
		String content = "";
		if ((pit || monster || entrance || exit || visionpotion || healingpotion) == false) {
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
				else {
					content = "M";
				}
			}
			if(exit) {
				if(content == "") {
					content = "O";
				}
				else {
					content = "M";
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
		else if (y == size){
			room += "|" + content + "*\n";
		}
		else {
			room += "|" + content + "|\n";
		}
			
		//bottom wall
		if (x == size) {
			room += "***\n";
		}else {
			room += "*-*\n";
		}
		contentstring = content;
		
		
		System.out.println("Room at " + x + "," + y + "\n" + room);
		System.out.println(getItemContents());
	}
	
	public int[] getCoordinates() {
		return Coordinates;
	}
	
	public String getContentString() {
		return contentstring;
	}
	
	public String getItemContents(){
		String itemstring = "This room contains ";
		if (contents[2]) {
			return itemstring + "the enterance";
		}
		if (contents[3]) {
			
			return itemstring + "the exit";
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
}
