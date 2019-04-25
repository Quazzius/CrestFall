package myGame;

public class Enemy
{
	//enemy ability can be 'a' - no status, 'v'- vampirism/ leech, 'p' - poison, or 's' - stun
	private static char enemyAbility;
	//enemy health, minimum damage, maximum damage, minimum chance to hit, maximum chance to hit
	private static int enemyHP, minRange, maxRange, eMinHit, eMaxHit, 
	//minimum value for hero ability to flee, maximum value for hero ability to flee, maximum value for random chance to hit enemy
	minFlee, maxFlee, heroHit, 
	// gold won from battle, points awarded from battle
	rewardGold, rewardPoints;
	//name of enemy, attack style, text to describe enemy death, reward flavor text, enemy introduction text
	private static String eType, aType, killText, deathFlavor, text;

	// constructor creates initial enemy objects
	public Enemy(String text1, char ability, int eHP, String eType1, String aType1, String kText, String dFlavor,
			int mRange, int maRange, int eMHit, int eMaHit, int eMFlee, int eMaFlee, int hHit, int rGold, int rPoints)
	{

		text = text1;
		enemyAbility = ability;
		enemyHP = eHP;
		eType = eType1;
		aType = aType1;
		killText = kText;
		deathFlavor = dFlavor;
		minRange = mRange;
		maxRange = maRange;
		eMinHit = eMHit;
		eMaxHit = eMaHit;
		minFlee = eMFlee;
		maxFlee = eMaFlee;
		heroHit = hHit;
		rewardGold = rGold;
		rewardPoints = rPoints;
	}
	
	//call current enemy values
	//for use on battle sequence
	public Enemy(Enemy enemyType) {
		
		text = enemyType.getText();
		enemyAbility = enemyType.getEnemyAbility();
		enemyHP = enemyType.getEnemyHP();
		eType = enemyType.geteType();
		aType = enemyType.getaType();
		killText = enemyType.getKillText();
		deathFlavor = enemyType.getDeathFlavor();
		minRange = enemyType.getMinRange ( );
		maxRange = enemyType.getMaxRange ( );
		eMinHit = enemyType.geteMinHit ( );
		eMaxHit = enemyType.geteMaxHit ( );
		minFlee = enemyType.getMinFlee();
		maxFlee = enemyType.getMaxFlee();
		heroHit = enemyType.getHeroHit();
		rewardGold = enemyType.getRewardGold();
		rewardPoints = enemyType.getRewardPoints();
	}

	//Enemies and their different attributes sent to constructor
	//all enemies use the same basic principles
	//this one is explained in detail
	public static Enemy bear( )
	{

		text = "You stumbled accross a Bear..."; // Bear fight
		enemyAbility = 'a'; // enemy special ability class (none in this case)
		enemyHP = 12; // enemy health initialize
		eType = "Bear"; // type of enemy
		aType = " Swipes"; // attack style
		killText = "You killed a "; // type of death
		deathFlavor = "! +5 gold for some reason"; // flavor text on enemy death
		minRange = 3; // enemy min damage range;
		maxRange = 6; // enemy max damage range;
		eMinHit = 4;  // enemy min chance to hit
		eMaxHit = 10; // enemy max chance to hit
		minFlee = 4; // min chance to flee from enemy
		maxFlee = 8; // max chance to flee from enemy
		heroHit = 8; // chance to hit enemy
		rewardGold = 5; //gold won from fight
		rewardPoints = 50; //points awarded from fight

		//calls constructor 
		Enemy bear = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		
		return bear;
	}
	
	public static Enemy goblins( ) {

		text = "You hear Goblins creeping around"; // goblins
		enemyAbility = 'a';
		enemyHP = 6;
		eType = "Goblins";
		aType = " attack";
		killText = "You killed some ";
		deathFlavor = ". and found 3 gold!";
		minRange = 1;
		maxRange = 5;
		eMinHit = 5;
		eMaxHit = 10;
		minFlee = 5;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 3;
		rewardPoints = 10;

		Enemy goblins = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return goblins;
	}

	public static Enemy elf( ) {
		text = "An Elf appears... to be very Menacing!"; // elf
		enemyAbility = 'a';
		enemyHP = 8;
		eType = "Crazy Elf";
		aType = " attacks";
		killText = "You killed a ";
		deathFlavor = ". and robbed his corpse of 6 gold! Awesome!";
		minRange = 3;
		maxRange = 5;
		eMinHit = 6;
		eMaxHit = 10;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 6;
		rewardPoints = 30;

		Enemy cElf = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return cElf;
}

	public static Enemy nBums( ) {
		text = "Two Naked Bums jump out at you from the ditch!"; // bums
		enemyAbility = 'a';
		enemyHP = 12;
		eType = "Wild twins";
		aType = " attack";
		killText = "You killed two ";
		deathFlavor = "! They each had 2 coins stashed... somewhere. + 4 gold";
		minRange = 1;
		maxRange = 6;
		eMinHit = 4;
		eMaxHit = 10;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 4;
		rewardPoints = 25;

		Enemy nBums = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return nBums;
	}

	public static Enemy bandit( ) {
		text = "It was a ruse!"; // bandit
		enemyAbility = 'a';
		enemyHP = 8;
		eType = "Bandit";
		aType = " attacks";
		killText = "You killed a ";
		deathFlavor = "! And robbed his corpse of 6 gold! Nice...";
		minRange = 4;
		maxRange = 6;
		eMinHit = 4;
		eMaxHit = 10;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 6;
		rewardPoints = 30;

		Enemy bandit = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return bandit;
	}

