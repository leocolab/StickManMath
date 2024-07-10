import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Combat class
 * @author Leo Colabrese
 *
 */
class CombatTest {

    private Player testPlayer;
    private Combat testCombat;
    /**
     * This method initializes a Combat object for testing
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up test environment for Combat class.");
        // Initialize the Player with some default values
        testPlayer = new Player("standard", "testUser", 100, new Item[3], new boolean[5][5]);

        // Initialize the Combat instance for world 1, level 1 for testing
        testCombat = new Combat(1, 1, testPlayer);
    }
    /**
    * Test of getPlayerHealth method, of class Combat.
    */
    @Test
    public void testPlayerHealth() {
        System.out.println("getPlayerHealth");
        assertEquals(10, testCombat.getPlayerHealth(), "Player health should be initialized to 10.");
    }
    /**
     * Test of getEnemyHealth method, of class Combat.
     */
    @Test
    public void testEnemyHealth() {
        System.out.println("getEnemyHealth");
        assertEquals(15, testCombat.getEnemyHealth(), "Enemy health should be initialized based on world and level.");
    }
    /**
     * Test of getBaseEnemyHealth method, of class Combat.
     */
    @Test
    public void testBaseEnemyHealth() {
        System.out.println("getBaseEnemyHealth");
        assertEquals(15, testCombat.getBaseEnemyHealth(), "Base enemy health should be initialized based on world and level.");
    }
    /**
     * Test of getBasePlayerHealth method, of class Combat.
     */
    @Test
    public void testBasePlayerHealth() {
        System.out.println("getBasePlayerHealth");
        assertEquals(10, testCombat.getBasePlayerHealth(), "Base player health should be initialized to 10.");
    }
    /**
     * Test of getEnemyStrength method, of class Combat.
     */
    @Test
    public void testEnemyStrength() {
        System.out.println("getEnemyStrength");
        assertEquals(1, testCombat.getEnemyStrength(), "Enemy strength should be initialized based on world.");
    }
    /**
     * Test of getPlayerStrength method, of class Combat.
     */
    @Test
    public void testPlayerStrength() {
        System.out.println("getPlayerStrength");
        assertEquals(1, testCombat.getPlayerStrength(), "Player strength should be initialized to 1.");
    }
    /**
     * Test of getTime method, of class Combat.
     */
    @Test
    public void testTime() {
        System.out.println("getTime");
        assertEquals(15, testCombat.getTime(), "Time should be initialized based on level.");
    }
    /**
     * Test of getTime method, of class Combat.
     */
    @Test
    public void testBaseTime() {
        System.out.println("getBaseTime");
        assertEquals(15, testCombat.getBaseTime(), "Base time should be initialized based on level.");
    }
    /**
     * Test of getRewardGold method, of class Combat.
     */
    @Test
    public void testRewardGold() {
        System.out.println("getRewardGold");
        assertEquals(5, testCombat.getRewardGold(), "Reward gold should be initialized based on level.");
    }
    /**
     * Test of getBlock method, of class Combat.
     */
    @Test
    public void testBlock() {
        System.out.println("getBlock");
        assertFalse(testCombat.getBlock(), "Block should be initialized to false.");
    }
    /**
     * Test of getDoubleGold method, of class Combat.
     */
    @Test
    public void testDoubleGold() {
        System.out.println("getDoubleGold");
        assertFalse(testCombat.getDoubleGold(), "Double gold should be initialized to false.");
    }
    /**
     * Test of getPlayer method, of class Combat.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        assertEquals(testPlayer, testCombat.getPlayer(), "Get player should return the initialized player.");
    }
    /**
     * Test of setEnemyHealth method, of class Combat.
     */
    @Test
    public void testSetEnemyHealth() {
        System.out.println("setEnemyHealth");
        testCombat.setEnemyHealth(12);
        assertEquals(12, testCombat.getEnemyHealth(), "Setting enemy health should reflect correctly.");
    }
    /**
     * Test of setPlayerHealth method, of class Combat.
     */
    @Test
    public void testSetPlayerHealth() {
        System.out.println("setPlayerHealth");
        testCombat.setPlayerHealth(8);
        assertEquals(8, testCombat.getPlayerHealth(), "Setting player health should reflect correctly.");
    }
    /**
     * Test of setPlayerStrength method, of class Combat.
     */
    @Test
    public void testSetPlayerStrength() {
        System.out.println("setPlayerStrength");
        testCombat.setPlayerStrength(2);
        assertEquals(2, testCombat.getPlayerStrength(), "Setting player strength should reflect correctly.");
    }
    /**
     * Test of setTime method, of class Combat.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        testCombat.setTime(10);
        assertEquals(10, testCombat.getTime(), "Setting time should reflect correctly.");
    }
    /**
     * Test of setBaseTime method, of class Combat.
     */
    @Test
    public void testSetBaseTime() {
        System.out.println("setBaseTime");
        testCombat.setBaseTime();
        assertEquals(testCombat.getBaseTime(), testCombat.getTime(), "Setting base time should reset the time to its base value.");
    }
    /**
     * Test of setBlock method, of class Combat.
     */
    @Test
    public void testSetBlock() {
        System.out.println("setBlock");
        testCombat.setBlock(true);
        assertTrue(testCombat.getBlock(), "Setting block should reflect correctly.");
    }
    /**
     * Test of setDoubleGold method, of class Combat.
     */
    @Test
    public void testSetDoubleGold() {
        System.out.println("setDoubleGold");
        testCombat.setDoubleGold(true);
        assertTrue(testCombat.getDoubleGold(), "Setting double gold should reflect correctly.");
    }
    /**
     * Test of setRewardGold method, of class Combat.
     */
    @Test
    public void testSetRewardGold() {
        System.out.println("setRewardGold");
        testCombat.setRewardGold(20);
        assertEquals(20, testCombat.getRewardGold(), "Setting reward gold should reflect correctly.");
    }

}