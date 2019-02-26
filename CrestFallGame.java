import java.util.Scanner;

public class CrestFallGame
{

	public static void main( String[ ] args )
	{
		//stats and items
		int gold = 0;
		int hp = 100;
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
		int ladyOfLake = 1;
		int sSword = 1;  //merchant items
		int lSword = 1;
		int lArmor = 1;
		int mBoots = 1;
		Scanner KeyIn = new Scanner(System.in);
		
		////Define Graphics "Engine" object
		Graphics g = new Graphics();
		System.out.println();
		g.printGraphic(g.gameLogo); //This is probably not how the class should be used but eh
		System.out.println();
		
		//user enter name
		System.out.println ( "Enter your name" );
		Scanner input = new Scanner(System.in);
		String player = input.nextLine( ); //-------------->>>>>>Put me to use, I'm so lonely
		
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
		while (hp >= 0)
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
				char swamp = 'E';
				char merchant = 'W';
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
									
									System.out.println ( "You killed a Bandit, and robbed his corpse of 8 gold! Nice..." );
									gold += 8;
									}
								}
							System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
							System.out.println ( "He gives you 10 gold for your services and company" );
							gold += 10;
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
								if (ruse > 5)
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
							System.out.println ( "You find a Garnet worth 12 gold! Killer!" );
							gold += 12;
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
							hp = 100;
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
						hp = 100;
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
						if (ruse > 5)
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
							System.out.println ( "You killed a Wraith! It dropped a garnet worth 12 gold, Nice..." );
							gold += 12;
						}
					System.out.println ( "You find a Garnet worth 12 gold! Killer!" );
					gold += 12;
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
			}}// end swamp road 2
			
			
			chapter = 2;
			}// end chapter 1
		
			
			while (chapter == 2)
			{
				//Merchant Camp
				System.out.println ( "You've reached the merchant camp." );
				System.out.println ( "HP: " + hp);
				System.out.println ( "Gold: " + gold );
				System.out.println ( "Press Enter to Continue" );
				KeyIn.nextLine();
				
				int merch = 0;  																															//Merchant
				System.out.println ( "There are a couple of Vendors hanging about..." );
				System.out.println ( "One of them turns to you and asks \"Are you in need?\" " );
				System.out.println ( "He then unrolls his mat to show you his various wares" );
				System.out.println ( "You hear him whisper what sounds like \"its a secret to everyone\" ");
				while (merch != 6)
				{
					System.out.println ( "What would you like?" );
					int sSwordCost = 10;
					System.out.println ( "1 - A reliable steel Short Sword. DMG: 3-6. (10 gold). In Stock: " + sSword );
					int lSwordCost = 15;
					System.out.println ( "2 - A Heavy Iron Long Sword (-1 dex). DMG 4-8 (15 gold) In Stock: " + lSword );
					int lArmorCost = 15;
					System.out.println ( "3 - Leather Armour. + 1 evade. (15 gold). InStock: " + lArmor);
					int mBootsCost = 20;
					System.out.println ( "4 - Mercurial Dancing Boots. + 1 evade (20 gold). In Stock " + mBoots);
					int hPotionCost = 5;
					System.out.println ( "5 - Magic EEL Sauce. Heal 50 HP (5 gold)" );
					System.out.println ( "6 - Exit Merchant Camp" );
					System.out.println ( "7 - View Stats" );
					System.out.println ( "You have " + gold + " gold");
				
					merch = input.nextInt();   //input decision
					switch (merch)
					{
						case 1:  //buy  short sword
							if (sSword > 0)
							{
								if (gold > sSwordCost)
								{
									System.out.println ( "The Short Sword is now yours! DMG: 3-6" );
									minDMG = 3;
									maxDMG = 6;
									gold -= sSwordCost;
									sSword--;
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
								if (gold > lSwordCost)
								{
									System.out.println ( "The Long Sword is now yours! DMG: 4-8. -1 dex" );
									minDMG = 4;
									maxDMG = 8;
									dex = 6;
									gold -= lSwordCost;
									lSword--;
									
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
								if (gold > lArmorCost)
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
							if (mBoots > 0)
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
							if (gold > hPotionCost)
							{
								hp += 50;
								gold -= hPotionCost;
								if (hp > 100)
								{
									hp = 100;
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
							System.out.println ( "Youve had your fill of shopping and decide to move on" );
							break;
						case 7:
							System.out.println ( "HP: " + hp);
							System.out.println ( "DMG: " + minDMG + " - " + maxDMG);
							System.out.println ( "Dex: " + dex);
							System.out.println ( "Evade: " + evade );
						
					}
				}  // end merchant camp
				
				System.out.println ( "There is a road sign at the far end of camp; It reads:" );
				System.out.println ( "Humble Mountain - West" );
				System.out.println ( "City of CrestFall - South" );
				System.out.println ( "SmellyFart Swamp - southEast" );
				System.out.println ( "Which way? W to mountain, S to city, E to swamp." );
				char direction = input.next ( ).toUpperCase ( ).charAt ( 0 );
				switch (direction)
				{
					case 'E':
						System.out.println ( "Lets take the muddy road to the smelly swamp then..." );
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
									if (ruse > 5)
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
												System.out.println ( "You miss! Lame!" );
											}
										}
										System.out.println ( "You killed a Wraith! And..." );
									}
								System.out.println ( "You find a Garnet worth 12 gold! Killer!" );
								gold += 12;
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
						
						case 2:  // you have reached the lake
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
								hp = 100;
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
							hp = 100;
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
							if (ruse > 5)
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
						System.out.println ( "You find a Garnet worth 12 gold! Killer!" );
						gold += 12;
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
					
					//South the the City
					case 'S':
					
					//West to the mountain
					case 'W':
						
				}
			} //end chapter 2
		}
		
		KeyIn.close();
		input.close();
		
	} //Game Over

}