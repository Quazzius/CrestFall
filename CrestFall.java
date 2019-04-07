import java.util.Scanner;

public class CrestFall
{
	public static final int minEnc = 1, maxEnc = 2, encNumber = 1, range = maxEnc - minEnc + 1, INNCOST = 15;
	public static int rand, attack, hitDMG, hitChance, merch, hpPotCost = 5;;
	
	public static void main( String[ ] args )
	{
		Scanner input = new Scanner(System.in);
		Scanner KeyIn = new Scanner(System.in);
		
		char playGame = 'y';
		while (playGame == 'y')
		{
			// Direction
			char forest = 'y';
			
			double start = 0.0; //Timer
			int[] a =  CfSetup.gameArray();
			a = CfSetup.warp ( a );
			a = CfSetup.characterClass(a);
			a = CfSetup.beginGame (a, forest);
			
			//loop while hp > 0
			while (a[1] > 0)
			{
				start = System.currentTimeMillis ( );// start timer
				attack = a[4] - a[3] + 1;  //damage range
				
				a = CfChapter.ch1();
				
				//Merchant Camp hub- Chapter 2
				if (a[1] > 0) {
					
					CfSetup.ch2Intro(a);
				}
				while (a[7] == 2)
				{
					a = CfChapter.ch2 ( );
				}
				//Chapter 3
				if (a[1] > 0) {
					
					CfSetup.ch3Intro();  //chapter 3 intro
				}
				while (a[7] == 3) 
				{
					a = CfChapter.ch3 ( );
				}
			
			}
				
			double end = System.currentTimeMillis ( );
			double time = end - start;
			int minutes = (int)(time / 1000 / 60);
			int seconds = (int)(time / 1000 % 60);
			System.out.println ( "\nGAME OVER :(" );
			System.out.println ( "TIME: " + minutes + " min " + seconds + " sec");
			if (minutes > 15) 
			{
				int penalty = (minutes - 15) * 50;
				System.out.println ( "Time Penalty -" + penalty + " points" );
				a[21] -= penalty;
			}
			System.out.println ( "SCORE: " + a[21] );
			System.out.println ( "Play Again? y/n" );
			do  //check character input
			{
				playGame = input.next ( ).toLowerCase ( ).charAt ( 0 );
				if (playGame != 'y' && playGame != 'n')  
				{
					System.out.println ( "You must enter y or n. Play Again?" );
				}
			} while (playGame != 'y' && playGame != 'n'); 
		}//playGame
	}//Main
}//Class 




