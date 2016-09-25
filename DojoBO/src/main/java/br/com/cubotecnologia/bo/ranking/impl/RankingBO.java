package br.com.cubotecnologia.bo.ranking.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.cubotecnologia.bo.logline.ILogLineBO;
import br.com.cubotecnologia.bo.logline.impl.LogLineBO;
import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.weapon.IWeaponBO;
import br.com.cubotecnologia.bo.weapon.impl.WeaponBO;
import br.com.cubotecnologia.entities.death.Death;
import br.com.cubotecnologia.entities.murder.Murder;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.entities.players.impl.Player;
import br.com.cubotecnologia.entities.weapons.impl.AWeapon;
import br.com.cubotecnologia.enuns.ActionsEnum;
import br.com.cubotecnologia.utils.DateUtil;
import br.com.cubotecnologia.utils.FileUtils;
import br.com.cubotecnologia.vo.LogLineVO;
import br.com.cubotecnologia.vo.RankinVO;
import br.com.cubotecnologia.vo.RankingLineVO;

public class RankingBO implements IRankingBO {
	
	private static Map<String, RankinVO> mapRankinVO;
	private static Map<String, IPlayer> mapPlayers;
	private static String sCurrentMatchId;
	private static RankinVO rknCurrentRankinVO; 
	
	private static RankinVO getRankinVOInstance (String sMatchId) {
		RankinVO rknRankinVO = null;
		if(mapRankinVO != null && mapRankinVO.containsKey(sMatchId)) {
			rknRankinVO = mapRankinVO.get(sMatchId);
		} else {
			if (mapRankinVO == null) {
				mapRankinVO = new LinkedHashMap<String, RankinVO>();
			}
			
			rknRankinVO = new RankinVO(sMatchId);
			mapRankinVO.put(sMatchId, rknRankinVO);
		}
		
		return rknRankinVO;
	}
	
	private static IPlayer getPlayerInstance(String sNickName){
		IPlayer iplyPlayer = null;
		if(mapPlayers != null && mapPlayers.containsKey(sNickName)) {
			iplyPlayer = mapPlayers.get(sNickName);
		} else {
			if (mapPlayers == null) {
				mapPlayers = new LinkedHashMap<String, IPlayer>();
			}
			
			iplyPlayer = new Player(sNickName);
			mapPlayers.put(sNickName, iplyPlayer);
		}
		
		return iplyPlayer;
	}

	@Override
	public Map<String, RankinVO> processesRanking(String sLogPath) throws Exception {
		// TODO Auto-generated method stub
		List<String> lLines = FileUtils.getLines(sLogPath);
		ILogLineBO illbLogLineBO = new LogLineBO();
		IWeaponBO iwpnWeaponBO = new WeaponBO();
		
		IPlayer iplyPlayer = null;
		AWeapon wpnWeapon = null;
		Murder mrdMurder = null;
		Death dthDeath = null;
		
		List<RankingLineVO> lRankingLineVO = new ArrayList<RankingLineVO>();
		
		
		for (String sLogLine : lLines) {
			LogLineVO llvlLogLineVO = illbLogLineBO.processesLogLine(sLogLine);
			
			ActionsEnum actAction = ActionsEnum.getActionByStrAction(llvlLogLineVO.getActionEnum());
			
			switch (actAction) {
			case STARTED:
				instantiateNewRankingVO(llvlLogLineVO.getMatchId(), llvlLogLineVO.getDateTime());
				break;
			
			case ENDED:
				rknCurrentRankinVO.setEndedDate(llvlLogLineVO.getDateTime());
				
				List<Map.Entry<String, IPlayer>> lPlayers = new LinkedList<Map.Entry<String, IPlayer>>(mapPlayers.entrySet());
				
				for (Map.Entry<String, IPlayer> entry : lPlayers) {
					RankingLineVO rlvRankingLineVO = processessRankingLine(entry.getKey(), entry.getValue());
					lRankingLineVO.add(rlvRankingLineVO);
				}
				
				rknCurrentRankinVO.setRankingLines(lRankingLineVO);				
				break;
			
			case KILLED:
				iplyPlayer = getPlayerInstance(llvlLogLineVO.getKillerNickName());
				wpnWeapon = iwpnWeaponBO.getWeaponInstace(llvlLogLineVO.getWeapon());
				mrdMurder = new Murder(DateUtil.getDateFromString(llvlLogLineVO.getDateTime()), wpnWeapon);
				iplyPlayer.addMurder(mrdMurder);
				iplyPlayer = getPlayerInstance(llvlLogLineVO.getVictmNickName());
				dthDeath = new Death(DateUtil.getDateFromString(llvlLogLineVO.getDateTime()));
				iplyPlayer.addDeath(dthDeath);
				break;
				
			case WORLD:
				iplyPlayer = getPlayerInstance(llvlLogLineVO.getVictmNickName());
				dthDeath = new Death(DateUtil.getDateFromString(llvlLogLineVO.getDateTime()));
				iplyPlayer.addDeath(dthDeath);
				break;
			}		
		}
		
		return mapRankinVO;
	}
	
	private RankingLineVO processessRankingLine (String sNickName, IPlayer iplyPlayer) {
		RankingLineVO rlvRankingLineVO = new RankingLineVO();
		
		rlvRankingLineVO.setPlayerNickName(sNickName);
		rlvRankingLineVO.setPlayerMurders(String.valueOf(iplyPlayer.getNumberOfMurders()));
		rlvRankingLineVO.setPlayerDeaths(String.valueOf(iplyPlayer.getNumberOfDeaths()));
		rlvRankingLineVO.setFavoriteWeapon(iplyPlayer.getFavoriteWeapon());
		
		return rlvRankingLineVO;
	}
	
	private void instantiateNewRankingVO (String sMatchId, String sDateTime){
		
		if (rknCurrentRankinVO != null
				&& !rknCurrentRankinVO.getMatchId().equalsIgnoreCase(sMatchId)
				&& (rknCurrentRankinVO.getEndedDate() == null || StringUtils.isEmpty(rknCurrentRankinVO.getEndedDate()))) {
			
			rknCurrentRankinVO.setEndedDate(sDateTime);
		}
		
		if (mapPlayers != null) {
			mapPlayers.clear();
		}
		
		sCurrentMatchId = sMatchId;
		rknCurrentRankinVO = getRankinVOInstance(sCurrentMatchId);
		rknCurrentRankinVO.setStartedDate(sDateTime);
	}	
}
