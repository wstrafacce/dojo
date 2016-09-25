package br.com.cubotecnologia.entities.players.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import br.com.cubotecnologia.entities.death.Death;
import br.com.cubotecnologia.entities.murder.Murder;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.entities.weapons.impl.AWeapon;
import br.com.cubotecnologia.utils.MapUtils;

public class Player implements IPlayer {
	private String sName;
	private String sNickName;
	private double dMoney;
	private int iPoints;
	private int iStreak;
	private List<AWeapon> lWeapons;
	private List<Murder> lMurders;
	private List<Death> lDeaths;

	public Player(String sName, String sNickName) {
		super();
		this.sName = sName;
		this.sNickName = sNickName;
		this.dMoney = 5000.0;
		this.lWeapons = new ArrayList<AWeapon>();
		this.lMurders = new ArrayList<Murder>();
		this.lDeaths = new ArrayList<Death>();
	}
	
	public Player(String sNickName) {
		super();
		this.sName = sNickName;
		this.sNickName = sNickName;
		this.dMoney = 5000.0;
		this.lWeapons = new ArrayList<AWeapon>();
		this.lMurders = new ArrayList<Murder>();
		this.lDeaths = new ArrayList<Death>();
	}

	public String getName() {
		return sName;
	}

	public String getNickName() {
		return sNickName;
	}

	public double getMoney() {
		return dMoney;
	}

	public void setMoney(double dMoney) {
		this.dMoney = dMoney;
	}

	public int getPoints() {
		return iPoints;
	}

	public void setPoints(int iPoints) {
		this.iPoints = iPoints;
	}

	public int getStreak() {
		return iStreak;
	}

	public void setStreak(int iStreak) {
		this.iStreak = iStreak;
	}

	public List<Murder> getMurders() {
		return lMurders;
	}

	public void addMurder(Murder mrdMurder) {
		this.lMurders.add(mrdMurder);
	}

	public List<Death> getDeaths() {
		return lDeaths;
	}

	public void addDeath(Death dthDeath) {
		this.lDeaths.add(dthDeath);
	}

	public List<AWeapon> getWeapons() {
		return lWeapons;
	}

	public void addWeapons(AWeapon wpnWeapons) {
		this.lWeapons.add(wpnWeapons);
	}

	public String getFavoriteWeapon() {
		Map<String, Integer> mapFavoriteWeapon = new LinkedHashMap<String, Integer>();

		for (Murder mrdMurder : lMurders) {
			AWeapon wpnWeapon = mrdMurder.getWeapon();
			if (mapFavoriteWeapon.containsKey(wpnWeapon.getAlias())) {
				int iCount = mapFavoriteWeapon.get(wpnWeapon.getAlias());
				mapFavoriteWeapon.replace(wpnWeapon.getAlias(), iCount, ++iCount);
			} else {
				mapFavoriteWeapon.put(wpnWeapon.getAlias(), 1);
			}
		}

		mapFavoriteWeapon = MapUtils.sortByValue(mapFavoriteWeapon);
		
		String sFavoriteWeapon = StringUtils.EMPTY;
		
		if (mapFavoriteWeapon.size() > 0) {
			Entry<String, Integer> lastEntry = MapUtils.getEntryByIndex(mapFavoriteWeapon, mapFavoriteWeapon.size() -1);
			sFavoriteWeapon = lastEntry.getKey();
		}
		
		return sFavoriteWeapon;
	}
	
	public int getNumberOfDeaths() {
		return this.lDeaths.size();
	}
	
	public int getNumberOfMurders() {
		return this.lMurders.size();
	}

}
