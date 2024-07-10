import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * NewAccount class used to open the NewAccount window.
 * @author Samuel Angarita
 */

public class NewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String accountType="";//Variable for the account type

	/**
	 * NewAccount method. Opens NewAccount window
	 * The NewAccount window is used to create an account if you don't have one 
	 * Enter a UserName and Password thats meets the requirements and select an account type Student or Teacher
	 * Use the Create Account button to create an account, open the MainMenu window and start playing
	 * If you do have an account you can use the Back button to open the Login window
	 * 
	 */
	public NewAccount() {
		//NewAccount Window
		setTitle("New Account");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    
		setBounds(100, 100, 862, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title label
		JLabel TitleLabel = new JLabel("Stickman Math");
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 80));
		TitleLabel.setBounds(165, 24, 526, 80);
		contentPane.add(TitleLabel);
		
		//UserName label
		JLabel UserLabel = new JLabel("User Name");
		UserLabel.setForeground(new Color(255, 255, 255));
		UserLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		UserLabel.setBounds(103, 150, 111, 33);
		contentPane.add(UserLabel);
		
		//New UserName text field
		textField = new JTextField();
		textField.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		textField.setColumns(10);
		textField.setBounds(274, 150, 300, 33);
		contentPane.add(textField);
		
		//Password label
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(new Color(255, 255, 255));
		PasswordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		PasswordLabel.setBounds(103, 240, 111, 33);
		contentPane.add(PasswordLabel);
		
		//New Password text field
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		passwordField.setBounds(274, 240, 300, 33);
		contentPane.add(passwordField);
		
		//Create Account Button
		JButton Create_button = new JButton("Create Account");
		Create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create Account Button action
				
				String NewUsername=textField.getText();                    //String in NewUserName text field
				String NewPassword=new String(passwordField.getPassword());//String in NewPassword text field
				
				//UserName and Password needs to be 5-20 characters no spaces
				//An account type needs to be selected
				//UserName needs to be unique
				if (!(NewUsername.length() >= 5 && NewUsername.length() <= 20)) {
				    JOptionPane.showMessageDialog(null, "Username needs to be between 5 and 20 characters");
				}
				else if(!(NewPassword.length() >= 5 && NewPassword.length() <= 20)) {                         
					JOptionPane.showMessageDialog(null, "Password needs to be 5-20 characters");
				}
				else if(!accountType.equals("Teacher") && !accountType.equals("Student")) {
					JOptionPane.showMessageDialog(null, "You need to select an account type Student or Teacher");
				}
				else if(NewUsername.contains(" ")) {
					JOptionPane.showMessageDialog(null, "Username cannot contain spaces");
				}
				else if(NewPassword.contains(" ")) {
					JOptionPane.showMessageDialog(null, "Password cannot contain spaces");
				}
				
				else if (!isUsernameUnique(NewUsername, "Main_Game_File.csv")) {
		            JOptionPane.showMessageDialog(null, "Username has already been taken");
		        } 
				
				//If ALL the requirements are met then an account can be created and added to the file
				
				else {
					try {
						FileWriter writer = new FileWriter("Main_Game_File.csv",true);
						
						// username, password, account_type, gold, levelProgress, Item1, Item2, Item3
						writer.write(""+NewUsername+","+NewPassword+","+accountType+",0,1,null,null,null");
						writer.write(System.getProperty("line.separator"));
						writer.close();
						JOptionPane.showMessageDialog(null,"Account Created");
						
						boolean[][] booleanArray = new boolean[5][5];
						// All values to false
						for (int i = 0; i < booleanArray.length; i++) {
						    for (int j = 0; j < booleanArray[i].length; j++) {
						        booleanArray[i][j] = false;
						    }
						}
						booleanArray[0][0]=true;//First value true
						
						Item[] item=new Item[3];//Empty Item array
						
						//Created Object of Player for the the new User
						Player player=new Player(accountType,NewUsername,0,item,booleanArray);
						
						//Opens MainMenu Window/GUI and Closes NewAccount Window/GUI
						MainMenu su=new MainMenu(player);
						su.setVisible(true);
						dispose();
						
					}catch(Exception ex) {
					}
				}
			}
		});
		Create_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Create_button.setBounds(329, 410, 190, 33);
		contentPane.add(Create_button);
		
		//Back Button
		JButton Back_button = new JButton("Back");
		Back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Back Button Action
				
				//Opens Login Window/GUI and Closes NewAccount Window/GUI
				Login su=new Login();
				su.setVisible(true);
				dispose();
			
			}
		});
		Back_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		Back_button.setBounds(715, 429, 123, 33);
		contentPane.add(Back_button);
		
		//Drop down select for Account Type
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Drop down select action
				String selectedAccountType = (String) comboBox.getSelectedItem();
				if(selectedAccountType.equals("Teacher")) {
					accountType="Teacher";
				}
				else {
					accountType="Student";
				}
			}
		});
		comboBox.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		comboBox.setBounds(359, 310, 130, 33);
		contentPane.add(comboBox);
		
		//AccountType label
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setForeground(new Color(255, 255, 255));
		lblAccountType.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		lblAccountType.setBounds(103, 310, 150, 33);
		contentPane.add(lblAccountType);
		
		//Image of main character
		JLabel MC_Back_label = new JLabel("");
		MC_Back_label.setBackground(new Color(255, 255, 255));
		MC_Back_label.setBounds(584, 200, 153, 262);
		MC_Back_label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Stickman.png")));
		contentPane.add(MC_Back_label);
		
		//Background
		JLabel Back_Image_label = new JLabel("");
		Back_Image_label.setBounds(0, 0, 862, 509);
		Back_Image_label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Login_Back.jpg")));
		contentPane.add(Back_Image_label);
		
		
	}
	
	/**
	 * isUsernameUnique method. Check if UserName is in the file already
	 * @param newUsername the UserName being checked.
	 * @param filename the name of the file.
	 * @return false if it's in the file true if it's not.
	 */
	public boolean isUsernameUnique(String newUsername, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + filename))) {
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
}
