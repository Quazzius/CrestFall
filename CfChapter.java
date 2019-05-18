

import java.util.Scanner;


//this is the layout of the game by chapter.
//It arranges the roads and areas while checking if the 
//player is still alive to reach the next area
public class CfChapter
{
	public static int merch = 0, direction = 0;
	public static String player;
	static Scanner input = new Scanner ( System.in );
	static Scanner KeyIn = new Scanner ( System.in );

	public static void ch1( )
	{

		while ( Var.getChapter ( ) == 1 )
		{
			// chapter 1
			// Forest
			CfRoads.forest ( );
			char roadFork = (char) CfRoads.roadFork ( ); // choose direction
			if ( roadFork == 'W' ) // Merchant Road
			{
				CfRoads.merchantRoad ( );
			}
			else if ( roadFork == 'E' )
			{

				CfRoads.swampRoad1 ( ); // swamp road
				if ( Var.getHp ( ) > 0 )
				{
					CfAreas.theLake ( ); // lake
				}
				if ( Var.getHp ( ) > 0 )
				{
					CfRoads.swampRoad2 ( );// swamp road 2
				}
			}
		}
	}

	// chapter 2
	public static void ch2( )
	{
		// direction 1 returns to player to merchant camp
		// merchant camp is the central hub for chapter 2
		Var.setDirection ( 1 );
		while ( Var.getDirection ( ) == 1 )
		{
			CfAreas.merchantHub ( 5 ); // merchant

			// player leaves merchant camp
			switch ( Var.getDirection ( ) )
			{

				// East to the swamp (lake)
				case 3:
					CfRoads.swampRoad1 ( );
					if ( Var.getHp ( ) > 0 )
					{
						CfAreas.theLake ( ); // the Lake
					}
					if ( Var.getHp ( ) > 0 )
					{
						CfRoads.swampRoad2 ( );
					}
					break;

				// South the the City
				case 2:

					CfSetup.cityIntro ( ); // text intro to go to the city

					CfRoads.cityRoad ( ); // road to Crestfall
					if ( Var.getHp ( ) > 0 )
					{
						CfAreas.theCity ( );///// the city of Crestfall/////
					}
					// direction 1 takes carriage back to merchant
					// direction 2 walks back to merchant
					// direction 3 goes to chapter 3
					if ( Var.getDirection ( ) == 2 && Var.getHp ( ) > 0 )
					{
						// walk back to the merchant camp
						System.out
								.println ( "As the gates to the city close behind you, you are filled with determination." );
						System.out.println ( "Press Enter to continue" );
						KeyIn.nextLine ( );
						CfRoads.cityRoad ( );
					}
					break;

				// West to the Mountain
				case 4:
					CfRoads.mountainRoad1 ( );
					if ( Var.getHp ( ) > 0 )
					{
						CfAreas.mountainTop ( );// the mountain and chaos demon boss battle
					}
					if ( Var.getHp ( ) > 0 )
					{
						CfRoads.mountainRoad2 ( );
					}

			} // End Merchant Fork Switch
		} // End Merchant Hub
	}// end Chapter 2

