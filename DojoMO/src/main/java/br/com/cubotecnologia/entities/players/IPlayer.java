package br.com.cubotecnologia.entities.players;

import br.com.cubotecnologia.entities.death.Death;
import br.com.cubotecnologia.entities.murder.Murder;

public interface IPlayer {
	public String getFavoriteWeapon();
	public void addMurder(Murder mrdMurder);
	public void addDeath(Death dthDeath);
	public int getNumberOfDeaths();
	public int getNumberOfMurders();
}
