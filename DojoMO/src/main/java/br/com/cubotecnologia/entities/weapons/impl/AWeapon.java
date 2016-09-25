package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.weapons.IWeapon;
import br.com.cubotecnologia.enuns.WeaponType;

public abstract class AWeapon implements IWeapon{
	protected WeaponType wptWeaponType;
	protected String sAlias;
	protected int iDamage;
	
	public AWeapon(String sAlias) {
		super();
		this.sAlias = sAlias;
	}
	
	public abstract WeaponType getWeponType();
	
	public abstract String getAlias();
	
	public abstract int getDamage();
}
