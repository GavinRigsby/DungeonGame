import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestDungeon {

	static Dungeon test;
	static Hero h;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		test = new Dungeon(7);
		h = new Warrior();
	}

	@Test
	void testDungeon() {
		assertTrue(test.toString().contains("enterance"));
		assertTrue(test.toString().contains("exit"));
		assertTrue(test.toString().contains("pillar of OO"));
		assertTrue(test.toString().contains("vision potion"));
		assertTrue(test.toString().contains("healing potion"));
		assertTrue(test.toString().contains("monster"));
	}
	
	@Test
	void testMovement() {
		int ex = test.getEntrance()[0];
		int ey = test.getEntrance()[1];
		h.setCoords(ex, ey);
		int x = h.getCoords()[0];
		int y = h.getCoords()[1];
		
		if (x == 0) {
			h.setCoords(x + 1, y);
			assertEquals(x+1,h.getCoords()[0]);
		}
		if (x == 6) {
			h.setCoords(x - 1, y);
			assertEquals(x-1,h.getCoords()[0]);
		}
		if (y == 0) {
			h.setCoords(x, y + 1);
			assertEquals(y+1,h.getCoords()[1]);
		}
		if (y == 6) {
			h.setCoords(x, y - 1);
			assertEquals(y-1,h.getCoords()[1]);
		}
		h.setCoords(x, y);
		assertEquals(x,h.getCoords()[0]);
		assertEquals(y,h.getCoords()[1]);
		
	}
}
