public enum Creature {
	green_slime(5,0,1,2,2),
	yellow_slime(10,0,2,4,4),
	red_slime(25,0,1,10,10),
	goblin(10,0,1,4,4),
	elite_goblin(20,0,2,8,8),
	goblin_warlord(50,0,5,20,20),
	squid(7,0,1,4,5),
	octopus(14,0,2,8,10),
	kraken(35,0,5,20,25),
	spider(9,0,3,5,4),
	wolf_spider(18,0,6,10,8),
	tarantula(45,0,15,25,20),
	snake(7,1,2,5,4),
	cobra(14,2,4,10,8),
	python(35,5,10,25,20),
	ogre(25,1,2,30,30),
	elite_ogre(50,2,4,60,60),
	ogre_warlord(125,5,10,150,150);
	/** Creature's Current HP */
	private int hp;
	/** Creature's max HP */
	private int maxHp;
	/** Creature's defense */
	private int def;
	/** Creature's speed */
	private int spd;
	/** EXP earned by defeating enemy */
	private int xp;
	/** Gold earned by defeating enemy */
	private int g;
	/** How many turns the creature is burned for */
	private int bt;
	/** How many turns the creature is stunned for */
	private int st;
	/**
	 * Creates a creature object with 1 hp, 0 def, 999 spd, 0 exp, 0 g
	 * */
	Creature(){
		this(1,0,999,0,0);
	}
	/**
	 * Creates a creature object
	 * @param hp creature's hp
	 * @param def creature's def
	 * @param spd creature's spd
	 * @param xp creature's xp
	 * @param g creature's g
	 * */
	Creature(int hp, int def, int spd, int xp, int g){
		this.hp = hp;
		maxHp = hp;
		this.def = def;
		this.spd = spd;
		this.xp = xp;
		this.g = g;
	}
	/**
	 * Returns the name of this enum constant, as contained in the declaration
	 * @return the name of this enum constant
	 * */
	public String toString(){
		String result = super.toString();
		return result.replace('_', ' ');
	}
	/**@return creature's HP*/
	public int getHp() {
		return hp;
	}
	/**
	 * Sets creature's HP
	 * @param hp creature's HP
	 * */
	public void setHp(int hp) {
		this.hp = hp;
	}
	/**@return creature's max HP*/
	public int getMaxhp() {
		return maxHp;
	}
	/**@return creature's defense*/
	public int getDef() {
		return def;
	}
	/**
	 * Sets creature's defense
	 * @param def creature's defense
	 * */
	public void setDef(int def) {
		this.def = def;
	}
	/**@return creature's speed*/
	public int getSpd() {
		return spd;
	}
	/**
	 * Sets creature's speed
	 * @param spd creature's speed
	 * */
	public void setSpd(int spd) {
		this.spd = spd;
	}
	/**@return creature's exp*/
	public int getXp() {
		return xp;
	}
	/**@return creature's gold*/
	public int getG() {
		return g;
	}
	/**@return creature's burn turns*/
	public int getBt() {
		return bt;
	}
	/**
	 * Sets creature's burn turns
	 * @param spd creature's speed
	 * */
	public void setBt(int bt) {
		this.bt = bt;
	}
	/**@return creature's stun turns*/
	public int getSt() {
		return st;
	}
	/**
	 * Sets creature's speed
	 * @param spd creature's speed
	 * */
	public void setSt(int st) {
		this.st = st;
	}
}