package br.com.cubotecnologia.enuns;

public enum WeaponType {
	FIRE(1), WHITE(2), UNKNOW(999);
	
	private int iWeaponTypeId;

	private WeaponType(int iWeaponTypeId) {
		this.iWeaponTypeId = iWeaponTypeId;
	}

	public int getiAwardTypeId() {
		return iWeaponTypeId;
	}

	public void setiAwardTypeId(int iWeaponTypeId) {
		this.iWeaponTypeId = iWeaponTypeId;
	}
}
