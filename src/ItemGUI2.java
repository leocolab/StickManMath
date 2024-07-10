import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// This class handles all purchases in the shop and display information about the item that has been clicked on
public class ItemGUI2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item tempItem = new Item("Ring", "Gain strenth and double coins", false, false, true, true, 20); // Real Item to be imported from shop
					String name = tempItem.getName(); //change name from temp item
					boolean [][] levelProgress = {{true,true,true,true,true},{true,true,true,true,true},{true,true,true,true,true},{true,true,true,true,true},{true,true,true,true,true}};
					Item[] items = {tempItem,tempItem,tempItem}; //temp
					Player currPlayer = new Player("empty", "emptyUsr", 19, items, levelProgress); //temp
					
					// if statements: if name = y, imgPath = x
					
					String tempImgPath = ""; // temp
					ItemGUI2 frame = new ItemGUI2(tempItem, tempImgPath, currPlayer);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ItemGUI2(final Item currItem, String imgPath, final Player currPlayer) {
		// Choose correct image file based on item name
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		//Make dependent on currItem
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/"+imgName)).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(37, 70, 277, 256);
		contentPane.add(lblNewLabel);
		
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
		}
		else strH = "No";
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
		}
		else strB = "No";
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
		}
		else strS = "No";
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
		}
		else strD = "No";
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
		
		// On click, need to check if there is enough coins, if yes: update player coins and inventory
		JButton btnNewButton = new JButton("Buy Now");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		btnNewButton.setBounds(87, 394, 123, 44);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent purchaseItem) {
				int gold = currPlayer.getGold();
				int price = currItem.getPrice();
				if (gold >= price) {
					currPlayer.setGold(gold - price);
					txtpnCoins.setText(String.valueOf(currPlayer.getGold()));
					JOptionPane.showMessageDialog(null, "Item Purchased", "Success!", JOptionPane.INFORMATION_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null, "Go out in the battle feild and earn some more!", "Stop! Not enough coins", JOptionPane.INFORMATION_MESSAGE);
				
				System.out.println("");
			}
		});
		contentPane.add(btnNewButton);
		
		
		JTextPane txtpnCoins_2 = new JTextPane();
		txtpnCoins_2.setText("Coins:");
		txtpnCoins_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		txtpnCoins_2.setEditable(false);
		txtpnCoins_2.setBackground(new Color(255, 215, 0));
		txtpnCoins_2.setBounds(702, 11, 117, 32);
		contentPane.add(txtpnCoins_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(730, 427, 89, 23);
		contentPane.add(btnNewButton_1);
		
		//Manny Code recommended
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
    	setBounds(100,100,862,509);
	}
}