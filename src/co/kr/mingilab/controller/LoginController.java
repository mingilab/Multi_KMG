package co.kr.mingilab.controller;

import java.util.Scanner;

import co.kr.mingilab.DAO.AccountDAO;
import co.kr.mingilab.DAO.Dolls_StorageDAO;
import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.ui.UI;

public class LoginController {
	
	public static void main(String[] args) {
		AccountDTO dto = null ;
		AccountDAO dao = null;
		int select;
		Scanner sc = new Scanner(System.in);
		myloop : while(true){
			UI.loginUI();
			System.out.print("작업선택하세요>>");
			select = sc.nextInt();
			switch (select){
			case 0:
				System.out.print("소녀전선을 종료합니다.");
				System.exit(0);
			
			case 1:
				sc.nextLine();
				System.out.print("ID를 입력해 주세요");
				String user_id = sc.nextLine();
				System.out.println("PW를 입력해 주세요");
				String user_pw = sc.nextLine();
				dao = new AccountDAO();
				dto = dao.userlogin(user_id, user_pw);
				if(dto!=null){
					MainController.mainprint(dto);
				//	if(sc!=null) sc.close();
				//	return;
				}
				break;
			case 2:
				AccountDAO usermake = new AccountDAO();
				usermake.makeUser();
				usermake = null;
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
				break;
			} //switch
		}// while
	}//main

}//controller
