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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WorldSelect extends JFrame {
	/**
	 * WorldSelect class will be used to create a frame of type WorldSelect
	 * 
	 * @param takes in to parameters
	 * @return returns nothing but creates an instance of class object WorldSelect
	 * @author Manuel Saldivar
	 */
	public WorldSelect() {

	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtWorld;
	private JTextField txtWorld_1;
	private JTextField txtWorld_2;
	private Music backgroundmusic = new Music(getClass().getClassLoader().getResource("OnePieceOvertaken.wav")); //
	// this
	// is
	// the
	// background
	// music
	// that
	// is
	// played
	// when opening this frame

	/**
	 * Worldselect method is a void method which will display the 5 different worlds
	 * the user can go to. User can only enter world, if they have completed the
	 * level or if they have completed previous level
	 * 
	 * @param user  which is of type Player will be used to check level progress and
	 *              other
	 * @param debug which be used to know whether to open the level select debug
	 *              mode or not
	 * @return displays the GUI for world selection screen
	 * @author Manuel Saldivar
	 */
	public void Worldselect(Player user, boolean debug) {
		backgroundmusic.PlayMusic(true);// play the background music
		boolean[][] progress = user.getLevelProgress();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Skull2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// this section is for the world one button, all new players can enter this
		// world without problems
		// no need to check level progress here
		JButton WorldOneButton = new JButton("World 1");
		WorldOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				// if user is of type debugger, then will open a special debugging screen for
				// them
				if (debug == true) {
					LevelSelectDebugMode frame = new LevelSelectDebugMode();
					frame.levelselectdebugmode(user, 0, "World1.jpg", "Grass Lands");
					frame.setResizable(false);
					frame.setVisible(true);
				} else {
					LevelSelect frame = new LevelSelect();
					frame.Levelselect(user, 0, "World1.jpg", "Grass lands");
					frame.setResizable(false);
					frame.setVisible(true);
				}

			}
		});
		WorldOneButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Addition.jpg")));
		WorldOneButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		WorldOneButton.setBackground(new Color(255, 250, 240));
		WorldOneButton.setBounds(33, 114, 122, 73);
		// this section is for the world two button, must check whether user has
		// completed previous level
		// or beyond that
		JButton WorldTwoButton = new JButton("World 2");
		if (progress[1][0] == false) {// if havent finished world one level 5 then disable access
			WorldTwoButton.setEnabled(false);
		}
		WorldTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				// if user is of type debugger, then will open a special debugging screen for
				// them
				if (debug == true) {
					LevelSelectDebugMode frame = new LevelSelectDebugMode();
					frame.levelselectdebugmode(user, 1, "World2.jpg", "Dusty Dunes");
					frame.setResizable(false);
					frame.setVisible(true);
				} else {
					LevelSelect frame = new LevelSelect();
					frame.Levelselect(user, 1, "World2.jpg", "Dusty Dunes");
					frame.setResizable(false);
					frame.setVisible(true);
				}
			}
		});
		WorldTwoButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Subtraction.jpg")));
		WorldTwoButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
		WorldTwoButton.setBounds(204, 114, 122, 73);
		contentPane.add(WorldTwoButton);
		// this section is for the world three button
		// progress is checked to enable or disable the button
		JButton WorldThreeButton = new JButton("World 3");
		if (progress[2][0] == false) {// if havent finished world 2 level 5 then disable button
			WorldThreeButton.setEnabled(false);
		}
		WorldThreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				if (debug == true) {
					LevelSelectDebugMode frame = new LevelSelectDebugMode();
					frame.levelselectdebugmode(user, 2, "World3.jpg", "Crystal Caves");
					frame.setResizable(false);
					frame.setVisible(true);
				} else {
					LevelSelect frame = new LevelSelect();
					frame.Levelselect(user, 2, "World3.jpg", "Crystal Caves");
					frame.setResizable(false);
					frame.setVisible(true);
				}
			}
		});
		WorldThreeButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Multiplication.jpg")));
		WorldThreeButton.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		WorldThreeButton.setBounds(373, 115, 122, 73);
		contentPane.add(WorldThreeButton);

		// this section is for the worldfour button
		// progress is checked to enable or disable the button
		JButton WorldFourButton = new JButton("World 4");
		if (progress[3][0] == false) {
			WorldFourButton.setEnabled(false);
		}
		WorldFourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				// if user is of type debugger, then will open a special debugging screen for
				// them
				if (debug == true) {
					LevelSelectDebugMode frame = new LevelSelectDebugMode();
					frame.levelselectdebugmode(user, 3, "World4.jpg", "Lava Lagoon");
					frame.setResizable(false);
					frame.setVisible(true);
				} else {
					LevelSelect frame = new LevelSelect();
					frame.Levelselect(user, 3, "World4.jpg", "Lava Lagoon");
					frame.setResizable(false);
					frame.setVisible(true);
				}
			}
		});
		WorldFourButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Division.jpg")));
		WorldFourButton.setBackground(new Color(255, 250, 240));
		WorldFourButton.setFont(new Font("Vivaldi", Font.BOLD, 14));
		WorldFourButton.setBounds(547, 115, 143, 71);
		contentPane.add(WorldFourButton);

		JTextArea txtrWorld = new JTextArea();
		txtrWorld.setEditable(false);
		txtrWorld.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		txtrWorld.setText("      World 1");
		txtrWorld.setBounds(33, 200, 122, 22);
		contentPane.add(txtrWorld);

		txtWorld = new JTextField();
		txtWorld.setEditable(false);
		txtWorld.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		txtWorld.setText("      World 2");
		txtWorld.setBounds(204, 202, 125, 20);
		contentPane.add(txtWorld);
		txtWorld.setColumns(10);

		txtWorld_1 = new JTextField();
		txtWorld_1.setEditable(false);
		txtWorld_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		txtWorld_1.setText("     World 3");
		txtWorld_1.setBounds(373, 202, 122, 20);
		contentPane.add(txtWorld_1);
		txtWorld_1.setColumns(10);

		txtWorld_2 = new JTextField();
		txtWorld_2.setEditable(false);
		txtWorld_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		txtWorld_2.setText("       World 4");
		txtWorld_2.setBounds(547, 202, 143, 20);
		contentPane.add(txtWorld_2);
		txtWorld_2.setColumns(10);

		// this coponent is to go back AKA the main menu
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu su = new MainMenu(user);
				su.setVisible(true);
				backgroundmusic.StopMusic();
				dispose();
			}
		});
		BackButton.setBounds(44, 21, 89, 23);
		contentPane.add(BackButton);

		// this component is for the FinalLevel button
		// progress is checked to enable or disable the button
		JButton FinalLevel = new JButton("");
		if (progress[4][0] == false) {
			FinalLevel.setEnabled(false);
		}
		FinalLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				backgroundmusic.StopMusic();
				// if user is of type debugger, then will open a special debugging screen for
				// them
				if (debug == true) {
					FinalLevelSelectDebugMode frame = new FinalLevelSelectDebugMode();
					frame.FinalLevelselectDebugMode(user, 4, "World5.jpg", "Lunar Landing");
					frame.setResizable(false);
					frame.setVisible(true);
				} else {
					FinalLevelSelect frame = new FinalLevelSelect();
					frame.FinalLevelselect(user, 4, "World5.jpg", "Lunar Lagoon");
					frame.setResizable(false);
					frame.setVisible(true);
				}
			}
		});
		FinalLevel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Skull2.jpg")));
		FinalLevel.setBounds(272, 260, 162, 87);
		contentPane.add(FinalLevel);

		JTextArea txtrFinalLevel = new JTextArea();
		txtrFinalLevel.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		txtrFinalLevel.setEditable(false);
		txtrFinalLevel.setText("         Final Level");
		txtrFinalLevel.setBounds(272, 371, 162, 22);
		contentPane.add(txtrFinalLevel);

		contentPane.add(WorldOneButton);
		JLabel BackGroundImage = new JLabel("World 2");
		BackGroundImage.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		BackGroundImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("MarioBackground.jpg")));
		BackGroundImage.setBounds(0, 0, 861, 482);
		contentPane.add(BackGroundImage);

	}

}
