/**
 * Block.java
 * Description: This class draws platforms in the game.
 * 		Players can jump on it.
 *
 * Name: Andy Tan 
 * Date: November 12th, 2013
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Block extends SuperObject {
	private int objID;
	private int x;
	private int y;
	private int x_origin;
	private int y_origin;
	private int width;
	private int height;
	private int depth;
	private boolean solid;
	private Image sprite_index;
	private String sprite_path;

	public Block(int x, int y, int x_origin, int y_origin, int width,
			int height, String sprite_path, boolean solid) {
		super.addStepList(this);
		super.sortStepList();
		this.x = x;
		this.y = y;
		this.x_origin = x_origin;
		this.y_origin = y_origin;
		this.width = width;
		this.height = height;
		this.sprite_path = sprite_path;
		this.solid = solid;
		sprite_index = Toolkit.getDefaultToolkit().getImage(sprite_path);
	}
		
	///////////////////////////
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	///////////////////////////
	public int getObjID() {
		return objID;
	}
	
	public void setObjID( int objID ) {
		this.objID = objID;
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

	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
		super.sortStepList();
	}

	public void paint(Graphics g) {
		g.drawImage(sprite_index, (int) (Math.round(x - x_origin)), (int) (Math.round(y - y_origin)), null);
	}

	public String toString() {
		if (solid)
			return "Block" + Integer.toString(objID);
		else
			return "NullBlock" + Integer.toString(objID);
	}
}