	public static Enemy marauder( ) {
		text = "A dark figure on a horse approaches..."; // Marauder
		enemyAbility = 'a';
		enemyHP = 10;
		eType = "Marauder";
		aType = " attacks";
		killText = "You killed a ";
		deathFlavor = " and took his purse, but his horse ran away. + 7 gold";
		minRange = 5;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 10;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 8;
		rewardGold = 7;
		rewardPoints = 40;

		Enemy marauder = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return marauder;
	}

	public static Enemy wolves( ) {
		text = "A small pack of wolves surround you!"; // wolf pack
		enemyAbility = 'a';
		enemyHP = 15;
		eType = "Wolves";
		aType = " attack";
		killText = "You killed a small pack of ";
		deathFlavor = " and find their previous victim's bones nearby. +5 gold";
		minRange = 2;
		maxRange = 7;
		eMinHit = 4;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 5;
		rewardPoints = 30;

		Enemy wolves = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return wolves;
	}

	public static Enemy vWolves( ) {
		text = "A vicious looking pack of wolves surround you!"; // vicious wolf pack
		enemyAbility = 'a';
		enemyHP = 20;
		eType = "Wolves";
		aType = " attack";
		killText = "You killed a viscious pack of ";
		deathFlavor = " and find their previous victim's bones nearby. +7 gold";
		minRange = 3;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 7;
		rewardPoints = 40;

		Enemy vWolves = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return vWolves;
	}

	public static Enemy wraith( ) {
		text = "It was a ruse!"; // wrait
		enemyAbility = 'a';
		enemyHP = 18;
		eType = "Wraith";
		aType = " attacks";
		killText = "You killed a ";
		deathFlavor = "! It dropped a garnet worth 8 gold, Nice...";
		minRange = 4;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 8;
		rewardPoints = 50;

		Enemy wraith = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return wraith;
	}

	public static Enemy mudMan( ) {
		text = "A MudMan grows rapidly in front of you like an Oozing pillar "; // MudMan
		enemyAbility = 'a';
		enemyHP = 14;
		eType = "MudMan";
		aType = " attacks";
		killText = "You killed a ";
		deathFlavor = "! It has some coins stuck to it. + 5 gold";
		minRange = 3;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 8;
		rewardGold = 5;
		rewardPoints = 40;

		Enemy mudMan = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return mudMan;
	}

	public static Enemy pooPoo( ) {
		text = "A PooPoo Man plops in front of you from seemingly nowhere. "; // MudMan
		enemyAbility = 'a';
		enemyHP = 20;
		eType = "PooPoo";
		aType = " lunges";
		killText = "You squash the huge ";
		deathFlavor = ". It has some coins stuck in it. + 8 gold";
		minRange = 3;
		maxRange = 9;
		eMinHit = 6;
		eMaxHit = 11;
		minFlee = 6;
		maxFlee = 6;
		heroHit = 8;
		rewardGold = 8;
		rewardPoints = 70;

		Enemy pooPoo = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return pooPoo;
	}

	public static Enemy leech( ) {
		text = "A Giant Leech! Disgusting!"; // leech
		enemyAbility = 'v';
		enemyHP = 14;
		eType = "Leech";
		aType = " bites";
		killText = "You Skewer the Giant ";
		deathFlavor = ". Gross! it expells 6 gold";
		minRange = 3;
		maxRange = 8;
		eMinHit = 4;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 6;
		rewardPoints = 35;

		Enemy leech = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return leech;
	}

	public static Enemy mLeech( ) {
		
		text = "A Massive Leech! Horrifying!"; // leech
		enemyAbility = 'v';
		enemyHP = 20;
		eType = "Leech";
		aType = " bites";
		killText = "You Fillet the Massive ";
		deathFlavor = ". Gross! it expells 10 gold";
		minRange = 4;
		maxRange = 9;
		eMinHit = 4;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 10;
		rewardPoints = 80;

		Enemy mLeech = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return mLeech;
	}
	
	public static Enemy rWraith( ) {
		text = "It was a ruse!"; // rotten wraith
		enemyAbility = 'a';
		enemyHP = 24;
		eType = "Rotten Wraith";
		aType = " swipes";
		killText = "You killed a ";
		deathFlavor = "! It dropped a garnet worth 8 gold, Nice...";
		minRange = 4;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 8;
		rewardPoints = 80;

		Enemy rWraith = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return rWraith;
	}

	public static Enemy thief( ) {
		text = "You hear a faint sound and turn in time to see a thief cutting your purse!"; // thief
		enemyAbility = 'a';
		enemyHP = 15;
		eType = "Thief";
		aType = " attacks";
		killText = "You kill the ";
		deathFlavor = ". His purse was pretty light. + 5 gold";
		minRange = 4;
		maxRange = 6;
		eMinHit = 4;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 5;
		rewardPoints = 40;

		Enemy thief = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return thief;
	}
	
