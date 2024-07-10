/**
 * Represents an item with various attributes that can be used in the game.
 * This class encapsulates properties such as name, description, and various abilities or effects the item has, along with its price.
 * @author Leo Colabrese
 */
public class Item {
	 
	// Defining instance variables
	private String name;
	private String description;
	private boolean heal;
	private boolean block;
	private boolean strength;
	private boolean doubl;
	private int price;
	
	/**
     * Constructs an Item with specified attributes.
     * 
     * @param _name The name of the item.
     * @param _description A description of the item.
     * @param _heal Boolean value indicating if the item has healing ability.
     * @param _block Boolean value indicating if the item can block attacks.
     * @param _strength Boolean value indicating if the item enhances strength.
     * @param _doubl Boolean value indicating if the item doubles certain benefits.
     * @param _price The price of the item.
     */
	public Item(String _name, String _description, boolean _heal, boolean _block, boolean _strength, boolean _doubl, int _price) {
		name = _name;
		description = _description;
		heal = _heal;
		block = _block;
		strength = _strength;
		doubl = _doubl;
		price = _price;
		
	}
	/** Gets name of item
	 * @return name of item
	 */
	public String getName() {
		return name;
	}
	/** Gets description of item
	 * @return description of item
	 */
	public String getDescription() {
		return description;
	}
	/** Gets heal property
	 * @return state of heal capabilities
	 */
	public boolean getHeal() {
		return heal;
	}
	/** Gets block property
	 * @return state of block capabilities
	 */
	public boolean getBlock() {
		return block;
	}
	/** Gets strength property
	 * @return state of strength capabilities
	 */
	public boolean getStrength() {
		return strength;
	}	
	/** Gets double property
	 * @return state of double capabilities
	 */
	public boolean getDouble() {
		return doubl;
	}
	/** Gets price of item
	 * @return price of item
	 */
	public int getPrice() {
		return price;
	}
	/** Sets name of item */
	public void setName(String _name) {
		name = _name;
	}
	/** Sets description of item */
	public void setDescription(String des) {
		description = des;
	}
	/** Sets heal property of item */
	public void setHeal(boolean _heal) {
		heal = _heal;
	}
	/** Sets block property of item */
	public void setBlock(boolean _block) {
		block = _block;
	}
	/** Sets heal strength property of item */
	public void setStrength(boolean _strength) {
		strength = _strength;
	}
	/** Sets heal double property of item */
	public void setDouble(boolean _doubl) {
		doubl = _doubl;
	}
	/** Sets price of item */
	public void setPrice(int _price) {
		price = _price;
	}
}