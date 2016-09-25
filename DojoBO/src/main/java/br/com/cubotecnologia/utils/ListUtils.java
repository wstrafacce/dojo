package br.com.cubotecnologia.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.cubotecnologia.vo.RankingLineVO;

public class ListUtils {
	
	public static void sortList(List<RankingLineVO> lRankingLineVO) {
		Collections.sort(lRankingLineVO, new Comparator<RankingLineVO>() {
	        @Override
	        public int compare(RankingLineVO rlvRankingLineVO_1, RankingLineVO rlvRankingLineVO_2)
	        {
	        	
	            return  rlvRankingLineVO_1.getPlayerMurders().compareTo(rlvRankingLineVO_1.getPlayerMurders());
	        }
	    });
	}

}