	public static Enemy thrall( ) {
		text = "It was a ruse!\nThere are 3 haggard looking people with empty looking eyes standing near the cart\n" // thralls
				+ "The \"man in need\" was a Necromancer!  His thralls quickly saunter your way.";
		enemyAbility = 'a';
		enemyHP = 20;
		eType = "Thrall";
		aType = " lunges";
		killText = "You killed the necromancers ";
		deathFlavor = "s. But the Necromancer disappeared...\nLooking through his useless cart you find 12 gold! Nice!";
		minRange = 3;
		maxRange = 9;
		eMinHit = 4;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 12;
		rewardPoints = 60;

		Enemy thrall = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return thrall;
	}

	public static Enemy wyvren( ) {
		text = "You hear an Eagle screech... nope, thats a Wyvren! "; // Wyvren
		enemyAbility = 'a';
		enemyHP = 25;
		eType = "Wyvren";
		aType = " claws";
		killText = "You killed a ";
		deathFlavor = "! WOW! you cut open its belly and find 11 gold!";
		minRange = 5;
		maxRange = 9;
		eMinHit = 4;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 4;
		heroHit = 8;
		rewardGold = 11;
		rewardPoints = 100;

		Enemy wyvren = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return wyvren;
	}

	public static Enemy fSprite( ) {
		text = "The surrounding rocks shimmer... A Fire Sprite floats closer"; // fireSprite
		enemyAbility = 'a';
		enemyHP = 30;
		eType = "Fire Sprite";
		aType = " throws fireball ";
		killText = "You extinguish the ";
		deathFlavor = "\n and find a hot ruby melting its way through the snow. +15 gold";
		minRange = 5;
		maxRange = 9;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 15;
		rewardPoints = 125;

		Enemy fSprite = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return fSprite;
	}
	
	public static Enemy mimic( ) {
		text = "It's a Mimic!"; // mimic
		enemyAbility = 'a';
		enemyHP = 35;
		eType = "Mimic";
		aType = " chomps";
		killText = "You killed a ";
		deathFlavor = "!\nYou open its skull, which resembles a chest, and find a Diamond! + 20 gold";
		minRange = 5;
		maxRange = 7;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 150;

		Enemy mimic = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return mimic;
	}

	public static Enemy mTroll( ) {
		text = "The ground quakes and a Mountain Troll lurches toward you. "; // mountain troll
		enemyAbility = 'a';
		enemyHP = 50;
		eType = "Mountain Troll";
		aType = " clubs you";
		killText = "You killed a ";
		deathFlavor = "! WOW\nIts pouch holds 20 gold, Awesome!";
		minRange = 6;
		maxRange = 8;
		eMinHit = 4;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 6;
		heroHit = 8;
		rewardGold = 20;
		rewardPoints = 140;

		Enemy mTroll = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return mTroll;
	}

	public static Enemy bat( ) {
		text = "The sky darkens. You look above to see a colony of thirsty Vampire Bats"; // bats
		enemyAbility = 'v';
		enemyHP = 30;
		eType = "Vampire Bat";
		aType = " swoops";
		killText = "You slaughter the colony of ";
		deathFlavor = "s and find 13 gold on a nearby corpse.";
		minRange = 5;
		maxRange = 5;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 13;
		rewardPoints = 120;

		Enemy bat = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return bat;
	}

	public static Enemy eBat( ) {
		text = "The sky darkens. You look above to see an enormous colony of thirsty Vampire Bats"; // big bats
		enemyAbility = 'v';
		enemyHP = 40;
		eType = "Vampire Bat";
		aType = " swoops";
		killText = "You slaughter the colony of ";
		deathFlavor = "s and find 13 gold on a nearby corpse.";
		minRange = 6;
		maxRange = 5;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 13;
		rewardPoints = 140;

		Enemy eBat = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return eBat;	
	}
	
	public static Enemy gBat() {
		text = "The cry of a hundred Giant Vampire bats ring though the cave" ; // gbat
		enemyAbility = 'v';
		enemyHP = 50;
		eType = "Giant Vampire Bat";
		aType = " swoops";
		killText = "You slaughter the colony of ";
		deathFlavor = "s and find a stash of 25 gold along with a bottle of Snake Oil!";
		minRange = 6;
		maxRange = 6;
		eMinHit = 6;
		eMaxHit = 13;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 10;
		rewardGold = 25;
		rewardPoints = 200;
		Enemy gBat = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return gBat;
		
	}

	public static Enemy fern( ) {
		text = "The nerby ferns begin to hiss. They uproot themselves and lash at you with their barbed stolons"; // Ferns
		enemyAbility = 'a';
		enemyHP = 30;
		eType = "Fern Feind";
		aType = " whips ";
		killText = "You dice the ";
		deathFlavor = "s and clip their buds worth 5 gold a piece. +15 gold";
		minRange = 5;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 15;
		rewardPoints = 125;

		Enemy fern = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return fern;
	}

	public static Enemy zombie( ) {
		text = "You uncover a rotting corpse... It opens its eyes and grabs you!"; // zombie
		enemyAbility = 'a';
		enemyHP = 35;
		eType = "Zombie";
		aType = " claws";
		killText = "You Decapitated a ";
		deathFlavor = "!\n20 gold shine in the bottom of the hole. +20  gold";
		minRange = 6;
		maxRange = 7;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 150;

		Enemy zombie = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return zombie;
	}

