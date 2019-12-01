

import java.util.Scanner;

@SuppressWarnings("resource")
public class CfSequence
{
	// merch is the the players decision at the merchant hub and leaves merchant loop if player dies
	// city is a count that gives text based on how many times the player has been to the city,
	// it also is used to end city loop if inside the city on death
	public static int rand, attack, hitDMG, hitChance, merch, city = 0;

	
	//this is the battle sequence, where the enemy attacks
	//and you make decisions to attack, flee, heal, or use explosives
	//the chances to  hit and status effects are randomized within enemy specific parameters
	public static void battleSequence( Enemy enemyType )
	{

		// calls overloaded Enemy constructor to get enemy data
		Enemy enemy = new Enemy ( enemyType );

		Scanner input = new Scanner ( System.in );
		int poisonCount = 0; // initialize hero poisoned counter
		int ePoisonCount = 0; // initialize enemy poisoned counter
		int stunCount = 0; // initialize hero stun
		int eStunCount = 0; // init enemy stun count
		int battleDec = 0; // init player decision
		attack = Var.getMaxDMG ( ) - Var.getMinDMG ( ) + 1; //get attack range
		if ( Var.getvRapier ( ) < 1 || Var.getsKatana ( ) < 1 )//weapons with vamp ability
		{
			// lose max hp to Vamp
			Var.setHpMax ( -10 );
		}
		while ( enemy.getEnemyHP ( ) > 0 ) // fight sequence
		{
			eStunCount--;
			if ( eStunCount < 1 ) //if enemy is stunned, they cannot attack this turn
			{
				int damage = (int) ( Math.random ( ) * enemy.getMaxRange ( ) + enemy.getMinRange ( ) ); // enemy attack
																																		// range
				System.out.println ( enemy.geteType ( ) + enemy.getaType ( ) + " for " + damage + " damage." );
				hitChance = (int) ( Math.random ( ) * enemy.geteMaxHit ( ) + enemy.geteMinHit ( ) ); // enemy hit chance
				if ( Var.getEvade ( ) > hitChance ) // if evade is greater than hit, enemy misses
				{
					System.out.println ( "But Misses!" );
				}
				else
				{
					Var.setHp ( -damage ); // player attacked
					System.out.println ( "-" + damage + " HP. " + "HP is " + Var.getHp ( ) + "/" + Var.getHpMax ( ) );

					// if enemy ability type "v" vampirism
					if ( enemy.getEnemyAbility ( ) == 'v' )
					{
						double vamp = damage * 0.20; // heals 20% damage given to player on hit
						int iVamp = (int) vamp; // change from double to int
						if ( iVamp > 0 )
						{
							// output if necessary
							System.out.println ( enemy.geteType ( ) + " heals " + iVamp + " HP" );
							enemy.setEnemyHP ( iVamp );
						}
					}
					//if enemy ability type 'p'poison
					else if ( enemy.getEnemyAbility ( ) == 'p' && poisonCount < 1 )
					{
						int poison = (int) ( Math.random ( ) * 3 + 1 ); // 1 in 3 chance of being poisoned on hit
						if ( poison == 3 )
						{
							System.out.println ( "You're Poisoned!" );
							poisonCount = 3; //poison lasts 3 turns
						}
					}
					else if ( enemy.getEnemyAbility ( ) == 's' && stunCount < 1 )
					{
						int stun = (int) ( Math.random ( ) * 8 + 1 ); //1 in 8 chance of being stunned on hit
						if ( stun == 5 )
						{
							System.out.println ( "You're Stunned! (1 turn)\n" );
							stunCount = 2; //stun lasts 1 turn, set to 2 since the stun count decrements at the end of the turn
						}
					}
					if ( Var.getHp ( ) < 1 ) // on death condition, reset variables to go to game over
					{
						Var.setChapter ( -4 ); //breaks chapter loop
						Var.setAreaCount ( 9 ); // if in area, breaks choice to continue loop
						enemy.setEnemyHP ( 0 ); // breaks battle sequence
						merch = 0; // if in chapter 2 breaks merchant hub loop
						city = 6; // if in citywalk inside the city, breaks loop to return to common board
						Var.setDirection ( -9 ); // breaks switch direction loop

					}
				}
			}
			if ( poisonCount > 0 ) //poison counter
			{
				poisonCount--;
				System.out.println ( "-2 HP (Poison), left: " + poisonCount );
				Var.setHp ( -2 ); // poison reduces health by 2 per round

			}
			// battle decision

			stunCount--;
			if ( Var.getHp ( ) > 0 && stunCount < 1 )
			{
				// chapters define item availability
				System.out.println ( "0 - Flee\n1 - Attack" );
				if ( Var.getChapter ( ) > 2 )
				{
					System.out.println ( "3 - Dynamite: " + Var.getDynamite ( ) );
				}
				if ( Var.getChapter ( ) > 1 )
				{
					System.out.println ( "5 - Health Potion: " + Var.getHpPot ( ) );
				}
				
				battleDec = input.nextInt ( ); 
				
				// players turn
				switch ( battleDec )
				{
					// flee
					case 0:
						// chance to flee based on enemy's speed
						hitChance = (int) ( Math.random ( ) * enemy.getMaxFlee ( ) + enemy.getMinFlee ( ) ); 
						if ( Var.getEvade ( ) > hitChance )
						{ // flee successful
							System.out.println ( "You run away! Coward!" );
							enemy.setEnemyHP ( 0 );
						}
						else
						{ // flee unsuccessful
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
						break;

					// attack
					case 1:
						hitDMG = (int) ( Math.random ( ) * attack + Var.getMinDMG ( ) ); // possible damage range
						hitChance = (int) ( Math.random ( ) * enemy.getHeroHit ( ) + 1 ); // chance to hit
						if ( Var.getDex ( ) >= hitChance ) // if dex is at least heroHit chance, hero hits
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							enemy.setEnemyHP ( -hitDMG );

							// has bangle, gives player Vamp, stacks with other abilities
							if ( Var.getvBangle ( ) == 0 )
							{
								System.out.println ( "HP + 1" );
								Var.setHp ( 1 );
							}

							// character ability Vamp
							if ( Var.getvRapier ( ) < 1 || Var.getsKatana ( ) < 1 )
							{
								System.out.println ( "HP + 1" );
								Var.setHp ( 1 );
							}
							// character ability poison
							else if ( Var.getcKukri ( ) == 0 && ePoisonCount < 1 ) //poison does not stack
							{
								int ePoison = (int) ( Math.random ( ) * 3 + 1 ); //1 in 3 chance to poison enemy on hit
								if ( ePoison == 3 )
								{
									System.out.println ( enemy.geteType ( ) + " Poisoned!" );
									ePoisonCount = 3;// lasts 3 turns
								}
							}
							// character ability stun
							else if ( Var.getlAxe ( ) == 0 )
							{
								int eStun = (int) ( Math.random ( ) * 7 + 1 ); //1 in 7 chance to stun enemy on hit
								if ( eStun == 3 )
								{
									System.out.println ( enemy.geteType ( ) + " Stunned!" );
									eStunCount = 2; //lasts 1 turn, set to 2 since it decrements -1 before enemy turn
								}
							}
						}
						//hero does not hit
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
						//enemy poison counter
						if ( ePoisonCount > 0 )
						{
							ePoisonCount--;
							System.out.println ( enemy.geteType ( ) + " -2 HP (Poison), Left: " + ePoisonCount );
							enemy.setEnemyHP ( -2 ); //enemy loses 2 hp per round when poisoned
							
						}
						break;

					// use dynamite
					case 3:
						if ( Var.getDynamite ( ) > 0 )
						{
							System.out.println ( "You light the wick and toss the dynamite at the " + enemy.geteType ( ) );
							System.out.println ( "dealing 30 damage! and deals you 5 damage." );
							enemy.setEnemyHP ( -30 );
							Var.setHp ( -5 );
							Var.setDynamite ( -1 );
						}
						else
						{
							System.out.println ( "Idiot! You have no explosives in your inventory!" );
						}
						break;

					// heal
					case 5:
						if ( Var.getHpPot ( ) > 0 )
						{
							if ( Var.getChapter ( ) > 2 ) //potion upgraded to snake oil in chapter 3
							{
								System.out.println ( "Delicious reptile secretions...\n +40 HP" );
								Var.setHpPot ( -1 ); // used potion
								Var.setPoints ( -40 ); // lose points for healing
								Var.setHp ( 40 ); // heal
							}
							else
							{
								System.out.println ( "That Sauce is Awesome!\n +25 HP" );
								Var.setHpPot ( -1 ); // used potion
								Var.setPoints ( -25 ); // lose points for healing
								Var.setHp ( 25 ); // heal
							}
						}
						else
						{
							System.out.println ( "Fool! You have no bottles in supply!" );
						}
				}
			}
		}
		// make sure hero did not die or flee for reward
		if ( Var.getHp ( ) > 0 && battleDec != 0 )
		{
			//output text related to killing the particular enemy and gain the gold and points associated
			System.out.println ( enemy.getKillText ( ) + enemy.geteType ( ) + enemy.getDeathFlavor ( ) );
			Var.setGold ( enemy.getRewardGold ( ) ); // gold
			Var.setPoints ( enemy.getRewardPoints ( ) ); // points
		}
		// return hp max to normal if player has vamp ability
		if ( Var.getvRapier ( ) == 0 || Var.getsKatana ( ) == 0 )
		{
			Var.setHpMax ( 10 );
		}
	}
	
