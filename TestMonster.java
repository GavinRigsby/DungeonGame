import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestMonster {

	static Monster test;
	static Hero h;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		test = new Bowler();
		h = new Warrior();
	}

	@Test
	void testheal() {
		int health = test.getHitPoints();
		for (int i = 0; i < 10; i ++) {
			test.heal();
		}
		assertTrue(health < test.getHitPoints());
	}
	
	@Test
	void testDrop() {
		for (int i = 0; i < 10; i ++) {
			test.randomDrop(h);
		}
		assertTrue(h.getInventory()[0] > 0);
	}
	@Test
	void testAddHP() {
		int health = test.getHitPoints();
		test.addHitPoints(25);
		assertEquals(health + 25 , test.getHitPoints());
	}
	
	@Test
	void testSubtractHP() {
		int health = test.getHitPoints();
		test.subtractHitPoints(50, h);
		//can heal
		assertTrue(health > test.getHitPoints());
	}

}
