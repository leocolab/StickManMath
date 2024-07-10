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
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class FinalLevelSelectDebugMode extends JFrame {
	/**
	 * this is for creating an object of FinalLevelSelectDebugMode class
	 * 
	 * @param none
	 * @return none but creates object of class
	 * @author Manuel Saldivar
	 */
	public FinalLevelSelectDebugMode() {

	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean selected = true;
	private Music backgroundmusic = new Music(
			getClass().getClassLoader().getResource("OnePieceOvertakenLevelSelect.wav"));

	/**
	 * method to display the debugger viewer of the final level
	 * 
	 * @param user       will be user that is currently playing the game
	 * @param world      will be an integer number 0-4 to know what world user is in
	 * @param background will be a .jpg of the background for the final level
	 * @param WorldName  will be a string of the name of the final world
	 * @return none but displays the frame for the debuger viewer
	 * @author Manuel Saldivar
	 */
	public void FinalLevelselectDebugMode(Player user, int world, String background, String WorldName) {
		backgroundmusic.PlayMusic(true);
		boolean[][] progress = user.getLevelProgress();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton FinalBossButton = new JButton("FINAL BOSS");
		if (progress[world][0] == false) {
			FinalBossButton.setEnabled(false);
		}

		// this section is for the button to fight the final boss
		FinalBossButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off music
				backgroundmusic.StopMusic();
				// open the combatGUI to fight the final boss
				new CombatGUI(user, world, 0, selected, true, background, WorldName);
			}
		});
		FinalBossButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
		FinalBossButton.setBackground(new Color(75, 0, 130));
		FinalBossButton.setForeground(new Color(255, 250, 240));
		FinalBossButton.setBounds(257, 221, 247, 67);
		contentPane.add(FinalBossButton);

		// this section is to display the worlds name
		JTextArea txtrSelectLevel = new JTextArea();
		txtrSelectLevel.setForeground(new Color(255, 250, 240));
		txtrSelectLevel.setBackground(new Color(139, 0, 0));
		txtrSelectLevel.setFont(new Font("Mongolian Baiti", Font.BOLD, 92));
		txtrSelectLevel.setEditable(false);
		txtrSelectLevel.setText(WorldName);
		txtrSelectLevel.setOpaque(false);
		txtrSelectLevel.setBounds(140, 40, 580, 91);
		contentPane.add(txtrSelectLevel);

		// this section is for the back button to return to WorldSelect GUI
		JButton BackWorldSelect = new JButton("BACK");
		BackWorldSelect.setForeground(new Color(255, 250, 250));
		BackWorldSelect.setBackground(new Color(0, 0, 0));
		BackWorldSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// stop playing music
				backgroundmusic.StopMusic();
				// open the worldselect GUI
				WorldSelect frame = new WorldSelect();
				frame.Worldselect(user, true);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		BackWorldSelect.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		BackWorldSelect.setBounds(10, 11, 114, 31);
		contentPane.add(BackWorldSelect);

		// this section is for the timer button, debugger can decide whether to include
		// timer in combat
		JToggleButton TimerSwitch = new JToggleButton("ON");
		TimerSwitch.setSelected(true);
		TimerSwitch.setForeground(Color.BLACK);
		TimerSwitch.setBackground(Color.GREEN);
		TimerSwitch.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		TimerSwitch.setBounds(40, 320, 151, 45);
		TimerSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = TimerSwitch.isSelected();
				if (selected) {
					// if timer is selected as on, will display button as "ON"
					TimerSwitch.setText("ON");
					TimerSwitch.setBackground(Color.green);
				} else {
					// if user selected switch as off, will display as "OFF"
					TimerSwitch.setText("OFF");
					TimerSwitch.setBackground(Color.RED);
				}
			}
		});
		contentPane.add(TimerSwitch);

		JTextField txtTimer = new JTextField();
		txtTimer.setEditable(false);
		txtTimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTimer.setText("        Timer");
		txtTimer.setBounds(40, 373, 151, 20);
		contentPane.add(txtTimer);
		txtTimer.setColumns(10);

		// this section is for to debugger to edit their items
		JButton EditItemsButton = new JButton("EDIT ITEMS");
		EditItemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// turn off the music before opening frame
				backgroundmusic.StopMusic();
				// open frame to display the debugger item select GUI
				DebugModeItems frame = new DebugModeItems();
				frame.Debugmode(user, world, background, WorldName);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		EditItemsButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		EditItemsButton.setBounds(599, 320, 158, 40);
		contentPane.add(EditItemsButton);

		// this section is to display the background of the level
		JLabel LevelSelectBackground = new JLabel("");
		LevelSelectBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource(background)));
		LevelSelectBackground.setBounds(0, 0, 861, 482);
		contentPane.add(LevelSelectBackground);
	}
}
