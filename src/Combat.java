/**
 * Combat class stores values for all the variables used during combat
 * @author Matthew Nazaruk
 *
 */
public class Combat {
	private int enemyHealth, playerHealth, baseEnemyHealth, basePlayerHealth, playerStrength, enemyStrength, time, baseTime,rewardGold;
	private boolean block, doubleGold;
	private Player user;
	/**
	 * Combat constructor. Initializes all the base values depending on what level you are playing
	 * @param world current world
	 * @param level current level
	 * @param player data of the player attempting the level
	 */
	public Combat(int world, int level, Player player) {
		block = false;
		doubleGold = false;
		user = player;
		playerHealth = 10;
		basePlayerHealth = 10;
		playerStrength = 1;


		if(world == 4) {
			enemyHealth = 25;
			baseEnemyHealth = 25;
			enemyStrength = 2;
			time = 7;
			baseTime = 7;
			rewardGold = 50;
		}
		else {
			enemyStrength = 1;
			switch(level) {
			case 0:
				enemyHealth = 10;
				baseEnemyHealth = 10;
				time = 15;
				baseTime = 15;
				rewardGold = 5;
				break;
				
			case 1:
				enemyHealth = 15;
				baseEnemyHealth = 15;
				time = 15;
				baseTime = 15;
				rewardGold = 5;
				break;
				
			case 2:
				enemyHealth = 10;
				baseEnemyHealth = 10;
				time = 10;
				baseTime = 10;
				rewardGold = 5;
				break;
				
			case 3:
				enemyHealth = 15;
				baseEnemyHealth = 15;
				time = 10;
				baseTime = 10;
				rewardGold = 5;
				break;
				
			case 4:
				enemyHealth = 20;
				baseEnemyHealth = 20;
				time = 9;
				baseTime = 9;
				rewardGold = 10;
				break;
			}
		}
	}
	
	/**
	 * Method returns the enemy health
	 * @return enemy health
	 */
	public int getEnemyHealth() {
		return enemyHealth;
	}
	
	/**
	 * Method returns the players health
	 * @return player health
	 */
	public int getPlayerHealth() {
		return playerHealth;
	}
	
	/**
	 * Method returns the enemy initial health
	 * @return enemy initial health
	 */
	public int getBaseEnemyHealth() {
		return baseEnemyHealth;
	}
	
	/**
	 * Method returns initial player health
	 * @return initial player health
	 */
	public int getBasePlayerHealth() {
		return basePlayerHealth;
	}
	
	/**
	 * Method returns the enemy strength
	 * @return enemy strength
	 */
	public int getEnemyStrength() {
		return enemyStrength;
	}
	
	/**
	 * Method returns the players strength
	 * @return player strength
	 */
	public int getPlayerStrength() {
		return playerStrength;
	}
	
	/**
	 * Method returns how much time is left to answer a question
	 * @return time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Method returns how much time is given to answer a question
	 * @return initial time
	 */
	public int getBaseTime() {
		return baseTime;
	}
	
	/**
	 * Method returns the amount of gold gained upon level completion
	 * @return amount of gold to be earned
	 */
	public int getRewardGold() {
		return rewardGold;
	}
	
	/**
	 * Method returns whether the next enemy attack is to be blocked
	 * @return true to block, otherwise false
	 */
	public boolean getBlock() {
		return block;
	}
	
	/**
	 * Method returns whether the player will receive double the rewarded gold at the end of the level
	 * @return true if gold is doubled, otherwise false
	 */
	public boolean getDoubleGold() {
		return doubleGold;
	}
	
	/**
	 * Mehtod returns the player object storing the players data
	 * @return player object
	 */
	public Player getPlayer() {
		return user;
	}
	
	/**
	 * Method sets the enemy health to the given value
	 * @param health new health value
	 */
	public void setEnemyHealth(int health) {
		enemyHealth = health;
	}
	
	/**
	 * Method sets the players health to the given value
	 * @param health new health value
	 */
	public void setPlayerHealth(int health) {
		playerHealth = health;
	}
	
	/**
	 * Method sets the players strength to the new value
	 * @param strength new strength value
	 */
	public void setPlayerStrength(int strength) {
		playerStrength = strength;
	}
	
	/**
	 * Method sets how much time is left to answer the question
	 * @param time new time value
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * Method sets the time back to the starting value
	 */
	public void setBaseTime() {
		time = baseTime;
	}
	
	/**
	 * Method sets whether or not the next enemy attack will be blocked
	 * @param block true if to be blocked, otherwise false
	 */
	public void setBlock(boolean block) {
		this.block = block;
	}
	
	/**
	 * Method sets whether the player will receive double the reward gold
	 * @param doubleGold true if to be doubled, otherwise false
	 */
	public void setDoubleGold(boolean doubleGold) {
		this.doubleGold = doubleGold;
	}
	
	/**
	 * Method sets the amount of gold to be earned after level completion
	 * @param gold gold to be earned
	 */
	public void setRewardGold(int gold) {
		rewardGold = gold;
	}
}
