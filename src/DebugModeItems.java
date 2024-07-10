import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class DebugModeItems extends JFrame {
	/**
	 * this will be used to initialize the DebugModeItems class
	 */
	public DebugModeItems() {

	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinner;
	private JTextField ITEM;
	private JTextField DESCRIPTION;
	private JTextField ITEMONE;
	private JTextField ItemOneDescription;
	private JTextField QTY;
	private JButton BackButton;
	private JButton AddItemButton;
	private JTextField ItemTwo;
	private JTextField ItemThree;
	private JTextField ItemFour;
	private JTextField ItemFive;
	private JTextField ItemSix;
	private JTextField ItemSeven;
	private JTextField ItemEigth;
	private JTextField ItemTwoDescription;
	private JTextField ItemThreeDescription;
	private JTextField ItemFourDescription;
	private JTextField ItemFiveDescription;
	private JTextField ItemSixDescription;
	private JTextField ItemSevenDescription;
	private JTextField ItemEigthDescription;
	private JSpinner ItemOneSpinner = new JSpinner(); // jspinner for item one
	private JSpinner ItemTwoSpinner = new JSpinner();// jspinner for item two
	private JSpinner ItemThreeSpinner = new JSpinner();// jspinner for item three
	private JSpinner ItemFourSpinner = new JSpinner();// jspinner for item four
	private JSpinner ItemFiveSpinner = new JSpinner();// jspinner for item five
	private JSpinner ItemSixSpinner = new JSpinner();// jspinner for item six
	private JSpinner ItemSevenSpinner = new JSpinner();// jspinner for item seven
	private JSpinner ItemEigthSpinner = new JSpinner();// jspinner for item eight
	private final Action action = new SwingAction();

	/**
	 * this method will display the items a debugger can use to test out, along with
	 * description of each item
	 * 
	 * @param user       will be the player object that will hold all user
	 *                   information
	 * @param world      will be the number of what world the debugger is on
	 * @param background will be the .jph background the previous world had
	 * @param WorldName  will be the name of the previous worlds name
	 */
	public void Debugmode(Player user, int world, String background, String WorldName) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(245, 245, 220));
		contentPane_1.setBounds(10, 0, 848, 472);
		contentPane.add(contentPane_1);

		ITEM = new JTextField();
		ITEM.setEditable(false);
		ITEM.setText("           ITEM");
		ITEM.setFont(new Font("Tahoma", Font.PLAIN, 21));
		ITEM.setColumns(10);
		ITEM.setBounds(20, 10, 198, 41);
		contentPane_1.add(ITEM);

		DESCRIPTION = new JTextField();
		DESCRIPTION.setEditable(false);
		DESCRIPTION.setText("DESCRIPTION");
		DESCRIPTION.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DESCRIPTION.setColumns(10);
		DESCRIPTION.setBounds(550, 10, 150, 41);
		contentPane_1.add(DESCRIPTION);

		ITEMONE = new JTextField();
		ITEMONE.setOpaque(false);
		ITEMONE.setEditable(false);
		ITEMONE.setText("Gold Double");
		ITEMONE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ITEMONE.setColumns(10);
		ITEMONE.setBounds(30, 62, 188, 25);
		contentPane_1.add(ITEMONE);

		ItemOneDescription = new JTextField();
		ItemOneDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemOneDescription.setEditable(false);
		ItemOneDescription.setOpaque(false);
		ItemOneDescription.setText("Doubles Your Coins");
		ItemOneDescription.setColumns(10);
		ItemOneDescription.setBounds(464, 62, 362, 29);
		contentPane_1.add(ItemOneDescription);

		QTY = new JTextField();
		QTY.setEditable(false);
		QTY.setFont(new Font("Tahoma", Font.PLAIN, 17));
		QTY.setText("     QTY");
		QTY.setBounds(307, 17, 108, 29);
		contentPane_1.add(QTY);
		QTY.setColumns(10);

		// this section is for the back button which will be used to go back to the
		// world
		BackButton = new JButton("BACK");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (world == 4) {
					// finallevelselect for a debugger will look differently that the normal level
					// select
					dispose();
					FinalLevelSelectDebugMode frame = new FinalLevelSelectDebugMode();
					frame.FinalLevelselectDebugMode(user, world, background, WorldName);
					frame.setResizable(false);
					frame.setVisible(true);
				} else {
					// if not going back to the final level, display the level select for every
					// other level
					dispose();
					LevelSelectDebugMode frame = new LevelSelectDebugMode();
					frame.levelselectdebugmode(user, world, background, WorldName);
					frame.setResizable(false);
					frame.setVisible(true);
				}
			}
		});
		BackButton.setForeground(Color.WHITE);
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BackButton.setBackground(new Color(0, 0, 0));
		BackButton.setBounds(20, 433, 108, 29);
		contentPane_1.add(BackButton);

		ItemTwo = new JTextField();
		ItemTwo.setText("Heal Spell");
		ItemTwo.setOpaque(false);
		ItemTwo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemTwo.setEditable(false);
		ItemTwo.setColumns(10);
		ItemTwo.setBounds(30, 109, 188, 25);
		contentPane_1.add(ItemTwo);

		ItemThree = new JTextField();
		ItemThree.setText("Strength Boost");
		ItemThree.setOpaque(false);
		ItemThree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemThree.setEditable(false);
		ItemThree.setColumns(10);
		ItemThree.setBounds(30, 159, 188, 25);
		contentPane_1.add(ItemThree);

		ItemFour = new JTextField();
		ItemFour.setText("Power Bar");
		ItemFour.setOpaque(false);
		ItemFour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemFour.setEditable(false);
		ItemFour.setColumns(10);
		ItemFour.setBounds(30, 209, 188, 25);
		contentPane_1.add(ItemFour);

		ItemFive = new JTextField();
		ItemFive.setText("Gemstone");
		ItemFive.setOpaque(false);
		ItemFive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemFive.setEditable(false);
		ItemFive.setColumns(10);
		ItemFive.setBounds(30, 262, 188, 25);
		contentPane_1.add(ItemFive);

		ItemSix = new JTextField();
		ItemSix.setText("Ring");
		ItemSix.setOpaque(false);
		ItemSix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemSix.setEditable(false);
		ItemSix.setColumns(10);
		ItemSix.setBounds(30, 310, 188, 25);
		contentPane_1.add(ItemSix);

		ItemSeven = new JTextField();
		ItemSeven.setText("Mega Boost");
		ItemSeven.setOpaque(false);
		ItemSeven.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemSeven.setEditable(false);
		ItemSeven.setColumns(10);
		ItemSeven.setBounds(30, 358, 188, 25);
		contentPane_1.add(ItemSeven);

		ItemEigth = new JTextField();
		ItemEigth.setEditable(false);
		ItemEigth.setText("Shield");
		ItemEigth.setOpaque(false);
		ItemEigth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemEigth.setColumns(10);
		ItemEigth.setBounds(30, 407, 188, 25);
		contentPane_1.add(ItemEigth);

		ItemOneSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemOneSpinner.setBounds(337, 62, 44, 29);
		contentPane_1.add(ItemOneSpinner);

		ItemTwoSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemTwoSpinner.setBounds(337, 105, 44, 29);
		contentPane_1.add(ItemTwoSpinner);

		ItemThreeSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemThreeSpinner.setBounds(337, 159, 44, 29);
		contentPane_1.add(ItemThreeSpinner);

		ItemFourSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemFourSpinner.setBounds(337, 205, 44, 29);
		contentPane_1.add(ItemFourSpinner);

		ItemFiveSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemFiveSpinner.setBounds(337, 258, 44, 29);
		contentPane_1.add(ItemFiveSpinner);

		ItemSixSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemSixSpinner.setBounds(337, 306, 44, 29);
		contentPane_1.add(ItemSixSpinner);

		ItemSevenSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemSevenSpinner.setBounds(337, 354, 44, 29);
		contentPane_1.add(ItemSevenSpinner);

		ItemEigthSpinner.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		ItemEigthSpinner.setBounds(337, 407, 44, 29);
		contentPane_1.add(ItemEigthSpinner);

		// this section is for the button to add the selected items into user inventory
		AddItemButton = new JButton("ADD ITEMS");
		AddItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NumItemsOne = (int) ItemOneSpinner.getValue();
				int NumItemsTwo = (int) ItemTwoSpinner.getValue();
				int NumItemsThree = (int) ItemThreeSpinner.getValue();
				int NumItemsFour = (int) ItemFourSpinner.getValue();
				int NumItemsFive = (int) ItemFiveSpinner.getValue();
				int NumItemsSix = (int) ItemSixSpinner.getValue();
				int NumItemsSeven = (int) ItemSevenSpinner.getValue();
				int NumItemsEight = (int) ItemEigthSpinner.getValue();
				int TotalItems = NumItemsOne + NumItemsTwo + NumItemsThree + NumItemsFour + NumItemsFive + NumItemsSix
						+ NumItemsSeven + NumItemsEight;
				if (TotalItems > 3) {
					// if debugger chose more than 3 items to add to inventory will get a warning
					// and will be forced to choose less items
					JOptionPane.showMessageDialog(contentPane_1, "Exceeded over 3 items, update items");
				} else {
					// list of all the items, along with their properties
					Item[] itemList = new Item[8];
					Item Gold_Double = new Item("Gold Double", "Doubles Your Coins", false, false, false, true, 10);
					Item Heal_Spell = new Item("Heal Spell", "Heals from previous damage", true, false, false, false,
							10);
					Item Strength_Boost = new Item("Strength Boost", "Gain strength", false, false, true, false, 10);
					Item Power_Bar = new Item("Power Bar", "Gain strength and heal", true, false, true, false, 25);
					Item Gemstone = new Item("Gemstone", "Double your coins and heal", true, false, false, true, 25);
					Item Ring = new Item("Ring", "Gain strenth and double coins", false, false, true, true, 25);
					Item Mega_Boost = new Item("Mega Boost", "Gain strength, heal, and get richer", true, false, true,
							true, 40);
					Item Shield = new Item("Shield", "Block enemy attacks", false, true, false, false, 10);
					itemList[0] = Gold_Double;
					itemList[1] = Heal_Spell;
					itemList[2] = Strength_Boost;
					itemList[3] = Power_Bar;
					itemList[4] = Gemstone;
					itemList[5] = Ring;
					itemList[6] = Mega_Boost;
					itemList[7] = Shield;
					Item[] temparray = new Item[3];
					int counter = TotalItems - 1;
					// this will loop through to see what items the debugger chose to add to
					// inventory
					while (counter >= 0) {
						if (NumItemsOne > 0) {// item list zero
							temparray[counter] = itemList[0];
							counter--;
							NumItemsOne--;
						} else if (NumItemsTwo > 0) {
							temparray[counter] = itemList[1];
							counter--;
							NumItemsTwo--;
						} else if (NumItemsThree > 0) {
							temparray[counter] = itemList[2];
							counter--;
							NumItemsThree--;
						} else if (NumItemsFour > 0) {
							temparray[counter] = itemList[3];
							counter--;
							NumItemsFour--;
						} else if (NumItemsFive > 0) {
							temparray[counter] = itemList[4];
							counter--;
							NumItemsFive--;
						} else if (NumItemsSix > 0) {
							temparray[counter] = itemList[5];
							counter--;
							NumItemsSix--;
						} else if (NumItemsSeven > 0) {
							temparray[counter] = itemList[6];
							counter--;
							NumItemsSeven--;
						} else if (NumItemsEight > 0) {
							temparray[counter] = itemList[7];
							counter--;
							NumItemsEight--;
						}
					}
					user.setItems(temparray);
					if (world == 4) {// last world
						dispose();
						FinalLevelSelectDebugMode frame = new FinalLevelSelectDebugMode();
						frame.FinalLevelselectDebugMode(user, world, background, WorldName);
						frame.setResizable(false);
						frame.setVisible(true);
					} else {
						dispose();
						LevelSelectDebugMode frame = new LevelSelectDebugMode();
						frame.levelselectdebugmode(user, world, background, WorldName);
						frame.setResizable(false);
						frame.setVisible(true);
					}

				}
			}
		});
		AddItemButton.setBackground(new Color(148, 0, 211));
		AddItemButton.setForeground(Color.WHITE);
		AddItemButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		AddItemButton.setBounds(182, 443, 150, 25);
		contentPane_1.add(AddItemButton);

		ItemTwoDescription = new JTextField();
		ItemTwoDescription.setText("Heals from previous damage");
		ItemTwoDescription.setOpaque(false);
		ItemTwoDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemTwoDescription.setEditable(false);
		ItemTwoDescription.setColumns(10);
		ItemTwoDescription.setBounds(464, 102, 362, 29);
		contentPane_1.add(ItemTwoDescription);

		ItemThreeDescription = new JTextField();
		ItemThreeDescription.setText("Gain strength");
		ItemThreeDescription.setOpaque(false);
		ItemThreeDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemThreeDescription.setEditable(false);
		ItemThreeDescription.setColumns(10);
		ItemThreeDescription.setBounds(464, 155, 362, 29);
		contentPane_1.add(ItemThreeDescription);

		ItemFourDescription = new JTextField();
		ItemFourDescription.setText("Gain strength and heal");
		ItemFourDescription.setOpaque(false);
		ItemFourDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemFourDescription.setEditable(false);
		ItemFourDescription.setColumns(10);
		ItemFourDescription.setBounds(464, 205, 362, 29);
		contentPane_1.add(ItemFourDescription);

		ItemFiveDescription = new JTextField();
		ItemFiveDescription.setText("Double your coins and heal");
		ItemFiveDescription.setOpaque(false);
		ItemFiveDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemFiveDescription.setEditable(false);
		ItemFiveDescription.setColumns(10);
		ItemFiveDescription.setBounds(464, 258, 362, 29);
		contentPane_1.add(ItemFiveDescription);

		ItemSixDescription = new JTextField();
		ItemSixDescription.setText("Gain strenth and double coins");
		ItemSixDescription.setOpaque(false);
		ItemSixDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemSixDescription.setEditable(false);
		ItemSixDescription.setColumns(10);
		ItemSixDescription.setBounds(464, 306, 362, 29);
		contentPane_1.add(ItemSixDescription);

		ItemSevenDescription = new JTextField();
		ItemSevenDescription.setText("Gain strength, heal, and get richer");
		ItemSevenDescription.setOpaque(false);
		ItemSevenDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemSevenDescription.setEditable(false);
		ItemSevenDescription.setColumns(10);
		ItemSevenDescription.setBounds(464, 354, 362, 29);
		contentPane_1.add(ItemSevenDescription);

		ItemEigthDescription = new JTextField();
		ItemEigthDescription.setText("Block enemy attacks");
		ItemEigthDescription.setOpaque(false);
		ItemEigthDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		ItemEigthDescription.setEditable(false);
		ItemEigthDescription.setColumns(10);
		ItemEigthDescription.setBounds(464, 411, 362, 29);
		contentPane_1.add(ItemEigthDescription);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

}
