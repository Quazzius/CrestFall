
import java.util.Scanner;

public class CfSetup
{
	static Scanner KeyIn = new Scanner ( System.in );
	static Scanner input = new Scanner ( System.in );

	//initialize All Variables. described in Var class
	public static void initialize( )
	{
		Var.setGold ( 0 );
		Var.setHpMax ( 100 );
		Var.setHp ( 100 );
		Var.setMinDMG ( 2 );
		Var.setMaxDMG ( 5 );
		Var.setDex ( 7 );
		Var.setEvade ( 7 );
		Var.setChapter ( 1 );
		Var.setLadyOfLake ( 1 );
		Var.setsSword ( 1 );
		Var.setlSword ( 1 );
		Var.setlArmor ( 1 );
		Var.setmBoots ( 1 );
		Var.setmDagger ( 1 );
		Var.setmShield ( 1 );
		Var.setbSword ( 1 );
		Var.setHpPot ( 0 );
		Var.setMerchCount ( 0 );
		Var.setLoser ( 0 );
		Var.setFighter ( 0 );
		Var.setVictim ( 1 );
		Var.setPoints ( 0 );
		Var.setBattleDec ( 0 );
		Var.setCity ( 0 );
		Var.setChaosDemonLife ( 1 );
		Var.setvRapier ( 1 );
		Var.setDynamite ( 0 );
		Var.setcKukri ( 1 );
		Var.setDirection ( 0 );
		Var.setHordeLife ( 1 );
		Var.setGryphonLife ( 1 );
		Var.setpDagger ( 1 );
		Var.setSlArmor ( 1 );
		Var.setsKatana ( 1 );
		Var.setlAxe ( 1 );
		Var.setLitchKing ( 1 );
		Var.setvBangle ( 1 );
		Var.setChaosLife ( 1 );
		Var.setAreaCount ( 0 );
	}
	
	//the game logo and game over were made from a text to ASCII generator
	//found here: http://patorjk.com/software/taag/#p=display&f=Swamp%20Land&t=Type%20Something%20
	//then did a find-replace on the back slashes to double them up and adjusted text for the array
	public static String[] gameLogo () {
		
		String[] gameLogo = {
		 "	 ______   ______    ______   ______   _________   ______   ________   __       __          \n"
		+"	/_____/\\ /_____/\\  /_____/\\ /_____/\\ /________/\\ /_____/\\ /_______/\\ /_/\\     /_/\\         \n"
		+"	\\:::__\\/ \\:::_ \\ \\ \\::::_\\/_\\::::_\\/_\\__.::.__\\/ \\::::_\\/_\\::: _  \\ \\\\:\\ \\    \\:\\ \\        \n"
		+"	 \\:\\ \\  __\\:(_) ) )_\\:\\/___/\\\\:\\/___/\\  \\::\\ \\    \\:\\/___/\\\\::(_)  \\ \\\\:\\ \\    \\:\\ \\       \n"
		+"	  \\:\\ \\/_/\\\\: __ `\\ \\\\::___\\/_\\_::._\\:\\  \\::\\ \\    \\:::._\\/ \\:: __  \\ \\\\:\\ \\____\\:\\ \\____  \n"
		+"	   \\:\\_\\ \\ \\\\ \\ `\\ \\ \\\\:\\____/\\ /____\\:\\  \\::\\ \\    \\:\\ \\    \\:.\\ \\  \\ \\\\:\\/___/\\\\:\\/___/\\ \n"
		+"	    \\_____\\/ \\_\\/ \\_\\/ \\_____\\/ \\_____\\/   \\__\\/     \\_\\/     \\__\\/\\__\\/ \\_____\\/ \\_____\\/ \n"
		};
		return gameLogo;
	}
	
