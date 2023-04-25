import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Game class
public class Game {
	JFrame gamewindow;
	Container contain;
	JPanel titleNamePanel, startButtonPanel, dialoguePanel, optionsPanel, hotbarPanel;
	JLabel titleNameText, hpLabel, hpNo, weaponLabel, weaponType;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
	Font startFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font hotbarFont = new Font("Times New Roman", Font.PLAIN, 24);
	Font buttonText = new Font("Times New Roman", Font.PLAIN, 25);
	JButton startButton, option1, option2, option3, option4;
	JTextArea mainTextArea;
	int playerHP;
	String weapon, gameState;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	OptionHandler optionHandler = new OptionHandler();

	public static void main(String[] args) {
		new Game();

	}
	public Game() {
//initialized  JFrame 
	gamewindow = new JFrame();
	//	Frame size in pixels
	gamewindow.setSize(900,700);
	//	Ability to exit 
	gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	Color of window
	gamewindow.getContentPane().setBackground(Color.black);
	//	Disable default layout
	gamewindow.setLayout(null);
	contain = gamewindow.getContentPane();
	
//initialized  JPanel 
	titleNamePanel = new JPanel();
	//	Title text dimensions
	titleNamePanel.setBounds(100, 100,700, 100);
	//	Container color
	titleNamePanel.setBackground(Color.gray);
	
//initialized  JLabel
	titleNameText = new JLabel("ADVENTURE QUEST");
	//	Text color
	titleNameText.setForeground(Color.yellow);
	titleNameText.setFont(titleFont);
	
	//initialized  JPanel
	startButtonPanel = new JPanel();
	//	button container 
	startButtonPanel.setBounds(300, 400, 210, 80);
	startButtonPanel.setBackground(Color.gray);
	
//initialized  JButton
	startButton= new JButton("BEGIN");
//	JButton customizations
	startButton.setBackground(Color.gray);
	startButton.setForeground(Color.yellow);
	startButton.setBorderPainted(false);
	startButton.setFont(startFont);
	
	startButton.addActionListener(tsHandler);
	startButton.setFocusPainted(false);
	
	
	
	//	Adding to items onto panel
	titleNamePanel.add(titleNameText);
	startButtonPanel.add(startButton);
	contain.add(titleNamePanel);
	contain.add(startButtonPanel);
		
	//Window visibility
	gamewindow.setVisible(true);
	}
	
	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		dialoguePanel = new JPanel();
		dialoguePanel.setBounds(100,100,600,250);
		dialoguePanel.setBackground(Color.gray);
		contain.add(dialoguePanel);
		
		//initialized  JTextArea
		mainTextArea = new JTextArea("Text here");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.gray);
		mainTextArea.setForeground(Color.yellow);
		mainTextArea.setFont(buttonText);
		mainTextArea.setLineWrap(true);
		dialoguePanel.add(mainTextArea);
		
//		Actions/option buttons
		optionsPanel = new JPanel();
		optionsPanel.setBounds(250,350,300,150);
		optionsPanel.setBackground(Color.black);
//		customized layout for buttons
		optionsPanel.setLayout(new GridLayout(4,1));
		contain.add(optionsPanel);
		
//		Option 1 button
		option1 = new JButton("option 1");
		option1.setBackground(Color.gray);
		option1.setForeground(Color.white);
		option1.setFont(buttonText);
		option1.setFocusPainted(false);
		option1.addActionListener(optionHandler);
		option1.setActionCommand("o1");
		optionsPanel.add(option1);
//		Option 2 button
		option2 = new JButton("option 2");
		option2.setBackground(Color.gray);
		option2.setForeground(Color.white);
		option2.setFont(buttonText);
		option2.setFocusPainted(false);
		option2.addActionListener(optionHandler);
		option2.setActionCommand("o2");
		optionsPanel.add(option2);
//		Option 3 button
		option3 = new JButton("option 3");
		option3.setBackground(Color.gray);
		option3.setForeground(Color.white);
		option3.setFont(buttonText);
		option3.setFocusPainted(false);
		option3.addActionListener(optionHandler);
		option3.setActionCommand("o3");
		optionsPanel.add(option3);
//		Option 4 button
		option4 = new JButton("option 4");
		option4.setBackground(Color.gray);
		option4.setForeground(Color.white);
		option4.setFont(buttonText);
		option4.setFocusPainted(false);
		option4.addActionListener(optionHandler);
		option4.setActionCommand("o4");
		optionsPanel.add(option4);
		
		hotbarPanel = new JPanel();
		hotbarPanel.setBounds(100, 15, 600, 50);
		hotbarPanel.setBackground(Color.gray);
		hotbarPanel.setLayout(new GridLayout(1,4));
		contain.add(hotbarPanel);
//		HP Label
		hpLabel= new JLabel("HP:");
		hpLabel.setFont(hotbarFont);
		hpLabel.setForeground(Color.white);
		hotbarPanel.add(hpLabel);
//		HP Amount
		hpNo = new JLabel();
		hpNo.setFont(hotbarFont);
		hpNo.setForeground(Color.white);
		hotbarPanel.add(hpNo);
//		Weapon Label
		weaponLabel = new JLabel("WEAPON:");
		weaponLabel.setFont(hotbarFont);
		weaponLabel.setForeground(Color.white);
		hotbarPanel.add(weaponLabel);
//		Weapon Type
		weaponType = new JLabel(); 
		weaponType.setFont(hotbarFont);
		weaponType.setForeground(Color.white);
		hotbarPanel.add(weaponType);
		
		playerSetup();


	}
	public void playerSetup() {
//	Player parameters
		playerHP = 20;
		weapon = "Worn Dagger";
		weaponType.setText(weapon);
		hpNo.setText(""+ playerHP);
		
		villageGate();
		
	}
