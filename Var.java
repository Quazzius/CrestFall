
public class Var
{
	static int gold, hp, hpMax, minDMG, maxDMG, dex, evade, chapter, ladyOfLake, sSword,
	lSword, lArmor, mBoots, mDagger, mShield, bSword, hpPot, merchCount, loser, fighter,
	victim, points, battleDec, city, chaosDemonLife, vRapier, dynamite, cKukri, direction,
	hordeLife, gryphonLife, pDagger, slArmor, sKatana, lAxe, litchKing, vBangle, chaos, areaCount;

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
		if (Var.hp > Var.hpMax) {
			hp = Var.hpMax;
		}
	}

	public static int getHpMax( )
	{
		return hpMax;
	}

	public static void setHpMax( int hpMax )
	{
		Var.hpMax += hpMax;
		if (Var.hp > hpMax) {
			Var.hp = hpMax;
		}
	}

	public static int getMinDMG( )
	{
		return minDMG;
	}

	public static void setMinDMG( int minDMG )
	{
		if (minDMG == 1 || minDMG == -1) {
			Var.minDMG += minDMG;
		}
		else {
			Var.minDMG = minDMG;
		}
		
	}

	public static int getMaxDMG( )
	{
		return maxDMG;
	}

	public static void setMaxDMG( int maxDMG )
	{
		if(maxDMG == 1 || maxDMG == -1 || maxDMG == 2) {
			Var.maxDMG += maxDMG;
		}
		else {
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
		if (sSword > 1) {
			Var.sSword = 1;
		}
		else {
			Var.sSword += sSword;
		}
	}

	public static int getlSword( )
	{
		return lSword;
	}

	public static void setlSword( int lSword )
	{
		if (lSword > 1) {
			Var.lSword = 1;
		}
		else {
			Var.lSword += lSword;
		}
		Var.lSword += lSword;
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
		if (vRapier > 1) {
			Var.vRapier = 1;
		}
		else {
			Var.vRapier += vRapier;
		}
		Var.vRapier += vRapier;
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
		if (cKukri > 1) {
			Var.cKukri = 1;
		}
		else {
			Var.cKukri += cKukri;
		}
		Var.cKukri += cKukri;
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
		if (sKatana > 1) {
			Var.sKatana = 1;
		}
		else {
			Var.sKatana += sKatana;
		}
		Var.sKatana += sKatana;
	}

	public static int getlAxe( )
	{
		return lAxe;
	}

	public static void setlAxe( int lAxe )
	{
		if (lAxe > 1) {
			Var.lAxe = 1;
		}
		else {
			Var.lAxe += lAxe;
		}
		Var.lAxe += lAxe;
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

	public static int getChaos( )
	{
		return chaos;
	}

	public static void setChaos( int chaos )
	{
		Var.chaos += chaos;
	}

	public static int getAreaCount( )
	{
		return areaCount;
	}

	public static void setAreaCount( int areaCount )
	{
		if (areaCount == 0) {
			Var.areaCount = areaCount;
		}
		else {
			Var.areaCount += areaCount;
		}
	}
	
	
}