	public static Enemy panther( ) {
		text = "Something has been stalking you... "; // Panther
		enemyAbility = 'a';
		enemyHP = 40;
		eType = "Panther";
		aType = " claws";
		killText = "You killed a ";
		deathFlavor = "! panther eyes are worth 10 gold each. +20 gold";
		minRange = 6;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 6;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 140;

		Enemy panther = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return panther;
	}
	public static Enemy viper(){
		text = "A giant snake drops out of the canopy! "; // snake
		enemyAbility = 'p';
		enemyHP = 40;
		eType = "Viper";
		aType = " Strikes";
		killText = "You decapitate the ";
		deathFlavor = " and cut open its stomach revealing a team of cadavers along with 15 gold";
		minRange = 6;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 6;
		maxFlee = 11;
		heroHit = 9;
		rewardGold = 15;
		rewardPoints = 160;
		
		Enemy viper = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return viper;
	}


	public static Enemy malboro( ) {
		text = "A leafy tentacle strikes at you form the thick shrubbery\nan octopus-like plant wants to devour you!"; // malboro
		enemyAbility = 'p';
		enemyHP = 45;
		eType = "Malboro";
		aType = " swats";
		killText = "You slay the ";
		deathFlavor = ". upon death it spews 25 gold.";
		minRange = 7;
		maxRange = 6;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 25;
		rewardPoints = 150;

		Enemy malboro = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return malboro;
	}

	public static Enemy litchling( ) {
		text = "The mist thickens into fog, and suddenly a pale figure is right in front of you"; // litchling
		enemyAbility = 'v';
		enemyHP = 35;
		eType = "Litchling";
		aType = " claws ";
		killText = "You stab the ";
		deathFlavor = " through the heart and cut off its head. Gross.\nIt was wearing a sapphire pendant. +20 Gold! ";
		minRange = 4;
		maxRange = 9;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 175;

		Enemy litchling = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange,
				maxRange, eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return litchling;
	}

	public static Enemy mCrows( ) {
		text = "There are about 100 crows in the tree, and theyre pissed!"; // murder crows
		enemyAbility = 'a';
		enemyHP = 50;
		eType = "Murder Crows";
		aType = " dive bomb ";
		killText = "You Murdered a Murder of ";
		deathFlavor = "!\nThere is a small hole in the base of the tree and you find 25 gold\nanlong with a bottle of Snake Oil!";
		minRange = 5;
		maxRange = 6;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 25;
		rewardPoints = 150;

		Enemy mCrows = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return mCrows;
	}
	
	public static Enemy banshee( ) {
		text = "A Horrible Scream stops you in your tracks..."; // banshee
		enemyAbility = 'a';
		enemyHP = 55;
		eType = "Banshee";
		aType = " claws";
		killText = "You destroy the ";
		deathFlavor = " and collect the bashee ash. +18 gold";
		minRange = 5;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 18;
		rewardPoints = 140;

		Enemy banshee = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return banshee;
	}

	public static Enemy aElemental( ) {
		text = "The mist ahead of you begins to bind cohesively. A figure forms and floats closer"; // air elemental
		enemyAbility = 'a';
		enemyHP = 45;
		eType = "Air Elemental";
		aType = " gusts ";
		killText = "You dissipate the ";
		deathFlavor = " and coins drop from the mist... huh? + 20 coins";
		minRange = 7;
		maxRange = 5;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 150;

		Enemy aElemental = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange,
				maxRange, eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return aElemental;
	}
	
	public static Enemy cScorpion( ) {
		text = "The ground explodes in front of you and a glistening insect crawls from the chasm"; // scorpion
		enemyAbility = 'p';
		enemyHP = 35;
		eType = "Crystal Scorpion";
		aType = " Stings";
		killText = "You crush the ";
		deathFlavor = " and find it has a diamond for a heart. +17 Gold! ";
		minRange = 5;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 17;
		rewardPoints = 155;

		Enemy cScorpion = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange,
				maxRange, eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return cScorpion;
	}

	public static Enemy phantom( ) {
		text = "It was a Mirage! you've heard stories of the desert phantom..."; // phantom
		enemyAbility = 'a';
		enemyHP = 40;
		eType = "Desert Phantom";
		aType = " Mind flays ";
		killText = "The ";
		deathFlavor = " Disappears without warning!\nYou find yourself standing in an Oasis with a bottle of snake oil\n"
				+ "in one hand and 20 gold coins in the other. Nice!";
		minRange = 6;
		maxRange = 6;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 150;

		Enemy phantom = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return phantom;
	}

	public static Enemy wWisp( ) {
		text = "A ball of blue light hovers above the ground and is coming for you..."; // will-o-the-wisp
		enemyAbility = 'v';
		enemyHP = 40;
		eType = "Will-o'-the-wisp";
		aType = " bludgeons";
		killText = "You defeated a ";
		deathFlavor = "! A Sapphire remains after its flame dissipated. +18 gold";
		minRange = 5;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 18;
		rewardPoints = 140;

		Enemy wWisp = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return wWisp;
	}

	public static Enemy taranTroll( ) {
		text = "A huge hairy boulder lies ahead...? Giant Tarantula! "; // tarantroll
		enemyAbility = 'a';
		enemyHP = 60;
		eType = "TaranTroll";
		aType = " lunges";
		killText = "You Skewer the ";
		deathFlavor = " and claim one of its fangs as a prize + 20 gold";
		minRange = 6;
		maxRange = 7;
		eMinHit = 4;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 175;

		Enemy taranTroll = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange,
				maxRange, eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return taranTroll;
	}