//	Village
	public void village() {
		gameState="village";
		mainTextArea.setText("You finally managed to make your way inside.\n You decide to explore a bit.\nWhat should you do first?");
		option1.setText("Find a Merchant");
		option2.setText("Rest");
		option3.setText("Leave Village");
		option4.setText("Talk to locals");
	}
	public void villageSquare( ) {
		gameState="villageSquare";
		mainTextArea.setText("");
		option1.setText("Weapon Shop");
		option2.setText("Rest Area");
		option3.setText("Item shop");
		option4.setText("Leave Village Square");
	}
//	Village Gate
	public void villageGate() {
		gameState="villageGate";
		mainTextArea.setText("You've approached the enterance gate \n leading into the village.\n \nYou notice the door is blocked by a guard,\n he is standing in front of you, immediately \n locking eyes with you; what will you do next?\n\n");
		option1.setText("Converse with Guard");
		option2.setText("Attack guard");
		option3.setText("Leave");
		option4.setText("Bribe");
		
	} 
	public void villageGate2() {
		gameState="villageGate2";
		mainTextArea.setText("You find another enterance to the village.\n The guard by the gate seems friendlier. Guard: Welcome, I can see you are a forigen travler, please come in.");
		option1.setText("Enter village");
		option2.setText("Talk to Guard");
		option3.setText("Go other gate");
		option4.setText("Leave");
	}
	public void talkGuard() {
		gameState="talkGuard";
		mainTextArea.setText(" The Guard examines you.\n\nGuard: Hello, strange foreigner,\nI've never seen a face like yours before \nand due to strict village protocol,\n I cannot open the gate and allow you in.\n\n The Guard shoos you away.");
		option1.setText("Leave");
		option2.setText("Talk");
		option3.setText("Attack");
		option4.setText("");
	}
	public void attackGuard() {
		gameState="attackGuard";
		mainTextArea.setText("Guard: Hey!! Don't even think about it!\n\nThe Guard draws his sword and it flashes before your eyes.\n\nGuard: Get lost scumbag!!\n\n (You lost 5 HP)");
		playerHP= playerHP-5;
		hpNo.setText(""+playerHP);
		option1.setText("Leave");
		option2.setText("Apologize");
		option3.setText("");
		option4.setText("");
		
	}
	public void bribeGuard() {
		gameState="bribeGuard";
		mainTextArea.setText("You dig into your pockets,\n pulling out a piece of lint and 2 copper coins. \nYou decide to offer them in exchange for letting you pass by\n\n The Guard shakes his head, and laughs at you.\n\n Guard: Don't you have better things to do?\n don't give me your trash!");
		option1.setText("Leave gates");
		option2.setText("Sneak in");
		option3.setText("Wander around");
		option4.setText("");
		
	}
//	Crossroads
	public void crossRoads() {
		gameState="crossRoads";
		mainTextArea.setText("You wander away from the village towards some crossroads. You come across 3 different paths.\n\n Well now what?");
		option1.setText("Return to Village");
		option2.setText("Go North");
		option3.setText("Go East");
		option4.setText("Go West");
	}
	public void north() {
		gameState="north";
		mainTextArea.setText("You come across a river.\n You gather some water and rest beside the river for a little while. \n\n(Your HP has restored by 5.)");
		playerHP= playerHP+5;
		hpNo.setText(""+playerHP);
		option1.setText("Explore riverside");
		option2.setText("Rest some more");
		option3.setText("Contuine going North");
		option4.setText("Head back");
	}
	public void east() {
		gameState="east";
		mainTextArea.setText("You wander into a shrouded forest, you notice the sun is setting");
		option1.setText("Set camp");
		option2.setText("Contuine East");
		option3.setText("Head back");
		option4.setText("Explore Forest");
		
	}
	public void west() {
		gameState="west";
		mainTextArea.setText("");
		option1.setText("");
		option2.setText("");
		option3.setText("");
		option4.setText("");
		
	}
	public void riverside() {
		gameState= "riverside";
		mainTextArea.setText("You come across a small chest hidden in a bush. Inside was a Steel Long sword and 50 gold coins!");
		weapon="Long Sword";
		weaponType.setText(weapon);
		option1.setText("Head to village");
		option2.setText("Leave Riverside");
		option3.setText("Rest");
		option4.setText("Contuine North");
	}
	
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	public class OptionHandler implements ActionListener{
//		recognizes which option is picked
		public void actionPerformed(ActionEvent event) {
			String playerChoice = event.getActionCommand();
			switch(gameState) {
//			decides call based on option picked
			case "villageGate":
				switch(playerChoice) {
				case "o1": talkGuard(); break;
				case "o2": attackGuard(); break;
				case "o3": crossRoads(); break;
				case "o4": bribeGuard(); break;
				}
				break;
			case "talkGuard":
				switch(playerChoice) {
				case "o1": villageGate(); break;
				case "o2": break;
				case "o3": attackGuard(); break;
				}
				break;
			case "attackGuard":
				switch(playerChoice) {
				case "o1": villageGate(); break;
				}
				break;
			case "bribeGuard":
				switch(playerChoice) {
				case "o1": villageGate(); break;
				}
				break;
			case "crossRoads":
				switch(playerChoice) {
				case "o1": villageGate(); break;
				case "o2": north(); break;
				case "o3": east(); break;
				case "o4": west();break;
				
				}
				break;
			case "north":
				switch(playerChoice) {
				case "o1": riverside(); break;
				case "o2": break;
				case "o3": break;
				case "o4": crossRoads(); break;
				
			}
				break;
			case "riverside":
				switch(playerChoice) {
				case "o1": villageGate2(); break;
				case "o2": break;
				case "o3": break;
				case "o4": crossRoads(); break;
				}
				
	}
		
	}
}
}
