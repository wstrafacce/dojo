package br.com.cubotecnologia.entities.awards.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.AwardType;

public class AwardPoints extends AAward{

	private final double dBASE_VALUE = 10.0;

	@Override
	public AwardType getAwardType() {
		return awtAwardType;
	}
	
	public void processesAward(IPlayer player) {
		// TODO Auto-generated method stub
		
	}

}
