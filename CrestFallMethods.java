import java.util.Scanner;

public class CrestFallMethods
{
	@SuppressWarnings("unused")
	public static int[] gameArray() {
		int [] a = new int[26];
		int gold, hp, hpMax, minDMG, maxDMG, dex, evade, chapter, ladyOfLake, sSword, lSword, lArmor, mBoots, mDagger, mShield;
		int bSword, hpPot, merchCount, loser, fighter, victim, points, battleDec, city, chaosDemonLife;
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
			System.out.println ( "You're a a[18] so you kind of suck at everything -1 a[5], -1 a[6], -1 Max DMG\n But a lifetime of being picked on gives you more resilience + 10 Max HP" );
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
	public static int[ ] forest(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int attack, int hitDMG) {
		//Journey through the forest
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		int forestCount = 0;
		System.out.println ( "You begin your journey heading South through the overgrown Elderwood forest" );
		while (forestCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
				case 1: System.out.println ("You stumbled accross a Bear, Fuck" );   //Bear fight
				int bearHP = 12;   //enemy health initialize
				while (bearHP > 0)  //fight sequence
				{	
					int bear = (int) ( Math.random ( ) * 8 + 3 ); //enemy attack range
					System.out.println ( "Bear attacks for " + bear + " damage.");
					hitChance = (int) ( Math.random ( ) * 10 + 4);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= bear; //player attacked
						System.out.println ( "-" + bear + " HP. " + "HP is " + a[1]);
						if (a[1] < 1) //on death condition, reset vars to go to game over
						{
							a[7] = 0;
							forestCount = 9;
							bearHP = 0;
							break;
						}
					}
					  //battle decision
					System.out.println ( "1-Attack, 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) { //flee decision
						hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
						if (a[6] > hitChance) {  //flee successful
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else { //flee unsuccessful
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);  //possible damage range
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)  //success to hit
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							bearHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
				}
				if (bearHP <= 0) { //enemy dead, get rewards
					if (a[1] > 0) {
						System.out.println ( "You killed a Bear! +5 gold for some reason" );
						a[0] += 5;
						a[21] += 50;
					}
				}
				break;
				
				case 2: System.out.println ("You hear some little Goblins creeping around"  );
				int gobHP = 8;
				while (gobHP > 0)  //fight sequence
				{	
					int goblin = (int) ( Math.random ( ) * 5 + 1 );
					System.out.println ( "Goblin attacks for " + goblin + " damage.");
					hitChance = (int) ( Math.random ( ) * 10 + 5);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= goblin;
						System.out.println ( "-" + goblin + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							forestCount = 9;
							gobHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 8 + 5);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							gobHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
				}
				if (gobHP <= 0) {
					if (a[1] > 0) {
						System.out.println ( "You killed some Goblins! and found 3 gold!" );
						a[0] += 3;
						a[21] += 10;
					}
				}
				break;
				
				case 3: System.out.println ( "An Elf appears... to be very menacing!" );
				int elfHP = 8;
				while (elfHP > 0)  //fight sequence
				{	
					int elf = (int) ( Math.random ( ) * 5 + 3 );
					System.out.println ( "Crazy Elf attacks for " + elf + " damage.");
					hitChance = (int) ( Math.random ( ) * 10 + 6);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= elf;
						System.out.println ( "-" + elf + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							forestCount = 9;
							elfHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							elfHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
				}
				if (elfHP <= 0) {
					if (a[1] > 0) {
					System.out.println ( "You killed a crazy theiving Elf, and robbed his corpse of 6 gold! Awesome!" );
					a[0] += 6;
					a[21] += 30;
					}
				}
				}//end switch
			
			}
			if (a[1] < 1) {
				break;
			}
			forestCount++;
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			System.out.println ( "Camp " + forestCount + ". Press Enter to continue South" );
			KeyIn.nextLine ( );
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
		int MerchRoadCount = 0;
		while (MerchRoadCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
				case 1: System.out.println ("Two Naked Bums jump out at you from the ditch!" );
				int bumHP = 12;
				while (bumHP > 0)  //fight sequence
				{	
					int bums = (int) ( Math.random ( ) * 6 + 1 );
					System.out.println ( "Bum Twins attack for " + bums + " damage.");
					hitChance = (int) ( Math.random ( ) * 10 + 4);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= bums;
						System.out.println ( "-" + bums + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							MerchRoadCount = 9;
							bumHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							bumHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
				}
				if (bumHP <= 0){
					if (a[1] > 0) {
					System.out.println ( "You killed two Naked Bums! They each had 2 coins stached... somewhere. + 4 gold" );
					a[0] += 4;
					a[21] += 25;
					}
				}
				break;
				
				case 2: System.out.println ("A man is busy mending the wheel for his cart"  ); // cart man/ Bandit
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
						int banditHP = 8;
						while (banditHP > 0)  //fight sequence
						{	
							int bandit = (int) ( Math.random ( ) * 6 + 4 );
							System.out.println ( "Bandit attacks for " + bandit + " damage.");
							hitChance = (int) ( Math.random ( ) * 10 + 4);  //chance to a[6]
							if (a[6] > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								a[1] -= bandit;
								System.out.println ( "-" + bandit + " HP. " + "HP is " + a[1]);
								if (a[1] < 1)
								{
									a[7] = 0;
									MerchRoadCount = 9;
									banditHP = 0;
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 0-Flee" );
							a[22] = input.nextInt();
							if (a[22] == 0) {
								hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
								if (a[6] > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
						
							//attack
							if (a[22] == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + a[3]);
								hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
								if (a[5] >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									banditHP -= hitDMG;
								}
								else
								{
									System.out.println ( "But you miss! Lame!" );
								}
							}
						}
						if (banditHP <= 0) {
							if (a[1] > 0) {
								System.out.println ( "You killed a Bandit, and robbed his corpse of 8 gold! Nice..." );
								a[0] += 8;
								a[21] += 50;
							}
						}
					}
					else
					{
						if (a[1] > 0) {
							System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
							System.out.println ( "He gives you 10 gold for your services and company" );
							a[0] += 10;
						}
					}
				}
				
				break;
				
				case 3: System.out.println ( "A dark figure on a horse approaches..." );   //Marauder
				int marauderHP = 10;
				while (marauderHP > 0)  //fight sequence
				{	
					int marauder = (int) ( Math.random ( ) * 8 + 5 );
					System.out.println ( "Marauder attacks for " + marauder + " damage.");
					hitChance = (int) ( Math.random ( ) * 10 + 5);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= marauder;
						System.out.println ( "-" + marauder + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							MerchRoadCount = 9;
							marauderHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							marauderHP -= hitDMG;
						}
						else
						{
							System.out.println ( "But you miss! Lame!" );
						}
					}
				}
				if (marauderHP <= 0) {
					if (a[1] > 0) {
						System.out.println ( "You killed a Marauder and took his purse, but his horse ran away. + 7 gold" );
						a[0] += 7;
						a[21] += 40;
					}
				}
				}
			
			}
			if (a[1] < 1) {
				break;
			}
			MerchRoadCount++;
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			System.out.println ( "Camp " + MerchRoadCount + ". Press Enter to continue West" );
			KeyIn.nextLine ( );
		}
		a[7] = 2;
		
		
		return a;
	} //End Merchant Road
	
