import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;


/**
 * The TutGUI class provides a graphical user interface for a tutorial section of a game.
 * This class manages multiple panels to guide the user through various tutorial pages,
 * offering interactive elements to navigate through the tutorial. It's part of a larger
 * game application.
 * 
 * @author Leo Colabrese
 */
public class TutGUI extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JTextField txtClickStart;
    private JTextField txtPreviousGameHistory;
    private JTextField txtReturn;
    private JTextField txtClickOnAnd;
    private JTextField txtReturnToMain;
    private JTextField txtClickUnlockedLevels;
    private JTextField txtClickshopTo;
    private JTextField txtAWorldPage;
    private JTextField txtCombatModeAnswer;
    private JTextField txtInCombatMode;
    private JTextField txtClickTheTop;
    private JTextField txtClickTheBottom;
    private JTextField txtIfYouAttack;
    private JTextField txtIfYouChoose;
    private JTextField txtIfYouAnswer;
    private JTextField txtClickOnAn;
    private JTextField txtYouWillBe;
    private JTextField txtThenViewItem;
    private JTextField txtFromTheMain;
    private JButton thirdExit;
    private JButton fourthExit;
    private JButton fifthExit;
    private JButton sixthExit;
    private JButton seventhExit;
    private JButton firstExit;
    private JTextField txtWorldMap;
    private JTextField txtIfYouChoose_1;
    private JTextField txtIfYouAnswer_1;
    
    /**
     * Constructs a TutGUI object with the provided player information.
     * It initializes the GUI components and sets up the tutorial panels.
     *
     * @param player The player object containing player-specific information.
     */
    public TutGUI(Player player) { 
        // Frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 862, 509);
        setResizable(false);
        getContentPane().setLayout(null);

        // Initialize panels
        initializePanel1();
        initializePanel2();
        initializePanel3();
        initializePanel4();
        initializePanel5();
        initializePanel6();
        initializePanel7(player); 

        // Add panel #1 first
        getContentPane().add(panel1);
        
        //Page 1 components
        
        JLabel pg1Image = new JLabel("");
		pg1Image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Amainpage.png")));
        pg1Image.setBounds(10, 95, 535, 357);
        panel1.add(pg1Image);
        
        txtClickStart = new JTextField();
        txtClickStart.setBackground(new Color(255, 255, 204));
        txtClickStart.setEditable(false);
        txtClickStart.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        txtClickStart.setText("To start a new game, click: \"New Game.\" ");
        txtClickStart.setBounds(482, 43, 351, 51);
        panel1.add(txtClickStart);
        txtClickStart.setColumns(10);
        
        txtPreviousGameHistory = new JTextField();
        txtPreviousGameHistory.setBackground(new Color(255, 255, 204));
        txtPreviousGameHistory.setEditable(false);
        txtPreviousGameHistory.setText("Previous game history will be lost!");
        txtPreviousGameHistory.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        txtPreviousGameHistory.setColumns(10);
        txtPreviousGameHistory.setBounds(545, 95, 303, 51);
        panel1.add(txtPreviousGameHistory);
        
        txtReturn = new JTextField();
        txtReturn.setBackground(new Color(255, 255, 204));
        txtReturn.setText("Click: \"Saved Game\" to return to previous game");
        txtReturn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
        txtReturn.setEditable(false);
        txtReturn.setColumns(10);
        txtReturn.setBounds(42, 43, 410, 51);
        panel1.add(txtReturn);
        
        firstExit = new JButton("Exit");
        firstExit.setBounds(744, 14, 89, 23);
        panel1.add(firstExit);
        firstExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		});
         
        //Page 2 components
        
        JLabel pg2Image = new JLabel("");
	    pg2Image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Amap.png")));
        pg2Image.setBounds(10, 51, 571, 371);
        panel2.add(pg2Image);
        
        txtClickOnAnd = new JTextField();
        txtClickOnAnd.setBackground(new Color(255, 255, 204));
        txtClickOnAnd.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        txtClickOnAnd.setEditable(false);
        txtClickOnAnd.setText("Click on and choose a world!");
        txtClickOnAnd.setBounds(591, 168, 241, 40);
        panel2.add(txtClickOnAnd);
        txtClickOnAnd.setColumns(10);       
        
        JButton secondExit = new JButton("Exit");
        secondExit.setBounds(712, 11, 89, 23);
        panel2.add(secondExit);
        
        txtWorldMap = new JTextField();
        txtWorldMap.setText("World Map");
        txtWorldMap.setFont(new Font("Mongolian Baiti", Font.BOLD, 19));
        txtWorldMap.setEditable(false);
        txtWorldMap.setColumns(10);
        txtWorldMap.setBackground(new Color(255, 255, 204));
        txtWorldMap.setBounds(245, 11, 107, 40);
        panel2.add(txtWorldMap);
        secondExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		});

        // Page 3 components
        
        JLabel world = new JLabel("");
        world.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Aoneworld.png")));
        world.setBounds(267, 57, 579, 332);
        panel3.add(world);
        
        txtReturnToMain = new JTextField();
        txtReturnToMain.setBackground(new Color(255, 255, 204));
        txtReturnToMain.setEditable(false);
        txtReturnToMain.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        txtReturnToMain.setText("Return to World Map with \"Exit\"");
        txtReturnToMain.setBounds(10, 95, 225, 30);
        panel3.add(txtReturnToMain);
        txtReturnToMain.setColumns(10);
        
        txtClickUnlockedLevels = new JTextField();
        txtClickUnlockedLevels.setBackground(new Color(255, 255, 204));
        txtClickUnlockedLevels.setText("Click on unlocked levels to enter combat mode");
        txtClickUnlockedLevels.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtClickUnlockedLevels.setEditable(false);
        txtClickUnlockedLevels.setColumns(10);
        txtClickUnlockedLevels.setBounds(45, 381, 343, 42);
        panel3.add(txtClickUnlockedLevels);
        
        txtClickshopTo = new JTextField();
        txtClickshopTo.setBackground(new Color(255, 255, 204));
        txtClickshopTo.setText("Click \"Shop\" to enter shop and \"Inventory\" to view your special items");
        txtClickshopTo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        txtClickshopTo.setEditable(false);
        txtClickshopTo.setColumns(10);
        txtClickshopTo.setBounds(45, 424, 454, 30);
        panel3.add(txtClickshopTo);
        
        txtAWorldPage = new JTextField();
        txtAWorldPage.setBackground(new Color(255, 255, 204));
        txtAWorldPage.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        txtAWorldPage.setText("A World Page");
        txtAWorldPage.setEditable(false);
        txtAWorldPage.setBounds(523, 11, 170, 42);
        panel3.add(txtAWorldPage);
        txtAWorldPage.setColumns(10);
        
        thirdExit = new JButton("Exit");
        thirdExit.setBounds(747, 4, 89, 23);
        panel3.add(thirdExit);
        thirdExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		});

        //Page 4 components
        
        txtCombatModeAnswer = new JTextField();
        txtCombatModeAnswer.setBackground(new Color(255, 255, 204));
        txtCombatModeAnswer.setEditable(false);
        txtCombatModeAnswer.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
        txtCombatModeAnswer.setText("Combat");
        txtCombatModeAnswer.setBounds(370, 0, 89, 47);
        panel4.add(txtCombatModeAnswer);
        txtCombatModeAnswer.setColumns(10);
        
        JLabel corrLabel = new JLabel("");
        corrLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Acombatplain.png")));
        corrLabel.setBounds(67, 123, 487, 266);
        panel4.add(corrLabel);
        
        txtInCombatMode = new JTextField();
        txtInCombatMode.setBackground(new Color(255, 255, 204));
        txtInCombatMode.setEditable(false);
        txtInCombatMode.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtInCombatMode.setText("To play, first choose attack or use item");
        txtInCombatMode.setBounds(263, 58, 316, 54);
        panel4.add(txtInCombatMode);
        txtInCombatMode.setColumns(10);
        
        txtClickTheTop = new JTextField();
        txtClickTheTop.setBackground(new Color(255, 255, 204));
        txtClickTheTop.setText("Click \"Attack\" to attack");
        txtClickTheTop.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtClickTheTop.setEditable(false);
        txtClickTheTop.setColumns(10);
        txtClickTheTop.setBounds(113, 405, 193, 47);
        panel4.add(txtClickTheTop);
        
        txtClickTheBottom = new JTextField();
        txtClickTheBottom.setBackground(new Color(255, 255, 204));
        txtClickTheBottom.setText("Click \"Use Item\" to use a special power item");
        txtClickTheBottom.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtClickTheBottom.setEditable(false);
        txtClickTheBottom.setColumns(10);
        txtClickTheBottom.setBounds(342, 400, 335, 47);
        panel4.add(txtClickTheBottom);
        
        fourthExit = new JButton("Exit");
        fourthExit.setBounds(744, 14, 89, 23);
        panel4.add(fourthExit);
        fourthExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		});
        
        //Page 5 components
        
        txtCombatModeAnswer = new JTextField();
        txtCombatModeAnswer.setBackground(new Color(255, 255, 153));
        txtCombatModeAnswer.setEditable(false);
        txtCombatModeAnswer.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        txtCombatModeAnswer.setText("If you choose Attack");
        txtCombatModeAnswer.setBounds(110, 23, 234, 47);
        panel5.add(txtCombatModeAnswer);
        txtCombatModeAnswer.setColumns(10);
        
        JLabel vicLabel = new JLabel("");
        vicLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Aattack.png")));
        vicLabel.setBounds(23, 68, 364, 208);
        panel5.add(vicLabel);
        
        JLabel itLabel = new JLabel("");
        itLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Achooseitem.png")));
        itLabel.setBounds(434, 68, 388, 223);
        panel5.add(itLabel);
        
        txtIfYouAttack = new JTextField();
        txtIfYouAttack.setText("If you answer wrong: enemy attacks you. You lose if you reach 0 hp");
        txtIfYouAttack.setFont(new Font("Mongolian Baiti", Font.PLAIN, 18));
        txtIfYouAttack.setEditable(false);
        txtIfYouAttack.setColumns(10);
        txtIfYouAttack.setBackground(new Color(255, 153, 102));
        txtIfYouAttack.setBounds(10, 366, 520, 47);
        panel5.add(txtIfYouAttack);
        
        txtIfYouChoose = new JTextField();
        txtIfYouChoose.setText("Pick a special item from your inventory");
        txtIfYouChoose.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        txtIfYouChoose.setEditable(false);
        txtIfYouChoose.setColumns(10);
        txtIfYouChoose.setBackground(new Color(230, 230, 250));
        txtIfYouChoose.setBounds(478, 282, 324, 47);
        panel5.add(txtIfYouChoose);
        
        txtIfYouAnswer = new JTextField();
        txtIfYouAnswer.setText("Answer the math question");
        txtIfYouAnswer.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        txtIfYouAnswer.setEditable(false);
        txtIfYouAnswer.setColumns(10);
        txtIfYouAnswer.setBackground(new Color(255, 255, 153));
        txtIfYouAnswer.setBounds(84, 287, 221, 36);
        panel5.add(txtIfYouAnswer);
        
        fifthExit = new JButton("Exit");
        fifthExit.setBounds(0, 0, 89, 23);
        panel5.add(fifthExit);
        
        txtIfYouChoose_1 = new JTextField();
        txtIfYouChoose_1.setText("If you choose Use Item");
        txtIfYouChoose_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        txtIfYouChoose_1.setEditable(false);
        txtIfYouChoose_1.setColumns(10);
        txtIfYouChoose_1.setBackground(new Color(230, 230, 250));
        txtIfYouChoose_1.setBounds(478, 23, 274, 47);
        panel5.add(txtIfYouChoose_1);
        
        txtIfYouAnswer_1 = new JTextField();
        txtIfYouAnswer_1.setText("If you answer correctly: you attack enemy. You win if enemy reaches 0 hp");
        txtIfYouAnswer_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 18));
        txtIfYouAnswer_1.setEditable(false);
        txtIfYouAnswer_1.setColumns(10);
        txtIfYouAnswer_1.setBackground(new Color(127, 255, 0));
        txtIfYouAnswer_1.setBounds(10, 416, 571, 47);
        panel5.add(txtIfYouAnswer_1);
        fifthExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		});
        
        // Page 6 components
        
        txtCombatModeAnswer = new JTextField();
        txtCombatModeAnswer.setBackground(new Color(255, 255, 204));
        txtCombatModeAnswer.setEditable(false);
        txtCombatModeAnswer.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        txtCombatModeAnswer.setText("Item Shop");
        txtCombatModeAnswer.setBounds(359, 11, 127, 54);
        panel6.add(txtCombatModeAnswer);
        txtCombatModeAnswer.setColumns(10);
        
        JLabel indv = new JLabel("");
        indv.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Aindividual.png")));
        indv.setBounds(529, 49, 345, 252);
        panel6.add(indv);
        
        JLabel full = new JLabel("");
        full.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ashop.png")));
        full.setBounds(10, 130, 285, 207);
        panel6.add(full);
        
        txtClickOnAn = new JTextField();
        txtClickOnAn.setText("Click on an item of interest");
        txtClickOnAn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtClickOnAn.setEditable(false);
        txtClickOnAn.setColumns(10);
        txtClickOnAn.setBackground(new Color(255, 255, 204));
        txtClickOnAn.setBounds(56, 87, 207, 45);
        panel6.add(txtClickOnAn);
        
        txtYouWillBe = new JTextField();
        txtYouWillBe.setText("Will be brought to its item page ->");
        txtYouWillBe.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
        txtYouWillBe.setEditable(false);
        txtYouWillBe.setColumns(10);
        txtYouWillBe.setBackground(new Color(255, 255, 204));
        txtYouWillBe.setBounds(302, 189, 224, 36);
        panel6.add(txtYouWillBe);
        
        txtThenViewItem = new JTextField();
        txtThenViewItem.setText("Then view item details and click \"Buy Now\" to purchase");
        txtThenViewItem.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        txtThenViewItem.setEditable(false);
        txtThenViewItem.setColumns(10);
        txtThenViewItem.setBackground(new Color(255, 255, 204));
        txtThenViewItem.setBounds(405, 309, 422, 45);
        panel6.add(txtThenViewItem);
        
        sixthExit = new JButton("Exit");
        sixthExit.setBounds(748, 11, 89, 23);
        panel6.add(sixthExit);
        sixthExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		});
       
        // Page 7 components
        
        txtCombatModeAnswer = new JTextField();
        txtCombatModeAnswer.setBackground(new Color(255, 255, 204));
        txtCombatModeAnswer.setEditable(false);
        txtCombatModeAnswer.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        txtCombatModeAnswer.setText("Leaderboard");
        txtCombatModeAnswer.setBounds(0, 387, 107, 36);
        panel7.add(txtCombatModeAnswer);
        txtCombatModeAnswer.setColumns(10);
        
        JLabel lead = new JLabel("");
        lead.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Aleader.png")));
        lead.setBounds(60, 11, 675, 384);
        panel7.add(lead);
        
        txtFromTheMain = new JTextField();
        txtFromTheMain.setText("From the main menu, click \"Leaderboard\" to view the ranks of you and your peers!");
        txtFromTheMain.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        txtFromTheMain.setEditable(false);
        txtFromTheMain.setColumns(10);
        txtFromTheMain.setBackground(new Color(255, 255, 204));
        txtFromTheMain.setBounds(0, 424, 546, 45);
        panel7.add(txtFromTheMain);
        
        seventhExit = new JButton("Exit");
        seventhExit.setBounds(742, 19, 89, 23);
        panel7.add(seventhExit);
        seventhExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
			}
		}); 
    }

    /**Initializes the 1st tutorial page */
    private void initializePanel1() {
        panel1 = new JPanel(null);
        panel1.setBackground(new Color(204, 255, 255));
        panel1.setBounds(0, 0, 858, 472);

        JButton btnSwitchToPanel2 = new JButton("Got it! Next");
        btnSwitchToPanel2.setBackground(new Color(255, 255, 204));
        btnSwitchToPanel2.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        btnSwitchToPanel2.setBounds(673, 392, 143, 51);
        btnSwitchToPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel2);
            }
        });

        panel1.add(btnSwitchToPanel2);
    }
    
    /** Initializes the 2nd tutorial page */
    private void initializePanel2() {
        panel2 = new JPanel(null);
        panel2.setBackground(new Color(204, 255, 255));
        panel2.setBounds(0, 0, 862, 509);

        JButton btnSwitchToPanel3 = new JButton("Got it, next!");
        btnSwitchToPanel3.setBackground(new Color(255, 255, 204));
        btnSwitchToPanel3.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        btnSwitchToPanel3.setBounds(602, 363, 179, 40);
        btnSwitchToPanel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel3);
            }
        });

        panel2.add(btnSwitchToPanel3);
    }
    
    /** Initializes the 3rd tutorial page */
    private void initializePanel3() {
        panel3 = new JPanel(null);
        panel3.setBackground(new Color(204, 255, 255));
        panel3.setBounds(0, 0, 862, 509);

        JButton btnSwitchToPanel4 = new JButton("Got it, Next!");
        btnSwitchToPanel4.setBackground(new Color(255, 255, 204));
        btnSwitchToPanel4.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        btnSwitchToPanel4.setBounds(667, 400, 134, 36);
        btnSwitchToPanel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel4);
            }
        });

        panel3.add(btnSwitchToPanel4);
    }
    
    /** Initializes the 4th tutorial page */
    private void initializePanel4() {
        panel4 = new JPanel(null);
        panel4.setBackground(new Color(204, 255, 255));
        panel4.setBounds(0, 0, 862, 509);

        JButton btnSwitchToPanel5 = new JButton("Got it, Next!");
        btnSwitchToPanel5.setBackground(new Color(255, 255, 204));
        btnSwitchToPanel5.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        btnSwitchToPanel5.setBounds(683, 416, 134, 36);
        btnSwitchToPanel5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel5);
            }
        });

        panel4.add(btnSwitchToPanel5);
    }
    
    /** Initializes the 5th tutorial page */
    private void initializePanel5() {
        panel5 = new JPanel(null);
        panel5.setBackground(new Color(204, 255, 255));
        panel5.setBounds(0, 0, 862, 509);

        JButton btnSwitchToPanel6 = new JButton("Got it, Next!");
        btnSwitchToPanel6.setBackground(new Color(255, 255, 204));
        btnSwitchToPanel6.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        btnSwitchToPanel6.setBounds(683, 416, 134, 36);
        btnSwitchToPanel6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel6);
            }
        });

        panel5.add(btnSwitchToPanel6);
    }
    
    /** Initializes the 6th tutorial page */
    private void initializePanel6() {
        panel6 = new JPanel(null);
        panel6.setBackground(new Color(204, 255, 255));
        panel6.setBounds(0, 0, 862, 509);

        JButton btnSwitchToPanel7 = new JButton("Got it, Next!");
        btnSwitchToPanel7.setBackground(new Color(255, 255, 204));
        btnSwitchToPanel7.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        btnSwitchToPanel7.setBounds(683, 416, 134, 36);
        btnSwitchToPanel7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(panel7);
            }
        });

        panel6.add(btnSwitchToPanel7);
    }
    
    /**
     * Initializes the seventh and final panel of the tutorial for the given player.
     * This method prepares the concluding stage of the tutorial, leading the player back to the main game.
     *
     * @param player The player object containing player-specific information.
     */
    private void initializePanel7(final Player player) { 
        panel7 = new JPanel(null);
        panel7.setBackground(new Color(204, 255, 255));
        panel7.setBounds(0, 0, 862, 509);

        JButton theEnd = new JButton("I understand, time to play!");
        theEnd.setBackground(new Color(255, 255, 204));
        theEnd.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        theEnd.setBounds(566, 407, 251, 45);
        theEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Exit Button action
				
				//Opens Main Menu Window/GUI and Closes Tutorial
                MainMenu su=new MainMenu(player);
				su.setVisible(true);
				su.setResizable(false);
				dispose();
            }
        });

        panel7.add(theEnd);
    }
    /** Used to switched from one tutorial page to the next */
    private void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }
}