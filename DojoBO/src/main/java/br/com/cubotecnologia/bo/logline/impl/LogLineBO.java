package br.com.cubotecnologia.bo.logline.impl;

import br.com.cubotecnologia.bo.logline.ILogLineBO;
import br.com.cubotecnologia.vo.LogLineVO;

public class LogLineBO implements ILogLineBO{

	private static final String sMATCH = "MATCH";
	private static final String sKILLED = "KILLED";
	private static final String sWORLD = "WORLD";
	private static final String sSTARTED = "STARTED";
	private static final String sENDED = "ENDED";
	
	public LogLineVO processesLogLine(String sLogLine) {

		LogLineVO lneLogLineVO = new LogLineVO();
		StringBuilder sbStringBuilder = new StringBuilder();
		String vSplitLine[] = sLogLine.split(" ");
		lneLogLineVO.setDateTime(sbStringBuilder.append(vSplitLine[0]).append(" ").append(vSplitLine[1]).toString());

		if (Integer.MIN_VALUE == getLogLineWordIndex(vSplitLine, sWORLD) ) {
			switch (vSplitLine[vSplitLine.length - 1].toUpperCase()) {
			case sSTARTED:
				lneLogLineVO.setMatchId(getMatchId(vSplitLine));
				lneLogLineVO.setActionEnum(vSplitLine[vSplitLine.length - 1]);
				break;
	
			case sENDED:
				lneLogLineVO.setMatchId(getMatchId(vSplitLine));
				lneLogLineVO.setActionEnum(vSplitLine[vSplitLine.length - 1]);
				break;
	
			default:
				int iKilledWordIndex = getLogLineWordIndex(vSplitLine, sKILLED);
				lneLogLineVO.setActionEnum(vSplitLine[iKilledWordIndex]);
				lneLogLineVO.setKillerNickName(vSplitLine[iKilledWordIndex - 1]);
				lneLogLineVO.setVictmNickName(vSplitLine[iKilledWordIndex + 1]);
				lneLogLineVO.setWeapon(vSplitLine[vSplitLine.length - 1]);
				break;
			}
		} else {
			lneLogLineVO.setActionEnum(sWORLD);
			int iKilledWordIndex = getLogLineWordIndex(vSplitLine, sKILLED);
			lneLogLineVO.setVictmNickName(vSplitLine[iKilledWordIndex + 1]);
		}

		return lneLogLineVO;
	}

	private int getLogLineWordIndex (String vSplitLine[], String sWord) {
		
		int iIndex = Integer.MIN_VALUE;
		
		for (int i = 0; i < vSplitLine.length; ++i) {
			vSplitLine[i] = vSplitLine[i].replace("<", "");
			vSplitLine[i] = vSplitLine[i].replace(">", "");
			if (vSplitLine[i].equalsIgnoreCase(sWord)) {
				iIndex = i;
				break;
			}
		}
		
		return iIndex;
	}
	
	private String getMatchId(String vSplitLine[]) {
		return vSplitLine[getLogLineWordIndex(vSplitLine, sMATCH) + 1];
	}
}
