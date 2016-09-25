package br.com.cubotecnologia.enuns;

public enum ActionsEnum {
	STARTED(1), KILLED(2), ENDED(3), WORLD(4);
	
	private static final String sSTARTED = "STARTED";
	private static final String sENDED = "ENDED";
	private static final String sKILLED = "KILLED";
	private static final String sWORLDKILLER = "WORLD";
	
	private int iActionTypeId;
	
	private ActionsEnum(int iActionTypeId) {
		this.iActionTypeId = iActionTypeId;
	}

	public int getActionTypeId() {
		return iActionTypeId;
	}

	public void setActionTypeId(int iActionTypeId) {
		this.iActionTypeId = iActionTypeId;
	}
	
	public static ActionsEnum getActionByStrAction(String sAction) throws Exception {
		
		ActionsEnum actAction = null;
		
		switch (sAction.toUpperCase()) {
		case sSTARTED:
			actAction = ActionsEnum.STARTED;
			break;
			
		case sENDED:
			actAction = ActionsEnum.ENDED;
			break;
		
		case sKILLED:
			actAction = ActionsEnum.KILLED;
			break;
			
		case sWORLDKILLER:
			actAction = ActionsEnum.WORLD;
			break;
			
		default:
			
			throw new Exception("Action doesn't exists");
		}
		
		return actAction;
	}
}
