/**
 * Animation.java
 * Description: This class stores all the animations into MoveSet classes.
 * 		All MoveSets are stored in an array.
 *
 * Name: Andy Tan & Jehro Celemin 
 * Date: November 27th, 2013
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
	private ArrayList<MoveSet> moveList = new ArrayList<MoveSet>();
	
	public void addMoveSet( String moveName ) {
		moveList.add(new MoveSet(moveName));
	}
	
	public void addImageFrame( String moveName, BufferedImage img, int xOffset, int yOffset ) {
		for( MoveSet x : moveList ) {
			if ( x.getMoveName().equals(moveName) )
				x.addImageFrame(img, xOffset, yOffset);
		}
	}
	
	public BufferedImage getImageFrame( String moveName, int index) {
		for( MoveSet x : moveList ) {
			if ( x.getMoveName().equals(moveName) )
				return x.getImageFrame(index);
		}
		return null;
	}
	
	public int getXOffset( String moveName, int index) {
		for( MoveSet x : moveList ) {
			if ( x.getMoveName().equals(moveName) )
				return x.getXOffset(index);
		}
		return 0;
	}
	
	public int getYOffset( String moveName, int index) {
		for( MoveSet x : moveList ) {
			if ( x.getMoveName().equals(moveName) )
				return x.getYOffset(index);
		}
		return 0;
	}
	
	public int getTotalImages( String moveName ) {
		for( MoveSet x : moveList ) {
			if ( x.getMoveName().equals(moveName) )
				return x.getTotalImages();
		}
		return -1;
		
	}
	
}
