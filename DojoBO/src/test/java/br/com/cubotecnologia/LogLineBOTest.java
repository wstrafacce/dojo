package br.com.cubotecnologia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cubotecnologia.bo.logline.ILogLineBO;
import br.com.cubotecnologia.bo.logline.impl.LogLineBO;
import br.com.cubotecnologia.vo.LogLineVO;

public class LogLineBOTest {

	@Test
	public void processesLogLineTest() {
		List<String> lLines = new ArrayList<String>();
		List<LogLineVO> lLogLineVO = new ArrayList<LogLineVO>();
		
		lLines.add("23/04/2013 15:34:22 - New match 11348965 has started");
		lLines.add("23/04/2013 15:36:04 - Roman killed Nick using M16");
		lLines.add("23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN");
		lLines.add("23/04/2013 15:39:22 - Match 11348965 has ended");
		
		for (String sLine : lLines) {
			ILogLineBO llbLogLineBO = new LogLineBO();
			lLogLineVO.add(llbLogLineBO.processesLogLine(sLine));	
		}
		
		compareAssert(lLogLineVO.get(0), "23/04/2013 15:34:22", "11348965", null, null, "started", null);
		compareAssert(lLogLineVO.get(1), "23/04/2013 15:36:04", null, "Roman", "Nick", "killed", "M16");
		compareAssert(lLogLineVO.get(2), "23/04/2013 15:36:33", null, null, "Nick", "WORLD", null);
		compareAssert(lLogLineVO.get(3), "23/04/2013 15:39:22", "11348965", null, null, "ended", null);
	}
	
	private void compareAssert 
					(LogLineVO llvLogLineVO, String sDateTime, String sMatchId, String sKillerNickName, 
							String sVictmNickName, String sActionEnum, String sWeapon) {
		
		assertEquals(sDateTime, llvLogLineVO.getDateTime());
		assertEquals(sMatchId, llvLogLineVO.getMatchId());
		assertEquals(sKillerNickName, llvLogLineVO.getKillerNickName());
		assertEquals(sVictmNickName, llvLogLineVO.getVictmNickName());
		assertEquals(sActionEnum, llvLogLineVO.getActionEnum());
		assertEquals(sWeapon, llvLogLineVO.getWeapon());
		
	}

}
