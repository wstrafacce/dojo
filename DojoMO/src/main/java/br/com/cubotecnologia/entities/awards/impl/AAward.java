package br.com.cubotecnologia.entities.awards.impl;

import br.com.cubotecnologia.entities.awards.IAward;
import br.com.cubotecnologia.enuns.AwardType;

public abstract class AAward implements IAward{
	
	protected AwardType awtAwardType;
	
	public abstract AwardType getAwardType();
}
