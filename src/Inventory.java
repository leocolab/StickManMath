
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

/**
 * Class to display the items in the players inventory
 * @author Matthew Nazaruk
 *
 */
public class Inventory {

	private Player user;
	private String background, worldName, line;
	private String [] line2, data = new String [8];
	private int world;
	private JFrame frame;
	private BufferedReader reader;
	private BufferedWriter writer;

	/**
	 * Inventory constructor. Sets variables and calls method to display the frame
	 * @param player player object stroing the players items
	 * @param background name of the background picture file of the current world
	 * @param worldName name of the current world
	 * @param world number representation of the current world
	 */
	public Inventory(Player player, String background, String worldName, int world) {
		user = player;
		this.background = background;
		this.worldName = worldName;
		this.world = world;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize and adds the contents of the frame and displays it.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 862, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Adds inventory title
		JLabel inventoryTitle = new JLabel("INVENTORY");
		inventoryTitle.setForeground(new Color(255, 255, 255));
		inventoryTitle.setBounds(330, 25, 200, 40);
		inventoryTitle.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
		frame.getContentPane().add(inventoryTitle);
		
		//Adds return button
		JButton returnButton = new JButton("Return");
		returnButton.setHorizontalAlignment(SwingConstants.CENTER);
		returnButton.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
		returnButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		returnButton.setBackground(new Color(255, 255, 0));
		returnButton.setForeground(new Color(0, 0, 0));
		returnButton.setBounds(5, 5, 89, 30);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); 
				if(world == 4) {
					FinalLevelSelect frame=new FinalLevelSelect();
					frame.FinalLevelselect(user, world, background, worldName);
					frame.setVisible(true);
					frame.setResizable(false);
				}
				else {
					LevelSelect frame=new LevelSelect();
					frame.Levelselect(user, world, background, worldName);
					frame.setVisible(true);
					frame.setResizable(false);
				}
			}
		});
		frame.getContentPane().add(returnButton);
		
		//Adds item1
		if(user.getItems()[0] != null) {
			//Adds the item picture
			JLabel item1 = new JLabel("");
			item1.setBounds(23, 125, 256, 256);
			switch(user.getItems()[0].getName()) {
			case "Gold Double":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold.png")));
				break;
						
			case "Heal Spell":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell.png")));
				break;
						
			case "Strength Boost":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength.png")));
				break;
						
			case "Power Bar":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar.png")));
				break;
						
			case "Gemstone":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone.png")));
				break;
						
			case "Ring":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring.png")));
				break;
						
			case "Mega Boost":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost.png")));
				break;
						
			case "Shield":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield.png")));
				break;
			}
			frame.getContentPane().add(item1);
			
			//Adds the text field displaying the item description
			JTextField description1 = new JTextField(user.getItems()[0].getDescription());
			description1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
			description1.setHorizontalAlignment(SwingConstants.CENTER);
			description1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			description1.setEditable(false);
			description1.setBounds(23, 85, 256, 30); 
			frame.getContentPane().add(description1);
			
			//Adds the button to remove item1
			JButton removeItem1 = new JButton("Remove " + user.getItems()[0].getName());
			removeItem1.setHorizontalAlignment(SwingConstants.CENTER);
			removeItem1.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
			removeItem1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			removeItem1.setBackground(new Color(255, 255, 0));
			removeItem1.setForeground(new Color(0, 0, 0));
			removeItem1.setBounds(48, 400, 206, 30);
			removeItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Removes item
					user.setItem(0, null);
					updateData();
					frame.dispose();
					new Inventory(user,background,worldName,world);
				}
			});
			frame.getContentPane().add(removeItem1);
		}
		
		//Adds item2
		if(user.getItems()[1] != null) {
			//Adds the item picture
			JLabel item2 = new JLabel("");
			item2.setBounds(302, 125, 256, 256);
			switch(user.getItems()[1].getName()) {
			case "Gold Double":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold.png")));
				break;
						
			case "Heal Spell":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell.png")));
				break;
						
			case "Strength Boost":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength.png")));
				break;
						
			case "Power Bar":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar.png")));
				break;
						
			case "Gemstone":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone.png")));
				break;
						
			case "Ring":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring.png")));
				break;
						
			case "Mega Boost":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost.png")));
				break;
						
			case "Shield":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield.png")));
				break;
			}
			frame.getContentPane().add(item2);
			
			//Adds the text field displaying the item description
			JTextField description2 = new JTextField(user.getItems()[1].getDescription());
			description2.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
			description2.setHorizontalAlignment(SwingConstants.CENTER);
			description2.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			description2.setEditable(false);
			description2.setBounds(302, 85, 256, 30); 
			frame.getContentPane().add(description2);
			
			//Adds the button to remove item2
			JButton removeItem2 = new JButton("Remove " + user.getItems()[1].getName());
			removeItem2.setHorizontalAlignment(SwingConstants.CENTER);
			removeItem2.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
			removeItem2.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			removeItem2.setBackground(new Color(255, 255, 0));
			removeItem2.setForeground(new Color(0, 0, 0));
			removeItem2.setBounds(327, 400, 206, 30);
			removeItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Removes item
					user.setItem(1, null);
					updateData();
					frame.dispose();
					new Inventory(user,background,worldName,world);			
				}
			});
			frame.getContentPane().add(removeItem2);
		}
		
		//Adds item3
		if(user.getItems()[2] != null) {
			//Adds the item picture
			JLabel item3 = new JLabel("");
			item3.setBounds(581, 125, 256, 256);
			switch(user.getItems()[2].getName()) {
			case "Gold Double":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold.png")));
				break;
						
			case "Heal Spell":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell.png")));
				break;
						
			case "Strength Boost":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength.png")));
				break;
						
			case "Power Bar":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar.png")));
				break;
						
			case "Gemstone":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone.png")));
				break;
						
			case "Ring":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring.png")));
				break;
						
			case "Mega Boost":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost.png")));
				break;
						
			case "Shield":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield.png")));
				break;
			}
			frame.getContentPane().add(item3);
			
			//Adds the text field displaying the item description
			JTextField description3 = new JTextField(user.getItems()[2].getDescription());
			description3.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
			description3.setHorizontalAlignment(SwingConstants.CENTER);
			description3.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			description3.setEditable(false);
			description3.setBounds(581, 85, 256, 30); 
			frame.getContentPane().add(description3);
			
			//Adds the button to remove item3
			JButton removeItem3 = new JButton("Remove " + user.getItems()[2].getName());
			removeItem3.setHorizontalAlignment(SwingConstants.CENTER);
			removeItem3.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
			removeItem3.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			removeItem3.setBackground(new Color(255, 255, 0));
			removeItem3.setForeground(new Color(0, 0, 0));
			removeItem3.setBounds(606, 400, 206, 30);
			removeItem3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Removes item
					user.setItem(2, null);
					updateData();
					frame.dispose();
					new Inventory(user,background,worldName,world);	
				}
			});
			frame.getContentPane().add(removeItem3);
		}
		
		//Adds the background picture
		JLabel useItemBackground = new JLabel("");
		useItemBackground.setBounds(0, 0, 861, 482);
		useItemBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("inventoryBackGround.jpg")));
		frame.getContentPane().add(useItemBackground);
	}
	
	/**
	 * Updates the players data to the csv file
	 */
	private void updateData() {
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
				if(data[0].equals(user.getUsername())) {
					if(user.getItems()[0] != null)
						data[5] = user.getItems()[0].getName();
					else 
						data[5] = "null";
					
					if(user.getItems()[1] != null)
						data[6] = user.getItems()[1].getName();
					else
						data[6] = "null";
					
					if(user.getItems()[2] != null)
						data[7] = user.getItems()[2].getName();
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
}
