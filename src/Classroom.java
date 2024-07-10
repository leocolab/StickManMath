import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

/**
 * Classroom class used to open the Classroom window.
 * @author Samuel Angarita
 *
 */
public class Classroom extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Classroom method. Opens Classroom window.
	 * The Classroom window displays the students in your classroom.
	 * You can use the Add Student button to add up to 20 students.  
	 * You can use the Back button to go back to the MainMenu Window
	 * 
	 * @param player an Object of Player.
	 */
	public Classroom(Player player) {
		//Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title label
		JLabel Title_label = new JLabel("Classroom");
		Title_label.setBackground(new Color(255, 255, 255));
		Title_label.setForeground(new Color(0, 0, 0));
		Title_label.setBounds(241, 10, 365, 80);
		Title_label.setOpaque(true);
		Title_label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 80));
		contentPane.add(Title_label);
		
		
		
		//If its the first time the teacher opens Classromm his name is added to the file
		if(isUsernameUnique(player.getUsername(), "/Classroom.csv")) {//calls method
			try {
				FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/Classroom.csv",true);
				writer.write(player.getUsername());
				writer.write(System.getProperty("line.separator"));
				writer.close();
			}catch(Exception ex) {
			}
		}
		
		LeadBoard[] leaderBoard = createList("Classroom.csv", "Main_Game_File.csv",player);
		int size=leaderBoard.length;

		//Table
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		table.setBackground(new Color(0, 0, 0));
		table.setFont(new Font("Mongolian Baiti", Font.BOLD, 12));
		table.setRowHeight(14);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{ "UserName", "Levels Completed", "Number of Coins"},
				{ isNull_User(leaderBoard,size,0), isNull_lvl(leaderBoard,size,0), isNull_coins(leaderBoard,size,0)},
				{ isNull_User(leaderBoard,size,1), isNull_lvl(leaderBoard,size,1), isNull_coins(leaderBoard,size,1)},
				{ isNull_User(leaderBoard,size,2), isNull_lvl(leaderBoard,size,2), isNull_coins(leaderBoard,size,2)},
				{ isNull_User(leaderBoard,size,3), isNull_lvl(leaderBoard,size,3), isNull_coins(leaderBoard,size,3)},
				{ isNull_User(leaderBoard,size,4), isNull_lvl(leaderBoard,size,4), isNull_coins(leaderBoard,size,4)},
				{ isNull_User(leaderBoard,size,5), isNull_lvl(leaderBoard,size,5), isNull_coins(leaderBoard,size,5)},
				{ isNull_User(leaderBoard,size,6), isNull_lvl(leaderBoard,size,6), isNull_coins(leaderBoard,size,6)},
				{ isNull_User(leaderBoard,size,7), isNull_lvl(leaderBoard,size,7), isNull_coins(leaderBoard,size,7)},
				{ isNull_User(leaderBoard,size,8), isNull_lvl(leaderBoard,size,8), isNull_coins(leaderBoard,size,8)},
				{ isNull_User(leaderBoard,size,9), isNull_lvl(leaderBoard,size,9), isNull_coins(leaderBoard,size,9)},
				{ isNull_User(leaderBoard,size,10), isNull_lvl(leaderBoard,size,10), isNull_coins(leaderBoard,size,10)},
				{ isNull_User(leaderBoard,size,11), isNull_lvl(leaderBoard,size,11), isNull_coins(leaderBoard,size,11)},
				{ isNull_User(leaderBoard,size,12), isNull_lvl(leaderBoard,size,12), isNull_coins(leaderBoard,size,12)},
				{ isNull_User(leaderBoard,size,13), isNull_lvl(leaderBoard,size,13), isNull_coins(leaderBoard,size,13)},
				{ isNull_User(leaderBoard,size,14), isNull_lvl(leaderBoard,size,14), isNull_coins(leaderBoard,size,14)},
				{ isNull_User(leaderBoard,size,15), isNull_lvl(leaderBoard,size,15), isNull_coins(leaderBoard,size,15)},
				{ isNull_User(leaderBoard,size,16), isNull_lvl(leaderBoard,size,16), isNull_coins(leaderBoard,size,16)},
				{ isNull_User(leaderBoard,size,17), isNull_lvl(leaderBoard,size,17), isNull_coins(leaderBoard,size,17)},
				{ isNull_User(leaderBoard,size,18), isNull_lvl(leaderBoard,size,18), isNull_coins(leaderBoard,size,18)},
				{ isNull_User(leaderBoard,size,19), isNull_lvl(leaderBoard,size,19), isNull_coins(leaderBoard,size,19)},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(200);
		table.getColumnModel().getColumn(2).setMaxWidth(250);
		
		
		table.setBounds(49, 100, 750, 294);
		contentPane.add(table);

		
		//Back Button
		JButton Back_button = new JButton("Back");
		Back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Back Button action
				
				//Opens MainMenu Window/GUI and Closes LeaderBoard Window/GUI
				MainMenu su=new MainMenu(player);
				su.setVisible(true);
				dispose();
				
			}
		});
		Back_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Back_button.setBounds(715, 429, 123, 33);
		contentPane.add(Back_button);
		
		//Add Student button
		JButton Add_button = new JButton("Add Student");
		Add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add Student button action
				
				String NewStudent=textField.getText();
				
				 if (isUsernameUnique(NewStudent, "/Main_Game_File.csv")) {
		            JOptionPane.showMessageDialog(null, "Student Username does not exist");
		        }
				 else if(isUsernameInLeaderboard(NewStudent, leaderBoard)) {
					 JOptionPane.showMessageDialog(null, "Student Username is alredy in classroom");
				 }
				 else if(leaderBoard.length>=20) {
					 JOptionPane.showMessageDialog(null, "Unfortunitly your classroom is full and you can't add more students");
				 }
				 
				 
				 else{
					 
				        List<String> lines = new ArrayList<>();

				        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Classroom.csv"))) {
				            String line;
				            while ((line = br.readLine()) != null) {
				            	line=line.replaceAll(",+$", "");
				                lines.add(line);
				                String[] parts = line.split(",");
				                if (parts.length > 0 && parts[0].equals(player.getUsername())) {
				                    lines.set(lines.size() - 1, line + "," + NewStudent);
				                }
				            }
				        } catch (IOException ee) {
				            ee.printStackTrace();
				        }
				        try (BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Classroom.csv"))) {
				            for (String updatedLine : lines) {
				                bw.write(updatedLine);
				                bw.newLine();
				            }
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
				        //Reset window
				        Classroom window = new Classroom(player);
						window.setVisible(true);
						dispose();
				 }
			}
		});
		Add_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Add_button.setBounds(10, 429, 200, 33);
		contentPane.add(Add_button);
		
		//Text field
		textField = new JTextField();
		textField.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		textField.setColumns(10);
		textField.setBounds(250, 429, 300, 33);
		contentPane.add(textField);
		
		//
		JLabel Max_label = new JLabel("Max 20 Students");
		Max_label.setFont(new Font("Mongolian Baiti", Font.BOLD, 13));
		Max_label.setBounds(49, 404, 100, 13);
		contentPane.add(Max_label);
		
		//Background
		JLabel Back_Image_label = new JLabel("");
		Back_Image_label.setBounds(0, 0, 862, 509);
		Back_Image_label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Classroom_Back.jpg")));
		contentPane.add(Back_Image_label);
		
		
			
	}
	/**
	 * isUsernameInLeaderboard method. Check if UserName is in the LeadBoard array.
	 * @param username the UserName being checked.
	 * @param leaderBoard the LeadBoard array.
	 * @return true if it's in the file false if it's not.
	 */
	public boolean isUsernameInLeaderboard(String username, LeadBoard[] leaderBoard) {
	    for (LeadBoard entry : leaderBoard) {
	        if (entry != null && username.equals(entry.getUsername())) {
	            return true;
	        }
	    }
	    return false;
	}
	/**
	 * isNull_User method. To handle null values.
	 * Check if the position is within leaderBoard.
	 * @param leaderBoard the LeadBoard array.
	 * @param size the size of the LeadBoard array.
	 * @param x the position. 
	 * @return a valid value. 
	 */
	public static String isNull_User(LeadBoard[] leaderBoard,int size,int x) {
		if(x<size) {
			return leaderBoard[x].getUsername();
		}
		else {
			return "";
		}
	}
	/**
	 * isNull_lvl method. To handle null values.
	 * Check if the position is within leaderBoard.
	 * @param leaderBoard the LeadBoard array.
	 * @param size the size of the LeadBoard array.
	 * @param x the position. 
	 * @return a valid value. 
	 */
	public static int isNull_lvl(LeadBoard[] leaderBoard,int size,int x) {
		if(x<size) {
			return leaderBoard[x].getLevel();
		}
		else {
			return 0;
		}
	}
	/**
	 * isNull_coins method. To handle null values.
	 * Check if the position is within leaderBoard.
	 * @param leaderBoard the LeadBoard array.
	 * @param size the size of the LeadBoard array.
	 * @param x the position. 
	 * @return a valid value. 
	 */
	public int isNull_coins(LeadBoard[] leaderBoard,int size,int x) {
		if(x<size) {
			return leaderBoard[x].getCoins();
		}
		else {
			return 0;
		}
	}
	
	
	/**
	 * isUsernameUnique method. Check if UserName is in the file already
	 * @param newUsername the UserName being checked.
	 * @param filename the name of the file.
	 * @return false if it's in the file true if it's not.
	 */
	public boolean isUsernameUnique(String newUsername, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                if (username.trim().equals(newUsername.trim())) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
	
	/**
	 * createList method. Creates an array of LeadBoard storing the students in the classroom
	 * @param classroomFilePath the name of the Classroom file. 
	 * @param gameFilePath the name of the Game file. 
	 * @param player an Object of Player.
	 * @return an array of LeadBoard storing the students.
	 */
	public LeadBoard[] createList(String classroomFilePath, String gameFilePath,Player player) {
        List<String> studentUsernames = new ArrayList<>();

        // Read the classroomFilePath to get the UserNames
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + classroomFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] usernames = line.split(",");
                
                if(usernames.length>0 && usernames[0].equals(player.getUsername())) {
                	for (String username : usernames) {
                        studentUsernames.add(username);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Create an array of LeadBoard objects based on the number of students
        LeadBoard[] leaderBoard = new LeadBoard[studentUsernames.size()-1];

        // Read the gameFilePath and create LeadBoard objects
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + gameFilePath))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < leaderBoard.length) {
                String[] parts = line.split(",");
                String username = parts[0].trim();
                if (studentUsernames.contains(username)&& !player.getUsername().equals(username)) {
                    int gold = Integer.parseInt(parts[3].trim());
                    int levelProgress = Integer.parseInt(parts[4].trim());
                    leaderBoard[index] = new LeadBoard(username, levelProgress, gold);
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return leaderBoard;
    }
}
