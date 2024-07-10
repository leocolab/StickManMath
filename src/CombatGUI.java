import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.io.*;
/**
 * CombatGUI class used to handle all input and output during combat 
 * @author Matthew Nazaruk
 *
 */
public class CombatGUI extends JFrame {

	private JPanel actionPane, attackPane, itemPane;
	private JLabel combatBackground = new JLabel(""), enemy, player, enemyHP, playerHP, attackBackground, win, loss, item1, item2, item3, useItemBackground, inventoryTitle;
	private JButton itemButton, attackButton, exitButton, useItem1, useItem2, useItem3, returnButton;
	private JProgressBar enemyHealthBar, playerHealthBar, timerBar;
	private JTextField answerText, question, description1, description2, description3, gold;
	private Timer timer;
	private BufferedReader br, reader;
	private BufferedWriter writer;
	private Music bossBackgroundMusic = new Music(getClass().getClassLoader().getResource("bossBackgroundMusic.wav")), backgroundMusic = new Music(getClass().getClassLoader().getResource("backgroundMusic.wav")), block = new Music(getClass().getClassLoader().getResource("blockSound.wav")),
			attack = new Music(getClass().getClassLoader().getResource("attackSound.wav")), enemyHit = new Music(getClass().getClassLoader().getResource("enemyDamageSound.wav")), playerHit = new Music(getClass().getClassLoader().getResource("playerDamageSound.wav")), item = new Music(getClass().getClassLoader().getResource("useItemSound.wav")),
			lose = new Music(getClass().getClassLoader().getResource("loseSound.wav")), victory = new Music(getClass().getClassLoader().getResource("victorySound.wav"));
	private Combat x;
	private int world, level, levelProgress;
	private boolean timerSet, debug, success = false;
	private String answer, line, worldBackground, worldName;
	private String [] equation = new String[2], data = new String[8], line2;

	/**
	 * CombatGUI constructor. Sets the frame and displays the combat page.
	 * @param user the players account information
	 * @param world the world the level is in
	 * @param level the level being played
	 * @param timer whether the timer is turned on or off
	 * @param debug whether this is in debug mode or not
	 * @param wrldbg the world background file name
	 * @param wrldnm the name of the world
	 */
	public CombatGUI(Player user, int world, int level, boolean timer, boolean debug, String wrldbg, String wrldnm) {
		//Starts playing background music
		if(world == 4)
			bossBackgroundMusic.PlayMusic(true);
		else
			backgroundMusic.PlayMusic(true);
		
		x = new Combat(world, level, user);
		new EquationGenerator(world);
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/equations.csv"));
		}
		catch(Exception e) {
			System.out.println("Unable to open equations file");
		}
		
