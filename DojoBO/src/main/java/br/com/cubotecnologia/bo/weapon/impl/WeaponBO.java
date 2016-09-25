package br.com.cubotecnologia.bo.weapon.impl;

import br.com.cubotecnologia.bo.weapon.IWeaponBO;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.entities.weapons.impl.AK47;
import br.com.cubotecnologia.entities.weapons.impl.AWeapon;
import br.com.cubotecnologia.entities.weapons.impl.Knife;
import br.com.cubotecnologia.entities.weapons.impl.M16;
import br.com.cubotecnologia.entities.weapons.impl.Magnum;
import br.com.cubotecnologia.enuns.WeaponType;

public class WeaponBO implements IWeaponBO{
	private static final String sAK47 = "AK47";
	private static final String sM16 = "M16";
	private static final String sKNIFE = "KNIFE";
	private static final String sMAGNUM = "MAGNUM";

	public AWeapon getWeaponInstace(String sWeapon) {
		
		AWeapon wpnWeapon = null;
		
		switch (sWeapon.toUpperCase()) {
		case sAK47:
			wpnWeapon = new AK47();
			break;

		case sM16:
			wpnWeapon = new M16();
			break;

		case sKNIFE:
			wpnWeapon = Knife.getKnifeInstance();
			break;

		case sMAGNUM:
			wpnWeapon = new Magnum();
			break;

		default:
			wpnWeapon = new AWeapon(sWeapon.toUpperCase()) {				
				@Override
				public void processesDamage(IPlayer player) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public WeaponType getWeponType() {
					return wptWeaponType;
				}
				
				@Override
				public int getDamage() {
					return iDamage;
				}
				
				@Override
				public String getAlias() {
					return sAlias;
				}
			};
			break;
		}
		
		return wpnWeapon;
	}
}
