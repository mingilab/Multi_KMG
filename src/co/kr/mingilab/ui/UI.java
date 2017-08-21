package co.kr.mingilab.ui;

import co.kr.mingilab.DAO.AccountDAO;
import co.kr.mingilab.DAO.ResourcesDAO;
import co.kr.mingilab.DAO.UserEXPDAO;
import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.DTO.ResourcesDTO;

public class UI {
	
	static int needexp[] = UserEXPDAO.User_exptable();
	
	public static void loginUI(){
		
		System.out.println("== 소녀전선에 오신 여러분을 환영합니다. ==");
		System.out.println("1.접속");
		System.out.println("2.계정생성");
		System.out.println("0.프로그램종료");
		System.out.println();
	}
	
	static public void mainUI(AccountDTO adto, ResourcesDTO rdto){
		
		System.out.println(adto.getUser_id()+"님 환영합니다.");
		System.out.printf("LV : %d, 경험치 : %d, 필요경험치 : %d%n",adto.getUser_lv(), adto.getUser_exp(), needexp[adto.getUser_lv()-1]);
		System.out.printf("인력 : %d/300000, 탄약 : %d/300000, 식량 : %d/300000, 부품 : %d/300000%n",
						  rdto.getManpower(), rdto.getAmmuniton(), rdto.getFood(), rdto.getParts());
		
		System.out.println("작업선택하세요>>");
		System.out.println("1.자원생성");
		System.out.println("2.인형생성");
		System.out.println("3.경험치증가");
		System.out.println("4.인형리스트");
		System.out.println("5.인형해체");
		System.out.println("0.프로그램종료");
	}
	
	static public void deleteUI(ResourcesDTO rdto){
		rdto = ResourcesDAO.loadResources(rdto.getUser_id());
		System.out.println("Core : "+ rdto.getCore());
		System.out.println("수명이 다한 인형을 해체합니다. 코스트에 따라 Core가 지급됩니다.");
		System.out.println("0.메인화면");
		System.out.println("1.시컨스분해");
		//System.out.println("2.등급분해");
	}
	
	static public void choiceUI(){
		System.out.println("인형제조를 시작합니다. 제조식을 선택해 주세요.");
		System.out.println("제조식별 자원소모량은 아래와 같습니다.");
		System.out.println("1.핸드건제조식(130/130/130/130), 2.범용제조식(430/430/430/230), 3.기관총제조식(730/630/130/430)");
		System.out.println("확률은 5성:5% / 4성:10% / 3성:20% / 2성:65%입니다.");
		System.out.println("1.핸드건제조");
		System.out.println("2.범용");
		System.out.println("3.기관총");
		System.out.println("0.메인화면");
		System.out.println();
	}
}