	public static Enemy ants( ) {
		text = "Mother of God! ANTS!"; // ants
		enemyAbility = 'p';
		enemyHP = 40;
		eType = "Komodo Ants";
		aType = " Sting";
		killText = "You grind the ";
		deathFlavor = " into the ground and wipe the sweat from your brow.\n15 Gold falls from the sky. It just does... ";
		minRange = 6;
		maxRange = 5;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 15;
		rewardPoints = 155;

		Enemy ants = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return ants;
	}
	
	public static Enemy doppleganger( ) {
		text = "Someone is walking beside you... for how long?"; // doppleganger
		enemyAbility = 'v';
		enemyHP = 40;
		eType = "Doppleganger";
		aType = " strikes";
		killText = "You Killed a ";
		deathFlavor = "! An amorphous blob is all that remains, along with 18 gold";
		minRange = 6;
		maxRange = 6;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 18;
		rewardPoints = 150;

		Enemy doppleganger = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange,
				maxRange, eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return doppleganger;
	}

	public static Enemy miniBears( ) {
		text = "A swarm of winged miniature bears burst from the ground! "; // miniBears
		enemyAbility = 'a';
		enemyHP = 50;
		eType = "MiniBears";
		aType = " Bite";
		killText = "You Murder the viscious ";
		deathFlavor = ". You notice later that your purse is heavier + 20 gold";
		minRange = 5;
		maxRange = 8;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 9;
		rewardGold = 20;
		rewardPoints = 175;

		Enemy miniBears = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange,
				maxRange, eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return miniBears;
	}

	public static Enemy hWitch( ) {
		text = "You smell something delicious and your mind drifts... you're all of a sudden eye-to-eye with an Old Hag"; // hag
																																								// witch
		enemyAbility = 's';
		enemyHP = 50;
		eType = "Hag Witch";
		aType = " Strikes";
		killText = "The ";
		deathFlavor = " shrivels up and smolders to ash. You search its camp and find 25 gold.";
		minRange = 6;
		maxRange = 7;
		eMinHit = 6;
		eMaxHit = 13;
		minFlee = 6;
		maxFlee = 8;
		heroHit = 10;
		rewardGold = 25;
		rewardPoints = 220;

		Enemy hWitch = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return hWitch;
	}

	public static Enemy mushMan( ) {
		text = "A cloud of spores floats by and a MushMan hops your way"; // MushMan
		enemyAbility = 'p';
		enemyHP = 50;
		eType = "MushMan";
		aType = " strikes";
		killText = "You Killed a ";
		deathFlavor = " and now feel kind of sad, until you find 25 gold! ";
		minRange = 6;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 10;
		rewardGold = 25;
		rewardPoints = 200;

		Enemy mushMan = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return mushMan;
	}

	public static Enemy centaur( ) {
		text = "You hear a horse running nearby and look to see it's holding a spear "; // centaur
		enemyAbility = 'a';
		enemyHP = 60;
		eType = "Centaur";
		aType = " Attacks";
		killText = "You Murder the ";
		deathFlavor = ". Its satchel holds a bar of gold. +30 gold!";
		minRange = 6;
		maxRange = 9;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 9;
		heroHit = 10;
		rewardGold = 30;
		rewardPoints = 250;

		Enemy centaur = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return centaur;
	}

	public static Enemy drunkass( ) {
		text = "A fight started up outside the pub \n and some Drunkass threw his tankard at you..."; // drunkass
		enemyAbility = 'a';
		enemyHP = 25;
		eType = "Drunkass";
		aType = " swings";
		killText = "You knocked out that worthless ";
		deathFlavor = "\n and pick up the gold tooth you knocked out of his mouth. +10 gold.";
		minRange = 5;
		maxRange = 8;
		eMinHit = 3;
		eMaxHit = 11;
		minFlee = 3;
		maxFlee = 8;
		heroHit = 8;
		rewardGold = 10;
		rewardPoints = 80;

		Enemy drunkass = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return drunkass;
	}

	public static Enemy gVandal( ) {
		text = "You come accross two Greasy Vandals attempting an unsavory act upon a young lady\n" // greasy vandals
				+ "You meet their eyes and your fist clenches your blade";
		enemyAbility = 'a';
		enemyHP = 45;
		eType = "Greasy Vandal";
		aType = " slashes";
		killText = "You killed a couple of ";
		deathFlavor = "s and save the girl!\nShe is shaken, but thanks you and gives you a kiss on the cheek\n"
				+ "It felt so wonderful you breifly closed your eyes\n When you opened them she was gone\n +25 Max HP";
		minRange = 5;
		maxRange = 10;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 0;
		rewardPoints = 250;

		Enemy gVandal = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return gVandal;
	}

	public static Enemy sRat( ) {
		text = "Its a Giant Sewer Rat! "; // Sewer Rat
		enemyAbility = 'a';
		enemyHP = 25;
		eType = "Sewer Rat";
		aType = " bites";
		killText = "You killed a Giant ";
		deathFlavor = "! Gross!\nOne of the locals witnessed your heroic deed and hands you 15 gold";
		minRange = 5;
		maxRange = 6;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 6;
		heroHit = 9;
		rewardGold = 15;
		rewardPoints = 250;
		Enemy sRat = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return sRat;
	}

