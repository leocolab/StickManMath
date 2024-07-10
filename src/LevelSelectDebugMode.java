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

public class LevelSelectDebugMode extends JFrame {
	/**
	 * LevelSelectDebugMode class is used solely for how the worldselect GUI will
	 * look for developers
	 * 
	 * @param takes in no parameters
	 * @return doesnt return anything but creates an instance of class object
	 *         LevelSelectDebugMode
	 * @author Manuel Saldivar
	 */
	public LevelSelectDebugMode() {

	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimer;
	private boolean selected = true;
	private Music backgroundmusic = new Music(getClass().getClassLoader().getResource("OnePieceOvertakenLevelSelect.wav"));

	/**
	 * this method will display the exact same thing that level select has, but
	 * include some specific GUI implementations for developers debugging
	 * 
	 * @param user       will be used to know the users progress
	 * @param world      will determine what world the user is entering
	 * @param background will be used to change the background of the worlds
	 *                   specific GUI
	 * @param WorldName  this will be the currents worlds name, can be changed in
	 *                   the WorldSelect class to whatever
	 * @return nothing, but displays the level selection for each world
	 * @author Manuel Saldivar
	 */
	public void levelselectdebugmode(Player user, int world, String background, String WorldName) {
		backgroundmusic.PlayMusic(true);
		boolean[][] progress = user.getLevelProgress();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// this section is for the level one button
		JButton LvlOneButton = new JButton("Level 1");
		// if player hasnt unlocked progress, cannot enter
		if (progress[world][0] == false) {
			LvlOneButton.setEnabled(false);
		}
		LvlOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CombatGUI(user, world, 0, selected, true, background, WorldName);
				dispose();
				backgroundmusic.StopMusic();
			}
		});

		LvlOneButton.setForeground(new Color(255, 255, 255));
		LvlOneButton.setBackground(new Color(75, 0, 130));
		LvlOneButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlOneButton.setBounds(10, 233, 142, 45);
		contentPane.add(LvlOneButton);

		// this section is for the level two button
		JButton LvlTwoButton = new JButton("Level 2");
		// if player hasnt unlocked progress, cannot enter
		if (progress[world][1] == false) {
			LvlTwoButton.setEnabled(false);
		}
		LvlTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				new CombatGUI(user, world, 1, selected, true, background, WorldName);

			}
		});
		LvlTwoButton.setBackground(new Color(75, 0, 130));
		LvlTwoButton.setForeground(new Color(255, 245, 238));
		LvlTwoButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlTwoButton.setBounds(189, 234, 124, 45);
		contentPane.add(LvlTwoButton);

		// this is the section for level three button
		JButton LvlThreeButton = new JButton("Level 3");
		// if player hasnt unlocked progress, cannot enter level
		if (progress[world][2] == false) {
			LvlThreeButton.setEnabled(false);
		}
		LvlThreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				new CombatGUI(user, world, 2, selected, true, background, WorldName);

			}
		});
		LvlThreeButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlThreeButton.setBackground(new Color(75, 0, 130));
		LvlThreeButton.setForeground(new Color(255, 250, 240));
		LvlThreeButton.setBounds(353, 237, 124, 40);
		contentPane.add(LvlThreeButton);

		// this is the section for the level four button
		JButton LvlFourButton = new JButton("Level 4");
		// if player has not reached progress, cannot enter level
		if (progress[world][3] == false) {
			LvlFourButton.setEnabled(false);
		}
		LvlFourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				new CombatGUI(user, world, 3, selected, true, background, WorldName);

			}
		});
		LvlFourButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlFourButton.setBackground(new Color(75, 0, 130));
		LvlFourButton.setForeground(new Color(255, 250, 240));
		LvlFourButton.setBounds(536, 235, 114, 45);
		contentPane.add(LvlFourButton);

		// this is the section for the level five button
		JButton LvlFiveButton = new JButton("Level 5");
		// if player hasnt unlocked progress, cannot enter level
		if (progress[world][4] == false) {
			LvlFiveButton.setEnabled(false);
		}
		LvlFiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CombatGUI(user, world, 4, selected, true, background, WorldName);
				dispose();
				backgroundmusic.StopMusic();
			}

		});
		LvlFiveButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		LvlFiveButton.setForeground(new Color(255, 250, 240));
		LvlFiveButton.setBackground(new Color(75, 0, 130));
		LvlFiveButton.setBounds(712, 233, 124, 45);
		contentPane.add(LvlFiveButton);

		// this section displays the worlds name
		JTextArea txtrSelectLevel = new JTextArea();
		txtrSelectLevel.setForeground(new Color(255, 250, 240));
		txtrSelectLevel.setBackground(new Color(139, 0, 0));
		txtrSelectLevel.setFont(new Font("Mongolian Baiti", Font.BOLD, 92));
		txtrSelectLevel.setEditable(false);
		txtrSelectLevel.setText(WorldName);
		txtrSelectLevel.setOpaque(false);
		txtrSelectLevel.setBounds(140, 40, 550, 91);
		contentPane.add(txtrSelectLevel);

		// this section is for the back button, used to go to WorldSelect frame
		JButton BackWorldSelect = new JButton("BACK");
		BackWorldSelect.setForeground(new Color(255, 250, 250));
		BackWorldSelect.setBackground(new Color(0, 0, 0));
		BackWorldSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				WorldSelect frame = new WorldSelect();
				frame.Worldselect(user, true);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		BackWorldSelect.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		BackWorldSelect.setBounds(10, 11, 114, 31);
		contentPane.add(BackWorldSelect);

		// this section if for choosing whether debugger wants the timer to be on or off
		JToggleButton TimerSwitch = new JToggleButton("ON");
		TimerSwitch.setSelected(true);
		TimerSwitch.setForeground(Color.BLACK);
		TimerSwitch.setBackground(Color.GREEN);
		TimerSwitch.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		TimerSwitch.setBounds(108, 320, 151, 45);
		TimerSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = TimerSwitch.isSelected();
				if (selected) {
					TimerSwitch.setText("ON");
					TimerSwitch.setBackground(Color.green);
				} else {
					TimerSwitch.setText("OFF");
					TimerSwitch.setBackground(Color.RED);
				}
			}
		});
		contentPane.add(TimerSwitch);

		txtTimer = new JTextField();
		txtTimer.setEditable(false);
		txtTimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTimer.setText("        Timer");
		txtTimer.setBounds(108, 376, 151, 20);
		contentPane.add(txtTimer);
		txtTimer.setColumns(10);

		// this section is for the debugger to decide what items to use
		JButton EditItemsButton = new JButton("Edit Items");
		EditItemsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				DebugModeItems frame = new DebugModeItems();
				frame.Debugmode(user, world, background, WorldName);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		EditItemsButton.setBackground(new Color(255, 250, 240));
		EditItemsButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		EditItemsButton.setBounds(602, 326, 164, 31);
		contentPane.add(EditItemsButton);

		// this section if for displaying the background of the world
		JLabel LevelSelectBackground = new JLabel("Timer");
		LevelSelectBackground.setFont(new Font("Tahoma", Font.BOLD, 16));
		LevelSelectBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource(background)));
		LevelSelectBackground.setBounds(0, 0, 881, 496);
		contentPane.add(LevelSelectBackground);

	}
}
