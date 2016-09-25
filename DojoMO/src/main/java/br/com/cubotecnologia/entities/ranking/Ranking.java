package br.com.cubotecnologia.entities.ranking;

import java.util.ArrayList;
import java.util.List;

import br.com.cubotecnologia.entities.players.impl.Player;

public class Ranking {
	
	private List<Player> lPlayers;

	public Ranking() {
		this.lPlayers = new ArrayList<Player>();
	}

	private List<Player> getPlayers() {
		return lPlayers;
	}

	private void addPlayers(Player plyPlayers) {
		this.lPlayers.add(plyPlayers);
	}
}
