/**
 * SuperObject.java
 * Description: This class controls all the objects in the game.
 * 		It holds all objects in an array for processing.
 *
 * Name: Andy Tan 
 * Date: November 21st, 2013
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

public class SuperObject {
	private static CopyOnWriteArrayList<SuperObject> stepList = new CopyOnWriteArrayList<SuperObject>();
	private static int objID = 1;

	public void step() {
	}

	public void paint(Graphics g) {
	}
	
	///////////////////////////
	public int getObjID() {
		return objID;
	}
	
	public void setObjID( int objID ) {
	}

	///////////////////////////
	public int getDepth() {
		return 0;
	}
	public void setDepth( int depth ) {
	}

	///////////////////////////
	public int getX() {
		return 0;
	}
	public void setX( int x ) {
	}
	public void setX(int x, boolean bypass) {
	}

	///////////////////////////
	public int getY() {
		return 0;
	}
	public void setY( int y ) {
	}
	public void setY(int y, boolean bypass) {
	}
	
	///////////////////////////
	public int getXOffset() {
		return 0;
	}
	public void setXOffset(int x_origin) {
	}
	
	///////////////////////////
	public int getYOffset() {
		return 0;
	}
	public void setYOffset(int y_origin) {
	}
	
	///////////////////////////
	public int getVspeed() {
		return 0;
	}

	public void setVspeed(int vspeed) {
	}

	///////////////////////////
	public int getXspeed() {
		return 0;
	}

	public void setXspeed(int xspeed) {
	}
	
	public void setXspeed(int xspeed, boolean bypass) {
	}

	///////////////////////////
	public int getWidth() {
		return 0;
	}

	public int getHeight() {
		return 0;
	}
	
	///////////////////////////
	public String getSpriteIndex() {
		return "";
	}

	public void setSpriteIndex(String spriteIndex) {
	}
	
	public void setSpriteIndex(String spriteIndex, boolean bypass) {
	}

	///////////////////////////
	public int getImageIndex() {
		return 0;
	}

	public void setImageIndex(int imageIndex) {
	}
	
	public void setImageIndex(int imageIndex, boolean bypass) {
	}
	
	///////////////////////////
	public String getAttackName() {
		return "";
	}

	public void setAttackName(String attackName) {
	}

	///////////////////////////
	public int getAttackTime() {
		return 0;
	}
	
	public void setAttackTime(int attackTime) {
	}
	
	///////////////////////////
	public String getNextAttack() {
		return "" ;
	}

	public void setNextAttack(String nextAttack) {
	}

	///////////////////////////
	public boolean getLeftSide() {
		return false;
	}

	public void setLeftSide(boolean leftSide) {
	}

	///////////////////////////
	public int getPlayerID() {
		return 0;
	}

	public void setPlayerID(int playerID) {
	}
	
	///////////////////////////
	public boolean getLethal() {
		return false;
	}

	public void setLethal(boolean lethal) {
	}

	///////////////////////////
	public int getKnockback() {
		return 0;
	}

	public void setKnockback(int knockback) {
	}

	public static SuperObject isBBCollide(SuperObject obj1, int xOffset1, int yOffset1, SuperObject obj2, int xOffset2, int yOffset2) {
		if ((obj1.getX() + xOffset1 < obj2.getX() + obj2.getWidth() + xOffset2)
				&& (obj1.getX() + obj1.getWidth() + xOffset1 > obj2.getX() + xOffset2)
				&& (obj1.getY() + yOffset1 < obj2.getY() + obj2.getHeight() + yOffset2)
				&& (obj1.getY() + obj1.getHeight() + yOffset1 > obj2.getY() + yOffset2))
			return obj2;
		else
			return null;
	}
	
	public static boolean isPPCollision( BufferedImage image1, int x1, int y1, BufferedImage image2, int x2, int y2){
        boolean bool = false;
        double width1 = x1 + image1.getWidth() - 1, height1 = y1
                + image1.getHeight() - 1, width2 = x2 + image2.getWidth() - 1, height2 = y2
                + image2.getHeight() - 1;
        int xstart = (int) Math.max(x1, x2), ystart = (int) Math.max(y1, y2), xend = (int) Math.min(width1, width2), yend = (int) Math.min(height1, height2);
        int toty = Math.abs(yend - ystart);
        int totx = Math.abs(xend - xstart);
        for (int y = 1; y < toty - 1; y++) {
            int ny = Math.abs(ystart - (int) y1) + y;
            int ny1 = Math.abs(ystart - (int) y2) + y;
            for (int x = 1; x < totx - 1; x++) {
                int nx = Math.abs(xstart - (int) x1) + x;
                int nx1 = Math.abs(xstart - (int) x2) + x;
                try {
                    if (((image1.getRGB(nx, ny) & 0xFF000000) != 0x00)
                            && ((image2.getRGB(nx1, ny1) & 0xFF000000) != 0x00)) {
                        bool = true;
                    }
                } catch (Exception e) {
                }
            }
        }
        return bool;
    }

	public static void sortStepList() {
		for (int i = getStepList().size() - 1; i > 0; i--) {
			if (getStepList().get(i).getDepth() < getStepList().get(i - 1).getDepth())
				Collections.swap(getStepList(), i, i - 1);
		}
		
		/*
		for (SuperObject x : getStepList()) {
			System.out.println(x);
		}
		System.out.println();
		*/
	}
	
	public static void addStepList(SuperObject obj) {
		obj.setObjID(objID);
		stepList.add(obj);
		objID++;
		sortStepList();
	}

	public static boolean removeStepList(SuperObject obj) {
		return stepList.remove(obj);
	}

	public String toString() {
		return "SuperObject";
	}

	public static CopyOnWriteArrayList<SuperObject> getStepList() {
		return stepList;
	}

	public static void setStepList(CopyOnWriteArrayList<SuperObject> stepList) {
		SuperObject.stepList = stepList;
	}
	
	public static BufferedImage getImageFile( String path ) throws IOException{
		return ImageIO.read(new File(path));
	}
	
	public static BufferedImage getFlippedImage(BufferedImage bi) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-bi.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return op.filter(bi, null);
    }

}