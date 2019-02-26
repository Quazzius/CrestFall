import java.util.Scanner;

public class CrestFallNoMountain
{

	public static void main( String[ ] args )
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
		int attack = maxDMG - minDMG + 1;  //dmg range
		int hitDMG;
		int hitChance;
		int chapter;  //chapter of game
		int swampRoadCount;
		int cityRoadCount;
		int ladyOfLake = 1;
		int sSword = 1;  //merchant items
		int lSword = 1;
		int lArmor = 1;
		int mBoots = 1;
		int mDagger = 1;
		int mShield = 1;
		int bSword = 1;
		final int INNCOST = 20;
		int merchCount = 0;
		char direction = 'N';
		Scanner KeyIn = new Scanner(System.in);
		
		//user enter name
		System.out.println ( "Enter your name" );
		Scanner input = new Scanner(System.in);
		String player = input.nextLine( );
		
		//begin game
		System.out.println ( "Your home, the village of Sardina, was just burned to the ground by a forest fire." );
		System.out.println ( "Living in the middle of the forest has its advantages though the closest town is 10 days away on foot." );
		System.out.println ( "You know of a merchant to the SouthWest, but first you mush make your way through the forest to find the road." );
		System.out.println ( "Your only posessions are the clothes on your back and your splitting axe (2-5 DMG)." );
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
			System.out.println ( "You decided you would rather just lay down and burn like everything else, GAME OVER" );
			System.exit ( 0 );
		}
		
		//is alive
		while (hp > 0)
		{
			chapter = 1;
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
							int bear = (int) ( Math.random ( ) * 9 + 4 );
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
									System.out.println ( "You Dead" );
									System.exit(0);
								}
							}
							  //key in enter to continue
							System.out.println ( "press Enter to attack" );
							KeyIn.nextLine ( );
							
							//attack
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
						System.out.println ( "You killed a Bear! +5 gold for some reason" );
						gold += 5;
						break;
						
						case 2: System.out.println ("You hear little asshole Goblins creeping around"  );
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
									System.out.println ( "You Dead" );
									System.exit(0);
								}
							}
							  //key in enter to continue
							System.out.println ( "press Enter to attack" );
							KeyIn.nextLine ( );
							
							//attack
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
						System.out.println ( "You killed some Asshole Goblins! and found 3 gold!" );
						gold += 3;
						break;
						
						case 3: System.out.println ( "an Elf appears... to be very menacing!" );
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
									System.out.println ( "You Dead" );
									System.exit(0);
								}
							}
							  //key in enter to continue
							System.out.println ( "press Enter to attack" );
							KeyIn.nextLine ( );
							
							//attack
							hitDMG = (int) ( Math.random ( ) * attack + minDMG);
							hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
							if (dex >= hitChance)
							{
								System.out.println ( "You hit for " + hitDMG + " DMG" );
								elfHP -= hitDMG;
							}
							else
							{
								System.out.println ( "But you miss! Lame!" );
							}
						}
						System.out.println ( "You killed a crazy theiving Elf, and robbed his corpse of 6 gold! Awesome!" );
						gold += 6;
						}
					
					} 
					forestCount++;
					rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
					System.out.println ( "Camp " + forestCount + ". Press Enter to continue South" );
					KeyIn.nextLine ( );
				} // End Forest
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
										System.out.println ( "You Dead" );
										System.exit(0);
									}
								}
								  //key in enter to continue
								System.out.println ( "press Enter to attack" );
								KeyIn.nextLine ( );
								
								//attack
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
							System.out.println ( "You killed two Naked Bums! Their purses each held 2 gold" );
							gold += 4;
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
												System.out.println ( "You Dead" );
												System.exit(0);
											}
										}
										//key in enter to continue
										System.out.println ( "press Enter to attack" );
										KeyIn.nextLine ( );
									
										//attack
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
									System.out.println ( "You killed a Bandit, and robbed his corpse of 8 gold! Nice..." );
									gold += 8;
									
								}
								else
								{
									System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
									System.out.println ( "He gives you 10 gold for your services and company" );
									gold += 10;
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
										System.out.println ( "You Dead" );
										System.exit(0);
									}
								}
								  //key in enter to continue
								System.out.println ( "press Enter to attack" );
								KeyIn.nextLine ( );
								
								//attack
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
							System.out.println ( "You killed a Marauder and took his purse, but his horse ran away. + 7 gold" );
							gold += 7;
							}
						
						} 
						MerchRoadCount++;
						rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
						System.out.println ( "Camp " + MerchRoadCount + ". Press Enter to continue West" );
						KeyIn.nextLine ( );
					}
				chapter = 2;
				} //End Merchant Road
				
				else 																																// to the swamp
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
										System.out.println ( "You Dead" );
										System.exit(0);
									}
								}
								  //key in enter to continue
								System.out.println ( "press Enter to attack" );
								KeyIn.nextLine ( );
								
								//attack
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
							System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
							gold += 8;
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
										int wraith = (int) ( Math.random ( ) * 8 + 3 );
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
												System.out.println ( "You Dead" );
												System.exit(0);
											}
										}
										//key in enter to continue
										System.out.println ( "press Enter to attack" );
										KeyIn.nextLine ( );
									
										//attack
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
									System.out.println ( "You killed a Wraith! And..." );
								}
							System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
							gold += 8;
							}
							break;
							
							case 3: System.out.println ( "A Muddy Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
										System.out.println ( "You Dead" );
										System.exit(0);
									}
								}
								  //key in enter to continue
								System.out.println ( "press Enter to attack" );
								KeyIn.nextLine ( );
								
								//attack
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
							System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
							gold += 7;
							}
						
						} 
						swampRoadCount++;
						rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
						System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue East" );
						KeyIn.nextLine ( );
				}// end swamp road
																																					//the lake
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
								System.out.println ( "You Dead" );
								System.exit(0);
							}
						}
						  //key in enter to continue
						System.out.println ( "press Enter to attack" );
						KeyIn.nextLine ( );
						
						//attack
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
					System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
					gold += 8;
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
						}
					}
					else
					{
						System.out.println ( "Here is where you met the lady of the lake" );
						System.out.println ( "You can feel her spirit well up inside of you. Full HP!" );
						hp = hpMax;
					}
					break;
					
					case 3: System.out.println ( "A Muddy Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
								System.out.println ( "You Dead" );
								System.exit(0);
							}
						}
						  //key in enter to continue
						System.out.println ( "press Enter to attack" );
						KeyIn.nextLine ( );
						
						//attack
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
					System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
					gold += 7;
				}
				
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
								System.out.println ( "You Dead" );
								System.exit(0);
							}
						}
						  //key in enter to continue
						System.out.println ( "press Enter to attack" );
						KeyIn.nextLine ( );
						
						//attack
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
					System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
					gold += 8;
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
								int wraith = (int) ( Math.random ( ) * 8 + 3 );
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
										System.out.println ( "You Dead" );
										System.exit(0);
									}
								}
								//key in enter to continue
								System.out.println ( "press Enter to attack" );
								KeyIn.nextLine ( );
							
								//attack
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
							System.out.println ( "You killed a Wraith! It dropped a garnet worth 8 gold, Nice..." );
							gold += 8;
						}
						else 
						{
							System.out.println ( "You find a Garnet worth 12 gold! Killer!" );
							gold += 8;
						}
					}
					break;
					
					case 3: System.out.println ( "A Muddy Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
								System.out.println ( "You Dead" );
								System.exit(0);
							}
						}
						  //key in enter to continue
						System.out.println ( "press Enter to attack" );
						KeyIn.nextLine ( );
						
						//attack
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
					System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
					gold += 7;
					}
				
				} 
				swampRoadCount++;
				rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
				System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue West" );
				KeyIn.nextLine ( );
			}
			}// end swamp road 2
			
			
			chapter = 2;
			}// end chapter 1
		
			//Merchant Camp
			System.out.println ( "You've reached the merchant camp." );
			System.out.println ( "HP: " + hp);
			System.out.println ( "Gold: " + gold );
			System.out.println ( "Press Enter to Continue" );
			KeyIn.nextLine();
			while (chapter == 2)
			{
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
					int hPotionCost = 10;
					System.out.println ( "5 - Magic EEL Sauce. Heal 50 HP (10 gold)" );
					System.out.println ( "6 - View Stats" );
					System.out.println ( "7 - Exit Merchant Camp" );
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
								if (gold > mBootsCost)
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
							System.out.println ( "HP: " + hp);
							System.out.println ( "DMG: " + minDMG + " - " + maxDMG);
							System.out.println ( "Dex: " + dex);
							System.out.println ( "Evade: " + evade );
							break;
						
						case 7:
						System.out.println ( "There is a road sign at the far end of camp; It reads:" );
						System.out.println ( "Humble Mountain - West, Road closed due to Extreme Terror" );
						System.out.println ( "City of CrestFall - South" );
						System.out.println ( "SmellyFart Swamp - southEast" );
						System.out.println ( "Which way? S to City, E to Swamp. W to Mountain... Fuck it, why not?\n N to stay at Camp" );
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
														System.out.println ( "You Dead" );
														System.exit(0);
													}
												}
												  //key in enter to continue
												System.out.println ( "press Enter to attack" );
												KeyIn.nextLine ( );
												
												//attack
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
											System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
											gold += 8;
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
														int wraith = (int) ( Math.random ( ) * 8 + 3 );
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
																System.out.println ( "You Dead" );
																System.exit(0);
															}
														}
														//key in enter to continue
														System.out.println ( "press Enter to attack" );
														KeyIn.nextLine ( );
													
														//attack
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
													System.out.println ( "You killed a Wraith! It dropped a garnet worth 8 gold, Nice..." );
													gold += 8;
												}
												else 
												{
													System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
													gold += 8;
												}
											}
											break;
											
											case 3: System.out.println ( "A Muddy Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
														System.out.println ( "You Dead" );
														System.exit(0);
													}
												}
												  //key in enter to continue
												System.out.println ( "press Enter to attack" );
												KeyIn.nextLine ( );
												
												//attack
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
											System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
											gold += 7;
										}
									
									} 
									swampRoadCount++;
									rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
									System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue East" );
									KeyIn.nextLine ( );
							}// end swamp road
																																								//the lake
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
												System.out.println ( "You Dead" );
												System.exit(0);
											}
										}
										  //key in enter to continue
										System.out.println ( "press Enter to attack" );
										KeyIn.nextLine ( );
										
										//attack
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
									System.out.println ( "You killed the wolves and find their previous victim's bones nearby. +10 gold" );
									gold += 10;
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
												if (mDagger == 0)
												{
													minDMG++;
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
												System.out.println ( "You Dead" );
												System.exit(0);
											}
										}
										  //key in enter to continue
										System.out.println ( "press Enter to attack" );
										KeyIn.nextLine ( );
										
										//attack
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
									System.out.println ( "You killed that Piece of Shit! It has some coins stuck in it. + 8 gold" );
									gold += 8;
							}
							
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
											System.out.println ( "You Dead" );
											System.exit(0);
										}
									}
									  //key in enter to continue
									System.out.println ( "press Enter to attack" );
									KeyIn.nextLine ( );
									
									//attack
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
								System.out.println ( "You killed the wolves and find their previous victims bones nearby. +8 gold" );
								gold += 8;
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
													System.out.println ( "You Dead" );
													System.exit(0);
												}
											}
											//key in enter to continue
											System.out.println ( "press Enter to attack" );
											KeyIn.nextLine ( );
										
											//attack
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 10);  //chance to hit
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
										System.out.println ( "You killed a Rotten Wraith! It dropped a garnet worth 8 gold, Nice..." );
										gold += 8;
									}
									else 
									{
										System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
										gold += 8;
									}
								}
								break;
								
								case 3: System.out.println ( "A Muddy Mud Man grows rapidly in front of you like an Oozing pillar " );   //MudMan
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
											System.out.println ( "You Dead" );
											System.exit(0);
										}
									}
									  //key in enter to continue
									System.out.println ( "press Enter to attack" );
									KeyIn.nextLine ( );
									
									//attack
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
								System.out.println ( "You killed a MudMan! It has some coins stuck to it. + 7 gold" );
								gold += 7;
								}
							
							} 
							swampRoadCount++;
							rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
							System.out.println ( "Camp " + swampRoadCount + ". Press Enter to continue West" );
							KeyIn.nextLine ( );
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
											int thief = (int) ( Math.random ( ) * 7 + 4 );  //attack
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
													System.out.println ( "You Dead" );
													System.exit(0);
												}
											}
											  //key in enter to continue
											System.out.println ( "press Enter to attack" );
											KeyIn.nextLine ( );
											
											//attack
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
										System.out.println ( "You kill the thief. His purse was pretty light. + 5 gold" );
										gold += 5;
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
															System.out.println ( "You Dead" );
															System.exit(0);
														}
													}
													//key in enter to continue
													System.out.println ( "press Enter to attack" );
													KeyIn.nextLine ( );
												
													//attack
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
													if (dex >= hitChance)
													{
														System.out.println ( "You hit for " + hitDMG + " DMG" );
														thrallHP -= hitDMG;
													}
													else
													{
														System.out.println ( "But you miss! Lame!" );
													}
												}
												System.out.println ( "You killed the necromancers Thralls! But the Necromancer disappeared..." );
												System.out.println ( "Looking through his useless cart you find 12 gold! Nice!" );
												gold += 12;
											}
											else
											{
												System.out.println ( "You help the man gather what he needs and he is grateful for your help." );
												System.out.println ( "He hands you 10 gold with thanks. +10 gold!" );
												gold += 10;
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
													System.out.println ( "You Dead" );
													System.exit(0);
												}
											}
											  //key in enter to continue
											System.out.println ( "press Enter to attack" );
											KeyIn.nextLine ( );
											
											//attack
											hitDMG = (int) ( Math.random ( ) * attack + minDMG);
											hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
											if (dex >= hitChance)
											{
												System.out.println ( "You hit for " + hitDMG + " DMG" );
												wyvrenHP -= hitDMG;
											}
											else
											{
												System.out.println ( "But you miss! Lame!" );
											}
										}
										System.out.println ( "You killed a Wyvren! WOW! you cut open its belly and find 11 gold!" );
										gold += 11;
										}
									
									} 
									cityRoadCount++;
									rand = (int) ( Math.random ( ) * range + minEnc );  //encounter chance
									System.out.println ( "Camp " + cityRoadCount + ". Press Enter to continue South" );
									KeyIn.nextLine ( );
							}// end city road
																																								/////the city/////
							System.out.println ( "You find yourself standing at the Gates to the City" );
							System.out.println ( "HP = " + hp + " gold = " + gold);
							System.out.println ( "Press Enter to... Enter" );
							KeyIn.nextLine ( );
						
							int city = 0;
							int commonBoard;
							int armorerItems;
							char armorer;
							System.out.println ( "The city looks like it has seen better days..." );
							System.out.println ( "There are only a handful of people walking about and there is rising smoke from multiple dwellings." );
							System.out.println ( "There is a large map of the city with a message board, that could be helpful." );
							System.out.println ( "Press Enter" );
							KeyIn.nextLine();
							
							while (city != 6)
							{
								System.out.println ( "City Common Board" );
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
															System.out.println ( "A chill flows from your palm to the top of your head" );
															System.out.println ( "and it feels as though you pulled this sword from its own grave" );
															System.out.println ( "DMG = 6 - 12" );
															minDMG = 6;
															maxDMG = 12;
															gold -= bSwordCost;
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
															System.out.println ( "You Dead" );
															System.exit(0);
														}
													}
													  //key in enter to continue
													System.out.println ( "press Enter to attack" );
													KeyIn.nextLine ( );
													
													//attack
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
												System.out.println ( "You knocked out that Asshole and picked up the\n gold tooth you knocked out of his mouth. +10 gold" );
												gold += 10;
												break;
												
												case 2:  // you have reached the lake
												int victim = 1;
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
														int vandalHP = 40;
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
																	System.out.println ( "You Dead" );
																	System.exit(0);
																}
															}
															  //key in enter to continue
															System.out.println ( "press Enter to attack" );
															KeyIn.nextLine ( );
															
															//attack
															hitDMG = (int) ( Math.random ( ) * attack + minDMG);
															hitChance = (int) ( Math.random ( ) * 8);  //chance to hit
															if (dex >= hitChance)
															{
																System.out.println ( "You hit for " + hitDMG + " DMG" );
																vandalHP -= hitDMG;
															}
															else
															{
																System.out.println ( "But you miss! Lame!" );
															}
														}
														System.out.println ( "You killed a couple Greasy Vandals and saved the girl!" );
														System.out.println ( "She is shaken, but thanks you and gives you a kiss on the cheek" );
														System.out.println ( "It felt so wonderful you breifly closed your eyes\n When you opened them she was gone" );
														System.out.println ( "+25 Max HP" );
														hpMax += 25;
														victim--;
													}
												}
												else
												{
													System.out.println ( "You wander back to the spot where you saved that young lady" );
													System.out.println ( "Feeling Nostalgic?\n ...Oh a coin! + 1 gold" );
													gold += 1;
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
															System.out.println ( "You Dead" );
															System.exit(0);
														}
													}
													  //key in enter to continue
													System.out.println ( "press Enter to attack" );
													KeyIn.nextLine ( );
													
													//attack
													hitDMG = (int) ( Math.random ( ) * attack + minDMG);
													hitChance = (int) ( Math.random ( ) * 9);  //chance to hit
													if (dex >= hitChance)
													{
														System.out.println ( "You hit for " + hitDMG + " DMG" );
														ratHP -= hitDMG;
													}
													else
													{
														System.out.println ( "But you miss! Lame!" );
													}
												}
												System.out.println ( "You killed a Giant Sewer Rat! Gross!" );
												System.out.println ( "One of the locals witnessed your heroic deed and hands you 15 gold" );
												gold += 15;
											}
											
										}
										System.out.println ( "Keep walking about aimlessly? y/n" );
										do  //check character input
										{
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
													city = 0;
												}
											}
										}	
									}// end commonBoard Switch
								}//end city decision
							
		
							}//end merchant direction switch
							break;
							
						case 'W':
							System.out.println ( "Its a Hard road to the mountain, but there's no turning back now..." );
							System.out.println ( "Press Enter to start your climb" );
							KeyIn.next();
						}// end merchant option switch
					
				} //end direction N  
			}//end chapter 2
		}//end hp > 0
	} //Game Over

}