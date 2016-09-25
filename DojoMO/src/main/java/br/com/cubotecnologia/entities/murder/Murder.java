package br.com.cubotecnologia.entities.murder;

import java.util.Date;

import br.com.cubotecnologia.entities.weapons.impl.AWeapon;

public class Murder {
	private Date dtMurderDateTime;
	private AWeapon wpnWeapon;
	
	public Murder(Date dtMurderDateTime, AWeapon wpnWeapon) {
		super();
		this.dtMurderDateTime = dtMurderDateTime;
		this.wpnWeapon = wpnWeapon;
	}
	
	public Date getMurderDateTime() {
		return dtMurderDateTime;
	}
	
	public AWeapon getWeapon() {
		return wpnWeapon;
	}
	
	
}
