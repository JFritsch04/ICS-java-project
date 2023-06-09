import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

//Game class
public class Game {
	JFrame gamewindow;
	Container contain;
	JPanel titleNamePanel, startButtonPanel, dialoguePanel, optionsPanel, hotbarPanel, lowbarPanel, healthBarPanel, imagePanel;
	JLabel titleNameText, hpLabel, hpNo, weaponLabel, weaponType, coinLabel, coinCount, imageLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
	Font startFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font hotbarFont = new Font("Times New Roman", Font.PLAIN, 24);
	Font buttonText = new Font("Times New Roman", Font.PLAIN, 25);
	JButton startButton, option1, option2, option3, option4;
	JTextArea mainTextArea;
	JProgressBar healthBar;
	int playerHP;
	int coins;
	int monsterHP;
	int ring;
	String weapon, gameState;
	ImageIcon image;
	
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
		dialoguePanel.setBounds(50,350,430,250);
		dialoguePanel.setBackground(Color.gray);
		contain.add(dialoguePanel);
		
		//initialized  JTextArea
		mainTextArea = new JTextArea("Text here");
		mainTextArea.setBounds(50,350,430,250);
		mainTextArea.setBackground(Color.gray);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(buttonText);
		mainTextArea.setLineWrap(true);
		dialoguePanel.add(mainTextArea);
		
//		Actions/option buttons
		optionsPanel = new JPanel();
		optionsPanel.setBounds(500,350,250,150);
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
		
		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(500, 300,245,30);
		healthBarPanel.setBackground(Color.black);
		contain.add(healthBarPanel);
		healthBar = new JProgressBar(0,25);
		healthBar.setPreferredSize(new Dimension(350,40));
		healthBar.setBackground(Color.red);
		healthBar.setForeground(Color.green);
		healthBarPanel.add(healthBar);
		
		
		
		hotbarPanel = new JPanel();
		hotbarPanel.setBounds(500,550,300,25);
		hotbarPanel.setBackground(Color.black);
		hotbarPanel.setLayout(new GridLayout(1,2));
		contain.add(hotbarPanel);
		
		lowbarPanel = new JPanel();
		lowbarPanel.setBounds(500,520,300,25);
		lowbarPanel.setBackground(Color.black);
		lowbarPanel.setLayout(new GridLayout(1,4));
		contain.add(lowbarPanel);
		
////		HP Label
//		hpLabel= new JLabel("HP:");
//		hpLabel.setFont(hotbarFont);
//		hpLabel.setForeground(Color.white);
//		hotbarPanel.add(hpLabel);
////		HP Amount
//		hpNo = new JLabel();
//		hpNo.setFont(hotbarFont);
//		hpNo.setForeground(Color.white);
//		hotbarPanel.add(hpNo);
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
//		Coins Label
		coinLabel = new JLabel("COINS:");
		coinLabel.setFont(hotbarFont);
		coinLabel.setForeground(Color.white);
		lowbarPanel.add(coinLabel);
		
		coinCount = new JLabel();
		coinCount.setFont(hotbarFont);
		coinCount.setForeground(Color.white);
		lowbarPanel.add(coinCount);
		
		imagePanel = new JPanel();
		imagePanel.setBounds(50,65,427,280);
		imagePanel.setBackground(Color.black);
		
		imageLabel = new JLabel();
		image = new ImageIcon(".//res//towngate.jpg");
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);
		
		contain.add(imagePanel);
		
		
		playerSetup();


	}
	private void playerSetup() {
//	Player parameters
		playerHP = 25;
		monsterHP = 20;
		weapon = "Worn Dagger";
		coins = 0;
		weaponType.setText(weapon);
//		hpNo.setText(""+ playerHP);
		coinCount.setText(""+coins);
		
		healthBar.setValue(playerHP);
		villageGate();
		
	}
