
/**
 * LeadBoard class used to stores values for some of the variables used in Leaderboard.java and Classroom.java
 * @author Samuel Angarita
 *
 */
public class LeadBoard {
    private String username;
    private int level;
    private int coins;

    /**
     * LeadBoard constructor. Initializes all the base values.
     * @param username UserName. 
     * @param level level progress. 
     * @param coins number of coins. 
     */
    public LeadBoard(String username, int level, int coins) {
        this.username = username;
        this.level = level;
        this.coins = coins;
    }

    /**
     * Method returns UserName.
     * @return UserName.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method sets the UserName.
     * @param username new UserName value. 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method returns level progress.
     * @return level progress.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Method sets level progress.
     * @param level new level progress.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Method returns number of coins.
     * @return number of coins.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Method sets number of coins.
     * @param coins number of coins.
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Method toString converts values into a String. 
     */
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", level=" + level +
                ", coins=" + coins +
                '}';
    }
}
