package co.kr.mingilab.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.util.DBUtil;

public class ResourcesDAO {
	
	static Connection conn;
	static PreparedStatement st;
	static ResultSet rs;
	
	//�ڿ�����
	public static int GenerateResources(String uid, int manpower, int ammuniton, int food, int parts, int core){
		String sql = "update RESOURCES"
				+ " set MANPOWER = MANPOWER +"+ manpower + ","
				+ " AMMUNITON = AMMUNITON +" + ammuniton +","
				+ " FOOD = FOOD +" + food +","
				+ " PARTS = PARTS +"+ parts +","
				+ " CORE = CORE +" + core
				+ " where USER_ID = ?";
		conn = DBUtil.getConnect();
		int count=0;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, uid);
			count = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�ִ밪�� �Ѿ� �ڿ������� �Ұ����մϴ�. �ڿ��Ҹ� �� �ٽ� �õ��� �ּ���.");
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		return count;
	} // Area0Code0
	
	// �ڿ����� 0���� �ڵ� �����Ʒ�
	public static int Area0Code0(String uid){
		String sql = "update RESOURCES"
				+ " set MANPOWER = MANPOWER + 1000,"
				+ " AMMUNITON = AMMUNITON + 1000,"
				+ " FOOD = FOOD + 1000,"
				+ " PARTS = PARTS + 1000"
				+ " where USER_ID = ?";
		conn = DBUtil.getConnect();
		int count=0;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, uid);
			count = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�ִ밪�� �Ѿ� �ڿ������� �Ұ����մϴ�. �ڿ��Ҹ� �� �ٽ� �õ��� �ּ���.");
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		return count;
	} // Area0Code0
	
	// �ε帮�ҽ�
	public static ResourcesDTO loadResources(String uid) {
		ResourcesDTO dto=null;
		String sql ="SELECT * FROM RESOURCES where user_id = ?";	 
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, uid);
			rs = st.executeQuery();
			if(rs.next()){
				dto = new ResourcesDTO();
				dto.setUser_id(rs.getString(1));
				dto.setManpower(rs.getInt(2));
				dto.setAmmuniton(rs.getInt(3));
				dto.setFood(rs.getInt(4));
				dto.setParts(rs.getInt(5));
				dto.setCore(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		return dto;
		
	} // userlogin
	
	// �ʱ��ڿ� ����
	static public void makeResources(String user_id){
		
	 	String sql;
	 	sql = "insert into RESOURCES(USER_ID) values(?)";
	 	conn = DBUtil.getConnect();
	 	int count = 0;
	 	
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user_id);
			count = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		System.out.println(count + "�ڿ��� �����Ǿ����ϴ�");
		
	} //makeDoll
	
	// �ڿ����
	static public int ResourcesUse(String user_id, int manpower, int ammuniton, int food, int parts){
		String sql = "update RESOURCES"
				+ " set MANPOWER = MANPOWER-"+ manpower +","
				+ " AMMUNITON = AMMUNITON-"+ ammuniton + ","
				+ " FOOD = FOOD-"+ food +","
				+ " PARTS = PARTS-" + parts
				+ " where USER_ID = ?";
		conn = DBUtil.getConnect();
		int count=0;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user_id);
			count = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�ڿ��� �����մϴ�. �ڿ��� Ȯ���� �ּ���.");
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;	
	}
	
	
} //ResourcesDAO
