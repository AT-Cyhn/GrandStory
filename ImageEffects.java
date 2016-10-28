/**
 * ImageEffects.java
 * Description: This class creates special effects on the screen.
 * 		Variables can be adjusted to change the characteristic of the effect.
 *
 * Name: Andy Tan 
 * Date: January 7th, 2014
 */
 
import java.awt.Graphics;

public class ImageEffects extends SuperObject {
	private int objID;
	private int x, y, width, height;
	private boolean lethal = false;
	private boolean follow = false;
	private boolean freeze = false;
	private int knockback;
	private int damage;
	private SuperObject playerControl;
	private int playerID;
	private int imageSpeed = 4;
	private int imageTrigger = 0, imageIndex = 0;
	private String leftSide;
	private int depth;
	private String spriteIndex = "";
	private int deathTimer;
	
    public ImageEffects( String spriteIndex, int x, int y , int deathTimer , boolean leftSide, int knockback, SuperObject playerControl ) {
		this.x = x;
		this.y = y;
		this.playerControl = playerControl;
		this.playerID = playerControl.getObjID();
		this.deathTimer = deathTimer;
		if (spriteIndex.startsWith("Hit"))
			this.leftSide = "";
		else if ( leftSide )
			this.leftSide = "Left";
		else 
			this.leftSide = "Right";
    	this.spriteIndex = spriteIndex + this.leftSide;
    	this.knockback = knockback;
    	
    	switch( spriteIndex ) {
    		case "FlashJump":
    			imageSpeed = 2;
    			depth = 5;
    			follow = false;
    			break;
    		
    		case "OStab1":
    		case "OAttack1":
    		case "OAttack2":
    		case "OAttack3":
    		case "OAttackF":
    			imageSpeed = 10;
    			depth = 15;
    			follow = true;
    			break;
    			
    		case "Hit0":
    		case "Hit1":
    		case "Hit2":
    			imageSpeed = 2;
    			depth = 16;
    			follow = true;
    			break;
    		
    		case "SpecialFreeze1":
    		case "SpecialFreeze2":
    			imageSpeed = 12;
    			depth = 30;
    			follow = false;
    			break;
    	}
    	
    	width = EffectsParent.AllEffects.getImageFrame(this.spriteIndex, 0).getWidth();
    	height = EffectsParent.AllEffects.getImageFrame(this.spriteIndex, 0).getHeight();
    	
		super.addStepList(this);
		super.sortStepList();
    	
    }
    
    public void step() {
    	if ( follow ) {
    		x = playerControl.getX() + playerControl.getXspeed();
    		y = playerControl.getY() + playerControl.getVspeed();
    	}
    	
		if ( deathTimer > 0 ) 
			deathTimer--;
		
		if ( deathTimer == 0 ) {
			if (spriteIndex.startsWith("SpecialFreeze")) {
				Player1.globalFreeze = false;
			}
			super.removeStepList(this);
		}
		
		// Timed death is positive and Loop death is negative
		imageTrigger++;
		if (imageTrigger >= imageSpeed) {
			if (imageIndex+1 >= EffectsParent.AllEffects.getTotalImages(spriteIndex)) {
				imageIndex = 0;
				if ( deathTimer < 0 )
					deathTimer++;
			}
			else
				imageIndex++;
			imageTrigger = 0;
		}
		
    }

	public void paint(Graphics g) {
		if ( deathTimer != 0 )
		g.drawImage(EffectsParent.AllEffects.getImageFrame(spriteIndex, imageIndex), 
				(int) (Math.round(x - EffectsParent.AllEffects.getXOffset(spriteIndex, imageIndex))), 
				(int) (Math.round(y - EffectsParent.AllEffects.getYOffset(spriteIndex, imageIndex))), null);
	}
	
    public String toString() {
    	return "ImageEffects" + Integer.toString(objID); 
    }
	
	///////////////////////////
	public int getObjID() {
		return objID;
	}
	
	public void setObjID( int objID ) {
		this.objID = objID;
	}
	
	///////////////////////////
	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	///////////////////////////
	public int getX() {
		return x;
	}
	public void setX(int x) {
			this.x = x;
	}

	///////////////////////////
	public int getY() {
		return y;
	}
	public void setY(int y) {
			this.y = y;
	}
	
	///////////////////////////
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	///////////////////////////
	public String getSpriteIndex() {
		return spriteIndex;
	}

	public void setSpriteIndex(String spriteIndex) {
		this.spriteIndex = spriteIndex;
	}

	///////////////////////////
	public int getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
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
	public boolean getLethal() {
		return lethal;
	}

	public void setLethal(boolean lethal) {
		this.lethal = lethal;
	}

	///////////////////////////
	public int getKnockback() {
		return knockback;
	}

	public void setKnockback(int knockback) {
		this.knockback = knockback;
	}

	///////////////////////////
	public boolean getFreeze() {
		return freeze;
	}

	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}