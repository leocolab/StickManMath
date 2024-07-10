
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class shop {

	private Player user;
	private int world;
	private String background, worldName;
	private boolean menu;
	private Item item;
	private JFrame frmShopframe;

	/**
	 * LevelSelect will create an object of LevelSelect
	 * 
	 * @param player,     storing all info about a user
	 * @param menu,       a boolean weather we are in the menu or not
	 * @param background, a string with the file name of the background in needed
	 * @param worldName,  a string with the name of the world we are going into the
	 *                    shop from
	 * @param world,      the world number we are going to the shop from
	 * @return none
	 * @author Cole Husar
	 */

	public shop(Player player, boolean menu, String background, String worldName, int world) {
		this.menu = menu;
		this.background = background;
		this.worldName = worldName;
		this.world = world;
		user = player;
		initialize();
	}

	public shop(Player player, boolean menu) {
		this.menu = menu;
		user = player;
		initialize();
	}

	// A method returning a string list of the specified column
	public String[] readCol(int col, String delimeter) {

		String[] data;
		String curLine;
		ArrayList<String> colData = new ArrayList<String>();

		try {

			BufferedReader scanner = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("Items.csv")));

			while ((curLine = scanner.readLine()) != null) {

				data = curLine.split(delimeter);
				colData.add(data[col]);

			}

		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}

		return colData.toArray(new String[0]);

	}

	// A method to create an item based on which item is selected in the shop
	public Item makeItem(String itemName) {
		String[] cols = readCol(0, ",");

		for (int i = 0; i < cols.length; i++) {

			if (cols[i].equals(itemName)) {
				String[] data;
				String curLine;

				try {

					BufferedReader scanner = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("Items.csv")));

					while ((curLine = scanner.readLine()) != null) {

						data = curLine.split(",");
						if (data[0].equals(itemName)) {
							String name = data[0];
							String description = data[1];

							String heal = data[2];
							Boolean heal_bool;
							if (heal.equals("1")) {
								heal_bool = true;
							} else
								heal_bool = false;

							String block = data[3];
							Boolean block_bool;
							if (block.equals("1")) {
								block_bool = true;
							} else
								block_bool = false;

							String strength = data[4];
							Boolean strength_bool;
							if (strength.equals("1")) {
								strength_bool = true;
							} else
								strength_bool = false;

							String doub = data[5];
							Boolean doub_bool;
							if (doub.equals("1")) {
								doub_bool = true;
							} else
								doub_bool = false;

							String price = data[6];
							int price_int = Integer.parseInt(price);

							item = new Item(name, description, heal_bool, block_bool, strength_bool, doub_bool,
									price_int);
							return item;
						}
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return item;
	}

	private void initialize() {
		frmShopframe = new JFrame();
		frmShopframe.setResizable(false);
		frmShopframe.setTitle("shopFrame");
		frmShopframe.setBounds(100, 100, 861, 509);
		frmShopframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopframe.getContentPane().setLayout(null);
		frmShopframe.getContentPane().setBackground(new Color(230, 230, 250));

		JLabel lblNewLabel = new JLabel("Shop");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(360, 41, 104, 45);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		frmShopframe.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(120, 88, 112, 104);
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(285, 88, 104, 104);
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(462, 88, 104, 104);
		lblNewLabel_3_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(630, 88, 96, 104);
		lblNewLabel_3_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setBounds(118, 236, 114, 94);
		lblNewLabel_3_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setBounds(285, 236, 104, 88);
		lblNewLabel_3_4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("");
		lblNewLabel_3_5.setBounds(462, 236, 104, 94);
		lblNewLabel_3_5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_6 = new JLabel("");
		lblNewLabel_3_6.setBounds(630, 236, 112, 94);
		lblNewLabel_3_6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield1.png")));
		frmShopframe.getContentPane().add(lblNewLabel_3_6);

		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));

		btnNewButton_3.setBounds(30, 46, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			// Go back to world page
			public void actionPerformed(ActionEvent e) {
				frmShopframe.dispose();
				if (menu == true) {
					MainMenu su = new MainMenu(user);
					su.setResizable(false);
					su.setVisible(true);
				} else {
					if (world == 4) {
						FinalLevelSelect frame = new FinalLevelSelect();
						frame.FinalLevelselect(user, world, background, worldName);
						frame.setVisible(true);
						frame.setResizable(false);
					} else {
						LevelSelect frame = new LevelSelect();
						frame.Levelselect(user, world, background, worldName);
						frame.setVisible(true);
						frame.setResizable(false);
					}
				}
			}
		});

		// Gold Double
		JButton btnNewButton = new JButton("Double Gold");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {

			// Get item attributes and create an object for gold double
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Gold Double");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton.setBounds(130, 203, 104, 23);
		frmShopframe.getContentPane().add(btnNewButton);

		// Power bar
		JButton btnNewButton_1 = new JButton("Power Bar");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {

			// Get item attributes and create an object for power bar
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Power Bar");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(637, 202, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_1);

		// Heal spell
		JButton btnNewButton_2 = new JButton("Heal Spell");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {

			// Get item attributes and create an object for heal spell
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Heal Spell");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(298, 202, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_2);

		// Displays users gold count
		String goldString = Integer.toString(user.getGold());
		JLabel lblNewLabel_1 = new JLabel(goldString);
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setBounds(760, 50, 49, 14);
		frmShopframe.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_9 = new JLabel("Gold: ");
		lblNewLabel_9.setForeground(Color.white);
		lblNewLabel_9.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lblNewLabel_9.setBounds(720, 50, 49, 14);
		frmShopframe.getContentPane().add(lblNewLabel_9);

		// Strength boost
		JButton btnNewButton_1_1 = new JButton("Strength");
		btnNewButton_1_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_1_1.addActionListener(new ActionListener() {

			// Get item attributes and create an object for strength boost
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Strength Boost");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(467, 202, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_1_1);

		// Shield
		JButton btnNewButton_1_2 = new JButton("Shield");
		btnNewButton_1_2.setBackground(new Color(0, 255, 0));
		btnNewButton_1_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_1_2.addActionListener(new ActionListener() {

			// Get item attributes and create an object for shield
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Shield");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_1_2.setBounds(640, 341, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_1_2);

		// Megaboost
		JButton btnNewButton_1_3 = new JButton("Mega Boost");
		btnNewButton_1_3.setBackground(new Color(0, 255, 0));
		btnNewButton_1_3.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_1_3.addActionListener(new ActionListener() {

			// Get item attributes and create an object for mega boost
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Mega Boost");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_1_3.setBounds(462, 341, 99, 23);
		frmShopframe.getContentPane().add(btnNewButton_1_3);

		// Gemstone
		JButton btnNewButton_1_4 = new JButton("Gemstone");
		btnNewButton_1_4.setBackground(new Color(0, 255, 0));
		btnNewButton_1_4.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_1_4.addActionListener(new ActionListener() {

			// Get item attributes and create an object for gemstone
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Gemstone");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_1_4.setBounds(126, 341, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_1_4);

		// Ring
		JButton btnNewButton_1_5 = new JButton("Ring");
		btnNewButton_1_5.setBackground(new Color(0, 255, 0));
		btnNewButton_1_5.setFont(new Font("Mongolian Baiti", Font.BOLD, 11));
		btnNewButton_1_5.addActionListener(new ActionListener() {

			// Get item attributes and create an object for ring
			public void actionPerformed(ActionEvent e) {
				item = makeItem("Ring");
				frmShopframe.dispose();
				ItemGUI itm = new ItemGUI(item, user, menu, background, worldName, world);
				itm.setResizable(false);
				itm.setVisible(true);
			}
		});
		btnNewButton_1_5.setBounds(298, 341, 89, 23);
		frmShopframe.getContentPane().add(btnNewButton_1_5);

		frmShopframe.setVisible(true);

		// this section is for displaying the background screen
		JLabel ShopBackground = new JLabel("");
		ShopBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("inventoryBackGround.jpg")));
		ShopBackground.setBounds(0, 0, 861, 482);
		frmShopframe.getContentPane().add(ShopBackground);
	}

	public Item getItem() {
		return item;

	}
}
