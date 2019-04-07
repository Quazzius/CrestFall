import java.util.Scanner;

public class CfSequence
{
	public static final int minEnc = 1, maxEnc = 2, encNumber = 1, range = maxEnc - minEnc + 1;
	public static int rand, attack, hitDMG, hitChance, merch;
	
	public static int[] battleSequence(int[] a, int minRange, int maxRange, String eType, String aType, int eMaxHit, int eMinHit, int areaCount, 
			int enemyHP, int maxFlee, int minFlee, int rewardGold, int rewardPoints, int heroHit, String killText, String deathFlavor, char enemyAbility) {
		Scanner input = new Scanner(System.in);
		int poisonCount = 0; //initialize hero poisoned counter
		int ePoisonCount = 0; // initialize enemy poisoned counter
		int stunCount = 0;  //initialize hero stun
		int eStunCount = 0;
		if (a[26] == 0 || a[33] == 0) { //lose max hp to Vamp
			a[2] -= 10;
			if (a[1] > a[2]) {
				a[1] = a[2];
			}
		}
		while (enemyHP > 0)  //fight sequence
		{	
			eStunCount--;
			if (eStunCount < 1) {
				int damage = (int) ( Math.random ( ) * maxRange + minRange ); //enemy attack range
				System.out.println ( eType + aType + " for " + damage + " damage.");
				hitChance = (int) ( Math.random ( ) * eMaxHit + eMinHit);  //enemy hit chance
				if (a[6] > hitChance) //if evade is greater than hit
				{
					System.out.println ( "But Misses!" );
				}
				else
				{
					a[1] -= damage; //player attacked
					System.out.println ( "-" + damage + " HP. " + "HP is " + a[1] + "/" + a[2]);
					 //if enemy ability type "v" vampirism
					if (enemyAbility == 'v') {  
						double vamp = damage * 0.25;  // heals 25% damage given
						int iVamp = (int) vamp;  // change from double to int
						if (iVamp > 0) {   // output if necessary
							System.out.println ( eType + " heals " + iVamp + " HP" );
							enemyHP += iVamp;
						}
					}
					else if (enemyAbility == 'p' && poisonCount < 1) {
						int poison = (int) (Math.random ( ) * 3 + 1);
						if (poison == 3) {
							System.out.println ( "You're Poisoned!" );
							poisonCount = 3;
						}
					}
					else if (enemyAbility == 's' && stunCount < 1) {
						int stun = (int) (Math.random ( ) * 8 + 1);
						if (stun == 5) {
							System.out.println ( "You're Stunned! (1 turn)\n" );
							stunCount = 2;
						}
					}
					if (a[1] < 1) //on death condition, reset variables to go to game over
					{
						a[7] = 0;
						areaCount = 9;
						enemyHP = 0;
						merch = 0;
						a[23] = 6;
						a[25] = '0';
						
					}
				}
			}
			if (poisonCount > 0 ){
				poisonCount--;
				System.out.println ( "-2 HP (Poison), left: " + poisonCount);
				a[1] -= 2;
				
			}
			  //battle decision
			
			stunCount--;
			if (a[1] > 0 && stunCount < 1) {
				System.out.println ( "0 - Flee\n1 - Attack" );
				if (a[7] > 2) {
					System.out.println ( "3 - Dynamite: " + a[27]);
				}
				if (a[7] > 1) {
					System.out.println ( "5 - Health Potion: " + a[16] );
				}
				a[22] = input.nextInt();
				
				//flee
				switch (a[22]) 
				{
					//flee
					case 0:
						hitChance = (int) ( Math.random ( ) * maxFlee + minFlee);  //chance to flee
						if (a[6] > hitChance) {  //flee successful
							System.out.println ( "You run away! Coward!" );
							enemyHP = 0;
						}
						else { //flee unsuccessful
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
						break;
				
					//attack
					case 1:
						hitDMG = (int) ( Math.random ( ) * attack + a[3]);  //possible damage range
						hitChance = (int) ( Math.random ( ) * heroHit + 1);  //chance to hit
						if (a[5] >= hitChance)  //if dex is at least heroHit chance
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							enemyHP -= hitDMG;
							
							// has bangle
							if (a[36] == 0) { 
								System.out.println ( "HP + 1" );
								a[1] += 1;
								if (a[1] > a[2]) { //cant go above max
									a[1] = a[2];
								}
							}
							
							//character ability Vamp
							if (a[26] == 0 || a[33] == 0) { 
								System.out.println ( "HP + 1" );
								a[1] += 1;
								if (a[1] > a[2]) { //cant go above max
									a[1] = a[2];
								}
							}
							//character ability poison
							else if (a[28] == 0 && ePoisonCount < 1) {
								int ePoison = (int) (Math.random ( ) * 3 + 1);
								if (ePoison == 3) {
									System.out.println ( eType + " Poisoned!" );
									ePoisonCount = 3;
								}
							}
							else if (a[34] == 0) {
								int eStun = (int) (Math.random ( ) * 7 + 1);
								if (eStun == 3) {
									System.out.println ( eType + " Stunned!" );
									eStunCount = 2;
								}
							}
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
						if (ePoisonCount > 0) {
							System.out.println ( eType + " -2 HP (Poison), Left: " + ePoisonCount );
							enemyHP -= 2;
							ePoisonCount--;
						}
					break;
						
					case 3:
						if (a[27] > 0) {
							System.out.println ( "You light the wick and toss the dynamite at the " + eType );
							System.out.println ( "dealing 30 damage! Your reckless action deals 5 damage to you as well" );
							enemyHP -= 30;
							a[1] -= 5;
							a[27] --;
						}
						else {
							System.out.println ( "Idiot! You have no explosives in your inventory!" );
						}
					break;
					
					//heal
					case 5:
						if (a[16] > 0) {
							if (a[7] > 2) {
								System.out.println ( "Delicious reptile secretions...\n +40 HP" );
								a[16] --;  //used potion
								a[21] -= 40; //lose points for healing
								a[1] += 40; // heal
								if (a[1] > a[2]) {
									a[1] = a[2]; //hp cant be greater than hp max
								}
							}
							else {
								System.out.println ( "That Sauce is Awesome!\n +25 HP" );
								a[16] --;  //used potion
								a[21] -= 25; //lose points for healing
								a[1] += 25; // heal
								if (a[1] > a[2]) {
									a[1] = a[2]; //hp cant be greater than hp max
								}
							}
						}
						else {
							System.out.println ( "Fool! You have no bottles in supply!" );
						}
				}
			}
		}
		if (a[1] > 0 && a[22] != 0) { //make sure hero did not die or flee for reward
			System.out.println ( killText + eType + deathFlavor );
			a[0] += rewardGold; // gold
			a[21] += rewardPoints;  //points
		}
		if (a[26] == 0 || a[33] == 0) {
			a[2] += 10;
		}
		return a;	
	}
	public static int[] guessingGame(int[]a, int gGameCost) {
		Scanner input = new Scanner(System.in);
		if (a[0] < gGameCost) {
			System.out.println ( "go get some more gold" );
		}
		else {
			int randNumber = 1;   //initialize nested loop
			int game = 1;   //game count
			int score = 6;  //player score, will decrement before first play to 5
			char play = 'y';  //initialize loop to play game
			int number = -9999;  //initialize guess loop
			int ttlpoints = 0;  //total point accumulator
			int gameGold = a[0];
			
			//Game start
			while (play =='y')
			{
				a[0] -= gGameCost;
				randNumber = (int) ( Math.random ( ) * 12 + 1 );  //Generate randNumberom number
				
				//user number must not equal randNumberom number to guess again
				while (number != randNumber)
				{
					score--; //minus one point per guess. starts at 5.
					if (score < 0)
					{
						score = 0; //set score to zero if less than zero
					}
					System.out.println ( score * 2 + " Points remain." ); 
					
					//prompt user for number and output results
					System.out.println ("Enter a number between 1 and 12");
					number = input.nextInt ( );  //users guess
					System.out.println ( "Your number was: " + number);
				
					//output if the number was too high or too low
					if (number > randNumber)
					{
						System.out.println ( "Too high, guess again!" );
					}
					if (number < randNumber)
					{
						System.out.println ( "Too low, guess again!" );
					}
				} //end loop when number = randNumber
				
				ttlpoints += score * 2; //score accumulate to total a[21]
				System.out.println ( "CORRECT! you get " + score * 2 + " Points and " + score * 2 + " gold! \nPlay Again? y/n" );
				a[0] += score * 2;
				a[21] += score * 2;
				do //user must answer 'y' or 'n'
				{
					play = input.next ( ).toLowerCase ( ).charAt ( 0 );  //user inputs character
					if (play != 'y' && play != 'n')  //check character input
					{
						System.out.println ( "You must enter y or n, Play again?" ); //prompt user for correct input
					}
				} while (play != 'y' && play != 'n');  //loop if user enters something other than 'y' or 'n'
				
				//variables must be changed for next round
				if (play == 'y')
				{
					if (a[0] >= gGameCost) {
						number = -9999;  // reset number
						score = 6;  //reset score for round (-1 before first guess)
						game++;   //add one to game number count
					}
					else {
						System.out.println ( "you're out of gold, go get some more... sucker" );
						play = 'n';
					}
				} 
			}//end loop if user inputs 'n'
			 //calculate average and output score
			double avg = (double)ttlpoints / game;
			System.out.println ("GUESSING GAME OVER. Total a[21]: " + ttlpoints);
			System.out.println ("Games played: " + game);
			System.out.println ( "Average Score: " + avg );
			int rev = a[0] - gameGold;
			if (a[0] > gameGold) {
				System.out.println ( "You made " + rev + " gold\n" );
			}
			else {
				System.out.println ( "Loser. " + rev + " gold" );
			}
		}
		return a;	
	}
}
