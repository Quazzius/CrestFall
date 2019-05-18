/*Jeff Flanegan
 * CSC 160 combo
 * Final Project
 * due 5/13/2019
 */



import java.util.Scanner;

public class CrestFall
{

	//CrerstFall is a text-based adventure game where you have to make choices
	//for which paths to take, what Items to buy/use and when to fight or flee.
	//there are  many enemies along the way which are specific to their environment.
	//there are 3 chapters that get increasingly more involved which are mostly milestone markers
	//for where we were in class and how much knowledge I had at the time.
	//you control a character and work your way through the areas, finding secrets,
	//deciding whether or not to investigate certain scenarios, slaying monsters,
	//fighting bosses, getting gold and points, and trying to eventually defeat Chaos in chapter 3.
	//you must make the correct decisions to make it to the volcano and even find Chaos itself.
	public static void main( String[ ] args )
	{
		Scanner input = new Scanner ( System.in );
		char playGame = 'y';
		while ( playGame == 'y' )
		{
			double start = 0.0; // Start Timer
			
			CfSetup.printGraphic(CfSetup.gameLogo()); //game Start logo
			CfSetup.initialize ( ); //initialize start variables
			
			//allow player to warp (mainly for testing)
			//names "ch2" and "ch3" take you the the respective chapters
			CfSetup.warp ( );  
			CfSetup.characterClass ( ); //player picks their class
			CfSetup.beginGame ( ); // introduction text

			// loop while hp > 0
			while ( Var.getHp ( ) > 0 )
			{
				start = System.currentTimeMillis ( );// start timer

				CfChapter.ch1 ( ); //chapter 1

				// Merchant Camp hub- Chapter 2
				if ( Var.getHp ( ) > 0 )
				{

					CfSetup.ch2Intro ( ); // chapter 2 intro
				}
				while ( Var.getChapter ( ) == 2 )
				{
					CfChapter.ch2 ( ); //chapter 2
				}
				// Chapter 3
				if ( Var.getHp ( ) > 0 )
				{

					CfSetup.ch3Intro ( ); // chapter 3 intro
				}
				while ( Var.getChapter ( ) == 3 )
				{
					CfChapter.ch3 ( ); //chapter 3
				}

			}
			//End Game
			//calculate play time, output game over screen
			double end = System.currentTimeMillis ( );
			double time = end - start;
			int minutes = (int) ( time / 1000 / 60 );
			int seconds = (int) ( time / 1000 % 60 );
			
			//if player takes more than 30 minutes, they receive a 100 point penalty for every minute after 30
			//this should help dieter gold and point farming
			if ( minutes > 30 )
			{
				int penalty = ( minutes - 30 ) * 100;
				Var.setPoints ( -penalty );
			}
			
			//player gets game over scenario if they defeated chaos
			//changes depending on calculated points
			if (Var.getChaosLife() < 1) {
				CfSetup.gameOverScenarios();
			}
			CfSetup.printGraphic(CfSetup.gameOver ( ));
			System.out.println ( "TIME: " + minutes + " min " + seconds + " sec" );
			
			//output penalty if there is one
			if ( minutes > 30 )
			{
				int penalty = ( minutes - 30 ) * 100;
				System.out.println ( "Time Penalty -" + penalty + " points" );
			}
			
			
			//output end game stats
			System.out.println ( "NAME: " + Var.getPlayer() );
			System.out.println ( "GOLD: " + Var.getGold());
			System.out.println ( "SCORE: " + Var.getPoints ( ) );
			System.out.println ( "\nPlay Again? y/n" );
			do // check character input
			{
				playGame = input.next ( ).toLowerCase ( ).charAt ( 0 );
				if ( playGame != 'y' && playGame != 'n' )
				{
					System.out.println ( "You must enter y or n. Play Again?" );
				}
			} while ( playGame != 'y' && playGame != 'n' );
		} // playGame
		input.close ( );
	}// Main
}// Class
