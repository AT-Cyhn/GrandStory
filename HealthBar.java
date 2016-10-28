/**
 * HealthBar.java
 * Description: This class draws the health bar at the top of the screen.
 * 		The health bar can be adjusted to any position.
 *
 * Name: Jehro Celemin 
 * Date: January 7th, 2014
 */
import java.awt.Color;
import java.awt.Graphics;

public class HealthBar extends SuperObject{
	//describes the percentage of health & energy remaining
	private int health = 100;
	private double energy = 0;
	private double chargeEnergy = 0;
	private int x, y, width, height;
	private int x2, y2, width2, height2;
	private boolean inverted;
	//reference to the Player1 object that we are displaying health for
	private SuperObject myPlayer;
	private int objID;
	
	//constructor
	public HealthBar(SuperObject myPlayer, int x, int y, int width, int height, int x2, int y2, int width2, int height2) {
		super.addStepList(this);
		super.sortStepList();
		this.myPlayer = myPlayer;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.x2 = x2;
		this.y2 = y2;
		this.width2 = width2;
		this.height2 = height2;
	}
	
	//paints the health bar & energy bar
	public void paint(Graphics g) {
		if (!inverted) {
			//Health Bar
			g.setColor(Color.BLACK);
			g.drawString(myPlayer.toString(), x, y-15);
			g.setColor(Color.GRAY);
			g.fillRect(x-2, y-2, width+4, height+4);
			g.setColor(Color.GREEN);
			g.fillRect(x, y, (int)((double)width/100.0*(double)health), height);
			
			//Energy Bar
			g.setColor(Color.GRAY);
			g.fillRect(x2-2, y2-2, width2+4, height2+4);
			g.setColor(Color.YELLOW);
			g.fillRect(x2, y2, (int)((double)width2/100.0*energy), height2);
			//Charged Energy
			g.setColor(new Color(255,0,0));
			g.fillRect(x2, y2, (int)((double)width2/100.0*chargeEnergy), height2);
			
			if (energy > 33)
				if (chargeEnergy > 33)
					g.setColor(new Color(0,0,0));
				else
					g.setColor(new Color(255,100,0));
			else
				g.setColor(new Color(255,200,130));
			g.fillOval(x2 + width2/3 - 7, y2 - 2, 14, 14);
			
	
			if (energy > 66)
				if (chargeEnergy > 66)
					g.setColor(new Color(0,0,0));
				else
					g.setColor(new Color(255,100,0));
			else
				g.setColor(new Color(255,200,130));
			g.fillOval(x2 + width2/3*2 - 7, y2 - 2, 14, 14);
	
			if (energy == 100.0)
				if (chargeEnergy == 100)
					g.setColor(new Color(0,0,0));
				else
					g.setColor(new Color(255,100,0));
			else
				g.setColor(new Color(255,200,130));
			g.fillOval(x2 + width2 - 7, y2 - 2, 14, 14);
		}
		else {
			//Health Bar
			g.setColor(Color.BLACK);
			g.drawString(myPlayer.toString(), x-40, y-15);
			g.setColor(Color.GRAY);
			g.fillRect(x-width-2, y-2, width+4, height+4);
			g.setColor(Color.GREEN);
			g.fillRect(x-(int)((double)width/100.0*(double)health), y, (int)((double)width/100.0*(double)health), height);
			
			//Energy Bar
			g.setColor(Color.GRAY);
			g.fillRect(x2-width2-2, y2-2, width2+4, height2+4);
			g.setColor(Color.YELLOW);
			g.fillRect(x2-(int)((double)width2/100.0*energy), y2, (int)((double)width2/100.0*energy), height2);
			//Charged Energy
			g.setColor(new Color(255,0,0));
			g.fillRect(x2-(int)((double)width2/100.0*chargeEnergy), y2, (int)((double)width2/100.0*chargeEnergy), height2);
			

			if (energy > 33) {
				if (chargeEnergy > 33)
					g.setColor(new Color(0,0,0));
				else
					g.setColor(new Color(255,100,0));
			}
			else
				g.setColor(new Color(255,200,130));
			g.fillOval(x2 - width2/3 - 7, y2 - 2, 14, 14);
			
	
			if (energy > 66) {
				if (chargeEnergy > 66)
					g.setColor(new Color(0,0,0));
				else
					g.setColor(new Color(255,100,0));
			}
			else
				g.setColor(new Color(255,200,130));
			g.fillOval(x2 - width2/3*2 - 7, y2 - 2, 14, 14);
	
			if (energy == 100.0) {
				if (chargeEnergy == 100)
					g.setColor(new Color(0,0,0));
				else
					g.setColor(new Color(255,100,0));
			}
			else
				g.setColor(new Color(255,200,130));
			g.fillOval(x2 - width2 - 7, y2 - 2, 14, 14);
		}
	}
	
	//deducts health to the player when hit and if health is 0, fight ends
	public boolean healthDedux(int amount) {
		health -= amount;
		if (health <= 0)
			return true;
		else
			return false;
	}
	
	//change energy level
	public void energyChange(double energy) {
		if (this.energy+energy <= 100.0)
			this.energy += energy;
		else
			this.energy = 100.0;
	}
	
	public double getEnergy() {
		return energy;
	}
	
	//charge energy bar
	public void chargingEnergy(double chargeEnergy) {
		if (chargeEnergy >= 100)
			this.chargeEnergy = 100;
		else
			this.chargeEnergy = chargeEnergy;
	}
	
	//resets the health bar back to 100
	public void reset() {
		health = 100;
		energy = 0;
		chargeEnergy = 0;
	}
	
	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}
	
	public String toString() {
		return "HealthBar" + Integer.toString(objID);
	}

	///////////////////////////
	public int getObjID() {
		return objID;
	}
	
	public void setObjID( int objID ) {
		this.objID = objID;
	}
}