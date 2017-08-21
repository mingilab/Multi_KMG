package co.kr.mingilab.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import co.kr.mingilab.DAO.Dolls_StorageDAO;
import co.kr.mingilab.DAO.Dolls_informationDAO;
import co.kr.mingilab.DAO.ResourcesDAO;
import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.DTO.Dolls_InformationDTO;
import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.ui.UI;
import co.kr.mingilab.util.Choismap;
import co.kr.mingilab.util.DBUtil;

public class ChoiceController {
		
	static Map<String, Double> map0 = Choismap.choiceMap("DOLL_CHOICE0");
	static Map<String, Double> map1 = Choismap.choiceMap("DOLL_CHOICE1");
	static Map<String, Double> map2 = Choismap.choiceMap("DOLL_CHOICE2");
	static Map<String, Double> map3 = Choismap.choiceMap("DOLL_CHOICE3");
	static Map<String, Double> greadmap = new HashMap<String, Double>();
	
	static boolean resourcesget1;
	static boolean resourcesget2;
	static String gread;
	static Random rand;
	static Dolls_InformationDTO dolldto;
	static ResourcesDTO rdto; 
	static String dollno;
	
	public static void chocieprint(AccountDTO dto) {
		
		/*
		 * 	System.out.println("1.핸드건제조");
		 * 	System.out.println("2.범용");
		 * 	System.out.println("3.기관총");
		 * 	System.out.println("0.메인화면");
		 */
		
		rdto = ResourcesDAO.loadResources(dto.getUser_id());
		
		greadmap.put("2성", 65D);
		greadmap.put("345성", 35D);
		
		Scanner sc = new Scanner(System.in);
		
		
		myloop : while(true){
			UI.choiceUI();
			rand = new Random();
			
			int select = sc.nextInt();
			
			switch(select){
			
			case 0:
				System.out.print("메인화면으로 돌아갑니다.");
				return;
			
			case 1:
				System.out.print("핸드건제조를 시작합니다.");
				resourcesget1 = rdto.getManpower()>=130 && rdto.getAmmuniton()>=130;
				resourcesget2 = rdto.getFood()>=130 && rdto.getParts()>=130;
				
				if(resourcesget1 && resourcesget2){
					Random rand = new Random();
					gread = DBUtil.getWeightedRandom(greadmap, rand);	
				}else{
					System.out.println("자원이 부족합니다. 확인 후 다시 시도해주세요");
					return;
				}
				if(gread.equals("2성")){
					dollno = DBUtil.getWeightedRandom(map0, rand);	
					dolldto = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
					ResourcesDAO.ResourcesUse(dto.getUser_id(), 130, 130, 130, 130);
					Dolls_StorageDAO.makeDoll(dto.getUser_id(), dolldto.getDoll_id());
					System.out.println(dolldto.getDoll_name()+"을 획득하였습니다.");
					System.out.println();
				
				}else if(gread.equals("345성")){
					dollno = DBUtil.getWeightedRandom(map1, rand);	
					dolldto = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
					ResourcesDAO.ResourcesUse(dto.getUser_id(), 130, 130, 130, 130);
					Dolls_StorageDAO.makeDoll(dto.getUser_id(), dolldto.getDoll_id());
					System.out.println(dolldto.getDoll_name()+"을 획득하였습니다.");
					System.out.println();
				}
				
				break;
				
			case 2:
				System.out.print("범용제조를 시작합니다.");
				resourcesget1 = rdto.getManpower()>=430 && rdto.getAmmuniton()>=430;
				resourcesget2 = rdto.getFood()>=430 && rdto.getParts()>=230;
				
				if(resourcesget1 && resourcesget2){
					Random rand = new Random();
					gread = DBUtil.getWeightedRandom(greadmap, rand);	
				}else{
					System.out.println("자원이 부족합니다. 확인 후 다시 시도해주세요");
					return;
				}
				if(gread.equals("2성")){
					dollno = DBUtil.getWeightedRandom(map0, rand);	
					dolldto = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
					ResourcesDAO.ResourcesUse(dto.getUser_id(), 430, 430, 430, 230);
					Dolls_StorageDAO.makeDoll(dto.getUser_id(), dolldto.getDoll_id());
					System.out.println(dolldto.getDoll_name()+"을 획득하였습니다.");
					System.out.println();
				
				}else if(gread.equals("345성")){
					dollno = DBUtil.getWeightedRandom(map2, rand);	
					dolldto = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
					ResourcesDAO.ResourcesUse(dto.getUser_id(), 430, 430, 430, 230);
					Dolls_StorageDAO.makeDoll(dto.getUser_id(), dolldto.getDoll_id());
					System.out.println(dolldto.getDoll_name()+"을 획득하였습니다.");
					System.out.println();
				}
				
				break;
			
			case 3:
				System.out.print("기관총제조를 시작합니다.");
				resourcesget1 = rdto.getManpower()>=730 && rdto.getAmmuniton()>=630;
				resourcesget2 = rdto.getFood()>=130 && rdto.getParts()>=430;
				
				if(resourcesget1 && resourcesget2){
					Random rand = new Random();
					gread = DBUtil.getWeightedRandom(greadmap, rand);	
				}else{
					System.out.println("자원이 부족합니다. 확인 후 다시 시도해주세요");
					return;
				}
				if(gread.equals("2성")){
					dollno = DBUtil.getWeightedRandom(map0, rand);	
					dolldto = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
					ResourcesDAO.ResourcesUse(dto.getUser_id(), 730, 630, 130, 430);
					Dolls_StorageDAO.makeDoll(dto.getUser_id(), dolldto.getDoll_id());
					System.out.println(dolldto.getDoll_name()+"을 획득하였습니다.");
					System.out.println();
				
				}else if(gread.equals("345성")){
					dollno = DBUtil.getWeightedRandom(map3, rand);	
					dolldto = Dolls_informationDAO.dollsinfo(Integer.parseInt(dollno));
					ResourcesDAO.ResourcesUse(dto.getUser_id(), 730, 630, 130, 430);
					Dolls_StorageDAO.makeDoll(dto.getUser_id(), dolldto.getDoll_id());
					System.out.println(dolldto.getDoll_name()+"을 획득하였습니다.");
					System.out.println();
				}
				
				break;
			
				
			default :
				System.out.println("잘못 입력하였습니다.");
				break;
			} //switch
			
		}//while
		
	}//chocieprint
	
}// ChoiceController
