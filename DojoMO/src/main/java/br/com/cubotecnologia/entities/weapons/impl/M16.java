package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.WeaponType;

public class M16 extends AWeapon{

	private static final String sALIAS = "M16";
	
	public M16() {
		super(sALIAS);
		wptWeaponType = WeaponType.FIRE;
		iDamage = 60;
	}

	@Override
	public WeaponType getWeponType() {
		return wptWeaponType;
	}

	@Override
	public String getAlias() {
		return sAlias;
	}

	@Override
	public int getDamage() {
		return iDamage;
	}

	public void processesDamage(IPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
}
