package br.com.cubotecnologia.vo;

public class LogLineVO {
	private String sDateTime;
	private String sMatchId;
	private String sKillerNickName;
	private String sVictmNickName;
	private String sActionEnum;
	private String sWeapon;
	
	public String getDateTime() {
		return sDateTime;
	}
	public void setDateTime(String sDateTime) {
		this.sDateTime = sDateTime;
	}
	public String getMatchId() {
		return sMatchId;
	}
	public void setMatchId(String sMatchId) {
		this.sMatchId = sMatchId;
	}
	public String getKillerNickName() {
		return sKillerNickName;
	}
	public void setKillerNickName(String sKillerNickName) {
		this.sKillerNickName = sKillerNickName;
	}
	public String getVictmNickName() {
		return sVictmNickName;
	}
	public void setVictmNickName(String sVictmNickName) {
		this.sVictmNickName = sVictmNickName;
	}
	public String getActionEnum() {
		return sActionEnum;
	}
	public void setActionEnum(String sActionEnum) {
		this.sActionEnum = sActionEnum;
	}
	public String getWeapon() {
		return sWeapon;
	}
	public void setWeapon(String sWeapon) {
		this.sWeapon = sWeapon;
	}	
}
