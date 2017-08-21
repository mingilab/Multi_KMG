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
			System.out.print("�۾������ϼ���>>");
			select = sc.nextInt();
			switch (select){
			case 0:
				System.out.print("�ҳ������� �����մϴ�.");
				System.exit(0);
			
			case 1:
				sc.nextLine();
				System.out.print("ID�� �Է��� �ּ���");
				String user_id = sc.nextLine();
				System.out.println("PW�� �Է��� �ּ���");
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
				System.out.println("�߸� �����ϼ̽��ϴ�.");
				break;
			} //switch
		}// while
	}//main

}//controller
