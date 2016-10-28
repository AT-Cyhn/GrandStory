/**
 * AttackLibrary.java
 * Description: This class holds all attack patterns for players.
 * 		It organizes patterns in AttackPattern classes.
 * 
 * Name: Andy Tan
 * Date: December 12th, 2013
 */

import java.util.ArrayList;

public class AttackLibrary {
	private ArrayList<AttackPattern> patternList = new ArrayList<AttackPattern>();

    public void addAttackPattern( String attackName ) {
    	patternList.add( new AttackPattern(attackName) );
    }
    
    public void addStepPattern( String attackName, String steps ) {
    	for( AttackPattern x : patternList ) {
			if ( x.getAttackName().equals(attackName) )
				x.addStepPattern(steps);
		}
    }
    
    public boolean actionPerform( String attackName, SuperObject player, int index, boolean leftSide ) {
    	String temp;
    	if ( leftSide )
    		temp = "Left";
    	else
    		temp = "Right";
    	
    	for( AttackPattern x : patternList ) {
			if ( x.getAttackName().equals(attackName) )
				return x.actionPerform( player, index, temp );
		}
		return false;
    }
}