/**
 * Player1.java
 * Description: This class contains all the necessary variables for each
 * 		Player. It is controlled by the main class.
 *
 * Name: Andy Tan 
 * Date: November 12th, 2013
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player1 extends SuperObject {
	public static boolean globalFreeze;
	private int objID;
	private int playerSelection = 1;
	private int x, y;
	private int x_origin = 0;
	private int y_origin = 0;
	private int width = 30;
	private int height = 60;
	private int gravity;
	private int xspeed, vspeed;
	private int depth;
	private int imageTrigger;
	private int imageSpeed = 8;
	private int imageIndex;
	private String attackName = "";
	private String nextAttack = "";
	private int attackTime = 0;
	private int hitMe = 0;
	private boolean lastLeftSide = true;
	private String spriteIndex = "StandLeft";
	public BufferedImage spriteMask;
	private AttackLibrary myAttacks = new AttackLibrary();

	public Player1(int x, int y, int playerSelection) {
		try {
			super.addStepList(this);
			super.sortStepList();
			this.x = x;
			this.y = y;
			spriteMask = super.getImageFile(System.getProperty("user.dir") + "\\Player1\\boundBox.png");
			this.playerSelection = playerSelection;
			
			// Load Attack Patterns
			myAttacks.addAttackPattern("JumpAttack0");
			myAttacks.addStepPattern("JumpAttack0", "0/1/OAttack2/0/");
			myAttacks.addStepPattern("JumpAttack0", "2/2/OAttack2/1/OAttack2/6/1/");
			myAttacks.addStepPattern("JumpAttack0", "5/1/OAttack2/2/");
			myAttacks.addStepPattern("JumpAttack0", "18/4/");
			
			myAttacks.addAttackPattern("OAttack1");
			myAttacks.addStepPattern("OAttack1", "0/1/OAttack1/0/");
			myAttacks.addStepPattern("OAttack1", "2/1/OAttack1/1/");
			myAttacks.addStepPattern("OAttack1", "5/2/OAttack1/2/OAttack1/3/2/");
			myAttacks.addStepPattern("OAttack1", "12/4/");
			
			myAttacks.addAttackPattern("OAttack2");
			myAttacks.addStepPattern("OAttack2", "0/1/OAttack2/0/");
			myAttacks.addStepPattern("OAttack2", "2/2/OAttack2/1/OAttack2/3/1/");
			myAttacks.addStepPattern("OAttack2", "7/1/OAttack2/2/");
			myAttacks.addStepPattern("OAttack2", "11/4/");
			
			myAttacks.addAttackPattern("OAttack3");
			myAttacks.addStepPattern("OAttack3", "0/1/OAttack3/0/");
			myAttacks.addStepPattern("OAttack3", "2/1/OAttack3/1/");
			myAttacks.addStepPattern("OAttack3", "5/2/OAttack3/2/OAttack3/3/1/");
			myAttacks.addStepPattern("OAttack3", "9/4/");
			
			myAttacks.addAttackPattern("OAttackF");
			myAttacks.addStepPattern("OAttackF", "0/1/OAttackF/0/");
			myAttacks.addStepPattern("OAttackF", "4/1/OAttackF/1/");
			myAttacks.addStepPattern("OAttackF", "8/4/");
			
			myAttacks.addAttackPattern("OAttackP");
			myAttacks.addStepPattern("OAttackP", "0/1/OAttackP/0/");
			myAttacks.addStepPattern("OAttackP", "3/1/OAttackP/1/");
			myAttacks.addStepPattern("OAttackP", "6/1/OAttackP/2/");
			myAttacks.addStepPattern("OAttackP", "8/1/OAttackP/3/");
			myAttacks.addStepPattern("OAttackP", "13/4/");
			
			myAttacks.addAttackPattern("SpecialSkill1");
			myAttacks.addStepPattern("SpecialSkill1", "0/1/OAttack2/0/");
			myAttacks.addStepPattern("SpecialSkill1", "4/1/OAttack2/1/");
			myAttacks.addStepPattern("SpecialSkill1", "7/5/SpecialFreeze"+Integer.toString(playerSelection)+"/");
			myAttacks.addStepPattern("SpecialSkill1", "8/2/OAttack2/2/OAttack2/4/3/");
			myAttacks.addStepPattern("SpecialSkill1", "12/1/OStab1/0/");
			myAttacks.addStepPattern("SpecialSkill1", "16/2/OStab1/1/OStab1/2/3/");
			myAttacks.addStepPattern("SpecialSkill1", "18/1/OAttackF/0/");
			myAttacks.addStepPattern("SpecialSkill1", "21/1/OAttackF/1/");
			myAttacks.addStepPattern("SpecialSkill1", "24/1/OAttackF/2/");
			myAttacks.addStepPattern("SpecialSkill1", "27/2/OAttackF/3/OAttackF/4/4/");
			myAttacks.addStepPattern("SpecialSkill1", "38/4/");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////
	public int getObjID() {
		return objID;
	}
	
	public void setObjID( int objID ) {
		this.objID = objID;
	}

	///////////////////////////
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if ( attackName.equals("") )
			this.x = x;
	}
	public void setX(int x, boolean bypass) {
		this.x = x;
	}

	///////////////////////////
	public int getY() {
		return y;
	}
	public void setY(int y) {
		if ( attackName.equals("") )
			this.y = y;
	}
	public void setY(int y, boolean bypass) {
		this.y = y;
	}
	
	///////////////////////////
	public int getXOffset() {
		return x_origin;
	}
	public void setXOffset(int x_origin) {
		this.x_origin = x_origin;
	}
	
	///////////////////////////
	public int getYOffset() {
		return y_origin;
	}
	public void setYOffset(int y_origin) {
		this.y_origin = y_origin;
	}

	///////////////////////////
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	///////////////////////////
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	///////////////////////////
	public int getVspeed() {
		return vspeed;
	}

	public void setVspeed(int vspeed) {
		this.vspeed = vspeed;
	}

	///////////////////////////
	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int xspeed) {
		if ( attackName.equals("") )
			this.xspeed = xspeed;
	}
	
	public void setXspeed(int xspeed, boolean bypass) {
		this.xspeed = xspeed;
	}

	///////////////////////////
	public int getGravity() {
		return gravity;
	}
	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	///////////////////////////
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
		super.sortStepList();
	}

	///////////////////////////
	public String getSpriteIndex() {
		return spriteIndex;
	}

	public void setSpriteIndex(String spriteIndex) {
		if ( attackName.equals("") )
			this.spriteIndex = spriteIndex;
	}
	
	public void setSpriteIndex(String spriteIndex, boolean bypass) {
		this.spriteIndex = spriteIndex;
	}

	///////////////////////////
	public int getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(int imageIndex) {
		if ( attackName.equals("") )
			this.imageIndex = imageIndex;
	}
	
	public void setImageIndex(int imageIndex, boolean bypass) {
		this.imageIndex = imageIndex;
	}
	
	///////////////////////////
	public int getImageSpeed() {
		return imageSpeed;
	}

	public void setImageSpeed(int imageSpeed) {
		this.imageSpeed = imageSpeed;
	}
	
	///////////////////////////
	public boolean getLeftSide() {
		return lastLeftSide;
	}

	public void setLeftSide(boolean lastLeftSide) {
		if ( attackName.equals("") )
			this.lastLeftSide = lastLeftSide;
	}
	
	///////////////////////////
	public String getAttackName() {
		return attackName ;
	}

	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}
	
	///////////////////////////
	public String getNextAttack() {
		return nextAttack ;
	}

	public void setNextAttack(String nextAttack) {
		this.nextAttack = nextAttack;
	}
	
	///////////////////////////
	public int getAttackTime() {
		return attackTime ;
	}

	public void setAttackTime(int attackTime) {
		this.attackTime = attackTime;
	}
	
	public int getHitMe() {
		return hitMe;
	}

	public void setHitMe(int hitMe) {
		this.hitMe = hitMe;
	}

	public int getPlayerSelection() {
		return playerSelection;
	}

	public void setPlayerSelection(int playerSelection) {
		this.playerSelection = playerSelection;
	}

	public void step() {
		if (!globalFreeze) {
			
			if ( getHitMe() > 0 ) {
				attackName = "";
				nextAttack = "";
				attackTime = 0;
				setHitMe(getHitMe() - 1);
				if (lastLeftSide)
					spriteIndex = "AlertLeft";
				else
					spriteIndex = "AlertRight";
			}
			
			if ( !attackName.equals("") ) {
				if ( myAttacks.actionPerform( attackName, this, attackTime, lastLeftSide ) )
					attackTime++;
				else {
					attackTime = 0;
					if ( nextAttack.equals("") )
						attackName = "";
					else {
						attackName = nextAttack;
						nextAttack = "";
					}
				}
			}
			else {
				attackTime = 0;
				
				imageTrigger++;
				if (imageTrigger >= imageSpeed) {
					imageIndex++;
					imageTrigger = 0;
				}
				if (imageIndex >= EffectsParent.AllCharacters[playerSelection].getTotalImages(spriteIndex))
					imageIndex = 0;
			}
				
			vspeed += gravity;
			y += vspeed;
			if ( x+xspeed < 570 && x+xspeed > 0 )
				x += xspeed;
			
			if ( vspeed > 10 ) {
				vspeed = 10;
			}
		}
	}

	public void paint(Graphics g) {
		if (spriteIndex != null)
			g.drawImage(EffectsParent.AllCharacters[playerSelection].getImageFrame(spriteIndex, imageIndex), 
					(int) (Math.round(x - EffectsParent.AllCharacters[playerSelection].getXOffset(spriteIndex, imageIndex))), 
					(int) (Math.round(y - EffectsParent.AllCharacters[playerSelection].getYOffset(spriteIndex, imageIndex))), null);
		
		g.setColor(Color.RED);
		g.drawString(toString(), x, y-22);
		
		//g.drawRect(x, y, width, height);
	}
	
	public String toString() {
		return "Player" + Integer.toString(objID);
	}
}