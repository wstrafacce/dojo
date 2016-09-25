package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.WeaponType;

public class AK47 extends AWeapon{
	
	private static final String sALIAS = "AK47";

	public AK47() {
		super(sALIAS);
		wptWeaponType = WeaponType.FIRE;
		iDamage = 35;
	}

	@Override
	public WeaponType getWeponType() {
		return wptWeaponType;
	}

	@Override
	public String getAlias() {
		return sALIAS;
	}
	
	@Override
	public int getDamage() {
		return iDamage;
	}

	public void processesDamage(IPlayer player) {
		// TODO Auto-generated method stub
		
	}

	

}
