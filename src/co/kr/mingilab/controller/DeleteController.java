package co.kr.mingilab.controller;

import java.util.Scanner;

import co.kr.mingilab.DAO.Dolls_StorageDAO;
import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.ui.UI;

public class DeleteController {
	
	public static void deleteprint(AccountDTO dto, ResourcesDTO rdto){
		Scanner sc = new Scanner(System.in);
	
		myloop : while(true){
			UI.deleteUI(rdto);
			int select = sc.nextInt();
			switch(select){
			
			case 0:
				System.out.print("메인화면으로 돌아갑니다.");
				break myloop;
			
			case 1:
				System.out.println("고유번호 삭제");
				Dolls_StorageDAO.deleteDoll(dto.getUser_id(), rdto);
				break;
				
			default :
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	} // delete
} //class
