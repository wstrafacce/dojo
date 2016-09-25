package br.com.cubotecnologia;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.ranking.impl.RankingBO;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.utils.ListUtils;
import br.com.cubotecnologia.vo.RankinVO;
import br.com.cubotecnologia.vo.RankingLineVO;

public class RankingBOTest {

	@Test
	public void processesRankingTest() {
		IRankingBO irkbRankingBO = new RankingBO();
		
		Map<String, RankinVO> mapRankingVO = null;
		
		try {
			mapRankingVO = irkbRankingBO.processesRanking("dojo.log");
			
			List<Map.Entry<String, RankinVO>> lRanking = new LinkedList<Map.Entry<String, RankinVO>>(mapRankingVO.entrySet());
			
			for (Map.Entry<String, RankinVO> entry : lRanking) {
				RankinVO rkvRankingVO = entry.getValue();
				List<RankingLineVO> lRankingLineVO = rkvRankingVO.getRankingLines();
				ListUtils.sortList(lRankingLineVO);
				
				assertEquals("23/04/2013 15:34:22", rkvRankingVO.getStartedDate());
				assertEquals("11348965", rkvRankingVO.getMatchId());
				
				
				compareAssert(lRankingLineVO.get(0), "Roman", "4", "3", "MAGNUM");
				compareAssert(lRankingLineVO.get(1), "Nick", "3", "5", "PISTOL");
				
				assertEquals("23/04/2013 15:42:22", rkvRankingVO.getEndedDate()); 
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void compareAssert
					(RankingLineVO rlvRankingLineVO, String sNickName, String sNumberOfMurders, 
							String sNumeberOfDeaths, String sFavoriteWeapon) {
		assertEquals(sNickName, rlvRankingLineVO.getPlayerNickName());
		assertEquals(sNumberOfMurders, rlvRankingLineVO.getPlayerMurders());
		assertEquals(sNumeberOfDeaths, rlvRankingLineVO.getPlayerDeaths());
		assertEquals(sFavoriteWeapon, rlvRankingLineVO.getFavoriteWeapon());
	}

}