	public static Enemy cultist( ) {
		text = "A robed figure leaps from the shadows and stabs at you without warning"; // cultist
		enemyAbility = 'v';
		enemyHP = 20;
		eType = "Cultist";
		aType = " stabs wildly";
		killText = "You decapitate the ";
		deathFlavor = " of Chaos...\ntheir purse holds 12 gold.";
		minRange = 5;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 8;
		rewardGold = 12;
		rewardPoints = 110;
		Enemy cultist = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return cultist;
	}
	public static Enemy scarabs() {
		text = "Shuffling sounds grow louder... "; // scarabs
		enemyAbility = 's';
		enemyHP = 50;
		eType = "Scarabs";
		aType = " Sting";
		killText = "You grind the ";
		deathFlavor = " into the ground and wipe the sweat from your brow.\n"
				+ "22 Gold lies in front of you surrounded by a broken clay pot . + 22 gold";
		minRange = 6;
		maxRange = 7;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 4;
		maxFlee = 8;
		heroHit = 10;
		rewardGold = 22;
		rewardPoints = 165;
		
		Enemy scarabs = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return scarabs;
	
	}
	public static Enemy pViper() { //pit viper
		text = "Snakes!";
		enemyAbility = 'p';
		enemyHP = 55;
		eType = "Pit Viper";
		aType = " Strikes ";
		killText = "You tear through the  ";
		deathFlavor = "s\nYou reach into the hole and find 25 gold\nanlong with a bottle of Snake Oil!";
		minRange = 6;
		maxRange = 7;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 10;
		rewardGold = 25;
		rewardPoints = 200;
		Enemy pViper = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return pViper;
	
	}
	
	public static Enemy spectre() {
		text = "A helpless moaning wafts through the air and a ghastly Spectre glides through the wall"; //spectre
		enemyAbility = 'a';
		enemyHP = 60;
		eType = "Spectre";
		aType = " Attacks";
		killText = "The ";
		deathFlavor = " vanishes and you're left dissatisfied, though an empty casket holds 18 gold.";
		minRange = 6;
		maxRange = 7;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 10;
		rewardGold = 18;
		rewardPoints = 220;
		Enemy spectre = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return spectre;
	
	}
		
	
	public static Enemy chimera() {
		text = "It looks like a large bat is flying overhead\n"
				+ "The image grows larger and the creature emits a primal roar"; // chimera
		enemyAbility = 'p';
		enemyHP = 65;
		eType = "Chimera";
		aType = " Attacks";
		killText = "The ";
		deathFlavor = " unleashes a gutteral scream and falls. You take its whiskers worth 24 gold.";
		minRange = 5;
		maxRange = 8;
		eMinHit = 5;
		eMaxHit = 13;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 10;
		rewardGold = 24;
		rewardPoints = 220;
		Enemy chimera = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return chimera;
	
	}
	
	public static Enemy stoneGolem() {
		text = "The ground shakes and a lone Colossal Stone statue makes its way toard you"; //Stone Golem
		enemyAbility = 'a';
		enemyHP = 80;
		eType = "Stone Golem";
		aType = " Swings";
		killText = "The ";
		deathFlavor = " crumbles, leaving a pile of rubble. In the rubble you find some gold ore. + 30 gold.";
		minRange = 7;
		maxRange = 9;
		eMinHit = 5;
		eMaxHit = 11;
		minFlee = 5;
		maxFlee = 7;
		heroHit = 10;
		rewardGold = 30;
		rewardPoints = 240;
		Enemy stoneGolem = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return stoneGolem;
	}
	
	public static Enemy chaosElemental() {
		text = "A rift opens suddenly and a ball of white hot gas emerges"; //Chaos elemental
		enemyAbility = 'a';
		enemyHP = 60;
		eType = "Chaos Elemental";
		aType = " Burns";
		killText = "You slash the ";
		deathFlavor = " and it implodes. A void opens and pulls you forward.\n"
				+ "you use all of your might to pull yourself away.\nYou then gather yourself and find gold ore lodged in a crevase + 28 gold.";
		minRange = 7;
		maxRange = 8;
		eMinHit = 7;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 8;
		heroHit = 10;
		rewardGold = 28;
		rewardPoints = 250;
		Enemy chaosElemental = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return chaosElemental;
	
	}
	public static Enemy omegaTroll() {
		text = "It sounds like a landslide ahead and you see an enormous leg that preceeds an enormous Troll\n"
				+ "Thankfully It seems to move more slowly than normal";                                                    //Omega Troll
		enemyAbility = 'a';
		enemyHP = 80;
		eType = "Omega Troll";
		aType = " Clubs";
		killText = "You bleed the ";
		deathFlavor = " to death and catch your breath.\nYou take its purse and find 40 gold.";
		minRange = 7;
		maxRange = 10;
		eMinHit = 4;
		eMaxHit = 13;
		minFlee = 6;
		maxFlee = 6;
		heroHit = 10;
		rewardGold = 40;
		rewardPoints = 275;
		Enemy omegaTroll = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return omegaTroll;
	
	}
	public static Enemy sandMan() {
		text = "A horrifying chuckle arises from the surrounding air and sends a chill up your spine"; //Sandman
		enemyAbility = 's';
		enemyHP = 70;
		eType = "Sandman";
		aType = " Attacks";
		killText = "You swing at the ";
		deathFlavor = " and it vanishes leaving you dissatisfied.\nYou gather yourself and the gold powder left behind + 28 gold.";
		minRange = 5;
		maxRange = 7;
		eMinHit = 7;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 6;
		heroHit = 10;
		rewardGold = 28;
		rewardPoints = 175;
		Enemy sandMan = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return sandMan;
	
	}
	
