

import java.util.Scanner;
@SuppressWarnings("resource")
public class CfRoads
{
	// minEnc and maxEnc are the boundaries of your chance for enemy encounters
	// encNumber is the number that is set for your chance of enemy encounter
	// range takes minEnc and maxEnc and gives a variable to be randomized
	// rand is the integer chosen my the randomizer
	// merch is the the players decision at the merchant hub
	public static final int minEnc = 1, maxEnc = 2, encNumber = 1, range = maxEnc - minEnc + 1;
	public static int rand, merch;

	//all roads use the same basic mechanics
	//the first couple are explained in detail
	public static void forest( )
	{
		// Journey through the forest
		Scanner KeyIn = new Scanner ( System.in );
		merch = 0;
		Var.setAreaCount ( 0 ); //initializes the amount of days the journey is to the next area
		System.out.println ( "You begin your journey heading South through the overgrown Elderwood forest" );
		while ( Var.getAreaCount ( ) < 3 ) //in this case the journey is 3 days long
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1 ); // random enemy
				switch ( enemy )
				{
					//in this case there are 3 different enemies that can be randomly chosen
					case 1:

						System.out.println ( Enemy.bear ( ).getText ( ) ); //type of enemy
						CfSequence.battleSequence ( Enemy.bear ( ) );  // battle sequence

						break;

					case 2:

						System.out.println ( Enemy.goblins ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.goblins ( ) );

						break;

					case 3:
						System.out.println ( Enemy.elf ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.elf ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 ) //character must be alive to continue
			{
				//increment area count and prompt the next day of the journey
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue South" );
				KeyIn.nextLine ( );
			}
		}
	}

	// fork in the road, choice to go to merchant or down swamp road early
	public static char roadFork( )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "You find the road after 3 days and shortly thereafter come to a Fork." );
		System.out
				.println ( "You're still alive with " + Var.getHp ( ) + " HP, and " + Var.getGold ( ) + " gold. Cool..." );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "You remember the Merchant Camp being to the West and looks well maintained." );
		System.out.println ( "The road East looks muddy." );
		System.out.println ( "E or W?" );

		// Merchant or Swamp?
		char roadFork;
		do // check character input
		{
			try {
				roadFork = input.next ( ).toUpperCase ( ).charAt ( 0 );
			}catch(Exception e) {
			}finally {
				roadFork = 'S';
			}
			if ( roadFork != 'E' && roadFork != 'W' )
			{
				System.out.println ( "You must enter E or W" );
			}
		} while ( roadFork != 'E' && roadFork != 'W' );

		return roadFork;
	}

	//west down merchant road to merchant camp
	public static void merchantRoad( )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "The Merchant Camp is 3 days from the fork" );
		System.out.println ( "The road is good for traveling but you have heard there are bandits along these roads" );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		merch = 0;
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.nBums ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.nBums ( ) );

						break;

					case 2:
						System.out.println ( "A man is busy mending the wheel for his cart" ); // cart man/ Bandit
						System.out.println ( "Do you want to help? y/n" );
						char help;
						
						//player gets the choice to engage in encounter
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't help
						{
							System.out.println ( "Screw that guy. You keep walking" );
						}
						else //help
						{
							//in this case there is a 2/5 chance that the encounter is an enemy
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse > 5 ) // enemy encounter
							{
								System.out.println ( Enemy.bandit ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.bandit ( ) );
							}
							else //no enemy 
							{
								System.out.println ( "You spend the rest of the day helping the Man fix his cart" );
								System.out.println ( "He gives you 10 gold for your services and company" );
								Var.setGold ( 10 );
							}

						}

						break;

					case 3:

						System.out.println ( Enemy.marauder ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.marauder ( ) );

				}

			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue West" );
				KeyIn.nextLine ( );
			}
		}
		if ( Var.getHp ( ) > 0 )
		{
			Var.setChapter ( 2 );
		}
	} // End Merchant Road
	
	//road to the lake
	public static void swampRoad1( )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Lets take the muddy road then..." );
		System.out.println ( "press Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "The road meanders to the SouthEast and the air cathces a chill" );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:

						System.out.println ( Enemy.wolves ( ).getText ( ) ); // wolves
						CfSequence.battleSequence ( Enemy.wolves ( ) );

						break;

					case 2:
						System.out.println ( "Something shiny catches your eye off trail" ); // jewel/ wraith
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 4 )
							{
								System.out.println ( Enemy.wraith ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.wraith ( ) );

							}
							else
							{
								System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
								Var.setGold ( 8 );

							}
						}
						break;

					case 3:
						System.out.println ( Enemy.mudMan ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.mudMan ( ) );

						break;

					case 4:
						System.out.println ( Enemy.leech ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.leech ( ) );

				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue East" );
				KeyIn.nextLine ( );
			}
		} // end swamp road
	}
	//road away from  the lake leading back to the merchant camp
	public static void swampRoad2( )
	{

		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "The only road out is northwest to the Merchant Camp" ); // other side of lake
		System.out.println ( "Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "You now head northWest along another muddy trail." );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:

						System.out.println ( Enemy.wolves ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.wolves ( ) );

						break;

					case 2:
						System.out.println ( "Something shiny catches your eye off trail" ); // jewel/ rotten wraith
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 4 )
							{
								System.out.println ( Enemy.rWraith ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.elf ( ) );
							}
							else
							{
								System.out.println ( "You find a Garnet worth 8 gold! Killer!" );
								Var.setGold ( 8 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.mudMan ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.mudMan ( ) );
						break;

					case 4:
						System.out.println ( Enemy.mLeech ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.mLeech ( ) );

				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue West" );
				KeyIn.nextLine ( );
			}
		} // end swamp road 2
		if(Var.getHp() > 0) {
			Var.setMerchCount ( 0 );
			Var.setChapter ( 2 );
		}
	}
	//road leading to  the city
	public static void cityRoad( )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 3 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.thief ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.thief ( ) );

						break;

					case 2:
						System.out.println ( "A terrified looking man runs up to you from the West" ); // distress/
																																	// Necromancer
						System.out.println (
								"He says a small dragon tried to carry off his carriage to the mountain but dropped it on the way" );
						System.out.println ( "He desperately needs help getting his shit back together" );
						System.out.println ( "Do you want to help? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse > 5 )
							{
								System.out.println ( Enemy.thrall ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.thrall ( ) );
							}
							else
							{
								System.out
										.println ( "You help the man gather what he needs and he is grateful for your help." );
								System.out.println ( "He hands you 10 gold with thanks. +10 gold!" );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.wyvren ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.wyvren ( ) );

				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue South" );
				KeyIn.nextLine ( );
			}
		}
	}
	// road leading to the mountain top
	public static void mountainRoad1( )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Its a Hard road to the mountain, but there's no turning back now..." );
		System.out.println ( "Press Enter to start your climb" );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:

						System.out.println ( Enemy.fSprite ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.fSprite ( ) );

						break;

					case 2:
						System.out.println ( "Tucked back in a dark alcove you can see the dull outline of a chest" ); // jewel/
																																						// mimic
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.mimic ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.mimic ( ) );
							}
							else
							{
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								Var.setGold ( 20 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.mTroll ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.mTroll ( ) );

						break;

					case 4:
						System.out.println ( Enemy.bat ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.bat ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue Upward" );
				KeyIn.nextLine ( );
			}
		} // end mountain road
	}
	//road leading away from the mountain top, to the merchant camp
	public static void mountainRoad2( )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:

						System.out.println ( Enemy.fSprite ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.fSprite ( ) );

						break;

					case 2:
						System.out.println ( "Tucked back in a dark alcove you can see the dull outline of a chest" ); // jewel/
																																						// mimic
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.mimic ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.mimic ( ) );
							}
							else
							{
								System.out.println ( "You find a Diamond worth 20 gold! Killer!" );
								Var.setGold ( 20 );
							}
						}
						break;

					case 3:

						System.out.println ( Enemy.mTroll ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.mTroll ( ) );

						break;

					case 4:

						System.out.println ( Enemy.eBat ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.eBat ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue Downward" );
				KeyIn.nextLine ( );
			}

		}
		if ( Var.getHp ( ) > 0 )
		{
			Var.setDirection ( 1 );
			Var.setMerchCount ( 0 );
		}
		else
		{
			Var.setDirection ( 0 );
		}
	}
	//road leading to  the shimmering valley area
	public static void sValleyRoad( String nautical )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:

						System.out.println ( Enemy.fern ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.fern ( ) );

						break;

					case 2:
						System.out.println (
								"You nearly trip over a mound of dirt hidden in the underbrush\n"
								+ "It looks like someone buried something recently" ); // chest/ zombie
						System.out.println ( "Do you want to dig it up? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "No way am i digging up whats been buried... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.zombie ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.zombie ( ) );
							}
							else
							{
								System.out.println ( "You find a chest full of coin! + 20 gold" );
								Var.setGold ( 20 );
							}
						}
						break;

					case 3:

						System.out.println ( Enemy.panther ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.panther ( ) );

						break;

					case 4:

						System.out.println ( Enemy.malboro ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.malboro ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end valley road
	}
	//road leading to  the white  marsh area
	public static void wMarshRoad( String nautical )
	{
		System.out.println ( "You can feel the humidity rise as your steps begin to sink further into the saturated ground" );
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.litchling ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.litchling ( ) );

						break;

					case 2:
						System.out.println ( "An Enormous tree stands alone in a small clearing.\n"
								+ "As you pass, you notice the branches swaying though there is no breeze." ); // tree
						System.out.println ( "Investigate the tree? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats one freaky tree bruh. Exit stage right." );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.mCrows ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.mCrows ( ) );
							}
							else
							{
								System.out.println ( "You can hear a creaky sigh let out from the tree as you approach.\n"
										+ "It gives itself a decent shake and drops 25 gold coins along with a few dead animals\n"
										+ "and a bottle of Snake Oil!" + " + 25 gold!" );
								Var.setGold ( 25 );
							}
							//player already has max potion amount
							//uses potion instead of storing it
							if ( Var.getHpPot ( ) > 0 )
							{
								System.out.println ( "Delicious! +40 HP" );
								Var.setHp ( 40 );
							}
							else
							{
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot ( 1 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.banshee ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.banshee ( ) );

						break;

					case 4:
						System.out.println ( Enemy.aElemental ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.aElemental ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end marsh road
	}
	//road leading to t he frozen desert area
	public static void fDesertRoad( String nautical )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.cScorpion ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.cScorpion ( ) );

						break;

					case 2:
						System.out.println ( "You see a frozen Oasis off in the distance" ); // tree
						System.out.println ( "Investigate the Oasis? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a mirage, lets not waste time." );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.phantom ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.phantom ( ) );
							}
							else
							{
								System.out.println ( "The Oasis looks like a paradise litterally frozen in time.\n "
										+ "You see something shining beneath the water and after punching through\n "
										+ "the ice, you find 20 gold and a bottle of snake oil!" );
								Var.setGold ( 25 );
							}
							if ( Var.getHpPot ( ) > 0 )
							{
								System.out.println ( "Delicious! +40 HP" );
								Var.setHp ( 40 );
							}
							else
							{
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot ( 1 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.wWisp ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.wWisp ( ) );

						break;

					case 4:
						System.out.println ( Enemy.taranTroll ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.taranTroll ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end desert road
	}
	// road leading to the sandstone cliffs area
	public static void sCliffsRoad( String nautical )
	{
		System.out.println ("The trail gradually unfreezes and then disappears.\nYou sense no one has been this way in a very long time...\n" );
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.ants ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.ants ( ) );

						break;

					case 2:
						System.out.println ( "Tucked back in a dark alcove you can see the dull outline of a chest" ); // jewel/
																																						// mimic
						System.out.println ( "Do you want to check it out? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats gotta be a trap... Keep walking" );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.mimic ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.mimic ( ) );
							}
							else
							{
								System.out.println ( "You find a bunch of coins worth 25 gold! Killer!" );
								Var.setGold ( 25 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.doppleganger ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.doppleganger ( ) );

						break;

					case 4:
						System.out.println ( Enemy.miniBears ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.miniBears ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end desert road
	}
	//road leading to  the ancient tomb entrance area
	public static void sForestRoad( String nautical )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 5 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:

						System.out.println ( Enemy.hWitch ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.hWitch ( ) );

						break;

					case 2:
						System.out.println ( "A small cave can be seen through the thick foliage..." ); // tree
						System.out.println ( "Investigate the cave? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "I'm not going anywhere near that forsaken dungeon..." );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.gBat ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.gBat ( ) );
							}
							else
							{
								System.out.println (
										"Thankfully the cave's occupants are away and amongst their droppings you find\n"
												+ "25 gold coins along with a few dead animals\nand a bottle of Snake Oil!" );
								Var.setGold ( 25 );
							}
							if ( Var.getHpPot ( ) > 0 )
							{
								System.out.println ( "\nDelicious! +40 HP" );
								Var.setHp ( 40 );
							}
							else
							{
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot ( 1 );
							}
						}
						break;

					case 3:

						System.out.println ( Enemy.mushMan ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.mushMan ( ) );

						break;

					case 4:
						System.out.println ( Enemy.centaur ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.centaur ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 5 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end desert road
	}
	//road leading to  the arid plains area
	public static void aPlainsRoad( String nautical )
	{
		
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.chimera ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.chimera ( ) );

						break;

					case 2:
						System.out.println ( "An Enormous tree stands alone in a small clearing.\n"
								+ "As you pass, you notice the branches swaying though there is no breeze." ); // tree
						System.out.println ( "Investigate the tree? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "Thats one freaky tree bruh. Exit stage right." );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.mCrows ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.mCrows ( ) );
							}
							else
							{
								System.out.println ( "You can hear a creaky sigh let out from the tree as you approach.\n"
										+ "It gives itself a decent shake and drops 25 gold coins along with a few dead animals\n"
										+ "and a bottle of Snake Oil!" + " + 25 gold!" );
								Var.setGold ( 25 );
							}
							if ( Var.getHpPot ( ) > 0 )
							{
								System.out.println ( "Delicious! +40 HP" );
								Var.setHp ( 40 );
							}
							else
							{
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot ( 1 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.sandMan ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.sandMan ( ) );

						break;

					case 4:
						System.out.println ( Enemy.stoneGolem ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.stoneGolem ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end aPlains road
	}
	//road leading to  the volcano  area
	public static void volcanoRoad( String nautical )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );
		System.out.println ( "Press Enter to head " + nautical );
		KeyIn.nextLine ( );
		Var.setAreaCount ( 0 );
		while ( Var.getAreaCount ( ) < 3 )
		{
			rand = (int) ( Math.random ( ) * range + minEnc ); // encounter chance
			if ( encNumber == rand )
			{
				int enemy = (int) ( Math.random ( ) * 4 + 1 ); // random enemy
				switch ( enemy )
				{
					case 1:
						System.out.println ( Enemy.chaosElemental ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.chaosElemental ( ) );

						break;

					case 2:
						System.out.println ( "You see a a large cave..." ); // tree
						System.out.println ( "Investigate the cave? y/n" );
						char help;
						do // check character input
						{
							help = input.next ( ).toLowerCase ( ).charAt ( 0 );
							if ( help != 'y' && help != 'n' )
							{
								System.out.println ( "You must enter y or n" );
							}
						} while ( help != 'y' && help != 'n' );

						if ( help == 'n' ) // Don't look
						{
							System.out.println ( "I'm not going anywhere near that forsaken dungeon..." );
						}
						else
						{
							int ruse = (int) ( Math.random ( ) * 10 );
							if ( ruse >= 5 )
							{
								System.out.println ( Enemy.gBat ( ).getText ( ) );
								CfSequence.battleSequence ( Enemy.gBat ( ) );
							}
							else
							{
								System.out.println (
										"Thankfully the cave's occupants are away and amongst their droppings you find\n"
												+ "25 gold coins along with a few dead animals\nand a bottle of Snake Oil!" );
								Var.setGold ( 25 );
							}
							if ( Var.getHpPot ( ) > 0 )
							{
								System.out.println ( "\nDelicious! +40 HP" );
								Var.setHp ( 40 );
							}
							else
							{
								System.out.println ( "You stowe the snake oil for later." );
								Var.setHpPot ( 1 );
							}
						}
						break;

					case 3:
						System.out.println ( Enemy.omegaTroll ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.omegaTroll ( ) );

						break;

					case 4:
						System.out.println ( Enemy.fBat ( ).getText ( ) );
						CfSequence.battleSequence ( Enemy.fBat ( ) );
				}
			}
			if ( Var.getAreaCount ( ) < 3 && Var.getHp ( ) > 0 )
			{
				Var.setAreaCount ( 1 );
				System.out.println ( "Camp " + Var.getAreaCount ( ) + ". Press Enter to continue " + nautical );
				KeyIn.nextLine ( );
			}
		} // end volcano road
	}

}
