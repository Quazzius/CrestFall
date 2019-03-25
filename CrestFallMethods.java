import java.util.Scanner;

public class CrestFallMethods
{
	@SuppressWarnings("unused")
	public static int[] gameArray() {
		int [] a = new int[33];
		int gold, hp, hpMax, minDMG, maxDMG, dex, evade, chapter, ladyOfLake, sSword, lSword, lArmor, mBoots, mDagger, mShield;
		int bSword, hpPot, merchCount, loser, fighter, victim, points, battleDec, city, chaosDemonLife, vRapier, dynamite, cKukri;
		int  hordeLife, griffinLife, pDagger, slArmor;
		char direction;
		a[0] = gold = 0;
		a[1] = hp = 100;
		a[2] = hpMax = 100;
		a[3] = minDMG = 2;
		a[4] = maxDMG = 5;
		a[5] = dex = 7;
		a[6] = evade = 7;
		a[7] = chapter = 1;
		a[8] = ladyOfLake = 1;
		a[9] = sSword = 1;
		a[10] = lSword = 1;
		a[11] = lArmor = 1;
		a[12] = mBoots = 1;
		a[13] = mDagger = 1;
		a[14] = mShield = 1;
		a[15] = bSword = 1;
		a[16] = hpPot = 0;
		a[17] = merchCount = 0;
		a[18] = loser = 0;
		a[19] = fighter = 0;
		a[20] = victim = 1;
		a[21] = points = 0;
		a[22] = battleDec = 0;
		a[23] = city = 9;
		a[24] = chaosDemonLife = 1;
		a[25] = direction = 'N';
		a[26] = vRapier = 1;
		a[27] = dynamite = 0;
		a[28] = cKukri = 1;
		a[29] = hordeLife = 1;
		a[30] = griffinLife = 1;
		a[31] = pDagger = 1;
		a[32] = slArmor = 1;
		return a;	
		}
	public static int[] characterClass(int[] a) {
		Scanner input = new Scanner(System.in);
		System.out.println ( "Pick your class type" ); //character class
		System.out.println ( "1. Hunter (Normal Game)\n2. Fighter (Braun mode) -1 dex, +2 Max DMG\n3. Loser (Hard Mode) -1 dex, -1 evade, -1 Max DMG, +10 Max HP" );
		int playerType = input.nextInt ( );
		if (playerType == 2) {
			a[19] = 1;
			a[5]--;
			a[4] += 2;
		}
		if (playerType == 3) {
			a[18] = 1;
			a[5]--;
			a[6]--;
			a[4]--;
			a[2] += 10;
		}
		
		return a;
	}
	public static int[] warp(int[] a, String player) {
		//warp
		if (player.equals ( "ch2" )) {
			a[7] = 2;
			a[0] = 20;
		}
		if (player.equals ( "ch3" )) {
			a[7] = 3;
			a[3] = 7;
			a[4] = 12;
			a[5] = 8;
			a[6] = 8;
			a[2] = 150;
			a[1] = a[2];
			a[0] = 75;
		}
		return a;
	}
	public static int beginGame( int[ ] a, char forest) {
		Scanner input = new Scanner(System.in);
		System.out.println ( "Your home, the village of Sardina, was just burned to the ground by a forest fire." );
		System.out.println ( "Living in the middle of the forest has its advantages though the closest town is 10 days away on foot." );
		System.out.println ( "You know of a merchant to the SouthWest, but first you mush make your way through the forest to find the road." );
		System.out.println ( "Your only posessions are the clothes on your back and your Splitting Axe (2-5 DMG)." );
		if(a[19] == 1) {
			System.out.println ( "You have a lifetime of fighting experince + 2 Max DMG\n But your large stature leaves you less nimble -1 a[5]" );
		}
		if (a[18] == 1) {
			System.out.println ( "You're a loser so you kind of suck at everything -1 dex, -1 evade, -1 Max DMG\n But a lifetime of being picked on gives you more resilience + 10 Max HP" );
		}
		System.out.println ( "The only choice you have is to head South, continue? y/n" );
		do  //check character input
		{
			forest = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (forest != 'y' && forest != 'n')  
			{
				System.out.println ( "You must enter y or n, continue?" );
			}
		} while (forest != 'y' && forest != 'n'); 
		
		//endgame statement
		if (forest == 'n')
		{
			System.out.println ( "You decided you would rather just lay down and burn like everything else." );
			a[1] = 0;
		}
		
		return a[1];
	}
	public static int[] battleSequence(int[] a, int hitChance, int hitDMG, int attack, int minRange, int maxRange, String eType, String aType, int eMaxHit, int eMinHit, int areaCount, 
			int enemyHP, int maxFlee, int minFlee, int rewardGold, int rewardPoints, int heroHit, String killText, String deathFlavor, int merch, char enemyAbility) {
		Scanner input = new Scanner(System.in);
		int poisonCount = 0; //initialize hero poisoned counter
		int ePoisonCount = 0; // initialize enemy poisoned counter
		if (a[26] == 0) { //lose max hp to void rapier
			a[2] -= 10;
			if (a[1] > a[2]) {
				a[1] = a[2];
			}
		}
		while (enemyHP > 0)  //fight sequence
		{	
			int damage = (int) ( Math.random ( ) * maxRange + minRange ); //enemy attack range
			System.out.println ( eType + aType + " for " + damage + " damage.");
			hitChance = (int) ( Math.random ( ) * eMaxHit + eMinHit);  //enemy hit chance
			if (a[6] > hitChance) //if evade is greater than hit
			{
				System.out.println ( "But Misses!" );
			}
			else
			{
				a[1] -= damage; //player attacked
				System.out.println ( "-" + damage + " HP. " + "HP is " + a[1] + "/" + a[2]);
				 //if enemy ability type "v" vampirism
				if (enemyAbility == 'v') {  
					double vamp = damage * 0.25;  // heals 25% damage given
					int iVamp = (int) vamp;  // change from double to int
					if (iVamp > 0) {   // output if necessary
						System.out.println ( eType + " heals " + iVamp + " HP" );
						enemyHP += iVamp;
					}
				}
				else if (enemyAbility == 'p' && poisonCount < 1) {
					int poison = (int) (Math.random ( ) * 3 + 1);
					if (poison == 3) {
						System.out.println ( "You're Poisoned!" );
						poisonCount = 3;
					}
				}
				if (a[1] < 1) //on death condition, reset variables to go to game over
				{
					a[7] = 0;
					areaCount = 9;
					enemyHP = 0;
					merch = 0;
					a[23] = 6;
					a[25] = '0';
					
				}
			}
			if (poisonCount > 0 ){
				poisonCount--;
				System.out.println ( "-2 HP (Poison), left: " + poisonCount);
				a[1] -= 2;
				
			}
			  //battle decision
			if (a[1] > 0) {
				System.out.println ( "0 - Flee\n1 - Attack" );
				if (a[7] > 2) {
					System.out.println ( "3 - Dynamite: " + a[27]);
				}
				if (a[7] > 1) {
					System.out.println ( "5 - Health Potion: " + a[16] );
				}
				a[22] = input.nextInt();
				
				//flee
				switch (a[22]) 
				{
					//flee
					case 0:
						hitChance = (int) ( Math.random ( ) * maxFlee + minFlee);  //chance to flee
						if (a[6] > hitChance) {  //flee successful
							System.out.println ( "You run away! Coward!" );
							enemyHP = 0;
						}
						else { //flee unsuccessful
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
						break;
				
					//attack
					case 1:
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);  //possible damage range
						hitChance = (int) ( Math.random ( ) * heroHit + 1);  //chance to hit
						if (a[5] >= hitChance)  //if dex is at least heroHit chance
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							enemyHP -= hitDMG;
							
							//character ability Vamp
							if (a[26] == 0) { 
								System.out.println ( "HP + 1" );
								a[1] += 1;
								if (a[1] > a[2]) { //cant go above max
									a[1] = a[2];
								}
							}
							//character ability poison
							else if (a[28] == 0 && ePoisonCount < 1) {
								int ePoison = (int) (Math.random ( ) * 3 + 1);
								if (ePoison == 3) {
									System.out.println ( eType + " Poisoned!" );
									ePoisonCount = 3;
								}
							}
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
						if (ePoisonCount > 0) {
							System.out.println ( eType + " -2 HP (Poison), Left: " + ePoisonCount );
							enemyHP -= 2;
						}
					break;
						
					case 3:
						if (a[27] > 0) {
							System.out.println ( "You light the wick and toss the dynamite at the " + eType );
							System.out.println ( "dealing 30 damage! The reckless action deals 5 damage to you as well" );
							enemyHP -= 30;
							a[1] -= 5;
							a[27] --;
						}
						else {
							System.out.println ( "Idiot! You have no explosives in your inventory!" );
						}
					break;
					
					//heal
					case 5:
						if (a[16] > 0) {
							if (a[7] > 2) {
								System.out.println ( "Delicious reptile secretions...\n +40 HP" );
								a[16] --;  //used potion
								a[21] -= 40; //lose points for healing
								a[1] += 40; // heal
								if (a[1] > a[2]) {
									a[1] = a[2]; //hp cant be greater than hp max
								}
							}
							else {
								System.out.println ( "That Sauce is Awesome!\n +25 HP" );
								a[16] --;  //used potion
								a[21] -= 25; //lose points for healing
								a[1] += 25; // heal
								if (a[1] > a[2]) {
									a[1] = a[2]; //hp cant be greater than hp max
								}
							}
						}
						else {
							System.out.println ( "Fool! You have no bottles in supply!" );
						}
				}
			}
		}
		if (a[1] > 0 && a[22] != 0) { //make sure hero did not die or flee for reward
			System.out.println ( killText + eType + deathFlavor );
			a[0] += rewardGold; // gold
			a[21] += rewardPoints;  //points
		}
		if (a[26] == 0) {
			a[2] += 10;
		}
		return a;	
	}
	public static int[ ] forest(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack) {
		//Journey through the forest
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		int merch = 0;
		int areaCount = 0;
		System.out.println ( "You begin your journey heading South through the overgrown Elderwood forest" );
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("You stumbled accross a Bear, Fuck" );   //Bear fight
						char enemyAbility = 'a';  //enemy special ability class (a = none)
						int enemyHP = 12;   //enemy health initialize
						String eType = "Bear"; //type of enemy
						String aType = " Swipes";  //attack style
						String killText = "You killed a "; //type of death
						String deathFlavor = "! +5 gold for some reason"; //flavor text on enemy death
						int minRange = 3, maxRange = 8;  // enemy damage range
						int eMinHit = 4, eMaxHit = 10;  // enemy chance to hit
						int minFlee = 4, maxFlee = 8;   // chance to flee from  enemy
						int heroHit = 8;  // chance to hit enemy
						int rewardGold = 5, rewardPoints = 50;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					break;
					
					case 2: 
						System.out.println ("You hear some Goblins creeping around"  );
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					break;
					
					case 3: 
						System.out.println ( "An Elf appears... to be very Menacing!" );
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);

				}
			}
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue South" );
				KeyIn.nextLine ( );
			}
		}
		return a;
	}
	
	public static int roadFork (int [] a) {
			Scanner input = new Scanner(System.in);
			Scanner KeyIn = new Scanner(System.in);
			System.out.println ( "You find the road after 3 days and shortly thereafter come to a Fork." );
			System.out.println ( "You're still alive with " + a[1] + " HP, and " + a[0] + " gold. Cool..." );
			System.out.println ( "press Enter to continue" );
			KeyIn.nextLine ( );
			System.out.println ( "You remember the Merchant Camp being to the West and looks well maintained." );
			System.out.println ( "The road East looks muddy." );
			System.out.println ( "E or W?" );
			
			//Merchant or Swamp?
			char roadFork;
			do  //check character input
			{
				roadFork =  input.next ( ).toUpperCase ( ).charAt ( 0 );
				if (roadFork != 'E' && roadFork != 'W')  
				{
					System.out.println ( "You must enter E or W" );
				}
			} while (roadFork != 'E' && roadFork != 'W'); 
			
			
			return (char)roadFork;	
	}
	
	public static int[ ] merchantRoad(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "The Merchant Camp is 3 days from the fork" );
		System.out.println ( "The road is good for traveling but you have heard there are bandits along these roads" );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		int merch = 0;
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
				case 1: 
					System.out.println ("Two Naked Bums jump out at you from the ditch!" );
					char enemyAbility = 'a';
					int enemyHP = 12;   
					String eType = "Wild twins";
					String aType = " attack";
					String killText = "You killed two ";
					String deathFlavor = "! They each had 2 coins stached... somewhere. + 4 gold";
					int minRange = 1; 
					int maxRange = 6;
					int eMinHit = 4; 
					int eMaxHit = 10;
					int minFlee = 4; 
					int maxFlee = 8;
					int heroHit = 8;
					int rewardGold = 4;
					int rewardPoints = 25;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				
				break;
				
				case 2: 
					System.out.println ("A man is busy mending the wheel for his cart"  ); // cart man/ Bandit
					System.out.println ( "Do you want to help? y/n" );
					char help;
					do  //check character input
					{
						help = input.next ( ).toLowerCase ( ).charAt ( 0 );
						if (help != 'y' && help != 'n')  
						{
							System.out.println ( "You must enter y or n" );
						}
					} while (help != 'y' && help != 'n'); 
					
					if (help == 'n')  //Don't help
					{
						System.out.println ( "Fuck that guy. You keep walking" );
					}
					else
					{
						int ruse =	(int) ( Math.random ( ) * 10);
						if (ruse > 5 )
						{
							System.out.println ( "It was a ruse!" );
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
							a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
								enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
						}
						else
						{
							System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
							System.out.println ( "He gives you 10 gold for your services and company" );
							a[0] += 10;
						}
				
					}
					
				break;
				
				case 3: 
					System.out.println ( "A dark figure on a horse approaches..." );   //Marauder
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
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
			
				}
			
			}
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue West" );
				KeyIn.nextLine ( );
			}
		}
		if (a[1] > 0) {
			a[7] = 2;
		}
		return a;
	} //End Merchant Road
	
	public static int[] swampRoad1 (int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		char enemyAbility;
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "Lets take the muddy road then..." );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "The road meanders to the SouthEast and the air cathces a chill" );
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("A small pack of wolves surround you!" ); //wolf pack
						enemyAbility = 'a';
						int enemyHP = 15;   
						String eType = "Wolves";
						String aType = " attack";
						String killText = "You killed a small pack of ";
						String deathFlavor = " and find their previous victim's bones nearby. +5 gold";
						int minRange = 2; 
						int maxRange = 7;
						int eMinHit = 4; 
						int eMaxHit = 11;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 8;
						int rewardGold = 5;
						int rewardPoints = 30;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2: 
						System.out.println ("Something shiny catches your eye off trail"  ); // jewel/ wraith
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do  //check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if (help != 'y' && help != 'n')  
							{
								System.out.println ( "You must enter y or n" );
							}
						} while (help != 'y' && help != 'n'); 
						
						if (help == 'n')  //Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 4)
							{
								System.out.println ( "It was a ruse!" );
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
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
						
							}
							else 
							{
								System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
								a[0] += 8;
								
							}
					}
					break;
					
					case 3: 
						System.out.println ( "A MudMan grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 4:
						System.out.println ("A Giant Leech! Disgusting!" ); //leech 
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
				}
			} 
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue East" );
				KeyIn.nextLine ( );
			}
		}// end swamp road
		
		return a;	
	}
	public static int[] theLake(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		int areaCount = 0;
		char lake;                                                                              //the lake
		System.out.println ( "You find yourself standing at the edge of a large lake" );
		System.out.println ( "There is only one path leading out and it heads northWest" );
		System.out.println ( "Would you like to look around? y/n" );
		do  //check character input
		{
			lake = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (lake != 'y' && lake != 'n')  
			{
				System.out.println ( "You must enter y or n" );
			}
		} while (lake != 'y' && lake != 'n'); 
		while (lake == 'y')
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: System.out.println ("A viscious looking pack of wolves surround you!" ); //wolf pack
					enemyAbility = 'a';
					int enemyHP = 20;   
					String eType = "Wolves";
					String aType = " attack";
					String killText = "You killed a viscious pack of ";
					String deathFlavor = " and find their previous victim's bones nearby. +7 gold";
					int minRange = 3; 
					int maxRange = 8;
					int eMinHit = 5; 
					int eMaxHit = 11;
					int minFlee = 5; 
					int maxFlee = 7;
					int heroHit = 9;
					int rewardGold = 7;
					int rewardPoints = 40;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2: 
						if (a[8] > 0)
						{
							System.out.println ("You hear someone singing..."  ); 				// Lady of the Lake
							System.out.println ( "Do you want to check it out? y/n" );
							char help;
							do  //check character input
							{
								help = input.next ( ).toLowerCase ( ).charAt ( 0 );
								if (help != 'y' && help != 'n')  
								{
									System.out.println ( "You must enter y or n" );
								}
							} while (help != 'y' && help != 'n'); 
							
							if (help == 'n')  //Don't look
							{
								System.out.println ( "Thats gotta be a trap... Keep wandering aimlessly" );
							}
							else
							{
								System.out.println ( "You found the lady of the lake" );
								System.out.println ( "Her kind and voiceless words heal your wounds. Full HP!" );
								a[1] = a[2];
								System.out.println ( "She hands you a short sword that glows faintly green.\nThe translucent lady disappears upon taking the sword.");
								System.out.println ( "You've acquired PhantomBane! DMG 5-8" );
								System.out.println ( "Do you wish to equip the PhantomBane?\ny/n" );
									do  //check character input
									{
										help = input.next ( ).toLowerCase ( ).charAt ( 0 );
										if (help != 'y' && help != 'n')  
										{
											System.out.println ( "You must enter y or n" );
										}
									} while (help != 'y' && help != 'n');
									if (help == 'y') {
										System.out.println ( "PhantomBane Equipped" );
										a[3] = 5;
										a[4] = 8;
										a[8]--;
										a[26] = 1;
										if (a[19] == 1) {
											a[4] += 2;
										}
										if (a[18] == 1) {
											a[4]--;
										}
										if (a[13] == 0){
											a[3]++;
										}
									}
									else {
										System.out.println ( "The sword fades back into obscurity" );
								}
							}
						}
						else
						{
							System.out.println ( "Here is where you met the lady of the lake" );
							System.out.println ( "You can feel her spirit well up inside of you. Regen 10% MaxHP!" );
							a[1] += a[2] / 10;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
							System.out.println ( "HP= " + a[1] );
						}
						break;
					
					case 3: 
						System.out.println ( "A PooPoo Man plops in front of you from seemingly nowhere. " );   //MudMan
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("A Giant Leech! Gross!" ); //leech 
						enemyAbility = 'v';
						enemyHP = 18;   
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
				}	
			}
			if (a[1] < 1) {
				lake = 'n';
			}
			else {
				System.out.println ( "Keep Searching the Lake?" );
				do  //check character input
				{
					lake = input.next ( ).toLowerCase ( ).charAt ( 0 );
					if (lake != 'y' && lake != 'n')  
					{
						System.out.println ( "You must enter y or n" );
					}
				} while (lake != 'y' && lake != 'n');
			}
		}
		return a;
	}
	
	public static int[] swampRoad2(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		char enemyAbility;
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		a[25] = 'E';
		System.out.println ( "The only road out is northwest to the Merchant Camp" );               //other side of lake
		System.out.println ( "Enter to continue" );
		KeyIn.nextLine();
		System.out.println ( "You now head northWest along another muddy trail." );
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
				case 1:
					System.out.println ("A small pack of wolves surround you!" ); //wolf pack
					enemyAbility = 'a';
					int enemyHP = 15;   
					String eType = "Wolves";
					String aType = " attack";
					String killText = "You killed a small pack of ";
					String deathFlavor = " and find their previous victim's bones nearby. +5 gold";
					int minRange = 2; 
					int maxRange = 7;
					int eMinHit = 4; 
					int eMaxHit = 11;
					int minFlee = 4; 
					int maxFlee = 8;
					int heroHit = 8;
					int rewardGold = 5;
					int rewardPoints = 30;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				break;
				
				case 2: System.out.println ("Something shiny catches your eye off trail"  ); // jewel/ wraith
				System.out.println ( "Do you want to check it out? y/n" );
				char help;
				do  //check character input
				{
					help = input.next ( ).toLowerCase ( ).charAt ( 0 );
					if (help != 'y' && help != 'n')  
					{
						System.out.println ( "You must enter y or n" );
					}
				} while (help != 'y' && help != 'n'); 
				
				if (help == 'n')  //Don't look
				{
					System.out.println ( "Thats gotta be a trap... Keep walking" );
				}
				else
				{
					int ruse =	(int) ( Math.random ( ) * 10);
					if (ruse >= 4)
					{
						System.out.println ( "It was a ruse!" );
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					}
					else 
					{
						System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
						a[0] += 8;
					}
				}
				break;
				
				case 3:
					System.out.println ( "A MudMan grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				break;
				
				case 4: 
					System.out.println ("A Massive Leech! Horrifying!" ); //leech 
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
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
			
				}
			}
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue West" );
				KeyIn.nextLine ( );	
			}
		}// end swamp road 2
		a[25] = 'N';
		a[17] = 0;
		a[7] = 2;
		return a;
	}
	public static int[] merchantHub(int[] a, int hpPotCost, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		if (a[17] == 0)
		{
			if (a[24] == 0) {
				System.out.println ( "You return to the Merchant Camp.\nYou are relieved to be walking amongst others again" );
				System.out.println ( "Recounting the first time making your way to this oasis,\nYou you can't help but feel an emptyness as if you lost a part of yourself on that mountain." );
			}
			System.out.println ( "There are a couple of Vendors hanging about..." );
			System.out.println ( "One of them turns to you and asks \"Are you in need?\" " );
			System.out.println ( "He then unrolls his mat to show you his various wares" );
			System.out.println ( "You hear him whisper what sounds like \"its a secret to everybody\" ");
			a[17]++;
		}
			
		System.out.println ( "What would you like?" );
		int gGameCost = 5;
		System.out.println ( "0 - Guessing Game (5 gold) Double your money and get points!" );
		int sSwordCost = 10;
		System.out.println ( "1 - A reliable steel Short Sword. DMG: 3-6. (10 gold). In Stock: " + a[9] );
		int lSwordCost = 15;
		System.out.println ( "2 - A Heavy Iron Long Sword (-1 dex). DMG 4-9 (15 gold) In Stock: " + a[10] );
		int lArmorCost = 15;
		System.out.println ( "3 - Leather Armour. + 1 evade. (15 gold). InStock: " + a[11]);
		int mBootsCost = 30;
		System.out.println ( "4 - Mercurial Dancing Boots. + 1 evade  (30 gold). In Stock " + a[12]);
		int hPotionCost = 8;
		System.out.println ( "5 - Magic EEL Sauce. Heal 50 HP (8 gold)" );
		hpPotCost = 5;
		System.out.println ( "6 - Magic EEL Sauce to go. Heal 25 HP in battle (5 gold)" );
		System.out.println ( "7 - View Stats" );
		System.out.println ( "8 - Exit Merchant Camp" );
		System.out.println ( "You have " + a[0] + " gold");
		do {
			merch = input.nextInt();   //input decision
			if (merch < 0 || merch > 8) {
				System.out.println ( "You must enter a valid number (1-8)" );
			}
		} while (merch < 0 || merch > 8);
		switch (merch)
		{
			case 0:
				if (a[0] < gGameCost) {
					System.out.println ( "go get some more gold" );
				}
				else {
					int randNumber = 1;   //initialize nested loop
					int game = 1;   //game count
					int score = 6;  //player score, will decrement before first play to 5
					char play = 'y';  //initialize loop to play game
					int number = -9999;  //initialize guess loop
					int ttlpoints = 0;  //total point accumulator
					int gameGold = a[0];
					
					//Game start
					while (play =='y')
					{
						a[0] -= gGameCost;
						randNumber = (int) ( Math.random ( ) * 12 + 1 );  //Generate randNumberom number
						
						//user number must not equal randNumberom number to guess again
						while (number != randNumber)
						{
							score--; //minus one point per guess. starts at 5.
							if (score < 0)
							{
								score = 0; //set score to zero if less than zero
							}
							System.out.println ( score * 2 + " Points remain." ); 
							
							//prompt user for number and output results
							System.out.println ("Enter a number between 1 and 12");
							number = input.nextInt ( );  //users guess
							System.out.println ( "Your number was: " + number);
						
							//output if the number was too high or too low
							if (number > randNumber)
							{
								System.out.println ( "Too high, guess again!" );
							}
							if (number < randNumber)
							{
								System.out.println ( "Too low, guess again!" );
							}
						} //end loop when number = randNumber
						
						ttlpoints += score * 2; //score accumulate to total a[21]
						System.out.println ( "CORRECT! you get " + score * 2 + " Points and " + score * 2 + " gold! \nPlay Again? y/n" );
						a[0] += score * 2;
						a[21] += score * 2;
						do //user must answer 'y' or 'n'
						{
							play = input.next ( ).toLowerCase ( ).charAt ( 0 );  //user inputs character
							if (play != 'y' && play != 'n')  //check character input
							{
								System.out.println ( "You must enter y or n, Play again?" ); //prompt user for correct input
							}
						} while (play != 'y' && play != 'n');  //loop if user enters something other than 'y' or 'n'
						
						//variables must be changed for next round
						if (play == 'y')
						{
							if (a[0] >= gGameCost) {
								number = -9999;  // reset number
								score = 6;  //reset score for round (-1 before first guess)
								game++;   //add one to game number count
							}
							else {
								System.out.println ( "you're out of gold, go get some more... sucker" );
								play = 'n';
							}
						} 
					}//end loop if user inputs 'n'
					 //calculate average and output score
					double avg = (double)ttlpoints / game;
					System.out.println ("GUESSING GAME OVER. Total a[21]: " + ttlpoints);
					System.out.println ("Games played: " + game);
					System.out.println ( "Average Score: " + avg );
					int rev = a[0] - gameGold;
					if (a[0] > gameGold) {
						System.out.println ( "You made " + rev + " gold\n" );
					}
					else {
						System.out.println ( "Loser. " + rev + " gold" );
					}
				}
				break;
				
			case 1:  //buy  short sword
				if (a[9] > 0)
				{
					if (a[0] >= sSwordCost)
					{
						System.out.println ( "The Short Sword is now yours! DMG: 3-6" );
						a[3] = 3;
						a[4] = 6;
						a[0] -= sSwordCost;
						a[9]--;
						a[26] = 1;
						if (a[19] == 1) {
							a[4] += 2;
						}
						if (a[18] == 1) {
							a[4]--;
						}
						if(a[13] == 0)
						{
							a[3]++;
						}
					}
					else
					{
						System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
					}
				}
				else
				{
					System.out.println ( "Sorry, This item is out of stock." );
				}
				break;
				
			case 2:  //buy long sword
				if (a[10] > 0)
				{
					if (a[0] >= lSwordCost)
					{
						System.out.println ( "The Long Sword is now yours! DMG: 4-9. -1 dex" );
						a[3] = 4;
						a[4] = 9;
						a[5]--;
						a[0] -= lSwordCost;
						a[10]--;
						a[26] = 1;
						if (a[19] == 1) {
							a[4] += 2;
						}
						if (a[18] == 1) {
							a[4]--;
						}
						if(a[13] == 0)
						{
							a[3]++;
						}
					}
					else
					{
						System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
					}
				}
				else
				{
					System.out.println ( "Sorry, This item is out of stock." );
				}
				break;
				
			case 3:  // buy leather armor
				if (a[11] > 0)
				{
					if (a[0] >= lArmorCost)
					{
						System.out.println ( "The Leather Armor fits! +1 Evade" );
						a[6]++;
						a[0] -= lArmorCost;
						a[11]--;
					}
					else
					{
						System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
					}
				}
				else
				{
					System.out.println ( "Sorry, This item is out of stock." );
				}
				break;
				
			case 4:
				if (a[12] >= 0)
				{
					if (a[0] >= mBootsCost)
					{
						System.out.println ( "The strange looking boots fit! +1 Evade. You feel lighter." );
						a[6]++;
						a[0] -= mBootsCost;
						a[12]--;
					}
					else
					{
						System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
					}
				}
				else
				{
					System.out.println ( "Sorry, This item is out of stock." );
				}
				break;
				
			case 5:
				if (a[0] >= hPotionCost)
				{
					a[1] += 50;
					a[0] -= hPotionCost;
					a[21] -= 50;
					if (a[1] > a[2])
					{
						a[1] = a[2];
					}
					System.out.println ( "That Sauce is Awesome! +50 HP. You have " + a[1] + " HP"  );
				}
				else
				{
					System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
					System.out.println ( "You have " + a[0] + " gold. Go find some more" );
				} 
				break;
				
			case 6:
				if (a[16] < 1) {
					if (a[0] >= hpPotCost) {
						System.out.println ( "You get a bottle of Magic EEl Sauce. Use it wisely" );
						a[0] -= hpPotCost;
						a[16] += 1;
					}
					else {
						System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
						System.out.println ( "You have " + a[0] + " gold. Go find some more" );
					}
				}
				else {
					System.out.println ( "You can only hold one bottle at a time." );
				}
				break;
				
			case 7: 
				System.out.println ( "HP: " + a[1]);
				System.out.println ( "DMG: " + a[3] + " - " + a[4]);
				System.out.println ( "Dex: " + a[5]);
				System.out.println ( "Evade: " + a[6] );
				break;
			
			case 8:
			System.out.println ( "There is a road sign at the far end of camp; It reads:" );
			System.out.println ( "Humble Mountain - West (Road closed due to Extreme Terror)" );
			System.out.println ( "City of CrestFall - South" );
			System.out.println ( "SmellyFart Swamp - southEast" );
			System.out.println ( "Which way? \nS - CrestFall, \nE - Smelly Fart Swamp. \nW - Hike up Humble Mountain... \nN - stay at Camp" );
			a[25] = input.next ( ).toUpperCase ( ).charAt ( 0 );
		}
		return a;
	}
	
	public static int[] cityRoad(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
				case 1:
					System.out.println ("You hear a faint sound and turn in time to see a thief cutting your purse!"); //thief
					enemyAbility = 'a';
					int enemyHP = 15;   
					String eType = "Thief";
					String aType = " attacks";
					String killText = "You kill the ";
					String deathFlavor = ". His purse was pretty light. + 5 gold";
					int minRange = 4; 
					int maxRange = 6;
					int eMinHit = 4; 
					int eMaxHit = 11;
					int minFlee = 4; 
					int maxFlee = 8;
					int heroHit = 8;
					int rewardGold = 5;
					int rewardPoints = 40;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				
				break;
				
				case 2: 
					System.out.println ("A terrified looking man runs up to you from the West" ); // distress/ Necromancer
					System.out.println ( "He says a small dragon tried to carry off his carriage to the mountain but dropped it on the way" );
					System.out.println ( "He desperately needs help getting his shit back together" );
					System.out.println ( "Do you want to help? y/n" );
					char help;
					do  //check character input
					{
						help = input.next ( ).toLowerCase ( ).charAt ( 0 );
						if (help != 'y' && help != 'n')  
						{
							System.out.println ( "You must enter y or n" );
						}
					} while (help != 'y' && help != 'n'); 
					
					if (help == 'n')  //Don't look
					{
						System.out.println ( "Thats gotta be a trap... Keep walking" );
					}
					else
					{
						int ruse =	(int) ( Math.random ( ) * 10);
						if (ruse > 5)
						{
							System.out.println ( "It was a ruse!" );
							System.out.println ( "There are 3 haggard looking people with empty looking eyes standing near the cart" );
							System.out.println ( "The \"man in need\" is a Necromancer!  His thralls quickly saunter your way." );
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
							a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
								enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
						}
						else
						{
								System.out.println ( "You help the man gather what he needs and he is grateful for your help." );
								System.out.println ( "He hands you 10 gold with thanks. +10 gold!" );
						}
					}
				break;
				
				case 3: 
					System.out.println ( "You hear an Eagle screech... nope, thats a Wyvren! " );                   //Wyvren
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
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				
				}
			} 
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue South" );
				KeyIn.nextLine ( );
			}
		}
		return a;
	}
	public static int[] theCity(int [] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch, int INNCOST ) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "You find yourself standing at the Gates to the City" );
		System.out.println ( "HP = " + a[1] + " gold = " + a[0]);
		System.out.println ( "Press Enter to... Enter" );
		KeyIn.nextLine ( );
	
		int commonBoard;
		int armorerItems;
		char armorer;
		a[23] = 9;
		System.out.println ( "The City looks like it has seen better days..." );
		System.out.println ( "There are only a handful of people walking about and there is rising smoke from multiple dwellings." );
		System.out.println ( "There is a large map of the City with a message board, that could be helpful." );
		System.out.println ( "Press Enter" );
		KeyIn.nextLine();
		
		while (a[23] != 6)
		{
			System.out.println ( "City Common Board" );
			System.out.println ( "0 - EEL Sauce Vendor. 1 Bottle (8 gold)" );
			System.out.println ( "1 - Read Messages" );
			System.out.println ( "2 - View Stats");
			System.out.println ( "3 - Visit the Armorer");
			System.out.println ( "4 - Get a room at the Inn. (15 gold)");
			System.out.println ( "5 - Wander aimlessly about town" );
			System.out.println ( "6 - Leave the City" );
			System.out.println ( "7 - Guessing Game (5) Double your gold and get points!" );
			System.out.println ( "You have " + a[0] + " gold");
			do {
				commonBoard = input.nextInt();   //input decision
				if (commonBoard < 0 || commonBoard > 7) {
					System.out.println ( "You must enter a valid number (0-7)" );
				}
			} while (commonBoard < 0 || commonBoard > 7);
			switch (commonBoard)
			{
				case 0:
					int hpPotCost = 8;
					if (a[16] < 1) {
						if (a[0] >= hpPotCost) {
							System.out.println ( "You get a bottle of Magic EEl Sauce. Use it wisely" );
							a[0] -= hpPotCost;
							a[16] += 1;
						}
						else {
							System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
							System.out.println ( "You have " + a[0] + " gold. Go find some more" );
						}
					}
					else {
						System.out.println ( "You can only hold one bottle at a time." );
					}
					break;
					
				case 1:  //Read Messages
					System.out.println ( "1.) Have you purchased your flame retardant wall dividers yet?" );
					System.out.println ( "2.) An increase in fire raining from the sky has prompted the a[23] treasurer" );
					System.out.println ( "\tto offer a reward of 50 gold to whomever can put an end to it." );
					System.out.println ( "3.) Please attend tomorrows memorial service for the Brave Soldiers" );
					System.out.println ( "\twho went to the mountain and gave their lives to help our fair City " );
					System.out.println ( "Press Enter to  Return to Common Board" );
					KeyIn.nextLine();
					break;
					
				case 2:  //View stats
					System.out.println ( "HP: " + a[1] + " / " + a[2]);
					System.out.println ( "DMG: " + a[3] + " - " + a[4]);
					System.out.println ( "Dex: " + a[5]);
					System.out.println ( "Evade: " + a[6] );
					break;
					
				case 3:  //visit armorer
					System.out.println ( "You enter the Armory and notice it's missing 2 walls." );
					System.out.println ( "There is only an Apprentice Armorer tending the shop." );
					System.out.println ( "You learn that the Master Armorer was killed in the last fallout" );
					System.out.println ( "Apprentice: \"I've managed to salvage a few items my master created, please have a look\"" );
					System.out.println ( "Buy something? y/n" );
					do  //check character input
					{
						armorer = input.next ( ).toLowerCase ( ).charAt ( 0 );
						if (armorer != 'y' && armorer != 'n')  
						{
							System.out.println ( "You must enter y or n, Buy Something?" );
						}
					} while (armorer != 'y' && armorer != 'n'); 
					while (armorer != 'n')
					{
						System.out.println ( "What would you like?" );
						int mDaggerCost = 30;
						System.out.println ( "1 - Jeweled Dagger. Off-hand, +1 Min DMG, + 1 Dex. (30 gold) In stock: " + a[13] );
						int mShieldCost = 30;
						System.out.println ( "2 - Crested Shield. Off-hand, +1 Resistance. (30 gold) In stock: " + a[14] );
						int bSwordCost = 50;
						System.out.println ( "3 - Snowy Bastard Sword. 6 - 12 DMG. (50 gold) In stock: " + a[15] );
						int vRapierCost = 60;
						System.out.println ( "4 - Void Rapier. 5 - 11 DMG. Heals 1 HP on Hit. - 10 Max HP in battle" + a[26]);
						System.out.println ( "5 - Return to Armorer Entrance" );
						System.out.println ( "(You may only hold one Off-hand item, unless you grow and extra hand...)" );
						armorerItems = input.nextInt();
						switch (armorerItems)
						{
							case 1:
								if (a[13] > 0)
								{
									if (a[0] >= mDaggerCost)
									{
										if (a[14] == 0)
										{
											System.out.println ( "You ditch your shield and it vanishes! -1 Resistance" );
											System.out.println ( "Where you left it now lies a few gold coins... + 10 gold" );
											a[2] -= 25;
											a[14]++;
											a[0] += 10;
										}
										System.out.println ( "The Dagger's hilt feels like it was made for your hand" );
										System.out.println ( "+1 Min DMG, +1 Dex" );
										a[3]++;
										a[5]++;
										a[0] -= mDaggerCost;
										a[13]--;
										
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
							
							case 2:
								if (a[14] > 0)
								{
									if (a[0] >= mShieldCost)
									{
										if (a[13] == 0)
										{
											System.out.println ( "You set aside the Jeweled Dagger and it vanishes! -1 MinDMG, -1 Dex" );
											System.out.println ( "A few coins materialize in its place. +10 gold" );
											a[3]--;
											a[5]--;
											a[0] += 10;
											a[13]++;
										}
										System.out.println ( "You grab your new shield and feel full of Vigor! +1 resistance = +25 Max HP" );
										a[2] += 25;												
										a[0] -= mShieldCost;
										a[14]--;
										
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
								
							case 3:
								if (a[15] > 0)
								{
									if (a[0] >= bSwordCost)
									{
										System.out.println ( "Gripping the pommel, a chill flows from your palm to the top of your head." );
										System.out.println ( "It feels as though you pulled this sword from its own grave" );
										System.out.println ( "DMG = 6 - 12" );
										a[3] = 6;
										a[4] = 12;
										a[0] -= bSwordCost;
										a[15]--;
										a[26] = 1;
										if (a[19] == 1) {
											a[4] += 2;
										}
										if (a[18] == 1) {
											a[4]--;
										}
										if (a[13] == 0)
										{
											a[3]++;
										}
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
							
							case 4:
								if (a[26] > 0)
								{
									if (a[0] >= vRapierCost)
									{
										System.out.println ( "Gripping the pommel, you get the feeling of a ghostly tentacle\nweaving its way through the tendons of your forearm." );
										System.out.println ( "DMG = 5 - 11. Max HP -10.\nYou feel more vascular." );
										a[3] = 5;
										a[4] = 11;
										a[0] -= vRapierCost;
										a[26]--;
										if (a[19] == 1) {
											a[4] += 2;
										}
										if (a[18] == 1) {
											a[4]--;
										}
										if (a[13] == 0)
										{
											a[3]++;
										}
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								
							case 5:
								System.out.println ( "Return to Common Board? y/n" );
								do  //check character input
								{
									armorer = input.next ( ).toLowerCase ( ).charAt ( 0 );
									if (armorer != 'y' && armorer != 'n')  
									{
										System.out.println ( "You must enter y or n, Return to Common Board?" );
									}
								} while (armorer != 'y' && armorer != 'n'); 
								if (armorer == 'y')                           // flip decision
								{
									armorer = 'n';
								}
								else if (armorer == 'n')
								{
									armorer = 'y';
								}
						}   // end armorerItem switch
					} // exit armorer
					break;
					
					case 4:
					if (a[0] >= INNCOST)
					{
						System.out.println ( "You recieve a good nights rest. + 75 HP" );
						a[1] += 75;
						a[21] -= 75;
						a[0] -= INNCOST;
						if (a[1] > a[2])
						{
							a[1] = a[2];
						}			
					}
					else
					{
						System.out.println ( "NO FREE-LOADING! Go make some gold, you Dirty BUM!" );
					}
					break;
					
				
				case 5: 
					//City Search
					a = cityWalk(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
					break; 
					
				case 6:
					//leave city
					int carriage = 10;
					System.out.println ( "Are you sure you  want to leave the City?" );
					System.out.println ( "Enter 6 to confirm. Enter 0 to return to Common Board" );
					a[23] = input.nextInt();
					if (a[23] == 6)
					{
						System.out.println ( "Where to?" );
						System.out.println ( "N - Take Carriage back to the Merchant Camp fork. (10 gold)");
						System.out.println ( "W - Walk back to Merchant Camp fork" );
						if (a[24] == 0) { // after killing chaos demon
							System.out.println ( "S - A man standing at the City Gates recognizes you\nas the one who ended the rain of fire" );
							System.out.println ( "Not knowing how he knows this, you aknowledge him\nand he offers you a free ride south with his caravan." );
						}
						a[25] = input.next ( ).toUpperCase ( ).charAt ( 0 );
						if (a[25] == 'N')
						{
							if (a[0] >= carriage)
							{
								a[0] -= carriage;
								merch = 0;
								a[17] = 0;
								System.out.println ( "The ride back to the Merchant Camp lasts the rest of\n the day and night, and is not very exciting\n" );
								
							}
							else
							{
								System.out.println ( "It's not that much money, go get some more." );
								a[23] = 9;
							}
						}
						if (a[25] == 'S' && a[24] == 0) {
							System.out.println ( "You desire to leave this place as there is nothing left here for you." );
							System.out.println ( "(this option will end this chapter of the game\nand you may not be able to return)\nContinue? y/n" );
							int citySearch;
							do  //check character input
							{
								citySearch = input.next ( ).toLowerCase ( ).charAt ( 0 );
								if (citySearch != 'y' && citySearch != 'n')  
								{
									System.out.println ( "You must enter y or n" );
								}
							} while (citySearch != 'y' && citySearch != 'n');
							if (citySearch == 'y') {
								System.out.println ( "The cloaked carriage driver gives you a nod \nand asks of you only to help him load up his shipment" );
								System.out.println ( "When you ask him exactly where you're going\nhe says \" 21 days South and 6 days East\"\n" );
								System.out.println ( "Feeling perfectly fine with that answer, you help load the cart.\nPress Enter" );
								KeyIn.nextLine ( );
								a[7] = 3;
								break;
							}
							else {
								System.out.println ( "You decide there are some things you need to wrap-up and take another look at the board...\n" );
								a[23] = 9;
							}
						}
					}
					break;
					
				case 7:
					int gGameCost = 5;
					if (a[0] < gGameCost) {
						System.out.println ( "go get some more gold" );
					}
					else {
						int randNumber = 1;   //initialize nested loop
						int game = 1;   //game count
						int score = 6;  //player score, will decrement before first play to 5
						char play = 'y';  //initialize loop to play game
						int number = -9999;  //initialize guess loop
						int ttlpoints = 0;  //total point accumulator
						int gameGold = a[0];
						
						//Game start
						while (play =='y')
						{
							a[0] -= gGameCost;
							randNumber = (int) ( Math.random ( ) * 12 + 1 );  //Generate randNumberom number
							
							//user number must not equal randNumberom number to guess again
							while (number != randNumber)
							{
								score--; //minus one point per guess. starts at 5.
								if (score < 0)
								{
									score = 0; //set score to zero if less than zero
								}
								System.out.println ( score * 2 + " Points remain." ); 
								
								//prompt user for number and output results
								System.out.println ("Enter a number between 1 and 12");
								number = input.nextInt ( );  //users guess
								System.out.println ( "Your number was: " + number);
							
								//output if the number was too high or too low
								if (number > randNumber)
								{
									System.out.println ( "Too high, guess again!" );
								}
								if (number < randNumber)
								{
									System.out.println ( "Too low, guess again!" );
								}
							} //end loop when number = randNumber
							
							ttlpoints += score * 2; //score accumulate to total points
							System.out.println ( "CORRECT! you get " + score * 2 + " Points and " + score * 2 + " gold! \nPlay Again? y/n" );
							a[0] += score * 2;
							a[21] += score * 2;
							do //user must answer 'y' or 'n'
							{
								play = input.next ( ).toLowerCase ( ).charAt ( 0 );  //user inputs character
								if (play != 'y' && play != 'n')  //check character input
								{
									System.out.println ( "You must enter y or n, Play again?" ); //prompt user for correct input
								}
							} while (play != 'y' && play != 'n');  //loop if user enters something other than 'y' or 'n'
							
							//variables must be changed for next round
							if (play == 'y')
							{
								if (a[0] >= gGameCost) {
									number = -9999;  // reset number
									score = 6;  //reset score for round (-1 before first guess)
									game++;   //add one to game number count
								}
								else {
									System.out.println ( "you're out of gold, go get some more... sucker" );
									play = 'n';
								}
							} 
						}//end loop if user inputs 'n'
						 //calculate average and output score
						double avg = (double)ttlpoints / game;
						System.out.println ("GUESSING GAME OVER. Total a[21]: " + ttlpoints);
						System.out.println ("Games played: " + game);
						System.out.println ( "Average Score: " + avg );
						int rev = a[0] - gameGold;
						if (a[0] > gameGold) {
							System.out.println ( "You made " + rev + " gold\n" );
						}
						else {
							System.out.println ( "Loser. " + rev + " gold" );
						}
					}
					if (a[1] < 1) {
						break;
					}
				}// end commonBoard Switch
				if (a[1] < 1) {
					break;
				}
			}//end a[23] decision
		
		
		return a;
	}
	public static int[] cityWalk (int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		char citySearch;
		int areaCount = 0;
		System.out.println ( "Lets walk about town, shall we? y/n" );
		do  //check character input
		{
			citySearch = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (citySearch != 'y' && citySearch != 'n')  
			{
				System.out.println ( "You must enter y or n, press 'n' to return to Common Board." );
			}
		} while (citySearch != 'y' && citySearch != 'n'); 
		while (citySearch == 'y')
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
				case 1: 
					System.out.println ("A fight started up outside the pub \n and some Drunkass threw his tankard at you..." ); //thief pack
					enemyAbility = 'a';
					int enemyHP = 25;   
					String eType = "Drunkass";
					String aType = " swings";
					String killText = "You knocked out that worthless ";
					String deathFlavor = "\n and pick up the gold tooth you knocked out of his mouth. +10 gold.";
					int minRange = 5; 
					int maxRange = 12;
					int eMinHit = 3; 
					int eMaxHit = 11;
					int minFlee = 3; 
					int maxFlee = 8;
					int heroHit = 8;
					int rewardGold = 10;
					int rewardPoints = 80;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				
				break;
				
				case 2:  // you find the girl
				if (a[20] > 0)
				{
					System.out.println ("You hear a whisper. As you listen more closely it sounds \n more like a hushed scream from down the alley"  ); 	// rescue
					System.out.println ( "Do you want to check it out? y/n" );
					char help;
					do  //check character input
					{
						help = input.next ( ).toLowerCase ( ).charAt ( 0 );
						if (help != 'y' && help != 'n')  
						{
							System.out.println ( "You must enter y or n" );
						}
					} while (help != 'y' && help != 'n'); 
					
					if (help == 'n')  //Don't look
					{
						System.out.println ( "That's way too Creepy. You walk the other way" );
					}
					else
					{
						System.out.println ( "You come accross two Greasy Vandals attempting an unsavory act upon a young lady" );
						System.out.println ( "You meet their eyes and your fist clenches your blade");
						enemyAbility = 'a';
						enemyHP = 45;   
						eType = "Greasy Vandal";
						aType = " slashes";
						killText = "You killed a couple of ";
						deathFlavor = "s and save the girl!\nShe is shaken, but thanks you and gives you a kiss on the cheek\n"
								+ "It felt so wonderful you breifly closed your eyes\n When you opened them she was gone\n +25 Max HP";
						minRange = 4; 
						maxRange = 11;
					 	eMinHit = 5; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 8;
						heroHit = 9;
						rewardGold = 0;
						rewardPoints = 250;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
						if (a[1] > 0) 
						{
							a[2] += 25; //increase max hp by 25
							a[20]--;  //girl saved
						}
					}
				}
				else
				{
					System.out.println ( "You wander back to the spot where you saved that young lady" );
					System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
					a[0] += 1;
				}
				break;
				
				case 3: 
					System.out.println ( "Its a Giant Sewer Rat! " );   //Sewer Rat
					enemyAbility = 'a';
					enemyHP = 25;   
					eType = "Sewer Rat";
					aType = " bites";
					killText = "You killed a Giant ";
					deathFlavor = "! Gross!\nOne of the locals witnessed your heroic deed and hands you 15 gold";
					minRange = 5; 
					maxRange = 8;
				 	eMinHit = 6; 
					eMaxHit = 12;
					minFlee = 6; 
					maxFlee = 6;
					heroHit = 9;
					rewardGold = 15;
					rewardPoints = 250;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
		
				break;
				
				case 4: 
					System.out.println ("A robed figure leaps from the shadows and stabs at you without warning" ); //cultist 
					enemyAbility = 'v';
					enemyHP = 20;   
					eType = "Cultist";
					aType = " stabs wildly";
					killText = "You decapitate the ";
					deathFlavor = " of Chaos...\ntheir purse holds 12 gold.";
					minRange = 5; 
					maxRange = 8;
				 	eMinHit = 5; 
					eMaxHit = 12;
					minFlee = 5; 
					maxFlee = 7;
					heroHit = 8;
					rewardGold = 12;
					rewardPoints = 110;
					a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
			
				}	
			}
			if (a[1] > 0) {
				System.out.println ( "Keep walking about aimlessly? y/n" );
				do  //check character input
				{
					if (a[1] < 1) {
						break;
					}
					citySearch = input.next ( ).toLowerCase ( ).charAt ( 0 );
					if (citySearch != 'y' && citySearch != 'n')  
					{
						System.out.println ( "You must enter y or n" );
					}
				} while (citySearch != 'y' && citySearch != 'n');
			}
			else {
				citySearch = 'n';
			}
		}
		return a;	
	}
	public static int[] mountainRoad1(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Its a Hard road to the mountain, but there's no turning back now..." );
		System.out.println ( "Press Enter to start your climb" );
		KeyIn.nextLine();
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
						enemyAbility = 'a';
						int enemyHP = 30;   
						String eType = "Fire Sprite";
						String aType = " throws fireball ";
						String killText = "You extinguish the ";
						String deathFlavor = "\n and find a hot ruby melting its way through the snow. +15 gold";
						int minRange = 5; 
						int maxRange = 9;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 15;
						int rewardPoints = 125;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2: 
						System.out.println ("Tucked back in a dark alcove you can see the dull outline of a chest"  ); // jewel/ mimic
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do  //check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if (help != 'y' && help != 'n')  
							{
								System.out.println ( "You must enter y or n" );
							}
						} while (help != 'y' && help != 'n'); 
						
						if (help == 'n')  //Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
								System.out.println ( "It's a Mimic!" );
								enemyAbility = 'a';
								enemyHP = 35;   
								eType = "Mimic";
								aType = " chomps";
								killText = "You killed a ";
								deathFlavor = "!\nYou open its skull, which resembles a chest, and find a Diamond! + 20 gold";
								minRange = 7; 
								maxRange = 8;
							 	eMinHit = 6; 
								eMaxHit = 12;
								minFlee = 5; 
								maxFlee = 7;
								heroHit = 9;
								rewardGold = 20;
								rewardPoints = 150;
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								a[0] += 20;	
							}
						}
					break;
					
					case 3: 
						System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //MudMan
						enemyAbility = 'a';
						enemyHP = 50;   
						eType = "Mountain Troll";
						aType = " clubs you";
						killText = "You killed a ";
						deathFlavor = "! WOW\nIts pouch holds 20 gold, Awesome!";
						minRange = 8; 
						maxRange = 8;
					 	eMinHit = 4; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 6;
						heroHit = 8;
						rewardGold = 20;
						rewardPoints = 140;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("The sky darkens. You look above to see a colony of thirsty Vampire Bats" ); //bat 
						enemyAbility = 'v';
						enemyHP = 30;   
						eType = "Vampire Bat";
						aType = " swoops";
						killText = "You slaughter the colony of ";
						deathFlavor = "s and find 13 gold on a nearby corpse.";
						minRange = 7; 
						maxRange = 5;
					 	eMinHit = 5; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 13;
						rewardPoints = 120;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				}
			} 
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue Upward" );
				KeyIn.nextLine ( );
			}
		}// end mountain road
		return a;												
	}
	
	public static int[] mountainTop(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch, String player) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "The top of the mountain is a meandering trenchwork of jagged rock and snow covered boulders." );
		System.out.println ( "You will need to find another way down..." );
		System.out.println ( "Would you like to look around first? y/n" );
		int areaCount = 0;
		char enemyAbility;
		char mountain = 'a';
		do  //check character input
		{
			mountain = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (mountain != 'y' && mountain != 'n')  
			{
				System.out.println ( "You must enter y or n" );
			}
		} while (mountain != 'y' && mountain != 'n'); 
		
		while (mountain == 'y')
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1:
						System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite
						enemyAbility = 'a';
						int enemyHP = 30;   
						String eType = "Fire Sprite";
						String aType = " throws fireball ";
						String killText = "You extinguish the ";
						String deathFlavor = "\n and find a hot ruby melting its way through the snow. +15 gold";
						int minRange = 5; 
						int maxRange = 9;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 15;
						int rewardPoints = 125;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					break;
					
					case 2:  // Chaos Demon
						if (a[24] > 0)
						{
							System.out.println ("A voice that is much different than your own begins to tug on your mind"  ); 	// rescue
							System.out.println ( "Give in to the foreign voice? y/n" );
							char help;
							do  //check character input
							{
								help = input.next ( ).toLowerCase ( ).charAt ( 0 );
								if (help != 'y' && help != 'n')  
								{
									System.out.println ( "You must enter y or n" );
								}
							} while (help != 'y' && help != 'n'); 
							
							if (help == 'n')  //Don't look
							{
								System.out.println ( "That's way too Creepy. You shut the voice out of your mind." );
							}
							else
							{
								System.out.println ( "\"" + player + "!\"\nYou stop in your tracks and regain your own sight, now realizing that you had lost it" );
								System.out.println ( "Filling your gaze is a huge creature, nearly as tall as a mountain troll.");
								System.out.println ( "It looks like it is made of molten rock and its features are constantly shifting\n though constantly righting themselves as well." );
								System.out.println ( "Press Enter" );
								KeyIn.nextLine ( );
								System.out.println ( "Chaos Demon: \"" + player + ", have you come all this way to seek revenge for your village in the forest?" );
								System.out.println ( "I am merely an agent of Chaos and make no decision against the fates of chance." );
								System.out.println ( "But I can see into your mind and know that you desire revenge more than your life..." );
								System.out.println ( "Have at you!\"  Regen 50% MaxHP" );
								a[1] += a[2] / 2;
								if (a[1] > a[2]) { //hp cannot go above max
									a[1] = a[2];
								}
								System.out.println ( "Press Enter" );
								KeyIn.nextLine ( );
								
								//Boss battle
								enemyAbility = 'a';
								enemyHP = 90;   
								eType = "Chaos Demon";
								aType = " attacks";
								killText = "You swing!... your blade cuts through empty air, at the same time\nan intense gust of wind throws you forward violently...\nThe ";
								deathFlavor = " imploded! Only a hot lump of glowing ore remains.\nA small piece of glowing ore has broken apart from the rest and you pick it up\n"
										+ "It is extremely heavy for its size and you feel a part of yourself being tied to this small gem\n+25 Max HP. HP fully restored! + 50 gold.";
								minRange = 6; 
								maxRange = 12;
							 	eMinHit = 5; 
								eMaxHit = 12;
								minFlee = 5; 
								maxFlee = 8;
								heroHit = 9;
								rewardGold = 50;
								rewardPoints = 500;
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
								if (a[1] > 0) {
									a[2] += 25; //hp Max + 25
									a[1] = a[2]; // full hp
									a[0] += 50;  // 50 gold
									a[24] --;  //chaos demon dies
									a[21] += 500; // 500 points
								}
							}
						}
						else
						{
							System.out.println ( "You wander back to the spot where you fought the Chaos Demon" );
							System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
							a[0] += 1;
						}
						break;
					
					case 3:
						System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //Troll
						enemyAbility = 'a';
						enemyHP = 50;   
						eType = "Mountain Troll";
						aType = " clubs you";
						killText = "You killed a ";
						deathFlavor = "! WOW\nIts pouch holds 20 gold, Awesome!";
						minRange = 8; 
						maxRange = 8;
					 	eMinHit = 4; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 6;
						heroHit = 8;
						rewardGold = 20;
						rewardPoints = 140;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					break;
					
					case 4: 
						System.out.println ("The sky darkens. You look above to see an enormous colony of thirsty Vampire Bats" ); //bat 
						enemyAbility = 'v';
						enemyHP = 40;   
						eType = "Vampire Bat";
						aType = " swoops";
						killText = "You slaughter the colony of ";
						deathFlavor = "s and find 13 gold on a nearby corpse.";
						minRange = 7; 
						maxRange = 5;
					 	eMinHit = 5; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 140;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
				}
			}
			if (a[1] > 0) {
				System.out.println ( "Keep Searching the Mountain?" );
				do  //check character input
				{
					mountain = input.next ( ).toLowerCase ( ).charAt ( 0 );
					if (mountain != 'y' && mountain != 'n')  
					{
						System.out.println ( "You must enter y or n" );
					}
				} while (mountain != 'y' && mountain != 'n');
			}
			else {
				mountain = 'n';
			}
		}
		if (a[1] > 0) {
			System.out.println ( "You find an old merchant trail marker and head Down the Mountain" );   //other side of mountain
			System.out.println ( "Enter to continue" );
			KeyIn.nextLine();
		}
		return a;
	}
	public static int[] mountainRoad2(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1:
						System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite 
						enemyAbility = 'a';
						int enemyHP = 30;   
						String eType = "Fire Sprite";
						String aType = " throws fireball ";
						String killText = "You extinguish the ";
						String deathFlavor = "\n and find a hot ruby melting its way through the snow. +15 gold";
						int minRange = 5; 
						int maxRange = 9;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 15;
						int rewardPoints = 125;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					break;
				
					case 2: 
						System.out.println ("Tucked back in a dark alcove you can see the dull outline of a chest"  ); // jewel/ mimic
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do  //check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if (help != 'y' && help != 'n')  
							{
								System.out.println ( "You must enter y or n" );
							}
						} while (help != 'y' && help != 'n'); 
						
						if (help == 'n')  //Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
								System.out.println ( "It's a Mimic!" );
								enemyAbility = 'a';
								enemyHP = 35;   
								eType = "Mimic";
								aType = " chomps";
								killText = "You killed a ";
								deathFlavor = "!\nYou open its skull, which resembles a chest, and find a Diamond! + 20 gold";
								minRange = 7; 
								maxRange = 8;
							 	eMinHit = 6; 
								eMaxHit = 12;
								minFlee = 5; 
								maxFlee = 7;
								heroHit = 9;
								rewardGold = 20;
								rewardPoints = 150;
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								a[0] += 20;	
							}
						}
					break;
				
					case 3: 
						System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //MudMan
						enemyAbility = 'a';
						enemyHP = 50;   
						eType = "Mountain Troll";
						aType = " clubs you";
						killText = "You killed a ";
						deathFlavor = "! WOW\nIts pouch holds 20 gold, Awesome!";
						minRange = 8; 
						maxRange = 8;
					 	eMinHit = 4; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 6;
						heroHit = 8;
						rewardGold = 20;
						rewardPoints = 140;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					break;
					
					case 4: 
						System.out.println ("The sky darkens. You look above to see an enormous colony of thirsty Vampire Bats" ); //bat 
						enemyAbility = 'v';
						enemyHP = 40;   
						eType = "Vampire Bat";
						aType = " swoops";
						killText = "You slaughter the colony of ";
						deathFlavor = "s and find 13 gold on a nearby corpse.";
						minRange = 7; 
						maxRange = 5;
					 	eMinHit = 5; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 140;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				}
			}
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue Downward" );
				KeyIn.nextLine ( );
			}
			
		}
		if (a[1] > 0) {
			a[25] = 'N';
			a[17] = 0;
		}
		else {
			a[25] = 'A';
		}
		return a;
	}
	public static void ch3Intro() {
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "You've completed Chapter 2!");
		System.out.println ( "Press Enter to skip 8 years" );         
		KeyIn.nextLine ( );
		System.out.println ( "You are immediately snapped out of your memory\nby a knock on front your door." );
		System.out.println ( "Opening the door reveals the distantly familiar\nface of the carriage driver that had brought you to this village." );
		System.out.println ( "You have not seen him since the day you stepped off his carriage\nPress Enter" );
		KeyIn.nextLine ( );
		System.out.println ( "\"Your abilities are needed again\" he says, \nand continues \"You had slain an agent of Chaos," );
		System.out.println ( "and though you sought retribution and have found peace again,\nThere are even more horrors of the world driving others, like yourself,\nfrom their homes and into an unforgiving world." );
		System.out.println ( "You are bound to this duty, just as the Chaos Orb is bound to you.\"\nPress Enter" );
		KeyIn.nextLine ( );
		System.out.println ( "Before you can say anything he disappears, and a familiar scenario arouses your memory again" );
		System.out.println ( "Where \"he\" stood now lays the very same equipment you had 8 years ago..." );
		System.out.println ( "After donning your armor and sheathing your weapons\nyou step out into the world willingly\nPress Enter" );
		KeyIn.nextLine ( );
		System.out.println ( "Your small village has no name as it is merely called \"Home\" to the village's 6 residents."
				+ "\nYou greet your friend Gil, the merchant, and ask to see his stock");
	}
	
	public static int[] homeHub(int[] a, int merch) {
		Scanner input = new Scanner(System.in);
		System.out.println ( "\"Welcome friend, what would you like?\"\n" );
		int gGameCost = 5;
		System.out.println ( "0 - Play Guessing Game. (5 gold)" );
		int hpPotCost = 20;
		System.out.println ( "1 - Snake Oil. Heal 40 HP. (20 gold)" );
		int dynamiteCost = 25;
		System.out.println ( "2 - Dynamite. Deals 30 DMG to the enemy and 5 damage to you. (25 gold)" );
		System.out.println ( "3 - Go Home and Rest. Full HP" );
		System.out.println ( "4 - Leave Village" );
		System.out.println ( "5 - Get Advice" );
		int slArmorCost = 220;
		int pDaggerCost = 150;
		// if marsh OR cliffs are complete
		if (a[29] == 0 || a[30] == 0) {
			System.out.println ( "6 - Parrying Dagger. dex + 2, + 1 minDMG off-hand (150 gold)" );
		}
		// if marsh AND cliffs are complete
		if (a[29] == 0 && a[30] == 0) {
			System.out.println ( "7 - Studded Leather Armor. + 2 Evade (220 gold)" );
		}
		System.out.println ( "\nYou Have " + a[0] + "gold");
		do {
			merch = input.nextInt();   //input decision
			if (merch < 0 || merch > 7) {
				System.out.println ( "You must enter a valid number" );
			}
		} while (merch < 0 || merch > 7);
		switch (merch) {
			case 0:
				if (a[0] < gGameCost) {
					System.out.println ( "go get some more gold" );
				}
				else {
					int randNumber = 1;   //initialize nested loop
					int game = 1;   //game count
					int score = 6;  //player score, will decrement before first play to 5
					char play = 'y';  //initialize loop to play game
					int number = -9999;  //initialize guess loop
					int ttlpoints = 0;  //total point accumulator
					int gameGold = a[0];
					
					//Game start
					while (play =='y')
					{
						a[0] -= gGameCost;
						randNumber = (int) ( Math.random ( ) * 12 + 1 );  //Generate randNumberom number
						
						//user number must not equal randNumberom number to guess again
						while (number != randNumber)
						{
							score--; //minus one point per guess. starts at 5.
							if (score < 0)
							{
								score = 0; //set score to zero if less than zero
							}
							System.out.println ( score * 2 + " Points remain." ); 
							
							//prompt user for number and output results
							System.out.println ("Enter a number between 1 and 12");
							number = input.nextInt ( );  //users guess
							System.out.println ( "Your number was: " + number);
						
							//output if the number was too high or too low
							if (number > randNumber)
							{
								System.out.println ( "Too high, guess again!" );
							}
							if (number < randNumber)
							{
								System.out.println ( "Too low, guess again!" );
							}
						} //end loop when number = randNumber
						
						ttlpoints += score * 2; //score accumulate to total a[21]
						System.out.println ( "CORRECT! you get " + score * 2 + " Points and " + score * 2 + " gold! \nPlay Again? y/n" );
						a[0] += score * 2;
						a[21] += score * 2;
						do //user must answer 'y' or 'n'
						{
							play = input.next ( ).toLowerCase ( ).charAt ( 0 );  //user inputs character
							if (play != 'y' && play != 'n')  //check character input
							{
								System.out.println ( "You must enter y or n, Play again?" ); //prompt user for correct input
							}
						} while (play != 'y' && play != 'n');  //loop if user enters something other than 'y' or 'n'
						
						//variables must be changed for next round
						if (play == 'y')
						{
							if (a[0] >= gGameCost) {
								number = -9999;  // reset number
								score = 6;  //reset score for round (-1 before first guess)
								game++;   //add one to game number count
							}
							else {
								System.out.println ( "you're out of gold, go get some more... sucker" );
								play = 'n';
							}
						} 
					}//end loop if user inputs 'n'
					 //calculate average and output score
					double avg = (double)ttlpoints / game;
					System.out.println ("GUESSING GAME OVER. Total a[21]: " + ttlpoints);
					System.out.println ("Games played: " + game);
					System.out.println ( "Average Score: " + avg );
					int rev = a[0] - gameGold;
					if (a[0] > gameGold) {
						System.out.println ( "You made " + rev + " gold\n" );
					}
					else {
						System.out.println ( "Loser. " + rev + " gold" );
					}
				}
			break;
			
			case 1:
				if (a[16] < 1) {
					if (a[0] >= hpPotCost) {
						System.out.println ( "You get a bottle of Snake Oil. Use it wisely" );
						a[0] -= hpPotCost;
						a[16] += 1;
					}
					else {
						System.out.println ( "I'm your friend but I still require payment. " );
						System.out.println ( "You only have " + a[0] + " gold..." );
					}
				}
				else {
					System.out.println ( "You can only hold one bottle at a time." );
				}
				break;
			
			case 2:
				if (a[27] < 1) {
					if (a[0] >= dynamiteCost) {
						System.out.println ( "You get a Stick of Dynamite. Use it recklessly" );
						a[0] -= dynamiteCost;
						a[27] ++;
					}
					else {
						System.out.println ( "I'm your friend but I still require payment. " );
						System.out.println ( "You only have " + a[0] + " gold..." );
					}
				}
				else {
					System.out.println ( "You can only hold one explosive at a time." );
				}
				break;
				
			case 3:
				a[1] = a[2];
				System.out.println ( "Your bed is so comfy... HP Refiled: " + a[1] + " / " + a[2]);
			break;
			
			case 4:
				System.out.println ( "Where to?" );
				System.out.println ( "1 - Stay Home\n2 - Shimmering Valley\n3 - Arid Plains\n4 - Frozen Desert\n5 - Sleeping Forest" );
				a[25] = (char)input.nextInt ( );
			break;
			
			case 5:
				//before diamond key
				System.out.println ( "I hear travelers lose whole days of travel in the sleeping forest\nand the plains are teaming with horrible creatures."
						+ "\nThe Volcano has been recently erupting beyond the plains as well.\nAnd that's about all I know right now, I hope that helps.\n" );
			break;
			
			case 6:
				if (a[29] == 0 || a[30] == 0) {
					if (a[31] > 0)
					{
						if (a[0] >= pDaggerCost)
						{
							if (a[14] == 0)
							{
								System.out.println ( "You ditch your shield and it vanishes! -1 Resistance" );
								System.out.println ( "Where you left it now lies a few gold coins... + 10 gold" );
								a[2] -= 25;
								a[14]++;
								a[0] += 10;
							}
							else if (a[13] == 0) {
								System.out.println ( "You set aside the Jeweled Dagger and it vanishes! -1 MinDMG, -1 Dex" );
								System.out.println ( "A few coins materialize in its place. +10 gold" );
								a[3]--;
								a[5]--;
								a[0] += 10;
								a[13]++;
							}
							System.out.println ( "The Parrying Dagger's hilt feels like it was made for your hand" );
							System.out.println ( "+1 Min DMG, +2 Dex" );
							a[3]++;
							a[5] += 2;
							a[0] -= pDaggerCost;
							a[31]--;
							
						}
						else
						{
							System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
						}
					}
					else
					{
						System.out.println ( "Sorry, This item is out of stock." );
					}
				}
				else {
					System.out.println ( "No Cheating!" );
				}
			break;
			
			case 7:
				if (a[29] == 0 && a[30] == 0) {
					if (a[32] > 0)
					{
						if (a[0] >= slArmorCost)
						{
							if (a[11] == 0) {
								System.out.println ( "You're glad to get some new armor and remove your old leather armor. -1 Evade" );
								System.out.println ( "It would be best if it was burned...\n" );
								a[6] --;
							}
							System.out.println ( "The Studded Leather Armor fits like a glove. +2 Evade" );
							a[6] += 2;
							a[0] -= slArmorCost;
							a[32]--;
						}
						else
						{
							System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
						}
					}
					else
					{
						System.out.println ( "Sorry, This item is out of stock." );
					}
				}
				else {
					System.out.println ( "No Cheating!" );
				}
			break;
		}
		return a;
	}
	
	public static int[] sValleyRoad(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch, String nautical) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("The nerby ferns begin to hiss. They uproot themselves and lash at you with their stolons" ); //Ferns
						enemyAbility = 'a';
						int enemyHP = 30;   
						String eType = "Fern Feind";
						String aType = " whips ";
						String killText = "You dice the ";
						String deathFlavor = "s and clip their buds worth 5 gold a piece. +15 gold";
						int minRange = 5; 
						int maxRange = 7;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 15;
						int rewardPoints = 125;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2: 
						System.out.println ("You nearly trip over a mound of dirt hidden in the underbrush\nIt looks like someone buried something recently"  ); // chest/ zombie
						System.out.println ( "Do you want to dig it up? y/n" );
						char help;
						do  //check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if (help != 'y' && help != 'n')  
							{
								System.out.println ( "You must enter y or n" );
							}
						} while (help != 'y' && help != 'n'); 
						
						if (help == 'n')  //Don't look
						{
							System.out.println ( "No way am i digging up whats been buried... Keep walking" );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
								System.out.println ( "You uncover a rotting corpse... It opens its eyes and grabs you!" );
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
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a chest full of coin! + 20 gold" );
								a[0] += 20;	
							}
						}
					break;
					
					case 3: 
						System.out.println ( "Something has been stalking you... " );   //MudMan
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("A leafy tentacle strikes at you form the thick shrubbery\nan octopus-like plant wants to devour you!" ); //bat 
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				}
			} 
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end valley road
		
		return a;	
	}
	public static int[] sValley(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		int areaCount = 0;
		char valley;                                                                              //Shimmering Valley
		System.out.println ( "The trail widens and then branches into many directions" );
		System.out.println ( "From here you can either head back home, or continue East to the White Marsh" );
		System.out.println ( "First, Would you like to look around the meandering trails? y/n" );
		do  //check character input
		{
			valley = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (valley != 'y' && valley != 'n')  
			{
				System.out.println ( "You must enter y or n" );
			}
		} while (valley != 'y' && valley != 'n'); 
		while (valley == 'y')
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("The nerby ferns begin to hiss. They uproot themselves and lash at you with their barbed stolons" ); //Ferns
						enemyAbility = 'a';
						int enemyHP = 30;   
						String eType = "Fern Feind";
						String aType = " whips ";
						String killText = "You dice the ";
						String deathFlavor = "s and clip their buds worth 5 gold a piece. +15 gold";
						int minRange = 5; 
						int maxRange = 8;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 15;
						int rewardPoints = 125;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2: 
							System.out.println ("The sound of a half-dozen horses comes from up ahead"  ); 	// traveling merchant
							System.out.println ( "Do you want to check it out? y/n" );
							char help;
							do  //check character input
							{
								help = input.next ( ).toLowerCase ( ).charAt ( 0 );
								if (help != 'y' && help != 'n')  
								{
									System.out.println ( "You must enter y or n" );
								}
							} while (help != 'y' && help != 'n'); 
							
							if (help == 'n')  //Don't look
							{
								System.out.println ( "Frightened, you run off into the brush and hide until the sound\nof the horses fade into the distance..." );
							}
							else
							{
								System.out.println ( "You meet a merchant and his small caravan on the trail\nand he gladly shows you his wares" );
								int valleyMerch = 0;
								while (valleyMerch != 4) {
									System.out.println ( "\"What would you like?\"\n" );
									int gGameCost = 5;
									System.out.println ( "0 - Play Guessing Game. (5 gold)" );
									int hpPotCost = 35;
									System.out.println ( "1 - Snake Oil. Heal 40 HP. (35 gold)" );
									int dynamiteCost = 40;
									System.out.println ( "2 - Dynamite. Deals 30 DMG to the enemy and 5 damage to you. (40 gold)" );
									int cKukriCost = 75;
									System.out.println ( "3 - Coral Kukri. 6 - 9 DMG, 33% Chance to Poison (75 gold)" );
									System.out.println ( "4 - Take your Leave" );
									System.out.println ( "\nYou Have " + a[0] + "gold");
									do {
										valleyMerch = input.nextInt();   //input decision
										if (valleyMerch < 0 || valleyMerch > 4) {
											System.out.println ( "You must enter a valid number (0 - 4)" );
										}
									} while (valleyMerch < 0 || valleyMerch > 4);
									switch (valleyMerch) {
										case 0:
											if (a[0] < gGameCost) {
												System.out.println ( "go get some more gold" );
											}
											else {
												int randNumber = 1;   //initialize nested loop
												int game = 1;   //game count
												int score = 6;  //player score, will decrement before first play to 5
												char play = 'y';  //initialize loop to play game
												int number = -9999;  //initialize guess loop
												int ttlpoints = 0;  //total point accumulator
												int gameGold = a[0];
												
												//Game start
												while (play =='y')
												{
													a[0] -= gGameCost;
													randNumber = (int) ( Math.random ( ) * 12 + 1 );  //Generate randNumberom number
													
													//user number must not equal randNumberom number to guess again
													while (number != randNumber)
													{
														score--; //minus one point per guess. starts at 5.
														if (score < 0)
														{
															score = 0; //set score to zero if less than zero
														}
														System.out.println ( score * 2 + " Points remain." ); 
														
														//prompt user for number and output results
														System.out.println ("Enter a number between 1 and 12");
														number = input.nextInt ( );  //users guess
														System.out.println ( "Your number was: " + number);
													
														//output if the number was too high or too low
														if (number > randNumber)
														{
															System.out.println ( "Too high, guess again!" );
														}
														if (number < randNumber)
														{
															System.out.println ( "Too low, guess again!" );
														}
													} //end loop when number = randNumber
													
													ttlpoints += score * 2; //score accumulate to total a[21]
													System.out.println ( "CORRECT! you get " + score * 2 + " Points and " + score * 2 + " gold! \nPlay Again? y/n" );
													a[0] += score * 2;
													a[21] += score * 2;
													do //user must answer 'y' or 'n'
													{
														play = input.next ( ).toLowerCase ( ).charAt ( 0 );  //user inputs character
														if (play != 'y' && play != 'n')  //check character input
														{
															System.out.println ( "You must enter y or n, Play again?" ); //prompt user for correct input
														}
													} while (play != 'y' && play != 'n');  //loop if user enters something other than 'y' or 'n'
													
													//variables must be changed for next round
													if (play == 'y')
													{
														if (a[0] >= gGameCost) {
															number = -9999;  // reset number
															score = 6;  //reset score for round (-1 before first guess)
															game++;   //add one to game number count
														}
														else {
															System.out.println ( "you're out of gold, go get some more... sucker" );
															play = 'n';
														}
													} 
												}//end loop if user inputs 'n'
												 //calculate average and output score
												double avg = (double)ttlpoints / game;
												System.out.println ("GUESSING GAME OVER. Total a[21]: " + ttlpoints);
												System.out.println ("Games played: " + game);
												System.out.println ( "Average Score: " + avg );
												int rev = a[0] - gameGold;
												if (a[0] > gameGold) {
													System.out.println ( "You made " + rev + " gold\n" );
												}
												else {
													System.out.println ( "Loser. " + rev + " gold" );
												}
											}
										break;
										
										case 1:
											if (a[16] < 1) {
												if (a[0] >= hpPotCost) {
													System.out.println ( "You get a bottle of Snake Oil. Use it wisely" );
													a[0] -= hpPotCost;
													a[16] += 1;
												}
												else {
													System.out.println ( "I'm your friend but I still require payment. " );
													System.out.println ( "You only have " + a[0] + " gold..." );
												}
											}
											else {
												System.out.println ( "You can only hold one bottle at a time." );
											}
											break;
										
										case 2:
											if (a[27] < 1) {
												if (a[0] >= dynamiteCost) {
													System.out.println ( "You get a Stick of Dynamite. Use it recklessly" );
													a[0] -= dynamiteCost;
													a[27] ++;
												}
												else {
													System.out.println ( "I'm your friend but I still require payment. " );
													System.out.println ( "You only have " + a[0] + " gold..." );
												}
											}
											else {
												System.out.println ( "You can only hold one explosive at a time." );
											}
											break;
											
										case 3:
											if (a[28] > 0)
											{
												if (a[0] >= cKukriCost)
												{
													System.out.println ( "The Coral Kukri is now yours! DMG: 6-9. careful not to poison yourself..." );
													a[3] = 6;
													a[4] = 9;
													a[0] -= cKukriCost;
													a[28]--;
													a[26] = 1;
													if (a[19] == 1) {
														a[4] += 2;
													}
													if (a[18] == 1) {
														a[4]--;
													}
													if(a[13] == 0)
													{
														a[3]++;
													}
												}
												else
												{
													System.out.println ( "You are too poor for this item. you have " + a[0] + " gold");
												}
											}
											else
											{
												System.out.println ( "Sorry, This item is out of stock." );
											}
											
										break;
										
										case 4:	
																				
									}//end switch
								}//end merchant
						}
					break;
					
					case 3: 
						System.out.println ( "A giant snake drops out of the canopy! " );   //snake
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
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("A leafy tentacle strikes at you form the thick shrubbery!\nAn octopus-like plant wants to devour you!" ); //bat 
						enemyAbility = 'p';
						enemyHP = 50;   
						eType = "Malboro Red";
						aType = " swats";
						killText = "You slay the ";
						deathFlavor = ". upon death it spews 25 gold.";
						minRange = 6; 
						maxRange = 9;
					 	eMinHit = 5; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 25;
						rewardPoints = 170;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
				}	
			}
			if (a[1] < 1) {
				valley = 'n';
			}
			else {
				System.out.println ( "Keep looking around?" );
				do  //check character input
				{
					valley = input.next ( ).toLowerCase ( ).charAt ( 0 );
					if (valley != 'y' && valley != 'n')  
					{
						System.out.println ( "You must enter y or n" );
					}
				} while (valley != 'y' && valley != 'n');
			}
		}
		return a;
		
	}
	
	public static int[] wMarshRoad(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch, String nautical) {
		System.out.println ( "You can feel the humidity rise as your steps begin to sink further into the saturated ground" );
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		int areaCount = 0;
		while (areaCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("The mist thickens into fog, and suddenly a pale figure is right in front of you" ); //Ferns
						enemyAbility = 'v';
						int enemyHP = 35;   
						String eType = "Litchling";
						String aType = " claws ";
						String killText = "You stab the ";
						String deathFlavor = " through the heart and cut off its head. Gross.\nIt was wearing a sapphire pendant. +20 Gold! ";
						int minRange = 4; 
						int maxRange = 9;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 20;
						int rewardPoints = 175;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2: 
						System.out.println ("An Enormous tree stands alone in a small clearing.\nAs you pass, you notice the branches swaying though there is no breeze."  ); //tree
						System.out.println ( "Investigate the tree? y/n" );
						char help;
						do  //check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if (help != 'y' && help != 'n')  
							{
								System.out.println ( "You must enter y or n" );
							}
						} while (help != 'y' && help != 'n'); 
						
						if (help == 'n')  //Don't look
						{
							System.out.println ( "Thats one freaky tree bruh. Exit stage right." );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
								System.out.println ( "There are about 100 crows in the tree, and theyre pissed!" );
								enemyAbility = 'a';
								enemyHP = 50;   
								eType = "Murder Crows";
								aType = " dive bomb ";
								killText = "You Murdered a Murder of ";
								deathFlavor = "!\nThere is a small hole in the base of the tree and you find 25 gold\nanlong with a bottle of Snake Oil!";
								minRange = 7; 
								maxRange = 4;
							 	eMinHit = 6; 
								eMaxHit = 12;
								minFlee = 5; 
								maxFlee = 7;
								heroHit = 9;
								rewardGold = 25;
								rewardPoints = 150;
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
							}
							else 
							{
								System.out.println ( "You can hear a creaky sigh let out from the tree as you approach.\n"
										+ "It gives itself a decent shake and drops 25 gold coins along with a few dead animals\nand a bottle of Snake Oil!"
										+ " + 25 gold!" );
								a[0] += 25;	
							}
							if (a[16] > 0) {
								System.out.println ( "Delicious! +40 HP" );
								a[1] += 40;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "You stowe the snake oil for later." );
								a[16] ++;
							}
						}
					break;
					
					case 3: 
						System.out.println ( "A Horrible Scream stops you in your tracks..." );   //banshee
						enemyAbility = 'a';
						enemyHP = 55;   
						eType = "Banshee";
						aType = " claws";
						killText = "You destroyed a ";
						deathFlavor = "! everyone knows Banshee heads are worth 18 gold. +18 gold";
						minRange = 5; 
						maxRange = 8;
					 	eMinHit = 5; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 8;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 140;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("The mist ahead of you begins to bind cohesively. A figure forms and floats closer" ); //air elemental
						enemyAbility = 'a';
						enemyHP = 45;   
						eType = "Air Elemental";
						aType = " gusts ";
						killText = "You dissipate the ";
						deathFlavor = " and coins drop from the mist... huh? + 20 coins";
						minRange = 7; 
						maxRange = 7;
					 	eMinHit = 6; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 150;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
				}
			} 
			if (areaCount < 3) {
				areaCount++;
				System.out.println ( "Camp " + areaCount + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end marsh road
		
		return a;	
	}
	public static int[] whiteMarsh(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "The White Marsh is Humid, Moist, Creepy, and blindingly white with low visibility." );
		System.out.println ( "Would you like to look around? y/n" );
		int areaCount = 0;
		char enemyAbility;
		char mountain = 'a';
		do  //check character input
		{
			mountain = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (mountain != 'y' && mountain != 'n')  
			{
				System.out.println ( "You must enter y or n" );
			}
		} while (mountain != 'y' && mountain != 'n'); 
		
		while (mountain == 'y')
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("The mist thickens into fog, and suddenly a pale figure is right in front of you" ); //Ferns
						enemyAbility = 'v';
						int enemyHP = 35;   
						String eType = "Litchling";
						String aType = " claws ";
						String killText = "You stab the ";
						String deathFlavor = " through the heart and cut off its head. Gross.\nIt was wearing a sapphire pendant. +20 Gold! ";
						int minRange = 4; 
						int maxRange = 9;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 20;
						int rewardPoints = 175;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
					break;
					
					case 2:  // Horde
						if (a[24] > 0)
						{
							System.out.println ("You come to a large circle of long dead trees.\n"
									+ "As you approach, you notice a glow eminating from the mist."  ); 	// boss
							System.out.println ( "Move closer? y/n" );
							char help;
							do  //check character input
							{
								help = input.next ( ).toLowerCase ( ).charAt ( 0 );
								if (help != 'y' && help != 'n')  
								{
									System.out.println ( "You must enter y or n" );
								}
							} while (help != 'y' && help != 'n'); 
							
							if (help == 'n')  //Don't look
							{
								System.out.println ( "No fucking way..." );
							}
							else
							{
								System.out.println ( "As you approach the glow, a mass of skeletons is uncovered from the mist.\n "
										+ "Their gaze is fixated on a floating jewel, which you imagine is important somehow.\n "
										+ "Suddenly one of the skeletons turns toward you!" );
								System.out.println ( "Have at you! Regen 50% MaxHP" );
								a[1] += a[2] / 2;
								if (a[1] > a[2]) { //hp cannot go above max
									a[1] = a[2];
								}
								System.out.println ( "Press Enter" );
								KeyIn.nextLine ( );
								
								//Boss battle
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
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
								if (a[1] > 0) {
									a[2] += 10; //hp Max + 10
									a[1] = a[2]; // full hp
									a[0] += 50;  // 50 gold
									a[29] --;  //horde dies
									a[21] += 600; // 600 points
								}
							}
						}
						else
						{
							System.out.println ( "You wander back to the spot where you fought the Necro Horde" );
							System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
							a[0] += 1;
						}
						break;
					
					case 3: 
						System.out.println ("An Enormous tree stands alone in a small clearing.\nAs you pass, you notice the branches swaying though there is no breeze."  ); //tree
						System.out.println ( "Investigate the tree? y/n" );
						char help;
						do  //check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if (help != 'y' && help != 'n')  
							{
								System.out.println ( "You must enter y or n" );
							}
						} while (help != 'y' && help != 'n'); 
						
						if (help == 'n')  //Don't look
						{
							System.out.println ( "Thats one freaky tree bruh. Exit stage right." );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
								System.out.println ( "There are about 100 crows in the tree, and theyre pissed!" );
								enemyAbility = 'a';
								enemyHP = 50;   
								eType = "Murder Crows";
								aType = " dive bomb ";
								killText = "You Murdered a Murder of ";
								deathFlavor = "!\nThere is a small hole in the base of the tree and you find 25 gold\nanlong with a bottle of Snake Oil!";
								minRange = 7; 
								maxRange = 4;
							 	eMinHit = 6; 
								eMaxHit = 12;
								minFlee = 5; 
								maxFlee = 7;
								heroHit = 9;
								rewardGold = 25;
								rewardPoints = 150;
								a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
							}
							else 
							{
								System.out.println ( "You can hear a creaky sigh let out from the tree as you approach.\n"
										+ "It gives itself a decent shake and drops 25 gold coins along with a few dead animals\nand a bottle of Snake Oil!"
										+ " + 25 gold!" );
								a[0] += 25;	
							}
							if (a[16] > 0) {
								System.out.println ( "Delicious! +40 HP" );
								a[1] += 40;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "You stowe the snake oil for later." );
								a[16] ++;
							}
						}
					break;
					
					case 4: 
						System.out.println ("The mist ahead of you begins to bind cohesively. A figure forms and floats closer" ); //air elemental
						enemyAbility = 'a';
						enemyHP = 45;   
						eType = "Air Elemental";
						aType = " gusts ";
						killText = "You dissipate the ";
						deathFlavor = " and coins drop from the mist... huh? + 20 coins";
						minRange = 7; 
						maxRange = 7;
					 	eMinHit = 6; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 150;
						a = battleSequence(a, hitChance, hitDMG, attack, minRange, maxRange, eType, aType, eMaxHit, eMinHit, areaCount, 
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, merch, enemyAbility);
					
				}
			}
			if (a[1] > 0) {
				System.out.println ( "Keep Searching the Marsh?" );
				do  //check character input
				{
					mountain = input.next ( ).toLowerCase ( ).charAt ( 0 );
					if (mountain != 'y' && mountain != 'n')  
					{
						System.out.println ( "You must enter y or n" );
					}
				} while (mountain != 'y' && mountain != 'n');
			}
			else {
				mountain = 'n';
			}
		}
		return a;
	}
	
	
	public static void main( String[ ] args )//////////////////////////////////////////////////////////////////////////////////////////////////
	{
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "Enter your name" ); //user enter name
		String player = input.nextLine( );
		char playGame = 'y';
		while (playGame == 'y')
		{
			// Direction
			char forest = 'y';
		   // probabilities
			int minEnc = 1, maxEnc = 2, encNumber = 1, range = maxEnc - minEnc + 1, rand = 0, hitDMG = 0, hitChance = 0;
			//misc
			int hpPotCost = 5, merch = 0;
			final int INNCOST = 15;
			double start = 0.0; //Timer
			
			int [] a = gameArray(); //get array variables
			a = characterClass(a);  //choose character class
			a = warp(a, player);    //warp to chapter
			a[1] = beginGame(a, forest); //hp check initialize
			//loop while hp > 0
			while (a[1] > 0)
			{
				start = System.currentTimeMillis ( );// start timer
				int attack = a[4] - a[3] + 1;  //damage range
				// Chapter 1
				while (a[7] == 1)      
				{
					//Forest
					a = forest( a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack);
					char roadFork = (char) roadFork(a);  //choose direction
					if (roadFork == 'W') //Merchant Road
					{  
						a = merchantRoad( a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack);
					}
					else if (roadFork == 'E')	// Swamp and swamp road
					{
						
						a = swampRoad1(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
						if (a[1] > 0) {
							a = theLake(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
						}
						if (a[1] > 0) {
							a = swampRoad2(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
						}
					}
				}
			
				//Merchant Camp hub- Chapter 2
				if (a[1] > 0) {
					System.out.println ( "You've reached the merchant camp and completed Chapter 1 of your journey." );
					System.out.println ( "HP: " + a[1]);
					System.out.println ( "Gold: " + a[0] );
					System.out.println ( "Press Enter to Continue" );
					KeyIn.nextLine();
				}
				while (a[7] == 2)
				{
					a[25] = 'N';
					merch = 0;
					while (a[25] == 'N')
					{
						a = merchantHub(a, hpPotCost, merch ); //Merchant
						switch (a[25])
						{
							// East to the swamp
							case 'E':
								a = swampRoad1(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								if (a[1] > 0) {
									a = theLake(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);  //the Lake
								}
								if (a[1] > 0) {
									a = swampRoad2(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								}
								break;
								
								//South the the City
							case 'S':
								System.out.println ( "Going to a bustling city sure sounds better than all the savagery you've encountered thus far." );
								System.out.println ( "Press Enter to continue" );         
								KeyIn.nextLine ( );
								System.out.println ( "As you set out, you have a strange feeling about this \"City\"." );
								System.out.println ( "But, The road is flat and lined by trees that are filled with birds singing their songs...\n" );
								a = cityRoad(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								if (a[1] > 0) {
									a= theCity(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, INNCOST);/////the city/////
								}
								if (a[25] != 'N' && a[1] > 0) {
									System.out.println ( "As the gates to the city close behind you, you are filled with determination." );   
									System.out.println ( "Press Enter to continue" );         
									KeyIn.nextLine ( );
									a = cityRoad(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								}
								break;
								
								//West to the Mountain
							case 'W':
								a = mountainRoad1(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								if (a[1] > 0) {
									a = mountainTop(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, player);//the mountain
								}
								if (a[1] > 0) {
									a = mountainRoad2(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								}
								
						}	//End Merchant Fork Switch
					} // End Merchant Hub
				}//end Chapter 2
				
				//Chapter 3
				while (a[7] == 3) 
				{
					String nautical;
					ch3Intro();  //chapter 3 intro
					a[1] = a[2]; //refill health
					a[25] = '1'; //initialize direction loop
					while (a[25] == '1') {
						a = homeHub(a, merch);
						switch (a[25]) {
							
							case 2:
								int eastWest = 0;
								System.out.println ( "The trees and ferns of Shimmering Valley all perpetually covered in dew\nby the mist that rolls in from the distant marsh." );
								nautical = "East";
								a = sValleyRoad(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, nautical);
								if(a[1] > 0) {
									a = sValley(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								}
								if(a[1] > 0) {
									System.out.println ( "Head back home or onward to the White Marsh?" );
									System.out.println ( "1 - Home\n2 - Marsh" );
									do {
										eastWest = input.nextInt ( );
										if (eastWest < 1 || eastWest > 2) {
											System.out.println ( "You must enter 1 to go Home or 2 for the Marsh" );
										}	
									}while (eastWest < 1 || eastWest > 2);
								}
								if (eastWest == 1) {
									nautical = "West";
									a = sValleyRoad (a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, nautical);
									a[25] = '1';
								}
								else if (eastWest == 2){
									nautical = "East";
									a = wMarshRoad (a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, nautical);
									if (a[1] > 0) {
										a = whiteMarsh(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
									}
									if (a[1] > 0) {
										nautical = "West";
										System.out.println ( "You find the trail and head back west but everything looks different.\n "
												+ "After what seems like a couple of hours, you realize that you are now\n "
												+ "walking amongst the split trails of the shimmering valley...\n" );
										a = sValleyRoad (a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, nautical);
										a[25] = '1';
									}
								}
							break;
							
							case 3:
								System.out.println ( "Arid Plains" );
								a[25] = '1';
							break;
								
							case 4:
								System.out.println ( "Frozen Desert" );
								a[25] = '1';
							break;
								
							case 5:
								System.out.println ( "Sleeping Forest" );
								a[25] = '1';
							
							
						}
					}
				}
			}//end HP > 0
			double end = System.currentTimeMillis ( );
			double time = end - start;
			int minutes = (int)(time / 1000 / 60);
			int seconds = (int)(time / 1000 % 60);
			System.out.println ( "\nGAME OVER :(" );
			System.out.println ( "TIME: " + minutes + " min " + seconds + " sec");
			if (minutes > 15) 
			{
				int penalty = (minutes - 15) * 50;
				System.out.println ( "Time Penalty -" + penalty + " points" );
				a[21] -= penalty;
			}
			System.out.println ( "SCORE: " + a[21] );
			System.out.println ( "Play Again? y/n" );
			do  //check character input
			{
				playGame = input.next ( ).toLowerCase ( ).charAt ( 0 );
				if (playGame != 'y' && playGame != 'n')  
				{
					System.out.println ( "You must enter y or n. Play Again?" );
				}
			} while (playGame != 'y' && playGame != 'n'); 
		}//playGame
		
		
	}//Main
}//Class 



