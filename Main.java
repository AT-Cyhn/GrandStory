/**
 * Main.java
 * Description: The main class of GrandStory. This contains all the controls
 * 		for the game. All other classes are linked to this class.
 *
 * Name: Andy Tan
 * Date: November 12, 2013
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame implements KeyListener {
	private Image mainImage;
	private BufferedImage background;
	private Random myRandom = new Random();
	
	// Create
	private EffectsParent myEffects = new EffectsParent();
	private Player1 p1 = new Player1(30, 62, 1);
	private Player1 p2 = new Player1(540, 62, 2);
	private HealthBar healthBar1 = new HealthBar(p1, 20, 60, 250, 15, 
													20, 80, 200, 10 );
	private HealthBar healthBar2 = new HealthBar(p2, 580, 60, 250, 15,
													580, 80, 200, 10 );
	// Player1 control variables44g4dgll lg
	private boolean arrowKeyCheck[] = {false,false,false,false};
	private boolean arrowKeyPressed[] = {false,false,false,false};
	private boolean attackKeyCheck[] = {false};
	private boolean attackKeyPressed[] = {false};
	private SuperObject preID = null;
	private boolean blockCollide = false;
	private boolean jumpAir = false;
	private boolean flashJump = false;
	private boolean lastLeftSide = true;
	private boolean freeze = false;
	private byte dashCounter = 0;
	private int chargeEnergy = 0;
	// Player2 control variables
	private boolean arrowKeyCheck2[] = {false,false,false,false};
	private boolean arrowKeyPressed2[] = {false,false,false,false};
	private boolean attackKeyCheck2[] = {false};
	private boolean attackKeyPressed2[] = {false};
	private SuperObject preID2 = null;
	private boolean blockCollide2 = false;
	private boolean jumpAir2 = false;
	private boolean flashJump2 = false;
	private boolean lastLeftSide2 = true;
	private boolean freeze2 = false;
	private byte dashCounter2 = 0;
	private int chargeEnergy2 = 0;

	public Main() { // Create Event (GAME MAKER)
		setTitle("GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocation(300,200);
		setResizable(false);
		setVisible(true);
		setBackground(new Color(200, 200, 200));
		setFocusable(true);
		addKeyListener(this);
		
		// Invert 2nd player health bar
		healthBar2.setInverted(true);
		
		try {
			background = SuperObject.getImageFile(System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\back1.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Temp Create
		p1.setDepth(10);
		p2.setDepth(10);
		//Ground
		for (int i = 0; i < 7; i++)
			new Block(i * 90, 372, 0, 10, 90, 10,
					System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\grassySoil1.png", true).setDepth(5);

		//End Tiles
		new Block(140, 300, 7, 10, 41, 10,
				System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\endSoil.png", true);
		new Block(410, 300, 7, 10, 41, 10,
				System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\endSoil.png", true);

		//Cover Tiles
		for (int i = 0; i < 3; i++)
			new Block(i * 90 + 160, 328, 0, 0, 0, 0,
					System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\baseCover1.png", false).setDepth(4);
		new Block(131, 328, 0, 0, 0, 0,
				System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\endCover1.png", false).setDepth(4);
		new Block(430, 328, 0, 0, 0, 0,
				System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\endCover2.png", false).setDepth(4);
		
		//Platform
		for (int i = 0; i < 3; i++)
			new Block(i * 90 + 160, 300, 0, 10, 90, 10,
					System.getProperty("user.dir") + "\\Platforms\\GrassySoil\\grassySoil1.png", true).setDepth(5);
		
	}

	public Image getImage(String s) { // Script (GAME MAKER)
		return Toolkit.getDefaultToolkit().getImage(s);
	}

	public void paint(Graphics g) { // Painting (GAME MAKER)
		try {
			Thread.sleep(30); // ROOM SPEED
		} catch (InterruptedException e) {
		}
		mainImage = createImage(getWidth(), getHeight());

		step(mainImage.getGraphics());
		g.drawImage(mainImage, 0, 0, null);
		repaint();
	}

	public void step(Graphics g) { // Step Event (GAME MAKER)

		
		// Check for Attack Collisions
		SuperObject hitID = null, hitID2 = null;
		for (SuperObject b : SuperObject.getStepList()) {
			if (b.toString().startsWith("ImageEffects")) {
				// Player1 Check
				SuperObject id = SuperObject.isBBCollide(p1, 0, 0, 
						b, -EffectsParent.AllEffects.getXOffset(b.getSpriteIndex(), b.getImageIndex()),
						-EffectsParent.AllEffects.getYOffset(b.getSpriteIndex(), b.getImageIndex()));
				if (id != null) { // Bounding Box Check
					if ( id.getLethal() && id.getPlayerID() != p1.getObjID() )
						if ( SuperObject.isPPCollision(p1.spriteMask, p1.getX(), p1.getY(), 
									EffectsParent.AllEffects.getImageFrame(id.getSpriteIndex(), id.getImageIndex()), 
									id.getX() - EffectsParent.AllEffects.getXOffset(id.getSpriteIndex(), id.getImageIndex()), 
									id.getY() - EffectsParent.AllEffects.getYOffset(id.getSpriteIndex(), id.getImageIndex()) ) ) {
							hitID = id;
						}
				}
				
				// Player2 Check
				id = SuperObject.isBBCollide(p2, 0, 0, 
						b, -EffectsParent.AllEffects.getXOffset(b.getSpriteIndex(), b.getImageIndex()),
						-EffectsParent.AllEffects.getYOffset(b.getSpriteIndex(), b.getImageIndex()));
				if (id != null) { // Bounding Box Check
					if ( id.getLethal() && id.getPlayerID() != p2.getObjID() )
						if ( SuperObject.isPPCollision(p2.spriteMask, p2.getX(), p2.getY(), 
									EffectsParent.AllEffects.getImageFrame(id.getSpriteIndex(), id.getImageIndex()), 
									id.getX() - EffectsParent.AllEffects.getXOffset(id.getSpriteIndex(), id.getImageIndex()), 
									id.getY() - EffectsParent.AllEffects.getYOffset(id.getSpriteIndex(), id.getImageIndex()) ) ) {
							hitID2 = id;
						}
				}
			}
		}
		if ( hitID != null ) {
			// Player1 got hit
			
			if ( (p1.getHitMe() == 0 
					|| hitID != preID)
					&& !p1.getAttackName().startsWith("SpecialSkill") ) {
				
				freeze = ((ImageEffects)hitID).getFreeze();
				preID = hitID;
				p1.setHitMe(11);
				
				new ImageEffects( "Hit" + Integer.toString(myRandom.nextInt(3)), p1.getX(), p1.getY(), -1, p1.getLeftSide(), 0, p1 );
				
				int directionChange;
				if ( hitID.getSpriteIndex().endsWith("Left") ) {
					directionChange = -1;
				}
				else {
					directionChange = 1;
				}
				
				// Knockback power
				switch(hitID.getKnockback()) {
					case 1:
						p1.setXspeed(5 * directionChange, true);
						break;

					case 2:
						p1.setXspeed(10 * directionChange, true);
						break;
					
					case 3:
						p1.setXspeed(0, true);
						break;
					
					case 4:
						p1.setXspeed(14 * directionChange, true);
						break;
				}

				// Charge Energy Bar
				if (chargeEnergy > 33) {
					p1.setXspeed(13 * directionChange, true);
					chargeEnergy = 0;
					healthBar1.energyChange(-33.0);
					healthBar1.chargingEnergy(chargeEnergy);
				}
				
				if ( blockCollide ) {
					if (hitID.getKnockback() == 1
							|| hitID.getKnockback() == 2
							|| hitID.getKnockback() == 4) {
						p1.setY(p1.getY()-3, true);
						p1.setVspeed(-4);
					}
				}
				
				// Health Bar Decrease
				if ( healthBar1.healthDedux(5) ) {
					healthBar1.reset();
					healthBar2.reset();
					p1.setAttackName("");
					p2.setAttackName("");
					p1.setX(30, true);
					p1.setY(62, true);
					p2.setX(540, true);
					p2.setY(62, true);
					// Player1
					if ( dashCounter > 0 )
						dashCounter--;
					else if ( dashCounter < 0 )
						dashCounter++;
					
					for ( int i = 0 ; i < 4 ; i++ ) {
						arrowKeyCheck[i] = false;
						arrowKeyPressed[i] = false;
					}
					attackKeyPressed[0] = false;
					
					// Player2
					if ( dashCounter2 > 0 )
						dashCounter2--;
					else if ( dashCounter2 < 0 )
						dashCounter2++;
					
					for ( int i = 0 ; i < 4 ; i++ ) {
						arrowKeyCheck2[i] = false;
						arrowKeyPressed2[i] = false;
					}
					attackKeyPressed2[0] = false;
					
					JOptionPane.showMessageDialog(null, "Player 2 Wins!", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
				}
			}
					
		}
		else if (p1.getHitMe() == 0 ){
			freeze = false;
		}
		
		if ( hitID2 != null ) {
			// Player2 got hit
			
			if ( (p2.getHitMe() == 0 
					|| hitID2 != preID2)
					&& !p2.getAttackName().startsWith("SpecialSkill") ) {

				freeze2 = ((ImageEffects)hitID2).getFreeze();
				preID2 = hitID2;
				p2.setHitMe(11);

				new ImageEffects( "Hit" + Integer.toString(myRandom.nextInt(3)), p2.getX(), p2.getY(), -1, p2.getLeftSide(), 0, p2 );
				
				int directionChange;
				if ( hitID2.getSpriteIndex().endsWith("Left") ) {
					directionChange = -1;
				}
				else {
					directionChange = 1;
				}
				
				// Knockback power
				switch(hitID2.getKnockback()) {
					case 1:
						p2.setXspeed(5 * directionChange, true);
						break;

					case 2:
						p2.setXspeed(10 * directionChange, true);
						break;
					
					case 3:
						p2.setXspeed(0, true);
						break;
						
					case 4:
						p2.setXspeed(14 * directionChange, true);
						break;
				}
				
				// Charge Energy Bar
				if (chargeEnergy2 > 33) {
					p2.setXspeed(13 * directionChange, true);
					chargeEnergy2 = 0;
					healthBar2.energyChange(-33.0);
					healthBar2.chargingEnergy(chargeEnergy2);
				}
				
				if ( blockCollide2 ) {
					if (hitID2.getKnockback() == 1
							|| hitID2.getKnockback() == 2
							|| hitID2.getKnockback() == 4) {
						p2.setY(p2.getY()-3, true);
						p2.setVspeed(-4);
					}
				}

				// Health Bar Decrease
				if ( healthBar2.healthDedux(5) ) {
					healthBar1.reset();
					healthBar2.reset();
					p1.setAttackName("");
					p2.setAttackName("");
					p1.setX(30, true);
					p1.setY(62, true);
					p2.setX(540, true);
					p2.setY(62, true);
					// Player1
					if ( dashCounter > 0 )
						dashCounter--;
					else if ( dashCounter < 0 )
						dashCounter++;
					
					for ( int i = 0 ; i < 4 ; i++ ) {
						arrowKeyCheck[i] = false;
						arrowKeyPressed[i] = false;
					}
					attackKeyPressed[0] = false;
					
					// Player2
					if ( dashCounter2 > 0 )
						dashCounter2--;
					else if ( dashCounter2 < 0 )
						dashCounter2++;
					
					for ( int i = 0 ; i < 4 ; i++ ) {
						arrowKeyCheck2[i] = false;
						arrowKeyPressed2[i] = false;
					}
					attackKeyPressed2[0] = false;
					JOptionPane.showMessageDialog(null, "Player 1 Wins!", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		else if (p2.getHitMe() == 0){
			freeze2 = false;
		}
		
		////////////////////////////////////////////////////////////
		//////////////////// Button Conditions ////////////////////
		
		//////////////////// Attack ////////////////////
		// Player1
		if ( p1.getHitMe() == 0 ) {
			// Jump Attack
			if ( attackKeyPressed[0] && p1.getAttackName().equals("") && !blockCollide ) {
				p1.setAttackName("JumpAttack0");
			}
			
			// Basic Ground Attack
			if ( attackKeyPressed[0] && p1.getAttackName().equals("") && blockCollide ) {
				p1.setAttackName("OAttack2");
			}
			else if ( attackKeyPressed[0] 
					&& p1.getAttackName().equals("OAttack2") 
					&& !p1.getNextAttack().equals("OAttack3") 
					&& p1.getAttackTime() > 5 
					&& blockCollide ) {
				p1.setNextAttack("OAttack3");
			}
			else if ( attackKeyPressed[0] 
					&& p1.getAttackName().equals("OAttack3") 
					&& !p1.getNextAttack().equals("OAttack1") 
					&& p1.getAttackTime() > 3
					&& blockCollide ) {
				p1.setNextAttack("OAttack1");
			}
			
			//Release Energy - BIG ATTACK
			if (!attackKeyCheck[0] && blockCollide && !Player1.globalFreeze )
				/*if (chargeEnergy == 100) {
					healthBar1.energyChange(-100);
				}
				else if (chargeEnergy > 66) {
					healthBar1.energyChange(-66.0);
				}
				else */if (chargeEnergy > 33) {
					healthBar1.energyChange(-33.0);
					
					p1.setAttackTime(0);
					p1.setAttackName("SpecialSkill1");
				}
			
			//Charge Energy
			if (chargeEnergy == 0 
					&& attackKeyPressed[0])
				chargeEnergy = 1;
			if (chargeEnergy < 100
					&& chargeEnergy > 0
					&& attackKeyCheck[0] 
					&& healthBar1.getEnergy() >= chargeEnergy+1)
				chargeEnergy += 2;
			healthBar1.chargingEnergy(chargeEnergy);
		}
		if (!attackKeyCheck[0]) {
			chargeEnergy = 0;
			healthBar1.chargingEnergy(chargeEnergy);
		}
		
		if (blockCollide && p1.getAttackName().equals("JumpAttack0")) {
			p1.setAttackName("");
			p1.setAttackTime(0);
		}
			
		// Player2
		if ( p2.getHitMe() == 0 ) {
			// Jump Attack
			if ( attackKeyPressed2[0] && p2.getAttackName().equals("") && !blockCollide2 ) {
				p2.setAttackName("JumpAttack0");
			}
			
			// Basic Ground Attack
			if ( attackKeyPressed2[0] && p2.getAttackName().equals("") && blockCollide2 ) {
				p2.setAttackName("OAttack2");
			}
			else if ( attackKeyPressed2[0] 
					&& p2.getAttackName().equals("OAttack2") 
					&& !p2.getNextAttack().equals("OAttack3") 
					&& p2.getAttackTime() > 5 
					&& blockCollide2 ) {
				p2.setNextAttack("OAttack3");
			}
			else if ( attackKeyPressed2[0] 
					&& p2.getAttackName().equals("OAttack3") 
					&& !p2.getNextAttack().equals("OAttack1") 
					&& p2.getAttackTime() > 3 
					&& blockCollide2 ) {
				p2.setNextAttack("OAttack1");
			}

			//Release Energy - BIG ATTACK
			if (!attackKeyCheck2[0] && blockCollide2 && !Player1.globalFreeze )
				/*if (chargeEnergy2 == 100) {
					healthBar2.energyChange(-100);
				}
				else if (chargeEnergy2 > 66) {
					healthBar2.energyChange(- 66 );
				}
				else */if (chargeEnergy2 > 33) {
					healthBar2.energyChange(- 33 );

					p2.setAttackTime(0);
					p2.setAttackName("SpecialSkill1");
				}
			
			//Charge Energy
			if (chargeEnergy2 == 0 
					&& attackKeyPressed2[0])
				chargeEnergy2 = 1;
			if (chargeEnergy2 < 100
					&& chargeEnergy2 > 0
					&& attackKeyCheck2[0]
					&& healthBar2.getEnergy() >= chargeEnergy2+1)
				chargeEnergy2 += 2;
			healthBar2.chargingEnergy(chargeEnergy2);
		}
		if (!attackKeyCheck2[0]) {
			chargeEnergy2 = 0;
			healthBar2.chargingEnergy(chargeEnergy2);
		}
		
		if (blockCollide2 && p2.getAttackName().equals("JumpAttack0")) {
			p2.setAttackName("");
			p2.setAttackTime(0);
		}
		
		//////////////////// Flash Jump ////////////////////
		// Player1
		if (freeze)
			dashCounter = 0;
		if ( !flashJump && p1.getAttackName().equals("")
				&& (( dashCounter < 0 && dashCounter != -7 && arrowKeyPressed[0] ) 
				|| ( dashCounter > 0 && dashCounter != 7 && arrowKeyPressed[1] )) ) {
			flashJump = true;
			new ImageEffects( "FlashJump", p1.getX(), p1.getY(), -1, p1.getLeftSide(), 0, p1 );
			if ( dashCounter < 0 ) {
				p1.setXspeed(-18);
			}
			else {
				p1.setXspeed(18);
			}
			dashCounter = 0;
		}
		else if ( blockCollide ) {
			flashJump = false;
		}
		
		// Player2
		if (freeze2)
			dashCounter = 0;
		if ( !flashJump2 && p2.getAttackName().equals("")
				&& (( dashCounter2 < 0 && dashCounter2 != -7 && arrowKeyPressed2[0] ) 
				|| ( dashCounter2 > 0 && dashCounter2 != 7 && arrowKeyPressed2[1] )) ) {
			flashJump2 = true;
			new ImageEffects( "FlashJump", p2.getX(), p2.getY(), -1, p2.getLeftSide(), 0, p2 );
			if ( dashCounter2 < 0 ) {
				p2.setXspeed(-18);
			}
			else {
				p2.setXspeed(18);
			}
			dashCounter2 = 0;
		}
		else if ( blockCollide2 ) {
			flashJump2 = false;
		}
		
		
		//////////////////// Move left and right ////////////////////
		// Player1
		if (!freeze && !Player1.globalFreeze) {
			if ( (blockCollide && !p1.getAttackName().equals(""))
					|| (!arrowKeyCheck[0] && !arrowKeyCheck[1]) 
					|| Math.abs(p1.getXspeed()) > 5 ) {
				if ( p1.getXspeed() > 1 )
					p1.setXspeed( p1.getXspeed() -1, true );
				else if ( p1.getXspeed() < -1 )
					p1.setXspeed( p1.getXspeed() +1, true );
				else
					p1.setXspeed( 0, true );
			}
			if ( arrowKeyCheck[0]
					&& !arrowKeyCheck[1] ) {
				if ( p1.getXspeed() > -5 ) {
					if ( blockCollide )
						p1.setXspeed(p1.getXspeed()-1);
					else
						p1.setXspeed(p1.getXspeed()-1, true);
				}
				else if ( p1.getXspeed() > -5 )
					p1.setXspeed(-5);
				p1.setLeftSide(true);
				if( blockCollide ) {
					p1.setImageSpeed(5);
					p1.setSpriteIndex("WalkLeft");
				}
				else {
					p1.setImageSpeed(0);
					p1.setSpriteIndex("JumpLeft");
				}
			} 
			else if( !arrowKeyCheck[0]
					&& arrowKeyCheck[1] ) {
				if ( p1.getXspeed() < 5 )
					if ( blockCollide )
						p1.setXspeed(p1.getXspeed()+1);
					else
						p1.setXspeed(p1.getXspeed()+1, true);
				else if ( p1.getXspeed() < 5 )
					p1.setXspeed(5);
				p1.setLeftSide(false);
				if( blockCollide ) {
					p1.setImageSpeed(5);
					p1.setSpriteIndex("WalkRight");
				}
				else {
					p1.setImageSpeed(0);
					p1.setSpriteIndex("JumpRight");
				}
			}
			else if( blockCollide ) {
					
				if( p1.getLeftSide() ) {
					p1.setSpriteIndex("StandLeft");
					p1.setImageSpeed(7);
				}
				else if( !p1.getLeftSide() ) {
					p1.setSpriteIndex("StandRight");
					p1.setImageSpeed(7);
				}
			}
			else if( !blockCollide ) {
				if( p1.getLeftSide() ) {
					p1.setSpriteIndex("JumpLeft");
					p1.setImageSpeed(7);
				}
				else if( !p1.getLeftSide() ) {
					p1.setSpriteIndex("JumpRight");
					p1.setImageSpeed(7);
				}
			}
		}
			
		// Player2
		if (!freeze2 && !Player1.globalFreeze) {
			if ( (blockCollide2 && !p2.getAttackName().equals(""))
					|| (!arrowKeyCheck2[0] && !arrowKeyCheck2[1]) 
					|| Math.abs(p2.getXspeed()) > 5 ) {
				if ( p2.getXspeed() > 1 )
					p2.setXspeed( p2.getXspeed() -1, true );
				else if ( p2.getXspeed() < -1 )
					p2.setXspeed( p2.getXspeed() +1, true );
				else
					p2.setXspeed( 0, true );
			}
			if ( arrowKeyCheck2[0]
					&& !arrowKeyCheck2[1] ) {
				if ( p2.getXspeed() > -5 ) {
					if ( blockCollide2 )
						p2.setXspeed(p2.getXspeed()-1);
					else
						p2.setXspeed(p2.getXspeed()-1, true);
				}
				else if ( p2.getXspeed() > -5 )
					p2.setXspeed(-5);
				p2.setLeftSide(true);
				if( blockCollide2 ) {
					p2.setImageSpeed(5);
					p2.setSpriteIndex("WalkLeft");
				}
				else {
					p2.setImageSpeed(0);
					p2.setSpriteIndex("JumpLeft");
				}
			} 
			else if( !arrowKeyCheck2[0]
					&& arrowKeyCheck2[1] ) {
				if ( p2.getXspeed() < 5 )
					if ( blockCollide2 )
						p2.setXspeed(p2.getXspeed()+1);
					else
						p2.setXspeed(p2.getXspeed()+1, true);
				else if ( p2.getXspeed() < 5 )
					p2.setXspeed(5);
				p2.setLeftSide(false);
				if( blockCollide2 ) {
					p2.setImageSpeed(5);
					p2.setSpriteIndex("WalkRight");
				}
				else {
					p2.setImageSpeed(0);
					p2.setSpriteIndex("JumpRight");
				}
			}
			else if( blockCollide2 ) {
					
				if( p2.getLeftSide() ) {
					p2.setSpriteIndex("StandLeft");
					p2.setImageSpeed(7);
				}
				else if( !p2.getLeftSide() ) {
					p2.setSpriteIndex("StandRight");
					p2.setImageSpeed(7);
				}
			}
			else if( !blockCollide2 ) {
				if( p2.getLeftSide() ) {
					p2.setSpriteIndex("JumpLeft");
					p2.setImageSpeed(7);
				}
				else if( !p2.getLeftSide() ) {
					p2.setSpriteIndex("JumpRight");
					p2.setImageSpeed(7);
				}
			}
		}
		
		// Jump
		// Player1
		if ( arrowKeyCheck[2]
				&& !jumpAir
				&& blockCollide 
				&& p1.getAttackName().equals("") 
				&& !freeze ) {
			jumpAir = true;
			p1.setY( p1.getY() - 2 );
			p1.setVspeed(-13);
		}
		else if ( !arrowKeyCheck[2] ){
			jumpAir = false;
		}
		
		// Player2
		if ( arrowKeyCheck2[2]
				&& !jumpAir2
				&& blockCollide2
				&& p2.getAttackName().equals("") 
				&& !freeze2 ) {
			jumpAir2 = true;
			p2.setY( p2.getY() - 2 );
			p2.setVspeed(-13);
		}
		else if ( !arrowKeyCheck2[2] ){
			jumpAir2 = false;
		}
		
		// Down Drop
		// Player1
		if (  arrowKeyCheck[3] && !blockCollide && p1.getVspeed() < 0 && !freeze ) {
			p1.setVspeed(10);
		}
		if ( arrowKeyCheck[3] && blockCollide && p1.getY() < 290 ) {
			p1.setY(p1.getY()+2, true);
		}

		// Player2
		if (  arrowKeyCheck2[3] && !blockCollide2 && p2.getVspeed() < 0 && !freeze2 ) {
			p2.setVspeed(10);
		}
		if ( arrowKeyCheck2[3] && blockCollide && p2.getY() < 290 ) {
			p2.setY(p2.getY()+2, true);
		}
		
		// Counters & Controllers
		// Player1
		if ( dashCounter > 0 )
			dashCounter--;
		else if ( dashCounter < 0 )
			dashCounter++;
		
		for ( int i = 0 ; i < 4 ; i++ ) {
			arrowKeyPressed[i] = false;
		}
		attackKeyPressed[0] = false;
		
		// Player2
		if ( dashCounter2 > 0 )
			dashCounter2--;
		else if ( dashCounter2 < 0 )
			dashCounter2++;
		
		for ( int i = 0 ; i < 4 ; i++ ) {
			arrowKeyPressed2[i] = false;
		}
		attackKeyPressed2[0] = false;
		
		//////////////////// Check for platform collisions //////////////////// 
		blockCollide = false;
		blockCollide2 = false;
		for (SuperObject b : SuperObject.getStepList()) {
			if (b.toString().startsWith("Block")) {
				SuperObject id = SuperObject.isBBCollide(p1, 0, p1.getVspeed() + 2, b, 0, 0);
				if (id != null
						&& SuperObject.isBBCollide(p1, 0, 0, b, 0, 0) == null
						&& p1.getVspeed() >= 0) {
					blockCollide = true;
					p1.setY(id.getY() - p1.getHeight(), true);
					p1.setVspeed(0);
				}
				
				id = SuperObject.isBBCollide(p2, 0, p2.getVspeed() + 2, b, 0, 0);
				if (id != null
						&& SuperObject.isBBCollide(p2, 0, 0, b, 0, 0) == null
						&& p2.getVspeed() >= 0) {
					blockCollide2 = true;
					p2.setY(id.getY() - p2.getHeight(), true);
					p2.setVspeed(0);
				}
			}
		}
		if ( blockCollide ) { 
			p1.setGravity(0);
			p1.setVspeed(0);
		} else {
			p1.setGravity(1);
		}
		if ( blockCollide2 ) { 
			p2.setGravity(0);
			p2.setVspeed(0);
		} else {
			p2.setGravity(1);
		}
		
		g.drawImage(background, -20, -20, null);
		healthBar1.energyChange(0.12);
		healthBar2.energyChange(0.12);
		// Update each object every step
		for (SuperObject obj : SuperObject.getStepList()) {
			obj.step();
			obj.paint(g);
		}
	}

	public void keyPressed(KeyEvent k) { // Keyboard Event (GAME MAKER)
		// Player1
		if (k.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			if ( !arrowKeyCheck[0] )
				arrowKeyPressed[0] = true;
			arrowKeyCheck[0] = true;
			if ( dashCounter >= 0 )
				dashCounter = -7;
		}

		if (k.getKeyCode() == KeyEvent.VK_NUMPAD6) {
			if ( !arrowKeyCheck[1] )
				arrowKeyPressed[1] = true;
			arrowKeyCheck[1] = true;
			if ( dashCounter <= 0 )
				dashCounter = 7;
		}

		if (k.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			if ( !arrowKeyCheck[2] )
				arrowKeyPressed[2] = true;
			arrowKeyCheck[2] = true;
		}

		if (k.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			if ( !arrowKeyCheck[3] )
				arrowKeyPressed[3] = true;
			arrowKeyCheck[3] = true;
		}

		if (k.getKeyCode() == KeyEvent.VK_L) {
			if ( !attackKeyCheck[0] )
				attackKeyPressed[0] = true;
			attackKeyCheck[0] = true;
		}
		
		// Player2
		if (k.getKeyCode() == KeyEvent.VK_D) {
			if ( !arrowKeyCheck2[0] )
				arrowKeyPressed2[0] = true;
			arrowKeyCheck2[0] = true;
			if ( dashCounter2 >= 0 )
				dashCounter2 = -7;
		}

		if (k.getKeyCode() == KeyEvent.VK_G) {
			if ( !arrowKeyCheck2[1] )
				arrowKeyPressed2[1] = true;
			arrowKeyCheck2[1] = true;
			if ( dashCounter2 <= 0 )
				dashCounter2 = 7;
		}

		if (k.getKeyCode() == KeyEvent.VK_R) {
			if ( !arrowKeyCheck2[2] )
				arrowKeyPressed2[2] = true;
			arrowKeyCheck2[2] = true;
		}

		if (k.getKeyCode() == KeyEvent.VK_F) {
			if ( !arrowKeyCheck2[3] )
				arrowKeyPressed2[3] = true;
			arrowKeyCheck2[3] = true;
		}

		if (k.getKeyCode() == KeyEvent.VK_A) {
			if ( !attackKeyCheck2[0] )
				attackKeyPressed2[0] = true;
			attackKeyCheck2[0] = true;
		}

	}

	public void keyReleased(KeyEvent k) { // KeyReleased Event (GAME MAKER)
		// Player1
		if (k.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			arrowKeyCheck[0] = false;
		}

		if (k.getKeyCode() == KeyEvent.VK_NUMPAD6) {
			arrowKeyCheck[1] = false;
		}

		if (k.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			arrowKeyCheck[2] = false;
		}
		
		if (k.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			arrowKeyCheck[3] = false;
		}

		if (k.getKeyCode() == KeyEvent.VK_L) {
			attackKeyCheck[0] = false;
		}
		
		// Player2
		if (k.getKeyCode() == KeyEvent.VK_D) {
			arrowKeyCheck2[0] = false;
		}

		if (k.getKeyCode() == KeyEvent.VK_G) {
			arrowKeyCheck2[1] = false;
		}

		if (k.getKeyCode() == KeyEvent.VK_R) {
			arrowKeyCheck2[2] = false;
		}
		
		if (k.getKeyCode() == KeyEvent.VK_F) {
			arrowKeyCheck2[3] = false;
		}

		if (k.getKeyCode() == KeyEvent.VK_A) {
			attackKeyCheck2[0] = false;
		}
	}

	public void keyTyped(KeyEvent k) { // I Don't Like Using This (NOT GAME MAKER)
	}

	public static void main(String arg[]) {
		new Main();
	}

}