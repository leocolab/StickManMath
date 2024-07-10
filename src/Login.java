import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.awt.Color;


/**
 * Login class used to open the Login window.
 * @author Samuel Angarita
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserField;
	private JPasswordField txtPasswordField;
	

	/**
	 * Login method. Opens Login window.
	 * The login window is used to login if you have an account.
	 * Enter your UserName and Password and use the Sign In button to open the MainMenu window and start playing.
	 * If you don't have an account you can use the New Account button to open the NewAccount window.
	 */
	public Login() {
		//Login Window
		setTitle("Login Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 509);//consistent size of all windows
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//NewAccount Button
		JButton NewAccount_button = new JButton("New Account");
		NewAccount_button.setBounds(329, 405, 190, 33);
		NewAccount_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));//consistent font
		NewAccount_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NewAccount Button action
				
				//Opens NewAccount Window/GUI and Closes Login Window/GUI
				NewAccount su=new NewAccount();
				su.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(NewAccount_button);
		
		//Title Label
		JLabel TitleLabel = new JLabel("Stickman Math");
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 80));
		TitleLabel.setBounds(161, 10, 526, 80);
		contentPane.add(TitleLabel);
		
		//Sign in Button
		JButton SignIn_button = new JButton("Sign In");
		SignIn_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Sign in Button action
				
				String username = txtUserField.getText();                    //String in UserName text field
                String password = new String(txtPasswordField.getPassword());//String in Password text field
         
                try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"))) {
					
                	String line;//To have each line as a String
                	
                	boolean found=false;//false until Password and UserName match
                	
                	//Reads the entire file
                    while ((line = br.readLine()) != null) {
                    	
                    	
                    	//Store in the array each component of the line read
                        String[] parts = line.split(",");
                        //If line has all 8 components required and the UserName and Password match/exist
                        if (parts.length == 8 && parts[0].equals(username) && parts[1].equals(password)) {
                        	
                        	found=true;//Password and UserName matched
                            
                        	//Values from the file
                            String theAccountType=parts[2];
                            String theUsername=parts[0];
                            int theGold=Integer.parseInt(parts[3]);
                            int x=Integer.parseInt(parts[4]);

                    		boolean[][] booleanArray = new boolean[5][5];
                    		// All values set to false
                    		for (int i = 0; i < booleanArray.length; i++) {
                    		    for (int j = 0; j < booleanArray[i].length; j++) {
                    		        booleanArray[i][j] = false;
                    		    }
                    		}
                    		// x values set to true
                    		int count = 0;
                    		for (int i = 0; i < booleanArray.length && count < x; i++) {
                    		    for (int j = 0; j < booleanArray[i].length && count < x; j++) {
                    		        booleanArray[i][j] = true;
                    		        count++;
                    		    }
                    		}
                    		
                    		String item1 = parts[5];
                    		String item2 = parts[6];
                    		String item3 = parts[7];
                    		Item[] items=new Item[3];
                    		items[0]=creatItem(item1);// Calls method that creates 
                    		items[1]=creatItem(item2);// Object of Item 
                    		items[2]=creatItem(item3);// with the String
                    		
                    		//Created Object of Player for the current User
                        	Player player=new Player(theAccountType,theUsername,theGold,items,booleanArray);
                        	//Opens MainMenu Window/GUI and Closes Login Window/GUI
                        	MainMenu temp=new MainMenu(player);
    						temp.setVisible(true);
    						dispose();
                            break;
                        }
                    }
                    if(!found) {//Password and UserName did not match
                    	//Message if LogIn is unsuccessful 
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
			}
		});
		SignIn_button.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));              
		SignIn_button.setBounds(363, 335, 122, 33);
		contentPane.add(SignIn_button);
		
		//UserName Label
		JLabel UserLabel = new JLabel("User Name");
		UserLabel.setForeground(new Color(255, 255, 255));
		UserLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		UserLabel.setBounds(143, 110, 111, 33);
		contentPane.add(UserLabel);
		
		//UserName text field
		txtUserField = new JTextField();
		txtUserField.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		txtUserField.setColumns(10);
		txtUserField.setBounds(274, 155, 300, 33);
		contentPane.add(txtUserField);
		
		//Password Label
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(new Color(255, 255, 255));
		PasswordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		PasswordLabel.setBounds(143, 215, 111, 33);
		contentPane.add(PasswordLabel);
		
		//Password text field
		txtPasswordField = new JPasswordField();
		txtPasswordField.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		txtPasswordField.setBounds(274, 260, 300, 33);
		contentPane.add(txtPasswordField);
		txtPasswordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sign in Button action
				
				String username = txtUserField.getText();                    //String in UserName text field
                String password = new String(txtPasswordField.getPassword());//String in Password text field

                try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Main_Game_File.csv"))) {
					
                	String line;//To have each line as a String
                	
                	boolean found=false;//false until Password and UserName match
                	
                	//Reads the entire file
                    while ((line = br.readLine()) != null) {
                    	
                    	
                    	//Store in the array each component of the line read
                        String[] parts = line.split(",");
                        //If line has all 8 components required and the UserName and Password match/exist
                        if (parts.length == 8 && parts[0].equals(username) && parts[1].equals(password)) {
                        	
                        	found=true;//Password and UserName matched
                            
                        	//Values from the file
                            String theAccountType=parts[2];
                            String theUsername=parts[0];
                            int theGold=Integer.parseInt(parts[3]);
                            int x=Integer.parseInt(parts[4]);

                    		boolean[][] booleanArray = new boolean[5][5];
                    		// All values set to false
                    		for (int i = 0; i < booleanArray.length; i++) {
                    		    for (int j = 0; j < booleanArray[i].length; j++) {
                    		        booleanArray[i][j] = false;
                    		    }
                    		}
                    		// x values set to true
                    		int count = 0;
                    		for (int i = 0; i < booleanArray.length && count < x; i++) {
                    		    for (int j = 0; j < booleanArray[i].length && count < x; j++) {
                    		        booleanArray[i][j] = true;
                    		        count++;
                    		    }
                    		}
                    		
                    		String item1 = parts[5];
                    		String item2 = parts[6];
                    		String item3 = parts[7];
                    		Item[] items=new Item[3];
                    		items[0]=creatItem(item1);// Calls method that creates 
                    		items[1]=creatItem(item2);// Object of Item 
                    		items[2]=creatItem(item3);// with the String
                    		
                    		//Created Object of Player for the current User
                        	Player player=new Player(theAccountType,theUsername,theGold,items,booleanArray);
                        	//Opens MainMenu Window/GUI and Closes Login Window/GUI
                        	MainMenu temp=new MainMenu(player);
    						temp.setVisible(true);
    						dispose();
                            break;
                        }
                    }
                    if(!found) {//Password and UserName did not match
                    	//Message if LogIn is unsuccessful 
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
			}
		});
		
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
	 * creatItem method. Creates the specified Item object
	 * @param name the name of the item.
	 * @return specified Item object.
	 */
	public static Item creatItem(String name) {
		
		if(name.equals("Gold Double")){
			Item item=new Item("Gold Double","Doubles Your Coins",false,false,false,true,10); 
				return item;
		}
		else if(name.equals("Heal Spell")) {
			Item item=new Item("Heal Spell","Heals from previous damage",true,false,false,false,10); 
			return item;
		}
		else if(name.equals("Strength Boost")) {
			Item item=new Item("Strength Boost","Gain strength",false,false,true,false,10);
			return item;
		}
		else if(name.equals("Power Bar")) {
			Item item=new Item("Power Bar","Gain strength and heal",true,false,true,false,25);
			return item;
		}
		else if(name.equals("Gemstone")) {
			Item item=new Item("Gemstone","Double your coins and heal",true,false,false,true,25);
			return item;
		}
		else if(name.equals("Ring")) {
			Item item=new Item("Ring","Gain strenth and double coins",false,false,true,true,25);
			return item;
		}
		else if(name.equals("Mega Boost")) {
			Item item=new Item("Mega Boost","Gain strength, heal, and get richer",true,false,true,true,40); 
			return item;
		}
		else if(name.equals("Shield")) {
			Item item=new Item("Shield","Block enemy attacks",false,true,false,false,10); 
			return item;
		}
		else  {//AKA null    
			return null;
		}
	}
	
	
	
	
	

}
