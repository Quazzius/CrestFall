import java.util.Scanner;

public class CrestFallGame
{

	public static void main( String[ ] args )
	{
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char playGame = 'y';
		//user enter name
		System.out.println ( "Enter your name" );
		String player = input.nextLine( );
		while (playGame == 'y')
		{
			//stats and items
			int gold = 0;
			int hp = 100;
			int hpMax = 100;
			int minDMG = 2;
			int maxDMG = 5;
			char forest = 'y';
			int minEnc = 1;
			int maxEnc = 3;
			int encNumber = 1;  //your number for encounter =
			int range = maxEnc - minEnc;
			int dex = 7;   // chance to hit
			int evade = 7; //chance to evade
			int rand;      //random number from encounter range
			int hitDMG;
			int hitChance;
			int chapter = 1;  //chapter of game
			int swampRoadCount;
			int cityRoadCount;
			int mtnRoadCount;
			int ladyOfLake = 1;
			int sSword = 1;  //merchant items
			int lSword = 1;
			int lArmor = 1;
			int mBoots = 1;
			int mDagger = 1;
			int mShield = 1;
			int bSword = 1;
			int hpPot = 0;
			int hpPotCost;
			final int INNCOST = 20;
			int merchCount = 0;
			char direction = 'N';
			int loser = 0;
			int fighter = 0;
			int victim = 1;
			int points =  0;
			int battleDec = 0;
			int city = 9;
			int chaosDemonLife = 1;
			
			
			//character class
			System.out.println ( "Pick your class type" );
			System.out.println ( "1. Hunter (Normal Game)\n2. Fighter (easier mode?) -1 dex, +2 Max DMG\n3. Loser (Harder Mode) -1 dex, -1 evade, -1 Max DMG, +10 Max HP" );
			int playerType = input.nextInt ( );
			if (playerType == 2) {
				fighter = 1;
				dex--;
				maxDMG += 2;
			}
			if (playerType == 3) {
				loser = 1;
				dex--;
				evade--;
				maxDMG--;
				hpMax += 10;
			}
			//warp
			if (player.equals ( "ch2" )) {
				chapter = 2;
				gold = 20;
			}
			if (player.equals ( "ch3" )) {
				chapter = 3;
				minDMG = 7;
				maxDMG = 12;
				dex = 8;
				evade = 8;
				hpMax = 150;
				hp = hpMax;
				gold = 75;
			}
			//begin game
			System.out.println ( "Your home, the village of Sardina, was just burned to the ground by a forest fire." );
			System.out.println ( "Living in the middle of the forest has its advantages though the closest town is 10 days away on foot." );
			System.out.println ( "You know of a merchant to the SouthWest, but first you mush make your way through the forest to find the road." );
			System.out.println ( "Your only posessions are the clothes on your back and your Splitting Axe (2-5 DMG)." );
			if(fighter == 1) {
				System.out.println ( "You have a lifetime of fighting experince + 2 Max DMG\n But your large stature leaves you less nimble -1 dex" );
			}
			if (loser == 1) {
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
				hp = 0;
			}
			
			//is alive
			while (hp > 0)
			{
				int attack = maxDMG - minDMG + 1;  //dmg range
				while (chapter == 1)
				{
					//Journey through the forest
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
							int bearHP = 12;
							while (bearHP > 0)  //fight sequence
							{	
								int bear = (int) ( Math.random ( ) * 8 + 3 );
								System.out.println ( "Bear attacks for " + bear + " damage.");
								hitChance = (int) ( Math.random ( ) * 10 + 4);  //chance to evade
								if (evade > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									hp -= bear;
									System.out.println ( "-" + bear + " HP. " + "HP is " + hp);
									if (hp < 1)
									{
										chapter = 0;
										forestCount = 9;
										bearHP = 0;
										break;
									}
								}
								  //battle decision
								System.out.println ( "1-Attack, 0-Flee" );
								battleDec = input.nextInt();
								if (battleDec == 0) {
									hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
									if (evade > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
								
								//attack
								if (battleDec == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + minDMG);
									hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
									if (dex >= hitChance)
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
							if (bearHP <= 0) {
								if (hp > 0) {
									System.out.println ( "You killed a Bear! +5 gold for some reason" );
									gold += 5;
									points += 50;
								}
							}
							break;
							
							case 2: System.out.println ("You hear some little Goblins creeping around"  );
							int gobHP = 8;
							while (gobHP > 0)  //fight sequence
							{	
								int goblin = (int) ( Math.random ( ) * 5 + 1 );
								System.out.println ( "Goblin attacks for " + goblin + " damage.");
								hitChance = (int) ( Math.random ( ) * 10 + 5);  //chance to evade
								if (evade > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									hp -= goblin;
									System.out.println ( "-" + goblin + " HP. " + "HP is " + hp);
									if (hp < 1)
									{
										chapter = 0;
										forestCount = 9;
										gobHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 0-Flee" );
								battleDec = input.nextInt();
								if (battleDec == 0) {
									hitChance = (int) ( Math.random ( ) * 8 + 5);  //chance to flee
									if (evade > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
								
								//attack
								if (battleDec == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + minDMG);
									hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
									if (dex >= hitChance)
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
								if (hp > 0) {
									System.out.println ( "You killed some Goblins! and found 3 gold!" );
									gold += 3;
									points += 10;
								}
							}
							break;
							
							case 3: System.out.println ( "An Elf appears... to be very menacing!" );
							int elfHP = 8;
							while (elfHP > 0)  //fight sequence
							{	
								int elf = (int) ( Math.random ( ) * 5 + 3 );
								System.out.println ( "Crazy Elf attacks for " + elf + " damage.");
								hitChance = (int) ( Math.random ( ) * 10 + 6);  //chance to evade
								if (evade > hitChance) 
								{
									System.out.println ( "But Misses!" );
								}
								else
								{
									hp -= elf;
									System.out.println ( "-" + elf + " HP. " + "HP is " + hp);
									if (hp < 1)
									{
										chapter = 0;
										forestCount = 9;
										elfHP = 0;
										break;
									}
								}
								 //battle decision
								System.out.println ( "1-Attack, 0-Flee" );
								battleDec = input.nextInt();
								if (battleDec == 0) {
									hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
									if (evade > hitChance) {
										System.out.println ( "You run away! Coward!" );
										break;
									}
									else {
										System.out.println ( "You try to run, but you trip and fall on your face." );
									}
								}
								
								//attack
								if (battleDec == 1) {
									hitDMG = (int) ( Math.random ( ) * attack + minDMG);
									hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
									if (dex >= hitChance)
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
								if (hp > 0) {
								System.out.println ( "You killed a crazy theiving Elf, and robbed his corpse of 6 gold! Awesome!" );
								gold += 6;
								points += 30;
								}
							}
							}//end switch
						
						}
						if (hp < 1) {
							break;
						}
						forestCount++;
						rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
						System.out.println ( "Camp " + forestCount + ". Press Enter to continue South" );
						KeyIn.nextLine ( );
					}
					if (hp < 1) {
						break;
					}// End Forest
					System.out.println ( "You find the road after 3 days and shortly thereafter come to a Fork." );
					System.out.println ( "You're still alive with " + hp + " HP, and " + gold + " gold. Cool..." );
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
					
					//Merchant road
					if (roadFork == 'W')
					{
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
									hitChance = (int) ( Math.random ( ) * 10 + 4);  //chance to evade
									if (evade > hitChance) 
									{
										System.out.println ( "But Misses!" );
									}
									else
									{
										hp -= bums;
										System.out.println ( "-" + bums + " HP. " + "HP is " + hp);
										if (hp < 1)
										{
											chapter = 0;
											roadFork = 'N';
											MerchRoadCount = 9;
											bumHP = 0;
											break;
										}
									}
									 //battle decision
									System.out.println ( "1-Attack, 0-Flee" );
									battleDec = input.nextInt();
									if (battleDec == 0) {
										hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
										if (evade > hitChance) {
											System.out.println ( "You run away! Coward!" );
											break;
										}
										else {
											System.out.println ( "You try to run, but you trip and fall on your face." );
										}
									}
									
									//attack
									if (battleDec == 1) {
										hitDMG = (int) ( Math.random ( ) * attack + minDMG);
										hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
										if (dex >= hitChance)
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
									if (hp > 0) {
									System.out.println ( "You killed two Naked Bums! They each had 2 coins stached... somewhere. + 4 gold" );
									gold += 4;
									points += 25;
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
											hitChance = (int) ( Math.random ( ) * 10 + 4);  //chance to evade
											if (evade > hitChance) 
											{
												System.out.println ( "But Misses!" );
											}
											else
											{
												hp -= bandit;
												System.out.println ( "-" + bandit + " HP. " + "HP is " + hp);
												if (hp < 1)
												{
													chapter = 0;
													roadFork = 'N';
													MerchRoadCount = 9;
													banditHP = 0;
													break;
												}
											}
											 //battle decision
											System.out.println ( "1-Attack, 0-Flee" );
											battleDec = input.nextInt();
											if (battleDec == 0) {
												hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
												if (evade > hitChance) {
													System.out.println ( "You run away! Coward!" );
													break;
												}
												else {
													System.out.println ( "You try to run, but you trip and fall on your face." );
												}
											}
										
											//attack
											if (battleDec == 1) {
												hitDMG = (int) ( Math.random ( ) * attack + minDMG);
												hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
												if (dex >= hitChance)
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
											if (hp > 0) {
												System.out.println ( "You killed a Bandit, and robbed his corpse of 8 gold! Nice..." );
												gold += 8;
												points += 50;
											}
										}
									}
									else
									{
										if (hp > 0) {
											System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
											System.out.println ( "He gives you 10 gold for your services and company" );
											gold += 10;
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
									hitChance = (int) ( Math.random ( ) * 10 + 5);  //chance to evade
									if (evade > hitChance) 
									{
										System.out.println ( "But Misses!" );
									}
									else
									{
										hp -= marauder;
										System.out.println ( "-" + marauder + " HP. " + "HP is " + hp);
										if (hp < 1)
										{
											chapter = 0;
											roadFork = 'N';
											MerchRoadCount = 9;
											marauderHP = 0;
											break;
										}
									}
									 //battle decision
									System.out.println ( "1-Attack, 0-Flee" );
									battleDec = input.nextInt();
									if (battleDec == 0) {
										hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
										if (evade > hitChance) {
											System.out.println ( "You run away! Coward!" );
											break;
										}
										else {
											System.out.println ( "You try to run, but you trip and fall on your face." );
										}
									}
									
									//attack
									if (battleDec == 1) {
										hitDMG = (int) ( Math.random ( ) * attack + minDMG);
										hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
										if (dex >= hitChance)
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
									if (hp > 0) {
										System.out.println ( "You killed a Marauder and took his purse, but his horse ran away. + 7 gold" );
										gold += 7;
										points += 40;
									}
								}
								}
							
							}
							if (hp < 1) {
								break;
							}
							MerchRoadCount++;
							rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
							System.out.println ( "Camp " + MerchRoadCount + ". Press Enter to continue West" );
							KeyIn.nextLine ( );
						}
						if (hp < 1) {
							break;
						}
					chapter = 2;
					} //End Merchant Road
					
					else if (roadFork == 'E')																											// to the swamp
					{
						System.out.println ( "Lets take the muddy road then..." );
						System.out.println ( "press Enter to continue" );
						KeyIn.nextLine ( );
						System.out.println ( "The road meanders to the SouthEast and the air cathces a chill" );
						swampRoadCount = 0;
						while (swampRoadCount < 3)
						{
							rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
							if (encNumber == rand)
							{
								int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
								switch (enemy)
								{
								case 1: System.out.println ("A small pack of muddy wolves surround you!" ); //wolf pack
								int wolfHP = 15;
								while (wolfHP > 0)  //fight sequence
								{	
									int wolf = (int) ( Math.random ( ) * 7 + 2 );
									System.out.println ( "Wolf lunges for " + wolf + " damage.");
									hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
									if (evade > hitChance) 
									{
										System.out.println ( "But Misses!" );
									}
									else
									{
										hp -= wolf;
										System.out.println ( "-" + wolf + " HP. " + "HP is " + hp);
										if (hp < 1)
										{
											chapter = 0;
											roadFork = 'N';
											swampRoadCount = 9;
											wolfHP = 0;
											break;
										}
									}
									 //battle decision
									System.out.println ( "1-Attack, 0-Flee" );
									battleDec = input.nextInt();
									if (battleDec == 0) {
										hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
										if (evade > hitChance) {
											System.out.println ( "You run away! Coward!" );
											break;
										}
										else {
											System.out.println ( "You try to run, but you trip and fall on your face." );
										}
									}
									
									//attack
									if (battleDec == 1) {
										hitDMG = (int) ( Math.random ( ) * attack + minDMG);
										hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
										if (dex >= hitChance)
										{
											System.out.println ( "You hit for " + hitDMG + " DMG" );
											wolfHP -= hitDMG;
										}
										else
										{
											System.out.println ( "You miss! Lame!" );
										}
									}
								}
								if (wolfHP <= 0) {
									if (hp > 0) {
										System.out.println ( "You killed the wolves and find their previous victim's bones nearby. +8 gold" );
										gold += 8;
										points += 30;
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
									if (ruse >= 5)
									{
										System.out.println ( "It was a ruse!" );
										int wraithHP = 16;
										while (wraithHP > 0)  //fight sequence
										{	
											int wraith = (int) ( Math.random ( ) * 8 + 4 );
											System.out.println ( "wraith attacks for " + wraith + " damage.");
											hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
											if (evade > hitChance) 
											{
												System.out.println ( "But Misses!" );
											}
											else
											{
												hp -= wraith;
												System.out.println ( "-" + wraith + " HP. " + "HP is " + hp);
												if (hp < 1)
												{
													chapter = 0;
													roadFork = 'N';
													swampRoadCount = 9;
													wraithHP = 0;
													break;
												}
											}
											 //battle decision
											System.out.println ( "1-Attack, 0-Flee" );
											battleDec = input.nextInt();
											if (battleDec == 0) {
												hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
												if (evade > hitChance) {
													System.out.println ( "You run away! Coward!" );
													break;
												}
												else {
													System.out.println ( "You try to run, but you trip and fall on your face." );
												}
											}
										
											//attack
											if (battleDec == 1) {
												hitDMG = (int) ( Math.random ( ) * attack + minDMG);
												hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
												if (dex >= hitChance)
												{
													System.out.println ( "You hit for " + hitDMG + " DMG" );
													wraithHP -= hitDMG;
												}
												else
												{
													System.out.println ( "But you miss! Lame!" );
												}
											}
										}
										if (wraithHP <= 0) {
											if (hp > 0) {
												System.out.println ( "You killed a Wraith! And you find a garnet worth 8 gold! killer!" );
												gold += 8;
												points += 50;
											break;
											}
										}
									}
								else	{
									if (hp > 0) {
										System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
										gold += 8;
									}
								}
								}
								break;
								
								case 3: System.out.println ( "A Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
								int mudManHP = 14;
								while (mudManHP > 0)  //fight sequence
								{	
									int mudMan = (int) ( Math.random ( ) * 8 + 3 );
									System.out.println ( "mudMan attacks for " + mudMan + " damage.");
									hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
									if (evade > hitChance) 
									{
										System.out.println ( "But Misses!" );
									}
									else
									{
										hp -= mudMan;
										System.out.println ( "-" + mudMan + " HP. " + "HP is " + hp);
										if (hp < 1)
										{
											chapter = 0;
											roadFork = 'N';
											swampRoadCount = 9;
											mudManHP = 0;
											break;
										}
									}
									 //battle decision
									System.out.println ( "1-Attack, 0-Flee" );
									battleDec = input.nextInt();
									if (battleDec == 0) {
										hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
										if (evade > hitChance) {
											System.out.println ( "You run away! Coward!" );
											break;
										}
										else {
											System.out.println ( "You try to run, but you trip and fall on your face." );
										}
									}
									
									//attack
									if (battleDec == 1) {
										hitDMG = (int) ( Math.random ( ) * attack + minDMG);
										hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
										if (dex >= hitChance)
										{
											System.out.println ( "You hit for " + hitDMG + " DMG" );
											mudManHP -= hitDMG;
										}
										else
										{
											System.out.println ( "But you miss! Lame!" );
										}
									}
								}
								if (mudManHP <= 0) {
									if (hp > 0) {
										System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
										gold += 7;
										points += 40;
									}
								}
								}
							
							}
							if (hp < 1) {
								break;
							}
							swampRoadCount++;
							rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
							System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue East" );
							KeyIn.nextLine ( );
					}// end swamp road
				if (hp < 1)	{
					break;                                                                              //the lake
				}
				System.out.println ( "You find yourself standing at the edge of a large lake" );
				System.out.println ( "There is only one path leading out and it heads northWest" );
				System.out.println ( "Would you like to look around? y/n" );
				char lake;
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
						int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
						switch (enemy)
						{
						case 1: System.out.println ("A small pack of muddy wolves surround you!" ); //wolf pack
						int wolfHP = 15;
						while (wolfHP > 0)  //fight sequence
						{	
							int wolf = (int) ( Math.random ( ) * 7 + 2 );
							System.out.println ( "Wolf lunges for " + wolf + " damage.");
							hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
							if (evade > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								hp -= wolf;
								System.out.println ( "-" + wolf + " HP. " + "HP is " + hp);
								if (hp < 1)
								{
									chapter = 0;
									roadFork = 'N';
									wolfHP = 0;
									lake = 'n';
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 0-Flee" );
							battleDec = input.nextInt();
							if (battleDec == 0) {
								hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
								if (evade > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
							
							//attack
							if (battleDec == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + minDMG);
								hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
								if (dex >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									wolfHP -= hitDMG;
								}
								else
								{
									System.out.println ( "You miss! Lame!" );
								}
							}
						}
						if (wolfHP <= 0) {
							if (hp > 0) {
								System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
								gold += 8;
								points += 30;
							}
						}
						break;
						
						case 2: 
						if (ladyOfLake > 0)
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
								hp = hpMax;
								System.out.println ( "She hands you a short sword that glows faintly green. The lady disappears upon taking the sword");
								System.out.println ( "You've acquired PhantomBane! DMG 5-8" );
								minDMG = 5;
								maxDMG = 8;
								ladyOfLake--;
								if (fighter == 1) {
									maxDMG += 2;
								}
								if (loser == 1) {
									maxDMG--;
								}
							}
						}
						else
						{
							System.out.println ( "Here is where you met the lady of the lake" );
							System.out.println ( "You can feel her spirit well up inside of you. Full HP!" );
							hp = hpMax;
						}
						break;
						
						case 3: System.out.println ( "A Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
						int mudManHP = 14;
						while (mudManHP > 0)  //fight sequence
						{	
							int mudMan = (int) ( Math.random ( ) * 8 + 3 );
							System.out.println ( "mudMan attacks for " + mudMan + " damage.");
							hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
							if (evade > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								hp -= mudMan;
								System.out.println ( "-" + mudMan + " HP. " + "HP is " + hp);
								if (hp < 1)
								{
									chapter = 0;
									roadFork = 'N';
									mudManHP = 0;
									lake = 'n';
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 0-Flee" );
							battleDec = input.nextInt();
							if (battleDec == 0) {
								hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
								if (evade > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
							
							//attack
							if (battleDec == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + minDMG);
								hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
								if (dex >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									mudManHP -= hitDMG;
								}
								else
								{
									System.out.println ( "But you miss! Lame!" );
								}
							}
						}
						if (mudManHP <= 0) {
							if (hp > 0) {
								System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
								gold += 7;
								points += 40;
							}
						}
						if (hp < 1) {
							break;
						}
					}
					if (hp < 1) {
						break;
					}
					
				}
				if (hp < 1) {
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
				if (hp < 1) {
					break;
				}
				System.out.println ( "The only road out is northwest to the Merchant Camp" );               //other side of lake
				System.out.println ( "Enter to continue" );
				KeyIn.nextLine();
				System.out.println ( "You now head northWest along another muddy trail." );
				swampRoadCount = 0;
				while (swampRoadCount < 3)
				{
					rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
					if (encNumber == rand)
					{
						int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
						switch (enemy)
						{
						case 1: System.out.println ("A small pack of muddy wolves surround you!" ); //wolf pack
						int wolfHP = 15;
						while (wolfHP > 0)  //fight sequence
						{	
							int wolf = (int) ( Math.random ( ) * 7 + 2 );
							System.out.println ( "Wolf lunges for " + wolf + " damage.");
							hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
							if (evade > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								hp -= wolf;
								System.out.println ( "-" + wolf + " HP. " + "HP is " + hp);
								if (hp < 1)
								{
									chapter = 0;
									roadFork = 'N';
									swampRoadCount = 9;
									wolfHP = 0;
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 0-Flee" );
							battleDec = input.nextInt();
							if (battleDec == 0) {
								hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
								if (evade > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
							
							//attack
							if (battleDec == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + minDMG);
								hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
								if (dex >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									wolfHP -= hitDMG;
								}
								else
								{
									System.out.println ( "You miss! Lame!" );
								}
							}
						}
						if (wolfHP <= 0) {
							if (hp > 0) {
								System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
								gold += 8;
								points += 30;
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
								int wraithHP = 16;
								while (wraithHP > 0)  //fight sequence
								{	
									int wraith = (int) ( Math.random ( ) * 8 + 4 );
									System.out.println ( "wraith attacks for " + wraith + " damage.");
									hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
									if (evade > hitChance) 
									{
										System.out.println ( "But Misses!" );
									}
									else
									{
										hp -= wraith;
										System.out.println ( "-" + wraith + " HP. " + "HP is " + hp);
										if (hp < 1)
										{
											chapter = 0;
											roadFork = 'N';
											swampRoadCount = 9;
											wraithHP = 0;
											break;
										}
									}
									 //battle decision
									System.out.println ( "1-Attack, 0-Flee" );
									battleDec = input.nextInt();
									if (battleDec == 0) {
										hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
										if (evade > hitChance) {
											System.out.println ( "You run away! Coward!" );
											break;
										}
										else {
											System.out.println ( "You try to run, but you trip and fall on your face." );
										}
									}
								
									//attack
									if (battleDec == 1) {
										hitDMG = (int) ( Math.random ( ) * attack + minDMG);
										hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
										if (dex >= hitChance)
										{
											System.out.println ( "You hit for " + hitDMG + " DMG" );
											wraithHP -= hitDMG;
										}
										else
										{
											System.out.println ( "But you miss! Lame!" );
										}
									}
								}
								if (wraithHP <= 0) {
									if (hp > 0) {
										System.out.println ( "You killed a Wraith! It dropped a garnet worth 8 gold, Nice..." );
										gold += 8;
										points += 50;
									}
								}
							}
							else 
							{
								if (hp > 0) {
									System.out.println ( "You find a Garnet worth 12 gold! Killer!" );
									gold += 8;
								}
							}
						}
						break;
						
						case 3: System.out.println ( "A Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
						int mudManHP = 14;
						while (mudManHP > 0)  //fight sequence
						{	
							int mudMan = (int) ( Math.random ( ) * 8 + 3 );
							System.out.println ( "mudMan attacks for " + mudMan + " damage.");
							hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
							if (evade > hitChance) 
							{
								System.out.println ( "But Misses!" );
							}
							else
							{
								hp -= mudMan;
								System.out.println ( "-" + mudMan + " HP. " + "HP is " + hp);
								if (hp < 1)
								{
									chapter = 0;
									roadFork = 'N';
									swampRoadCount = 9;
									mudManHP = 0;
									break;
								}
							}
							 //battle decision
							System.out.println ( "1-Attack, 0-Flee" );
							battleDec = input.nextInt();
							if (battleDec == 0) {
								hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
								if (evade > hitChance) {
									System.out.println ( "You run away! Coward!" );
									break;
								}
								else {
									System.out.println ( "You try to run, but you trip and fall on your face." );
								}
							}
							
							//attack
							if (battleDec == 1) {
								hitDMG = (int) ( Math.random ( ) * attack + minDMG);
								hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
								if (dex >= hitChance)
								{
									System.out.println ( "You hit for " + hitDMG + " DMG" );
									mudManHP -= hitDMG;
								}
								else
								{
									System.out.println ( "But you miss! Lame!" );
								}
							}
						}
						if (mudManHP <= 0) {
							if (hp > 0) {
								System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
								gold += 7;
								points += 40;
							}
						}
						}
					
					}
					if (hp < 1) {
						break;
					}
					swampRoadCount++;
					rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
					System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue West" );
					KeyIn.nextLine ( );
				}
				if (hp < 1) {
					break;
				}
				}// end swamp road 2
				
				if (hp < 1) {
					break;
				}
				chapter = 2;
				}// end chapter 1
			
				//Merchant Camp hub
				while (chapter == 2)
				{
					if (hp > 0) {
						System.out.println ( "You've reached the merchant camp." );
						System.out.println ( "HP: " + hp);
						System.out.println ( "Gold: " + gold );
						System.out.println ( "Press Enter to Continue" );
						KeyIn.nextLine();
					}
					int merch = 0;  																															//Merchant
					while (direction == 'N')
					{
						if (merchCount == 0)
						{
							System.out.println ( "There are a couple of Vendors hanging about..." );
							System.out.println ( "One of them turns to you and asks \"Are you in need?\" " );
							System.out.println ( "He then unrolls his mat to show you his various wares" );
							System.out.println ( "You hear him whisper what sounds like \"its a secret to everyone\" ");
							merchCount++;
						}
							
						System.out.println ( "What would you like?" );
						int sSwordCost = 10;
						System.out.println ( "1 - A reliable steel Short Sword. DMG: 3-6. (10 gold). In Stock: " + sSword );
						int lSwordCost = 15;
						System.out.println ( "2 - A Heavy Iron Long Sword (-1 dex). DMG 4-9 (15 gold) In Stock: " + lSword );
						int lArmorCost = 15;
						System.out.println ( "3 - Leather Armour. + 1 evade. (15 gold). InStock: " + lArmor);
						int mBootsCost = 30;
						System.out.println ( "4 - Mercurial Dancing Boots. + 1 evade (30 gold). In Stock " + mBoots);
						int hPotionCost = 8;
						System.out.println ( "5 - Magic EEL Sauce. Heal 50 HP (8 gold)" );
						hpPotCost = 5;
						System.out.println ( "6 - Magic EEL Sauce to go. Heal 25 HP in battle (5 gold)" );
						System.out.println ( "7 - View Stats" );
						System.out.println ( "8 - Exit Merchant Camp" );
						System.out.println ( "You have " + gold + " gold");
						merch = input.nextInt();   //input decision
						switch (merch)
						{
							case 1:  //buy  short sword
								if (sSword > 0)
								{
									if (gold >= sSwordCost)
									{
										System.out.println ( "The Short Sword is now yours! DMG: 3-6" );
										minDMG = 3;
										maxDMG = 6;
										gold -= sSwordCost;
										sSword--;
										if (fighter == 1) {
											maxDMG += 2;
										}
										if (loser == 1) {
											maxDMG--;
										}
										if(mDagger == 0)
										{
											minDMG++;
										}
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + gold + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
								
							case 2:  //buy long sword
								if (lSword > 0)
								{
									if (gold >= lSwordCost)
									{
										System.out.println ( "The Long Sword is now yours! DMG: 4-9. -1 dex" );
										minDMG = 4;
										maxDMG = 9;
										dex--;
										gold -= lSwordCost;
										lSword--;
										if (fighter == 1) {
											maxDMG += 2;
										}
										if (loser == 1) {
											maxDMG--;
										}
										if(mDagger == 0)
										{
											minDMG++;
										}
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + gold + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
								
							case 3:  // buy leather armor
								if (lArmor > 0)
								{
									if (gold >= lArmorCost)
									{
										System.out.println ( "The Leather Armor fits! +1 Evade" );
										evade++;
										gold -= lArmorCost;
										lArmor--;
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + gold + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
								
							case 4:
								if (mBoots >= 0)
								{
									if (gold >= mBootsCost)
									{
										System.out.println ( "The strange looking boots fit! +1 Evade. You feel lighter" );
										evade++;
										gold -= mBootsCost;
										mBoots--;
									}
									else
									{
										System.out.println ( "You are too poor for this item. you have " + gold + " gold");
									}
								}
								else
								{
									System.out.println ( "Sorry, This item is out of stock." );
								}
								break;
								
							case 5:
								if (gold >= hPotionCost)
								{
									hp += 50;
									gold -= hPotionCost;
									points -= 50;
									if (hp > hpMax)
									{
										hp = hpMax;
									}
									System.out.println ( "That Sauce is Awesome! +50 HP. You have " + hp + " HP"  );
								}
								else
								{
									System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
									System.out.println ( "You have " + gold + " gold. Go find some more" );
								} 
								break;
								
							case 6:
								if (hpPot < 1) {
									if (gold >= hpPotCost) {
										System.out.println ( "You get a bottle of Magic EEl Sauce. Use it wisely" );
										gold -= hpPotCost;
										hpPot += 1;
									}
									else {
										System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
										System.out.println ( "You have " + gold + " gold. Go find some more" );
									}
								}
								else {
									System.out.println ( "You can only hold one bottle at a time." );
								}
								break;
								
							case 7: 
								System.out.println ( "HP: " + hp);
								System.out.println ( "DMG: " + minDMG + " - " + maxDMG);
								System.out.println ( "Dex: " + dex);
								System.out.println ( "Evade: " + evade );
								break;
							
							case 8:
							System.out.println ( "There is a road sign at the far end of camp; It reads:" );
							System.out.println ( "Humble Mountain - West, Road closed due to Extreme Terror" );
							System.out.println ( "City of CrestFall - South" );
							System.out.println ( "SmellyFart Swamp - southEast" );
							System.out.println ( "Which way? S to City, E to Swamp. N to stay at Camp" );
							direction = input.next ( ).toUpperCase ( ).charAt ( 0 );
							switch (direction)
							{
								case 'E':
									System.out.println ( "Lets take the muddy road then..." );
									System.out.println ( "press Enter to continue" );
									KeyIn.nextLine ( );
									System.out.println ( "The road meanders to the SouthEast and the air cathces a chill" );
									swampRoadCount = 0;
									while (swampRoadCount < 3)
									{
										rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
										if (encNumber == rand)
										{
											int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
											switch (enemy)
											{
												case 1: System.out.println ("A small pack of muddy wolves surround you!" ); //wolf pack
												int wolfHP = 15;
												while (wolfHP > 0)  //fight sequence
												{	
													int wolf = (int) ( Math.random ( ) * 7 + 2 );
													System.out.println ( "Wolf lunges for " + wolf + " damage.");
													hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
													if (evade > hitChance) 
													{
														System.out.println ( "But Misses!" );
													}
													else
													{
														hp -= wolf;
														System.out.println ( "-" + wolf + " HP. " + "HP is " + hp);
														if (hp < 1)
														{
															chapter = 0;
															direction = 'A';
															merch = 0;
															swampRoadCount = 9;
															wolfHP = 0;
															break;
														}
													}
													 //battle decision
													System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
													battleDec = input.nextInt();
													if (battleDec == 0) {
														hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
														if (evade > hitChance) {
															System.out.println ( "You run away! Coward!" );
															break;
														}
														else {
															System.out.println ( "You try to run, but you trip and fall on your face." );
														}
													}
													
													//attack
													if (battleDec == 1) {
														hitDMG = (int) ( Math.random ( ) * attack + minDMG);
														hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
														if (dex >= hitChance)
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
													if (battleDec == 5) {
														if (hpPot > 0) {
															System.out.println ( "That Sauce is Awesome! +25HP" );
															hpPot --;
															points -= 25;
															hp += 25;
															if (hp > hpMax) {
																hp = hpMax;
															}
														}
														else {
															System.out.println ( "Fool! You have no Sauce in supply!" );
														}
													}
												}
												if (wolfHP <= 0) {
													if (hp > 0) {
														System.out.println ( "You killed the wolves and find their previous victim's bones nearby. +8 gold" );
														gold += 8;
														points += 30;
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
														int wraithHP = 16;
														while (wraithHP > 0)  //fight sequence
														{	
															int wraith = (int) ( Math.random ( ) * 8 + 4 );
															System.out.println ( "wraith attacks for " + wraith + " damage.");
															hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
															if (evade > hitChance) 
															{
																System.out.println ( "But Misses!" );
															}
															else
															{
																hp -= wraith;
																System.out.println ( "-" + wraith + " HP. " + "HP is " + hp);
																if (hp < 1)
																{
																	chapter = 0;
																	direction = 'A';
																	merch = 0;
																	swampRoadCount = 9;
																	wraithHP = 0;
																	break;
																}
															}
															 //battle decision
															System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
															battleDec = input.nextInt();
															if (battleDec == 0) {
																hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
																if (evade > hitChance) {
																	System.out.println ( "You run away! Coward!" );
																	break;
																}
																else {
																	System.out.println ( "You try to run, but you trip and fall on your face." );
																}
															}
														
															//attack
															if (battleDec == 1) {
																hitDMG = (int) ( Math.random ( ) * attack + minDMG);
																hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
																if (dex >= hitChance)
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
															if (battleDec == 5) {
																if (hpPot > 0) {
																	System.out.println ( "That Sauce is Awesome! +25HP" );
																	hpPot --;
																	points -= 25;
																	hp += 25;
																	if (hp > hpMax) {
																		hp = hpMax;
																	}
																}
																else {
																	System.out.println ( "Fool! You have no Sauce in supply!" );
																}
															}
														}
														if (wraithHP <= 0) {
															if (hp > 0) {
																System.out.println ( "You killed a Wraith! It dropped a garnet worth 8 gold, Nice..." );
																gold += 8;
																points += 50;
															}
														}
													}
													else 
													{
														if (hp > 0) {
															System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
															gold += 8;
														}
														
													}
												}
												break;
												
												case 3: System.out.println ( "A Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
												int mudManHP = 14;
												while (mudManHP > 0)  //fight sequence
												{	
													int mudMan = (int) ( Math.random ( ) * 8 + 3 );
													System.out.println ( "mudMan attacks for " + mudMan + " damage.");
													hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
													if (evade > hitChance) 
													{
														System.out.println ( "But Misses!" );
													}
													else
													{
														hp -= mudMan;
														System.out.println ( "-" + mudMan + " HP. " + "HP is " + hp);
														if (hp < 1)
														{
															chapter = 0;
															direction = 'A';
															merch = 0;
															swampRoadCount = 9;
															mudManHP = 0;
															break;
														}
													}
													 //battle decision
													System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
													battleDec = input.nextInt();
													if (battleDec == 0) {
														hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
														if (evade > hitChance) {
															System.out.println ( "You run away! Coward!" );
															break;
														}
														else {
															System.out.println ( "You try to run, but you trip and fall on your face." );
														}
													}
													
													//attack
													if (battleDec == 1) {
														hitDMG = (int) ( Math.random ( ) * attack + minDMG);
														hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
														if (dex >= hitChance)
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
													if (battleDec == 5) {
														if (hpPot > 0) {
															System.out.println ( "That Sauce is Awesome! +25HP" );
															hpPot --;
															points -= 25;
															hp += 25;
															if (hp > hpMax) {
																hp = hpMax;
															}
														}
														else {
															System.out.println ( "Fool! You have no Sauce in supply!" );
														}
													}
												}
												if (mudManHP <= 0) {
													if (hp > 0) {
														System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
														gold += 7;
														points += 40;
													}
												}
												if (hp < 1) {
													break;
												}
											}
											if (hp < 1) {
												break;
											}
										} 
										if (hp < 1) {
											break;
										}
										swampRoadCount++;
										rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
										System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue East" );
										KeyIn.nextLine ( );
								}// end swamp road
									if (hp < 1) {
										break;
									}	
									
							char lake;                                                                              //the lake
							if (hp > 0) {
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
							if (hp < 1) {
								lake = 'n';
							}
							while (lake == 'y')
							{
								rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
								if (encNumber == rand)
								{
									int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
									switch (enemy)
									{
										case 1: System.out.println ("A viscious looking pack of wolves surround you!" ); //wolf pack
										int wolfHP = 20;
										while (wolfHP > 0)  //fight sequence
										{	
											int wolf = (int) ( Math.random ( ) * 8 + 3 );
											System.out.println ( "Wolf lunges for " + wolf + " damage.");
											hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
											if (evade > hitChance) 
											{
												System.out.println ( "But Misses!" );
											}
											else
											{
												hp -= wolf;
												System.out.println ( "-" + wolf + " HP. " + "HP is " + hp);
												if (hp < 1)
												{
													chapter = 0;
													direction = 'A';
													merch = 0;
													swampRoadCount = 9;
													wolfHP = 0;
													break;
												}
											}
											 //battle decision
											System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
											battleDec = input.nextInt();
											if (battleDec == 0) {
												hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
												if (evade > hitChance) {
													System.out.println ( "You run away! Coward!" );
													break;
												}
												else {
													System.out.println ( "You try to run, but you trip and fall on your face." );
												}
											}
											
											//attack
											if (battleDec == 1) {
												hitDMG = (int) ( Math.random ( ) * attack + minDMG);
												hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
												if (dex >= hitChance)
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
											if (battleDec == 5) {
												if (hpPot > 0) {
													System.out.println ( "That Sauce is Awesome! +25HP" );
													hpPot --;
													points -= 25;
													hp += 25;
													if (hp > hpMax) {
														hp = hpMax;
													}
												}
												else {
													System.out.println ( "Fool! You have no Sauce in supply!" );
												}
											}
										}
										if (wolfHP <= 0) {
											if (hp > 0) {
												System.out.println ( "You killed the wolves and find their previous victim's bones nearby. +10 gold" );
												gold += 10;
												points += 40;
											}
										}
										break;
										
										case 2: 
											if (ladyOfLake > 0)
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
													hp = hpMax;
													System.out.println ( "She hands you a short sword that glows faintly green. The lady disappears upon taking the sword");
													System.out.println ( "You've acquired PhantomBane! DMG 5-8" );
													minDMG = 5;
													maxDMG = 8;
													ladyOfLake--;
													if (fighter == 1) {
														maxDMG += 2;
													}
													if (loser == 1) {
														maxDMG--;
													}
													if (mDagger == 0)
													{
														minDMG++;
													}
												}
											}
											else
											{
												System.out.println ( "Here is where you met the lady of the lake" );
												System.out.println ( "You can feel her spirit well up inside of you. Regen 50% MaxHP!" );
												hp += hpMax / 2;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											break;
										
										case 3: System.out.println ( "A PooPoo Man plops in front of you from seemingly nowhere. " );   //MudMan
										int mudManHP = 16;
										while (mudManHP > 0)  //fight sequence
										{	
											int mudMan = (int) ( Math.random ( ) * 9 + 3 );
											System.out.println ( "PooPoo Man attacks for " + mudMan + " damage.");
											hitChance = (int) ( Math.random ( ) * 11 + 6);  //chance to evade
											if (evade > hitChance) 
											{
												System.out.println ( "But Misses!" );
											}
											else
											{
												hp -= mudMan;
												System.out.println ( "-" + mudMan + " HP. " + "HP is " + hp);
												if (hp < 1)
												{
													chapter = 0;
													direction = 'A';
													merch = 0;
													swampRoadCount = 9;
													mudManHP = 0;
													break;
												}
											}
											 //battle decision
											System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
											battleDec = input.nextInt();
											if (battleDec == 0) {
												hitChance = (int) ( Math.random ( ) * 6 + 6);  //chance to flee
												if (evade > hitChance) {
													System.out.println ( "You run away! Coward!" );
													break;
												}
												else {
													System.out.println ( "You try to run, but you slip on some shit and fall on your face." );
												}
											}
											
											//attack
											if (battleDec == 1) {
												hitDMG = (int) ( Math.random ( ) * attack + minDMG);
												hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
												if (dex >= hitChance)
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
											if (battleDec == 5) {
												if (hpPot > 0) {
													System.out.println ( "That Sauce is Awesome! +25HP" );
													hpPot --;
													points -= 25;
													hp += 25;
													if (hp > hpMax) {
														hp = hpMax;
													}
												}
												else {
													System.out.println ( "Fool! You have no Sauce in supply!" );
												}
											}
										}
										if (mudManHP <= 0) {
											if (hp > 0) {
												System.out.println ( "You killed that Piece of Shit! It has some coins stuck in it. + 8 gold" );
												gold += 8;
												points += 70;
											}
										}
										if (hp < 1) {
											break;
										}
									}
									if (hp < 1) {
										break;
									}
								}
								if (hp < 1) {
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
							if (hp < 1) {
								break;
							}
							System.out.println ( "The only road out is northwest to the Merchant Camp" );               //other side of lake
							System.out.println ( "Enter to continue" );
							KeyIn.nextLine();
							System.out.println ( "You now head northWest along another muddy trail." );
							swampRoadCount = 0;
							while (swampRoadCount < 3)
							{
								rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
								if (encNumber == rand)
								{
									int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
									switch (enemy)
									{
									case 1: System.out.println ("A small pack of muddy wolves surround you!" ); //wolf pack
									int wolfHP = 15;
									while (wolfHP > 0)  //fight sequence
									{	
										int wolf = (int) ( Math.random ( ) * 7 + 2 );
										System.out.println ( "Wolf lunges for " + wolf + " damage.");
										hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
										if (evade > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											hp -= wolf;
											System.out.println ( "-" + wolf + " HP. " + "HP is " + hp);
											if (hp < 1)
											{
												chapter = 0;
												direction = 'A';
												merch = 0;
												swampRoadCount = 9;
												wolfHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
										battleDec = input.nextInt();
										if (battleDec == 0) {
											hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
											if (evade > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										
										//attack
										if (battleDec == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
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
										if (battleDec == 5) {
											if (hpPot > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												hpPot --;
												points -= 25;
												hp += 25;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (wolfHP <= 0) {
										if (hp > 0) {
											System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
											gold += 8;
											points += 30;
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
												hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to evade
												if (evade > hitChance) 
												{
													System.out.println ( "But Misses!" );
												}
												else
												{
													hp -= wraith;
													System.out.println ( "-" + wraith + " HP. " + "HP is " + hp);
													if (hp < 1)
													{
														chapter = 0;
														direction = 'A';
														merch = 0;
														swampRoadCount = 9;
														wraithHP = 0;
														break;
													}
												}
												 //battle decision
												System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
												battleDec = input.nextInt();
												if (battleDec == 0) {
													hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
													if (evade > hitChance) {
														System.out.println ( "You run away! Coward!" );
														break;
													}
													else {
														System.out.println ( "You try to run, but you trip and fall on your face." );
													}
												}
											
												//attack
												if (battleDec == 1) {
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 10);  //chance to hit
													if (dex >= hitChance)
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
												if (battleDec == 5) {
													if (hpPot > 0) {
														System.out.println ( "That Sauce is Awesome! +25HP" );
														hpPot --;
														points -= 25;
														hp += 25;
														if (hp > hpMax) {
															hp = hpMax;
														}
													}
													else {
														System.out.println ( "Fool! You have no Sauce in supply!" );
													}
												}
											}
											if (wraithHP <= 0) {
												if (hp > 0) {
													System.out.println ( "You killed a Rotten Wraith! It dropped a garnet worth 8 gold, Nice..." );
													gold += 8;
													points += 80;
												}
											}
										}
										else 
										{
											if (hp > 0) {
												System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
												gold += 8;
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
										hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
										if (evade > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											hp -= mudMan;
											System.out.println ( "-" + mudMan + " HP. " + "HP is " + hp);
											if (hp < 1)
											{
												chapter = 0;
												direction = 'A';
												merch = 0;
												swampRoadCount = 9;
												mudManHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
										battleDec = input.nextInt();
										if (battleDec == 0) {
											hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
											if (evade > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										
										//attack
										if (battleDec == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
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
										if (battleDec == 5) {
											if (hpPot > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												hpPot --;
												points -= 25;
												hp += 25;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (mudManHP <= 0) {
										if (hp > 0) {
												System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
												gold += 7;
												points += 40;
										}
									}
									if (hp < 1) {
										break;
									}
									}
									if (hp < 1) {
										break;
									}
								}
								if (hp < 1) {
									break;
								}
								swampRoadCount++;
								rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
								System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue West" );
								KeyIn.nextLine ( );
								direction = 'N';
								merchCount = 0;
							}// end swamp road 2
							break;
								
								//South the the City
								case 'S':
									System.out.println ( "Going to a bustling city sure sounds better than all the savagery you've encountered thus far." );                ///////To the City!///////
									System.out.println ( "press Enter to continue" );         
									KeyIn.nextLine ( );
									System.out.println ( "As you set out, you have a strange feeling about this \"City\"." );
									System.out.println ( "But, The road is flat and lined by trees that are filled with birds, singing their songs" );
									System.out.println ( "You pick up your pace..." );
									cityRoadCount = 0;
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
												hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
												if (evade > hitChance) 
												{
													System.out.println ( "But Misses!" );
												}
												else
												{
													hp -= thief;
													System.out.println ( "-" + thief + " HP. " + "HP is " + hp);
													if (hp < 1)
													{
														chapter = 0;
														direction = 'A';
														merch = 0;
														cityRoadCount = 9;
														thiefHP = 0;
														break;
													}
												}
												 //battle decision
												System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
												battleDec = input.nextInt();
												if (battleDec == 0) {
													hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
													if (evade > hitChance) {
														System.out.println ( "You run away! Coward!" );
														break;
													}
													else {
														System.out.println ( "You try to run, but you trip and fall on your face." );
													}
												}
												
												//attack
												if (battleDec == 1) {
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
													if (dex >= hitChance)
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
												if (battleDec == 5) {
													if (hpPot > 0) {
														System.out.println ( "That Sauce is Awesome! +25HP" );
														hpPot --;
														points -= 25;
														hp += 25;
														if (hp > hpMax) {
															hp = hpMax;
														}
													}
													else {
														System.out.println ( "Fool! You have no Sauce in supply!" );
													}
												}
											}
											if (hp > 0) {
												System.out.println ( "You kill the thief. His purse was pretty light. + 5 gold" );
												gold += 5;
												points += 40;
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
														hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
														if (evade > hitChance) 
														{
															System.out.println ( "But Misses!" );
														}
														else
														{
															hp -= thrall;
															System.out.println ( "-" + thrall + " HP. " + "HP is " + hp);
															if (hp < 1)
															{
																chapter = 0;
																direction = 'A';
																merch = 0;
																cityRoadCount = 9;
																thrallHP = 0;
																break;
															}
														}
														 //battle decision
														System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
														battleDec = input.nextInt();
														if (battleDec == 0) {
															hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
															if (evade > hitChance) {
																System.out.println ( "You run away! Coward!" );
																break;
															}
															else {
																System.out.println ( "You try to run, but you trip and fall on your face." );
															}
														}
													
														//attack
														if (battleDec == 1) {
															hitDMG = (int) ( Math.random ( ) * attack + minDMG);
															hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
															if (dex >= hitChance)
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
														if (battleDec == 5) {
															if (hpPot > 0) {
																System.out.println ( "That Sauce is Awesome! +25HP" );
																hpPot --;
																points -= 25;
																hp += 25;
																if (hp > hpMax) {
																	hp = hpMax;
																}
															}
															else {
																System.out.println ( "Fool! You have no Sauce in supply!" );
															}
														}
													}
													if (thrallHP <= 0) {
														if (hp > 0) {
															System.out.println ( "You killed the necromancers Thralls! But the Necromancer disappeared..." );
															System.out.println ( "Looking through his useless cart you find 12 gold! Nice!" );
															gold += 12;
															points += 60;
														}
													}
												}
												else
												{
													if (hp > 0) {
														System.out.println ( "You help the man gather what he needs and he is grateful for your help." );
														System.out.println ( "He hands you 10 gold with thanks. +10 gold!" );
														gold += 10;
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
												hitChance = (int) ( Math.random ( ) * 11 + 5);  //chance to evade
												if (evade > hitChance) 
												{
													System.out.println ( "But Misses!" );
												}
												else
												{
													hp -= wyvren;
													System.out.println ( "-" + wyvren + " HP. " + "HP is " + hp);
													if (hp < 1)
													{
														chapter = 0;
														direction = 'A';
														merch = 0;
														cityRoadCount = 9;
														wyvrenHP = 0;
														break;
													}
												}
												 //battle decision
												System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
												battleDec = input.nextInt();
												if (battleDec == 0) {
													hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
													if (evade > hitChance) {
														System.out.println ( "You run away! Coward!" );
														break;
													}
													else {
														System.out.println ( "You try to run, but you trip and fall on your face." );
													}
												}
												
												//attack
												if (battleDec == 1) {
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
													if (dex >= hitChance)
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
												if (battleDec == 5) {
													if (hpPot > 0) {
														System.out.println ( "That Sauce is Awesome! +25HP" );
														hpPot --;
														points -= 25;
														hp += 25;
														if (hp > hpMax) {
															hp = hpMax;
														}
													}
													else {
														System.out.println ( "Fool! You have no Sauce in supply!" );
													}
												}
											}
											if (wyvrenHP <= 0) {
												if (hp > 0) {
													System.out.println ( "You killed a Wyvren! WOW! you cut open its belly and find 11 gold!" );
													gold += 11;
													points += 100;
												}
											}
											if (hp < 1) {
												break;
											}
											}
											if (hp < 1) {
												break;
											}
										} 
										if (hp < 1) {
											break;
										}
										cityRoadCount++;
										rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
										System.out.println ( "Camp " + cityRoadCount + ". Press Enter to continue South" );
										KeyIn.nextLine ( );
								}// end city road
								if (hp < 1) {
									break;
								}																																	/////the city/////
								System.out.println ( "You find yourself standing at the Gates to the City" );
								System.out.println ( "HP = " + hp + " gold = " + gold);
								System.out.println ( "Press Enter to... Enter" );
								KeyIn.nextLine ( );
							
								int commonBoard;
								int armorerItems;
								char armorer;
								city = 9;
								System.out.println ( "The city looks like it has seen better days..." );
								System.out.println ( "There are only a handful of people walking about and there is rising smoke from multiple dwellings." );
								System.out.println ( "There is a large map of the city with a message board, that could be helpful." );
								System.out.println ( "Press Enter" );
								KeyIn.nextLine();
								
								while (city != 6)
								{
									System.out.println ( "City Common Board" );
									System.out.println ( "0 - EEL Sauce Vendor. 1 Bottle (8 gold)" );
									System.out.println ( "1 - Read Messages" );
									System.out.println ( "2 - View Stats");
									System.out.println ( "3 - Visit the Armorer");
									System.out.println ( "4 - Get a room at the Inn. (20 gold)");
									System.out.println ( "5 - Wander aimlessly about town" );
									System.out.println ( "6 - Leave the city" );
									System.out.println ( "You have " + gold + " gold");
								
									commonBoard = input.nextInt();   //input decision
									switch (commonBoard)
									{
										case 0:
											hpPotCost = 8;
											if (hpPot < 1) {
												if (gold >= hpPotCost) {
													System.out.println ( "You get a bottle of Magic EEl Sauce. Use it wisely" );
													gold -= hpPotCost;
													hpPot += 1;
												}
												else {
													System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
													System.out.println ( "You have " + gold + " gold. Go find some more" );
												}
											}
											else {
												System.out.println ( "You can only hold one bottle at a time." );
											}
											break;
											
										case 1:  //Read Messages
											System.out.println ( "1.) Have you purchased your flame retardant wall dividers yet?" );
											System.out.println ( "2.) An increase in fire raining from the sky has prompted the city treasurer" );
											System.out.println ( "\t \t to offer a reward of 50 gold to whomever can put an end to it." );
											System.out.println ( "3.) Please attend tomorrows memorial service for the Brave Soldiers" );
											System.out.println ( "\t \t who went to the mountain and gave their lives to help our fair City " );
											System.out.println ( "Press Enter to  Return to Common Board" );
											KeyIn.nextLine();
											break;
											
										case 2:  //View stats
											System.out.println ( "HP: " + hp);
											System.out.println ( "DMG: " + minDMG + " - " + maxDMG);
											System.out.println ( "Dex: " + dex);
											System.out.println ( "Evade: " + evade );
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
												System.out.println ( "1 - Jeweled Dagger. Off-hand, +1 Min DMG, + 1 Dex. (30 gold) In stock: " + mDagger );
												int mShieldCost = 30;
												System.out.println ( "2 - Crested Shield. Off-hand, +1 Resistance. (30 gold) In stock: " + mShield );
												int bSwordCost = 50;
												System.out.println ( "3 - Snowy Bastard Sword. 6 - 12 DMG. (50 gold) In stock: " + bSword );
												System.out.println ( "4 - Return to Armorer Entrance" );
												System.out.println ( "(You may only hold one Off-hand item, unless you grow and extra hand...)" );
												armorerItems = input.nextInt();
												switch (armorerItems)
												{
													case 1:
														if (mDagger > 0)
														{
															if (gold >= mDaggerCost)
															{
																if (mShield == 0)
																{
																	System.out.println ( "You ditch your shield and it vanishes! -1 Resistance" );
																	System.out.println ( "Where you left it now lies a few gold coins... + 10 gold" );
																	hpMax -= 25;
																	mShield++;
																	gold += 10;
																}
																System.out.println ( "The Dagger's hilt feels like it was made for your hand" );
																System.out.println ( "+1 Min DMG, +1 Dex" );
																minDMG++;
																dex++;
																gold -= mDaggerCost;
																mDagger--;
																
															}
															else
															{
																System.out.println ( "You are too poor for this item. you have " + gold + " gold");
															}
														}
														else
														{
															System.out.println ( "Sorry, This item is out of stock." );
														}
														break;
													
													case 2:
														if (mShield > 0)
														{
															if (gold >= mShieldCost)
															{
																if (mDagger == 0)
																{
																	System.out.println ( "You set aside the Jeweled Dagger and it vanishes! -1 MinDMG, -1 Dex" );
																	System.out.println ( "A few coins materialize in its place. +10 gold" );
																	minDMG--;
																	dex--;
																	gold += 10;
																	mDagger++;
																}
																System.out.println ( "You grab your new shield and feel full of Vigor! +1 resistance = +25 Max HP" );
																hpMax += 25;												
																gold -= mShieldCost;
																mShield--;
																
															}
															else
															{
																System.out.println ( "You are too poor for this item. you have " + gold + " gold");
															}
														}
														else
														{
															System.out.println ( "Sorry, This item is out of stock." );
														}
														break;
														
													case 3:
														if (bSword > 0)
														{
															if (gold >= bSwordCost)
															{
																System.out.println ( "A chill flows from your palm to the top of your head." );
																System.out.println ( "It feels as though you pulled this sword from its own grave" );
																System.out.println ( "DMG = 6 - 12" );
																minDMG = 6;
																maxDMG = 12;
																gold -= bSwordCost;
																bSword--;
																if (fighter == 1) {
																	maxDMG += 2;
																}
																if (loser == 1) {
																	maxDMG--;
																}
																if (mDagger == 0)
																{
																	minDMG++;
																}
															}
															else
															{
																System.out.println ( "You are too poor for this item. you have " + gold + " gold");
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
											if (gold >= INNCOST)
											{
												System.out.println ( "You recieve a good nights rest. + 75 HP" );
												hp += 75;
												points -= 75;
												gold -= INNCOST;
												if (hp > hpMax)
												{
													hp = hpMax;
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
													int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
													switch (enemy)
													{
													case 1: System.out.println ("A fight started up outside the pub \n and some Drunkass threw his tankard at you..." ); //thief pack
													int DrunkassHP = 25;
													while (DrunkassHP > 0)  //fight sequence
													{	
														int Drunkass = (int) ( Math.random ( ) * 12 + 5 );
														System.out.println ( "Drunkass attacks for " + Drunkass + " damage.");
														hitChance = (int) ( Math.random ( ) * 11 + 3);  //chance to evade
														if (evade > hitChance) 
														{
															System.out.println ( "But Misses!" );
														}
														else
														{
															hp -= Drunkass;
															System.out.println ( "-" + Drunkass + " HP. " + "HP is " + hp);
															if (hp < 1)
															{
																chapter = 0;
																direction = 'A';
																merch = 0;
																cityRoadCount = 9;
																city = 6;
																citySearch = 'n';
																DrunkassHP = 0;
																break;
															}
														}
														 //battle decision
														System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
														battleDec = input.nextInt();
														if (battleDec == 0) {
															hitChance = (int) ( Math.random ( ) * 8 + 3);  //chance to flee
															if (evade > hitChance) {
																System.out.println ( "You run away! Coward!" );
																break;
															}
															else {
																System.out.println ( "You try to run, but you trip and fall on your face." );
															}
														}
														
														//attack
														if (battleDec == 1) {
															hitDMG = (int) ( Math.random ( ) * attack + minDMG);
															hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
															if (dex >= hitChance)
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
														if (battleDec == 5) {
															if (hpPot > 0) {
																System.out.println ( "That Sauce is Awesome! +25HP" );
																hpPot --;
																points -= 25;
																hp += 25;
																if (hp > hpMax) {
																	hp = hpMax;
																}
															}
															else {
																System.out.println ( "Fool! You have no Sauce in supply!" );
															}
														}
													}
													if (DrunkassHP <= 0) {
														if (hp > 0) {
															System.out.println ( "You knocked out that Asshole and picked up the\n gold tooth you knocked out of his mouth. +10 gold" );
															gold += 10;
															points += 80;
														}
													}
													break;
													
													case 2:  // you find the girl
													if (victim > 0)
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
																hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to evade
																if (evade > hitChance) 
																{
																	System.out.println ( "But Misses!" );
																}
																else
																{
																	hp -= vandal;
																	System.out.println ( "-" + vandal + " HP. " + "HP is " + hp);
																	if (hp < 1)
																	{
																		chapter = 0;
																		direction = 'A';
																		merch = 0;
																		cityRoadCount = 9;
																		citySearch = 'n';
																		city = 6;
																		vandalHP = 0;
																		break;
																	}
																}
																 //battle decision
																System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
																battleDec = input.nextInt();
																if (battleDec == 0) {
																	hitChance = (int) ( Math.random ( ) * 8 + 5);  //chance to flee
																	if (evade > hitChance) {
																		System.out.println ( "You run away! Coward!" );
																		break;
																	}
																	else {
																		System.out.println ( "You try to run, but you trip and fall on your face." );
																	}
																}
																//attack
																if (battleDec == 1) {
																	hitDMG = (int) ( Math.random ( ) * attack + minDMG);
																	hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
																	if (dex >= hitChance)
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
																if (battleDec == 5) {
																	if (hpPot > 0) {
																		System.out.println ( "That Sauce is Awesome! +25HP" );
																		hpPot --;
																		points -= 25;
																		hp += 25;
																		if (hp > hpMax) {
																			hp = hpMax;
																		}
																	}
																	else {
																		System.out.println ( "Fool! You have no Sauce in supply!" );
																	}
																}
															}
															if (vandalHP <= 0) {
																if (hp > 0) {
																	System.out.println ( "You killed a couple Greasy Vandals and saved the girl!" );
																	System.out.println ( "She is shaken, but thanks you and gives you a kiss on the cheek" );
																	System.out.println ( "It felt so wonderful you breifly closed your eyes\n When you opened them she was gone" );
																	System.out.println ( "+25 Max HP" );
																	hpMax += 25;
																	victim--;
																	points += 200;
																}
															}
														}
													}
													else
													{
														if (hp > 0) {
															System.out.println ( "You wander back to the spot where you saved that young lady" );
															System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
															gold += 1;
														}
													}
													break;
													
													case 3: System.out.println ( "Its a Giant Sewer Rat! " );   //Sewer Rat
													int ratHP = 25;
													while (ratHP > 0)  //fight sequence
													{	
														int rat = (int) ( Math.random ( ) * 8 + 5 );
														System.out.println ( "Giant Sewer Rat bites for " + rat + " damage.");
														hitChance = (int) ( Math.random ( ) * 12 + 6);  //chance to evade
														if (evade > hitChance) 
														{
															System.out.println ( "But Misses!" );
														}
														else
														{
															hp -= rat;
															System.out.println ( "-" + rat + " HP. " + "HP is " + hp);
															if (hp < 1)
															{
																chapter = 0;
																direction = 'A';
																merch = 0;
																cityRoadCount = 9;
																citySearch = 'n';
																city = 6;
																ratHP = 0;
																break;
															}
														}
														 //battle decision
														System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
														battleDec = input.nextInt();
														if (battleDec == 0) {
															hitChance = (int) ( Math.random ( ) * 6 + 6);  //chance to flee
															if (evade > hitChance) {
																System.out.println ( "You run away! Coward!" );
																break;
															}
															else {
																System.out.println ( "You try to run, but you trip and fall on your face." );
															}
														}
														
														//attack
														if (battleDec == 1) {
															hitDMG = (int) ( Math.random ( ) * attack + minDMG);
															hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
															if (dex >= hitChance)
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
														if (battleDec == 5) {
															if (hpPot > 0) {
																System.out.println ( "That Sauce is Awesome! +25HP" );
																hpPot --;
																points -= 25;
																hp += 25;
																if (hp > hpMax) {
																	hp = hpMax;
																}
															}
															else {
																System.out.println ( "Fool! You have no Sauce in supply!" );
															}
														}
													}
													if (ratHP <= 0) {
														if (hp > 0) {
															System.out.println ( "You killed a Giant Sewer Rat! Gross!" );
															System.out.println ( "One of the locals witnessed your heroic deed and hands you 15 gold" );
															gold += 15;
															points += 100;
														}
													}
													if (hp < 1) {
														break;
													}
												}
												if (hp < 1) {
													break;
												}	
											}
											if (hp < 1) {
												break;
											}
											System.out.println ( "Keep walking about aimlessly? y/n" );
											do  //check character input
											{
												if (hp < 1) {
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
											System.out.println ( "Enter 6 to confirm. Enter 0 to  Return to Common Board" );
											city = input.nextInt();
											if (city == 6)
											{
												System.out.println ( "Where to?" );
												System.out.println ( "N - Take Carriage back to Merchant Camp. (10 gold)");
												System.out.println ( "W - Hike to Humble Mountain" );
												if (chaosDemonLife == 0) {
													System.out.println ( "S - A man standing at the City Gates recognizes you as the one who ended the rain of fire" );
													System.out.println ( "Not knowing how he knows this, you aknowledge him\nand he offers you a free ride south with his caravan." );
												}
												direction = input.next ( ).toUpperCase ( ).charAt ( 0 );
												if (direction == 'N')
												{
													if (gold >= carriage)
													{
														gold -= carriage;
														merch = 0;
														merchCount = 0;
														System.out.println ( "The ride back to the Merchant Camp lasts the rest of\n the day and night, and is not very exciting\n" );
														
													}
													else
													{
														System.out.println ( "It's not that much money, go get some more." );
														city = 9;
													}
												}
												if (direction == 'S' && chaosDemonLife == 0) {
													System.out.println ( "You desire to leave this place as there is nothing left here for you." );
													System.out.println ( "(this option will end this chapter of the game\nand you may not be able to return) continue? y/n" );
													do  //check character input
													{
														citySearch = input.next ( ).toLowerCase ( ).charAt ( 0 );
														if (citySearch != 'y' && citySearch != 'n')  
														{
															System.out.println ( "You must enter y or n" );
														}
													} while (citySearch != 'y' && citySearch != 'n');
													if (citySearch == 'y') {
														chapter = 3;
														break;
													}
													else {
														System.out.println ( "You decide there are some things you need to wrap-up..." );
														city = 9;
													}
												}
												if (hp < 1) {
													break;
												}
											}
											if (hp < 1) {
												break;
											}
										}// end commonBoard Switch
									if (hp < 1) {
										break;
									}
									}//end city decision
								if (hp < 1) {
									break;
								}
					
								if (direction == 'W') {
								System.out.println ( "Its a Hard road to the mountain, but there's no turning back now..." );
								System.out.println ( "Press Enter to start your climb" );
								KeyIn.nextLine();
								mtnRoadCount = 0;
								while (mtnRoadCount < 3)
								{
									rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
									if (encNumber == rand)
									{
										int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
										switch (enemy)
										{
											case 1: System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
											int fireSpriteHP = 30;
											while (fireSpriteHP > 0)  //fight sequence
											{	
												int fireSprite = (int) ( Math.random ( ) * 9 + 5 );
												System.out.println ( "Fire Sprite throws fireball for " + fireSprite + " damage.");
												hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to evade
												if (evade > hitChance) 
												{
													System.out.println ( "But Misses!" );
												}
												else
												{
													hp -= fireSprite;
													System.out.println ( "-" + fireSprite + " HP. " + "HP is " + hp);
													if (hp < 1)
													{
														chapter = 0;
														direction = 'A';
														merch = 0;
														mtnRoadCount = 9;
														city = 6;
														fireSpriteHP = 0;
														break;
													}
												}
												 //battle decision
												System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
												battleDec = input.nextInt();
												if (battleDec == 0) {
													hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
													if (evade > hitChance) {
														System.out.println ( "You run away! Coward!" );
														break;
													}
													else {
														System.out.println ( "You try to run, but you trip and fall on your face." );
													}
												}
												
												//attack
												if (battleDec == 1) {
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
													if (dex >= hitChance)
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
												if (battleDec == 5) {
													if (hpPot > 0) {
														System.out.println ( "That Sauce is Awesome! +25HP" );
														hpPot --;
														points -= 25;
														hp += 25;
														if (hp > hpMax) {
															hp = hpMax;
														}
													}
													else {
														System.out.println ( "Fool! You have no Sauce in supply!" );
													}
												}
											}
											if (fireSpriteHP <= 0) {
												if (hp > 0) {
													System.out.println ( "You Extinguish the Fire Sprite and a find a hot Ruby melting the surrounding snow. + 15 gold" );
													gold += 15;
													points += 125;
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
														hitChance = (int) ( Math.random ( ) * 12 + 6);  //chance to evade
														if (evade > hitChance) 
														{
															System.out.println ( "But Misses!" );
														}
														else
														{
															hp -= mimic;
															System.out.println ( "-" + mimic + " HP. " + "HP is " + hp);
															if (hp < 1)
															{
																chapter = 0;
																direction = 'A';
																merch = 0;
																mtnRoadCount = 9;
																city = 6;
																mimicHP = 0;
																break;
															}
														}
														 //battle decision
														System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
														battleDec = input.nextInt();
														if (battleDec == 0) {
															hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
															if (evade > hitChance) {
																System.out.println ( "You run away! Coward!" );
																break;
															}
															else {
																System.out.println ( "You try to run, but you trip and fall on your face." );
															}
														}
													
														//attack
														if (battleDec == 1) {
															hitDMG = (int) ( Math.random ( ) * attack + minDMG);
															hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
															if (dex >= hitChance)
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
														if (battleDec == 5) {
															if (hpPot > 0) {
																System.out.println ( "That Sauce is Awesome! +25HP" );
																hpPot --;
																points -= 25;
																hp += 25;
																if (hp > hpMax) {
																	hp = hpMax;
																}
															}
															else {
																System.out.println ( "Fool! You have no Sauce in supply!" );
															}
														}
													}
													if (mimicHP <= 0) {
														if (hp > 0) {
															System.out.println ( "You killed a Mimic! You open its skull, which resembles a chest, and find a Diamond! + 20 gold" );
															gold += 20;
															points += 150;
														}
													}
												}
												else 
												{
													if (hp > 0) {
														System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
														gold += 20;
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
												hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
												if (evade > hitChance) 
												{
													System.out.println ( "But Misses!" );
												}
												else
												{
													hp -= mtnTroll;
													System.out.println ( "-" + mtnTroll + " HP. " + "HP is " + hp);
													if (hp < 1)
													{
														chapter = 0;
														direction = 'A';
														merch = 0;
														mtnRoadCount = 9;
														city = 6;
														mtnTrollHP = 0;
														break;
													}
												}
												 //battle decision
												System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
												battleDec = input.nextInt();
												if (battleDec == 0) {
													hitChance = (int) ( Math.random ( ) * 6 + 4);  //chance to flee
													if (evade > hitChance) {
														System.out.println ( "You run away! Coward!" );
														break;
													}
													else {
														System.out.println ( "You try to run, but you trip and fall on your face." );
													}
												}
												
												//attack
												if (battleDec == 1) {
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
													if (dex >= hitChance)
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
												if (battleDec == 5) {
													if (hpPot > 0) {
														System.out.println ( "That Sauce is Awesome! +25HP" );
														hpPot --;
														points -= 25;
														hp += 25;
														if (hp > hpMax) {
															hp = hpMax;
														}
													}
													else {
														System.out.println ( "Fool! You have no Sauce in supply!" );
													}
												}
											}
											if (mtnTrollHP <= 0) {
												if (hp > 0) {
													System.out.println ( "You killed a Mountain Troll! Wow! Its pouch holds 20 gold" );
													gold += 20;
													points += 135;
												}
											}
											if (hp < 1) {
												break;
											}
										}
										if (hp < 1) {
											break;
										}
									} 
									if (hp < 1) {
										break;
									}
									mtnRoadCount++;
									rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
									System.out.println ( "Camp " + mtnRoadCount + ". Press Enter to continue Upward" );
									KeyIn.nextLine ( );
							}// end mountain road
								if (hp < 1) {
									break;
								}																																	//the mountain top
						if (hp > 0) {
							System.out.println ( "The top of the mountain is a meandering trenchwork of jagged rock and snow covered boulders." );
							System.out.println ( "You will need to find another way down..." );
							System.out.println ( "Would you like to look around first? y/n" );
						}
						char mountain = 'a';
						do  //check character input
						{
							if (hp < 1) {
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
								int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
								switch (enemy)
								{
									case 1: System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
									int fireSpriteHP = 30;
									while (fireSpriteHP > 0)  //fight sequence
									{	
										int fireSprite = (int) ( Math.random ( ) * 9 + 5 );
										System.out.println ( "Fire Sprite throws fireball for " + fireSprite + " damage.");
										hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to evade
										if (evade > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											hp -= fireSprite;
											System.out.println ( "-" + fireSprite + " HP. " + "HP is " + hp);
											if (hp < 1)
											{
												chapter = 0;
												direction = 'A';
												merch = 0;
												mtnRoadCount = 9;
												city = 6;
												mountain = 'n';
												fireSpriteHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
										battleDec = input.nextInt();
										if (battleDec == 0) {
											hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
											if (evade > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										
										//attack
										if (battleDec == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
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
										if (battleDec == 5) {
											if (hpPot > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												hpPot --;
												points -= 25;
												hp += 25;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (fireSpriteHP <= 0) {
										if (hp > 0) {
											System.out.println ( "You Extinguish the Fire Sprite and a find a hot Ruby melting the surrounding snow. + 15 gold" );
											gold += 15;
											points += 125;
										}
									}
									break;
									
									case 2:  // Chaos Demon
										if (chaosDemonLife > 0)
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
												hp += hpMax / 2;
												if (hp > hpMax) {
													hp = hpMax;
												}
												System.out.println ( "Press Enter" );
												KeyIn.nextLine ( );
												int chaosDemonHP = 80;
												while (chaosDemonHP > 0)  //fight sequence
												{	
													int chaosDemon = (int) ( Math.random ( ) * 12 + 6 );
													System.out.println ( "Chaos Demon attacks for " + chaosDemon + " damage.");
													hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to evade
													if (evade > hitChance) 
													{
														System.out.println ( "But Misses!" );
													}
													else
													{
														hp -= chaosDemon;
														System.out.println ( "-" + chaosDemon + " HP. " + "HP is " + hp);
														if (hp < 1)
														{
															chapter = 0;
															direction = 'A';
															merch = 0;
															mtnRoadCount = 9;
															city = 6;
															mountain = 'n';
															chaosDemonHP = 0;
															break;
														}
													}
													 //battle decision
													System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
													battleDec = input.nextInt();
													if (battleDec == 0) {
														hitChance = (int) ( Math.random ( ) * 8 + 5);  //chance to flee
														if (evade > hitChance) {
															System.out.println ( "You run away! Coward!" );
															break;
														}
														else {
															System.out.println ( "You try to run, but you trip and fall on your face." );
														}
													}
													//attack
													if (battleDec == 1) {
														hitDMG = (int) ( Math.random ( ) * attack + minDMG);
														hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
														if (dex >= hitChance)
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
													if (battleDec == 5) {
														if (hpPot > 0) {
															System.out.println ( "That Sauce is Awesome! +25HP" );
															hpPot --;
															points -= 25;
															hp += 25;
															if (hp > hpMax) {
																hp = hpMax;
															}
														}
														else {
															System.out.println ( "Fool! You have no Sauce in supply!" );
														}
													}
												}
												if (chaosDemonHP <= 0) {
													if (hp > 0) {
														System.out.println ( "You swing!... your blade cuts through empty air, at the same time\nan intense gust of wind throws you forward violently..." );
														System.out.println ( "The Chaos Demon imploded! Only a hot lump of glowing ore remains." );
														System.out.println ( "A small piece of glowing ore has broken apart from the rest and you pick it up" );
														System.out.println ( "It is extremely heavy for its size and you feel a part of yourself being tied to this small gem" );
														System.out.println ( "+25 Max HP. HP fully restored! + 50 gold" );
														hpMax += 25;
														hp = hpMax;
														gold += 50;
														chaosDemonLife --;
														points += 500;
													}
												}
											}
										}
										else
										{
											if (hp > 0) {
												System.out.println ( "You wander back to the spot where you fought the Chaos Demon" );
												System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
												gold += 1;
											}
										}
										break;
									
									case 3: System.out.println ( "The ground quakes and a Mountain Troll lurches toward you. " );   //MudMan
									int mtnTrollHP = 50;
									while (mtnTrollHP > 0)  //fight sequence
									{	
										int mtnTroll = (int) ( Math.random ( ) * 8 + 8 );
										System.out.println ( "Mountain Troll clubs you for " + mtnTroll + " damage.");
										hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
										if (evade > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											hp -= mtnTroll;
											System.out.println ( "-" + mtnTroll + " HP. " + "HP is " + hp);
											if (hp < 1)
											{
												chapter = 0;
												direction = 'A';
												merch = 0;
												mtnRoadCount = 9;
												city = 6;
												mountain = 'n';
												mtnTrollHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
										battleDec = input.nextInt();
										if (battleDec == 0) {
											hitChance = (int) ( Math.random ( ) * 6 + 4);  //chance to flee
											if (evade > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										
										//attack
										if (battleDec == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
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
										if (battleDec == 5) {
											if (hpPot > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												hpPot --;
												points -= 25;
												hp += 25;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (mtnTrollHP <= 0) {
										if (hp > 0) {
											System.out.println ( "You killed a Mountain Troll! Wow! Its pouch holds 20 gold" );
											gold += 20;
											points += 135;
										}
									}
									if (hp < 1) {
										break;
									}
							}
								if (hp < 1) {
									break;
								}
							
						}
							if (hp < 1) {
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
						if (hp < 1) {
							break;
						}
						System.out.println ( "You find an old merchant trail marker and head Down the Mountain" );         //other side of mountain
						System.out.println ( "Enter to continue" );
						KeyIn.nextLine();
						mtnRoadCount = 0;
						while (mtnRoadCount < 3)
						{
							rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
							if (encNumber == rand)
							{
								int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
								switch (enemy)
								{
									case 1: System.out.println ("The surrounding rocks shimmer... A Fire Sprite floats closer" ); //fireSprite pack
									int fireSpriteHP = 30;
									while (fireSpriteHP > 0)  //fight sequence
									{	
										int fireSprite = (int) ( Math.random ( ) * 9 + 5 );
										System.out.println ( "Fire Sprite throws fireball for " + fireSprite + " damage.");
										hitChance = (int) ( Math.random ( ) * 12 + 5);  //chance to evade
										if (evade > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											hp -= fireSprite;
											System.out.println ( "-" + fireSprite + " HP. " + "HP is " + hp);
											if (hp < 1)
											{
												chapter = 0;
												direction = 'A';
												merch = 0;
												mtnRoadCount = 9;
												city = 6;
												fireSpriteHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
										battleDec = input.nextInt();
										if (battleDec == 0) {
											hitChance = (int) ( Math.random ( ) * 8 + 4);  //chance to flee
											if (evade > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										
										//attack
										if (battleDec == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
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
										if (battleDec == 5) {
											if (hpPot > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												hpPot --;
												points -= 25;
												hp += 25;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (fireSpriteHP <= 0) {
										if (hp > 0) {
											System.out.println ( "You Extinguish the Fire Sprite and a find a hot Ruby melting the surrounding snow. + 15 gold" );
											gold += 15;
											points += 125;
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
												hitChance = (int) ( Math.random ( ) * 12 + 6);  //chance to evade
												if (evade > hitChance) 
												{
													System.out.println ( "But Misses!" );
												}
												else
												{
													hp -= mimic;
													System.out.println ( "-" + mimic + " HP. " + "HP is " + hp);
													if (hp < 1)
													{
														chapter = 0;
														direction = 'A';
														merch = 0;
														mtnRoadCount = 9;
														city = 6;
														mimicHP = 0;
														break;
													}
												}
												 //battle decision
												System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
												battleDec = input.nextInt();
												if (battleDec == 0) {
													hitChance = (int) ( Math.random ( ) * 7 + 5);  //chance to flee
													if (evade > hitChance) {
														System.out.println ( "You run away! Coward!" );
														break;
													}
													else {
														System.out.println ( "You try to run, but you trip and fall on your face." );
													}
												}
											
												//attack
												if (battleDec == 1) {
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
													if (dex >= hitChance)
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
												if (battleDec == 5) {
													if (hpPot > 0) {
														System.out.println ( "That Sauce is Awesome! +25HP" );
														hpPot --;
														points -= 25;
														hp += 25;
														if (hp > hpMax) {
															hp = hpMax;
														}
													}
													else {
														System.out.println ( "Fool! You have no Sauce in supply!" );
													}
												}
											}
											if (mimicHP <= 0) {
												if (hp > 0) {
													System.out.println ( "You killed a Mimic! You open its skull, which resembles a chest, and find a Diamond! + 20 gold" );
													gold += 20;
													points += 150;
												}
											}
										}
										else 
										{
											if (hp > 0) {
												System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
												gold += 20;
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
										hitChance = (int) ( Math.random ( ) * 11 + 4);  //chance to evade
										if (evade > hitChance) 
										{
											System.out.println ( "But Misses!" );
										}
										else
										{
											hp -= mtnTroll;
											System.out.println ( "-" + mtnTroll + " HP. " + "HP is " + hp);
											if (hp < 1)
											{
												chapter = 0;
												direction = 'A';
												merch = 0;
												mtnRoadCount = 9;
												city = 6;
												mtnTrollHP = 0;
												break;
											}
										}
										 //battle decision
										System.out.println ( "1-Attack, 5-EEL Sauce (" + hpPot + "), 0-Flee" );
										battleDec = input.nextInt();
										if (battleDec == 0) {
											hitChance = (int) ( Math.random ( ) * 6 + 4);  //chance to flee
											if (evade > hitChance) {
												System.out.println ( "You run away! Coward!" );
												break;
											}
											else {
												System.out.println ( "You try to run, but you trip and fall on your face." );
											}
										}
										
										//attack
										if (battleDec == 1) {
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
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
										if (battleDec == 5) {
											if (hpPot > 0) {
												System.out.println ( "That Sauce is Awesome! +25HP" );
												hpPot --;
												points -= 25;
												hp += 25;
												if (hp > hpMax) {
													hp = hpMax;
												}
											}
											else {
												System.out.println ( "Fool! You have no Sauce in supply!" );
											}
										}
									}
									if (mtnTrollHP <= 0) {
										if (hp > 0) {
											System.out.println ( "You killed a Mountain Troll! Wow! Its pouch holds 20 gold" );
											gold += 20;
											points += 135;
										}
									}
									if (hp < 1) {
										break;
									}
								}
								if (hp < 1) {
									break;
								}
							
							}
							if (hp < 1) {
								break;
							}
							mtnRoadCount++;
							rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
							System.out.println ( "Camp " + mtnRoadCount + ". Press Enter to continue Downward" );
							KeyIn.nextLine ( );
							direction = 'N';
							merchCount = 0;
						}
						}// end if mountain
						}// end merchant option switch
					}	
					} //end direction N  
				}//end chapter 2
				
				while (chapter == 3) {
					System.out.println ( "Good Job. Youve completed chapter 2");
					chapter = 0;
					hp = 0;
					break;
				}
			}//end hp > 0
			System.out.println ( "GAME OVER.  SCORE: " + points );
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
	KeyIn.close();	
	input.close();
	}

} 

