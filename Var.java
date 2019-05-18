

public class Var
{
	//game data
	
	//player gold, player health points, player maximum health points, player minimum and maximum damage, player dexterity and evade chance
	private static int gold, hp, hpMax, minDMG, maxDMG, dex, evade, 
	
	// chaper of game, character lady of the lake in swamp count, short sword weapon, long sword weapon, leather armor, mercurial dancing boots
	chapter, ladyOfLake, sSword, lSword, lArmor, mBoots,
	
	// jeweled dagger, magic shield, snowy bastard sword, hp potion amount, text counter for merchant area, loser and figher player classes
	mDagger, mShield, bSword, hpPot, merchCount, loser, fighter, 
	
	// victim character in the city walk count, player points, player battle decision, city counter for text, Chaos demon boos alive/dead
	victim, points, battleDec, city, chaosDemonLife,
	
	// void rapier weapon, dynamite item count, coral Kukri weapon, direction decision for chapters 2 and 3, necro Horde boss alive/dead
	vRapier, dynamite, cKukri, direction, hordeLife, 
	
	// gryphon boss life alive/dead, parrying dagger weapon, studded leather armor, shadow Katana weapon, lighning axe weapon
	gryphonLife, pDagger, slArmor, sKatana, lAxe, 
	
	// litch King boss life alive/dead, void Bangle item, counter for road length, chaos final boss life alive/dead
	litchKing, vBangle, areaCount, chaosLife;
	
	//player name
	private static String player;
	
	//Data getters and setters
	public static int getChaosLife( )
	{
		return chaosLife;
	}

	public static void setChaosLife( int chaosLife )
	{
		Var.chaosLife += chaosLife;
	}

	public static String getPlayer( )
	{
		return player;
	}

	public static void setPlayer( String player )
	{
		Var.player = player;
	}

	public static int getGold( )
	{
		return gold;
	}

	public static void setGold( int gold )
	{
		Var.gold += gold;
	}

	public static int getHp( )
	{
		return hp;
	}

	public static void setHp( int hp )
	{
			Var.hp += hp;
			
			if ( Var.hp > Var.getHpMax() ) //hp cannot be higher than hp max
			{
				Var.hp = Var.getHpMax();
			}
		
	}

	public static int getHpMax( )
	{
		return hpMax;
	}

	public static void setHpMax( int hpMax )
	{
		Var.hpMax += hpMax;
	}

	public static int getMinDMG( )
	{
		return minDMG;
	}

	public static void setMinDMG( int minDMG )
	{
		if ( minDMG == 1 || minDMG == -1 ) //if change is only by one, then it is an off-hand modifier
		{
			Var.minDMG += minDMG;
		}
		else // change is literal
		{
			Var.minDMG = minDMG;
		}

	}

	public static int getMaxDMG( )
	{
		return maxDMG;
	}

	public static void setMaxDMG( int maxDMG )
	{
		if ( maxDMG == 1 || maxDMG == -1 || maxDMG == 2 )//these values indicate a modifier instead of a literal change
		{
			Var.maxDMG += maxDMG;
		}
		else
		{
			Var.maxDMG = maxDMG;
		}
	}

	public static int getDex( )
	{
		return dex;
	}

	public static void setDex( int dex )
	{
		Var.dex += dex;
	}

	public static int getEvade( )
	{
		return evade;
	}

	public static void setEvade( int evade )
	{
		Var.evade += evade;
	}

	public static int getChapter( )
	{
		return chapter;
	}

	public static void setChapter( int chapter )
	{
		Var.chapter = chapter;
	}

	public static int getLadyOfLake( )
	{
		return ladyOfLake;
	}

	public static void setLadyOfLake( int ladyOfLake )
	{
		Var.ladyOfLake = ladyOfLake;
	}

	public static int getsSword( )
	{
		return sSword;
	}

	public static void setsSword( int sSword )
	{
		if ( sSword > 1 ) //check to make sure item quantity is binary
		{
			Var.sSword = 1;
		}
		else
		{
			Var.sSword += sSword;
		}
	}

	public static int getlSword( )
	{
		return lSword;
	}

	public static void setlSword( int lSword )
	{
		if ( lSword > 1 )//check to make sure item quantity is binary
		{
			Var.lSword = 1;
		}
		else
		{
			Var.lSword += lSword;
		}
	}

	public static int getlArmor( )
	{

		return lArmor;
	}

	public static void setlArmor( int lArmor )
	{
		Var.lArmor += lArmor;
	}

	public static int getmBoots( )
	{
		return mBoots;
	}

	public static void setmBoots( int mBoots )
	{
		Var.mBoots += mBoots;
	}

