import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;

/**
 * Test class for the Item class.
 * @author Leo Colabrese
 *
 */

public class ItemTest {

    private Item item;
    /**
     * This method initializes an Item object for testing
     */
    @BeforeEach
    public void setUp() {
        // Initialize a default Item object before each test
        System.out.println("Setting up test environment for Item class.");
        item = new Item("TestItem", "TestDescription", true, false, true, false, 100);
    }
    /**
    * Test of getName method, of class Item.
    */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("TestItem", item.getName());
    }
    /**
     * Test of setName method, of class Item.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        item.setName("NewName");
        assertEquals("NewName", item.getName());
    }
    /**
     * Test of getDescription method, of class Item.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        assertEquals("TestDescription", item.getDescription());
    }
    /**
     * Test of setDescription method, of class Item.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        item.setDescription("NewDescription");
        assertEquals("NewDescription", item.getDescription());
    }
    /**
     * Test of getHeal method, of class Item.
     */
    @Test
    public void testGetHeal() {
        System.out.println("getHeal");
        assertTrue(item.getHeal());
    }
    /**
     * Test of setHeal method, of class Item.
     */
    @Test
    public void testSetHeal() {
        System.out.println("setHeal");
        item.setHeal(false);
        assertFalse(item.getHeal());
    }
    /**
     * Test of getBlock method, of class Item.
     */
    @Test
    public void testGetBlock() {
        System.out.println("getBlock");
        assertFalse(item.getBlock());
    }
    /**
     * Test of setBlock method, of class Item.
     */
    @Test
    public void testSetBlock() {
        System.out.println("setBlock");
        item.setBlock(true);
        assertTrue(item.getBlock());
    }
    /**
     * Test of getStrength method, of class Item.
     */
    @Test
    public void testGetStrength() {
        System.out.println("getStrength");
        assertTrue(item.getStrength());
    }
    /**
     * Test of setStrength method, of class Item.
     */
    @Test
    public void testSetStrength() {
        System.out.println("setStrength");
        item.setStrength(false);
        assertFalse(item.getStrength());
    }
    /**
     * Test of getDouble method, of class Item.
     */
    @Test
    public void testGetDouble() {
        System.out.println("getDouble");
        assertFalse(item.getDouble());
    }
    /**
     * Test of setDouble method, of class Item.
     */
    @Test
    public void testSetDouble() {
        System.out.println("setDouble");
        item.setDouble(true);
        assertTrue(item.getDouble());
    }
    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        assertEquals(100, item.getPrice());
    }
    /**
     * Test of setPrice method, of class Item.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        item.setPrice(200);
        assertEquals(200, item.getPrice());
    }
}
