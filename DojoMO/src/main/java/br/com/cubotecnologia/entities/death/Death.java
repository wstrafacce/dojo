package br.com.cubotecnologia.entities.death;

import java.util.Date;

public class Death {
	
	private Date dtDeathDateTime;

	public Death(Date dtDeathDateTime) {
		super();
		this.dtDeathDateTime = dtDeathDateTime;
	}

	public Date getDeathDateTime() {
		return dtDeathDateTime;
	}
}