	public static int getmDagger( )
	{
		return mDagger;
	}

	public static void setmDagger( int mDagger )
	{
		Var.mDagger += mDagger;
	}

	public static int getmShield( )
	{
		return mShield;
	}

	public static void setmShield( int mShield )
	{
		Var.mShield += mShield;
	}

	public static int getbSword( )
	{
		return bSword;
	}

	public static void setbSword( int bSword )
	{
		Var.bSword += bSword;
	}

	public static int getHpPot( )
	{
		return hpPot;
	}

	public static void setHpPot( int hpPot )
	{
		Var.hpPot += hpPot;
	}

	public static int getMerchCount( )
	{
		return merchCount;
	}

	public static void setMerchCount( int merchCount )
	{
		Var.merchCount += merchCount;
	}

	public static int getLoser( )
	{
		return loser;
	}

	public static void setLoser( int loser )
	{
		Var.loser += loser;
	}

	public static int getFighter( )
	{
		return fighter;
	}

	public static void setFighter( int fighter )
	{
		Var.fighter += fighter;
	}

	public static int getVictim( )
	{
		return victim;
	}

	public static void setVictim( int victim )
	{
		Var.victim += victim;
	}

	public static int getPoints( )
	{
		return points;
	}

	public static void setPoints( int points )
	{
		Var.points += points;
	}

	public static int getBattleDec( )
	{
		return battleDec;
	}

	public static void setBattleDec( int battleDec )
	{
		Var.battleDec += battleDec;
	}

	public static int getCity( )
	{
		return city;
	}

	public static void setCity( int city )
	{
		Var.city += city;
	}

	public static int getChaosDemonLife( )
	{
		return chaosDemonLife;
	}

	public static void setChaosDemonLife( int chaosDemonLife )
	{
		Var.chaosDemonLife += chaosDemonLife;
	}

	public static int getvRapier( )
	{

		return vRapier;
	}

	public static void setvRapier( int vRapier )
	{
		if ( vRapier > 1 )//check to make sure item quantity is binary
		{
			Var.vRapier = 1;
		}
		else
		{
			Var.vRapier += vRapier;
		}
	}

	public static int getDynamite( )
	{
		return dynamite;
	}

	public static void setDynamite( int dynamite )
	{
		Var.dynamite += dynamite;
	}

	public static int getcKukri( )
	{

		return cKukri;
	}

	public static void setcKukri( int cKukri )
	{
		if ( cKukri > 1 )//check to make sure item quantity is binary
		{
			Var.cKukri = 1;
		}
		else
		{
			Var.cKukri += cKukri;
		}
	}

	public static int getDirection( )
	{
		return direction;
	}

	public static void setDirection( int direction )
	{
		Var.direction = direction;
	}

	public static int getHordeLife( )
	{
		return hordeLife;
	}

	public static void setHordeLife( int hordeLife )
	{
		Var.hordeLife += hordeLife;
	}

	public static int getGryphonLife( )
	{
		return gryphonLife;
	}

	public static void setGryphonLife( int gryphonLife )
	{
		Var.gryphonLife += gryphonLife;
	}

	public static int getpDagger( )
	{
		return pDagger;
	}

	public static void setpDagger( int pDagger )
	{
		Var.pDagger += pDagger;
	}

	public static int getSlArmor( )
	{
		return slArmor;
	}

	public static void setSlArmor( int slArmor )
	{
		Var.slArmor += slArmor;
	}

	public static int getsKatana( )
	{

		return sKatana;
	}

	public static void setsKatana( int sKatana )
	{
		if ( sKatana > 1 )//check to make sure item quantity is binary
		{
			Var.sKatana = 1;
		}
		else
		{
			Var.sKatana += sKatana;
		}
	}

	public static int getlAxe( )
	{
		return lAxe;
	}

	public static void setlAxe( int lAxe )
	{
		if ( lAxe > 1 )//check to make sure item quantity is binary
		{
			Var.lAxe = 1;
		}
		else
		{
			Var.lAxe += lAxe;
		}
	}

	public static int getLitchKing( )
	{
		return litchKing;
	}

	public static void setLitchKing( int litchKing )
	{
		Var.litchKing += litchKing;
	}

	public static int getvBangle( )
	{
		return vBangle;
	}

	public static void setvBangle( int vBangle )
	{
		Var.vBangle += vBangle;
	}

	public static int getAreaCount( )
	{
		return areaCount;
	}

	public static void setAreaCount( int areaCount )
	{
		if ( areaCount == 0 ) //used to break loop
		{
			Var.areaCount = areaCount;
		}
		else //else increments
		{
			Var.areaCount += areaCount;
		}
	}

}
