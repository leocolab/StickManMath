import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for Combat class
 * @author Leo Colabrese
 *
 */
class LeadBoardTest {
	
	private LeadBoard lead;
	/**
     * This method initializes a LeadBoard object for testing
     */
	@BeforeEach
	public void setUp() {
		System.out.println("Setting up test environment for LeadBoard class.");
		lead = new LeadBoard("usr", 1, 69);
	}
	/**
	 * Test of getUsername method, of class LeadBoard.
	 */
	@Test
	public void testGetUsername() {
		System.out.println("getUsername");
		assertEquals("usr", lead.getUsername());
	}
	/**
	 * Test of setUsername method, of class LeadBoard.
	 */
	@Test
	public void testSetUsername() {
		System.out.println("setUsername");
		lead.setUsername("newUsr");
		assertEquals("newUsr", lead.getUsername());
	}
	/**
	 * Test of getLevel method, of class LeadBoard.
	 */
	@Test
	public void testGetLevel() {
		System.out.println("getLevel");
		assertEquals(1, lead.getLevel());
	}
	/**
	 * Test of setLevel method, of class LeadBoard.
	 */
	@Test
	public void testSetLevel() {
		System.out.println("setLevel");
		lead.setLevel(420);
		assertEquals(420, lead.getLevel());
	}
	/**
	 * Test of getCoins method, of class LeadBoard.
	 */
	@Test
	public void testGetCoins() {
		System.out.println("getCoins");
		assertEquals(69, lead.getCoins());
	}
	/**
	 * Test of setCoins method, of class LeadBoard.
	 */
	@Test
	public void testSetCoins() {
		System.out.println("setCoins");
		lead.setCoins(420);
		assertEquals(420, lead.getCoins());
	
	}
	/**
	 * Test of toString method, of class LeadBoard.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "Player{" +
                "username='" + "usr" + '\'' +
                ", level=" + "1" +
                ", coins=" + "69" +
                '}';
		assertEquals(expResult, lead.toString());
		
	}

}
