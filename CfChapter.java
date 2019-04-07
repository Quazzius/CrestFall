import java.util.Scanner;

public class CfChapter
{
	public static final int INNCOST = 15;
	public static int merch = 0;
	static Scanner input = new Scanner (System.in);
	static Scanner KeyIn = new Scanner (System.in);
	
	public static int [] ch1(){
	   int[] a = CfSetup.gameArray ();
		while (a[7] == 1)      
		{
			//Forest
			a = CfRoads.forest(a);
			char roadFork = (char) CfRoads.roadFork (a);  //choose direction
			if (roadFork == 'W') //Merchant Road
			{  
				a = CfRoads.merchantRoad( a);
			}
			else if (roadFork == 'E')	// Swamp and swamp road
			{
				
				a = CfRoads.swampRoad1(a);
				if (a[1] > 0) {
					a = CfAreas.theLake(a);
				}
				if (a[1] > 0) {
					a = CfRoads.swampRoad2(a);
				}
			}
		}
	return a;
   }
	
	public static int[] ch2(){
		
		int [] a = CfChapter.ch1 ( );
		String player = CfSetup.playerName ( );
		
		a[25] = 'N';
		while (a[25] == 'N')
		{
			switch (a[25])
			{
				// East to the swamp
				case 'E':
					a = CfRoads.swampRoad1(a);
					if (a[1] > 0) {
						a = CfAreas.theLake(a);  //the Lake
					}
					if (a[1] > 0) {
						a = CfRoads.swampRoad2(a);
					}
					break;
					
					//South the the City
				case 'S':
					System.out.println ( "Going to a bustling city sure sounds better than all the savagery you've encountered thus far." );
					System.out.println ( "Press Enter to continue" );         
					KeyIn.nextLine ( );
					System.out.println ( "As you set out, you have a strange feeling about this \"City\"." );
					System.out.println ( "But, The road is flat and lined by trees that are filled with birds singing their songs...\n" );
					a = CfRoads.cityRoad(a);
					if (a[1] > 0) {
						a= CfAreas.theCity(a, INNCOST);/////the city/////
					}
					if (a[25] != 'N' && a[1] > 0) {
						System.out.println ( "As the gates to the city close behind you, you are filled with determination." );   
						System.out.println ( "Press Enter to continue" );         
						KeyIn.nextLine ( );
						a = CfRoads.cityRoad(a);
					}
					break;
					
					//West to the Mountain
				case 'W':
					a = CfRoads.mountainRoad1(a);
					if (a[1] > 0) {
						a = CfAreas.mountainTop(a, player);//the mountain
					}
					if (a[1] > 0) {
						a = CfRoads.mountainRoad2(a);
					}
					
			}	//End Merchant Fork Switch
		} // End Merchant Hub
		return a;
	}//end Chapter 2
	
