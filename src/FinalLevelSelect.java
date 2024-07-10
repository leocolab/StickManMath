import java.awt.Color;
import java.awt.Font;
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

public class FinalLevelSelect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Music backgroundmusic = new Music(
			getClass().getClassLoader().getResource("OnePieceOvertakenLevelSelect.wav"));

	/**
	 * This method will be used to create an instance of class FinalLevelSelect
	 * 
	 * @author Manuel saldivar
	 */
	public FinalLevelSelect() {

	}

	/**
	 * This method will be used as a frame just before fighting the final boss, in
	 * this frame, user can go back, check inventory, enter the shop, or proceed to
	 * fight the final boss
	 * 
	 * @param user       which will be used to check player progress throughout game
	 * @param world      let program know what world the user is in
	 * @param background let method know what background to display
	 * @param WorldName  let method know what the title of the frame will be
	 * @return nothing, but displays frame
	 * @author Manuel Saldivar
	 */
	public void FinalLevelselect(Player user, int world, String background, String WorldName) {
		backgroundmusic.PlayMusic(true);
		boolean[][] progress = user.getLevelProgress();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// this section is for the final boss button
		JButton FinalBossButton = new JButton("FINAL BOSS");
		// if user hasnt unlocked progress, will disable button
		if (progress[world][0] == false) {
			FinalBossButton.setEnabled(false);
		}
		FinalBossButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				// open the CombatGUI to fight final boss
				new CombatGUI(user, world, 0, true, false, background, WorldName);
			}
		});
		FinalBossButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
		FinalBossButton.setBackground(new Color(75, 0, 130));
		FinalBossButton.setForeground(new Color(255, 250, 240));
		FinalBossButton.setBounds(257, 221, 247, 67);
		contentPane.add(FinalBossButton);

		JTextArea txtrSelectLevel = new JTextArea();
		txtrSelectLevel.setForeground(new Color(255, 250, 240));
		txtrSelectLevel.setBackground(new Color(139, 0, 0));
		txtrSelectLevel.setFont(new Font("Mongolian Baiti", Font.BOLD, 92));
		txtrSelectLevel.setEditable(false);
		txtrSelectLevel.setText(WorldName);
		txtrSelectLevel.setOpaque(false);
		txtrSelectLevel.setBounds(140, 40, 580, 91);
		contentPane.add(txtrSelectLevel);

		// this section is for returning back to the world select GUI
		JButton BackWorldSelect = new JButton("BACK");
		BackWorldSelect.setForeground(new Color(255, 250, 250));
		BackWorldSelect.setBackground(new Color(0, 0, 0));
		BackWorldSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				// open the worldslect frame
				WorldSelect frame = new WorldSelect();
				frame.Worldselect(user, false);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		BackWorldSelect.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		BackWorldSelect.setBounds(10, 11, 114, 31);
		contentPane.add(BackWorldSelect);

		// this section is for the inventory button
		JButton InventoryButton = new JButton("Inventory");
		InventoryButton.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
		InventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				// open the inventory GUI to check inventory
				new Inventory(user, background, WorldName, world);
			}
		});
		InventoryButton.setBackground(Color.YELLOW);
		InventoryButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		InventoryButton.setBounds(621, 361, 168, 48);
		contentPane.add(InventoryButton);

		// this section is for opening the shop GUI
		JButton ShopButton = new JButton("Shop");
		ShopButton.setBackground(Color.YELLOW);
		ShopButton.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
		ShopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				// open the shop GUI
				new shop(user, false, background, WorldName, 4);

			}
		});
		ShopButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		ShopButton.setBounds(21, 363, 168, 45);
		contentPane.add(ShopButton);

		// this section is for displaying the background screen
		JLabel LevelSelectBackground = new JLabel("");
		LevelSelectBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource(background)));
		LevelSelectBackground.setBounds(0, 0, 861, 482);
		contentPane.add(LevelSelectBackground);
	}

}