	public static Enemy fBat() {
		text = "The sky lights up with a cacophony of flames flapping overhead! "; //fire bat
		enemyAbility = 'v';
		enemyHP = 60;
		eType = "Fire Bat";
		aType = " Swoops";
		killText = "You defend yourself from the ";
		deathFlavor = "s and the rest of them dissappear into a crevasse.\n"
				+ "You find more gold ore as you catch your breath+ 30 gold.";
		minRange = 7;
		maxRange = 6;
		eMinHit = 7;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 6;
		heroHit = 10;
		rewardGold = 30;
		rewardPoints = 220;
		Enemy fBat = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
	return fBat;
	
	}
	
	public static Enemy litchKing( ) {
		text = "You approach the Sarcophagus and see that the lid is slightly ajar.\n" //litch king
				+ "As you begin to exhune this potentially unknown corpse, the lid blows clear off\n"
				+ "and though the settling dust you see a terrifying pale creature rise\n"
				+ "in still motion and hangs calmly for a moment before revealing its fangs.\n"
				+ "Have at you! Regen 50% MaxHP" ;
		enemyAbility = 'v';
		enemyHP = 110;
		eType = "Litch King";
		aType = " Attacks";
		killText = "The eyes of the  ";
		deathFlavor = " grow wide as you push your blade though its heart.\n"
				+ "After removing its head and setting it on fire for good measure,\n"
				+ "you take a look in the Sarcophagus and see a blood red bangle laying next to\n"
				+ "a dusty pair of spectacles. You try on the bangle and your blood catches a chill.\n"
				+ "You feel thirsty..." + "+25 max HP. HP fully restored! + 50 gold.\n"
				+ "You try on the spectacles and nothing happens so you store them away";
		minRange = 7;
		maxRange = 10;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 8;
		heroHit = 10;
		rewardGold = 50;
		rewardPoints = 800;
		Enemy litchKing = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return litchKing;
	}
		
		
	public static Enemy gryphon( ) {
		text = "You peer out over the edge of the cliff at the vast ocean with rolling waves\n"    //gryphon
					+ "crashing on the rugged coast. You also notice a necklace with a Locket dangling\n"
					+ "from a dead branch below your feet... You also notice a Gryphon staring back at you.\n"
					+ "Have at you! Regen 50% MaxHP";
		enemyAbility = 'a';
		enemyHP = 120;
		eType = "Gryphon";
		aType = " Strikes";
		killText = "You decapitate the once Glorious ";
		deathFlavor = " and drop to your knees from exhaustion.\n"
				+ "The Locket you witnessed is floating at eye level when you turn around.\n"
				+ "It is Ice cold to the touch and resembles a key."
				+ "+10 max HP. HP fully restored! + 40 gold.";
		minRange = 7;
		maxRange = 9;
		eMinHit = 6;
		eMaxHit = 12;
		minFlee = 6;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 40;
		rewardPoints = 600;
		Enemy gryphon = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return gryphon;
	}
		
		
	public static Enemy horde( ) {	
		text = "As you approach the glow, a mass of skeletons is uncovered from the mist.\n "    //necro Horde
				+ "Their gaze is fixated on a floating jewel, which you imagine is important somehow.\n"
				+ "Suddenly one of the skeletons turns toward you!\n"
				+ "Have at you! Regen 50% MaxHP";
		enemyAbility = 'a';
		enemyHP = 120;
		eType = "Necro Horde";
		aType = " attacks";
		killText = "You slice through the last of the ";
		deathFlavor = " and drop to your knees from exhaustion.\n"
				+ "The jewel dims its light and drops from the air\n"
				+ "When you pick it up you can see that it is a diamond in the shape of a key...\n"
				+ "+10 max HP. HP fully restored! + 40 gold.";
		minRange = 7;
		maxRange = 9;
		eMinHit = 5;
		eMaxHit = 13;
		minFlee = 6;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 40;
		rewardPoints = 600;
		Enemy horde = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return horde;
	}
	
	
	public static Enemy chaosDemon() {	                             //chaos Demon
		text = "\"" + Var.getPlayer ( ) + "!\"\nYou stop in your tracks and regain your own sight, now realizing that you had lost it\n"
				+ "Filling your gaze is a huge creature, nearly as tall as a mountain troll.\n"
				+ "It looks like it is made of molten rock and its features are constantly shifting\n"
				+ "though constantly righting themselves as well.\n"
				+ "Chaos Demon: \"" + Var.getPlayer ( ) + ", have you come all this way to seek revenge for your village in the forest?\n"
				+ "I am merely an agent of Chaos and make no decision against fate.\n"
				+ "But I can see into your mind and know that you desire revenge more than your life...\n"
				+ "Have at you!\"  Regen 50% MaxHP";
		enemyAbility = 'a';
		enemyHP = 90;
		eType = "Chaos Demon";
		aType = " attacks";
		killText = "You swing!... and your blade cuts through empty air, at the same time\n"
				+ "an intense gust of wind throws you forward violently...\nThe ";
		deathFlavor = " imploded! Only a hot lump of glowing ore remains.\n"
				+ "A small piece of glowing ore has broken apart from the rest and you pick it up\n"
				+ "It is extremely heavy for its size and you feel a part of yourself being tied to this small gem\n"
				+ "+25 Max HP. HP fully restored! + 50 gold.";
		minRange = 6;
		maxRange = 12;
		eMinHit = 5;
		eMaxHit = 12;
		minFlee = 5;
		maxFlee = 8;
		heroHit = 9;
		rewardGold = 50;
		rewardPoints = 500;
		Enemy chaosDemon = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return chaosDemon;
	}

