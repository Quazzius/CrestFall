import java.util.Scanner;

public class CfRoads
{
	
	public static final int minEnc = 1, maxEnc = 2, encNumber = 1, range = maxEnc - minEnc + 1;
	public static int rand, attack, hitDMG, hitChance, merch;
	

	public static void forest() {
		//Journey through the forest
		Scanner KeyIn = new Scanner(System.in);
		int merch = 0;
		Var.setAreaCount(0);
		System.out.println ( "You begin your journey heading South through the overgrown Elderwood forest" );
		while (Var.getAreaCount() < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("You stumbled accross a Bear, Fuck" );   //Bear fight
						char enemyAbility = 'a';  //enemy special ability class ( none)
						int enemyHP = 12;   //enemy health initialize
						String eType = "Bear"; //type of enemy
						String aType = " Swipes";  //attack style
						String killText = "You killed a "; //type of death
						String deathFlavor = "! +5 gold for some reason"; //flavor text on enemy death
						int minRange = 3, maxRange = 8;  // enemy damage range;
						int eMinHit = 4, eMaxHit = 10;  // enemy chance to hit
						int minFlee = 4, maxFlee = 8;   // chance to flee from  enemy
						int heroHit = 8;  // chance to hit enemy
						int rewardGold = 5, rewardPoints = 50;
						 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit, enemyHP, maxFlee, 
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
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
						CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
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
						 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
				}
			}
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue South" );
				KeyIn.nextLine ( );
			}
		}
	}

	public static char roadFork () {
			Scanner input = new Scanner(System.in);
			Scanner KeyIn = new Scanner(System.in);
			System.out.println ( "You find the road after 3 days and shortly thereafter come to a Fork." );
			System.out.println ( "You're still alive with " + Var.hp + " HP, and " + Var.getGold() + " gold. Cool..." );
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
			
			return roadFork;	
	}

	public static  void merchantRoad() {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "The Merchant Camp is 3 days from the fork" );
		System.out.println ( "The road is good for traveling but you have heard there are bandits along these roads" );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		int merch = 0;
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
					String deathFlavor = "! They each had 2 coins stashed... somewhere. + 4 gold";
					int minRange = 1; 
					int maxRange = 6;
					int eMinHit = 4; 
					int eMaxHit = 10;
					int minFlee = 4; 
					int maxFlee = 8;
					int heroHit = 8;
					int rewardGold = 4;
					int rewardPoints = 25;
					 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
							minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
				
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
							 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
									minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
						}
						else
						{
							System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
							System.out.println ( "He gives you 10 gold for your services and company" );
							Var.setGold(10);
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
					 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
							minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
			
				}
			
			}
			if (Var.getAreaCount() < 3 && Var.getHp() > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue West" );
				KeyIn.nextLine ( );
			}
		}
		if (Var.getHp() > 0) {
			Var.setChapter(2);
		}
	} //End Merchant Road

	public static void swampRoad1 () {
		char enemyAbility;
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "Lets take the muddy road then..." );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "The road meanders to the SouthEast and the air cathces a chill" );
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
						 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
					
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
								 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
										minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
						
							}
							else 
							{
								System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
								Var.setGold(8);
								
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
						 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
					
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
						 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
					
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue East" );
				KeyIn.nextLine ( );
			}
		}// end swamp road	
	}

	public static void swampRoad2() {
		char enemyAbility;
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		System.out.println ( "The only road out is northwest to the Merchant Camp" );       //other side of lake
		System.out.println ( "Enter to continue" );
		KeyIn.nextLine();
		System.out.println ( "You now head northWest along another muddy trail." );
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
					 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
							minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
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
						 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
								minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
					}
					else 
					{
						System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
						Var.setGold(8);
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
					 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
							minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
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
					 CfSequence.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
							minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
			
				}
			}
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue West" );
				KeyIn.nextLine ( );	
			}
		}// end swamp road 2
		Var.setMerchCount(0);
		Var.setChapter(2);
	}

	public static void cityRoad() {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
					 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				
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
							 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
								enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
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
					 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
						enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue South" );
				KeyIn.nextLine ( );
			}
		}
	}

	public static void mountainRoad1() {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Its a Hard road to the mountain, but there's no turning back now..." );
		System.out.println ( "Press Enter to start your climb" );
		KeyIn.nextLine();
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
								 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								Var.setGold(20);	
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue Upward" );
				KeyIn.nextLine ( );
			}
		}// end mountain road											
	}

	public static void mountainRoad2() {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
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
								 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								Var.setGold(20);	
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
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
						rewardGold = 13;
						rewardPoints = 140;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			}
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue Downward" );
				KeyIn.nextLine ( );
			}
			
		}
		if (Var.hp > 0) {
			Var.setDirection(1);
			Var.setMerchCount(0);
		}
		else {
			Var.setDirection(0);
		}
	}

	public static void sValleyRoad( String nautical) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
								 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a chest full of coin! + 20 gold" );
								Var.setGold(20);	
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end valley road	
	}

	public static void wMarshRoad( String nautical) {
		System.out.println ( "You can feel the humidity rise as your steps begin to sink further into the saturated ground" );
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
								 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "You can hear a creaky sigh let out from the tree as you approach.\n"
										+ "It gives itself a decent shake and drops 25 gold coins along with a few dead animals\nand a bottle of Snake Oil!"
										+ " + 25 gold!" );
								Var.setGold(25);	
							}
							if (Var.getHpPot() > 0) {
								System.out.println ( "Delicious! +40 HP" );
								Var.setHp(40);
							}
							else {
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot(1);
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
						rewardGold = 18;
						rewardPoints = 140;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end marsh road
	}

	public static void fDesertRoad( String nautical) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("The ground explodes in front of you and a glistening insect crawls from the chasm" ); //Ferns
						enemyAbility = 'p';
						int enemyHP = 35;   
						String eType = "Crystal Scorpion";
						String aType = " Stings";
						String killText = "You crush the ";
						String deathFlavor = " and find it has a diamond for a heart. +17 Gold! ";
						int minRange = 5; 
						int maxRange = 7;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 17;
						int rewardPoints = 155;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
					break;
					
					case 2: 
						System.out.println ("You see a frozen Oasis off in the distance"  ); //tree
						System.out.println ( "Investigate the Oasis? y/n" );
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
							System.out.println ( "Thats gotta be a mirage, lets not waste time." );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
								System.out.println ( "It was a Mirage! you've heard stories of the desert phantom..." );
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
								 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "The Oasis looks like a paradise litterally frozen in time.\n "
										+ "You see something shining beneath the water and after punching through\n "
										+ "the ice, you find 20 gold and a bottle of snake oil!" );
								Var.setGold(25);	
							}
							if (Var.getHpPot() > 0) {
								System.out.println ( "Delicious! +40 HP" );
								Var.setHp(40);
							}
							else {
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot(1);
							}
						}
					break;
					
					case 3: 
						System.out.println ( "A ball of blue light hovers above the ground and is coming for you..." );   //banshee
						enemyAbility = 'v';
						enemyHP = 40;   
						eType = "Will-o'-the-wisp";
						aType = " bludgeons";
						killText = "You defeated a ";
						deathFlavor = "! A Sapphire remains after its flame dissipated. +18 gold";
						minRange = 6; 
						maxRange = 7;
					 	eMinHit = 5; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 8;
						heroHit = 9;
						rewardGold = 18;
						rewardPoints = 140;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("A huge hairy boulder lies ahead... Giant Tarantula! " ); //air elemental
						enemyAbility = 'a';
						enemyHP = 60;   
						eType = "TaranTroll";
						aType = " lunges";
						killText = "You Skewer the ";
						deathFlavor = " and claim one of its fangs as a prize + 20 gold";
						minRange = 7; 
						maxRange = 8;
					 	eMinHit = 4; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 175;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end desert road	
	}

	public static void sCliffsRoad( String nautical) {
		System.out.println ( "The trail gradually unfreezes and then disappears.\nYou sense no one has been this way in a very long time...\n" );
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("Mother of God! ANTS!" ); //Ferns
						enemyAbility = 'p';
						int enemyHP = 40;   
						String eType = "Komodo Ants";
						String aType = " Sting";
						String killText = "You grind the ";
						String deathFlavor = " into the ground and wipe the sweat from your brow.\n15 Gold falls from the sky. It just does... ";
						int minRange = 7; 
						int maxRange = 5;
						int eMinHit = 5; 
						int eMaxHit = 12;
						int minFlee = 4; 
						int maxFlee = 8;
						int heroHit = 9;
						int rewardGold = 15;
						int rewardPoints = 155;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
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
								enemyHP = 45;   
								eType = "Salty Mimic";
								aType = " chomps";
								killText = "You killed a ";
								deathFlavor = "!\nYou open its skull, which resembles a chest, and find a bunch of coins! + 25 gold";
								minRange = 7; 
								maxRange = 8;
							 	eMinHit = 6; 
								eMaxHit = 12;
								minFlee = 5; 
								maxFlee = 7;
								heroHit = 9;
								rewardGold = 25;
								rewardPoints = 150;
								 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
									enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "You find a bunch of coins worth 25 gold! Killer!" );
								Var.setGold(25);	
							}
						}
					break;
					
					case 3: 
						System.out.println ( "Someone is walking beside you... for how long?" );   //doppleganger
						enemyAbility = 'v';
						enemyHP = 40;   
						eType = "Doppleganger";
						aType = " strikes";
						killText = "You Killed a ";
						deathFlavor = "! An amorphous blob is all that remains, along with 18 gold";
						minRange = 6; 
						maxRange = 7;
					 	eMinHit = 5; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 8;
						heroHit = 9;
						rewardGold = 18;
						rewardPoints = 150;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("A swarm of winged miniature bears burst from the ground! " ); //air elemental
						enemyAbility = 'a';
						enemyHP = 50;   
						eType = "MiniBears";
						aType = " Bite";
						killText = "You Murder the viscious ";
						deathFlavor = ". You notice later that your purse is heavier + 20 gold";
						minRange = 6; 
						maxRange = 7;
					 	eMinHit = 6; 
						eMaxHit = 12;
						minFlee = 5; 
						maxFlee = 7;
						heroHit = 9;
						rewardGold = 20;
						rewardPoints = 175;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			} 
			if (Var.getAreaCount() < 3 && Var.hp > 0) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end desert road	
	}

	public static void sForestRoad( String nautical) {
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		char enemyAbility;
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine();
		Var.setAreaCount(0);
		while (Var.getAreaCount() < 3)
		{
			rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
			if (encNumber == rand)
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1);  //random enemy
				switch (enemy)
				{
					case 1: 
						System.out.println ("You smell something delicious and your mind drifts... you're all of a sudden eye-to-eye with an Old Hag" ); //Ferns
						enemyAbility = 's';
						int enemyHP = 50;   
						String eType = "Hag Witch";
						String aType = " Strikes";
						String killText = "The ";
						String deathFlavor = " shrivels up and smolders to ash. You search its camp and find 25 gold.";
						int minRange = 7; 
						int maxRange = 9;
						int eMinHit = 6; 
						int eMaxHit = 13;
						int minFlee = 6; 
						int maxFlee = 8;
						int heroHit = 10;
						int rewardGold = 25;
						int rewardPoints = 220;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
					break;
					
					case 2: 
						System.out.println ("A small cave can be seen through the thick foliage..."  ); //tree
						System.out.println ( "Investigate the cave? y/n" );
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
							System.out.println ( "I'm not going anywhere near that forsaken dungeon..." );
						}
						else
						{
							int ruse =	(int) ( Math.random ( ) * 10);
							if (ruse >= 5)
							{
									System.out.println ("The cry of a hundred Giant Vampire bats ring though the cave" ); //bat 
									enemyAbility = 'v';
									enemyHP = 50;   
									eType = "Giant Vampire Bat";
									aType = " swoops";
									killText = "You slaughter the colony of ";
									deathFlavor = "s and find a stash of 25 gold along with a bottle of Snake Oil!";
									minRange = 7; 
									maxRange = 6;
								 	eMinHit = 6; 
									eMaxHit = 13;
									minFlee = 5; 
									maxFlee = 7;
									heroHit = 10;
									rewardGold = 25;
									rewardPoints = 200;
									 CfSequence.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
										enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
							}
							else 
							{
								System.out.println ( "Thankfully the cave's occupants are away and amongst their droppings you find\n"
										+ "25 gold coins along with a few dead animals\nand a bottle of Snake Oil!");
								Var.setGold(25);	
							}
							if (Var.getHpPot() > 0) {
								System.out.println ( "\nDelicious! +40 HP" );
								Var.setHp (40);
							}
							else {
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot(1);
							}
						}
					break;
					
					case 3: 
						System.out.println ( "A cloud of spores floats by and a MushMan hops your way" );   //doppleganger
						enemyAbility = 'p';
						enemyHP = 50;   
						eType = "MushMan";
						aType = " strikes";
						killText = "You Killed a ";
						deathFlavor = " and now feel kind of sad, until you find 25 gold! ";
						minRange = 7; 
						maxRange = 7;
					 	eMinHit = 5; 
						eMaxHit = 11;
						minFlee = 4; 
						maxFlee = 8;
						heroHit = 10;
						rewardGold = 25;
						rewardPoints = 200;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
					
					break;
					
					case 4: 
						System.out.println ("You hear a horse running nearby and look to see it's holding a spear " ); //air elemental
						enemyAbility = 'a';
						enemyHP = 60;   
						eType = "Centaur";
						aType = " Attacks";
						killText = "You Murder the ";
						deathFlavor = ". Its satchel holds a bar of gold. +30 gold!";
						minRange = 8; 
						maxRange = 8;
					 	eMinHit = 6; 
						eMaxHit = 12;
						minFlee = 6; 
						maxFlee = 9;
						heroHit = 10;
						rewardGold = 30;
						rewardPoints = 250;
						 CfSequence.battleSequence( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
							enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				}
			} 
			if (Var.getAreaCount() < 5 && Var.hp > 0 ) {
				Var.setAreaCount(1);
				System.out.println ( "Camp " + Var.getAreaCount() + ". Press Enter to continue " + nautical);
				KeyIn.nextLine ( );
			}
		}// end desert road	
	}

	public static void aPlainsRoad( String nautical) {
		

		
	}

	public static void volcanoRoad( String nautical) {
		

		
	}

}
