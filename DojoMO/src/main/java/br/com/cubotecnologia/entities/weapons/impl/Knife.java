package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.WeaponType;

public class Knife extends AWeapon{
	
	private static Knife knfKinfeInstance;
	private static final String sALIAS = "KNIFE";
	
	private Knife() {
		super(sALIAS);
		wptWeaponType = WeaponType.WHITE;
		iDamage = 10;
	}
	
	public static Knife getKnifeInstance () {
		
		if (knfKinfeInstance == null) {
			knfKinfeInstance = new Knife();
		}
		
		return knfKinfeInstance;
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