	public static Enemy chaos() {	                                //final boss chaos
		text = "\"" + Var.getPlayer ( ) + "!\"\nYou stop in your tracks and regain your own sight, now realizing that you had lost it again\n"
				+ "Filling your gaze is a huge creature, taller than a mountain troll.\n"
				+ "It looks like it is made of molten rock and its features are constantly shifting...\n"
				+ "This is all too familiar.\n"
				+ "Chaos Demon:  "+ Var.getPlayer ( ) + "... I am Chaos.\n"
				+ "It was Luck that allowed you to destroy my apparition on the Mountain and only by chance\n"
				+ "did a peice of myself bind iteself to yours, which led you to me. Now, finally, you meet your fate.\n"
				+ "\"Have at you!\"  Regen 50% MaxHP";
		enemyAbility = 'a';
		enemyHP = 150;
		eType = "Chaos";
		aType = " attacks";
		killText = "You swing!... and your blade cuts straight through the molten demon\n"
				+ "an intense gust of wind throws you backward violently as\n ";
		deathFlavor = " gazes at the surrounding Earth for its final seconds as a physical body...\n\n"
				+ "You awaken, and are still on the Volcano... How long were you knocked out?\n"
				+ "+25 Max HP. HP fully restored! + 100 gold.";
		minRange = 8;
		maxRange = 9;
		eMinHit = 7;
		eMaxHit = 13;
		minFlee = 5;
		maxFlee = 8;
		heroHit = 10;
		rewardGold = 100;
		rewardPoints = 1000;
		Enemy chaos = new Enemy ( text, enemyAbility, enemyHP, eType, aType, killText, deathFlavor, minRange, maxRange,
				eMinHit, eMaxHit, minFlee, maxFlee, heroHit, rewardGold, rewardPoints );
		return chaos;
	}
	
	//setters update enemy variables
	//getters return current instances of enemy variables
	public char getEnemyAbility( )
	{
		return enemyAbility;
	}

	public void setEnemyAbility( char enemyAbility )
	{
		Enemy.enemyAbility = enemyAbility;
	}

	public int getEnemyHP( )
	{
		return enemyHP;
	}

	public void setEnemyHP( int enemyHP )
	{
		if (enemyHP == 0) {
			Enemy.enemyHP = enemyHP;
		}
		else {
			Enemy.enemyHP += enemyHP;
		}
	}

	public int getMinRange( )
	{
		return minRange;
	}

	public void setMinRange( int minRange )
	{
		Enemy.minRange = minRange;
	}

	public int getMaxRange( )
	{
		return maxRange;
	}

	public void setMaxRange( int maxRange )
	{
		Enemy.maxRange = maxRange;
	}

	public int geteMinHit( )
	{
		return eMinHit;
	}

	public void seteMinHit( int eMinHit )
	{
		Enemy.eMinHit = eMinHit;
	}

	public int geteMaxHit( )
	{
		return eMaxHit;
	}

	public void seteMaxHit( int eMaxHit )
	{
		Enemy.eMaxHit = eMaxHit;
	}

	public int getMinFlee( )
	{
		return minFlee;
	}

	public void setMinFlee( int minFlee )
	{
		Enemy.minFlee = minFlee;
	}

	public int getMaxFlee( )
	{
		return maxFlee;
	}

	public void setMaxFlee( int maxFlee )
	{
		Enemy.maxFlee = maxFlee;
	}

	public int getHeroHit( )
	{
		return heroHit;
	}

	public void setHeroHit( int heroHit )
	{
		Enemy.heroHit = heroHit;
	}

	public int getRewardGold( )
	{
		return rewardGold;
	}

	public void setRewardGold( int rewardGold )
	{
		Enemy.rewardGold = rewardGold;
	}

	public int getRewardPoints( )
	{
		return rewardPoints;
	}

	public void setRewardPoints( int rewardPoints )
	{
		Enemy.rewardPoints = rewardPoints;
	}

	public String geteType( )
	{
		return eType;
	}

	public void seteType( String eType )
	{
		Enemy.eType = eType;
	}

	public String getaType( )
	{
		return aType;
	}

	public void setaType( String aType )
	{
		Enemy.aType = aType;
	}

	public String getKillText( )
	{
		return killText;
	}

	public void setKillText( String killText )
	{
		Enemy.killText = killText;
	}

	public String getDeathFlavor( )
	{
		return deathFlavor;
	}

	public void setDeathFlavor( String deathFlavor )
	{
		Enemy.deathFlavor = deathFlavor;
	}

	public String getText( )
	{
		return text;
	}

	public void setText( String text )
	{
		Enemy.text = text;
	}
}
