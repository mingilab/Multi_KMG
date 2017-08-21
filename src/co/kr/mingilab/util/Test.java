package co.kr.mingilab.util;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import co.kr.mingilab.DAO.Dolls_informationDAO;
import co.kr.mingilab.DTO.Dolls_InformationDTO;

public class Test {
	
	public static void main(String[] args) {
		
		
		Map<String, Double> m0 = Choismap.choiceMap("DOLL_CHOICE3");
		int count;
		Map<String, Double> w = new HashMap<String, Double>();
		w.put("ball", 25D);
		w.put("strike", 70D);
		w.put("wild pitch", 5D);
		
		for(int i = 0 ; i <50 ; i++){
			Random rand = new Random();
			String dollno = DBUtil.getWeightedRandom(m0, rand);	
			Dolls_InformationDTO dto2 = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
			System.out.println(i+" "+dto2.getDoll_id()+" "+dto2.getDoll_name());
		}
	}
}