	public static int[] ch3() {
		
		int[] a = CfChapter.ch2 ( );
		
		String nautical;
		a[1] = a[2]; //refill health
		a[25] = '1'; //initialize direction loop
		while (a[25] == '1') {
		if (a[1] > 0) {
			a = CfAreas.homeHub(a);
		}
		else {
			a[25] = '0';
			a[7] = 0;
		}
			switch (a[25]) {
				
				case 2:
					int eastWest = 0;
					System.out.println ( "The trees and ferns of Shimmering Valley all perpetually covered in dew\nby the mist that rolls in from the distant marsh." );
					nautical = "East";
					a = CfRoads.sValleyRoad(a, nautical);
					if(a[1] > 0) {
						a = CfAreas.sValley(a);
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
						a = CfRoads.sValleyRoad (a, nautical);
						a[25] = '1';
					}
					else if (eastWest == 2){
						nautical = "East";
						a = CfRoads.wMarshRoad (a, nautical);
						if (a[1] > 0) {
							a = CfAreas.whiteMarsh(a);
						}
						if (a[1] > 0) {
							nautical = "West";
							System.out.println ( "You find the trail and head back west but everything looks different.\n "
									+ "After what seems like a couple of hours, you realize that you are now\n "
									+ "walking amongst the split trails of the shimmering valley...\n" );
							a = CfRoads.sValleyRoad (a, nautical);
							a[25] = '1';
						}
					}
				break;
				
				case 3:
					eastWest = 0;
					nautical = "North";
					System.out.println ( "The Arid Plains are barren, sans short grass and a faint\n"
							+ "smell of sulpher wafting from the Volcano looming in the distant Northern horizon" );
					a = CfRoads.aPlainsRoad(a, nautical);
					if (a[1] > 0) {
						a = CfAreas.aridPlains(a);
					}
					if(a[1] > 0) {
						System.out.println ( "Head back home or onward to the Volcano?\n" );
						System.out.println ( "1 - Home\n2 - Volcano" );
						do {
							eastWest = input.nextInt ( );
							if (eastWest < 1 || eastWest > 2) {
								System.out.println ( "You must enter 1 to go Home or 2 for the Volcano" );
							}	
						}while (eastWest < 1 || eastWest > 2);
					}
					if (eastWest == 1) {
						nautical = "South";
						a = CfRoads.aPlainsRoad (a, nautical);
						a[25] = '1';
					}
					else if (eastWest == 2){
						nautical = "North";
						a = CfRoads.volcanoRoad (a, nautical);
						if (a[1] > 0) {
							a = CfAreas.volcano(a);
						}
						if (a[37] < 1) {
							System.out.println ( "You're abruptly transported home by the rift..." );
							a[25] = '1';
						}
						else if (a[1] > 0) {
							nautical = "South";
							System.out.println ( "You give up and head back home..." );
							a = CfRoads.fDesertRoad (a, nautical);
							if (a[1] > 0) {
								a = CfRoads.aPlainsRoad (a, nautical);
								a[25] = '1';
							}
						}
					}
					
				break;
					
				case 4:
					eastWest = 0;
					nautical = "South";
					System.out.println ( "The grass gets crunchy as you reach the southern tundra and the frozen dunes rise on the horizon.\n"
							+ "However, you sense no change in the air temperature..." );
					a = CfRoads.fDesertRoad(a, nautical);
					if (a[1] > 0) {
						a = CfAreas.frozenDesert(a);
					}
					if(a[1] > 0) {
						System.out.println ( "Head back home or onward to the Sandstone Cliffs?" );
						System.out.println ( "1 - Home\n2 - Sandstone Cliffs" );
						do {
							eastWest = input.nextInt ( );
							if (eastWest < 1 || eastWest > 2) {
								System.out.println ( "You must enter 1 to go Home or 2 for the Cliffs" );
							}	
						}while (eastWest < 1 || eastWest > 2);
					}
					if (eastWest == 1) {
						nautical = "North";
						a = CfRoads.fDesertRoad (a, nautical);
						a[25] = '1';
					}
					else if (eastWest == 2){
						nautical = "South";
						a = CfRoads.sCliffsRoad (a, nautical);
						if (a[1] > 0) {
							a = CfAreas.sandstoneCliffs(a);
						}
						if (a[1] > 0) {
							nautical = "North";
							System.out.println ( "You decide to open the Icy Locket and a seemingly endless amount of.\n"
									+ "sand pours from it like a waterfall. You find yourself back in the Frozen Desert...\n" );
							a = CfRoads.fDesertRoad (a, nautical);
							a[25] = '1';
						}
					}
				break;
					
				case 5:
					eastWest = 0;
					nautical = "West";
					System.out.println ( "You've heard the Sleeping Forest is difficult to navigate\nand as you enter the first stand of trees you already feel eyes upon you" );
					a = CfRoads.sForestRoad(a, nautical);
					if (a[1] > 0) {
						System.out.println ( "You come to a clearing with a gargantuan stone door and a small table with a merchant tending it." );
						a = CfAreas.tombEntrance(a);
					}
					if (a[1] > 0) {
						nautical = "East";
						System.out.println ( "The only way home is back though the forest..." );
						a = CfRoads.sForestRoad(a, nautical);
						a[25] = '1';
					}
			}
		}
		return a;
	}
}
