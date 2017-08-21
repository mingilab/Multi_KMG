package co.kr.mingilab.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.util.DBUtil;



public class AccountDAO {
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int needexp[] = UserEXPDAO.User_exptable();
	
	/*
	 *  USER_ID                                   NOT NULL VARCHAR2(30)
	 *  USER_PW                                   NOT NULL VARCHAR2(30)
	 *  USER_LV                                            NUMBER(3)
	 *  USER_EXP                                           NUMBER(10)
	 *  CREATION_DATE                                      DATE
	 */
	
	public AccountDTO loadAccount(String uid) {
		
		String sql ="SELECT USER_ID, USER_LV, USER_EXP, CREATION_DATE FROM Account where user_id = ?";	 		
		AccountDTO dto = new AccountDTO();
		dto.setUser_pw("");
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, uid);
			rs = st.executeQuery();
			if(rs.next()){
				dto.setUser_id(rs.getString(1));
				dto.setUser_lv(rs.getInt(2));
				dto.setUser_exp(rs.getInt(3));
				dto.setCreation_date(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		return dto;
		
	} // userlogin
	
	// ������ ���� Account DTO����
	public AccountDTO userlogin(String uid, String upw) {
		AccountDTO dto=null;
		String sql ="select * from Account where USER_ID = ?";	 
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, uid);
			rs = st.executeQuery();
			if(rs.next()){
				dto = new AccountDTO();
				dto.setUser_id(rs.getNString(1));
				dto.setUser_pw(rs.getString(2));
				dto.setUser_lv(rs.getInt(3));
				dto.setUser_exp(rs.getInt(4));
				dto.setCreation_date(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		if(upw.equals(dto.getUser_pw())){
			System.out.println("���ӿ� �����Ͽ����ϴ�.");
			return dto;
		} else {
			System.out.println("���ӿ� �����Ͽ����ϴ�.");
			return null;
		}
		
	} // userlogin
		
	//����ڷκ��� �Է��� �޾� ��������
	public void makeUser(){
		
		Scanner sc = new Scanner(System.in);
		
		String user_id = null;                                
	 	String user_pw = null;  
	 	String uid = null;
	 	String upw1 = null;
	 	String upw2 = null;
	 	char ykey = ' ';
	 	boolean loof = true;;
	 	int loofcount = 0;
	 	String sql;
	 		 	
	 	System.out.println("ID�� �Է��� �ּ���");
	 	uid = sc.nextLine();	
	 	uid.trim();
	 	
	 	while(loof){
	 		System.out.println("PW�� �Է��� �ּ���");
		 	upw1 = sc.nextLine();
		 	System.out.println("PW�� �ٽ� �Է��� �ּ���");
		 	upw2 = sc.nextLine();
		 	if(upw1.equals(upw2)){
		 		user_id = uid;
		 		user_pw = upw1;
		 		System.out.println("�Է��Ͻ� ID�� �н����带 Ȯ�����ּ���");
		 		System.out.printf("ID : %s PW : %s %n",user_id,user_pw);
		 		System.out.println("������ y�Ǵ� Y�� �����ּ���. �ٸ�Ű�� ������ ����ȭ������ ���ư��ϴ�.");
		 		ykey = sc.nextLine().charAt(0);
		 		if(ykey == 'y' || ykey == 'Y'){
		 			loof = false;
		 		}else{
		 			System.out.println("����ȭ������ ���ư��ϴ�.");
		 			return;
		 		}
		 	}else{
		 		System.out.println("�������� ���� ��й�ȣ�Դϴ�. �ٽ� �Է��� �ּ���.");
		 		loofcount ++;	
		 	}//if
		 	if(loofcount==3){
		 		System.out.println("�Է��Ͻ� ������ 3ȸ Ʋ�Ƚ��ϴ�. �ٽ� �õ����ּ���.");
		 		return;
		 	}
	 	}//while
	 	
	 	sql = "insert into ACCOUNT(USER_ID,USER_PW) values(?,?)";
	 	conn = DBUtil.getConnect();
	 	int count = 0;
	 	try {
			st = conn.prepareStatement(sql);
			st.setString(1, user_id);
			st.setString(2, user_pw);
			count = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("������ ���������� �ֽ��ϴ�. �ٽ� �õ����ּ���.");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
		} finally{
			DBUtil.dbClose(conn, st, rs);
		}
	 	System.out.println(count);
	 	
	 	if(count==0){
	 		System.out.println("���������� �����Ͽ����ϴ�.");
	 	}else{
		 	Dolls_StorageDAO.makeDoll(user_id, 5);
		 	Dolls_StorageDAO.makeDoll(user_id, 7);
		 	Dolls_StorageDAO.makeDoll(user_id, 68);
		 	ResourcesDAO.makeResources(user_id);
	 		System.out.println("���������� �Ϸ�Ǿ����ϴ�.");
	 	}
	 	
	} //makeUser
	
	// ����ġ �����żҵ�
	public int expup(AccountDTO dto, int expup){
		String sql = null; 
		int userexp = dto.getUser_exp()+expup;
		int userlv = dto.getUser_lv()-1;
		int count = 0;
		int lvcount = 0;
		if(userexp >= needexp[userlv]){
			while(userexp>=needexp[userlv]){
				userexp -= needexp[userlv];
				lvcount ++;					
			} //while
		} //if
		sql = "update ACCOUNT set USER_EXP = ?, USER_LV = USER_LV + ? where USER_ID = ?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, userexp);
			st.setInt(2, lvcount);
			st.setString(3, dto.getUser_id());
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
			
		return count;
	} // Area0Code0
	
}//class