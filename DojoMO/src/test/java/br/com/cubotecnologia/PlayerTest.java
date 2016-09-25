package br.com.cubotecnologia;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.cubotecnologia.entities.murder.Murder;
import br.com.cubotecnologia.entities.players.impl.Player;
import br.com.cubotecnologia.entities.weapons.impl.AK47;
import br.com.cubotecnologia.entities.weapons.impl.AWeapon;
import br.com.cubotecnologia.entities.weapons.impl.Knife;
import br.com.cubotecnologia.entities.weapons.impl.M16;

public class PlayerTest {

	@Test
	public void getFavoriteWeaponSuccesTest() {
		Player plyPlayer = new Player("William", "wstrafacce");

		for (int i = 0; i < 100; ++i) {
			Date now = new Date();
			AWeapon wpnWeapon = null;

			if (i % 2 == 0) {
				wpnWeapon = Knife.getKnifeInstance();
			} else if (i % 3 == 0) {
				wpnWeapon = new AK47();
			} else {
				wpnWeapon = new M16();
			}

			Murder mrdMurder = new Murder(now, wpnWeapon);
			plyPlayer.addMurder(mrdMurder);
		}

		String sFavoriteWeapon = plyPlayer.getFavoriteWeapon();
		AWeapon wpnWeapon = Knife.getKnifeInstance();
		assertEquals(wpnWeapon.getAlias(), sFavoriteWeapon);

	}

	@Test
	public void getFavoriteWeaponFailTest() {
		Player plyPlayer = new Player("William", "wstrafacce");

		for (int i = 0; i < 100; ++i) {
			Date now = new Date();
			AWeapon wpnWeapon = null;

			if (i % 2 == 0) {
				wpnWeapon = Knife.getKnifeInstance();
			} else if (i % 3 == 0) {
				wpnWeapon = new AK47();
			} else {
				wpnWeapon = new M16();
			}

			Murder mrdMurder = new Murder(now, wpnWeapon);
			plyPlayer.addMurder(mrdMurder);
		}

		String sFavoriteWeapon = plyPlayer.getFavoriteWeapon();
		AWeapon wpnWeapon = new AK47();
		assertNotEquals(wpnWeapon.getAlias(), sFavoriteWeapon);

	}

}
