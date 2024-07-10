import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

/**
 * Class that displays each panel for the story of the game
 * @author Matthew Nazaruk
 *
 */
public class Story extends JFrame{
	private JPanel part1, part2, part3, part4, part5, part6;
	private JTextArea text1, text2, text3, text4;
	private JLabel pic1, pic2, pic3, pic4;
	private JButton button1;
	private Player player;
	private int world;
	private String worldBackground, worldName;
	private boolean debug;
	
	/**
	 * Constructor receives a value which determines what panel to display and then displays it
	 * @param event determines which panel to display
	 * @param player current player data
	 */
	public Story (int event, Player player) {
		this.player = player;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 482);
		switch (event) {
		case 1:
			part1();
			break;
			
		case 2:
			part2();
			break;
			
		case 3:
			part3();
			break;
			
		case 4:
			part4();
			break;
			
		case 5:
			part5();
			break;
			
		case 6:
			part6();
			break;
		}
		setVisible(true);
	}
	
	/**
	 * Constructor receives a value which determines what panel to display and then displays it. Contains more parameters to return to the proper world.
	 * @param event determines which panel to display
	 * @param player current player data
	 * @param world number representation of the current world
	 * @param debug whether it is in debug mode
	 * @param wrldbg name of the world background picture
	 * @param wrldnm name of the world
	 */
	public Story (int event, Player player, int world, boolean debug, String wrldbg, String wrldnm) {
		this.player = player;
		this.world = world;
		this.debug = debug;
		worldBackground = wrldbg;
		worldName = wrldnm;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 482);
		switch (event) {
		case 1:
			part1();
			break;
			
		case 2:
			part2();
			break;
			
		case 3:
			part3();
			break;
			
		case 4:
			part4();
			break;
			
		case 5:
			part5();
			break;
			
		case 6:
			part6();
			break;
		}
		setVisible(true);
	}
	
	/**
	 * Method displays the first part of the story
	 */
	private void part1() {
		//Initializes the panel
		part1 = new JPanel();
		part1.setBounds(new Rectangle(100, 100, 861, 482));
		part1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(part1);
		part1.setLayout(null);
		
		//Writes all of the text
		text1 = new JTextArea("The Kingdom of Numeralia was once a peaceful kingdom\n"
				+ "where all would prosper.");
		text1.setBounds(30, 195, 360, 40);
		text1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part1.add(text1);
		
		text2 = new JTextArea("But this all changed when Infinityus Prime along with\n"
				+ "the Geometric 4 and the rest of the Infinite Legion\n"
				+ "invaded the kingdom.");
		text2.setBounds(470, 175, 360, 60);
		text2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part1.add(text2);
		
		text3 = new JTextArea("However, just when all hope seemed lost, one brave soul\n"
				+ "set forth to defeat the Infinite Legion and restore the\n"
				+ "Kingdom of Numeralia back to its former glory.");
		text3.setBounds(30, 380, 360, 60);
		text3.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part1.add(text3);
		
		text4 = new JTextArea("Thus, he began his journey by  travelling to the Wispy\n"
				+ "Woods where he would confront the first of the\n"
				+ "Geometric 4, Summatrius, The Infinite Aggregator.");
		text4.setBounds(470, 380, 360, 60);
		text4.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part1.add(text4);
		
		//Displays all the pictures
		pic1 = new JLabel("");
		pic1.setBounds(0, 0, 430, 240);
		pic1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part1TopLeft.jpg")));
		part1.add(pic1);
		
		pic2 = new JLabel("");
		pic2.setBounds(430, 0, 430, 240);
		pic2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part1TopRight.jpg")));
		part1.add(pic2);
		
		pic3 = new JLabel("");
		pic3.setBounds(0, 240, 430, 240);
		pic3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part1BottomLeft.jpg")));
		part1.add(pic3);
		
		pic4 = new JLabel("");
		pic4.setBounds(430, 240, 430, 240);
		pic4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("World1Story.jpg")));
		part1.add(pic4);
		
		//Adds the continue button
		button1 = new JButton("Continue");
		button1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
		button1.setBounds(730, 15, 100, 40);
		button1.setBackground(new Color(255, 255, 0));
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
            	//Opens WorldSelect Window/GUI and Closes MainMenu Window/GUI
            	WorldSelect a=new WorldSelect();
				a.Worldselect(player, false);//
				a.setResizable(false);
				a.setVisible(true);
				dispose();
			}
		});
		part1.add(button1);
	}
	
	/**
	 * Method displays the second part of the story
	 */
	private void part2() {
		//Initializes the panel
		part2 = new JPanel();
		part2.setBounds(new Rectangle(100, 100, 861, 482));
		part2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(part2);
		part2.setLayout(null);
		
		//Writes all of the text
		text1 = new JTextArea("After a hard fought battle, our hero stood victorious over\n"
				+ "Summatrius, The Infinite Aggregator, and the first\n"
				+ "of the Geometric 4.");
		text1.setBounds(30, 175, 360, 60);
		text1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part2.add(text1);
		
		text2 = new JTextArea("Now without any time to rest, he set forth towards the\n"
				+ "Dusty Dunes where he would confront the second of the\n"
				+ "Geometric 4, Subtraxious, The Infinite Reducer.");
		text2.setBounds(30, 380, 360, 60);
		text2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part2.add(text2);
		
		//Displays all the pictures
		pic1 = new JLabel("");
		pic1.setBounds(0, 0, 862, 240);
		pic1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part2Top.jpg")));
		part2.add(pic1);
		
		pic2 = new JLabel("");
		pic2.setBounds(0, 240, 862, 240);
		pic2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("World2Story.jpg")));
		part2.add(pic2);
		
		//Adds the continue button
		button1 = new JButton("Continue");
		button1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
		button1.setBounds(730, 15, 100, 40);
		button1.setBackground(new Color(255, 255, 0));
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(debug == true) {
		 			switch(world) {
		 			case 0:
		 				LevelSelectDebugMode frame1 = new LevelSelectDebugMode();
		 				frame1.setResizable(false);
		 				frame1.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelectDebugMode frame2 = new LevelSelectDebugMode();
		 				frame2.setResizable(false);
		 				frame2.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelectDebugMode frame3 = new LevelSelectDebugMode();
		 				frame3.setResizable(false);
		 				frame3.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelectDebugMode frame4 = new LevelSelectDebugMode();
		 				frame4.setResizable(false);
		 				frame4.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelectDebugMode frame5 = new FinalLevelSelectDebugMode();
		 				frame5.FinalLevelselectDebugMode(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
		 		else {
		 			switch(world) {
		 			case 0:
		 				LevelSelect frame1 = new LevelSelect();
		 				frame1.setResizable(false);
		 				frame1.Levelselect(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelect frame2 = new LevelSelect();
		 				frame2.setResizable(false);
		 				frame2.Levelselect(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelect frame3 = new LevelSelect();
		 				frame3.setResizable(false);
		 				frame3.Levelselect(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelect frame4 = new LevelSelect();
		 				frame4.setResizable(false);
		 				frame4.Levelselect(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelect frame5 = new FinalLevelSelect();
		 				frame5.FinalLevelselect(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
			}
		});
		part2.add(button1);
	}
	
	/**
	 * Method displays the third part of the story
	 */
	private void part3() {
		//Initializes the panel
		part3 = new JPanel();
		part3.setBounds(new Rectangle(100, 100, 861, 482));
		part3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(part3);
		part3.setLayout(null);
		
		//Writes all of the text
		text1 = new JTextArea("While braving the heat of the Dusty Dunes, our hero\n"
				+ "was able to emerge victorious against Subtraxious,\n"
				+ "the second of the Geometric 4.");
		text1.setBounds(30, 175, 360, 60);
		text1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part3.add(text1);
		
		text2 = new JTextArea("Now he continues his journey by travelling to the\n"
				+ "Crystal Caves where he will confront the third of the\n"
				+ "Geometric 4, Multiplicitus, The Infinite Multiplier.");
		text2.setBounds(30, 380, 360, 60);
		text2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part3.add(text2);
		
		//Displays all the pictures
		pic1 = new JLabel("");
		pic1.setBounds(0, 0, 862, 240);
		pic1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part3Top.jpg")));
		part3.add(pic1);
		
		pic2 = new JLabel("");
		pic2.setBounds(0, 240, 862, 240);
		pic2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("World3Story.jpg")));
		part3.add(pic2);
		
		//Adds the continue button
		button1 = new JButton("Continue");
		button1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
		button1.setBounds(730, 15, 100, 40);
		button1.setBackground(new Color(255, 255, 0));
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(debug == true) {
		 			switch(world) {
		 			case 0:
		 				LevelSelectDebugMode frame1 = new LevelSelectDebugMode();
		 				frame1.setResizable(false);
		 				frame1.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelectDebugMode frame2 = new LevelSelectDebugMode();
		 				frame2.setResizable(false);
		 				frame2.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelectDebugMode frame3 = new LevelSelectDebugMode();
		 				frame3.setResizable(false);
		 				frame3.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelectDebugMode frame4 = new LevelSelectDebugMode();
		 				frame4.setResizable(false);
		 				frame4.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelectDebugMode frame5 = new FinalLevelSelectDebugMode();
		 				frame5.FinalLevelselectDebugMode(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
		 		else {
		 			switch(world) {
		 			case 0:
		 				LevelSelect frame1 = new LevelSelect();
		 				frame1.setResizable(false);
		 				frame1.Levelselect(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelect frame2 = new LevelSelect();
		 				frame2.setResizable(false);
		 				frame2.Levelselect(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelect frame3 = new LevelSelect();
		 				frame3.setResizable(false);
		 				frame3.Levelselect(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelect frame4 = new LevelSelect();
		 				frame4.setResizable(false);
		 				frame4.Levelselect(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelect frame5 = new FinalLevelSelect();
		 				frame5.FinalLevelselect(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
			}
		});
		part3.add(button1);
	}
	
	/**
	 * Method displays the fourth part of the story
	 */
	private void part4() {
		//Initializes the panel
		part4 = new JPanel();
		part4.setBounds(new Rectangle(100, 100, 861, 482));
		part4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(part4);
		part4.setLayout(null);
		
		//Writes all of the text
		text1 = new JTextArea("After navigating the treacherous labyrinth known as the Crystal Caves,\n"
				+ "our hero confronted Multiplicitus, The Infinite Multipliers, where\n"
				+ "he emerged victorious having now beaten three of the Geometric 4.");
		text1.setBounds(30, 175, 450, 60);
		text1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part4.add(text1);
		
		text2 = new JTextArea("He will now set foot in the fiery inferno known as the Lava\n"
				+ "Lagoon where he will confront the final and deadliest\n"
				+ "of the Geometric 4, Dividarus, The Infinite Divider.");
		text2.setBounds(30, 380, 370, 60);
		text2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part4.add(text2);
		
		//Displays all the pictures
		pic1 = new JLabel("");
		pic1.setBounds(0, 0, 862, 240);
		pic1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part4Top.jpg")));
		part4.add(pic1);
		
		pic2 = new JLabel("");
		pic2.setBounds(0, 238, 862, 240);
		pic2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("World4Story.jpg")));
		part4.add(pic2);
		
		//Adds the continue button
		button1 = new JButton("Continue");
		button1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
		button1.setBounds(730, 15, 100, 40);
		button1.setBackground(new Color(255, 255, 0));
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(debug == true) {
		 			switch(world) {
		 			case 0:
		 				LevelSelectDebugMode frame1 = new LevelSelectDebugMode();
		 				frame1.setResizable(false);
		 				frame1.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelectDebugMode frame2 = new LevelSelectDebugMode();
		 				frame2.setResizable(false);
		 				frame2.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelectDebugMode frame3 = new LevelSelectDebugMode();
		 				frame3.setResizable(false);
		 				frame3.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelectDebugMode frame4 = new LevelSelectDebugMode();
		 				frame4.setResizable(false);
		 				frame4.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelectDebugMode frame5 = new FinalLevelSelectDebugMode();
		 				frame5.FinalLevelselectDebugMode(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
		 		else {
		 			switch(world) {
		 			case 0:
		 				LevelSelect frame1 = new LevelSelect();
		 				frame1.setResizable(false);
		 				frame1.Levelselect(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelect frame2 = new LevelSelect();
		 				frame2.setResizable(false);
		 				frame2.Levelselect(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelect frame3 = new LevelSelect();
		 				frame3.setResizable(false);
		 				frame3.Levelselect(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelect frame4 = new LevelSelect();
		 				frame4.setResizable(false);
		 				frame4.Levelselect(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelect frame5 = new FinalLevelSelect();
		 				frame5.FinalLevelselect(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
			}
		});
		part4.add(button1);
	}
	
	/**
	 * Method displays the fifth part of the story
	 */
	private void part5() {
		//Initializes the panel
		part5 = new JPanel();
		part5.setBounds(new Rectangle(100, 100, 861, 482));
		part5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(part5);
		part5.setLayout(null);
		
		//Writes all of the text
		text1 = new JTextArea("After his most difficult battle yet, our hero emerged victorious. Now having\n"
				+ "defeated the Geometric 4, our hero now sets forth to finish what he\n"
				+ "started and complete his goal of restoring peace to the Kingdom of Numeralia.");
		text1.setBounds(30, 175, 500, 60);
		text1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part5.add(text1);
		
		text2 = new JTextArea("He departs for the Lunar Lagoon with his heart beat getting louder and louder until he finally arrives\n"
				+ "at the scene of the final showdown. He must now use all that he has learned throughout his journey\n"
				+ "to defeat the greatest enemy known to the land, the leader of the Infinite Legion, Infinityus Prime.");
		text2.setBounds(30, 380, 630, 60);
		text2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part5.add(text2);
		
		//Displays all the pictures
		pic1 = new JLabel("");
		pic1.setBounds(0, 0, 862, 240);
		pic1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part5Top.jpg")));
		part5.add(pic1);
		
		pic2 = new JLabel("");
		pic2.setBounds(0, 240, 862, 240);
		pic2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("World5Story.jpg")));
		part5.add(pic2);
		
		//Adds the continue button
		button1 = new JButton("Continue");
		button1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
		button1.setBounds(730, 15, 100, 40);
		button1.setBackground(new Color(255, 255, 0));
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(debug == true) {
		 			switch(world) {
		 			case 0:
		 				LevelSelectDebugMode frame1 = new LevelSelectDebugMode();
		 				frame1.setResizable(false);
		 				frame1.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelectDebugMode frame2 = new LevelSelectDebugMode();
		 				frame2.setResizable(false);
		 				frame2.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelectDebugMode frame3 = new LevelSelectDebugMode();
		 				frame3.setResizable(false);
		 				frame3.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelectDebugMode frame4 = new LevelSelectDebugMode();
		 				frame4.setResizable(false);
		 				frame4.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelectDebugMode frame5 = new FinalLevelSelectDebugMode();
		 				frame5.FinalLevelselectDebugMode(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
		 		else {
		 			switch(world) {
		 			case 0:
		 				LevelSelect frame1 = new LevelSelect();
		 				frame1.setResizable(false);
		 				frame1.Levelselect(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelect frame2 = new LevelSelect();
		 				frame2.setResizable(false);
		 				frame2.Levelselect(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelect frame3 = new LevelSelect();
		 				frame3.setResizable(false);
		 				frame3.Levelselect(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelect frame4 = new LevelSelect();
		 				frame4.setResizable(false);
		 				frame4.Levelselect(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelect frame5 = new FinalLevelSelect();
		 				frame5.FinalLevelselect(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
			}
		});
		part5.add(button1);
	}
	
	/**
	 * Method displays the sixth part of the story
	 */
	private void part6() {
		//Initializes the panel
		part6 = new JPanel();
		part6.setBounds(new Rectangle(100, 100, 861, 482));
		part6.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(part6);
		part6.setLayout(null);
		
		//Writes all of the text
		text1 = new JTextArea("After a grueling battle that seemed to stretch across the very fabric of time, our hero stood\n"
				+ "victorious against Infinityus Prime. With a final, decisive blow, he banished the Infinite Legion\n"
				+ "who had threatened the peace of the kingdom and ensured that they would never strike again.");
		text1.setBounds(30, 175, 600, 60);
		text1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part6.add(text1);
		
		text2 = new JTextArea("Having now completed his mission, our hero has successfully restored\n"
				+ "peace to the kingdom. He know ventures back to the capital where\n"
				+ "he will be hailed as the hero of the land until the end of time.");
		text2.setBounds(30, 380, 450, 60);
		text2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		part6.add(text2);
		
		//Displays all the pictures
		pic1 = new JLabel("");
		pic1.setBounds(0, 0, 862, 240);
		pic1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part6Top.jpg")));
		part6.add(pic1);
		
		pic2 = new JLabel("");
		pic2.setBounds(0, 240, 862, 240);
		pic2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("part6Bottom.png")));
		part6.add(pic2);
		
		//Adds the continue button
		button1 = new JButton("Continue");
		button1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
		button1.setBounds(730, 15, 100, 40);
		button1.setBackground(new Color(255, 255, 0));
		button1.setForeground(new Color(0, 0, 0));
		button1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(debug == true) {
		 			switch(world) {
		 			case 0:
		 				LevelSelectDebugMode frame1 = new LevelSelectDebugMode();
		 				frame1.setResizable(false);
		 				frame1.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelectDebugMode frame2 = new LevelSelectDebugMode();
		 				frame2.setResizable(false);
		 				frame2.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelectDebugMode frame3 = new LevelSelectDebugMode();
		 				frame3.setResizable(false);
		 				frame3.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelectDebugMode frame4 = new LevelSelectDebugMode();
		 				frame4.setResizable(false);
		 				frame4.levelselectdebugmode(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelectDebugMode frame5 = new FinalLevelSelectDebugMode();
		 				frame5.FinalLevelselectDebugMode(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
		 		else {
		 			switch(world) {
		 			case 0:
		 				LevelSelect frame1 = new LevelSelect();
		 				frame1.setResizable(false);
		 				frame1.Levelselect(player, world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelect frame2 = new LevelSelect();
		 				frame2.setResizable(false);
		 				frame2.Levelselect(player, world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelect frame3 = new LevelSelect();
		 				frame3.setResizable(false);
		 				frame3.Levelselect(player, world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelect frame4 = new LevelSelect();
		 				frame4.setResizable(false);
		 				frame4.Levelselect(player, world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelect frame5 = new FinalLevelSelect();
		 				frame5.FinalLevelselect(player, world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
			}
		});
		part6.add(button1);
	}
}
