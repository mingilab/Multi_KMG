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
		 * 	System.out.println("1.�ڿ�����");
		 * 	System.out.println("2.��������");
		 * 	System.out.println("3.����ġ����");
		 * 	System.out.println("4.��������Ʈ");
		 * 	System.out.println("0.���α׷�����");
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
				System.out.print("�ҳ������� �����մϴ�.");
				System.exit(0);
			
			case 1:{
				int count = ResourcesDAO.Area0Code0(dto.getUser_id());
				System.out.println(count + "���� �ڿ��� �����Ǿ����ϴ�.");
				break;
			}
			case 2:{
				ChoiceController.chocieprint(dto);
				break;
			}
			case 3:{
				int count = exp.expup(accountdto, 1000);
				System.out.println(count + "���� ����ġ�� �ö����ϴ�.");
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
				System.out.println("�߸� �����ϼ̽��ϴ�.");
				break;
				
			} //switch
			
		} //while
		
	} //mainprint
	
} //class
