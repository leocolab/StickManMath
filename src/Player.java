
public class Player {
	private String accountType, username;
	private int gold;
	private Item [] items = new Item [3];
	private boolean [][] levelProgress = new boolean [5][5];
	private Item [] itemList = new Item[8];
	
	public Player(String accountType, String username, int gold, Item [] items, boolean [][] levelProgress) {
		this.accountType = accountType;
		this.username = username;
		this.gold = gold;
		
		for (int i = 0; i < 3; i++)
			this.items[i] = items[i];
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				this.levelProgress[i][j] = levelProgress[i][j];
		
		
		//List of Items to have access from an Object of Player
		Item Gold_Double = new Item("Gold Double","Doubles Your Coins",false,false,false,true,10);     
		Item Heal_Spell = new Item("Heal Spell","Heals from previous damage",true,false,false,false,10);
		Item Strength_Boost = new Item("Strength Boost","Gain strength",false,false,true,false,10);
		Item Power_Bar = new Item("Power Bar","Gain strength and heal",true,false,true,false,25);
		Item Gemstone = new Item("Gemstone","Double your coins and heal",true,false,false,true,25);
		Item Ring = new Item("Ring","Gain strenth and double coins",false,false,true,true,25);
		Item Mega_Boost = new Item("Mega Boost","Gain strength, heal, and get richer",true,false,true,true,40);
		Item Shield = new Item("Shield","Block enemy attacks",false,true,false,false,10);
		
		itemList[0]=Gold_Double;
		itemList[1]=Heal_Spell;
		itemList[2]=Strength_Boost;
		itemList[3]=Power_Bar;
		itemList[4]=Gemstone;
		itemList[5]=Ring;
		itemList[6]=Mega_Boost;
		itemList[7]=Shield;
		
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getGold() {
		return gold;
	}
	
	public Item [] getItems() {
		return items;
	}
	
	public boolean [][]getLevelProgress() {
		return levelProgress;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void setItems(Item [] items) {
		for (int i = 0; i < 3; i++)
			this.items[i] = items[i];
	}
	
	public void setItem(int x, Item item) {
		items[x] = item;
	}
	
	public void setLevelProgress(int x, int y, boolean value) {
		levelProgress[x][y] = value;
	}
}