//	Village
	public void village() {
		gameState="village";
		mainTextArea.setText("You finally managed to make your way inside.\n You decide to explore a bit.\nWhat should you do first?");
		option1.setText("Head to the square");
		option2.setText("Rest Area");
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
	public void talkVillagers() {
		gameState="talkVillagers";
		mainTextArea.setText("You approach a young maiden and she looks at you with a smile. She offers you help, do you accept?");
		option1.setText("Accept");
		option2.setText("Reject");
		option3.setText("Question");
		option4.setText("Leave Village Square");
		
	}
	public void weaponShop() {
		gameState="weaponShop";
		mainTextArea.setText("You push open a heavy wooden door and head inside to a weaponsmith's shop. The walls are decorated with hunting memorabilia and nice weapons. A older man is waiting at the store counter and greets you with a jolly smile.");
		option1.setText("Talk to Shop Keeper");
		option2.setText("View inventory");
		option3.setText("Steal");
		option4.setText("Leave");
	}
	public void itemShop() {
		gameState="itemShop";
		mainTextArea.setText("You head inside, quickly greeted by a sweet old woman; she smiles and asks if she can help you find anything");
		option1.setText("Talk to Shop Keeper");
		option2.setText("View Inventory");
		option3.setText("Steal");
		option4.setText("Leave");
		
	}
	public void restPoint() {
		
	}
	public void bribeOpen() {
		
	}
//	Village Gate
	public void villageGate() {
		image = new ImageIcon(".//res//towngate.jpg");
		imageLabel.setIcon(image);
		gameState="villageGate";
		mainTextArea.setText("You've approached the enterance gate \n leading into the village.\n \nYou notice the door is blocked by a guard,\n he is standing in front of you, immediately locking eyes with you; what will you\n do next?\n\n");
		option1.setText("Converse with Guard");
		option2.setText("Attack guard");
		option3.setText("Leave");
		option4.setText("Bribe");
		
	} 
	public void villageGate2() {
		image = new ImageIcon(".//res//towngate.jpg");
		imageLabel.setIcon(image);
		gameState="villageGate2";
		mainTextArea.setText("You find another entrance to the village.\n The guard by the gate seems friendlier. Guard: Welcome, I can see you are a foreign traveler, please come in.");
		option1.setText("Enter village");
		option2.setText("Talk to Guard");
		option3.setText("Go other gate");
		option4.setText("Leave");
	}
	public void talkGuard() {
		gameState="talkGuard";
		mainTextArea.setText(" The Guard examines you.\n\nGuard: Hello, strange foreigner,\nI've never seen a face like yours before \nand due to strict village protocol,\n I cannot open the gate and allow you in.\n\n The Guard shoos you away.");
		option1.setText("Leave");
		option2.setText("Attack");
		option3.setText("");
		option4.setText("");
	}
	public void attackGuard() {
		gameState="attackGuard";
		mainTextArea.setText("Guard: Hey!! Don't even think about it!\n\nThe Guard draws his sword and it flashes before your eyes.\n\nGuard: Get lost scumbag!!\n\n (You lost 5 HP)");
		playerHP= playerHP-5;
		healthBar.setValue(playerHP);
//		hpNo.setText(""+playerHP);
		option1.setText("Leave");
		option2.setText("Apologize");
		option3.setText("");
		option4.setText("");
		
	}
	public void bribeGuard() {
		gameState="bribeGuard";
		mainTextArea.setText("You dig into your pockets,\n pulling out a piece of lint and "+coins+" coins. \nYou decide to offer them in exchange for letting you pass by\n\n The Guard shakes his head, and laughs at you.\n\n Guard: Don't you have better things to do?\n don't give me your trash!");
		option1.setText("Leave gates");
		option2.setText("Sneak in");
		option3.setText("Wander around");
		option4.setText("");
		
			
		}
	public void apologizeGuard() {
		gameState="apologizeGuard";
		mainTextArea.setText("You apologize for your abrupt decision; the Guard frowns and forces you to leave.");
		option1.setText("Leave");
		option2.setText("");
		option3.setText("");
		option4.setText("");
	}
//	Cross roads
	public void crossRoads() {
		image = new ImageIcon(".//res//crossroad.jpg");
		imageLabel.setIcon(image);
		gameState="crossRoads";
		mainTextArea.setText("You wander away from the village towards some crossroads.\n You come across 3 different paths.\n\n Well now what?");
		option1.setText("Return to Village");
		option2.setText("Go North");
		option3.setText("Go East");
		option4.setText("Go West");
	}
	public void north() {
		image = new ImageIcon(".//res//river.jpg");
		imageLabel.setIcon(image);
		gameState="north";
		mainTextArea.setText("You come across a river.\n You gather some water and rest beside the river for a little while. \n\n(Your HP has restored by 5.)");
		playerHP= playerHP+5;
		healthBar.setValue(playerHP);
//		hpNo.setText(""+playerHP);
		option1.setText("Explore riverside");
		option2.setText("Rest again");
		option3.setText("Contuine going North");
		option4.setText("Head back");
	}
	public void farNorth() {
		image = new ImageIcon(".//res//void.jpg");
		imageLabel.setIcon(image);
		gameState="farNorth";
		mainTextArea.setText("");
		option1.setText("");
		option2.setText("");
		option3.setText("");
		option4.setText("");
	}
	public void east() {
		image = new ImageIcon(".//res//forest.jpg");
		imageLabel.setIcon(image);
		gameState="east";
		mainTextArea.setText("You wander into a shrouded forest,\n you notice the sun is setting");
		option1.setText("Set camp");
		option2.setText("Contuine East");
		option3.setText("Head back");
		option4.setText("Explore Forest");
		
	}
	public void setCamp() {
		gameState="setCamp";
		playerHP= playerHP+10;
		healthBar.setValue(playerHP);
		mainTextArea.setText("You set camp for the night and rest up. \nYou wake up and feel like a weight lifted off your back.\n (You restore 10 HP)");
		option1.setText("Explore Forest");
		option2.setText("Leave Forest");
		option3.setText("Rest Again");
		option4.setText("");
	}
	public void farEast() {
		image = new ImageIcon(".//res//void.jpg");
		imageLabel.setIcon(image);
		gameState="farEast";
		mainTextArea.setText("You head farther East. A cat runs up to you and seemingly greets you.");
		option1.setText("Pet cat");
		option2.setText("Attack cat");
		option3.setText("Abandon cat");
		option4.setText("Do nothing");
	}
	public void west() {
		gameState="west";
		mainTextArea.setText("You decide to go West, \nit's extremely foggy and it's hard to navigate. \nYou end up going in circles and seem lost.");
		option1.setText("Turn back");
		option2.setText("Wander");
		option3.setText("");
		option4.setText("");
		
	}
//	Riverside
	public void riverside() {
		
		gameState= "riverside";
		mainTextArea.setText("You come across a small chest hidden in a bush. Inside was a Steel Long sword and 50 gold coins!");
		weapon="Long Sword";
		weaponType.setText(weapon);
		coins=coins+50;
		coinCount.setText(""+coins);
		option1.setText("Head to village");
		option2.setText("Leave Riverside");
		option3.setText("Rest");
		option4.setText("Contuine North");
	}
	public void restRiver() {
		gameState="restRiver";
		mainTextArea.setText("You rest a bit more by the relaxing river. (You receive 5 HP)");
		playerHP= playerHP+5;
		healthBar.setValue(playerHP);
//		hpNo.setText(""+playerHP);
		option1.setText("Explore Riverside");
		option2.setText("Contuine going North");
		option3.setText("Go back");
		option4.setText("");
	
	
	}
//	Monster encounter 
	public void forest() {
		image = new ImageIcon(".//res//exploreForest.jpg");
		imageLabel.setIcon(image);
		gameState="forest";
		mainTextArea.setText("You go deeper into the forest and encounter a  greater blue slime!");
		option1.setText("Fight");
		option2.setText("Run");
		option3.setText("Items");
		option4.setText("");
	}
	public void fightSlime() {
		image = new ImageIcon(".//res//slime.jpg");
		imageLabel.setIcon(image);
		gameState="fightSlime";
		mainTextArea.setText("Greater slime HP: "+ monsterHP);
		option1.setText("Attack");
		option2.setText("Run");
		option3.setText("");
		option4.setText("");
	}
	public void runAway() {
		gameState="runAway";
		mainTextArea.setText("You ran away safely, and head back to the Crossroads.");
		option1.setText("Return to Village");
		option2.setText("Go North");
		option3.setText("Go East");
		option4.setText("Go West");
	}
	public void ending() {
		gameState = "ending";
		mainTextArea.setText("The guard notices your sapphire ring.\n\nGuard:Oh you killed the greater slime?!\n That slime has been attacking this village for many moons.\n You are a true hero worthy of this town!\n\n The Guard opens the Village gate for you.");
		option1.setText("");
		option2.setText("");
		option3.setText("");
		option4.setText("");
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		option4.setVisible(false);
	}
	public void playerAttack() {
		gameState="playerAttack";
		int playerDmg = 0;

		if(weapon.equals("Worn Dagger")) {
			playerDmg = new java.util.Random().nextInt(4);	
		}
		else if (weapon.equals("Long Sword")) {
			playerDmg = new java.util.Random().nextInt(11);
		}
		
		mainTextArea.setText("You attacked, and inflicted " +playerDmg+" damage! \n\nGreater slime HP: "+ monsterHP);
		monsterHP = monsterHP - playerDmg;
		option1.setText("Next Turn");
		option2.setText("Run");
		option3.setText("Items");
		option4.setText("");
	}
	public void monsterAttack() {
		gameState="monsterAttack";
		int monsterDmg = 0;
		monsterDmg= new java.util.Random().nextInt(6);
		mainTextArea.setText("You were attacked and lost " +monsterDmg+" HP! \n\nGreater slime HP: "+ monsterHP);
		playerHP = playerHP - monsterDmg;
//		hpNo.setText(""+playerHP);
		healthBar.setValue(playerHP);
		option1.setText("Attack");
		option2.setText("Run");
		option3.setText("Items");
		option4.setText("");
	}
	public void winBattle() {
		image = new ImageIcon(".//res//ring.jpg");
		imageLabel.setIcon(image);
		gameState="winBattle";
		mainTextArea.setText("You defeated the monster! The Monster dropped a sapphire ring!(You obtained a sapphire ring and 70 gold coins!)");
		ring= 1;
		coins=coins+70;
		coinCount.setText(""+coins);
		option1.setText("Crossroads");
		option2.setText("Contuine East");
		option3.setText("Rest");
		option4.setText("");
		
	}
	public void lossDeath() {
		gameState="lossDeath";
		mainTextArea.setText("You have no HP left, you collapse over and die.\n\n <GAME OVER!>");
		
		option1.setText("Try again");
		option2.setText("");
		option3.setText("");
		option4.setText("");
	
		
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
//				Village gate options
				switch(playerChoice) {
				case "o1": 
					if (ring==1) {
						ending();
					}
					else {
						talkGuard();
					}
					break;
				case "o2": attackGuard(); break;
				case "o3": crossRoads(); break;
				case "o4":
					if (coins>=50) {
						bribeOpen();
					}
					else {
					bribeGuard(); 
				}
				}
				break;
			case "talkGuard":
//				Talk options
				switch(playerChoice) {
				case "o1": 
					if (ring==1) {
						ending();
					}
					else {
						crossRoads();
					}
					break;
				case "o2": attackGuard(); break;
				}
				break;
			case "attackGuard":
//				Attack options
				switch(playerChoice) {
				case "o1": 
					if(playerHP<1) {
						lossDeath();
					} 
					else {
					villageGate(); 
				}
				case "o2": apologizeGuard(); break;
				}
				break;
			case "bribeGuard":
//				Bribe options
				switch(playerChoice) {
				case "o1": villageGate(); break;
				}
				break;
			case "apologizeGuard":
				switch(playerChoice) {
				case "o1": crossRoads(); break;
				}
				break;
			case "crossRoads":
//				Cross Roads options
				switch(playerChoice) {
				case "o1": villageGate(); break;
				case "o2": north(); break;
				case "o3": east(); break;
				case "o4": west();break;
				
				}
				break;
			case "north":
//				North options
				switch(playerChoice) {
				case "o1": riverside(); break;
				case "o2": restRiver(); break;
				case "o3": farNorth(); break;
				case "o4": crossRoads(); break;
				
			}
				break;
//				east options 
			case "east":
				switch(playerChoice) {
				case "o1": setCamp(); break;
				case "o2": farEast(); break;
				case "o3": crossRoads(); break;
				case "o4": forest(); break;
				}
				break;
//				east options 
			case "west":
				switch(playerChoice) {
				case "o1": crossRoads(); break;
				case "o2": break;
				case "o3": break;
				case "o4": break;
				}
				break;
//				Riverside options
			case "riverside":
				switch(playerChoice) {
				case "o1": villageGate2(); break;
				case "o2": crossRoads(); break;
				case "o3": restRiver(); break;
				case "o4": farNorth(); break;
				}
				break;
//				Riverside options
			case "restRiver":
				switch(playerChoice) {
				case "o1": riverside(); break;
				case "o2": farNorth(); break;
				case "o3": crossRoads(); break;
				case "o4": break;
				}
				break;
			case "villageGate2":
				switch(playerChoice) {
				case "o1": break;
				case "o2": break;
				case "o3": break;
				case "o4": break;
				
				}
			case "villageSquare":
				switch(playerChoice) {
				case "o1": break;
				case "o2": break;
				case "o3": break;
				case "o4": break;
				}
				break;
			case "forest":
				switch(playerChoice) {
				case "o1": fightSlime();break;
				case "o2": runAway(); break;
				case "o3": break;
				case "o4": break;
				}
				break;
			case "fightSlime":
				switch(playerChoice) {
				case "o1": playerAttack();break;
				case "o2": runAway(); break;
				case "o3": break;
				}
				break;
			case "runAway":
				switch(playerChoice) {
				case "o1": villageGate(); break;
				case "o2": north(); break;
				case "o3": east(); break;
				case "o4": west();break;
				}
				break;
			case "playerAttack":
				switch(playerChoice) {
				case "o1": 
					if(monsterHP<1) {
						winBattle();
					}
					else {
					monsterAttack(); 
					}
					break;
				case "o2": runAway(); break;
				case "o3": break;
				}
				break;
			case "monsterAttack":
				switch(playerChoice) {
				case "o1": 
				if(playerHP<1) {
					lossDeath();
				}
				else {
					playerAttack(); 
				}
				break;
				case "o2": runAway(); break;
				case "o3": break;
				}
				break;
			case "winBattle":
				switch(playerChoice) {
				case "o1": crossRoads(); break;
				case "o2": farEast();break;
				case "o3": break;
				case "o4": break;
				}
				break;
			case "lossDeath":
				switch(playerChoice) {
				case "o1": villageGate(); break;
				}
				
				
				
				
	}
		
	}
}
}
