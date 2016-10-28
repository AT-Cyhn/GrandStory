/**
 * MoveSet.java
 * Description: This class works with the Animation class to store images into arrays.
 * 		This organizes animated images for other classes to use.
 *
 * Name: Andy Tan & Jehro Celemin 
 * Date: November 28th, 2013
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MoveSet {
	private String moveName;
	private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>();
	private ArrayList<Integer> xOffsetList = new ArrayList<Integer>();
	private ArrayList<Integer> yOffsetList = new ArrayList<Integer>();
	

	public MoveSet( String moveName ) {
		this.moveName = moveName;
	}
	
	public String getMoveName() {
		return moveName;
	}
	
	public void addImageFrame( BufferedImage img, int xOffset, int yOffset ) {
		imageList.add(img);
		xOffsetList.add(xOffset);
		yOffsetList.add(yOffset);
	}
	
	public BufferedImage getImageFrame( int index ) {
		return imageList.get(index);
	}
	
	public int getXOffset( int index ) {
		return xOffsetList.get(index);
	}
	
	public int getYOffset( int index ) {
		return yOffsetList.get(index);
	}
	
	public int getTotalImages() {
		return imageList.size();
	}
}
