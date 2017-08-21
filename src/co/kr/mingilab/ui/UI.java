package co.kr.mingilab.ui;

import co.kr.mingilab.DAO.AccountDAO;
import co.kr.mingilab.DAO.ResourcesDAO;
import co.kr.mingilab.DAO.UserEXPDAO;
import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.DTO.ResourcesDTO;

public class UI {
	
	static int needexp[] = UserEXPDAO.User_exptable();
	
	public static void loginUI(){
		
		System.out.println("== �ҳ������� ���� �������� ȯ���մϴ�. ==");
		System.out.println("1.����");
		System.out.println("2.��������");
		System.out.println("0.���α׷�����");
		System.out.println();
	}
	
	static public void mainUI(AccountDTO adto, ResourcesDTO rdto){
		
		System.out.println(adto.getUser_id()+"�� ȯ���մϴ�.");
		System.out.printf("LV : %d, ����ġ : %d, �ʿ����ġ : %d%n",adto.getUser_lv(), adto.getUser_exp(), needexp[adto.getUser_lv()-1]);
		System.out.printf("�η� : %d/300000, ź�� : %d/300000, �ķ� : %d/300000, ��ǰ : %d/300000%n",
						  rdto.getManpower(), rdto.getAmmuniton(), rdto.getFood(), rdto.getParts());
		
		System.out.println("�۾������ϼ���>>");
		System.out.println("1.�ڿ�����");
		System.out.println("2.��������");
		System.out.println("3.����ġ����");
		System.out.println("4.��������Ʈ");
		System.out.println("5.������ü");
		System.out.println("0.���α׷�����");
	}
	
	static public void deleteUI(ResourcesDTO rdto){
		rdto = ResourcesDAO.loadResources(rdto.getUser_id());
		System.out.println("Core : "+ rdto.getCore());
		System.out.println("������ ���� ������ ��ü�մϴ�. �ڽ�Ʈ�� ���� Core�� ���޵˴ϴ�.");
		System.out.println("0.����ȭ��");
		System.out.println("1.����������");
		//System.out.println("2.��޺���");
	}
	
	static public void choiceUI(){
		System.out.println("���������� �����մϴ�. �������� ������ �ּ���.");
		System.out.println("�����ĺ� �ڿ��Ҹ��� �Ʒ��� �����ϴ�.");
		System.out.println("1.�ڵ��������(130/130/130/130), 2.����������(430/430/430/230), 3.�����������(730/630/130/430)");
		System.out.println("Ȯ���� 5��:5% / 4��:10% / 3��:20% / 2��:65%�Դϴ�.");
		System.out.println("1.�ڵ������");
		System.out.println("2.����");
		System.out.println("3.�����");
		System.out.println("0.����ȭ��");
		System.out.println();
	}
}
