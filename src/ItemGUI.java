import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * The ItemGUI class serves as the central point of sale for the shop in the
 * game. After handling purchases with in-game currency, it updates the
 * inventory display page instantaneously, allowing players to see their new
 * acquisitions in real-time and make strategic decisions based on their current
 * inventory. Instant updates in the player's coin balance are also displayed
 * after purchase. ItemGUI is responsible for displaying information about items
 * available for purchase.
 * 
 * @author Leo Colabrese
 */
public class ItemGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Player currPlayer;
	private Item currItem;
	private boolean menu;

	/**
	 * Constructs a new ItemGUI window.
	 * 
	 * @param currItem   The item to be displayed in the GUI.
	 * @param currPlayer The current player.
	 * @param menu       A boolean to indicate if the menu should be displayed.
	 * @param background The background image for the GUI.
	 * @param worldName  The name of the current world.
	 * @param world      The world number.
	 */
	public ItemGUI(Item currItem, Player currPlayer, boolean menu, String background, String worldName, int world) {
		// Choose correct image file based on name of item being currently viewed
		this.menu = menu;
		this.currPlayer = currPlayer;
		this.currItem = currItem;
		String imgName;
		String itemName = currItem.getName();
		if (itemName.equals("Gold Double")) {
			imgName = "doubleGold.png";
		} else if (itemName.equals("Heal Spell")) {
			imgName = "healSpell.png";
		} else if (itemName.equals("Strength Boost")) {
			imgName = "strength.png";
		} else if (itemName.equals("Power Bar")) {
			imgName = "powerBar.png";
		} else if (itemName.equals("Gemstone")) {
			imgName = "gemstone.png";
		} else if (itemName.equals("Ring")) {
			imgName = "Ring.png";
		} else if (itemName.equals("Mega Boost")) {
			imgName = "megaBoost.png";
		} else {
			imgName = "shield.png";
		}

		// Page configuration
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Page components

		JTextPane txtpnTemperary = new JTextPane();
		txtpnTemperary.setBackground(new Color(0, 255, 255));
		txtpnTemperary.setEditable(false);
		txtpnTemperary.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
		txtpnTemperary.setText(currItem.getName());
		txtpnTemperary.setBounds(55, 11, 177, 44);
		StyledDocument doc = txtpnTemperary.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		contentPane.add(txtpnTemperary);

		JTextPane txtpnPrice = new JTextPane();
		txtpnPrice.setBackground(new Color(255, 215, 0));
		txtpnPrice.setEditable(false);
		txtpnPrice.setText("Coins to Purchase:");
		txtpnPrice.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnPrice.setBounds(45, 354, 167, 32);
		contentPane.add(txtpnPrice);

		JTextPane txtpnTpric = new JTextPane();
		txtpnTpric.setBackground(new Color(255, 215, 0));
		txtpnTpric.setEditable(false);
		txtpnTpric.setText(String.valueOf(currItem.getPrice()));
		txtpnTpric.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		txtpnTpric.setBounds(210, 354, 43, 32);
		contentPane.add(txtpnTpric);

		// Image displayed dependent on name of image passed as parameter
		JLabel itemPicture = new JLabel("");
		itemPicture.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imgName)));
		itemPicture.setBounds(37, 70, 277, 256);
		contentPane.add(itemPicture);

		JTextPane txtpnDescription = new JTextPane();
		txtpnDescription.setBackground(new Color(0, 255, 255));
		txtpnDescription.setText("  Description");
		txtpnDescription.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		txtpnDescription.setEditable(false);
		txtpnDescription.setBounds(402, 25, 154, 32);
		contentPane.add(txtpnDescription);

		JTextPane txtpnDestmp = new JTextPane();
		txtpnDestmp.setBackground(new Color(240, 248, 255));
		txtpnDestmp.setText(currItem.getDescription());
		txtpnDestmp.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnDestmp.setEditable(false);
		txtpnDestmp.setBounds(402, 88, 436, 80);
		contentPane.add(txtpnDestmp);

		JTextPane txtpnFeatures = new JTextPane();
		txtpnFeatures.setBackground(new Color(0, 255, 255));
		txtpnFeatures.setText("     Features");
		txtpnFeatures.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		txtpnFeatures.setEditable(false);
		txtpnFeatures.setBounds(402, 196, 154, 32);
		contentPane.add(txtpnFeatures);

		JTextPane txtpnHeal = new JTextPane();
		txtpnHeal.setBackground(new Color(240, 248, 255));
		String strH;
		if (currItem.getHeal() == true) {
			strH = "Yes";
		} else
			strH = "No";
		txtpnHeal.setText(strH);
		txtpnHeal.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnHeal.setEditable(false);
		txtpnHeal.setBounds(518, 239, 38, 32);
		contentPane.add(txtpnHeal);

		JTextPane txtpnHeal_1 = new JTextPane();
		txtpnHeal_1.setBackground(new Color(240, 248, 255));
		txtpnHeal_1.setText("Heal:");
		txtpnHeal_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnHeal_1.setEditable(false);
		txtpnHeal_1.setBounds(402, 239, 154, 32);
		contentPane.add(txtpnHeal_1);

		JTextPane txtpnBnu = new JTextPane();
		txtpnBnu.setBackground(new Color(240, 248, 255));
		String strB;
		if (currItem.getBlock() == true) {
			strB = "Yes";
		} else
			strB = "No";
		txtpnBnu.setText(strB);
		txtpnBnu.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnBnu.setEditable(false);
		txtpnBnu.setBounds(518, 282, 38, 32);
		contentPane.add(txtpnBnu);

		JTextPane txtpnHeal_1_1 = new JTextPane();
		txtpnHeal_1_1.setBackground(new Color(240, 248, 255));
		txtpnHeal_1_1.setText("Block:");
		txtpnHeal_1_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnHeal_1_1.setEditable(false);
		txtpnHeal_1_1.setBounds(402, 282, 154, 32);
		contentPane.add(txtpnHeal_1_1);

		JTextPane txtpnStrength = new JTextPane();
		txtpnStrength.setBackground(new Color(240, 248, 255));
		String strS;
		if (currItem.getStrength() == true) {
			strS = "Yes";
		} else
			strS = "No";
		txtpnStrength.setText(strS);
		txtpnStrength.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnStrength.setEditable(false);
		txtpnStrength.setBounds(518, 325, 38, 32);
		contentPane.add(txtpnStrength);

		JTextPane txtpnHeal_1_1_1 = new JTextPane();
		txtpnHeal_1_1_1.setBackground(new Color(240, 248, 255));
		txtpnHeal_1_1_1.setText("Strength:");
		txtpnHeal_1_1_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnHeal_1_1_1.setEditable(false);
		txtpnHeal_1_1_1.setBounds(402, 325, 154, 32);
		contentPane.add(txtpnHeal_1_1_1);

		JTextPane txtpnDnu = new JTextPane();
		txtpnDnu.setBackground(new Color(240, 248, 255));
		String strD;
		if (currItem.getDouble() == true) {
			strD = "Yes";
		} else
			strD = "No";
		txtpnDnu.setText(strD);
		txtpnDnu.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnDnu.setEditable(false);
		txtpnDnu.setBounds(518, 368, 38, 32);
		contentPane.add(txtpnDnu);

		JTextPane txtpnHeal_1_1_1_1 = new JTextPane();
		txtpnHeal_1_1_1_1.setBackground(new Color(240, 248, 255));
		txtpnHeal_1_1_1_1.setText("Double:");
		txtpnHeal_1_1_1_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		txtpnHeal_1_1_1_1.setEditable(false);
		txtpnHeal_1_1_1_1.setBounds(402, 368, 154, 32);
		contentPane.add(txtpnHeal_1_1_1_1);

		final JTextPane txtpnCoins = new JTextPane();
		txtpnCoins.setBackground(new Color(255, 215, 0));
		txtpnCoins.setText(String.valueOf(currPlayer.getGold()));
		txtpnCoins.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		txtpnCoins.setEditable(false);
		txtpnCoins.setBounds(777, 11, 61, 32);
		contentPane.add(txtpnCoins);

		// On click, check if there is sufficient player coin balance
		JButton buyNow = new JButton("Buy Now");
		buyNow.setForeground(new Color(0, 0, 0));
		buyNow.setBackground(new Color(255, 215, 0));
		buyNow.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		buyNow.setBounds(87, 394, 123, 44);
		buyNow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent purchaseItem) {
				int gold = currPlayer.getGold();
				int price = currItem.getPrice();
				Item[] items = currPlayer.getItems();
				// Case: Insufficient funds
				if (gold < price)
					JOptionPane.showMessageDialog(null, "Go out in the battle feild and earn some more!",
							"Stop! Not enough coins", JOptionPane.INFORMATION_MESSAGE);
				// Case: Full Inventory
				else if (items[0] != null && items[1] != null && items[2] != null) {
					JOptionPane.showMessageDialog(null, "You can only hold 3 items at a time", "Full Inventory",
							JOptionPane.INFORMATION_MESSAGE);
				}
				// Case: able to purchase item
				else {
					currPlayer.setGold(gold - price);
					txtpnCoins.setText(String.valueOf(currPlayer.getGold()));
					// Add item to next available inventory location
					boolean added = false;
					for (int i = 0; i < 3; i++) {
						if (items[i] == null && !added) {
							items[i] = currItem;
							added = true;
						}
					}
					// Update player class with newly acquired items
					currPlayer.setItems(items);
					JOptionPane.showMessageDialog(null, "Item Purchased", "Success!", JOptionPane.INFORMATION_MESSAGE);
				}

				System.out.println("");
			}
		});
		contentPane.add(buyNow);

		JTextPane txtpnCoins_2 = new JTextPane();
		txtpnCoins_2.setText("Coins:");
		txtpnCoins_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		txtpnCoins_2.setEditable(false);
		txtpnCoins_2.setBackground(new Color(255, 215, 0));
		txtpnCoins_2.setBounds(702, 11, 117, 32);
		contentPane.add(txtpnCoins_2);

		JButton exitButton = new JButton("Back");
		exitButton.setBackground(Color.CYAN);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitButton.setBounds(730, 427, 89, 23);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new shop(currPlayer, menu, background, worldName, world);
				dispose();
			}
		});
		contentPane.add(exitButton);
		// this section is to display the background of the world
		JLabel ItemBackground = new JLabel("");
		ItemBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("inventoryBackGround.jpg")));
		ItemBackground.setBounds(0, 0, 861, 482);
		contentPane.add(ItemBackground);

	}
}