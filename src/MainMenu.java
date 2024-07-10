import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


/**
 * MainMenu class used to open the MainMenu window.
 * @author Samuel Angarita
 *
 */
public class MainMenu extends JFrame {

	private JPanel contentPane;
	
	//for update method
	private BufferedReader reader;
	private BufferedWriter writer;
	private String line;
	private String [] data = new String[8], line2;


	/**
	 * MainMenu method. Opens MainMenu window.
	 * The MainMenu window is used to access the rest of the game.
	 * From here you will be able to use the buttons that each open a certain window.
	 * 
	 * @param player an Object of Player.
	 */
	public MainMenu(Player player) { 
		//Plays background music
		Music bckgdMusic = new Music(getClass().getClassLoader().getResource("MenuMusic.wav"));
		
		
		bckgdMusic.PlayMusic(true);
		//Window
		setTitle("Main Menu");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Saved Game button
		JButton SavedGame_button = new JButton("Saved Game");
		SavedGame_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stops music
				bckgdMusic.StopMusic();
				
				//Saved Game button action
				WorldSelect a=new WorldSelect();
				a.Worldselect(player, false);
				a.setResizable(false);
				a.setVisible(true);
				dispose();
				
			}
		});
		SavedGame_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		SavedGame_button.setBounds(329, 190, 190, 33);
		contentPane.add(SavedGame_button);
		
		//Title label
		JLabel TitleLabel = new JLabel("Stickman Math");
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 80));
		TitleLabel.setBounds(161, 23, 526, 80);
		contentPane.add(TitleLabel);
		
		//New Game button
		JButton NewGame_button = new JButton("New Game");
		NewGame_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//New Game button action
				
			      int result = JOptionPane.showConfirmDialog(null,
	                        "Are you sure you want to proceed? If you do ALL your progress will be deleted",
	                        "Confirmation",
	                        JOptionPane.YES_NO_OPTION);
	                if (result == JOptionPane.YES_OPTION) {
	                	//Stops music
	    				bckgdMusic.StopMusic();
	                    // New game button action
	                	
	                	//Calls method
	                	resetData(player);
	                	
	                	//Empty array
	                	boolean[][] booleanArray = new boolean[5][5];
						// Initialize all values to false
						for (int ii = 0; ii < booleanArray.length; ii++) {
						    for (int j = 0; j < booleanArray[ii].length; j++) {
						        booleanArray[ii][j] = false;
						    }
						}
						booleanArray[0][0]=true;//First level true
						
						Item[] item=new Item[3];//Empty Item array
						
						//Created Object of Player for the the new User
						Player Resetplayer=new Player(player.getAccountType(),player.getUsername(),0,item,booleanArray);
						
						//Opens the story page
						new Story(1, Resetplayer);
						dispose();
	                }
			}
		});
		NewGame_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		NewGame_button.setBounds(329, 113, 190, 33);
		contentPane.add(NewGame_button);
		
		//Leaderboard button
		JButton Leaderboard_button = new JButton("Leaderboard");
		Leaderboard_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stops music
				bckgdMusic.StopMusic();
				//Leaderboard button action
				Leaderboard su=new Leaderboard(player);                       
				su.setVisible(true);
				dispose();                                               
			}
		});
		Leaderboard_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Leaderboard_button.setBounds(329, 343, 190, 33);
		contentPane.add(Leaderboard_button);
		
		//Tutorial button
		JButton Tutorial_button = new JButton("Tutorial");
		Tutorial_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stops music
				bckgdMusic.StopMusic();
				//Tutorial button action
				dispose();
				TutGUI tut = new TutGUI(player);
				tut.setResizable(false);
				tut.setVisible(true);
					
			}
		});
		Tutorial_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Tutorial_button.setBounds(329, 419, 190, 33);
		contentPane.add(Tutorial_button);
		
		
		//Shop button
		JButton Shop_button = new JButton("Shop");
		Shop_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stops music
				bckgdMusic.StopMusic();
				//Shop button action
				new shop(player, true);
				dispose();
				
			}
		});
		Shop_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Shop_button.setBounds(329, 266, 190, 33);
		contentPane.add(Shop_button);
		
		//Classroom mode button
		if(player.getAccountType().equals("Teacher")) {
			
			JButton ClassR_button = new JButton("Classroom Mode");
			ClassR_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Stops music
					bckgdMusic.StopMusic();
					//Classroom mode button action
					Classroom window = new Classroom(player);
					window.setVisible(true);
					dispose();
					
				}
			});
			ClassR_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
			ClassR_button.setBounds(633, 113, 205, 66);
			contentPane.add(ClassR_button);
			
		}
		
		//Debug Mode button
		if(player.getAccountType().equals("Developer")) {
			
			JButton DeBug_button = new JButton("DeBug Mode");
			DeBug_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Stops music
					bckgdMusic.StopMusic();
					
					//Allows access to all levels and gives gold
					for(int i = 0;i < 4; i++)
						for(int j = 0;j < 5; j++)
							player.setLevelProgress(i, j, true);
					player.setLevelProgress(4, 0, true);
					
					player.setGold(1000);
					
					//Debug Mode button action
					WorldSelect a=new WorldSelect();
    				a.Worldselect(player, true);
    				a.setResizable(false);
    				a.setVisible(true);
    				dispose();
				}
			});
			DeBug_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
			DeBug_button.setBounds(10, 113, 205, 66);
			contentPane.add(DeBug_button);
			
		}
		
		//Exit button
		JButton Exit_button = new JButton("Exit");
		Exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stops music
				bckgdMusic.StopMusic();
				dispose();                    ////Closes MainMenu Window/GUI
			}
		});
		Exit_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Exit_button.setBounds(715, 23, 123, 33);
		contentPane.add(Exit_button);
		
		//Save game button
		JButton Save_button = new JButton("Save");
		Save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Music saveSound = new Music(getClass().getClassLoader().getResource("saveGame.wav"));
				saveSound.PlayMusic(false);
			}
		});
		Save_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Save_button.setBounds(715, 419, 123, 33);
		contentPane.add(Save_button);
		
		//Image of main character
		JLabel MC_Image_label = new JLabel("");
		MC_Image_label.setBackground(new Color(255, 255, 255));
		MC_Image_label.setBounds(62, 200, 153, 262);
		MC_Image_label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Stickman.png")));
		contentPane.add(MC_Image_label);
		
		//Western label
		JLabel Western_label = new JLabel("Winter 2024 CS2212 Western University");
		Western_label.setForeground(new Color(255, 255, 255));
		Western_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Western_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Western_label.setBounds(561, 360, 277, 13);
		contentPane.add(Western_label);
		
		//Samuel label
		JLabel Samuel_label = new JLabel("Samuel Angarita");
		Samuel_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Samuel_label.setForeground(Color.WHITE);
		Samuel_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Samuel_label.setBounds(561, 337, 277, 13);
		contentPane.add(Samuel_label);
		
		//Manuel label
		JLabel Manuel_label = new JLabel("Manuel Saldivar");
		Manuel_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Manuel_label.setForeground(Color.WHITE);
		Manuel_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Manuel_label.setBounds(561, 314, 277, 13);
		contentPane.add(Manuel_label);
		
		//Matthew label
		JLabel Matthew_label = new JLabel("Matthew Nazaruk");
		Matthew_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Matthew_label.setForeground(Color.WHITE);
		Matthew_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Matthew_label.setBounds(561, 291, 277, 13);
		contentPane.add(Matthew_label);
		
		//Cole label
		JLabel Cole_label = new JLabel("Cole Husar");
		Cole_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Cole_label.setForeground(Color.WHITE);
		Cole_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Cole_label.setBounds(561, 268, 277, 13);
		contentPane.add(Cole_label);
		
		//Leo label
		JLabel Leo_label = new JLabel("Leonardo Colabrese");
		Leo_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Leo_label.setForeground(Color.WHITE);
		Leo_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Leo_label.setBounds(561, 245, 277, 13);
		contentPane.add(Leo_label);
		
		//Team 11 label
		JLabel Team_label = new JLabel("Team 11");
		Team_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Team_label.setForeground(Color.WHITE);
		Team_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		Team_label.setBounds(561, 222, 277, 13);
		contentPane.add(Team_label);
		
		//Background
		JLabel Back_Image_label = new JLabel("");
		Back_Image_label.setBounds(0, 0, 862, 509);
		Back_Image_label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("MainMenu_Back.jpg")));
		contentPane.add(Back_Image_label);
		
		updateData(player);//SAVES GAME IN THE FILE
		
	}
	
	
	
	/**
	 * Updates the players data to the csv file
	 * @param player an Object of Player
	 */
	private void updateData(Player player) {
		
		int count = 0;
		int levelProgress = 0;
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(player.getLevelProgress()[i][j] == true)
					levelProgress++;
		
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			while((reader.readLine()) != null)
				count++;
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			line2 = new String[count];
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			int i = 0;
			while((line = reader.readLine()) != null) {
				line2[i] = line;
				i++;
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			int i = 0;
			writer.write(line2[i] + "\n");
			for(i = 1; i < line2.length; i++) {
				data = line2[i].split(",");
				if(data[0].equals(player.getUsername())) {
					data[3] = String.valueOf(player.getGold());
					data[4] = String.valueOf(levelProgress);
					if(player.getItems()[0] != null)
						data[5] = player.getItems()[0].getName();
					else 
						data[5] = "null";
					if(player.getItems()[1] != null)
						data[6] = player.getItems()[1].getName();
					else
						data[6] = "null";
					if(player.getItems()[2] != null)
						data[7] = player.getItems()[2].getName();
					else
						data[7] = "null";
					writer.write(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + ",\n");
				}
				else {
					writer.write(line2[i] + "\n");
				}
			}
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Resets the players data in the csv file.
	 * @param player an Object of Player.
	 */
	private void resetData(Player player) {
		
		int count = 0;
		
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			while((reader.readLine()) != null)
				count++;
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			line2 = new String[count];
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			int i = 0;
			while((line = reader.readLine()) != null) {
				line2[i] = line;
				i++;
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			int i = 0;
			writer.write(line2[i] + "\n");
			for(i = 1; i < line2.length; i++) {
				data = line2[i].split(",");
				if(data[0].equals(player.getUsername())) {
					
					writer.write(data[0] + "," + data[1] + "," + data[2] + ",0,1,null,null,null" + ",\n");
				}
				else {
					writer.write(line2[i] + "\n");
				}
			}
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