	public static String[] gameOver() {
		
			String[] gmeOver = {
			 "	 _______    ________   ___ __ __   ______       ______   __   __   ______   ______       \n"
			+"	/______/\\  /_______/\\ /__//_//_/\\ /_____/\\     /_____/\\ /_/\\ /_/\\ /_____/\\ /_____/\\      \n"
			+"	\\::::__\\/__\\::: _  \\ \\\\::\\| \\| \\ \\\\::::_\\/_    \\:::_ \\ \\\\:\\ \\\\ \\ \\\\::::_\\/_\\:::_ \\ \\     \n"
			+"	 \\:\\ /____/\\\\::(_)  \\ \\\\:.      \\ \\\\:\\/___/\\    \\:\\ \\ \\ \\\\:\\ \\\\ \\ \\\\:\\/___/\\\\:(_) ) )_   \n"
			+"	  \\:\\\\_  _\\/ \\:: __  \\ \\\\:.\\-/\\  \\ \\\\::___\\/_    \\:\\ \\ \\ \\\\:\\_/.:\\ \\\\::___\\/_\\: __ `\\ \\  \n"
			+"	   \\:\\_\\ \\ \\  \\:.\\ \\  \\ \\\\. \\  \\  \\ \\\\:\\____/\\    \\:\\_\\ \\ \\\\ ..::/ / \\:\\____/\\\\ \\ `\\ \\ \\ \n"
			+"	    \\_____\\/   \\__\\/\\__\\/ \\__\\/ \\__\\/ \\_____\\/     \\_____\\/ \\___/_(   \\_____\\/ \\_\\/ \\_\\/ \n"
			};
			return gmeOver;
		}
	//print graphic arrays shown above
	public static void printGraphic(String[] outputArray) {
		for(int i = 0; i < outputArray.length; i++) {
			System.out.println(outputArray[i]);
		}
	}
	// user enter name
	public static String playerName( )
	{
		
		System.out.println ( "Enter your name" ); 
		String player = input.nextLine ( );
		Var.setPlayer ( player );
		return player;
	}
	//choose character class
	public static void characterClass( )
	{
		System.out.println ( "Pick your class type" ); 
		System.out.println (
				"1. Hunter (Normal Game)\n2. Fighter (Braun mode) -1 dex, +2 Max DMG\n"
				+ "3. Loser (Hard Mode) -1 dex, -1 evade, -1 Max DMG, +10 Max HP" );
		int playerType = input.nextInt ( );
		if ( playerType == 2 ) //fighter class
		{
			Var.setFighter ( 1 ); //initialize fighter class
			Var.setDex ( -1 ); //fighter gets -1 to  dexterity
			Var.setMaxDMG ( 2 ); //fighter gets +2 to max damage
		}
		if ( playerType == 3 ) //loser class
		{
			Var.setLoser ( 1 ); // initialize loser class
			Var.setDex ( -1 ); //loser class gets - 1 to dexterity
			Var.setEvade ( -1 ); // -1 to  evade
			Var.setMaxDMG ( -1 ); // -1 to max damage
			Var.setHpMax ( 10 ); // +10 to max hp
		}

	}
	// warp if user enters "ch2" or "ch3"
	public static void warp( )
	{
		String player = CfSetup.playerName ( );
		if ( player.equals ( "ch2" ) ) // chapter 2, get 150 gold for testing purposes
		{
			Var.setChapter ( 2 );
			Var.setGold ( 150 );
		}
		if ( player.equals ( "ch3" ) ) // chapter 3, get updated stats for chapter level and 200 gold for testing
		{
			Var.setChapter ( 3 );
			Var.setMinDMG ( 7 );
			Var.setMaxDMG ( 12 );
			Var.setDex ( 1 ); // +1
			Var.setEvade ( 1 ); // +1
			Var.setHpMax ( 50 ); // +50 to max hp
			Var.setHp (50); // full health
			Var.setGold ( 200 );
			//items "acquired" from chapter 2
			Var.setlArmor ( 0 );
			Var.setbSword ( 0 );
			Var.setmDagger ( -1 );
		}
	}
	//beginning of story text and first decision (to play the game)
	public static void beginGame( )
	{
		char forest;
		System.out.println ( "Your home, the village of Sardina, was just burned to the ground by a ball of fire that fell from the sky." );
		System.out.println (
				"Living in the middle of the forest has its advantages, though the closest town is 10 days away on foot." );
		System.out.println (
				"You know of a merchant to the SouthWest, but first you mush make your way through the forest to find the road." );
		System.out.println ( "Your only posessions are the clothes on your back and your Splitting Axe (2-5 DMG)." );
		if ( Var.getFighter ( ) == 1 ) //fighter class
		{
			System.out.println (
					"You have a lifetime of fighting experince + 2 Max DMG\n But your large stature leaves you less nimble -1 dex" );
		}
		if ( Var.getLoser ( ) == 1 ) // loser class
		{
			System.out.println (
					"You're a loser so you kind of suck at everything -1 dex, -1 evade, -1 Max DMG\n"
					+ "But a lifetime of being picked on gives you more resilience + 10 Max HP" );
		}
		System.out.println ( "The only choice you have is to head South, continue? y/n" );
		do // check character input
		{
			forest = input.next ( ).toLowerCase ( ).charAt ( 0 );
			if ( forest != 'y' && forest != 'n' )
			{
				System.out.println ( "You must enter y or n, continue?" );
			}
		} while ( forest != 'y' && forest != 'n' );

		//pre-game play decision
		if ( forest == 'n' )
		{
			System.out.println ( "You decided you would rather just lay down and burn like everything else." );
			Var.setHp ( -200 );
		}

	}
	//introduction to city road 
	public static void cityIntro() {
		System.out.println (
				"Going to a bustling city sure sounds better than all the savagery you've encountered thus far." );
		System.out.println ( "Press Enter to continue" );
		KeyIn.nextLine ( );
		System.out.println ( "As you set out, you have a strange feeling about this \"City\"." );
		System.out.println (
				"Althhough, The road is flat and lined by trees that are filled with birds singing their peaceful songs...\n" );
	}
	//introduction to chapter 2
	public static void ch2Intro( )
	{

		System.out.println ( "You've reached the merchant camp and completed Chapter 1 of your journey." );
		System.out.println ( "HP: " + Var.getHp ( ) );
		System.out.println ( "Gold: " + Var.getGold ( ) );
		System.out.println ( "Press Enter to Continue" );
		KeyIn.nextLine ( );
	}
	//introduction to chapter 3
	public static void ch3Intro( )
	{

		System.out.println ( "You've completed Chapter 2!" );
		System.out.println ( "Press Enter to skip 8 years" );
		KeyIn.nextLine ( );
		System.out.println ( "You are immediately snapped out of your memory\nby a knock on front your door." );
		System.out.println (
				"Opening the door reveals the distantly familiar\nface of the carriage driver that had brought you to this village." );
		System.out.println ( "You have not seen him since the day you stepped off his carriage\nPress Enter" );
		KeyIn.nextLine ( );
		System.out.println (
				"\"Your abilities are needed again\" he says, \nand continues \"You had slain an agent of Chaos," );
		System.out.println (
				"and though you sought retribution and have found peace again,\nThere are even more horrors of the world driving others, like yourself,\nfrom their homes and into an unforgiving world." );
		System.out.println ( "You are bound to this duty, just as the Chaos Orb is bound to you.\"\nPress Enter" );
		KeyIn.nextLine ( );
		System.out
				.println ( "Before you can say anything he disappears, and a familiar scenario arouses your memory again" );
		System.out.println ( "Where \"he\" stood now lays the very same equipment you had 8 years ago..." );
		System.out.println (
				"After donning your armor and sheathing your weapons\nyou step out into the world willingly\nPress Enter" );
		KeyIn.nextLine ( );
		System.out
				.println ( "Your small village has no name as it is merely called \"Home\" to the village's 6 residents."
						+ "\nYou greet your friend Gil, the merchant, and ask to see his stock" );
	}
	//the type of game over scene you get is dependent on if you 
	//defeated chaos and the amount of points you received 
	public static void gameOverScenarios() {
		
		//player returns home if less than 5000 points and killed chaos
		if (Var.getPoints() < 7500 && Var.getChaosLife() < 1) {
			System.out.println ( "You emerge from the rift and are home in Home. You Open the door to your\n"
					+ "house and collapse in your bed. Tales of your journey are spead lightly through legends\n"
					+ "and your story becomes a myth told by few...\n\n");
		}
		//Player returns to alternate reality where Sardina is intact
		//if they have more than 5000 points and killed chaos.
		else if (Var.getPoints() >= 7500 && Var.getChaosLife() < 1) {
			System.out.println ( "You emerge from the rift into a familiar place... Sardina.\n"
					+ "Amazed by your surroundings, your eyes well up with tears.\n"
					+ "Your freinds walk up to you and are concerned that you look confused\n"
					+ "and strangely emotional..." + Var.getPlayer ( ) + ", where have you been?! the bakery\n "
					+ "caught fire last night! We put it out but we could have used your help.\n"
					+ "You shake your head and sit down where you are, overwhelmed with joy...\n\n");
		}
		
	}

}
