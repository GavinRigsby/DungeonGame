import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestHero {

static Hero test;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		test = new Warrior();
	}


	@Test
	void testSetCoords() {
		test.setCoords(0, 1);
		int x = test.getCoords()[0];
		int y = test.getCoords()[1];
		assertEquals(0,x);
		assertEquals(1,y);
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
		test.subtractHitPoints(50, new Skeleton());
		//can heal
		assertEquals(health - 50 , test.getHitPoints());
	}
	
	@Test
	void testHealingPotion() {
		int hp = test.getHitPoints();
		assertEquals(test.getInventory()[0] , 0);
		test.addHealthPotion();
		assertEquals(test.getInventory()[0] , 1);
		test.useHealthPotion();
		assertEquals(test.getInventory()[0] , 0);
		assertTrue(hp < test.getHitPoints());
	}
	
	@Test
	void testVisionPotion() {
		assertEquals(test.getInventory()[1] , 0);
		test.addVisionPotion();
		assertEquals(test.getInventory()[1] , 1);
		assertTrue(test.useVisionPotion());
	}
	
}



