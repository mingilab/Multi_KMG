package co.kr.mingilab.controller;


import java.util.Scanner;

import co.kr.mingilab.DAO.AccountDAO;
import co.kr.mingilab.DAO.Dolls_StorageDAO;
import co.kr.mingilab.DAO.ResourcesDAO;
import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.ui.UI;
public class MainController {
	
	static public void mainprint(AccountDTO dto){
		
		/*
		 * 	System.out.println("1.자원생성");
		 * 	System.out.println("2.인형생성");
		 * 	System.out.println("3.경험치관리");
		 * 	System.out.println("4.인형리스트");
		 * 	System.out.println("0.프로그램종료");
		 */
		AccountDAO accountdao = new AccountDAO();
		AccountDTO accountdto = new AccountDTO();
		AccountDAO exp = new AccountDAO();
	
		Scanner sc = new Scanner(System.in);
		int select;
		myloop : while(true){
			accountdto = accountdao.loadAccount(dto.getUser_id());
			ResourcesDTO Resourcesdto = ResourcesDAO.loadResources(dto.getUser_id());
			UI.mainUI(accountdto, Resourcesdto);
			select = sc.nextInt();
			switch (select){
			case 0:
				System.out.print("소녀전선을 종료합니다.");
				System.exit(0);
			
			case 1:{
				int count = ResourcesDAO.Area0Code0(dto.getUser_id());
				System.out.println(count + "건의 자원이 생성되었습니다.");
				break;
			}
			case 2:{
				ChoiceController.chocieprint(dto);
				break;
			}
			case 3:{
				int count = exp.expup(accountdto, 1000);
				System.out.println(count + "건의 경험치가 올랐습니다.");
				break;
			}
			case 4:{
				Dolls_StorageDAO.printDoll(dto.getUser_id());
				break;
			}
			case 5:{
				DeleteController.deleteprint(accountdto, Resourcesdto);
				break;
			}
			default:
				System.out.println("잘못 선택하셨습니다.");
				break;
				
			} //switch
			
		} //while
		
	} //mainprint
	
} //class
