import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class LevelSelect extends JFrame {
	/**
	 * LevelSelect will create an object of LevelSelect
	 * 
	 * @param none
	 * @return none
	 * @author Manuel Saldivar
	 */
	public LevelSelect() {

	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Music backgroundmusic = new Music(
			getClass().getClassLoader().getResource("OnePieceOvertakenLevelSelect.wav"));

	/**
	 * the LevelSelect method will display on a frame the 5 different levels a user
	 * can select, levels can only be selected if user progress allows them to
	 * 
	 * @param user       which is of type Player will contain all the users
	 *                   information
	 * @param world      will be a number between 0-4 to indicate what world the
	 *                   user is going into
	 * @param background a string input that lets method know what background to put
	 * @param WorldName  a string input that will display the name of the world user
	 *                   is currently in
	 * @return displays the GUI for level selection
	 * @author Manuel Saldivar
	 */
	public void Levelselect(Player user, int world, String background, String WorldName) {
		backgroundmusic.PlayMusic(true);
		boolean[][] progress = user.getLevelProgress();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Skull2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// this section is for the level one button
		JButton LvlOneButton = new JButton("Level 1");
		// disable button if user progress has not allowed it
		if (progress[world][0] == false) {
			LvlOneButton.setEnabled(false);
		}
		LvlOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				new CombatGUI(user, world, 0, true, false, background, WorldName);
			}
		});
		LvlOneButton.setForeground(new Color(255, 255, 255));
		LvlOneButton.setBackground(new Color(75, 0, 130));
		LvlOneButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlOneButton.setBounds(10, 233, 142, 45);
		contentPane.add(LvlOneButton);

		// this section is for the level two button
		JButton LvlTwoButton = new JButton("Level 2");
		// disable the buton if user does not have access to it
		if (progress[world][1] == false) {
			LvlTwoButton.setEnabled(false);
		}
		LvlTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// stop playing music
				backgroundmusic.StopMusic();
				// enter the combatGUI class when button is pressed
				new CombatGUI(user, world, 1, true, false, background, WorldName);
			}
		});
		LvlTwoButton.setBackground(new Color(75, 0, 130));
		LvlTwoButton.setForeground(new Color(255, 245, 238));
		LvlTwoButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlTwoButton.setBounds(189, 234, 124, 45);
		contentPane.add(LvlTwoButton);

		// this section is for the level three button
		JButton LvlThreeButton = new JButton("Level 3");
		// disable button if user has not reached progress
		if (progress[world][2] == false) {
			LvlThreeButton.setEnabled(false);
		}
		LvlThreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// stop playing the music
				backgroundmusic.StopMusic();
				// enter the CombatGUI class when button is pressed
				new CombatGUI(user, world, 2, true, false, background, WorldName);
			}
		});
		LvlThreeButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlThreeButton.setBackground(new Color(75, 0, 130));
		LvlThreeButton.setForeground(new Color(255, 250, 240));
		LvlThreeButton.setBounds(353, 237, 124, 40);
		contentPane.add(LvlThreeButton);

		// this section is for the level four button
		JButton LvlFourButton = new JButton("Level 4");
		// disable button if user hasnt unlocked level yet
		if (progress[world][3] == false) {
			LvlFourButton.setEnabled(false);
		}
		LvlFourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// stop playing music
				backgroundmusic.StopMusic();
				// enter the CombatGUI class when button is pressed
				new CombatGUI(user, world, 3, true, false, background, WorldName);
			}
		});
		LvlFourButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlFourButton.setBackground(new Color(75, 0, 130));
		LvlFourButton.setForeground(new Color(255, 250, 240));
		LvlFourButton.setBounds(536, 235, 114, 45);
		contentPane.add(LvlFourButton);

		// this section is for the level five button
		JButton LvlFiveButton = new JButton("Level 5");
		// disable button if user hasnt unlocked level
		if (progress[world][4] == false) {
			LvlFiveButton.setEnabled(false);
		}
		LvlFiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// stop playing music
				backgroundmusic.StopMusic();
				// open the CombatGUI class when button is pressed
				new CombatGUI(user, world, 4, true, false, background, WorldName);
			}
		});
		LvlFiveButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlFiveButton.setForeground(new Color(255, 250, 240));
		LvlFiveButton.setBackground(new Color(75, 0, 130));
		LvlFiveButton.setBounds(712, 233, 124, 45);
		contentPane.add(LvlFiveButton);

		// this section is to display the world name
		JTextArea txtrSelectLevel = new JTextArea();
		txtrSelectLevel.setForeground(new Color(255, 250, 240));
		txtrSelectLevel.setBackground(new Color(139, 0, 0));
		txtrSelectLevel.setFont(new Font("Mongolian Baiti", Font.BOLD, 92));
		txtrSelectLevel.setEditable(false);
		txtrSelectLevel.setText(WorldName);
		txtrSelectLevel.setOpaque(false);
		txtrSelectLevel.setBounds(140, 40, 580, 91);
		contentPane.add(txtrSelectLevel);

		// this section is for the backbutton, which will return to the world select
		// frame
		JButton BackWorldSelect = new JButton("BACK");
		BackWorldSelect.setForeground(new Color(255, 250, 250));
		BackWorldSelect.setBackground(new Color(0, 0, 0));
		BackWorldSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				WorldSelect frame = new WorldSelect();
				frame.Worldselect(user, false);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		BackWorldSelect.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		BackWorldSelect.setBounds(10, 11, 114, 31);
		contentPane.add(BackWorldSelect);

		// this button is to check user inventory before entering level
		JButton InventoryButton = new JButton("Inventory");
		InventoryButton.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
		InventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// stop music
				backgroundmusic.StopMusic();
				// open the user inventory GUI
				new Inventory(user, background, WorldName, world);
			}
		});
		InventoryButton.setBackground(Color.YELLOW);
		InventoryButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		InventoryButton.setBounds(621, 361, 168, 48);
		contentPane.add(InventoryButton);

		// this section is for the Shop button, which will be used to purchase items
		// before entering a level
		JButton ShopButton = new JButton("Shop");
		ShopButton.setBackground(Color.YELLOW);
		ShopButton.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
		ShopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				// open the shop frame to buy items
				new shop(user, false, background, WorldName, world);
			}
		});
		ShopButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		ShopButton.setBounds(21, 363, 168, 45);
		contentPane.add(ShopButton);

		// this section is to display the background of the world
		JLabel LevelSelectBackground = new JLabel("");
		LevelSelectBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource(background)));
		LevelSelectBackground.setBounds(0, 0, 861, 482);
		contentPane.add(LevelSelectBackground);

	}

}
