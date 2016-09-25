package br.com.cubotecnologia.bo.ranking;

import java.util.Map;

import br.com.cubotecnologia.vo.RankinVO;

public interface IRankingBO {
	public Map<String, RankinVO> processesRanking(String sLogPath) throws Exception ;
}