		worldBackground = wrldbg;
		worldName = wrldnm;
		timerSet = timer;
		this.debug = debug;
		this.world = world;
		this.level = level;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 482);
		action();
		setVisible(true);	

	}
	
	/**
	 * Creates and displays the panel where the player decides what action to choose
	 */
	private void action() {
		//Creates and sets dimensions of the panel
		actionPane = new JPanel();
		actionPane.setBounds(new Rectangle(0, 0, 861, 482));
		actionPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(actionPane);
		actionPane.setLayout(null);
		
		//Adds the enemy depending on what level you are on as well as the player HP
		enemy = new JLabel("");
		enemyHP = new JLabel("HP: " + x.getEnemyHealth());
		playerHP = new JLabel("HP: " + x.getPlayerHealth());
		switch(world) {
		case 0:
			//Adds player HP
			playerHP.setForeground(new Color(255, 255, 255));
			playerHP.setBounds(157, 140, 47, 14);
			playerHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(playerHP);
			
			//Adds enemy HP
			enemyHP.setForeground(new Color(255, 255, 255));
			enemyHP.setBounds(614, 55, 47, 14);
			enemyHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(enemyHP);
			
			switch(level) {
			case 0:
				//Adds enemy picture
				enemy.setBounds(559, 89, 140, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy1.png")));
				actionPane.add(enemy);
				break;
				
			case 1:
				//Adds enemy picture
				enemy.setBounds(540, 89, 206, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy2.png")));
				actionPane.add(enemy);
				break;
				
			case 2:
				//Adds enemy picture
				enemy.setBounds(550, 89, 166, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy3.png")));
				actionPane.add(enemy);
				break;
				
			case 3:
				//Adds enemy HP
				enemy.setBounds(553, 89, 159, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy4.png")));
				actionPane.add(enemy);
				break;
				
			case 4:
				//Adds enemy picture
				enemy.setBounds(535, 89, 216, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Boss1.png")));
				actionPane.add(enemy);
				break;
			}
			break;
			
		case 1:
			//Adds player HP
			playerHP.setForeground(new Color(0, 0, 0));
			playerHP.setBounds(157, 140, 47, 14);
			playerHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(playerHP);
			
			//Adds enemy HP
			enemyHP.setForeground(new Color(0, 0, 0));
			enemyHP.setBounds(614, 55, 47, 14);
			enemyHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(enemyHP);
			
			switch(level) {
			case 0:
				//Adds enemy picture
				enemy.setBounds(559, 89, 140, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy1.png")));
				actionPane.add(enemy);
				break;
				
			case 1:
				//Adds enemy picture
				enemy.setBounds(540, 89, 206, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy2.png")));
				actionPane.add(enemy);
				break;
				
			case 2:
				//Adds enemy picture
				enemy.setBounds(550, 89, 166, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy3.png")));
				actionPane.add(enemy);
				break;
				
			case 3:
				//Adds enemy HP
				enemy.setBounds(553, 89, 159, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy4.png")));
				actionPane.add(enemy);
				break;
				
			case 4:
				//Adds enemy picture
				enemy.setBounds(530, 125, 216, 77);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Boss2.png")));
				actionPane.add(enemy);
				break;
			}
			break;
			
		case 2:
			//Adds player HP
			playerHP.setForeground(new Color(0, 0, 0));
			playerHP.setBounds(157, 140, 47, 14);
			playerHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(playerHP);
			
			//Adds enemy HP
			enemyHP.setForeground(new Color(0, 0, 0));
			enemyHP.setBounds(614, 55, 47, 14);
			enemyHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(enemyHP);
			
			switch(level) {
			case 0:
				//Adds enemy picture
				enemy.setBounds(559, 89, 140, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy1.png")));
				actionPane.add(enemy);
				break;
				
			case 1:
				//Adds enemy picture
				enemy.setBounds(540, 89, 206, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy2.png")));
				actionPane.add(enemy);
				break;
				
			case 2:
				//Adds enemy picture
				enemy.setBounds(550, 89, 166, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy3.png")));
				actionPane.add(enemy);
				break;
				
			case 3:
				//Adds enemy HP
				enemy.setBounds(553, 89, 159, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy4.png")));
				actionPane.add(enemy);
				break;
				
			case 4:
				//Adds enemy picture
				enemy.setBounds(530, 89, 216, 201);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Boss3.png")));
				actionPane.add(enemy);
				break;
			}
			break;
			
		case 3:
			//Adds player HP
			playerHP.setForeground(new Color(255, 255, 255));
			playerHP.setBounds(157, 140, 47, 14);
			playerHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(playerHP);
			
			//Adds enemy HP
			enemyHP.setForeground(new Color(255, 255, 255));
			enemyHP.setBounds(614, 55, 47, 14);
			enemyHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(enemyHP);
			
			switch(level) {
			case 0:
				//Adds enemy picture
				enemy.setBounds(559, 89, 140, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy1.png")));
				actionPane.add(enemy);
				break;
				
			case 1:
				//Adds enemy picture
				enemy.setBounds(540, 89, 206, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy2.png")));
				actionPane.add(enemy);
				break;
				
			case 2:
				//Adds enemy picture
				enemy.setBounds(550, 89, 166, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy3.png")));
				actionPane.add(enemy);
				break;
				
			case 3:
				//Adds enemy HP
				enemy.setBounds(553, 89, 159, 208);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Enemy4.png")));
				actionPane.add(enemy);
				break;
				
			case 4:
				//Adds enemy picture
				enemy.setBounds(530, 89, 216, 183);
				enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Boss4.png")));
				actionPane.add(enemy);
				
				//Adds enemy HP
				enemyHP.setForeground(new Color(255, 255, 255));
				enemyHP.setBounds(614, 55, 47, 14);
				enemyHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
				actionPane.add(enemyHP);
				
				//Adds player HP
				playerHP.setForeground(new Color(255, 255, 255));
				playerHP.setBounds(157, 140, 47, 14);
				playerHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
				actionPane.add(playerHP);
				break;
			}
			break;
			
		case 4:
			//Adds enemy picture
			enemy.setBounds(530, 115, 216, 97);
			enemy.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Boss5.png")));
			actionPane.add(enemy);
			
			//Adds enemy HP
			enemyHP.setForeground(new Color(255, 255, 255));
			enemyHP.setBounds(614, 55, 47, 14);
			enemyHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(enemyHP);
			
			//Adds player HP
			playerHP.setForeground(new Color(255, 255, 255));
			playerHP.setBounds(157, 140, 47, 14);
			playerHP.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
			actionPane.add(playerHP);
			break;
		}
		
		//Adds enemy health bar
		enemyHealthBar = new JProgressBar();
		enemyHealthBar.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
		enemyHealthBar.setBounds(543, 36, 189, 14);
		enemyHealthBar.setString("");
		enemyHealthBar.setStringPainted(true);
		enemyHealthBar.setMaximum(x.getBaseEnemyHealth());
		enemyHealthBar.setForeground(new Color(255, 0, 0));
		enemyHealthBar.setValue(x.getEnemyHealth());
		actionPane.add(enemyHealthBar);
				
		//Adds the player picture
		player = new JLabel("");
		player.setBounds(116, 164, 120, 268);
		player.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Stickman.png")));
		actionPane.add(player);
		
		//Adds player health bar
		playerHealthBar = new JProgressBar();
		playerHealthBar.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
		playerHealthBar.setBounds(86, 121, 189, 14);
		playerHealthBar.setString("");
		playerHealthBar.setStringPainted(true);
		playerHealthBar.setMaximum(x.getBasePlayerHealth());
		playerHealthBar.setForeground(new Color(255, 0, 0));
		playerHealthBar.setValue(x.getPlayerHealth());
		actionPane.add(playerHealthBar);
		
		//Adds the attack button
		attackButton = new JButton("Attack");
		attackButton.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
		attackButton.setBounds(530, 378, 96, 45);
		attackButton.setBackground(new Color(255, 255, 0));
		attackButton.setForeground(new Color(0, 0, 0));
		attackButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		attackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack();
			}
		});
		actionPane.add(attackButton);
		
		//Adds the exit button
		exitButton = new JButton("Exit");
		exitButton.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
		exitButton.setBounds(5, 5, 89, 30);
		exitButton.setBackground(new Color(255, 255, 0));
		exitButton.setForeground(new Color(0, 0, 0));
		exitButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Stops playing background music
		 		if(world == 4)
		 			bossBackgroundMusic.StopMusic();
		 		else
		 			backgroundMusic.StopMusic();
		 		
		 		dispose();
		 		
		 		if(success == true && level == 4)
		 			new Story(world+2, x.getPlayer(), world, debug, worldBackground, worldName);
		 		
		 		else if (success == true && world == 4)
		 			new Story(world+2, x.getPlayer(), world, debug, worldBackground, worldName);
		 		
		 		else if(debug == true) {
		 			switch(world) {
		 			case 0:
		 				LevelSelectDebugMode frame1 = new LevelSelectDebugMode();
		 				frame1.setResizable(false);
		 				frame1.levelselectdebugmode(x.getPlayer(), world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelectDebugMode frame2 = new LevelSelectDebugMode();
		 				frame2.setResizable(false);
		 				frame2.levelselectdebugmode(x.getPlayer(), world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelectDebugMode frame3 = new LevelSelectDebugMode();
		 				frame3.setResizable(false);
		 				frame3.levelselectdebugmode(x.getPlayer(), world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelectDebugMode frame4 = new LevelSelectDebugMode();
		 				frame4.setResizable(false);
		 				frame4.levelselectdebugmode(x.getPlayer(), world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelectDebugMode frame5 = new FinalLevelSelectDebugMode();
		 				frame5.FinalLevelselectDebugMode(x.getPlayer(), world, worldBackground, worldName);
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
		 				frame1.Levelselect(x.getPlayer(), world, worldBackground, worldName);
		 				frame1.setVisible(true);
		 				break;
		 				
		 			case 1:
		 				LevelSelect frame2 = new LevelSelect();
		 				frame2.setResizable(false);
		 				frame2.Levelselect(x.getPlayer(), world, worldBackground, worldName);
		 				frame2.setVisible(true);
		 				break;
		 				
		 			case 2:
		 				LevelSelect frame3 = new LevelSelect();
		 				frame3.setResizable(false);
		 				frame3.Levelselect(x.getPlayer(), world, worldBackground, worldName);
		 				frame3.setVisible(true);
		 				break;
		 				
		 			case 3:
		 				LevelSelect frame4 = new LevelSelect();
		 				frame4.setResizable(false);
		 				frame4.Levelselect(x.getPlayer(), world, worldBackground, worldName);
		 				frame4.setVisible(true);
		 				break;
		 				
		 			case 4:
		 				FinalLevelSelect frame5 = new FinalLevelSelect();
		 				frame5.FinalLevelselect(x.getPlayer(), world, worldBackground, worldName);
		 				frame5.setResizable(false);
		 				frame5.setVisible(true);
		 				break;
		 			}
		 		}
		 			
		 			
				
			}
		});
		actionPane.add(exitButton);
		
		//Adds the use item button
		itemButton = new JButton("Use Item");
		itemButton.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
		itemButton.setBounds(695, 378, 96, 45);
		itemButton.setBackground(new Color(255, 255, 0));
		itemButton.setForeground(new Color(0, 0, 0));
		itemButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		itemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useItem();
			}
		});
		actionPane.add(itemButton);
		
		//Adds the background depending on what world you are in
		switch(world) {
		case 0:
			combatBackground.setBounds(0, 0, 845, 443);
			combatBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("CombatW1.jpg")));
			actionPane.add(combatBackground);
			break;
		
		case 1:
			combatBackground.setBounds(0, 0, 845, 443);
			combatBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("CombatW2.jpg")));
			actionPane.add(combatBackground);
			break;
			
		case 2:
			combatBackground.setBounds(0, 0, 845, 443);
			combatBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("CombatW3.jpg")));
			actionPane.add(combatBackground);
			break;
			
		case 3:
			combatBackground.setBounds(0, 0, 845, 443);
			combatBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("CombatW4.jpg")));
			actionPane.add(combatBackground);
			break;
		
		case 4:
			combatBackground.setBounds(0, 0, 845, 443);
			combatBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("CombatW5.jpg")));
			actionPane.add(combatBackground);
			break;
		}
	}
	
	/**
	 * Creates and displays the panel that asks the player a question and verifies the answer
	 */
	private void attack() {		
		//Gets the equation from the csv file
		try {
			line = br.readLine();
			equation = line.split(",");
		}
		catch(Exception e) {
			System.out.println("Unable to read line in equations file");
		}
		
		//Creates and sets dimensions of the panel
		attackPane = new JPanel();
		attackPane.setBounds(new Rectangle(0, 0, 861, 482));
		attackPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(attackPane);
		attackPane.setLayout(null);
				
		if(timerSet == true) {
			//Adds timer bar
			x.setBaseTime();
			timerBar = new JProgressBar();
			timerBar.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), null));
			timerBar.setBounds(305, 80, 250, 40);
			timerBar.setString("");
			timerBar.setStringPainted(true);
			timerBar.setMaximum(x.getBaseTime());
			timerBar.setMinimum(1);
			timerBar.setValue(x.getBaseTime());
			timerBar.setForeground(new Color(255, 0, 0));
			attackPane.add(timerBar);
					
			//Adds the timer
			ActionListener timerAction = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					x.setTime(x.getTime() - 1);
					timerBar.setValue(x.getTime());
					if(x.getTime() == 0) {
						timer.stop();
						if(x.getBlock() == true) {
							//Plays the block sound effect
							block.reset();
					 		block.PlayMusic(false);
					 		x.setBlock(false);
						}	
						else {
							//Plays the playerHit sound effect
							playerHit.reset();
					 		playerHit.PlayMusic(false);
							x.setPlayerHealth(x.getPlayerHealth() - x.getEnemyStrength());
						}
						
						if(x.getPlayerHealth() <= 0) {
							action();
							loss();
						}
						else
							action();
					}
				}
			};
			timer = new Timer(1000, timerAction);
			timer.setRepeats(true);
			timer.start();
	}
		
		//Adds the text field to answer the question
		answerText = new JTextField(3);
		answerText.setHorizontalAlignment(SwingConstants.CENTER);
		answerText.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
		answerText.setBounds(305, 240, 250, 80);
		answerText.addKeyListener(new KeyAdapter() {  //Sets the maximum number of characters entered to 3
			public void keyTyped(KeyEvent e) {
				if(answerText.getText().length() > 2)
					e.consume();
			}
		});
		answerText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = answerText.getText();
				if (answer.equals(equation[1])) {
					if(timerSet == true)
						timer.stop();
					//Plays the attack and enemy hit sound effect
					attack.reset();
					enemyHit.reset();
			 		attack.PlayMusic(false);
			 		enemyHit.PlayMusic(false);
			 		
					x.setEnemyHealth(x.getEnemyHealth() - x.getPlayerStrength());
					
					if(x.getPlayerStrength() != 1) //Reverts player strength to 1 if an item was used
						x.setPlayerStrength(1);
				}
				else {
					if(timerSet == true)
						timer.stop();
					if(x.getBlock() == true) {
						//Plays the block sound effect
						block.reset();
				 		block.PlayMusic(false);
						x.setBlock(false); //Reverts block to false if an item was used
					}
					else {
						//Plays the incorrect sound effect
						playerHit.reset();
				 		playerHit.PlayMusic(false);
						x.setPlayerHealth(x.getPlayerHealth() - x.getEnemyStrength());
					}
				}
				
				if(x.getPlayerHealth() <= 0) {
					action();
					loss();
				}
				else if(x.getEnemyHealth() <= 0) {
					action();
					win();
				}
				else
					action();
			}
		});
		answerText.setVisible(true);
		attackPane.add(answerText);
		answerText.requestFocus();
		
		//Adds the text field displaying the question
		question = new JTextField(equation[0]);
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
		question.setEditable(false);
		question.setBounds(305, 140, 250, 80); 
		attackPane.add(question);
		
		//Adds the background picture
		attackBackground = new JLabel("");
		attackBackground.setBounds(0,0, 861, 482);
		attackBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("questionBackground.jpg")));
		attackPane.add(attackBackground);
	}
	
	/**
	 * Creates and displays the panel that allows the player to choose to use an item from their inventory
	 */
	private void useItem () {
		//Creates and sets dimensions of the panel
		itemPane = new JPanel();
		itemPane.setBounds(new Rectangle(0, 0, 861, 482));
		itemPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(itemPane);
		itemPane.setLayout(null);
		
		//Adds inventory title
		inventoryTitle = new JLabel("INVENTORY");
		inventoryTitle.setForeground(new Color(255, 255, 255));
		inventoryTitle.setBounds(330, 25, 200, 40);
		inventoryTitle.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
		itemPane.add(inventoryTitle);
		
		//Adds return button
		returnButton = new JButton("Return");
		returnButton.setHorizontalAlignment(SwingConstants.CENTER);
		returnButton.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
		returnButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		returnButton.setBackground(new Color(255, 255, 0));
		returnButton.setForeground(new Color(0, 0, 0));
		returnButton.setBounds(5, 5, 89, 30);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action();
			}
		});
		itemPane.add(returnButton);
		
		//Adds item1
		if(x.getPlayer().getItems()[0] != null) {
			//Adds the item picture
			item1 = new JLabel("");
			item1.setBounds(23, 125, 256, 256);
			switch(x.getPlayer().getItems()[0].getName()) {
			case "Gold Double":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold.png")));
				break;
				
			case "Heal Spell":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell.png")));
				break;
				
			case "Strength Boost":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength.png")));
				break;
				
			case "Power Bar":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar.png")));
				break;
				
			case "Gemstone":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone.png")));
				break;
				
			case "Ring":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring.png")));
				break;
				
			case "Mega Boost":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost.png")));
				break;
				
			case "Shield":
				item1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield.png")));
				break;
			}
			itemPane.add(item1);
			
			//Adds the button to use item1
			useItem1 = new JButton("Use " + x.getPlayer().getItems()[0].getName());
			useItem1.setHorizontalAlignment(SwingConstants.CENTER);
			useItem1.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
			useItem1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			useItem1.setBackground(new Color(255, 255, 0));
			useItem1.setForeground(new Color(0, 0, 0));
			useItem1.setBounds(48, 400, 206, 30);
			useItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Heals if item heals player
					if(x.getPlayer().getItems()[0].getHeal() == true)
						x.setPlayerHealth(x.getPlayerHealth() + 1);
					
					//Blocks if item blocks next enemy attack
					if(x.getPlayer().getItems()[0].getBlock() == true) 
						x.setBlock(true);
					
					//Increases strength if item increases players strength
					if(x.getPlayer().getItems()[0].getStrength() == true)
						x.setPlayerStrength(2);
					
					//Doubles reward gold if item doubles reward
					if(x.getPlayer().getItems()[0].getDouble() == true) 
						x.setDoubleGold(true);
						
					//plays use item sound, removes item, and returns to actionPane
					item.reset();
					item.PlayMusic(false);
					x.getPlayer().setItem(0, null);
					action();	
				}
			});
			itemPane.add(useItem1);
			
			//Adds the text field displaying the item description
			description1 = new JTextField(x.getPlayer().getItems()[0].getDescription());
			description1.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
			description1.setHorizontalAlignment(SwingConstants.CENTER);
			description1.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			description1.setEditable(false);
			description1.setBounds(23, 85, 256, 30); 
			itemPane.add(description1);
		}
		
		//Adds item2
		if(x.getPlayer().getItems()[1] != null) {
			//Adds the item picture
			item2 = new JLabel("");
			item2.setBounds(302, 125, 256, 256);
			switch(x.getPlayer().getItems()[1].getName()) {
			case "Gold Double":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold.png")));
				break;
				
			case "Heal Spell":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell.png")));
				break;
				
			case "Strength Boost":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength.png")));
				break;
				
			case "Power Bar":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar.png")));
				break;
				
			case "Gemstone":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone.png")));
				break;
				
			case "Ring":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring.png")));
				break;
				
			case "Mega Boost":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost.png")));
				break;
				
			case "Shield":
				item2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield.png")));
				break;
			}
			itemPane.add(item2);
			
			//Adds the button to use item2
			useItem2 = new JButton("Use " + x.getPlayer().getItems()[1].getName());
			useItem2.setHorizontalAlignment(SwingConstants.CENTER);
			useItem2.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
			useItem2.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			useItem2.setBackground(new Color(255, 255, 0));
			useItem2.setForeground(new Color(0, 0, 0));
			useItem2.setBounds(327, 400, 206, 30);
			useItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Heals if item heals player
					if(x.getPlayer().getItems()[1].getHeal() == true)
						x.setPlayerHealth(x.getPlayerHealth() + 1);
					
					//Blocks if item blocks next enemy attack
					if(x.getPlayer().getItems()[1].getBlock() == true) 
						x.setBlock(true);
					
					//Increases strength if item increases players strength
					if(x.getPlayer().getItems()[1].getStrength() == true)
						x.setPlayerStrength(2);
					
					//Doubles reward gold if item doubles reward
					if(x.getPlayer().getItems()[1].getDouble() == true) 
						x.setDoubleGold(true);
						
					//plays use item sound, removes item, and returns to actionPane
					item.reset();
					item.PlayMusic(false);
					x.getPlayer().setItem(1, null);
					action();
				}
			});
			itemPane.add(useItem2);
			
			//Adds the text field displaying the item description
			description2 = new JTextField(x.getPlayer().getItems()[1].getDescription());
			description2.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
			description2.setHorizontalAlignment(SwingConstants.CENTER);
			description2.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			description2.setEditable(false);
			description2.setBounds(302, 85, 256, 30); 
			itemPane.add(description2);
		}
		
		//Adds item3
		if(x.getPlayer().getItems()[2] != null) {
			//Adds the item picture
			item3 = new JLabel("");
			item3.setBounds(581, 125, 256, 256);
			switch(x.getPlayer().getItems()[2].getName()) {
			case "Gold Double":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("doubleGold.png")));
				break;
				
			case "Heal Spell":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("healSpell.png")));
				break;
				
			case "Strength Boost":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("strength.png")));
				break;
				
			case "Power Bar":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("powerBar.png")));
				break;
				
			case "Gemstone":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gemstone.png")));
				break;
				
			case "Ring":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ring.png")));
				break;
				
			case "Mega Boost":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("megaBoost.png")));
				break;
				
			case "Shield":
				item3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("shield.png")));
				break;
			}
			itemPane.add(item3);
			
			//Adds the button to use item3
			useItem3 = new JButton("Use " + x.getPlayer().getItems()[2].getName());
			useItem3.setHorizontalAlignment(SwingConstants.CENTER);
			useItem3.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
			useItem3.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			useItem3.setBackground(new Color(255, 255, 0));
			useItem3.setForeground(new Color(0, 0, 0));
			useItem3.setBounds(606, 400, 206, 30);
			useItem3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Heals if item heals player
					if(x.getPlayer().getItems()[2].getHeal() == true)
						x.setPlayerHealth(x.getPlayerHealth() + 1);
					
					//Blocks if item blocks next enemy attack
					if(x.getPlayer().getItems()[2].getBlock() == true) 
						x.setBlock(true);
					
					//Increases strength if item increases players strength
					if(x.getPlayer().getItems()[2].getStrength() == true)
						x.setPlayerStrength(2);
					
					//Doubles reward gold if item doubles reward
					if(x.getPlayer().getItems()[2].getDouble() == true) 
						x.setDoubleGold(true);
						
					//plays use item sound, removes item, and returns to actionPane
					item.reset();
					item.PlayMusic(false);
					x.getPlayer().setItem(2, null);
					action();	
				}
			});
			itemPane.add(useItem3);
			
			//Adds the text field displaying the item description
			description3 = new JTextField(x.getPlayer().getItems()[2].getDescription());
			description3.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)), null));
			description3.setHorizontalAlignment(SwingConstants.CENTER);
			description3.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
			description3.setEditable(false);
			description3.setBounds(581, 85, 256, 30); 
			itemPane.add(description3);
		}
		
		//Adds the background picture
		useItemBackground = new JLabel("");
		useItemBackground.setBounds(0, 0, 861, 482);
		useItemBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("inventoryBackGround.jpg")));
		itemPane.add(useItemBackground);

	}
	
	/**
	 * Displays the victory screen to the action panel and updates the players stats
	 */
 	private void win() { 	
 		success = true;
 		//Stops playing background music
 		if(world == 4)
 			bossBackgroundMusic.StopMusic();
 		else
 			backgroundMusic.StopMusic();
 		
 		//Plays the victory sound effect
 		victory.reset();
 		victory.PlayMusic(false);
 		
		//Disables the attack and use item buttons
		itemButton.setEnabled(false);
		attackButton.setEnabled(false);
		
		//Adds the win picture
		win = new JLabel("");
		win.setBounds(245, 170, 300, 169); 
		win.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Victory.png")));
		combatBackground.add(win);
		actionPane.add(combatBackground);	
		
		//Doubles reward gold if item used
		if(x.getDoubleGold() == true) {
			x.setRewardGold(x.getRewardGold() * 2);
			x.setDoubleGold(false);
		}
		
		//Adds the text field displaying gold won
		gold = new JTextField(x.getRewardGold() + " Gold");
		gold.setHorizontalAlignment(SwingConstants.CENTER);
		gold.setBorder(new CompoundBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)), null));
		gold.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		gold.setBackground(new Color(255, 255, 255));
		gold.setForeground(new Color(0, 0, 0));
		gold.setEditable(false);
		gold.setBounds(345, 295, 100, 40); 
		actionPane.add(gold);
		
		//Adds the gold to the players account
		x.getPlayer().setGold(x.getPlayer().getGold() + x.getRewardGold());;
		
		//Updates players level progress
		if(world != 4) {
			if(level == 4)
				x.getPlayer().setLevelProgress(world + 1, 0, true);
			else
				x.getPlayer().setLevelProgress(world, level + 1, true);
		}
		
		updateData();
	}
	
 	/**
	 * Displays the loss screen to the action panel and updates the players stats
	 */
	private void loss() {
		//Stops playing background music
 		if(world == 4)
 			bossBackgroundMusic.StopMusic();
 		else
 			backgroundMusic.StopMusic();
 		
		//Plays the fail sound effect
 		lose.reset();
 		lose.PlayMusic(false);
 		
		//Disables the attack and use item buttons
		itemButton.setEnabled(false);
		attackButton.setEnabled(false);
		
		//Adds the loss picture
		loss = new JLabel("");
		loss.setBounds(245, 170, 300, 169);
		loss.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Loss.png")));
		combatBackground.add(loss);
		actionPane.add(combatBackground);
		
		updateData();
	}
	
	/**
	 * Updates the players data to the csv file
	 */
	private void updateData() {
		int count = 0;
		//Gets the players level progress
		levelProgress = 0;
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(x.getPlayer().getLevelProgress()[i][j] == true)
					levelProgress++;
			
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			while((reader.readLine()) != null)
				count++;
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			line2 = new String[count];
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			int i = 0;
			while((line = reader.readLine()) != null) {
				line2[i] = line;
				i++;
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Main_Game_File.csv"));
			int i = 0;
			writer.write(line2[i] + "\n");
			for(i = 1; i < line2.length; i++) {
				data = line2[i].split(",");
				if(data[0].equals(x.getPlayer().getUsername())) {
					data[3] = String.valueOf(x.getPlayer().getGold());
					data[4] = String.valueOf(levelProgress);
					if(x.getPlayer().getItems()[0] != null)
						data[5] = x.getPlayer().getItems()[0].getName();
					else 
						data[5] = "null";
					
					if(x.getPlayer().getItems()[1] != null)
						data[6] = x.getPlayer().getItems()[1].getName();
					else
						data[6] = "null";
					
					if(x.getPlayer().getItems()[2] != null)
						data[7] = x.getPlayer().getItems()[2].getName();
					else
						data[7] = "null";
					
					writer.write(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + ",\n");
				}
				else {
					writer.write(line2[i] + "\n");
				}
			}
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