	//player can try to win gold playing the guessing game
	public static void guessingGame( int gGameCost )
	{
		Scanner input = new Scanner ( System.in );
		if ( Var.getGold ( ) < gGameCost )
		{
			System.out.println ( "go get some more gold" );
		}
		else
		{
			int randNumber = 1; // initialize number to guess
			int game = 1; // game count
			int score = 6; // player score, will decrement before first play to 5
			char play = 'y'; // initialize loop to play game
			int number = -9999; // initialize guess loop
			int ttlpoints = 0; // total point accumulator
			int gameGold = Var.getGold ( ); //instance of amount of gold when beginning game

			// Game start
			while ( play == 'y' )
			{
				Var.setGold ( -gGameCost );
				randNumber = (int) ( Math.random ( ) * 10 + 1 ); // Generate randNumberom number

				// user number must not equal randNumberom number to guess again
				while ( number != randNumber )
				{
					score--; // minus one point per guess. starts at 5.
					if ( score < 0 )
					{
						score = 0; // set score to zero if less than zero
					}
					System.out.println ( score * 2 + " Points remain." );

					// prompt user for number and output results
					System.out.println ( "Enter a number between 1 and 10" );
					number = input.nextInt ( ); // users guess
					System.out.println ( "Your number was: " + number );

					// output if the number was too high or too low
					if ( number > randNumber )
					{
						System.out.println ( "Too high, guess again!" );
					}
					if ( number < randNumber )
					{
						System.out.println ( "Too low, guess again!" );
					}
				} // end loop when number = randNumber

				ttlpoints += score * 2; // score accumulate to total points
				System.out.println (
						"CORRECT! you get " + score * 2 + " Points and " + score * 2 + " gold! \nPlay Again? y/n" );
				
				//user gets amount of gold and points 
				//worth double the amount of remaining guesses
				Var.setGold ( score * 2 );
				Var.setPoints ( score * 2 );
				do // user must answer 'y' or 'n'
				{
					play = input.next ( ).toLowerCase ( ).charAt ( 0 ); // user inputs character
					if ( play != 'y' && play != 'n' ) // check character input
					{
						System.out.println ( "You must enter y or n, Play again?" ); // prompt user for correct input
					}
				} while ( play != 'y' && play != 'n' ); // loop if user enters something other than 'y' or 'n'

				// variables must be changed for next round
				if ( play == 'y' )
				{
					if ( Var.getGold ( ) >= gGameCost )
					{
						number = -9999; // reset number
						score = 6; // reset score for round (-1 before first guess)
						game++; // add one to game number count
					}
					else
					{
						System.out.println ( "you're out of gold, go get some more... sucker" );
						play = 'n';
					}
				}
			} // end loop if user inputs 'n'

			// calculate average and output score
			double avg = (double) ttlpoints / game;
			System.out.println ( "GUESSING GAME OVER. Total points: " + ttlpoints );
			System.out.println ( "Games played: " + game );
			System.out.println ( "Average Score: " + avg );
			int rev = Var.getGold ( ) - gameGold;
			//let player know the outcome of their game
			if ( Var.getGold ( ) > gameGold )
			{
				System.out.println ( "You made " + rev + " gold\n" );
			}
			else
			{
				System.out.println ( "Loss... " + rev + " gold" );
			}
		}
	}
}
