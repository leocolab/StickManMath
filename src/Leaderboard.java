import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

/**
 * Leaderboard class used to open the MainMenu window.
 * @author Samuel Angarita
 *
 */
public class Leaderboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Leaderboard method. Opens Leaderboard window.
	 * The Leaderboard window displays the 10 users with the most progress in the game. 
	 * You can use the Back button to go back to the MainMenu Window
	 * 
	 * @param player an Object of Player.
	 */
	public Leaderboard(Player player) {
		
		LeadBoard[] leaderBoard = topTen("Main_Game_File.csv");//calls method and returns object array of the top 10
		
		//Window
		setTitle("Leaderboard");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title label
		JLabel TitleLabel = new JLabel("Leaderboard");
		TitleLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 80));
		TitleLabel.setBounds(204, 10, 441, 80);
		contentPane.add(TitleLabel);
		
		
		//Back Button
		JButton Back_button = new JButton("Back");
		Back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Back Button action
				
				//Opens MainMenu Window/GUI and Closes LeaderBoard Window/GUI
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				dispose();
				
			}
		});
		Back_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Back_button.setBounds(715, 429, 123, 33);
		contentPane.add(Back_button);
		
		//Table
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		table.setBackground(new Color(129, 158, 80));
		table.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		table.setRowHeight(29);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Position", "UserName", "Levels Completed", "Number of Coins"},
				{"1st", leaderBoard[0].getUsername(), leaderBoard[0].getLevel(), leaderBoard[0].getCoins()},
				{"2nd", leaderBoard[1].getUsername(), leaderBoard[1].getLevel(), leaderBoard[1].getCoins()},
				{"3rd", leaderBoard[2].getUsername(), leaderBoard[2].getLevel(), leaderBoard[2].getCoins()},
				{"4th", leaderBoard[3].getUsername(), leaderBoard[3].getLevel(), leaderBoard[3].getCoins()},
				{"5th", leaderBoard[4].getUsername(), leaderBoard[4].getLevel(), leaderBoard[4].getCoins()},
				{"6th", leaderBoard[5].getUsername(), leaderBoard[5].getLevel(), leaderBoard[5].getCoins()},
				{"7th", leaderBoard[6].getUsername(), leaderBoard[6].getLevel(), leaderBoard[6].getCoins()},
				{"8th", leaderBoard[7].getUsername(), leaderBoard[7].getLevel(), leaderBoard[7].getCoins()},
				{"9th", leaderBoard[8].getUsername(), leaderBoard[8].getLevel(), leaderBoard[8].getCoins()},
				{"10th", leaderBoard[9].getUsername(), leaderBoard[9].getLevel(), leaderBoard[9].getCoins()},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(200);
		table.getColumnModel().getColumn(2).setMaxWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setMinWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(250);
		
		table.setBounds(49, 100, 750, 319);
		contentPane.add(table);
		
		//Background
		JLabel Back_Image_label = new JLabel("");
		Back_Image_label.setBounds(0, 0, 862, 509);
		Back_Image_label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("LeaderBoard_Back.jpg")));
		contentPane.add(Back_Image_label);
		
	}
	
	/**
	 * topTen method. Creates an array of LeadBoard storing the top 10 best players in the game.
	 * @param filePath name of the file.
	 * @return array of LeadBoard size 10 with the 10 best users.
	 */
    public LeadBoard[] topTen(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + filePath))) {
            Map<String, Integer> levels = new HashMap<>();//for level progress
            Map<String, Integer> coins = new HashMap<>();//for number of coins
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    String username = parts[0].trim();
                    int score = Integer.parseInt(parts[4].trim());
                    int equalizer = Integer.parseInt(parts[3].trim());
                    levels.put(username, score);
                    coins.put(username, equalizer);
                }
            }
            return levels.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int scoreCompare = Integer.compare(e2.getValue(), e1.getValue());
                        if (scoreCompare != 0) {
                            return scoreCompare;
                        } else {
                            return Integer.compare(coins.get(e2.getKey()), coins.get(e1.getKey()));
                        }
                    })
                    .limit(10)
                    .map(entry -> new LeadBoard(entry.getKey(), entry.getValue(), coins.get(entry.getKey())))
                    .toArray(LeadBoard[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return new LeadBoard[0];
        }
    }
	
	
	
}
