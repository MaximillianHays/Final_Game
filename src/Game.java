import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Game{
	/** Player's max HP */
	private int maxHp = 10;
	/** Player's max SP */
	private int maxSp = 1;
	/** Player's unmodified defense */
	private int def = 0;
	/** Player's defense from armor */
	private int ac = 0;
	/** Player's unmodified attack */
	private int atk = 0;
	/** Player's unmodified speed */
	private int spd = 1;
	/** Player's current HP */
	private int hp = maxHp;
	/** Player's current SP */
	private int sp = maxSp;
	/** Player's current attack */
	private int tAtk = atk;
	/** Player's current defense */
	private int tDef = def;
	/** If the player knows the spell nutritious water */
	private boolean nutritiousWater = false;
	/** If the player knows the spell scorch */
	private boolean scorch = false;
	/** If the player knows the spell vine shield */
	private boolean vineShield = false;
	/** If the player knows the spell cure */
	private boolean cure = false;
	/** If the player knows the spell flare */
	private boolean flare = false;
	/** If the player knows the spell vine trap */
	private boolean vineTrap = false;
	/** Player's EXP */
	private int xp;
	/** How much total EXP the player needs to increase LV */
	private int xpg = 10;
	/** How much more EXP the player needs to increase LV */
	private int xpr = 10;
	/** How much xpg will increase when the player's LV increases */
	private int xpi = 20;
	//TODO Replace with temporary variable in method.
	/** How many times the player's LV will increase */
	private int lvup;
	/** Player's LV */
	private int lv = 1;
	/** Player's gold */
	private int g;
	/** If the player has an ability gem */
	private boolean gem = false;
	/** Power of the current attack */
	private int pow;
	/** Player's punching power */
	private int gPow;
	/** Player's kicking power */
	private int bPow;
	/** Player's magic power */
	private int mPow;
	/** Amount of turns player is stunned for */
	private int ySt;
	/** Amount of turns player is poisoned for */
	private int yPt;
	/** If a round of combat will be skipped */
	private boolean skip = false;
	/** Current armor */
	private String Earmor = "Nothing";
	/** Current gloves */
	private String Egloves = "Nothing";
	/** Current boots */
	private String Eboots = "Nothing";
	/** Current helm */
	private String Ehelm = "Nothing";
	/** Amount of lesser healing potions player owns */
	private int LHPp;
	/** Amount of lesser special potions player owns */
	private int LSPp;
	/** Amount of healing potions player owns */
	private int HPp;
	/** Amount of special potions player owns */
	private int SPp;
	/** Amount of lesser magic potions player owns */
	private int LMPp;
	/** Amount of greater healing potions player owns */
	private int GHPp;
	/** Amount of greater special potions player owns */
	private int GSPp;
	/** Amount of greater magic potions player owns */
	private int GMPp;
	/** Amount of battles until the player reaches the next town */
	private int b;
	/** If player is wearing a crown */
	private boolean crown = false;
	/** What helms the player owns */
	private ArrayList<String> helm = new ArrayList<String>();
	/** What gloves the player owns */
	private ArrayList<String> gloves = new ArrayList<String>();
	/** What armor the player owns */
	private ArrayList<String> armor = new ArrayList<String>();
	/** What boots the player owns */
	private ArrayList<String> boots = new ArrayList<String>();
	/** What world the player is in */
	private int loc = 1;
	/** What text should be displayed */
	private String output = "";
	/** The game */
	private static final Game GAME = new Game();
	
	public static void main(String args[]){
		try {
			GAME.play();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getLocalizedMessage());
		}
	}
	/** Starts the game */
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
			battle(Creature.goblin);
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
			battle(Creature.elite_goblin);
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
			battle(Creature.ogre);
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
			battle(Creature.elite_ogre);
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
			battle(Creature.ogre_warlord);
			JOptionPane.showMessageDialog(null, "You win!");
		}
	}
	/**
	 * Starts a battle against a random enemy
	 * @param d The difficulty of the encounter
	 * */
	private void encounter(int d) throws FileNotFoundException{
		double r = Math.random() * 10;
		switch (d){
		case 1:
			if(r < 6){
				battle(Creature.green_slime);
			}else{
				battle(Creature.goblin);
			}
			break;
		case 2:
			if(r < 3){
				battle(Creature.goblin);
			}else{
				battle(Creature.squid);
			}
			break;
		case 3:
			if(r < 1){
				battle(Creature.squid);
			}else if(r < 3){
				battle(Creature.yellow_slime);
			}else if(r < 8){
				battle(Creature.spider);
			}else{
				battle(Creature.snake);
			}
			break;
		case 4:
			if(r < 3){
				battle(Creature.snake);
			}else{
				battle(Creature.elite_goblin);
			}
			break;
		case 5:
			if(r < 2){
				battle(Creature.cobra);
			}else if(r < 7){
				battle(Creature.red_slime);
			}else{
				battle(Creature.ogre);
			}
			break;
		case 6:
			if(r < 3){
				battle(Creature.cobra);
			}else if(r < 7){
				battle(Creature.wolf_spider);
			}else{
				battle(Creature.octopus);
			}
			break;
		case 7:
			if(r < 1){
				battle(Creature.red_slime);
			}else if(r < 3){
				battle(Creature.cobra);
			}else{
				battle(Creature.goblin_warlord);
			}
			break;
		case 8:
			if(r < 1){
				battle(Creature.goblin_warlord);
			}else if(r < 4){
				battle(Creature.kraken);
			}else{
				battle(Creature.elite_ogre);
			}
			break;
		case 9:
			if(r < 1){
				battle(Creature.goblin_warlord);
			}else if(r < 3){
				battle(Creature.elite_ogre);
			}else{
				battle(Creature.kraken);
			}
			break;
		case 10:
			if(r < 3){
				battle(Creature.tarantula);
			}else{
				battle(Creature.kraken);
			}
			break;
		case 11:
			if(r < 3){
				battle(Creature.kraken);
			}else{
				battle(Creature.tarantula);
			}
			break;
		case 12:
			if(r < 3){
				battle(Creature.python);
			}else{
				battle(Creature.tarantula);
			}
			break;
		}
		if(b > 0){
			menu();
		}
	}
	/**
	 * Causes the player to battle an enemy
	 * @param eName The name of the enemy
	 * */
	private void battle(Creature x){
		tAtk = atk;
		tDef = def + ac;
		skip = false;
		while (true) {
			if (spd >= x.getSpd()){
				if (ySt == 0){
					String choice = JOptionPane.showInputDialog("You have " + hp + "/" + maxHp + " HP and " + sp + "/" + maxSp + " SP.  The " + x + " has " + x.getHp() + "/" + x.getMaxhp() + " HP and " + x.getDef() + " DEF.  Press l for a list of actions.");
					if (choice.equals("l")){
						output = "Punch does " + (2 + gPow + atk) + " damage (p).\nKick does " + (1 + bPow + atk) + " damage and stuns the enemy 50% of the time (k).";
						if (nutritiousWater){
							output += "\nNutritious Water heals " + (5 + mPow) + " HP and uses 1 SP (nw).";
						}
						if (scorch){
							output += "\nScorch does " + (3 + mPow + atk) + " damage and burns the enemy for 2 turns " + (50 + mPow * 10) + "% of the time and uses 1 SP (s).";
						}
						if (vineShield){
							output += "\nVine Shield increases your defense by 1 for the duration of the battle and uses " + damage(tDef,1,mPow) + " SP. The cost increases with higher defense (vs).";
						}
						if (cure){
							output += "\nCure heals " + (10 + mPow * 3) + " HP, cures poison, and uses 3 SP (c).";
						}
						if (flare){
							output += "\nFlare burns the enemy for " + (5 + mPow) + " turns and uses 1 SP (f).";
						}
						if (vineTrap){
							output += "\nVine Trap stuns the enemy for 3 turns, has a " + (50 + mPow * 10) + "% chance to reduce its defense by 1 for the duration of the battle, and uses 3 SP. (vt).";
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
						skip = true;
					}else if (choice.equals("p")){
						pow = 2 + gPow;
						JOptionPane.showMessageDialog(null, "The " + x + " took " + damage(pow, tAtk, x.getDef()) + " damage!");
						x.setHp(x.getHp() - damage(pow, tAtk, x.getDef()));
					}else if (choice.equals("k")) {
						pow = 1 + bPow;
						JOptionPane.showMessageDialog(null, "The " + x + " took " + damage(pow, tAtk, x.getDef()) + " damage!");
						x.setHp(x.getHp() - damage(pow, tAtk, x.getDef()));
						if ((Math.random()) * 10 < 5){
							x.setSt(x.getSt() + 1);
							JOptionPane.showMessageDialog(null, "The " + x + " cannot move for " + x.getSt() + " turn(s)!");
						}
					}else if (choice.equals ("nw") && nutritiousWater){
						if (sp > 0){
							if(healHP(5 + mPow)){
								sp--;
							}
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							skip = true;
						}
					}else if (choice.equals ("s") && scorch) {
						if (sp > 0){
							pow = 3 + mPow;
							JOptionPane.showMessageDialog(null, "The " + x + " took " + damage(pow, tAtk, x.getDef()) + " damage!");
							x.setHp(x.getHp() - damage(pow, tAtk, x.getDef()));
							if ((Math.random()) * 100 < 50 + mPow * 10){
								x.setBt(x.getBt() + 2);
								JOptionPane.showMessageDialog(null, "The " + x + " was burned for 2 turns!");
							}
							sp--;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							skip = true;
						}
					}else if (choice.equals ("vs") && vineShield) {
						if(sp + mPow > tDef){
							JOptionPane.showMessageDialog(null,"Your defense went up by 1 for the battle!");
							sp -= damage(tDef, 1, mPow);
							tDef += 1;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							skip = true;
						}
					}else if (choice.equals ("c") && cure) {
						if (sp > 2){
							if(healHP(10 + mPow * 3) || yPt > 0){
								sp -= 3;
								if(yPt > 0){
									yPt = 0;
									JOptionPane.showMessageDialog(null, "You are no longer poisoned!");
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							skip = true;
						}
					}else if (choice.equals ("f") && flare) {
						if(sp > 0){
							JOptionPane.showMessageDialog(null, "The " + x + " was burned for " + (5 + mPow) + " turns!");
							//bt += 5 + mPow;
							x.setBt(x.getBt() + 5 + mPow);
							sp--;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							skip = true;
						}
					}else if (choice.equals ("vt") && vineTrap) {
						if(sp > 2){
							x.setSt(x.getSt() + 3);
							JOptionPane.showMessageDialog(null, "The " + x + " cannot move for " + x.getSt() + " turn(s)!");
							if ((Math.random()) * 100 < 50 + mPow * 10){
								x.setDef(x.getDef() - 1);
								JOptionPane.showMessageDialog(null, "The " + x + "'s defense went down by one for the battle!");
							}
							sp -= 3;
						}else{
							JOptionPane.showMessageDialog(null, "You don't have enough SP!");
							skip = true;
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
						skip = true;
					}
					if (x.getHp() <= 0){
						XP(x);
						break;
					}
				}
			}
			x.setSpd(0);
			if(!skip){
				if (ySt > 0){
					ySt--;
					if (ySt > 0) {
						JOptionPane.showMessageDialog(null, "You still can't move...");
					}else{
						JOptionPane.showMessageDialog(null, "You can move again!");
					}
				}
				if (yPt > 0){
					yPt--;
					JOptionPane.showMessageDialog(null, "You took 1 poison damage!");
					hp--;
					if (yPt > 0) {
						JOptionPane.showMessageDialog(null, "You are still poisoned...");
					}else{
						JOptionPane.showMessageDialog(null, "You are no longer poisoned!");
					}
				}
			}
			if (hp <= 0){
				JOptionPane.showMessageDialog(null, "You lost...");
				System.exit(0);
			}
			if (!skip) {
				if (x.getSt() == 0){
					switch (x){
					case green_slime:
						pow = 1;
						JOptionPane.showMessageDialog(null, "The green slime ran into you for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case yellow_slime:
						pow = 2;
						JOptionPane.showMessageDialog(null, "The yellow slime ran into you for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case red_slime:
						pow = 5;
						JOptionPane.showMessageDialog(null, "The red slime ran into you for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case goblin:
						pow = 1;
						JOptionPane.showMessageDialog(null, "The goblin smacked you for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case elite_goblin:
						pow = 2;
						JOptionPane.showMessageDialog(null, "The elite goblin smacked you for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case goblin_warlord:
						pow = 5;
						JOptionPane.showMessageDialog(null, "The goblin warlord smacked you for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case squid:
						if (damage(3, tAtk, x.getDef()) > x.getHp() && !(damage(3, 0, def) > maxHp) && tDef < 1) {
							pow = 1;
							JOptionPane.showMessageDialog(null, "The squid shot ink at you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
							if ((Math.random()) * 10 < 3){
								ySt++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + ySt + " turn(s)!");
							}
						}else{
							pow = 2;
							JOptionPane.showMessageDialog(null, "The squid slapped you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}
						break;
					case octopus:
						if (damage(3, tAtk, x.getDef()) > x.getHp() && !(damage(5, 0, def) > maxHp) && tDef < 2) {
							pow = 2;
							JOptionPane.showMessageDialog(null, "The octopus shot ink at you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
							if ((Math.random()) * 10 <= 3){
								ySt++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + ySt + " turn(s)!");
							}
						}else{
							pow = 4;
							JOptionPane.showMessageDialog(null, "The octopus slapped you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}
						break;
					case kraken:
						if (damage(3, tAtk, x.getDef()) > x.getHp() && !(damage(11, 0, def) > maxHp) && tDef < 5) {
							pow = 5;
							JOptionPane.showMessageDialog(null, "The kraken shot ink at you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
							if ((Math.random()) * 10 <= 3){
								ySt++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + ySt + " turn(s)!");
							}
						}else{
							pow = 10;
							JOptionPane.showMessageDialog(null, "The kraken slapped you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}
						break;
					case spider:
						if (damage(3, tAtk, x.getDef()) > x.getHp() && !(damage(3, 0, def) > maxHp) && tDef < 1) {
							pow = 1;
							JOptionPane.showMessageDialog(null, "The spider shot a web at you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
							if ((Math.random()) * 10 < 4){
								ySt++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + ySt + " turn(s)!");
							}
						}else{
							pow = 2;
							JOptionPane.showMessageDialog(null, "The spider bit you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}
						break;
					case wolf_spider:
						if (damage(3, tAtk, x.getDef()) > x.getHp() && !(damage(5, 0, def) > maxHp) && tDef < 2) {
							pow = 2;
							JOptionPane.showMessageDialog(null, "The wolf spider shot a web at you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
							if ((Math.random()) * 10 < 4){
								ySt++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + ySt + " turn(s)!");
							}
						}else{
							pow = 4;
							JOptionPane.showMessageDialog(null, "The wolf spider bit you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}
						break;
					case tarantula:
						if (damage(3, tAtk, x.getDef()) > x.getHp() && !(damage(11, 0, def) > maxHp) && tDef < 5) {
							pow = 5;
							JOptionPane.showMessageDialog(null, "The tarantula shot a web at you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
							if ((Math.random()) * 10 < 4){
								ySt++;
								JOptionPane.showMessageDialog(null, "You cannot move for " + ySt + " turn(s)!");
							}
						}else{
							pow = 10;
							JOptionPane.showMessageDialog(null, "The tarantula bit you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}
						break;
					case snake:
						if (damage(3, tAtk, x.getDef()) > x.getHp() || damage(3, 0, def) > maxHp) {
							pow = 2;
							JOptionPane.showMessageDialog(null, "The snake bit you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}else{
							pow = 1;
							JOptionPane.showMessageDialog(null, "The snake spat venom at you for " + damage(pow, 0, tDef) + " damage! You were also poisoned for 2 turns.");
							yPt += 2;
							hp -= damage(pow, 0, tDef);
						}
						break;
					case cobra:
						if (damage(3, tAtk, x.getDef()) > x.getHp() || damage(5, 0, def) > maxHp) {
							pow = 4;
							JOptionPane.showMessageDialog(null, "The cobra bit you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}else{
							pow = 2;
							JOptionPane.showMessageDialog(null, "The cobra spat venom at you for " + damage(pow, 0, tDef) + " damage! You were also poisoned for 2 turns.");
							yPt += 4;
							hp -= damage(pow, 0, tDef);
						}
						break;
					case python:
						if (damage(3, tAtk, x.getDef()) > x.getHp() || damage(11, 0, def) > maxHp) {
							pow = 10;
							JOptionPane.showMessageDialog(null, "The python bit you for " + damage(pow, 0, tDef) + " damage!");
							hp -= damage(pow, 0, tDef);
						}else{
							pow = 5;
							JOptionPane.showMessageDialog(null, "The python spat venom at you for " + damage(pow, 0, tDef) + " damage! You were also poisoned for 2 turns.");
							yPt += 4;
							hp -= damage(pow, 0, tDef);
						}
						break;
					case ogre:
						pow = 3;
						JOptionPane.showMessageDialog(null, "The ogre hits you with its club for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case elite_ogre:
						pow = 6;
						JOptionPane.showMessageDialog(null, "The elite ogre hits you with its club for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					case ogre_warlord:
						pow = 15;
						JOptionPane.showMessageDialog(null, "The ogre warlord hits you with its club for " + damage(pow, 0, tDef) + " damage!");
						hp -= damage(pow, 0, tDef);
						break;
					}
					if (hp <= 0){
						JOptionPane.showMessageDialog(null, "You lost...");
						System.exit(0);
					}
				}else{
					if (x.getSt() > 1) {
						JOptionPane.showMessageDialog(null, "The " + x + " still can't move...");
					}else{
						JOptionPane.showMessageDialog(null, "The " + x + " can move again!");
					}
					x.setSt(x.getSt() - 1);
				}
				if (x.getBt() > 0){
					JOptionPane.showMessageDialog(null, "The " + x + " took " + (mPow + 1) + " burn damage!");
					x.setHp(x.getHp() - (mPow + 1));
					x.setBt(x.getBt() - 1);
					if (x.getBt() == 0){
						JOptionPane.showMessageDialog(null, "The " + x + " is no longer burned!");
					}else{
						JOptionPane.showMessageDialog(null, "The " + x + " is still burned!");
					}
				}
				if (x.getHp() <= 0){
					XP(x);
					break;
				}
			}
			skip = false;
		}
		yPt = 0;
		ySt = 0;
		b--;
	}
	/**
	 * Lets the player buy items at a shop
	 * @param s The level of shop
	 * */
	private void shop(int s) throws FileNotFoundException{
		String c;
		hp = maxHp;
		sp = maxSp;
		while(true){
			output = "You have " + g + " gold.\nWhat would you like to buy?\n";
			switch(s){
			case 1:
				output += "p1. Lesser health potion (5)\np2. Lesser special potion (5)\n1. Exit";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("p1") && g > 4){
					g -= 5;
					LHPp++;
				}else if(c.equals("p2") && g > 4){
					g -= 5;
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
				if(c.equals("p1") && g > 4){
					g -= 5;
					LHPp++;
				}else if(c.equals("p2") && g > 4){
					g -= 5;
					LSPp++;
				}else if(c.equals("p3") && g > 14){
					g -= 15;
					HPp++;
				}else if(c.equals("p4") && g > 14){
					g -= 15;
					SPp++;
				}else if(c.equals("p5") && g > 14){
					g -= 15;
					LMPp++;
				}else if(c.equals("1") && g > 14){
					g -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && g > 14){
					g -= 15;
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
				if(c.equals("p1") && g > 4){
					g -= 5;
					LHPp++;
				}else if(c.equals("p2") && g > 4){
					g -= 5;
					LSPp++;
				}else if(c.equals("p3") && g > 14){
					g -= 15;
					HPp++;
				}else if(c.equals("p4") && g > 14){
					g -= 15;
					SPp++;
				}else if(c.equals("p5") && g > 14){
					g -= 15;
					LMPp++;
				}else if(c.equals("1") && g > 14){
					g -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && g > 14){
					g -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3") && g > 29){
					g -= 30;
					boots.add("Bronze boots");
				}else if(c.equals("4") && g > 29){
					g -= 30;
					gloves.add("Silver gauntlets");
				}else if(c.equals("5") && g > 29){
					g -= 30;
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
				if(c.equals("p1") && g > 4){
					g -= 5;
					LHPp++;
				}else if(c.equals("p2") && g > 4){
					g -= 5;
					LSPp++;
				}else if(c.equals("p3") && g > 14){
					g -= 15;
					HPp++;
				}else if(c.equals("p4") && g > 14){
					g -= 15;
					SPp++;
				}else if(c.equals("p5") && g > 14){
					g -= 15;
					LMPp++;
				}else if(c.equals("p6") && g > 44){
					g -= 45;
					GHPp++;
				}else if(c.equals("p7") && g > 44){
					g -= 45;
					GSPp++;
				}else if(c.equals("p8") && g > 44){
					g -= 45;
					GMPp++;
				}else if(c.equals("1") && g > 14){
					g -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && g > 14){
					g -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3") && g > 29){
					g -= 30;
					boots.add("Bronze boots");
				}else if(c.equals("4") && g > 29){
					g -= 30;
					gloves.add("Silver gauntlets");
				}else if(c.equals("5") && g > 29){
					g -= 30;
					helm.add("Silver helm");
				}else if(c.equals("6") && g > 44){
					g -= 45;
					armor.add("Bronze armor");
				}else if(c.equals("7") && g > 44){
					g -= 45;
					gloves.add("Gold gauntlets");
				}else if(c.equals("8") && g > 44){
					g -= 45;
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
				if(c.equals("p1") && g > 4){
					g -= 5;
					LHPp++;
				}else if(c.equals("p2") && g > 4){
					g -= 5;
					LSPp++;
				}else if(c.equals("p3") && g > 14){
					g -= 15;
					HPp++;
				}else if(c.equals("p4") && g > 14){
					g -= 15;
					SPp++;
				}else if(c.equals("p5") && g > 14){
					g -= 15;
					LMPp++;
				}else if(c.equals("p6") && g > 44){
					g -= 45;
					GHPp++;
				}else if(c.equals("p7") && g > 44){
					g -= 45;
					GSPp++;
				}else if(c.equals("p8") && g > 44){
					g -= 45;
					GMPp++;
				}else if(c.equals("1") && g > 14){
					g -= 15;
					gloves.add("Bronze gauntlets");
				}else if(c.equals("2") && g > 14){
					g -= 15;
					helm.add("Bronze helm");
				}else if(c.equals("3") && g > 29){
					g -= 30;
					boots.add("Bronze boots");
				}else if(c.equals("4") && g > 29){
					g -= 30;
					gloves.add("Silver gauntlets");
				}else if(c.equals("5") && g > 29){
					g -= 30;
					helm.add("Silver helm");
				}else if(c.equals("6") && g > 44){
					g -= 45;
					armor.add("Bronze armor");
				}else if(c.equals("7") && g > 44){
					g -= 45;
					gloves.add("Gold gauntlets");
				}else if(c.equals("8") && g > 44){
					g -= 45;
					helm.add("Gold helm");
				}else if(c.equals("9") && g > 59){
					g -= 60;
					boots.add("Silver boots");
				}else if(c.equals("10") && g > 59){
					g -= 60;
					gloves.add("Platinum gauntlets");
				}else if(c.equals("11") && g > 59){
					g -= 60;
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
	/**
	 * If the player can be healed, heals the player
	 * @param x 1/5 the amount of HP healed and the amount of SP restored.
	 * @return If the player can be healed
	 * */
	private boolean heal(int x){
		if(hp < maxHp || sp < maxSp){
			restoreHP(x * 5);
			restoreSP(x);
			return true;
		}
		return false;
	}
	/**
	 * If the player's HP can be restored, restores the player's HP
	 * @param x Amount of HP restored
	 * @return If the player can be healed
	 * */
	private boolean healHP(int x){
		if (hp < maxHp){
			restoreHP(x);
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "You are at full health!");
			skip = true;
			return false;
		}
	}
	/**
	 * Increases the player's current HP, but not over max HP. (Should only be used in heal and healHP)
	 * @param x How much to increase HP
	 * */
	private void restoreHP(int x){
		hp += x;
		while(hp > maxHp){
			hp--;
			x--;
		}
		JOptionPane.showMessageDialog(null, "You recovered " + x + " HP.");
	}
	/**
	 * If the player's SP can be restored, restores the player's SP
	 * @param x Amount of SP restored
	 * @return If the player can be healed
	 * */
	private boolean healSP(int x){
		if (sp < maxSp){
			restoreSP(x);
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "You are at full SP!");
			skip = true;
			return false;
		}
	}
	/**
	 * Increases the player's current SP, but not over max SP (Should only be used in heal and healSP)
	 * @param x How much to increase SP
	 * */
	private void restoreSP(int x){
		sp += x;
		while(sp > maxSp){
			sp--;
			x--;
		}
		JOptionPane.showMessageDialog(null, "You recovered " + x + " SP.");
	}
	/**
	 * Calculates damage
	 * @param a1 Attack value of the attack
	 * @param a2 Attack value of the attacker
	 * @param d Defense value of the defender
	 * @return Amount of damage
	 * */
	private int damage(int a1, int a2, int d){
		int x = a1 + a2;
		int y = x - d;
		if (y < 0){
			y = 0;
		}
		return y;
	}
	/**
	 * Gives player EXP, gold, and possibly items for defeating enemies
	 * @param x The name of the defeated enemy
	 * */
	private void XP(Creature x){
		switch(x){
		case red_slime:
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
		case goblin_warlord:
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
		case kraken:
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
		case tarantula:
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
		case python:
			if (Math.random() * 10 < 5){
				if(helm.contains("Gold crown")){
					JOptionPane.showMessageDialog(null, "The python dropped a greater health potion!");
					GHPp++;
				}else{
					JOptionPane.showMessageDialog(null, "The python dropped a gold crown!");
					helm.add("Gold crown");
				}
			}
		default:
			break;
		}
		if (crown){
			g += x.getG() + x.getXp();
			JOptionPane.showMessageDialog(null, "You beat the " + x + ". You got " + (x.getG() + x.getXp()) + " gold!");
		}else{
			g += x.getG();
			xp += x.getXp();
			JOptionPane.showMessageDialog(null, "You beat the " + x + ". You got " + x.getXp() + " XP and " + x.getG() + " gold!");
		}
		while (xp >= xpg) {
			lvup++;
			xpg += xpi;
			xpi += xpi;
		}
		xpr = xpg - xp;
		while (lvup > 0){
			maxHp += 5;
			hp += 5;
			maxSp++;
			sp++;
			spd++;
			gem = true;
			while(gem){
				String menu = JOptionPane.showInputDialog("You leveled up! Your HP went up by 5! Your SP went up by 1! Your SPD went up 1! Would you like to upgrade attack(a) or defense(d)?");
				if (menu.equals ("a")){
					atk++;
					gem = false;
				}else if (menu.equals ("d")){
					def++;
					gem = false;
				}
			}
			lvup--;
			lv++;
		}
	}
	/**
	 * Lets the player choose a spell to learn
	 * @param s What level of spells are available
	 * */
	private void gemShop(int s) throws FileNotFoundException{
		gem = true;
		String c;
		while(gem){
			output = "What would you like to learn?\n";
			switch(s){
			case 1:
				output += "1. Nutritious Water\n2. Scorch\n3. Vine Shield";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("1") && !nutritiousWater){
					gem = false;
					nutritiousWater = true;
				}else if(c.equals("2") && !scorch){
					gem = false;
					scorch = true;
				}else if(c.equals("3") && !vineShield){
					gem = false;
					vineShield = true;
				}
				break;
			case 2:
				output += "1. Nutritious Water\n2. Scorch\n3. Vine Shield\n4. Cure\n5. Flare\n6. Vine Trap";
				c = JOptionPane.showInputDialog(null, output);
				if(c.equals("1") && !nutritiousWater){
					gem = false;
					nutritiousWater = true;
				}else if(c.equals("2") && !scorch){
					gem = false;
					scorch = true;
				}else if(c.equals("3") && !vineShield){
					gem = false;
					vineShield = true;
				}else if(c.equals("4") && !cure){
					gem = false;
					cure = true;
				}else if(c.equals("5") && !flare){
					gem = false;
					flare = true;
				}else if(c.equals("6") && !vineTrap){
					gem = false;
					vineTrap = true;
				}
				break;
			default:
				return;
			}
			output = "";
		}
		loc++;
		gem = true;
		while (gem){
			c = JOptionPane.showInputDialog("Would you like to save your game? (y/n)");
			if(c.equalsIgnoreCase("y")){
				save();
				gem = false;
			}else if(c.equalsIgnoreCase("n")){
				gem = false;
			}
		}
	}
	/**
	 * Displays the menu
	 * */
	private void menu() throws FileNotFoundException{
		String c = JOptionPane.showInputDialog("Would you like to use the menu (m) or continue (Any other key)?");
		if (c.equals("m")){
			while(true){
				JOptionPane.showMessageDialog(null, "You are Level " + lv + ".  You have " + hp + "/" + maxHp + " HP and " + sp + "/" + maxSp + " SP.  Your ATK is " + atk + ", your DEF is " + def + " (" + (def + ac) + " with armor), and your SPD is " + spd + ".  You need " + xpr + " XP to level up.  You have " + g + " gold. You need to beat " + b + " more monster(s) to get to the next town.");
				c = JOptionPane.showInputDialog("Helm: " + Ehelm + " | Gloves: " + Egloves + " | Boots: " + Eboots + " | Armor: " + Earmor + " \nWould you like to equip a (h)elm, (g)loves, (b)oots, (a)rmor, use a (p)otion or healing ability, or do (n)othing?");
				if (c.equals("h")){
					crown = false;
					for (int i = 0; i < helm.size(); i++){
						output += (i + 1) + ". " + helm.get(i) + "\n";
					}
					output += "What would you like to equip?";
					c = JOptionPane.showInputDialog(output);
					int n = Integer.parseInt(c);
					if(n > 0 && n < helm.size() + 1){
						String N = helm.get(n - 1);
						switch(N){
						case "Nothing":
							mPow = 0;
							break;
						case "Bronze helm":
							mPow = 1;
							break;
						case "Silver helm":
							mPow = 2;
							break;
						case "Gold helm":
							mPow = 3;
							break;
						case "Platinum helm":
							mPow = 4;
							break;
						case "Bronze crown":
							mPow = 1;
							crown = true;
							break;
						case "Silver crown":
							mPow = 2;
							crown = true;
							break;
						case "Gold crown":
							mPow = 3;
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
					if(n > 0 && n < gloves.size() + 1){
						String N = gloves.get(n - 1);
						switch(N){
						case "Nothing":
							gPow = 0;
							break;
						case "Bronze gauntlets":
							gPow = 1;
							break;
						case "Silver gauntlets":
							gPow = 2;
							break;
						case "Gold gauntlets":
							gPow = 3;
							break;
						case "Platinum gauntlets":
							gPow = 4;
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
					if(n > 0 && n < boots.size() + 1){
						String N = boots.get(n - 1);
						switch(N){
						case "Nothing":
							bPow = 0;
							break;
						case "Bronze boots":
							bPow = 1;
							break;
						case "Silver boots":
							bPow = 2;
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
					if(n > 0 && n < armor.size() + 1){
						String N = armor.get(n - 1);
						switch(N){
						case "Nothing":
							ac = 0;
							break;
						case "Bronze armor":
							ac = 1;
							break;
						}
						Earmor = N;
					}
				}else if (c.equals("p")){
					output = "What would you like to use?";
					if (nutritiousWater && sp > 0){
						output += "\nNutritious Water heals " + (5 + mPow) + " HP and uses 1 SP (nw).";
					}
					if (cure && sp > 2){
						output += "\nCure heals " + (10 + mPow * 2) + " HP, cures poison, and uses 3 SP (c).";
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
						if (sp > 0){
							if(healHP(5 + mPow)){
								sp--;
							}
						}
					}else if (c.equals ("c") && cure) {
						if (sp > 2){
							if(healHP(10 + mPow * 2) || yPt > 0){
								sp -= 3;
								if(yPt > 0){
									yPt = 0;
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
	/**
	 * Saves the game to C:/Users/Public/Save
	 * */
	private void save() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter("C:/Users/Public/Save");
		writer.print("");
		writer.println(maxHp);
		writer.println(maxSp);
		writer.println(def);
		writer.println(ac);
		writer.println(atk);
		writer.println(spd);
		writer.println(nutritiousWater);
		writer.println(scorch);
		writer.println(vineShield);
		writer.println(cure);
		writer.println(flare);
		writer.println(vineTrap);
		writer.println(xp);
		writer.println(xpg);
		writer.println(xpr);
		writer.println(xpi);
		writer.println(lv);
		writer.println(g);
		writer.println(gPow);
		writer.println(bPow);
		writer.println(mPow);
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
	/**
	 * Loads the game from C:/Users/Public/Save
	 * */
	private void load() throws FileNotFoundException{
        Scanner s = new Scanner(new File ("C:/Users/Public/Save"));
        maxHp = s.nextInt();
        maxSp = s.nextInt();
		def = s.nextInt();
		ac = s.nextInt();
		atk = s.nextInt();
		spd = s.nextInt();
		nutritiousWater = s.nextBoolean();
		scorch = s.nextBoolean();
		vineShield = s.nextBoolean();
		cure = s.nextBoolean();
		flare = s.nextBoolean();
		vineTrap = s.nextBoolean();
		xp = s.nextInt();
		xpg = s.nextInt();
		xpr = s.nextInt();
		xpi = s.nextInt();
		lv = s.nextInt();
		g = s.nextInt();
		gPow = s.nextInt();
		bPow = s.nextInt();
		mPow = s.nextInt();
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
		if(maxHp > 35 || maxSp > 6 || def > 5 || atk > 5 || atk + def > 5 || ac > 1 || spd > 6 || g > 500 || gPow > 3 || bPow > 1 || mPow > 3){
			JOptionPane.showMessageDialog(null, "Your file is corrupt.");
			System.exit(0);
		}
	}
}