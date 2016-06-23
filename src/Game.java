import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Game{
	private int HP = 10;
	private int SP = 1;
	private int DEF = 0;
	private int AC = 0;
	private int ATK = 0;
	private int SPD = 1;
	private int tHP = HP;
	private int tSP = SP;
	private int tATK = ATK;
	private int tDEF = DEF;
	private boolean nutritiousWater = false;
	private boolean scorch = false;
	private boolean vineShield = false;
	private boolean cure = false;
	private boolean flare = false;
	private boolean vineTrap = false;
	private int XP;
	private int XPG = 10;
	private int XPR = 10;
	private int XPI = 20;
	private int LVUP;
	private int LV = 1;
	private int G = 0;
	private boolean gems = false;
	private int POW;
	private int gPOW;
	private int bPOW;
	private int mPOW;
	private int ST;
	private int yST;
	private int BT;
	private int yPT;
	private boolean Skip = false;
	private int eHP;
	private int eMAXHP = eHP;
	private int eDEF;
	private int eSPD;
	private int eXP;
	private int eG;
	private String Earmor = "Nothing";
	private String Egloves = "Nothing";
	private String Eboots = "Nothing";
	private String Ehelm = "Nothing";
	private int LHPp;
	private int LSPp;
	private int HPp;
	private int SPp;
	private int LMPp;
	private int GHPp;
	private int GSPp;
	private int GMPp;
	private int b;
	private boolean crown = false;
	private ArrayList<String> helm = new ArrayList<String>();
	private ArrayList<String> gloves = new ArrayList<String>();
	private ArrayList<String> armor = new ArrayList<String>();
	private ArrayList<String> boots = new ArrayList<String>();
	private int loc = 1;
	private String output = "";
	private static final Game GAME = new Game();
	
	public static void main(String args[]){
		try {
			GAME.play();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getLocalizedMessage());
		}
	}
	
	private void play() throws FileNotFoundException{
		String choice = JOptionPane.showInputDialog("Would you like to load a saved game? (y/n)");
		if (choice.equalsIgnoreCase("y")){
			load();
		}
		if (loc == 1){
			helm.add("Nothing");
			gloves.add("Nothing");
			armor.add("Nothing");
			boots.add("Nothing");
			JOptionPane.showMessageDialog(null, "World 1-1");
			JOptionPane.showMessageDialog(null, "World 1 boss: Goblin");
			b = 1;
			battle("goblin");
			JOptionPane.showMessageDialog(null, "The goblin dropped an ability gem!");
			gemShop(1);
		}
		if (loc == 2){
			shop(1);
			JOptionPane.showMessageDialog(null, "World 2-1");
			b = 2;
			encounter(1);
			encounter(2);
			shop(2);
			JOptionPane.showMessageDialog(null, "World 2-2");
			b = 2;
			encounter(2);
			JOptionPane.showMessageDialog(null, "World 2 boss: Elite Goblin");
			battle("elite goblin");
			JOptionPane.showMessageDialog(null, "The elite goblin dropped an ability gem!");
			gemShop(1);
		}
		if (loc == 3){
			shop(2);
			JOptionPane.showMessageDialog(null, "World 3-1");
			b = 3;
			encounter(3);
			encounter(3);
			encounter(3);
			shop(3);
			JOptionPane.showMessageDialog(null, "World 3-2");
			b = 3;
			encounter(4);
			encounter(4);
			encounter(4);
			shop(3);
			JOptionPane.showMessageDialog(null, "World 3-3");
			b = 3;
			encounter(4);
			encounter(4);
			JOptionPane.showMessageDialog(null, "World 3 boss: Ogre");
			battle("ogre");
			JOptionPane.showMessageDialog(null, "The ogre dropped an ability gem!");
			gemShop(2);
		}
		if (loc == 4){
			shop(3);
			JOptionPane.showMessageDialog(null, "World 4-1");
			b = 4;
			encounter(6);
			encounter(6);
			encounter(5);
			encounter(5);
			shop(4);
			JOptionPane.showMessageDialog(null, "World 4-2");
			b = 4;
			encounter(6);
			encounter(5);
			encounter(5);
			encounter(5);
			shop(4);
			JOptionPane.showMessageDialog(null, "World 4-3");
			b = 4;
			encounter(7);
			encounter(7);
			encounter(7);
			encounter(7);
			shop(4);
			JOptionPane.showMessageDialog(null, "World 4-4");
			b = 4;
			encounter(7);
			encounter(7);
			encounter(7);
			JOptionPane.showMessageDialog(null, "World 4 boss: Elite Ogre");
			battle("elite ogre");
			JOptionPane.showMessageDialog(null, "The elite ogre dropped an ability gem!");
			gemShop(2);
		}
		if(loc == 5){
			shop(4);
			JOptionPane.showMessageDialog(null, "World 5-1");
			b = 5;
			encounter(7);
			encounter(8);
			encounter(8);
			encounter(8);
			encounter(8);
			shop(5);
			JOptionPane.showMessageDialog(null, "World 5-2");
			b = 5;
			encounter(8);
			encounter(9);
			encounter(9);
			encounter(9);
			encounter(9);
			shop(5);
			JOptionPane.showMessageDialog(null, "World 5-3");
			b = 5;
			encounter(9);
			encounter(10);
			encounter(10);
			encounter(10);
			encounter(10);
			shop(5);
			JOptionPane.showMessageDialog(null, "World 5-4");
			b = 5;
			encounter(10);
			encounter(11);
			encounter(11);
			encounter(11);
			encounter(11);
			shop(5);
			JOptionPane.showMessageDialog(null, "World 5-5");
			b = 5;
			encounter(11);
			encounter(12);
			encounter(12);
			encounter(12);
			JOptionPane.showMessageDialog(null, "World 4 boss: Ogre Warlord");
			battle("ogre warlord");
			JOptionPane.showMessageDialog(null, "You win!");
		}
	}
	private void encounter(int d) throws FileNotFoundException{
		double r = Math.random() * 10;
		switch (d){
		case 1:
			if(r < 6){
				battle("green slime");
			}else{
				battle("goblin");
			}
			break;
		case 2:
			if(r < 3){
				battle("goblin");
			}else{
				battle("squid");
			}
			break;
		case 3:
			if(r < 1){
				battle("squid");
			}else if(r < 3){
				battle("yellow slime");
			}else if(r < 8){
				battle("spider");
			}else{
				battle("snake");
			}
			break;
		case 4:
			if(r < 3){
				battle("snake");
			}else{
				battle("elite goblin");
			}
			break;
		case 5:
			if(r < 2){
				battle("cobra");
			}else if(r < 7){
				battle("red slime");
			}else{
				battle("ogre");
			}
			break;
		case 6:
			if(r < 3){
				battle("cobra");
			}else if(r < 7){
				battle("wolf spider");
			}else{
				battle("octopus");
			}
			break;
		case 7:
			if(r < 1){
				battle("red slime");
			}else if(r < 3){
				battle("cobra");
			}else{
				battle("goblin warlord");
			}
			break;
		case 8:
			if(r < 1){
				battle("goblin warlord");
			}else if(r < 4){
				battle("kraken");
			}else{
				battle("elite ogre");
			}
			break;
		case 9:
			if(r < 1){
				battle("goblin warlord");
			}else if(r < 3){
				battle("elite ogre");
			}else{
				battle("kraken");
			}
			break;
		case 10:
			if(r < 3){
				battle("tarantula");
			}else{
				battle("kraken");
			}
			break;
		case 11:
			if(r < 3){
				battle("kraken");
			}else{
				battle("tarantula");
			}
			break;
		case 12:
			if(r < 3){
				battle("python");
			}else{
				battle("tarantula");
			}
			break;
		}
		if(b > 0){
			menu();
		}
	}
	private void battle(String eNAME){
		switch (eNAME){
		case "green slime":
			eHP = 5;
			eDEF = 0;
			eSPD = 1;
			eXP = 2;
			eG = 2;
			break;
		case "yellow slime":
			eHP = 10;
			eDEF = 0;
			eSPD = 2;
			eXP = 4;
			eG = 4;
			break;
		case "red slime":
			eHP = 25;
			eDEF = 0;
			eSPD = 5;
			eXP = 10;
			eG = 10;
			break;
		case "goblin":
			eHP = 10;
			eDEF = 0;
			eSPD = 1;
			eXP = 4;
			eG = 4;
			break;
		case "elite goblin":
			eHP = 20;
			eDEF = 0;
			eSPD = 2;
			eXP = 8;
			eG = 8;
			break;
		case "goblin warlord":
			eHP = 50;
			eDEF = 0;
			eSPD = 5;
			eXP = 20;
			eG = 20;
			break;
		case "squid":
			eHP = 7;
			eDEF = 0;
			eSPD = 1;
			eXP = 4;
			eG = 5;
			break;
		case "octopus":
			eHP = 14;
			eDEF = 0;
			eSPD = 2;
			eXP = 8;
			eG = 10;
			break;
		case "kraken":
			eHP = 35;
			eDEF = 0;
			eSPD = 5;
			eXP = 20;
			eG = 20;
			break;
		case "spider":
			eHP = 9;
			eDEF = 0;
			eSPD = 3;
			eXP = 5;
			eG = 4;
			break;
		case "wolf spider":
			eHP = 18;
			eDEF = 0;
			eSPD = 6;
			eXP = 10;
			eG = 8;
			break;
		case "tarantula":
			eHP = 45;
			eDEF = 0;
			eSPD = 15;
			eXP = 25;
			eG = 20;
			break;
		case "snake":
			eHP = 7;
			eDEF = 1;
			eSPD = 2;
			eXP = 5;
			eG = 4;
			break;
		case "cobra":
			eHP = 14;
			eDEF = 2;
			eSPD = 4;
			eXP = 10;
			eG = 8;
			break;
		case "python":
			eHP = 35;
			eDEF = 5;
			eSPD = 10;
			eXP = 25;
			eG = 20;
			break;
		case "ogre":
			eHP = 25;
			eDEF = 1;
			eSPD = 2;
			eXP = 30;
			eG = 30;
			break;
		case "elite ogre":
			eHP = 50;
			eDEF = 2;
			eSPD = 4;
			eXP = 60;
			eG = 60;
			break;
		case "ogre warlord":
			eHP = 125;
			eDEF = 5;
			eSPD = 10;
			eXP = 150;
			eG = 150;
			break;
		}
		tATK = ATK;
		tDEF = DEF + AC;
		eMAXHP = eHP;
		Skip = false;
		while (true) {
			if (SPD >= eSPD){
				if (yST == 0){
					String choice = JOptionPane.showInputDialog("You have " + tHP + "/" + HP + " HP and " + tSP + "/" + SP + " SP.  The " + eNAME + " has " + eHP + "/" + eMAXHP + " HP and " + eDEF + " DEF.  Press l for a list of actions.");
					if (choice.equals("l")){
						output = "Punch does " + (2 + gPOW + ATK) + " damage (p).\nKick does " + (1 + bPOW + ATK) + " damage and stuns the enemy 50% of the time (k).";
						if (nutritiousWater){
							output += "\nNutritious Water heals " + (5 + mPOW) + " HP and uses 1 SP (nw).";
						}
						if (scorch){
							output += "\nScorch does " + (3 + mPOW + ATK) + " damage and burns the enemy for 2 turns " + (50 + mPOW * 10) + "% of the time and uses 1 SP (s).";
						}
						if (vineShield){
							output += "\nVine Shield increases your defense by 1 for the duration of the battle and uses " + damage(tDEF, 1, mPOW) + " SP. The cost increases with higher defense (vs).";
						}
						if (cure){
							output += "\nCure heals " + (10 + mPOW * 3) + " HP, cures poison, and uses 3 SP (c).";
						}
						if (flare){
							output += "\nFlare burns the enemy for " + (5 + mPOW) + " turns and uses 1 SP (f).";
						}
						if (vineTrap){
							output += "\nVine Trap stuns the enemy for 3 turns, has a " + (50 + mPOW * 10) + "% chance to reduce its defense by 1 for the duration of the battle, and uses 3 SP. (vt).";
						}
						if(LHPp == 1){
							output += "\nYou can use your lesser health potion to heal 5 HP (h1).";
						}
						if(LHPp > 1){
							output += "\nYou can use one of your " + LHPp + " lesser health potions to heal 5 HP (h1).";
						}
						if(LSPp == 1){
							output += "\nYou can use your lesser special potion to heal 1 SP (s1).";
						}
						if(LSPp > 1){
							output += "\nYou can use one of your " + LSPp + " lesser special potions to heal 1 SP (s1).";
						}
						if(HPp == 1){
							output += "\nYou can use your health potion to heal 10 HP (h2).";
						}
						if(HPp > 1){
							output += "\nYou can use one of your " + HPp + " health potions to heal 10 HP (h2).";
						}
						if(SPp == 1){
							output += "\nYou can use your special potion to heal 2 SP (s2).";
						}
						if(SPp > 1){
							output += "\nYou can use one of your " + SPp + " special potions to heal 2 SP (s2).";
						}
						if(LMPp == 1){
							output += "\nYou can use your lesser magic potion to heal 5 HP and 1 SP (m1).";
						}
						if(LMPp > 1){
							output += "\nYou can use one of your " + LMPp + " lesser magic potions to heal 5 HP and 1 SP (m1).";
						}
						if(GHPp == 1){
							output += "\nYou can use your greater health potion to heal 20 HP (h3).";
						}
						if(GHPp > 1){
							output += "\nYou can use one of your " + GHPp + " greater health potions to heal 20 HP (h3).";
						}
						if(GSPp == 1){
							output += "\nYou can use your greater special potion to heal 4 SP (s3).";
						}
						if(GSPp > 1){
							output += "\nYou can use one of your " + GSPp + " greater special potions to heal 4 SP (s3).";
						}
						if(GMPp == 1){
							output += "\nYou can use your greater magic potion to heal 10 HP and 2 SP (m2).";
						}
						if(GMPp > 1){
							output += "\nYou can use one of your " + GMPp + " greater magic potions to heal 10 HP and 2 SP (m2).";
						}
						JOptionPane.showMessageDialog(null, output);
						output = "";
						Skip = true;
					}else if (choice.equals("p")){
						POW = 2 + gPOW;
						JOptionPane.showMessageDialog(null, "The " + eNAME + " took " + damage(POW, tATK, eDEF) + " damage!");
						eHP -= damage(POW, tATK, eDEF);
					}else if (choice.equals("k")) {
						POW = 1 + bPOW;
						JOptionPane.showMessageDialog(null, "The " + eNAME + " took " + damage(POW, tATK, eDEF) + " damage!");
						eHP -= damage(POW, tATK, eDEF);
						if ((Math.random()) * 10 < 5){
							ST++;
							JOptionPane.showMessageDialog(null, "The " + eNAME + " cannot move for " + ST + " turn(s)!");
						}
					}else if (choice.equals ("nw") && nutritiousWater){
						if (tSP > 0){
							if(healHP(5 + mPOW)){
								tSP--;
							}
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							Skip = true;
						}
					}else if (choice.equals ("s") && scorch) {
						if (tSP > 0){
							POW = 3 + mPOW;
							JOptionPane.showMessageDialog(null, "The " + eNAME + " took " + damage(POW, tATK, eDEF) + " damage!");
							eHP -= damage(POW, tATK, eDEF);
							if ((Math.random()) * 100 < 50 + mPOW * 10){
								BT += 2;
								JOptionPane.showMessageDialog(null, "The " + eNAME + " was burned for 2 turns!");
							}
							tSP--;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							Skip = true;
						}
					}else if (choice.equals ("vs") && vineShield) {
						if(tSP + mPOW > tDEF){
							JOptionPane.showMessageDialog(null,"Your defense went up by 1 for the battle!");
							tSP -= damage(tDEF, 1, mPOW);
							tDEF += 1;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							Skip = true;
						}
					}else if (choice.equals ("c") && cure) {
						if (tSP > 2){
							if(healHP(10 + mPOW * 3) || yPT > 0){
								tSP -= 3;
								if(yPT > 0){
									yPT = 0;
									JOptionPane.showMessageDialog(null, "You are no longer poisoned!");
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							Skip = true;
						}
					}else if (choice.equals ("f") && flare) {
						if(tSP > 0){
							JOptionPane.showMessageDialog(null, "The " + eNAME + " was burned for " + (5 + mPOW) + " turns!");
							BT += 5 + mPOW;
							tSP--;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							Skip = true;
						}
					}else if (choice.equals ("vt") && vineTrap) {
						if(tSP > 2){
							ST += 3;
							JOptionPane.showMessageDialog(null, "The " + eNAME + " cannot move for " + ST + " turn(s)!");
							if ((Math.random()) * 100 < 50 + mPOW * 10){
								eDEF--;
								JOptionPane.showMessageDialog(null, "The " + eNAME + "'s defense went down by one for the battle!");
							}
							tSP -= 3;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							Skip = true;
						}
					}else if (choice.equals ("h1") && LHPp > 0) {
						if (healHP(5)) {
							LHPp--;
						}
					}else if (choice.equals ("s1") && LSPp > 0) {
						if (healSP(1)) {
							LSPp--;
						}
					}else if (choice.equals ("h2") && HPp > 0) {
						if (healHP(10)) {
							HPp--;
						}
					}else if (choice.equals ("s2") && SPp > 0) {
						if (healSP(2)) {
							SPp--;
						}
					}else if (choice.equals ("m1") && LMPp > 0) {
						if (heal(1)) {
							LMPp--;
						}
					}else if (choice.equals ("h3") && GHPp > 0) {
						if (healHP(20)) {
							GHPp--;
						}
					}else if (choice.equals ("s3") && GSPp > 0) {
						if (healSP(4)) {
							GSPp--;
						}
					}else if (choice.equals ("m2") && GMPp > 0) {
						if (heal(2)) {
							GMPp--;
						}
					}else{
						Skip = true;
					}
					if (eHP <= 0){
						XP(eNAME);
						break;
					}
				}
			}
			eSPD = 0;
			if(!Skip){
				if (yST > 0){
					yST--;
					if (yST > 0) {
						JOptionPane.showMessageDialog(null, "You still can't move...");
					}else{
						JOptionPane.showMessageDialog(null, "You can move again!");
					}
				}
				if (yPT > 0){
					yPT--;
					JOptionPane.showMessageDialog(null, "You took 1 poison damage!");
					tHP--;
					if (yPT > 0) {
						JOptionPane.showMessageDialog(null, "You are still poisoned...");
					}else{
						JOptionPane.showMessageDialog(null, "You are no longer poisoned!");
					}
				}
			}
			if (tHP <= 0){
				JOptionPane.showMessageDialog(null, "You lost...");
				System.exit(0);
			}
			if (!Skip) {
				if (ST == 0){
					switch (eNAME){
					case "green slime":
						POW = 1;
						JOptionPane.showMessageDialog(null, "The green slime ran into you for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "yellow slime":
						POW = 2;
						JOptionPane.showMessageDialog(null, "The yellow slime ran into you for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "red slime":
						POW = 5;
						JOptionPane.showMessageDialog(null, "The red slime ran into you for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "goblin":
						POW = 1;
						JOptionPane.showMessageDialog(null, "The goblin smacked you for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "elite goblin":
						POW = 2;
						JOptionPane.showMessageDialog(null, "The elite goblin smacked you for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "goblin warlord":
						POW = 5;
						JOptionPane.showMessageDialog(null, "The goblin warlord smacked you for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "squid":
						if (damage(3, tATK, eDEF) > eHP && !(damage(3, 0, DEF) > HP) && tDEF < 1) {
							POW = 1;
							JOptionPane.showMessageDialog(null, "The squid shot ink at you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
							if ((Math.random()) * 10 < 3){
								yST++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + yST + " turn(s)!");
							}
						}else{
							POW = 2;
							JOptionPane.showMessageDialog(null, "The squid slapped you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "octopus":
						if (damage(3, tATK, eDEF) > eHP && !(damage(5, 0, DEF) > HP) && tDEF < 2) {
							POW = 2;
							JOptionPane.showMessageDialog(null, "The octopus shot ink at you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
							if ((Math.random()) * 10 <= 3){
								yST++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + yST + " turn(s)!");
							}
						}else{
							POW = 4;
							JOptionPane.showMessageDialog(null, "The octopus slapped you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "kraken":
						if (damage(3, tATK, eDEF) > eHP && !(damage(11, 0, DEF) > HP) && tDEF < 5) {
							POW = 5;
							JOptionPane.showMessageDialog(null, "The kraken shot ink at you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
							if ((Math.random()) * 10 <= 3){
								yST++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + yST + " turn(s)!");
							}
						}else{
							POW = 10;
							JOptionPane.showMessageDialog(null, "The kraken slapped you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "spider":
						if (damage(3, tATK, eDEF) > eHP && !(damage(3, 0, DEF) > HP) && tDEF < 1) {
							POW = 1;
							JOptionPane.showMessageDialog(null, "The spider shot a web at you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
							if ((Math.random()) * 10 < 4){
								yST++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + yST + " turn(s)!");
							}
						}else{
							POW = 2;
							JOptionPane.showMessageDialog(null, "The spider bit you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "wolf spider":
						if (damage(3, tATK, eDEF) > eHP && !(damage(5, 0, DEF) > HP) && tDEF < 2) {
							POW = 2;
							JOptionPane.showMessageDialog(null, "The wolf spider shot a web at you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
							if ((Math.random()) * 10 < 4){
								yST++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + yST + " turn(s)!");
							}
						}else{
							POW = 4;
							JOptionPane.showMessageDialog(null, "The wolf spider bit you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "tarantula":
						if (damage(3, tATK, eDEF) > eHP && !(damage(11, 0, DEF) > HP) && tDEF < 5) {
							POW = 5;
							JOptionPane.showMessageDialog(null, "The tarantula shot a web at you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
							if ((Math.random()) * 10 < 4){
								yST++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + yST + " turn(s)!");
							}
						}else{
							POW = 10;
							JOptionPane.showMessageDialog(null, "The tarantula bit you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "snake":
						if (damage(3, tATK, eDEF) > eHP || damage(3, 0, DEF) > HP) {
							POW = 2;
							JOptionPane.showMessageDialog(null, "The snake bit you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}else{
							POW = 1;
							JOptionPane.showMessageDialog(null, "The snake spat venom at you for " + damage(POW, 0, tDEF) + " damage! You were also poisoned for 2 turns.");
							yPT += 2;
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "cobra":
						if (damage(3, tATK, eDEF) > eHP || damage(5, 0, DEF) > HP) {
							POW = 4;
							JOptionPane.showMessageDialog(null, "The cobra bit you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}else{
							POW = 2;
							JOptionPane.showMessageDialog(null, "The cobra spat venom at you for " + damage(POW, 0, tDEF) + " damage! You were also poisoned for 2 turns.");
							yPT += 4;
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "python":
						if (damage(3, tATK, eDEF) > eHP || damage(11, 0, DEF) > HP) {
							POW = 10;
							JOptionPane.showMessageDialog(null, "The python bit you for " + damage(POW, 0, tDEF) + " damage!");
							tHP -= damage(POW, 0, tDEF);
						}else{
							POW = 5;
							JOptionPane.showMessageDialog(null, "The python spat venom at you for " + damage(POW, 0, tDEF) + " damage! You were also poisoned for 2 turns.");
							yPT += 4;
							tHP -= damage(POW, 0, tDEF);
						}
						break;
					case "ogre":
						POW = 3;
						JOptionPane.showMessageDialog(null, "The ogre hits you with its club for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "elite ogre":
						POW = 6;
						JOptionPane.showMessageDialog(null, "The elite ogre hits you with its club for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					case "ogre warlord":
						POW = 15;
						JOptionPane.showMessageDialog(null, "The ogre warlord hits you with its club for " + damage(POW, 0, tDEF) + " damage!");
						tHP -= damage(POW, 0, tDEF);
						break;
					}
					if (tHP <= 0){
						JOptionPane.showMessageDialog(null, "You lost...");
						System.exit(0);
					}
				}else{
					if (ST > 1) {
						JOptionPane.showMessageDialog(null, "The " + eNAME + " still can't move...");
					}else{
						JOptionPane.showMessageDialog(null, "The " + eNAME + " can move again!");
					}
					ST--;
				}
				if (BT > 0){
					JOptionPane.showMessageDialog(null, "The " + eNAME + " took " + (mPOW + 1) + " burn damage!");
					eHP -= mPOW + 1;
					BT--;
					if (BT == 0){
						JOptionPane.showMessageDialog(null, "The " + eNAME + " is no longer burned!");
					}else{
						JOptionPane.showMessageDialog(null, "The " + eNAME + " is still burned!");
					}
				}
				if (eHP <= 0){
					XP(eNAME);
					break;
				}
			}
			Skip = false;
		}
		yPT = 0;
		yST = 0;
		ST = 0;
		BT = 0;
		b--;
	}

	private void shop(int s) throws FileNotFoundException{
		String c;
		tHP = HP;
		tSP = SP;
		while(true){
			output = "You have " + G + " gold.\nWhat would you like to buy?\n";
			switch(s){
			case 1:
				output += "p1. Lesser health potion (5)\np2. Lesser special potion (5)\n1. Exit";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("p1") && G > 4){
					G -= 5;
					LHPp++;
				}else if(c.equals("p2") && G > 4){
					G -= 5;
					LSPp++;
				}else if(c.equals("1")){
					output = "";
					return;
				}else if(c.equals("")){
				}else{
					JOptionPane.showMessageDialog(null, "You can not afford that.");
				}
				break;
			case 2:
				output += "p1. Lesser health potion (5)\np2. Lesser special potion (5)\np3. Health potion (15)\np4. Special potion (15)\np5. Lesser magic potion (15)";
				output += "\n1. Bronze gauntlets (15)\n2. Bronze helm (15)\n3. Exit";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("p1") && G > 4){
					G -= 5;
					LHPp++;
				}else if(c.equals("p2") && G > 4){
					G -= 5;
					LSPp++;
				}else if(c.equals("p3") && G > 14){
					G -= 15;
					HPp++;
				}else if(c.equals("p4") && G > 14){
					G -= 15;
					SPp++;
				}else if(c.equals("p5") && G > 14){
					G -= 15;
					LMPp++;
				}else if(c.equals("1") && G > 14){
					G -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && G > 14){
					G -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3")){
					output = "";
					return;
				}else if(c.equals("")){
				}else{
					JOptionPane.showMessageDialog(null, "You can not afford that.");
				}
				break;
			case 3:
				output += "p1. Lesser health potion (5)\np2. Lesser special potion (5)\np3. Health potion (15)\np4. Special potion (15)\np5. Lesser magic potion (15)";
				output += "\n1. Bronze gauntlets (15)\n2. Bronze helm (15)\n3. Bronze boots (30)\n4. Silver gauntlets (30)\n5. Silver helm (30)\n6. Exit";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("p1") && G > 4){
					G -= 5;
					LHPp++;
				}else if(c.equals("p2") && G > 4){
					G -= 5;
					LSPp++;
				}else if(c.equals("p3") && G > 14){
					G -= 15;
					HPp++;
				}else if(c.equals("p4") && G > 14){
					G -= 15;
					SPp++;
				}else if(c.equals("p5") && G > 14){
					G -= 15;
					LMPp++;
				}else if(c.equals("1") && G > 14){
					G -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && G > 14){
					G -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3") && G > 29){
					G -= 30;
					boots.add("Bronze boots");
				}else if(c.equals("4") && G > 29){
					G -= 30;
					gloves.add("Silver gauntlets");
				}else if(c.equals("5") && G > 29){
					G -= 30;
					helm.add("Silver helm");
				}else if(c.equals("6")){
					output = "";
					return;
				}else if(c.equals("")){
				}else{
					JOptionPane.showMessageDialog(null, "You can not afford that.");
				}
				break;
			case 4:
				output += "p1. Lesser health potion (5)\np2. Lesser special potion (5)\np3. Health potion (15)\np4. Special potion (15)\np5. Lesser magic potion (15)\np6. Greater health potion (45)\np7. Greater special potion (45)\np8. Greater magic potion (45)";
				output += "\n1. Bronze gauntlets (15)\n2. Bronze helm (15)\n3. Bronze boots (30)\n4. Silver gauntlets (30)\n5. Silver helm (30)\n6. Bronze armor (45)\n7. Gold gauntlets (45)\n8. Gold helm (45)\n9. Exit";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("p1") && G > 4){
					G -= 5;
					LHPp++;
				}else if(c.equals("p2") && G > 4){
					G -= 5;
					LSPp++;
				}else if(c.equals("p3") && G > 14){
					G -= 15;
					HPp++;
				}else if(c.equals("p4") && G > 14){
					G -= 15;
					SPp++;
				}else if(c.equals("p5") && G > 14){
					G -= 15;
					LMPp++;
				}else if(c.equals("p6") && G > 44){
					G -= 45;
					GHPp++;
				}else if(c.equals("p7") && G > 44){
					G -= 45;
					GSPp++;
				}else if(c.equals("p8") && G > 44){
					G -= 45;
					GMPp++;
				}else if(c.equals("1") && G > 14){
					G -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && G > 14){
					G -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3") && G > 29){
					G -= 30;
					boots.add("Bronze boots");
				}else if(c.equals("4") && G > 29){
					G -= 30;
					gloves.add("Silver gauntlets");
				}else if(c.equals("5") && G > 29){
					G -= 30;
					helm.add("Silver helm");
				}else if(c.equals("6") && G > 44){
					G -= 45;
					armor.add("Bronze armor");
				}else if(c.equals("7") && G > 44){
					G -= 45;
					gloves.add("Gold gauntlets");
				}else if(c.equals("8") && G > 44){
					G -= 45;
					helm.add("Gold helm");
				}else if(c.equals("9")){
					output = "";
					return;
				}else if(c.equals("")){
				}else{
					JOptionPane.showMessageDialog(null, "You can not afford that.");
				}
				break;
			case 5:
				output += "p1. Lesser health potion (5)\np2. Lesser special potion (5)\np3. Health potion (15)\np4. Special potion (15)\np5. Lesser magic potion (15)\np6. Greater health potion (45)\np7. Greater special potion (45)\np8. Greater magic potion (45)";
				output += "\n1. Bronze gauntlets (15)\n2. Bronze helm (15)\n3. Bronze boots (30)\n4. Silver gauntlets (30)\n5. Silver helm (30)\n6. Bronze armor (45)\n7. Gold gauntlets (45)\n8. Gold helm (45)\n9. Silver boots (60)\n10. Platinum gauntlets (60)\n11. Platinum helm (60)\n12. Exit";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("p1") && G > 4){
					G -= 5;
					LHPp++;
				}else if(c.equals("p2") && G > 4){
					G -= 5;
					LSPp++;
				}else if(c.equals("p3") && G > 14){
					G -= 15;
					HPp++;
				}else if(c.equals("p4") && G > 14){
					G -= 15;
					SPp++;
				}else if(c.equals("p5") && G > 14){
					G -= 15;
					LMPp++;
				}else if(c.equals("p6") && G > 44){
					G -= 45;
					GHPp++;
				}else if(c.equals("p7") && G > 44){
					G -= 45;
					GSPp++;
				}else if(c.equals("p8") && G > 44){
					G -= 45;
					GMPp++;
				}else if(c.equals("1") && G > 14){
					G -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && G > 14){
					G -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3") && G > 29){
					G -= 30;
					boots.add("Bronze boots");
				}else if(c.equals("4") && G > 29){
					G -= 30;
					gloves.add("Silver gauntlets");
				}else if(c.equals("5") && G > 29){
					G -= 30;
					helm.add("Silver helm");
				}else if(c.equals("6") && G > 44){
					G -= 45;
					armor.add("Bronze armor");
				}else if(c.equals("7") && G > 44){
					G -= 45;
					gloves.add("Gold gauntlets");
				}else if(c.equals("8") && G > 44){
					G -= 45;
					helm.add("Gold helm");
				}else if(c.equals("9") && G > 59){
					G -= 60;
					boots.add("Silver boots");
				}else if(c.equals("10") && G > 59){
					G -= 60;
					gloves.add("Platinum gauntlets");
				}else if(c.equals("11") && G > 59){
					G -= 60;
					helm.add("Platinum helm");
				}else if(c.equals("12")){
					output = "";
					return;
				}else if(c.equals("")){
				}else{
					JOptionPane.showMessageDialog(null, "You can not afford that.");
				}
				break;
			default:
				return;
			}
			output = "";
			menu();
		}
	}

	private boolean heal(int x){
		if(tHP < HP || tSP < SP){
			restoreHP(x * 5);
			restoreSP(x);
			return true;
		}
		return false;
	}

	private boolean healHP(int x){
		if (tHP < HP){
			restoreHP(x);
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "You are at full health!");
			Skip = true;
			return false;
		}
	}

	private void restoreHP(int x){
		tHP += x;
		while(tHP > HP){
			tHP--;
			x--;
		}
		JOptionPane.showMessageDialog(null, "You recovered " + x + " HP.");
	}

	private boolean healSP(int x){
		if (tSP < SP){
			tSP += x;
			while(tSP > SP){
				tSP--;
				x--;
			}
			JOptionPane.showMessageDialog(null, "You recovered " + x + " SP.");
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "You are at full SP!");
			Skip = true;
			return false;
		}
	}

	private void restoreSP(int x){
		tSP += x;
		while(tSP > SP){
			tSP--;
			x--;
		}
		JOptionPane.showMessageDialog(null, "You recovered " + x + " SP.");
	}

	private int damage(int a1, int a2, int d){
		int x = a1 + a2;
		int y = x - d;
		if (y < 0){
			y = 0;
		}
		return y;
	}

	private void XP(String eNAME){
		switch(eNAME){
		case "red slime":
			if (Math.random() * 10 < 7){
				if(helm.contains("Bronze crown")){
					JOptionPane.showMessageDialog(null, "The red slime dropped a lesser special potion!");
					LSPp++;
				}else{
					JOptionPane.showMessageDialog(null, "The red slime dropped a bronze crown!");
					helm.add("Bronze crown");
				}
			}
			break;
		case "goblin warlord":
			if (Math.random() * 10 < 6){
				if(helm.contains("Silver crown")){
					JOptionPane.showMessageDialog(null, "The goblin warlord dropped a health potion!");
					HPp++;
				}else{
					JOptionPane.showMessageDialog(null, "The goblin warlord dropped a silver crown!");
					helm.add("Silver crown");
				}
			}
			break;
		case "kraken":
			if (Math.random() * 10 < 6){
				if(helm.contains("Silver crown")){
					JOptionPane.showMessageDialog(null, "The kraken dropped a special potion!");
					SPp++;
				}else{
					JOptionPane.showMessageDialog(null, "The kraken dropped a silver crown!");
					helm.add("Silver crown");
				}
			}
			break;
		case "tarantula":
			if (Math.random() * 10 < 5){
				if(helm.contains("Gold crown")){
					JOptionPane.showMessageDialog(null, "The tarantula dropped a greater health potion!");
					GHPp++;
				}else{
					JOptionPane.showMessageDialog(null, "The tarantula dropped a gold crown!");
					helm.add("Gold crown");
				}
			}
			break;
		case "python":
			if (Math.random() * 10 < 5){
				if(helm.contains("Gold crown")){
					JOptionPane.showMessageDialog(null, "The python dropped a greater health potion!");
					GHPp++;
				}else{
					JOptionPane.showMessageDialog(null, "The python dropped a gold crown!");
					helm.add("Gold crown");
				}
			}
		}
		if (crown){
			G += eG + eXP;
			JOptionPane.showMessageDialog(null, "You beat the " + eNAME + ". You got " + (eG + eXP) + " gold!");
		}else{
			G += eG;
			XP += eXP;
			JOptionPane.showMessageDialog(null, "You beat the " + eNAME + ". You got " + eXP + " XP and " + eG + " gold!");
		}
		while (XP >= XPG) {
			LVUP++;
			XPG += XPI;
			XPI += XPI;
		}
		XPR = XPG - XP;
		while (LVUP > 0){
			HP += 5;
			tHP += 5;
			SP++;
			tSP++;
			SPD++;
			gems = true;
			while(gems){
				String menu = JOptionPane.showInputDialog("You leveled up! Your HP went up by 5! Your SP went up by 1! Your SPD went up 1! Would you like to upgrade attack(a) or defense(d)?");
				if (menu.equals ("a")){
					ATK++;
					gems = false;
				}else if (menu.equals ("d")){
					DEF++;
					gems = false;
				}
			}
			LVUP--;
			LV++;
		}
	}
	private void gemShop(int s) throws FileNotFoundException{
		gems = true;
		String c;
		while(gems){
			output = "What would you like to learn?\n";
			switch(s){
			case 1:
				output += "1. Nutritious Water\n2. Scorch\n3. Vine Shield";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("1") && !nutritiousWater){
					gems = false;
					nutritiousWater = true;
				}else if(c.equals("2") && !scorch){
					gems = false;
					scorch = true;
				}else if(c.equals("3") && !vineShield){
					gems = false;
					vineShield = true;
				}
				break;
			case 2:
				output += "1. Nutritious Water\n2. Scorch\n3. Vine Shield\n4. Cure\n5. Flare\n6. Vine Trap";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("1") && !nutritiousWater){
					gems = false;
					nutritiousWater = true;
				}else if(c.equals("2") && !scorch){
					gems = false;
					scorch = true;
				}else if(c.equals("3") && !vineShield){
					gems = false;
					vineShield = true;
				}else if(c.equals("4") && !cure){
					gems = false;
					cure = true;
				}else if(c.equals("5") && !flare){
					gems = false;
					flare = true;
				}else if(c.equals("6") && !vineTrap){
					gems = false;
					vineTrap = true;
				}
				break;
			default:
				return;
			}
			output = "";
		}
		loc++;
		gems = true;
		while (gems){
			c = JOptionPane.showInputDialog("Would you like to save your game? (y/n)");
			if(c.equalsIgnoreCase("y")){
				save();
				gems = false;
			}else if(c.equalsIgnoreCase("n")){
				gems = false;
			}
		}
	}
	private void menu() throws FileNotFoundException{
		String c = JOptionPane.showInputDialog("Would you like to use the menu (m) or continue (Any other key)?");
		if (c.equals("m")){
			while(true){
				JOptionPane.showMessageDialog(null, "You are Level " + LV + ".  You have " + tHP + "/" + HP + " HP and " + tSP + "/" + SP + " SP.  Your ATK is " + ATK + ", your DEF is " + DEF + " (" + (DEF + AC) + " with armor), and your SPD is " + SPD + ".  You need " + XPR + " XP to level up.  You have " + G + " gold. You need to beat "+ b + " more monster(s) to get to the next town.");
				c = JOptionPane.showInputDialog("Helm: " + Ehelm + " | Gloves: " + Egloves + " | Boots: " + Eboots + " | Armor: " + Earmor + " \nWould you like to equip a (h)elm, (g)loves, (b)oots, (a)rmor, use a (p)otion or healing ability, or do (n)othing?");
				if (c.equals("h")){
					crown = false;
					for (int i = 0; i < helm.size(); i++){
						output += (i + 1) + ". " + helm.get(i) + "\n";
					}
					output += "What would you like to equip?";
					c = JOptionPane.showInputDialog(output);
					int n = Integer.parseInt(c);
					if(n > 0 || n < helm.size() + 1){
						String N = helm.get(n - 1);
						switch(N){
						case "Nothing":
							mPOW = 0;
							break;
						case "Bronze helm":
							mPOW = 1;
							break;
						case "Silver helm":
							mPOW = 2;
							break;
						case "Gold helm":
							mPOW = 3;
							break;
						case "Platinum helm":
							mPOW = 4;
							break;
						case "Bronze crown":
							mPOW = 1;
							crown = true;
							break;
						case "Silver crown":
							mPOW = 2;
							crown = true;
							break;
						case "Gold crown":
							mPOW = 3;
							crown = true;
							break;
						}
						Ehelm = N;
					}
				}else if (c.equals("g")){
					for (int i = 0; i < gloves.size(); i++){
						output += (i + 1) + ". " + gloves.get(i) + "\n";
					}
					output += "What would you like to equip?";
					c = JOptionPane.showInputDialog(output);
					int n = Integer.parseInt(c);
					if(n > 0 || n < armor.size() + 1){
						String N = gloves.get(n - 1);
						switch(N){
						case "Nothing":
							gPOW = 0;
							break;
						case "Bronze gauntlets":
							gPOW = 1;
							break;
						case "Silver gauntlets":
							gPOW = 2;
							break;
						case "Gold gauntlets":
							gPOW = 3;
							break;
						case "Platinum gauntlets":
							gPOW = 4;
							break;
						}
						Egloves = N;
					}
				}else if (c.equals("b")){
					for (int i = 0; i < boots.size(); i++){
						output += (i + 1) + ". " + boots.get(i) + "\n";
					}
					output += "What would you like to equip?";
					c = JOptionPane.showInputDialog(output);
					int n = Integer.parseInt(c);
					if(n > 0 || n < armor.size() + 1){
						String N = boots.get(n - 1);
						switch(N){
						case "Nothing":
							bPOW = 0;
							break;
						case "Bronze boots":
							bPOW = 1;
							break;
						case "Silver boots":
							bPOW = 2;
							break;
						}
						Eboots = N;
					}
				}else if (c.equals("a")){
					for (int i = 0; i < armor.size(); i++){
						output += (i + 1) + ". " + armor.get(i) + "\n";
					}
					output += "What would you like to equip?";
					c = JOptionPane.showInputDialog(output);
					int n = Integer.parseInt(c);
					if(n > 0 || n < armor.size() + 1){
						String N = armor.get(n - 1);
						switch(N){
						case "Nothing":
							AC = 0;
							break;
						case "Bronze armor":
							AC = 1;
							break;
						}
						Earmor = N;
					}
				}else if (c.equals("p")){
					output = "What would you like to use?";
					if (nutritiousWater && tSP > 0){
						output += "\nNutritious Water heals " + (5 + mPOW) + " HP and uses 1 SP (nw).";
					}
					if (cure && tSP > 2){
						output += "\nCure heals " + (10 + mPOW * 2) + " HP, cures poison, and uses 3 SP (c).";
					}
					if(LHPp == 1){
						output += "\nYou can use your lesser health potion to heal 5 HP (h1).";
					}
					if(LHPp > 1){
						output += "\nYou can use one of your " + LHPp + " lesser health potions to heal 5 HP (h1).";
					}
					if(LSPp == 1){
						output += "\nYou can use your lesser special potion to heal 1 SP (s1).";
					}
					if(LSPp > 1){
						output += "\nYou can use one of your " + LSPp + " lesser special potions to heal 1 SP (s1).";
					}
					if(HPp == 1){
						output += "\nYou can use your health potion to heal 10 HP (h2).";
					}
					if(HPp > 1){
						output += "\nYou can use one of your " + HPp + " health potions to heal 10 HP (h2).";
					}
					if(SPp == 1){
						output += "\nYou can use your special potion to heal 2 SP (s2).";
					}
					if(SPp > 1){
						output += "\nYou can use one of your " + SPp + " special potions to heal 2 SP (s2).";
					}
					if(LMPp == 1){
						output += "\nYou can use your lesser magic potion to heal 5 HP and 1 SP (m1).";
					}
					if(LMPp > 1){
						output += "\nYou can use one of your " + LMPp + " lesser magic potions to heal 5 HP and 1 SP (m1).";
					}
					if(GHPp == 1){
						output += "\nYou can use your greater health potion to heal 20 HP (h3).";
					}
					if(GHPp > 1){
						output += "\nYou can use one of your " + GHPp + " greater health potions to heal 20 HP (h3).";
					}
					if(GSPp == 1){
						output += "\nYou can use your greater special potion to heal 4 SP (s3).";
					}
					if(GSPp > 1){
						output += "\nYou can use one of your " + GSPp + " greater special potions to heal 4 SP (s3).";
					}
					if(GMPp == 1){
						output += "\nYou can use your greater magic potion to heal 10 HP and 2 SP (m2).";
					}
					if(GMPp > 1){
						output += "\nYou can use one of your " + GMPp + " greater magic potions to heal 10 HP and 2 SP (m2).";
					}
					c = JOptionPane.showInputDialog(output);
					if (c.equals ("h1") && LHPp > 0) {
						if (healHP(5)) {
							LHPp--;
						}
					}else if (c.equals ("s1") && LSPp > 0) {
						if (healSP(1)) {
							LSPp--;
						}
					}else if (c.equals ("h2") && HPp > 0) {
						if (healHP(10)) {
							HPp--;
						}
					}else if (c.equals ("s2") && SPp > 0) {
						if (healSP(2)) {
							SPp--;
						}
					}else if (c.equals ("m1") && LMPp > 0) {
						if (heal(1)) {
							LMPp--;
						}
					}else if (c.equals ("h3") && GHPp > 0) {
						if (healHP(20)) {
							GHPp--;
						}
					}else if (c.equals ("s3") && GSPp > 0) {
						if (healSP(4)) {
							GSPp--;
						}
					}else if (c.equals ("m2") && GMPp > 0) {
						if (heal(2)) {
							GMPp--;
						}
					}else if (c.equals ("nw") && nutritiousWater){
						if (tSP > 0){
							if(healHP(5 + mPOW)){
								tSP--;
							}
						}
					}else if (c.equals ("c") && cure) {
						if (tSP > 2){
							if(healHP(10 + mPOW * 2) || yPT > 0){
								tSP -= 3;
								if(yPT > 0){
									yPT = 0;
									JOptionPane.showMessageDialog(null, "You are no longer poisoned!");
								}
							}
						}
					}
				}else{
					break;
				}
				output = "";
			}
		}
	}
	private void save() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter("C:/Users/Public/Save");
		writer.print("");
		writer.println(HP);
		writer.println(SP);
		writer.println(DEF);
		writer.println(AC);
		writer.println(ATK);
		writer.println(SPD);
		writer.println(nutritiousWater);
		writer.println(scorch);
		writer.println(vineShield);
		writer.println(cure);
		writer.println(flare);
		writer.println(vineTrap);
		writer.println(XP);
		writer.println(XPG);
		writer.println(XPR);
		writer.println(XPI);
		writer.println(LV);
		writer.println(G);
		writer.println(gPOW);
		writer.println(bPOW);
		writer.println(mPOW);
		writer.println(Earmor);
		writer.println(Egloves);
		writer.println(Eboots);
		writer.println(Ehelm);
		writer.println(LHPp);
		writer.println(LSPp);
		writer.println(HPp);
		writer.println(SPp);
		writer.println(LMPp);
		writer.println(GHPp);
		writer.println(GSPp);
		writer.println(GMPp);
		writer.println(b);
		writer.println(crown);
		writer.println(helm.size());
		for (int i = 0; i < helm.size(); i++){
			writer.println(helm.get(i));
		}
		writer.println(gloves.size());
		for (int i = 0; i < gloves.size(); i++){
			writer.println(gloves.get(i));
		}
		writer.println(armor.size());
		for (int i = 0; i < armor.size(); i++){
			writer.println(armor.get(i));
		}
		writer.println(boots.size());
		for (int i = 0; i < boots.size(); i++){
			writer.println(boots.get(i));
		}
		writer.print(loc);
		writer.close();
	}
	private void load() throws FileNotFoundException{
        Scanner s = new Scanner(new File ("C:/Users/Public/Save"));
        HP = s.nextInt();
        SP = s.nextInt();
		DEF = s.nextInt();
		AC = s.nextInt();
		ATK = s.nextInt();
		SPD = s.nextInt();
		nutritiousWater = s.nextBoolean();
		scorch = s.nextBoolean();
		vineShield = s.nextBoolean();
		cure = s.nextBoolean();
		flare = s.nextBoolean();
		vineTrap = s.nextBoolean();
		XP = s.nextInt();
		XPG = s.nextInt();
		XPR = s.nextInt();
		XPI = s.nextInt();
		LV = s.nextInt();
		G = s.nextInt();
		gPOW = s.nextInt();
		bPOW = s.nextInt();
		mPOW = s.nextInt();
		s.nextLine();
		Earmor = s.nextLine();
		Egloves = s.nextLine();
		Eboots = s.nextLine();
		Ehelm = s.nextLine();
		LHPp = s.nextInt();
		LSPp = s.nextInt();
		HPp = s.nextInt();
		SPp = s.nextInt();
		LMPp = s.nextInt();
		GHPp = s.nextInt();
		GSPp = s.nextInt();
		GMPp = s.nextInt();
		b = s.nextInt();
		crown = s.nextBoolean();
		int n = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++){
			helm.add(s.nextLine());
		}
		n = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++){
			gloves.add(s.nextLine());
		}
		n = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++){
			armor.add(s.nextLine());
		}
		n = s.nextInt();
		s.nextLine();
		for (int i = 0; i < n; i++){
			boots.add(s.nextLine());
		}
		loc = s.nextInt();
		s.close();
		if(HP > 35 || SP > 6 || DEF > 5 || ATK > 5 || ATK + DEF > 5 || AC > 1 || SPD > 6 || G > 500 || gPOW > 3 || bPOW > 1 || mPOW > 3){
			JOptionPane.showMessageDialog(null, "Your file is corrupt.");
			System.exit(0);
		}
	}
}