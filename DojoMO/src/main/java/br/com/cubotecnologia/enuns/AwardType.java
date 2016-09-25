package br.com.cubotecnologia.enuns;

public enum AwardType {
	LIFE(1), MONEY(2), POINTS(3);
	
	private int iAwardTypeId;

	private AwardType(int iAwardTypeId) {
		this.iAwardTypeId = iAwardTypeId;
	}

	public int getiAwardTypeId() {
		return iAwardTypeId;
	}

	public void setiAwardTypeId(int iAwardTypeId) {
		this.iAwardTypeId = iAwardTypeId;
	}
}
