/**
 * EffectsParent.java
 * Description: This class preloads all images at the start of the game.
 * 		It contains a library of images stored in arrays.
 *
 * author 
 * version 1.00 2014/1/12
 */

import java.io.IOException;

public class EffectsParent extends SuperObject {
	public static Animation AllEffects = new Animation();
	public static Animation[] AllCharacters = {null,new Animation(),new Animation()};
	private String sprite_path = System.getProperty("user.dir") + "\\Effects\\";
	private String sprite_path2 = System.getProperty("user.dir") + "\\Player1\\";
	private String sprite_path3 = System.getProperty("user.dir") + "\\Player2\\";
	
	public EffectsParent() {

    	// Preload all animation effects
    	try {
    		
    		/////////////////// Special Effects ///////////////////
    		AllEffects.addMoveSet("SpecialFreeze1Left");
			AllEffects.addImageFrame("SpecialFreeze1Left", super.getImageFile(sprite_path+"player1Freeze.png"), 0, 0);
    		AllEffects.addMoveSet("SpecialFreeze1Right");
			AllEffects.addImageFrame("SpecialFreeze1Right", super.getFlippedImage(super.getImageFile(sprite_path+"player1Freeze.png")), 0, 0);

			
    		AllEffects.addMoveSet("SpecialFreeze2Left");
			AllEffects.addImageFrame("SpecialFreeze2Left", super.getImageFile(sprite_path+"player2Freeze.png"), 0, 0);
    		AllEffects.addMoveSet("SpecialFreeze2Right");
			AllEffects.addImageFrame("SpecialFreeze2Right", super.getFlippedImage(super.getImageFile(sprite_path+"player2Freeze.png")), 0, 0);
    		
			
    		AllEffects.addMoveSet("FlashJumpLeft");
			AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_0.png"), 30, 42);
	    	AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_1.png"), 30, 42);
	    	AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_2.png"), 30, 42);
	    	AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_3.png"), 30, 42);
	    	AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_4.png"), 30, 42);
	    	AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_5.png"), 30, 42);
	    	AllEffects.addImageFrame("FlashJumpLeft", super.getImageFile(sprite_path+"flashJump_6.png"), 30, 42);
			
			
    		AllEffects.addMoveSet("FlashJumpRight");
			AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_0.png")), 65, 42);
	    	AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_1.png")), 65, 42);
	    	AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_2.png")), 65, 42);
	    	AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_3.png")), 65, 42);
	    	AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_4.png")), 65, 42);
	    	AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_5.png")), 65, 42);
	    	AllEffects.addImageFrame("FlashJumpRight", super.getFlippedImage(super.getImageFile(sprite_path+"flashJump_6.png")), 65, 42);
	    	
	    	
	    	AllEffects.addMoveSet("OStab1Left"); //35 Centre
			AllEffects.addImageFrame("OStab1Left", super.getImageFile(sprite_path+"16stabO1.png"), 80, -26);
	    	AllEffects.addMoveSet("OStab1Right");
			AllEffects.addImageFrame("OStab1Right", super.getFlippedImage(super.getImageFile(sprite_path+"16stabO1.png")), -10, -26);
	    	
			
	    	AllEffects.addMoveSet("OAttack1Left"); //28 Centre
			AllEffects.addImageFrame("OAttack1Left", super.getImageFile(sprite_path+"16swingO1.png"), 88, 10);
	    	AllEffects.addMoveSet("OAttack1Right");
			AllEffects.addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path+"16swingO1.png")), -32, 10);
			
			
	    	AllEffects.addMoveSet("OAttack2Left"); //31 Centre
			AllEffects.addImageFrame("OAttack2Left", super.getImageFile(sprite_path+"16swingO2.png"), 62, 6);
	    	AllEffects.addMoveSet("OAttack2Right");
			AllEffects.addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path+"16swingO2.png")), 0, 6);
			
			
	    	AllEffects.addMoveSet("OAttack3Left"); //34 Centre
			AllEffects.addImageFrame("OAttack3Left", super.getImageFile(sprite_path+"16swingO3.png"), 74, -8);
	    	AllEffects.addMoveSet("OAttack3Right");
			AllEffects.addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path+"16swingO3.png")), -6, -8);
			

	    	AllEffects.addMoveSet("OAttackFLeft"); //57 Centre
			AllEffects.addImageFrame("OAttackFLeft", super.getImageFile(sprite_path+"16swingOF.png"), 102, -19);
	    	AllEffects.addMoveSet("OAttackFRight");
			AllEffects.addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path+"16swingOF.png")), 12, -19);
	    	
			
			AllEffects.addMoveSet("Hit0");
			AllEffects.addImageFrame("Hit0", super.getImageFile(sprite_path+"20hit0_0.png"), 31, 23);
			AllEffects.addImageFrame("Hit0", super.getImageFile(sprite_path+"20hit0_1.png"), 31, 23);
			AllEffects.addImageFrame("Hit0", super.getImageFile(sprite_path+"20hit0_2.png"), 31, 23);
			AllEffects.addImageFrame("Hit0", super.getImageFile(sprite_path+"20hit0_3.png"), 31, 23);
			
			AllEffects.addMoveSet("Hit1");
			AllEffects.addImageFrame("Hit1", super.getImageFile(sprite_path+"20hit1_0.png"), 36, 18);
			AllEffects.addImageFrame("Hit1", super.getImageFile(sprite_path+"20hit1_1.png"), 36, 18);
			AllEffects.addImageFrame("Hit1", super.getImageFile(sprite_path+"20hit1_2.png"), 36, 18);
			AllEffects.addImageFrame("Hit1", super.getImageFile(sprite_path+"20hit1_3.png"), 36, 18);

			AllEffects.addMoveSet("Hit2");
			AllEffects.addImageFrame("Hit2", super.getImageFile(sprite_path+"20hit2_0.png"), 63, 14);
			AllEffects.addImageFrame("Hit2", super.getImageFile(sprite_path+"20hit2_1.png"), 63, 14);
			AllEffects.addImageFrame("Hit2", super.getImageFile(sprite_path+"20hit2_2.png"), 63, 14);
			AllEffects.addImageFrame("Hit2", super.getImageFile(sprite_path+"20hit2_3.png"), 63, 14);
			
			
			/////////////////// Character Sprites ///////////////////
			// Player1
			AllCharacters[1].addMoveSet("WalkLeft");
			AllCharacters[1].addImageFrame("WalkLeft", super.getImageFile(sprite_path2+"walk1_0.png"), 35, 14);
			AllCharacters[1].addImageFrame("WalkLeft", super.getImageFile(sprite_path2+"walk1_1.png"), 35, 14);
			AllCharacters[1].addImageFrame("WalkLeft", super.getImageFile(sprite_path2+"walk1_2.png"), 35, 14);
			AllCharacters[1].addImageFrame("WalkLeft", super.getImageFile(sprite_path2+"walk1_3.png"), 35, 14);
			AllCharacters[1].addMoveSet("WalkRight");
			AllCharacters[1].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path2+"walk1_0.png")), 17, 14);
			AllCharacters[1].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path2+"walk1_1.png")), 17, 14);
			AllCharacters[1].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path2+"walk1_2.png")), 17, 14);
			AllCharacters[1].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path2+"walk1_3.png")), 17, 14);
			
			AllCharacters[1].addMoveSet("StandLeft");
			AllCharacters[1].addImageFrame("StandLeft", super.getImageFile(sprite_path2+"stand1_0.png"), 36, 14);
			AllCharacters[1].addImageFrame("StandLeft", super.getImageFile(sprite_path2+"stand1_1.png"), 36, 14);
			AllCharacters[1].addImageFrame("StandLeft", super.getImageFile(sprite_path2+"stand1_2.png"), 36, 14);
			AllCharacters[1].addImageFrame("StandLeft", super.getImageFile(sprite_path2+"stand1_3.png"), 36, 14);
			AllCharacters[1].addImageFrame("StandLeft", super.getImageFile(sprite_path2+"stand1_4.png"), 36, 14);
			AllCharacters[1].addMoveSet("StandRight");
			AllCharacters[1].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path2+"stand1_0.png")), 10, 14);
			AllCharacters[1].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path2+"stand1_1.png")), 10, 14);
			AllCharacters[1].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path2+"stand1_2.png")), 10, 14);
			AllCharacters[1].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path2+"stand1_3.png")), 10, 14);
			AllCharacters[1].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path2+"stand1_4.png")), 10, 14);

			AllCharacters[1].addMoveSet("AlertLeft");
			AllCharacters[1].addImageFrame("AlertLeft", super.getImageFile(sprite_path2+"alert_0.png"), 27, 14);
			AllCharacters[1].addMoveSet("AlertRight");
			AllCharacters[1].addImageFrame("AlertRight", super.getFlippedImage(super.getImageFile(sprite_path2+"alert_0.png")), 14, 14);
			
			AllCharacters[1].addMoveSet("JumpLeft");
			AllCharacters[1].addImageFrame("JumpLeft", super.getImageFile(sprite_path2+"jump_0.png"), 27, 14);
			AllCharacters[1].addMoveSet("JumpRight");
			AllCharacters[1].addImageFrame("JumpRight", super.getFlippedImage(super.getImageFile(sprite_path2+"jump_0.png")), 17, 14);

			AllCharacters[1].addMoveSet("OStab1Left");
			AllCharacters[1].addImageFrame("OStab1Left", super.getImageFile(sprite_path2+"stabO1_0.png"), 60, 12);
			AllCharacters[1].addImageFrame("OStab1Left", super.getImageFile(sprite_path2+"stabO1_1.png"), 60, 12);
			AllCharacters[1].addMoveSet("OStab1Right");
			AllCharacters[1].addImageFrame("OStab1Right", super.getFlippedImage(super.getImageFile(sprite_path2+"stabO1_0.png")), 19, 12);
			AllCharacters[1].addImageFrame("OStab1Right", super.getFlippedImage(super.getImageFile(sprite_path2+"stabO1_1.png")), 19, 12);
			
			AllCharacters[1].addMoveSet("OAttack1Left");
			AllCharacters[1].addImageFrame("OAttack1Left", super.getImageFile(sprite_path2+"swingO1_0.png"), 60, 12);
			AllCharacters[1].addImageFrame("OAttack1Left", super.getImageFile(sprite_path2+"swingO1_1.png"), 60, 12);
			AllCharacters[1].addImageFrame("OAttack1Left", super.getImageFile(sprite_path2+"swingO1_2.png"), 60, 12);
			AllCharacters[1].addMoveSet("OAttack1Right");
			AllCharacters[1].addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO1_0.png")), 19, 12);
			AllCharacters[1].addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO1_1.png")), 19, 12);
			AllCharacters[1].addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO1_2.png")), 19, 12);
			
			AllCharacters[1].addMoveSet("OAttack2Left");
			AllCharacters[1].addImageFrame("OAttack2Left", super.getImageFile(sprite_path2+"swingO2_0.png"), 30, 14);
			AllCharacters[1].addImageFrame("OAttack2Left", super.getImageFile(sprite_path2+"swingO2_1.png"), 30, 14);
			AllCharacters[1].addImageFrame("OAttack2Left", super.getImageFile(sprite_path2+"swingO2_2.png"), 30, 14);
			AllCharacters[1].addMoveSet("OAttack2Right");
			AllCharacters[1].addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO2_0.png")), 14, 14);
			AllCharacters[1].addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO2_1.png")), 14, 14);
			AllCharacters[1].addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO2_2.png")), 14, 14);
			
			AllCharacters[1].addMoveSet("OAttack3Left");
			AllCharacters[1].addImageFrame("OAttack3Left", super.getImageFile(sprite_path2+"swingO3_0.png"), 60, 9);
			AllCharacters[1].addImageFrame("OAttack3Left", super.getImageFile(sprite_path2+"swingO3_1.png"), 60, 9);
			AllCharacters[1].addImageFrame("OAttack3Left", super.getImageFile(sprite_path2+"swingO3_2.png"), 60, 9);
			AllCharacters[1].addMoveSet("OAttack3Right");
			AllCharacters[1].addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO3_0.png")), 16, 9);
			AllCharacters[1].addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO3_1.png")), 16, 9);
			AllCharacters[1].addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path2+"swingO3_2.png")), 16, 9);
			
			AllCharacters[1].addMoveSet("OAttackFLeft");
			AllCharacters[1].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path2+"swingOF_0.png"), 65, 26);
			AllCharacters[1].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path2+"swingOF_1.png"), 65, 26);
			AllCharacters[1].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path2+"swingOF_2.png"), 65, 26);
			AllCharacters[1].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path2+"swingOF_3.png"), 65, 26);
			AllCharacters[1].addMoveSet("OAttackFRight");
			AllCharacters[1].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingOF_0.png")), 20, 26);
			AllCharacters[1].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingOF_1.png")), 20, 26);
			AllCharacters[1].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingOF_2.png")), 20, 26);
			AllCharacters[1].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingOF_3.png")), 20, 26);
			
			AllCharacters[1].addMoveSet("OAttackPLeft");
			AllCharacters[1].addImageFrame("OAttackPLeft", super.getImageFile(sprite_path2+"swingPF_0.png"), 10, 12);
			AllCharacters[1].addImageFrame("OAttackPLeft", super.getImageFile(sprite_path2+"swingPF_1.png"), 10, 12);
			AllCharacters[1].addImageFrame("OAttackPLeft", super.getImageFile(sprite_path2+"swingPF_2.png"), 10, 12);
			AllCharacters[1].addImageFrame("OAttackPLeft", super.getImageFile(sprite_path2+"swingPF_3.png"), 10, 12);
			AllCharacters[1].addMoveSet("OAttackPRight");
			AllCharacters[1].addImageFrame("OAttackPRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingPF_0.png")), 10, 12);
			AllCharacters[1].addImageFrame("OAttackPRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingPF_1.png")), 10, 12);
			AllCharacters[1].addImageFrame("OAttackPRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingPF_2.png")), 10, 12);
			AllCharacters[1].addImageFrame("OAttackPRight", super.getFlippedImage(super.getImageFile(sprite_path2+"swingPF_3.png")), 10, 12);
			

			// Player2
			AllCharacters[2].addMoveSet("WalkLeft");
			AllCharacters[2].addImageFrame("WalkLeft", super.getImageFile(sprite_path3+"walk1_0.png"), 27, 14);
			AllCharacters[2].addImageFrame("WalkLeft", super.getImageFile(sprite_path3+"walk1_1.png"), 27, 14);
			AllCharacters[2].addImageFrame("WalkLeft", super.getImageFile(sprite_path3+"walk1_2.png"), 27, 14);
			AllCharacters[2].addImageFrame("WalkLeft", super.getImageFile(sprite_path3+"walk1_3.png"), 27, 14);
			AllCharacters[2].addMoveSet("WalkRight");
			AllCharacters[2].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path3+"walk1_0.png")), 17, 14);
			AllCharacters[2].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path3+"walk1_1.png")), 17, 14);
			AllCharacters[2].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path3+"walk1_2.png")), 17, 14);
			AllCharacters[2].addImageFrame("WalkRight", super.getFlippedImage(super.getImageFile(sprite_path3+"walk1_3.png")), 17, 14);
			
			AllCharacters[2].addMoveSet("StandLeft");
			AllCharacters[2].addImageFrame("StandLeft", super.getImageFile(sprite_path3+"stand1_0.png"), 18, 14);
			AllCharacters[2].addImageFrame("StandLeft", super.getImageFile(sprite_path3+"stand1_1.png"), 18, 14);
			AllCharacters[2].addImageFrame("StandLeft", super.getImageFile(sprite_path3+"stand1_2.png"), 18, 14);
			AllCharacters[2].addImageFrame("StandLeft", super.getImageFile(sprite_path3+"stand1_3.png"), 18, 14);
			AllCharacters[2].addImageFrame("StandLeft", super.getImageFile(sprite_path3+"stand1_4.png"), 18, 14);
			AllCharacters[2].addMoveSet("StandRight");
			AllCharacters[2].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path3+"stand1_0.png")), 15, 14);
			AllCharacters[2].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path3+"stand1_1.png")), 15, 14);
			AllCharacters[2].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path3+"stand1_2.png")), 15, 14);
			AllCharacters[2].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path3+"stand1_3.png")), 15, 14);
			AllCharacters[2].addImageFrame("StandRight", super.getFlippedImage(super.getImageFile(sprite_path3+"stand1_4.png")), 15, 14);

			AllCharacters[2].addMoveSet("AlertLeft");
			AllCharacters[2].addImageFrame("AlertLeft", super.getImageFile(sprite_path3+"alert_0.png"), 27, 14);
			AllCharacters[2].addMoveSet("AlertRight");
			AllCharacters[2].addImageFrame("AlertRight", super.getFlippedImage(super.getImageFile(sprite_path3+"alert_0.png")), 19, 14);
			
			AllCharacters[2].addMoveSet("JumpLeft");
			AllCharacters[2].addImageFrame("JumpLeft", super.getImageFile(sprite_path3+"jump_0.png"), 3, 14);
			AllCharacters[2].addMoveSet("JumpRight");
			AllCharacters[2].addImageFrame("JumpRight", super.getFlippedImage(super.getImageFile(sprite_path3+"jump_0.png")), 21, 14);

			AllCharacters[2].addMoveSet("OStab1Left");
			AllCharacters[2].addImageFrame("OStab1Left", super.getImageFile(sprite_path3+"stabO1_0.png"), 60, 12);
			AllCharacters[2].addImageFrame("OStab1Left", super.getImageFile(sprite_path3+"stabO1_1.png"), 60, 12);
			AllCharacters[2].addMoveSet("OStab1Right");
			AllCharacters[2].addImageFrame("OStab1Right", super.getFlippedImage(super.getImageFile(sprite_path3+"stabO1_0.png")), 19, 12);
			AllCharacters[2].addImageFrame("OStab1Right", super.getFlippedImage(super.getImageFile(sprite_path3+"stabO1_1.png")), 19, 12);
			
			AllCharacters[2].addMoveSet("OAttack1Left");
			AllCharacters[2].addImageFrame("OAttack1Left", super.getImageFile(sprite_path3+"swingO1_0.png"), 41, 12);
			AllCharacters[2].addImageFrame("OAttack1Left", super.getImageFile(sprite_path3+"swingO1_1.png"), 41, 12);
			AllCharacters[2].addImageFrame("OAttack1Left", super.getImageFile(sprite_path3+"swingO1_2.png"), 41, 12);
			AllCharacters[2].addMoveSet("OAttack1Right");
			AllCharacters[2].addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO1_0.png")), 19, 12);
			AllCharacters[2].addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO1_1.png")), 19, 12);
			AllCharacters[2].addImageFrame("OAttack1Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO1_2.png")), 19, 12);
			
			AllCharacters[2].addMoveSet("OAttack2Left");
			AllCharacters[2].addImageFrame("OAttack2Left", super.getImageFile(sprite_path3+"swingO2_0.png"), 20, 14);
			AllCharacters[2].addImageFrame("OAttack2Left", super.getImageFile(sprite_path3+"swingO2_1.png"), 20, 14);
			AllCharacters[2].addImageFrame("OAttack2Left", super.getImageFile(sprite_path3+"swingO2_2.png"), 20, 14);
			AllCharacters[2].addMoveSet("OAttack2Right");
			AllCharacters[2].addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO2_0.png")), 14, 14);
			AllCharacters[2].addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO2_1.png")), 14, 14);
			AllCharacters[2].addImageFrame("OAttack2Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO2_2.png")), 14, 14);
			
			AllCharacters[2].addMoveSet("OAttack3Left");
			AllCharacters[2].addImageFrame("OAttack3Left", super.getImageFile(sprite_path3+"swingO3_0.png"), 60, 9);
			AllCharacters[2].addImageFrame("OAttack3Left", super.getImageFile(sprite_path3+"swingO3_1.png"), 60, 9);
			AllCharacters[2].addImageFrame("OAttack3Left", super.getImageFile(sprite_path3+"swingO3_2.png"), 60, 9);
			AllCharacters[2].addMoveSet("OAttack3Right");
			AllCharacters[2].addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO3_0.png")), 16, 9);
			AllCharacters[2].addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO3_1.png")), 16, 9);
			AllCharacters[2].addImageFrame("OAttack3Right", super.getFlippedImage(super.getImageFile(sprite_path3+"swingO3_2.png")), 16, 9);
			
			AllCharacters[2].addMoveSet("OAttackFLeft");
			AllCharacters[2].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path3+"swingOF_0.png"), 45, 26);
			AllCharacters[2].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path3+"swingOF_1.png"), 45, 26);
			AllCharacters[2].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path3+"swingOF_2.png"), 45, 26);
			AllCharacters[2].addImageFrame("OAttackFLeft", super.getImageFile(sprite_path3+"swingOF_3.png"), 45, 26);
			AllCharacters[2].addMoveSet("OAttackFRight");
			AllCharacters[2].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path3+"swingOF_0.png")), 20, 26);
			AllCharacters[2].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path3+"swingOF_1.png")), 20, 26);
			AllCharacters[2].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path3+"swingOF_2.png")), 20, 26);
			AllCharacters[2].addImageFrame("OAttackFRight", super.getFlippedImage(super.getImageFile(sprite_path3+"swingOF_3.png")), 20, 26);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
