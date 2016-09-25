package br.com.cubotecnologia.entities.weapons;

import br.com.cubotecnologia.entities.players.IPlayer;

public interface IWeapon {
	
	public void processesDamage(IPlayer player);
}