	// chapter 3. must defeat chaos demon and take carriage from city
	public static void ch3( )
	{
		while ( Var.getChapter ( ) == 3 )
		{

			String nautical; // passes nautical direction to roads

			// initialize direction loop, home hub is central to chapter 3
			Var.setDirection ( 1 );
			while ( Var.getDirection ( ) == 1 )
			{
				if ( Var.getHp ( ) > 0 )
				{
					Var.setHp ( Var.getHpMax ( ) ); // refill health
					CfAreas.homeHub ( ); // home hub
				}
				// hp is > 1, player is dead
				else
				{
					Var.setDirection ( -9 );
					Var.setChapter ( -9 );
				}
				switch ( Var.getDirection ( ) )
				{
					// go to shimmering valley and white marsh
					case 2:
						int eastWest = 0;
						System.out.println ( "The trees and ferns of Shimmering Valley all perpetually covered in dew\n"
								+ "by the mist that rolls in from the distant marsh." );
						nautical = "East";
						CfRoads.sValleyRoad ( nautical ); // shimmering valley road
						if ( Var.getHp ( ) > 0 )
						{
							CfAreas.sValley ( ); // shimmering valley area
						}
						if ( Var.getHp ( ) > 0 )
						{
							System.out.println ( "Head back home or onward to the White Marsh?" );
							System.out.println ( "1 - Home\n2 - Marsh" );
							do
							{
								eastWest = input.nextInt ( );
								if ( eastWest < 1 || eastWest > 2 )
								{
									System.out.println ( "You must enter 1 to go Home or 2 for the Marsh" );
								}
							} while ( eastWest < 1 || eastWest > 2 );
						}
						// player heads home
						if ( eastWest == 1 )
						{
							nautical = "West";
							CfRoads.sValleyRoad ( nautical );
							Var.setDirection ( 1 );
						}
						// player goes to white marsh
						else if ( eastWest == 2 )
						{
							nautical = "East";
							CfRoads.wMarshRoad ( nautical ); // white marsh road
							if ( Var.getHp ( ) > 0 )
							{
								CfAreas.whiteMarsh ( ); // white marsh area and necro horde boss fight
							}
							// when player leaves the marsh, they only take shimmering valley road back home
							if ( Var.getHp ( ) > 0 )
							{
								nautical = "West";
								System.out.println ( "You find the trail and head back west but everything looks different.\n "
										+ "After what seems like a couple of hours, you realize that you are now\n "
										+ "walking amongst the split trails of the shimmering valley...\n" );
								CfRoads.sValleyRoad ( nautical );
								Var.setDirection ( 1 );
							}
						}
						break;

					// go to the Arid Plains and volcano
					case 3:
						eastWest = 0;
						nautical = "North";
						System.out.println ( "The Arid Plains are barren, sans short grass and a faint\n"
								+ "smell of sulpher wafting from the Volcano that looms on the distant Northern horizon" );
						CfRoads.aPlainsRoad ( nautical ); // arid plains road
						if ( Var.getHp ( ) > 0 )
						{
							CfAreas.aridPlains ( ); // arid plains area
						}
						if ( Var.getHp ( ) > 0 )
						{
							System.out.println ( "Head back home or onward to the Volcano?\n" );
							System.out.println ( "1 - Home\n2 - Volcano" );
							do
							{
								eastWest = input.nextInt ( );
								if ( eastWest < 1 || eastWest > 2 )
								{
									System.out.println ( "You must enter 1 to go Home or 2 for the Volcano" );
								}
							} while ( eastWest < 1 || eastWest > 2 );
						}
						// player heads back home
						if ( eastWest == 1 )
						{
							nautical = "South";
							CfRoads.aPlainsRoad ( nautical );
							Var.setDirection ( 1 );
						}
						// player continues to the volcano
						else if ( eastWest == 2 )
						{
							nautical = "North";
							CfRoads.volcanoRoad ( nautical ); // volcano road
							if ( Var.getHp ( ) > 0 )
							{
								CfAreas.volcano ( ); // volcano area and final boss fight, chaos
							}
							// if player defeats chaos, the player is transported to the game over scenario.
							if ( Var.getChaosLife ( ) < 1 )
							{
								System.out.println ( "You're abruptly transported home by the rift..." );
								Var.setDirection ( 9 ); // breaks home hub loop
								Var.setChapter ( 9 ); // breaks chapter loop
								Var.setHp ( -300 ); //breaks hp loop
							}
							// player either ran away or couldn't find the chaos demon and gave up because they didn't
							// have the spectacles found in the tomb
							else if ( Var.getHp ( ) > 0 )
							{
								// player must take both roads directly home
								nautical = "South";
								System.out.println ( "You give up and head back home..." );
								CfRoads.volcanoRoad ( nautical );
								if ( Var.getHp ( ) > 0 )
								{
									CfRoads.aPlainsRoad ( nautical );
									Var.setDirection ( 1 );
								}
							}
						}

						break;

					// go to frozen desert and sandstone cliffs
					case 4:
						eastWest = 0;
						nautical = "South";
						System.out.println (
								"The grass gets crunchy as you reach the southern tundra and the frozen dunes rise on the horizon.\n"
										+ "However, you sense no change in the air temperature..." );
						CfRoads.fDesertRoad ( nautical ); // frozen desert road
						if ( Var.getHp ( ) > 0 )
						{
							CfAreas.frozenDesert ( );// frozen desert area
						}
						if ( Var.getHp ( ) > 0 )
						{
							System.out.println ( "Head back home or onward to the Sandstone Cliffs?" );
							System.out.println ( "1 - Home\n2 - Sandstone Cliffs" );
							do
							{
								eastWest = input.nextInt ( );
								if ( eastWest < 1 || eastWest > 2 )
								{
									System.out.println ( "You must enter 1 to go Home or 2 for the Cliffs" );
								}
							} while ( eastWest < 1 || eastWest > 2 );
						}
						// player heads back home
						if ( eastWest == 1 )
						{
							nautical = "North";
							CfRoads.fDesertRoad ( nautical );
							Var.setDirection ( 1 );
						}
						// player continues to sandstone cliffs
						else if ( eastWest == 2 )
						{
							nautical = "South";
							CfRoads.sCliffsRoad ( nautical ); // cliffs road
							if ( Var.getHp ( ) > 0 )
							{
								CfAreas.sandstoneCliffs ( );// sandstone cliffs area and gryphon boss fight
							}
							// when player leaves and gryphon is dead, they only take the frozen desert road back
							if ( Var.getHp ( ) > 0 && Var.getGryphonLife ( ) < 1 )
							{
								nautical = "North";
								System.out.println ( "You decide to open the Icy Locket and a seemingly endless amount of\n"
										+ "sand pours from it like a waterfall. You find yourself back in the Frozen Desert...\n" );
								CfRoads.fDesertRoad ( nautical );
								Var.setDirection ( 1 );
							}
							// if player retreats from the sandstone cliffs before defeating the gryphon
							else if ( Var.getHp ( ) > 0 )
							{
								System.out.println ( "You decide to retreat" );
								nautical = "North";
								CfRoads.sCliffsRoad ( nautical ); // back along cliffs road
								CfRoads.fDesertRoad ( nautical );// back along frozen desert road
								Var.setDirection ( 1 );
							}
						}
						break;

					// go to sleeping forest and ancient tomb
					case 5:
						eastWest = 0;
						nautical = "West";
						System.out.println ( "You've heard the Sleeping Forest is difficult to navigate\n"
								+ "and as you enter the first stand of trees you already feel eyes upon you" );
						CfRoads.sForestRoad ( nautical ); // sleeping forest road
						if ( Var.getHp ( ) > 0 )
						{
							System.out.println (
									"You come to a clearing with a gargantuan stone door and a small table with a merchant tending it." );
							CfAreas.tombEntrance ( ); // outside the doors to the ancient tomb
						}
						// player must head back through the sleeping forest to get back home
						if ( Var.getHp ( ) > 0 )
						{
							nautical = "East";
							System.out.println ( "The only way home is back though the forest..." );
							CfRoads.sForestRoad ( nautical );
							Var.setDirection ( 1 );
						}
				}// direction choice
			} // back to hub
		} // chapter 3
	}// end chapter 3
}// end chapter class
