import java.util.Scanner;

public class CfSetup
{
	static Scanner KeyIn = new Scanner(System.in);
	static Scanner input = new Scanner(System.in);
	
	public static int[] gameArray() {
		int [] a = new int[38];
		a[0] = 0; //---gold
		a[1] = 100; //-hp
		a[2] = 100; //-hpMax
		a[3] = 2; //---minDMG
		a[4] = 5; //---maxDMG
		a[5] = 7; //---dex
		a[6] = 7; //---evade
		a[7] = 1; //---chapter
		a[8] = 1; //---ladyOfLake
		a[9] = 1; //---sSword
		a[10] = 1; //--lSword
		a[11] = 1; //--lArmor
		a[12] = 1; //--mBoots
		a[13] = 1; //--mDagger
		a[14] = 1; //--mShield
		a[15] = 1; //--bSword
		a[16] = 0; //--hpPot
		a[17] = 0; //--merchCount
		a[18] = 0; //--loser
		a[19] = 0; //--fighter
		a[20] = 1; //--victim
		a[21] = 0; //--points
		a[22] = 0; //--battleDec
		a[23] = 9; //--city
		a[24] = 1; //--chaosDemonLife
		a[25] = 'N'; //direction
		a[26] = 1; //--vRapier
		a[27] = 0; //--dynamite
		a[28] = 1; //--cKukri
		a[29] = 1; //--hordeLife
		a[30] = 1; //--gryphonLife
		a[31] = 1; //--pDagger
		a[32] = 1; //--slArmor
		a[33] = 1; //--sKatana
		a[34] = 1; //--lAxe
		a[35] = 1; //--litchKing
		a[36] = 1; //--vBangle
		a[37] = 1; //--chaos
		return a;	
		}
	public static String playerName() {
		
		System.out.println ( "Enter your name" ); //user enter name
		String player = input.nextLine( );
		return player;
	}
	
	public static int[] characterClass(int[] a) {
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
	public static int[] warp(int[] a) {
		//warp
		String player = CfSetup.playerName ( );
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
			a[11] = 0;
			a[15] = 0;
		}
		return a;
	}
	public static int[ ] beginGame( int[ ] a, char forest) {
		
		System.out.println ( "Your home, the village of Sardina, was just burned to the ground by a forest fire." );
		System.out.println ( "Living in the middle of the forest has its advantages though the closest town is 10 days away on foot." );
		System.out.println ( "You know of a merchant to the SouthWest, but first you mush make your way through the forest to find the road." );
		System.out.println ( "Your only posessions are the clothes on your back and your Splitting Axe (2-5 DMG)." );
		if(a[19] == 1) {
			System.out.println ( "You have a lifetime of fighting experince + 2 Max DMG\n But your large stature leaves you less nimble -1 dex" );
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
		
		return a;
	}
	
	public static void ch2Intro(int[]a) {
		
		System.out.println ( "You've reached the merchant camp and completed Chapter 1 of your journey." );
		System.out.println ( "HP: " + a[1]);
		System.out.println ( "Gold: " + a[0] );
		System.out.println ( "Press Enter to Continue" );
		KeyIn.nextLine();
	}

	public static void ch3Intro() {
		
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
	
	
}
