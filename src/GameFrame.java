import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	private Player player;
	
	GameFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public void combat() {
		CombatGUI combat = new CombatGUI(this, player);
		
		this.add(combat);
		this.pack();
		this.setVisible(true);
	}

}
