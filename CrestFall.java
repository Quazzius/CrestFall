package myGame;
import java.util.Scanner;

public class CrestFall
{

	public static void main( String[ ] args )
	{
		Scanner input = new Scanner ( System.in );
		Scanner KeyIn = new Scanner ( System.in );

		char playGame = 'y';
		while ( playGame == 'y' )
		{
			// Direction
			char forest = 'y';

			double start = 0.0; // Start Timer
			
			CfSetup.printGraphic(CfSetup.gameLogo());
			CfSetup.initialize ( );
			CfSetup.warp ( );
			CfSetup.characterClass ( );
			CfSetup.beginGame ( forest );

			// loop while hp > 0
			while ( Var.getHp ( ) > 0 )
			{
				start = System.currentTimeMillis ( );// start timer

				CfChapter.ch1 ( );

				// Merchant Camp hub- Chapter 2
				if ( Var.getHp ( ) > 0 )
				{

					CfSetup.ch2Intro ( );
				}
				while ( Var.getChapter ( ) == 2 )
				{
					CfChapter.ch2 ( );
				}
				// Chapter 3
				if ( Var.getHp ( ) > 0 )
				{

					CfSetup.ch3Intro ( ); // chapter 3 intro
				}
				while ( Var.getChapter ( ) == 3 )
				{
					CfChapter.ch3 ( );
				}

			}
			//End Game
			//calculate play time, output game over screen
			double end = System.currentTimeMillis ( );
			double time = end - start;
			int minutes = (int) ( time / 1000 / 60 );
			int seconds = (int) ( time / 1000 % 60 );
			CfSetup.printGraphic(CfSetup.gameOver ( ));
			System.out.println ( "TIME: " + minutes + " min " + seconds + " sec" );
			
			//if player takes more than 30 minutes, they receive a 100 point penalty for every minute after 30
			//this should help dieter gold and point farming
			if ( minutes > 30 )
			{
				int penalty = ( minutes - 30 ) * 100;
				System.out.println ( "Time Penalty -" + penalty + " points" );
				Var.setPoints ( -penalty );
			}
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
		KeyIn.close ( );
	}// Main
}// Class