	public static int[] swampRoad1 (int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		a[25] = 'E';
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "Lets take the muddy road then..." );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "The road meanders to the SouthEast and the air cathces a chill" );
		int swampRoadCount = 0;
		while (swampRoadCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: System.out.println ("A small pack of wolves surround you!" ); //wolf pack
					int wolfHP = 15;
					while (wolfHP > 0)  //fight sequence
					{	
						int wolf = (int) ( Math.random ( ) * 7 + 2 );
						System.out.println ( "Wolf lunges for " + wolf + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= wolf;
							System.out.println ( "-" + wolf + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								swampRoadCount = 9;
								wolfHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								wolfHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (wolfHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed the wolves and find their previous a[20]'s bones nearby. +5 gold" );
							a[0] += 5;
							a[21] += 30;
						}
					}
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
							int wraithHP = 18;
							while (wraithHP > 0)  //fight sequence
							{	
								int wraith = (int) ( Math.random ( ) * 8 + 4 );
								System.out.println ( "wraith attacks for " + wraith + " damage.");
								hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to a[6]
								if (a[6] > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									a[1] -= wraith;
									System.out.println ( "-" + wraith + " HP. " + "HP is " + a[1]);
									if (a[1] < 1)
									{
										a[7] = 0;
										a[25] = 'A';
										merch = 0;
										swampRoadCount = 9;
										wraithHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
								a[22] = input.nextInt();
								if (a[22] == 0) {
									hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
									if (a[6] > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
							
								//attack
								if (a[22] == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + a[3]);
									hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
									if (a[5] >= hitChance)
									{
										System.out.println ( "You hit for " + hitDMG + " DMG" );
										wraithHP -= hitDMG;
									}
									else
									{
										System.out.println ( "You miss! Lame!" );
									}
								}
								//potion
								if (a[22] == 5) {
									if (a[16] > 0) {
										System.out.println ( "That Sauce is Awesome! +25HP" );
										a[16] --;
										a[21] -= 25;
										a[1] += 25;
										if (a[1] > a[2]) {
											a[1] = a[2];
										}
									}
									else {
										System.out.println ( "Fool! You have no Sauce in supply!" );
									}
								}
							}
							if (wraithHP <= 0) {
								if (a[1] > 0) {
									System.out.println ( "You killed a Wraith! It dropped a garnet worth 8 gold, Nice..." );
									a[0] += 8;
									a[21] += 50;
								}
							}
						}
						else 
						{
							if (a[1] > 0) {
								System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
								a[0] += 8;
							}
							
						}
					}
					break;
					
					case 3: System.out.println ( "A MudMan grows rapidly in front of you like an Oozing pillar " );   //MudMan
					int mudManHP = 14;
					while (mudManHP > 0)  //fight sequence
					{	
						int mudMan = (int) ( Math.random ( ) * 8 + 3 );
						System.out.println ( "MudMan attacks for " + mudMan + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= mudMan;
							System.out.println ( "-" + mudMan + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								swampRoadCount = 9;
								mudManHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								mudManHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (mudManHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 5 gold" );
							a[0] += 5;
							a[21] += 40;
						}
					}
					break;
					
					case 4: System.out.println ("A Giant Leech! Disgusting!" ); //leech 
					int leechHP = 14;
					while (leechHP > 0)  //fight sequence
					{	
						int leech = (int) ( Math.random ( ) * 8 + 3 );
						System.out.println ( "Leech swats for " + leech + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 4);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= leech;
							System.out.println ( "-" + leech + " HP. " + "HP is " + a[1]);
							double vamp = leech * 0.25;  //leech heals 25% damage given
							int iVamp = (int) vamp;
							if (iVamp > 0) {   // output if necessary
								System.out.println ( "Giant Leech heals " + iVamp + " HP" );
								leechHP += iVamp;
							}
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								swampRoadCount = 9;
								leechHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								leechHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (leechHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You Skewer the Giant Leech. Gross! it expells 6 gold" );
							a[0] += 6;
							a[21] += 35;
						}
					}
					if (a[1] < 1) {
						break;
					}
				}
				if (a[1] < 1) {
					break;
				}
			} 
			if (a[1] < 1) {
				break;
			}
			swampRoadCount++;
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue East" );
			KeyIn.nextLine ( );
		}// end swamp road
		
		
		return a;	
	}
	public static int[] theLake(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		a[25] = 'E';
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char lake;                                                                              //the lake
		if (a[1] > 0) {
			System.out.println ( "You find yourself standing at the edge of a large lake" );
			System.out.println ( "There is only one path leading out and it heads northWest" );
			System.out.println ( "Would you like to look around? y/n" );
		}
		do  //check character input
		{
			lake = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if (lake != 'y' && lake != 'n')  
			{
				System.out.println ( "You must enter y or n" );
			}
		} while (lake != 'y' && lake != 'n'); 
		if (a[1] < 1) {
			lake = 'n';
		}
		while (lake == 'y')
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: System.out.println ("A viscious looking pack of wolves surround you!" ); //wolf pack
					int wolfHP = 20;
					while (wolfHP > 0)  //fight sequence
					{	
						int wolf = (int) ( Math.random ( ) * 8 + 3 );
						System.out.println ( "Wolf lunges for " + wolf + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= wolf;
							System.out.println ( "-" + wolf + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								lake = 'n';
								wolfHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								wolfHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (wolfHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed the wolves and find their previous victim's bones nearby. + 7 gold" );
							a[0] += 7;
							a[21] += 40;
						}
					}
					break;
					
					case 2: 
						if (a[8] > 0)
						{
							System.out.println ("You hear someone singing..."  ); 								// Lady of the Lake
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
								System.out.println ( "She hands you a short sword that glows faintly green. The lady disappears upon taking the sword");
								System.out.println ( "You've acquired PhantomBane! DMG 5-8" );
								a[3] = 5;
								a[4] = 8;
								a[8]--;
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
						}
						else
						{
							System.out.println ( "Here is where you met the lady of the lake" );
							System.out.println ( "You can feel her spirit well up inside of you. Regen 25% MaxHP!" );
							a[1] += a[2] / 4;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
							System.out.println ( "HP= " + a[1] );
						}
						break;
					
					case 3: System.out.println ( "A PooPoo Man plops in front of you from seemingly nowhere. " );   //MudMan
					int mudManHP = 20;
					while (mudManHP > 0)  //fight sequence
					{	
						int mudMan = (int) ( Math.random ( ) * 9 + 3 );
						System.out.println ( "PooPoo Man attacks for " + mudMan + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 6);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= mudMan;
							System.out.println ( "-" + mudMan + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								lake = 'n';
								mudManHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 6 + 6);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you slip on some shit and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								mudManHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (mudManHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed that Piece of Shit! It has some coins stuck in it. + 8 gold" );
							a[0] += 8;
							a[21] += 70;
						}
					}
					break;
					
					case 4: System.out.println ("A Massive Leech! Horrifying!" ); //leech 
					int leechHP = 18;
					while (leechHP > 0)  //fight sequence
					{	
						int leech = (int) ( Math.random ( ) * 8 + 4 ); // damage range
						System.out.println ( "Leech swats for " + leech + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 4);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= leech;
							System.out.println ( "-" + leech + " HP. " + "HP is " + a[1]);
							double vamp = leech * 0.25;  //leech heals 25% damage given
							int iVamp = (int) vamp;
							if (iVamp > 0) {   // output if necessary
								System.out.println ( "Massive Leech heals " + iVamp + " HP" );
								leechHP += iVamp;
							}
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								lake = 'n';
								leechHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								leechHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (leechHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You disembowel the Massive Leech. Gross! it expells 8 gold" );
							a[0] += 8;
							a[21] += 60;
						}
					}
					if (a[1] < 1) {
						break;
					}
				}
				if (a[1] < 1) {
					break;
				}
			}
			if (a[1] < 1) {
				break;
			}
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
		
		
		return a;
	}
	public static int[] swampRoad2(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		a[25] = 'E';
		System.out.println ( "The only road out is northwest to the Merchant Camp" );               //other side of lake
		System.out.println ( "Enter to continue" );
		KeyIn.nextLine();
		System.out.println ( "You now head northWest along another muddy trail." );
		int swampRoadCount = 0;
		while (swampRoadCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
				case 1: System.out.println ("A small pack of wolves surround you!" ); //wolf pack
				int wolfHP = 15;
				while (wolfHP > 0)  //fight sequence
				{	
					int wolf = (int) ( Math.random ( ) * 7 + 2 );
					System.out.println ( "Wolf lunges for " + wolf + " damage.");
					hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= wolf;
						System.out.println ( "-" + wolf + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							a[25] = 'A';
							merch = 0;
							swampRoadCount = 9;
							wolfHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							wolfHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
					//potion
					if (a[22] == 5) {
						if (a[16] > 0) {
							System.out.println ( "That Sauce is Awesome! +25HP" );
							a[16] --;
							a[21] -= 25;
							a[1] += 25;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
						}
						else {
							System.out.println ( "Fool! You have no Sauce in supply!" );
						}
					}
				}
				if (wolfHP <= 0) {
					if (a[1] > 0) {
						System.out.println ( "You killed the wolves and find their previous victim's bones nearby. +5 gold" );
						a[0] += 5;
						a[21] += 30;
					}
				}
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
						int wraithHP = 24;
						while (wraithHP > 0)  //fight sequence
						{	
							int wraith = (int) ( Math.random ( ) * 10 + 3 );
							System.out.println ( "Rotten Wraith attacks for " + wraith + " damage.");
							hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
							if (a[6] > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								a[1] -= wraith;
								System.out.println ( "-" + wraith + " HP. " + "HP is " + a[1]);
								if (a[1] < 1)
								{
									a[7] = 0;
									a[25] = 'A';
									merch = 0;
									swampRoadCount = 9;
									wraithHP = 0;
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
							a[22] = input.nextInt();
							if (a[22] == 0) {
								hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
								if (a[6] > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
						
							//attack
							if (a[22] == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + a[3]);
								hitChance = (int) ( Math.random ( ) * 10);  //chance to hit
								if (a[5] >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									wraithHP -= hitDMG;
								}
								else
								{
									System.out.println ( "You miss! Lame!" );
								}
							}
							//potion
							if (a[22] == 5) {
								if (a[16] > 0) {
									System.out.println ( "That Sauce is Awesome! +25HP" );
									a[16] --;
									a[21] -= 25;
									a[1] += 25;
									if (a[1] > a[2]) {
										a[1] = a[2];
									}
								}
								else {
									System.out.println ( "Fool! You have no Sauce in supply!" );
								}
							}
						}
						if (wraithHP <= 0) {
							if (a[1] > 0) {
								System.out.println ( "You killed a Rotten Wraith! It dropped a garnet worth 8 gold, Nice..." );
								a[0] += 8;
								a[21] += 80;
							}
						}
					}
					else 
					{
						if (a[1] > 0) {
							System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
							a[0] += 8;
						}
					}
				}
				break;
				
				case 3: System.out.println ( "A Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
				int mudManHP = 14;
				while (mudManHP > 0)  //fight sequence
				{	
					int mudMan = (int) ( Math.random ( ) * 8 + 5 );
					System.out.println ( "mudMan attacks for " + mudMan + " damage.");
					hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= mudMan;
						System.out.println ( "-" + mudMan + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							a[25] = 'A';
							merch = 0;
							swampRoadCount = 9;
							mudManHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							mudManHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
					//potion
					if (a[22] == 5) {
						if (a[16] > 0) {
							System.out.println ( "That Sauce is Awesome! +25HP" );
							a[16] --;
							a[21] -= 25;
							a[1] += 25;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
						}
						else {
							System.out.println ( "Fool! You have no Sauce in supply!" );
						}
					}
				}
				if (mudManHP <= 0) {
					if (a[1] > 0) {
							System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 5 gold" );
							a[0] += 5;
							a[21] += 40;
					}
				}
				break;
				
				case 4: System.out.println ("A Giant Leech! Disgusting!" ); //leech 
				int leechHP = 14;
				while (leechHP > 0)  //fight sequence
				{	
					int leech = (int) ( Math.random ( ) * 8 + 3 );
					System.out.println ( "Leech swats for " + leech + " damage.");
					hitChance = (int) ( Math.random ( ) * 12 + 4);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= leech;
						System.out.println ( "-" + leech + " HP. " + "HP is " + a[1]);
						double vamp = leech * 0.25;  //leech heals 25% damage given
						int iVamp = (int) vamp;
						if (iVamp > 0) {   // output if necessary
							System.out.println ( "Giant Leech heals " + iVamp + " HP" );
							leechHP += iVamp;
						}
						if (a[1] < 1)
						{
							a[7] = 0;
							a[25] = 'A';
							merch = 0;
							swampRoadCount = 9;
							leechHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							leechHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
					//potion
					if (a[22] == 5) {
						if (a[16] > 0) {
							System.out.println ( "That Sauce is Awesome! +25HP" );
							a[16] --;
							a[21] -= 25;
							a[1] += 25;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
						}
						else {
							System.out.println ( "Fool! You have no Sauce in supply!" );
						}
					}
				}
				if (leechHP <= 0) {
					if (a[1] > 0) {
						System.out.println ( "You Skewer the Giant Leech. Gross! it expells 6 gold" );
						a[0] += 6;
						a[21] += 35;
					}
				}
				if (a[1] < 1) {
					break;
				}
				}
			if (a[1] < 1) {
				break;
			}
		}
		if (a[1] < 1) {
			break;
		}
		swampRoadCount++;
		rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
		System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue West" );
		KeyIn.nextLine ( );
		a[25] = 'N';
		a[17] = 0;
		}// end swamp road 2
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
		System.out.println ( "2 - A Heavy Iron Long Sword (-1 a[5]). DMG 4-9 (15 gold) In Stock: " + a[10] );
		int lArmorCost = 15;
		System.out.println ( "3 - Leather Armour. + 1 a[6]. (15 gold). InStock: " + a[11]);
		int mBootsCost = 30;
		System.out.println ( "4 - Mercurial Dancing Boots. + 1 a[6] (30 gold). In Stock " + a[12]);
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
						System.out.println ( "The strange looking boots fit! +1 Evade. You feel lighter" );
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
		int cityRoadCount = 0;
		while (cityRoadCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
				case 1: System.out.println ("You hear a faint sound and turn in time to see a thief cutting your purse!" ); //thief
				int thiefHP = 15;
				while (thiefHP > 0)  //fight sequence
				{	
					int thief = (int) ( Math.random ( ) * 6 + 4 );  //enemy attack
					System.out.println ( "Thief attacks for " + thief + " damage.");
					hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= thief;
						System.out.println ( "-" + thief + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							a[25] = 'A';
							merch = 0;
							cityRoadCount = 9;
							thiefHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							thiefHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
					//potion
					if (a[22] == 5) {
						if (a[16] > 0) {
							System.out.println ( "That Sauce is Awesome! +25HP" );
							a[16] --;
							a[21] -= 25;
							a[1] += 25;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
						}
						else {
							System.out.println ( "Fool! You have no Sauce in supply!" );
						}
					}
				}
				if (a[1] > 0) {
					System.out.println ( "You kill the thief. His purse was pretty light. + 5 gold" );
					a[0] += 5;
					a[21] += 40;
				}
				break;
				
				case 2: System.out.println ("A terrified looking man runs up to you from the West" ); // distress/ Necromancer
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
						System.out.println ( "The \"man in need\" is a Necromancer!  His thralls saunter your way" );
						int thrallHP = 20;
						while (thrallHP > 0)  //fight sequence
						{	
							int thrall = (int) ( Math.random ( ) * 9 + 3 );
							System.out.println ( "Thrall attacks for " + thrall + " damage.");
							hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
							if (a[6] > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								a[1] -= thrall;
								System.out.println ( "-" + thrall + " HP. " + "HP is " + a[1]);
								if (a[1] < 1)
								{
									a[7] = 0;
									a[25] = 'A';
									merch = 0;
									cityRoadCount = 9;
									thrallHP = 0;
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
							a[22] = input.nextInt();
							if (a[22] == 0) {
								hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
								if (a[6] > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
						
							//attack
							if (a[22] == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + a[3]);
								hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
								if (a[5] >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									thrallHP -= hitDMG;
								}
								else
								{
									System.out.println ( "You miss! Lame!" );
								}
							}
							//potion
							if (a[22] == 5) {
								if (a[16] > 0) {
									System.out.println ( "That Sauce is Awesome! +25HP" );
									a[16] --;
									a[21] -= 25;
									a[1] += 25;
									if (a[1] > a[2]) {
										a[1] = a[2];
									}
								}
								else {
									System.out.println ( "Fool! You have no Sauce in supply!" );
								}
							}
						}
						if (thrallHP <= 0) {
							if (a[1] > 0) {
								System.out.println ( "You killed the necromancers Thralls! But the Necromancer disappeared..." );
								System.out.println ( "Looking through his useless cart you find 12 gold! Nice!" );
								a[0] += 12;
								a[21] += 60;
							}
						}
					}
					else
					{
						if (a[1] > 0) {
							System.out.println ( "You help the man gather what he needs and he is grateful for your help." );
							System.out.println ( "He hands you 10 gold with thanks. +10 gold!" );
							a[0] += 10;
						}
					}
				}
				break;
				
				case 3: System.out.println ( "You hear an Eagle screech... nope, thats a Wyvren! " );                   //Wyvren
				int wyvrenHP = 25;
				while (wyvrenHP > 0)  //fight sequence
				{	
					int wyvren = (int) ( Math.random ( ) * 9 + 5 );
					System.out.println ( "Wyvren claws at you for " + wyvren + " damage.");
					hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to a[6]
					if (a[6] > hitChance) 
					{
						System.out.println ( "But Misses!" );
					}
					else
					{
						a[1] -= wyvren;
						System.out.println ( "-" + wyvren + " HP. " + "HP is " + a[1]);
						if (a[1] < 1)
						{
							a[7] = 0;
							a[25] = 'A';
							merch = 0;
							cityRoadCount = 9;
							wyvrenHP = 0;
							break;
						}
					}
					 //battle decision
					System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
					a[22] = input.nextInt();
					if (a[22] == 0) {
						hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
						if (a[6] > hitChance) {
							System.out.println ( "You run away! Coward!" );
							break;
						}
						else {
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
					}
					
					//attack
					if (a[22] == 1) {
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);
						hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
						if (a[5] >= hitChance)
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							wyvrenHP -= hitDMG;
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
					}
					//potion
					if (a[22] == 5) {
						if (a[16] > 0) {
							System.out.println ( "That Sauce is Awesome! +25HP" );
							a[16] --;
							a[21] -= 25;
							a[1] += 25;
							if (a[1] > a[2]) {
								a[1] = a[2];
							}
						}
						else {
							System.out.println ( "Fool! You have no Sauce in supply!" );
						}
					}
				}
				if (wyvrenHP <= 0) {
					if (a[1] > 0) {
						System.out.println ( "You killed a Wyvren! WOW! you cut open its belly and find 11 gold!" );
						a[0] += 11;
						a[21] += 100;
					}
				}
				if (a[1] < 1) {
					break;
				}
				}
				if (a[1] < 1) {
					break;
				}
			} 
			if (a[1] < 1) {
				break;
			}
			cityRoadCount++;
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			System.out.println ( "Camp " + cityRoadCount + ". Press Enter to continue South" );
			KeyIn.nextLine ( );
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
			System.out.println ( "4 - Get a room at the Inn. (20 gold)");
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
					System.out.println ( "HP: " + a[1]);
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
						System.out.println ( "4 - Return to Armorer Entrance" );
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
										System.out.println ( "A chill flows from your palm to the top of your head." );
										System.out.println ( "It feels as though you pulled this sword from its own grave" );
										System.out.println ( "DMG = 6 - 12" );
										a[3] = 6;
										a[4] = 12;
										a[0] -= bSwordCost;
										a[15]--;
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
					int citySearch;
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
							case 1: System.out.println ("A fight started up outside the pub \n and some Drunkass threw his tankard at you..." ); //thief pack
							int DrunkassHP = 25;
							while (DrunkassHP > 0)  //fight sequence
							{	
								int Drunkass = (int) ( Math.random ( ) * 12 + 5 );
								System.out.println ( "Drunkass attacks for " + Drunkass + " damage.");
								hitChance = (int) ( Math.random ( ) * 11 + 3);  //chance to a[6]
								if (a[6] > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									a[1] -= Drunkass;
									System.out.println ( "-" + Drunkass + " HP. " + "HP is " + a[1]);
									if (a[1] < 1)
									{
										a[7] = 0;
										a[25] = 'A';
										merch = 0;
										a[23] = 6;
										citySearch = 'n';
										DrunkassHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
								a[22] = input.nextInt();
								if (a[22] == 0) {
									hitChance = (int) ( Math.random ( ) * 8 + 3);  //chance to flee
									if (a[6] > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
								
								//attack
								if (a[22] == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + a[3]);
									hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
									if (a[5] >= hitChance)
									{
										System.out.println ( "You hit for " + hitDMG + " DMG" );
										DrunkassHP -= hitDMG;
									}
									else
									{
										System.out.println ( "Drunkass falls over and you miss! Lame!" );
									}
								}
								//potion
								if (a[22] == 5) {
									if (a[16] > 0) {
										System.out.println ( "That Sauce is Awesome! +25HP" );
										a[16] --;
										a[21] -= 25;
										a[1] += 25;
										if (a[1] > a[2]) {
											a[1] = a[2];
										}
									}
									else {
										System.out.println ( "Fool! You have no Sauce in supply!" );
									}
								}
							}
							if (DrunkassHP <= 0) {
								if (a[1] > 0) {
									System.out.println ( "You knocked out that Asshole and picked up the\n gold tooth you knocked out of his mouth. +10 gold" );
									a[0] += 10;
									a[21] += 80;
								}
							}
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
									System.out.println ( "Thats way too Creepy. You walk the other way" );
								}
								else
								{
									System.out.println ( "You come accross two Greasy Vandals attempting an unsavory act upon a young lady" );
									System.out.println ( "You meet their eyes and your fist clenches your blade");
									int vandalHP = 45;
									while (vandalHP > 0)  //fight sequence
									{	
										int vandal = (int) ( Math.random ( ) * 11 + 4 );
										System.out.println ( "Greasy Vandal slashes for " + vandal + " damage.");
										hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
										if (a[6] > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											a[1] -= vandal;
											System.out.println ( "-" + vandal + " HP. " + "HP is " + a[1]);
											if (a[1] < 1)
											{
												a[7] = 0;
												a[25] = 'A';
												merch = 0;
												citySearch = 'n';
												a[23] = 6;
												vandalHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
										a[22] = input.nextInt();
										if (a[22] == 0) {
											hitChance = (int) ( Math.random ( ) * 8 + 5);  //chance to flee
											if (a[6] > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										//attack
										if (a[22] == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + a[3]);
											hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
											if (a[5] >= hitChance)
											{
												System.out.println ( "You hit for " + hitDMG + " DMG" );
												vandalHP -= hitDMG;
											}
											else
											{
												System.out.println ( "You miss! Lame!" );
											}
										}
										//potion
										if (a[22] == 5) {
											if (a[16] > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												a[16] --;
												a[21] -= 25;
												a[1] += 25;
												if (a[1] > a[2]) {
													a[1] = a[2];
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (vandalHP <= 0) {
										if (a[1] > 0) {
											System.out.println ( "You killed a couple Greasy Vandals and saved the girl!" );
											System.out.println ( "She is shaken, but thanks you and gives you a kiss on the cheek" );
											System.out.println ( "It felt so wonderful you breifly closed your eyes\n When you opened them she was gone" );
											System.out.println ( "+25 Max HP" );
											a[2] += 25;
											a[20]--;
											a[21] += 200;
										}
									}
								}
							}
							else
							{
								if (a[1] > 0) {
									System.out.println ( "You wander back to the spot where you saved that young lady" );
									System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
									a[0] += 1;
								}
							}
							break;
							
							case 3: System.out.println ( "Its a Giant Sewer Rat! " );   //Sewer Rat
							int ratHP = 25;
							while (ratHP > 0)  //fight sequence
							{	
								int rat = (int) ( Math.random ( ) * 8 + 5 );
								System.out.println ( "Giant Sewer Rat bites for " + rat + " damage.");
								hitChance = (int) ( Math.random ( ) * 12 + 6);  //chance to a[6]
								if (a[6] > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									a[1] -= rat;
									System.out.println ( "-" + rat + " HP. " + "HP is " + a[1]);
									if (a[1] < 1)
									{
										a[7] = 0;
										a[25] = 'A';
										merch = 0;
										citySearch = 'n';
										a[23] = 6;
										ratHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
								a[22] = input.nextInt();
								if (a[22] == 0) {
									hitChance = (int) ( Math.random ( ) * 6 + 6);  //chance to flee
									if (a[6] > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
								
								//attack
								if (a[22] == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + a[3]);
									hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
									if (a[5] >= hitChance)
									{
										System.out.println ( "You hit for " + hitDMG + " DMG" );
										ratHP -= hitDMG;
									}
									else
									{
										System.out.println ( "You miss! Lame!" );
									}
								}
								//potion
								if (a[22] == 5) {
									if (a[16] > 0) {
										System.out.println ( "That Sauce is Awesome! +25HP" );
										a[16] --;
										a[21] -= 25;
										a[1] += 25;
										if (a[1] > a[2]) {
											a[1] = a[2];
										}
									}
									else {
										System.out.println ( "Fool! You have no Sauce in supply!" );
									}
								}
							}
							if (ratHP <= 0) {
								if (a[1] > 0) {
									System.out.println ( "You killed a Giant Sewer Rat! Gross!" );
									System.out.println ( "One of the locals witnessed your heroic deed and hands you 15 gold" );
									a[0] += 15;
									a[21] += 100;
								}
							}
							break;
							
							case 4: System.out.println ("A robed figure leaps from the shadows and stabs at you without warning" ); //cultist 
							int cultistHP = 20;
							while (cultistHP > 0)  //fight sequence
							{	
								int cultist = (int) ( Math.random ( ) * 8 + 5 );
								System.out.println ( "Cultist stabs wildly for " + cultist + " damage.");
								hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
								if (a[6] > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									a[1] -= cultist;
									System.out.println ( "-" + cultist + " HP. " + "HP is " + a[1]);
									double vamp = cultist * 0.25;  //cultist heals 25% damage given
									int iVamp = (int) vamp;
									if (iVamp > 0) {   // output if necessary
										System.out.println ( "Cultist heals " + iVamp + " HP" );
										cultistHP += iVamp;
									}
									if (a[1] < 1)
									{
										a[7] = 0;
										a[25] = 'A';
										merch = 0;
										citySearch = 'n';
										a[23] = 6;
										cultistHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
								a[22] = input.nextInt();
								if (a[22] == 0) {
									hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
									if (a[6] > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
								
								//attack
								if (a[22] == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + a[3]);
									hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
									if (a[5] >= hitChance)
									{
										System.out.println ( "You hit for " + hitDMG + " DMG" );
										cultistHP -= hitDMG;
									}
									else
									{
										System.out.println ( "You miss! Lame!" );
									}
								}
								//potion
								if (a[22] == 5) {
									if (a[16] > 0) {
										System.out.println ( "That Sauce is Awesome! +25HP" );
										a[16] --;
										a[21] -= 25;
										a[1] += 25;
										if (a[1] > a[2]) {
											a[1] = a[2];
										}
									}
									else {
										System.out.println ( "Fool! You have no Sauce in supply!" );
									}
								}
							}
							if (cultistHP <= 0) {
								if (a[1] > 0) {
									System.out.println ( "You decapitate the Cultist of Chaos... thier purse holds 12 gold" );
									a[0] += 12;
									a[21] += 110;
								}
							}
							if (a[1] < 1) {
								break;
							}
						}
						if (a[1] < 1) {
							break;
						}	
					}
					if (a[1] < 1) {
						break;
					}
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
			
					break; // End CitySearch
					
				case 6:
					
					int carriage = 10;
					System.out.println ( "Are you sure you  want to leave the City?" );
					System.out.println ( "Enter 6 to confirm. Enter 0 to return to Common Board" );
					a[23] = input.nextInt();
					if (a[23] == 6)
					{
						System.out.println ( "Where to?" );
						System.out.println ( "N - Take Carriage back to the Merchant Camp fork. (10 gold)");
						System.out.println ( "W - Walk back to Merchant Camp fork" );
						if (a[24] == 0) {
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
							System.out.println ( "(this option will end this chapter of the game\nand you may not be able to return)\ncontinue? y/n" );
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
	public static int[] mountainRoad1(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "Its a Hard road to the mountain, but there's no turning back now..." );
		System.out.println ( "Press Enter to start your climb" );
		KeyIn.nextLine();
		int mtnRoadCount = 0;
		while (mtnRoadCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
					int fireSpriteHP = 30;
					while (fireSpriteHP > 0)  //fight sequence
					{	
						int fireSprite = (int) ( Math.random ( ) * 9 + 5 );
						System.out.println ( "Fire Sprite throws fireball for " + fireSprite + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= fireSprite;
							System.out.println ( "-" + fireSprite + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								mtnRoadCount = 9;
								a[23] = 6;
								fireSpriteHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								fireSpriteHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (fireSpriteHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You Extinguish the Fire Sprite and a find a hot Ruby melting the surrounding snow. + 15 gold" );
							a[0] += 15;
							a[21] += 125;
						}
					}
					break;
					
					case 2: System.out.println ("Tucked back in a dark alcove you can see the dull outline of a chest"  ); // jewel/ mimic
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
							int mimicHP = 35;
							while (mimicHP > 0)  //fight sequence
							{	
								int mimic = (int) ( Math.random ( ) * 8 + 7 );
								System.out.println ( "Mimic attacks for " + mimic + " damage.");
								hitChance = (int) ( Math.random ( ) * 12 + 6);  //chance to a[6]
								if (a[6] > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									a[1] -= mimic;
									System.out.println ( "-" + mimic + " HP. " + "HP is " + a[1]);
									if (a[1] < 1)
									{
										a[7] = 0;
										a[25] = 'A';
										merch = 0;
										mtnRoadCount = 9;
										a[23] = 6;
										mimicHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
								a[22] = input.nextInt();
								if (a[22] == 0) {
									hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
									if (a[6] > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
							
								//attack
								if (a[22] == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + a[3]);
									hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
									if (a[5] >= hitChance)
									{
										System.out.println ( "You hit for " + hitDMG + " DMG" );
										mimicHP -= hitDMG;
									}
									else
									{
										System.out.println ( "You miss! Lame!" );
									}
								}
								//potion
								if (a[22] == 5) {
									if (a[16] > 0) {
										System.out.println ( "That Sauce is Awesome! +25HP" );
										a[16] --;
										a[21] -= 25;
										a[1] += 25;
										if (a[1] > a[2]) {
											a[1] = a[2];
										}
									}
									else {
										System.out.println ( "Fool! You have no Sauce in supply!" );
									}
								}
							}
							if (mimicHP <= 0) {
								if (a[1] > 0) {
									System.out.println ( "You killed a Mimic! You open its skull, which resembles a chest, and find a Diamond! + 20 gold" );
									a[0] += 20;
									a[21] += 150;
								}
							}
						}
						else 
						{
							if (a[1] > 0) {
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								a[0] += 20;
							}
							
						}
					}
					break;
					
					case 3: System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //MudMan
					int mtnTrollHP = 50;
					while (mtnTrollHP > 0)  //fight sequence
					{	
						int mtnTroll = (int) ( Math.random ( ) * 8 + 8 );
						System.out.println ( "Mountain Troll clubs you for " + mtnTroll + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= mtnTroll;
							System.out.println ( "-" + mtnTroll + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								mtnRoadCount = 9;
								a[23] = 6;
								mtnTrollHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 6 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								mtnTrollHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (mtnTrollHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed a Mountain Troll! Wow! Its pouch holds 20 gold" );
							a[0] += 20;
							a[21] += 140;
						}
					}
					break;
					
					case 4: System.out.println ("The sky darkens. You look above to see a colony of thirsty Vampire Bats" ); //bat 
					int batHP = 30;
					while (batHP > 0)  //fight sequence
					{	
						int bat = (int) ( Math.random ( ) * 5 + 7 );
						System.out.println ( "Vampire Bat swoops for " + bat + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= bat;
							System.out.println ( "-" + bat + " HP. " + "HP is " + a[1]);
							double vamp = bat * 0.25;  //bat heals 25% damage given
							int iVamp = (int) vamp;
							if (iVamp > 0) {   // output if necessary
								System.out.println ( "Bat Colony heals " + iVamp + " HP" );
								batHP += iVamp;
							}
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								mtnRoadCount = 9;
								a[23] = 6;
								batHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								batHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (batHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You slaughter the colony of annoying sky rats.\nYou find 13 gold on a nearby corpse" );
							a[0] += 13;
							a[21] += 120;
						}
					}
					if (a[1] < 1) {
						break;
					}
				}
				if (a[1] < 1) {
					break;
				}
			} 
			if (a[1] < 1) {
				break;
			}
			mtnRoadCount++;
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			System.out.println ( "Camp " + mtnRoadCount + ". Press Enter to continue Upward" );
			KeyIn.nextLine ( );
		}// end mountain road
		
		
		return a;												
	}
	public static int[] mountainTop(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch, String player) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		if (a[1] > 0) {
			System.out.println ( "The top of the mountain is a meandering trenchwork of jagged rock and snow covered boulders." );
			System.out.println ( "You will need to find another way down..." );
			System.out.println ( "Would you like to look around first? y/n" );
		}
		char mountain = 'a';
		do  //check character input
		{
			if (a[1] < 1) {
				break;
			}
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
					case 1: System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
					int fireSpriteHP = 30;
					while (fireSpriteHP > 0)  //fight sequence
					{	
						int fireSprite = (int) ( Math.random ( ) * 9 + 5 );
						System.out.println ( "Fire Sprite throws fireball for " + fireSprite + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= fireSprite;
							System.out.println ( "-" + fireSprite + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								a[23] = 6;
								mountain = 'n';
								fireSpriteHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								fireSpriteHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (fireSpriteHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You Extinguish the Fire Sprite and a find a hot Ruby melting the surrounding snow. + 15 gold" );
							a[0] += 15;
							a[21] += 125;
						}
					}
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
								System.out.println ( "That's way too Creepy. You shut the voice out of your mind" );
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
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
								System.out.println ( "Press Enter" );
								KeyIn.nextLine ( );
								int chaosDemonHP = 90;
								while (chaosDemonHP > 0)  //fight sequence
								{	
									int chaosDemon = (int) ( Math.random ( ) * 12 + 6 );
									System.out.println ( "Chaos Demon attacks for " + chaosDemon + " damage.");
									hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
									if (a[6] > hitChance) 
									{
										System.out.println ( "But Misses!" );
									}
									else
									{
										a[1] -= chaosDemon;
										System.out.println ( "-" + chaosDemon + " HP. " + "HP is " + a[1]);
										if (a[1] < 1)
										{
											a[7] = 0;
											a[25] = 'A';
											merch = 0;
											a[23] = 6;
											mountain = 'n';
											chaosDemonHP = 0;
											break;
										}
									}
									 //battle decision
									System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
									a[22] = input.nextInt();
									if (a[22] == 0) {
										hitChance = (int) ( Math.random ( ) * 8 + 5);  //chance to flee
										if (a[6] > hitChance) {
											System.out.println ( "You run away! Coward!" );
											break;
										}
										else {
											System.out.println ( "You try to run, but you trip and fall on your face." );
										}
									}
									//attack
									if (a[22] == 1) {
										hitDMG = (int) ( Math.random ( ) * attack + a[3]);
										hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
										if (a[5] >= hitChance)
										{
											System.out.println ( "You hit for " + hitDMG + " DMG" );
											chaosDemonHP -= hitDMG;
										}
										else
										{
											System.out.println ( "You miss! Lame!" );
										}
									}
									//potion
									if (a[22] == 5) {
										if (a[16] > 0) {
											System.out.println ( "That Sauce is Awesome! +25HP" );
											a[16] --;
											a[21] -= 25;
											a[1] += 25;
											if (a[1] > a[2]) {
												a[1] = a[2];
											}
										}
										else {
											System.out.println ( "Fool! You have no Sauce in supply!" );
										}
									}
								}
								if (chaosDemonHP <= 0) {
									if (a[1] > 0) {
										System.out.println ( "You swing!... your blade cuts through empty air, at the same time\nan intense gust of wind throws you forward violently..." );
										System.out.println ( "The Chaos Demon imploded! Only a hot lump of glowing ore remains." );
										System.out.println ( "A small piece of glowing ore has broken apart from the rest and you pick it up" );
										System.out.println ( "It is extremely heavy for its size and you feel a part of yourself being tied to this small gem" );
										System.out.println ( "+25 Max HP. HP fully restored! + 50 gold" );
										a[2] += 25;
										a[1] = a[2];
										a[0] += 50;
										a[24] --;
										a[21] += 500;
									}
								}
							}
						}
						else
						{
							if (a[1] > 0) {
								System.out.println ( "You wander back to the spot where you fought the Chaos Demon" );
								System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
								a[0] += 1;
							}
						}
						break;
					
					case 3: System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //MudMan
					int mtnTrollHP = 50;
					while (mtnTrollHP > 0)  //fight sequence
					{	
						int mtnTroll = (int) ( Math.random ( ) * 8 + 8 );
						System.out.println ( "Mountain Troll clubs you for " + mtnTroll + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= mtnTroll;
							System.out.println ( "-" + mtnTroll + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								a[23] = 6;
								mountain = 'n';
								mtnTrollHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 6 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								mtnTrollHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (mtnTrollHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed a Mountain Troll! Wow! Its pouch holds 20 gold" );
							a[0] += 20;
							a[21] += 135;
						}
					}
					break;
					
					case 4: System.out.println ("The sky darkens. You look above to see an enormous colony of thirsty Vampire Bats" ); //bat 
					int batHP = 40;
					while (batHP > 0)  //fight sequence
					{	
						int bat = (int) ( Math.random ( ) * 5 + 7 );
						System.out.println ( "Vampire Bat swoops for " + bat + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= bat;
							System.out.println ( "-" + bat + " HP. " + "HP is " + a[1]);
							double vamp = bat * 0.25;  //bat heals 25% damage given
							int iVamp = (int) vamp;
							if (iVamp > 0) {   // output if necessary
								System.out.println ( "Bat Colony heals " + iVamp + " HP" );
								batHP += iVamp;
							}
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								a[23] = 6;
								mountain = 'n';
								batHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								batHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (batHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You slaughter the colony of annoying sky rats.\nYou find 20 gold on a nearby corpse" );
							a[0] += 20;
							a[21] += 120;
						}
					}
					if (a[1] < 1) {
						break;
					}
				}
				if (a[1] < 1) {
					break;
				}
			
			}
			if (a[1] < 1) {
				break;
			}
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
		System.out.println ( "You find an old merchant trail marker and head Down the Mountain" );         //other side of mountain
		System.out.println ( "Enter to continue" );
		KeyIn.nextLine();
		
		
		return a;
	}
	public static int[] mountainRoad2(int[] a, int rand, int range, int minEnc, int encNumber, int hitChance, int hitDMG, int attack, int merch) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		int mtnRoadCount = 0;
		while (mtnRoadCount < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
					int fireSpriteHP = 30;
					while (fireSpriteHP > 0)  //fight sequence
					{	
						int fireSprite = (int) ( Math.random ( ) * 9 + 5 );
						System.out.println ( "Fire Sprite throws fireball for " + fireSprite + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= fireSprite;
							System.out.println ( "-" + fireSprite + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								mtnRoadCount = 9;
								a[23] = 6;
								fireSpriteHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								fireSpriteHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (fireSpriteHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You Extinguish the Fire Sprite and a find a hot Ruby melting the surrounding snow. + 15 gold" );
							a[0] += 15;
							a[21] += 125;
						}
					}
					break;
				
					case 2: System.out.println ("Tucked back in a dark alcove you can see the dull outline of a chest"  ); // jewel/ mimic
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
							int mimicHP = 35;
							while (mimicHP > 0)  //fight sequence
							{	
								int mimic = (int) ( Math.random ( ) * 8 + 7 );
								System.out.println ( "Mimic attacks for " + mimic + " damage.");
								hitChance = (int) ( Math.random ( ) * 12 + 6);  //chance to a[6]
								if (a[6] > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									a[1] -= mimic;
									System.out.println ( "-" + mimic + " HP. " + "HP is " + a[1]);
									if (a[1] < 1)
									{
										a[7] = 0;
										a[25] = 'A';
										merch = 0;
										mtnRoadCount = 9;
										a[23] = 6;
										mimicHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
								a[22] = input.nextInt();
								if (a[22] == 0) {
									hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
									if (a[6] > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
							
								//attack
								if (a[22] == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + a[3]);
									hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
									if (a[5] >= hitChance)
									{
										System.out.println ( "You hit for " + hitDMG + " DMG" );
										mimicHP -= hitDMG;
									}
									else
									{
										System.out.println ( "You miss! Lame!" );
									}
								}
								//potion
								if (a[22] == 5) {
									if (a[16] > 0) {
										System.out.println ( "That Sauce is Awesome! +25HP" );
										a[16] --;
										a[21] -= 25;
										a[1] += 25;
										if (a[1] > a[2]) {
											a[1] = a[2];
										}
									}
									else {
										System.out.println ( "Fool! You have no Sauce in supply!" );
									}
								}
							}
							if (mimicHP <= 0) {
								if (a[1] > 0) {
									System.out.println ( "You killed a Mimic! You open its skull, which resembles a chest, and find a Diamond! + 20 gold" );
									a[0] += 20;
									a[21] += 150;
								}
							}
						}
						else 
						{
							if (a[1] > 0) {
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								a[0] += 20;
							}
							
						}
					}
					break;
				
					case 3: System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //MudMan
					int mtnTrollHP = 50;
					while (mtnTrollHP > 0)  //fight sequence
					{	
						int mtnTroll = (int) ( Math.random ( ) * 8 + 8 );
						System.out.println ( "Mountain Troll clubs you for " + mtnTroll + " damage.");
						hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= mtnTroll;
							System.out.println ( "-" + mtnTroll + " HP. " + "HP is " + a[1]);
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								mtnRoadCount = 9;
								a[23] = 6;
								mtnTrollHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 6 + 4);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 8 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								mtnTrollHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (mtnTrollHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You killed a Mountain Troll! Wow! Its pouch holds 20 gold" );
							a[0] += 20;
							a[21] += 135;
						}
					}
					break;
					
					case 4: System.out.println ("The sky darkens. You look above to see a colony of thirsty Vampire Bats" ); //bat 
					int batHP = 30;
					while (batHP > 0)  //fight sequence
					{	
						int bat = (int) ( Math.random ( ) * 5 + 7 );
						System.out.println ( "Vampire Bat swoops for " + bat + " damage.");
						hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to a[6]
						if (a[6] > hitChance) 
						{
							System.out.println ( "But Misses!" );
						}
						else
						{
							a[1] -= bat;
							System.out.println ( "-" + bat + " HP. " + "HP is " + a[1]);
							double vamp = bat * 0.25;  //bat heals 25% damage given
							int iVamp = (int) vamp;
							if (iVamp > 0) {   // output if necessary
								System.out.println ( "Bat Colony heals " + iVamp + " HP" );
								batHP += iVamp;
							}
							if (a[1] < 1)
							{
								a[7] = 0;
								a[25] = 'A';
								merch = 0;
								mtnRoadCount = 9;
								a[23] = 6;
								batHP = 0;
								break;
							}
						}
						 //battle decision
						System.out.println ( "1-Attack, 5-EEL Sauce (" + a[16] + "), 0-Flee" );
						a[22] = input.nextInt();
						if (a[22] == 0) {
							hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
							if (a[6] > hitChance) {
								System.out.println ( "You run away! Coward!" );
								break;
							}
							else {
								System.out.println ( "You try to run, but you trip and fall on your face." );
							}
						}
						
						//attack
						if (a[22] == 1) {
							hitDMG = (int) ( Math.random ( ) * attack + a[3]);
							hitChance = (int) ( Math.random ( ) * 9 + 1);  //chance to hit
							if (a[5] >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								batHP -= hitDMG;
							}
							else
							{
								System.out.println ( "You miss! Lame!" );
							}
						}
						//potion
						if (a[22] == 5) {
							if (a[16] > 0) {
								System.out.println ( "That Sauce is Awesome! +25HP" );
								a[16] --;
								a[21] -= 25;
								a[1] += 25;
								if (a[1] > a[2]) {
									a[1] = a[2];
								}
							}
							else {
								System.out.println ( "Fool! You have no Sauce in supply!" );
							}
						}
					}
					if (batHP <= 0) {
						if (a[1] > 0) {
							System.out.println ( "You slaughter the colony of annoying sky rats.\nYou find 13 gold on a nearby corpse" );
							a[0] += 13;
							a[21] += 120;
						}
					}
					if (a[1] < 1) {
						break;
					}
				}
				if (a[1] < 1) {
					break;
				}
			
			}
			if (a[1] < 1) {
				break;
			}
			mtnRoadCount++;
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			System.out.println ( "Camp " + mtnRoadCount + ". Press Enter to continue Downward" );
			KeyIn.nextLine ( );
			a[25] = 'N';
			a[17] = 0;
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
			int minEnc = 1, maxEnc = 3, encNumber = 1, range = maxEnc - minEnc + 1, rand = 0, hitDMG = 0, hitChance = 0;
			//misc
			int hpPotCost = 5, merch = 0;
			final int INNCOST = 20;
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
				while (a[7] == 2)
				{
					if (a[1] > 0) {
						System.out.println ( "You've reached the merchant camp and completed Chapter 1 of your journey." );
						System.out.println ( "HP: " + a[1]);
						System.out.println ( "Gold: " + a[0] );
						System.out.println ( "Press Enter to Continue" );
						KeyIn.nextLine();
					}
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
								System.out.println ( "But, The road is flat and lined by trees that are filled with birds singing their songs" );
								System.out.println ( "You pick up your pace...\n" );
								a = cityRoad(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch);
								if (a[1] > 0) {
									a= theCity(a, rand, range, minEnc, encNumber, hitChance, hitDMG, attack, merch, INNCOST);/////the city/////
								}
								if (a[25] != 'N') {
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
					System.out.println ( "Before you can say anything he disappears, and a familiar memory wells up in your mind" );
					System.out.println ( "Where \"he\" stood now lays the very same equipment you had 8 years ago..." );
					System.out.println ( "After donning your armor and sheathing your weapons\nyou step out into the world willingly\nPress Enter" );
					KeyIn.nextLine ( );
					a[7] = 0;
					a[1] = 0;
					break;
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
				System.out.println ( "Time Penalty -" + penalty + " a[21]" );
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



