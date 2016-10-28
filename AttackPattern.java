/**
 * AttackPattern.java
 * Description: This class works with the AttackLibrary class. It helps 
 * 		organize the AttackPatterns in an array.
 *
 * Name: Andy Tan
 * Date: December 12th, 2013
 */
import java.util.ArrayList;

public class AttackPattern {
	private ArrayList<String> stepPattern = new ArrayList<String>();
	private int check;
	private String attackName;
	
    public AttackPattern( String attackName ) {
    	this.attackName = attackName;
    }
    
    public String getAttackName() {
    	return attackName;
    }
    
    public void addStepPattern( String steps ) {
    	stepPattern.add(steps);
    }
    
    public boolean actionPerform( SuperObject player, int index, String leftRight ) {
		if ( index == 0 )
			check = 0;
		
		// ATTACK STRING FORMAT: "12/1/WalkRight/2/Effect1/8/"
		// "12" = Frame
		// "1" = Action Type
		// "/WalkRight" = First Argument for Action Type
		
		if ( check <= stepPattern.size() ) {
			String[] checkPattern = stepPattern.get(check).split("/");
			if ( Integer.parseInt(checkPattern[0]) == index ) {
				switch( Integer.parseInt(checkPattern[1]) ) {
				
					// Change Player Sprite
					case 1:
						player.setSpriteIndex( checkPattern[2] + leftRight , true );
						player.setImageIndex( Integer.parseInt(checkPattern[3]) , true );
						check++;
						break;
					
					// Change Player Sprite and Create Attack Effect
					case 2:
						player.setSpriteIndex( checkPattern[2] + leftRight , true);
						player.setImageIndex( Integer.parseInt(checkPattern[3]), true );
						ImageEffects temp = new ImageEffects( checkPattern[4], player.getX(), player.getY(), 
								Integer.parseInt(checkPattern[5]), player.getLeftSide(), Integer.parseInt(checkPattern[6]), player );
						if (attackName.startsWith("Special"))
							temp.setFreeze(true);
						temp.setLethal(true);
						check++;
						break;
					
					// Create Attack Effect
					case 3:
						ImageEffects temp2 = new ImageEffects( checkPattern[2], player.getX(), player.getY(), 
								Integer.parseInt(checkPattern[3]), player.getLeftSide(), Integer.parseInt(checkPattern[4]), player );
						if (attackName.startsWith("Special"))
							temp2.setFreeze(true);
						temp2.setLethal(true);
						check++;
						break;
					
					// Last frame
					case 4:
						return false;
						
					// Special Skill Freeze
					case 5:
						Player1.globalFreeze = true;
						new ImageEffects( checkPattern[2], 0, 0, 
								10, player.getLeftSide(), 0, player );
						check++;
						break;
						
					default:
						break;
				}
			}	
			return true;
		}
		else {
			return false;
		}
    }
}