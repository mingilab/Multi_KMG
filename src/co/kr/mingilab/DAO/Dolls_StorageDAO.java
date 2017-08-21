package co.kr.mingilab.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.kr.mingilab.DTO.Dolls_InformationDTO;
import co.kr.mingilab.DTO.Dolls_StorageDTO;
import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.util.DBUtil;

public class Dolls_StorageDAO {
	
	static Connection conn;
	static PreparedStatement st;
	static ResultSet rs;
	static int count;
	
	//인형생성
	static public void makeDoll(String user_id, int doll_id){
		
	 	String sql;
	 	sql = "insert into DOLLS_STORAGE(USER_ID,DOLL_ID,DOLL_SECNO) values(?,?,DOLLSEC.nextval)";
	 	conn = DBUtil.getConnect();
	 	count = 0;
	 	
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user_id);
			st.setInt(2, doll_id);
			count = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		System.out.println(count + "인형이 생성되었습니다.");
		
	} //makeDoll
	
	// 인형검색 
	static public void printDoll(String user_id){
		Dolls_InformationDTO infodto=null;
		Dolls_StorageDTO strdto=null;
		
		String sql ="select USER_ID, DOLL_ID, DOLL_SECNO, DOLL_NAME, DOLL_GRADE, DOLL_CLASS, DOLL_LV"
				+ " from DOLLS_STORAGE join DOLLS_INFORMATION using(DOLL_ID)"
				+ " where USER_ID = ?"
				+ " order by DOLL_GRADE";	 
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user_id);
			rs = st.executeQuery();
			while(rs.next()){
				strdto = new Dolls_StorageDTO();
				infodto = new Dolls_InformationDTO();	
				strdto.setUser_id(rs.getString(1));
				strdto.setDoll_id(rs.getInt(2));
				strdto.setDoll_secno(rs.getInt(3));
				infodto.setDoll_name(rs.getString(4));
				infodto.setDoll_grade(rs.getInt(5));
				infodto.setDoll_class(rs.getString(6));
				strdto.setDoll_lv(rs.getInt(7));
				System.out.printf("번호 : %3d / 고유번호 : %3d / 이름 : %16s / 등급 : %d / 클래스 : %3s / 레벨 : %3d%n",
				strdto.getDoll_id(),strdto.getDoll_secno(),infodto.getDoll_name(),infodto.getDoll_grade(),infodto.getDoll_class(),strdto.getDoll_lv());
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
	}

	// 코드재사용으로 인해 커넥이 주석처리 되어있음 사용시 주의
	static public Dolls_InformationDTO getDollInfo(int doll_sec){
		
		Dolls_InformationDTO infodto=null;
		String sql ="select DOLL_ID, DOLL_NAME, DOLL_GRADE, DOLL_CLASS"
				+ " from DOLLS_STORAGE join DOLLS_INFORMATION using(DOLL_ID)"
				+ " where DOLL_SECNO = ?";	 
		//conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, doll_sec);
			rs = st.executeQuery();
			infodto = new Dolls_InformationDTO();	
			if(rs.next()){
				infodto.setDoll_id(rs.getInt(1));
				infodto.setDoll_name(rs.getString(2));
				infodto.setDoll_grade(rs.getInt(3));
				infodto.setDoll_class(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DBUtil.dbClose(conn, st, rs);
		}
		//System.out.println(infodto.toString());
		return infodto;
	}
	
	
	static public void deleteDoll(String uid, ResourcesDTO rdto){
		int doll_sec;
		int core;
		int grade;
		String sql;
		Dolls_InformationDTO dolldto = null;
		sql = "DELETE FROM DOLLS_STORAGE WHERE DOLL_SECNO = ?";
		conn = DBUtil.getConnect();
		
		count = 0;
		System.out.println("고유번호를 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		doll_sec = sc.nextInt();
		
		try {
			//오토커밋을 하지 않겠다.
			conn.setAutoCommit(false);
			dolldto = getDollInfo(doll_sec);
			st = conn.prepareStatement(sql);
			st.setInt(1, doll_sec);
			count = st.executeUpdate();
			//완료후 커밋
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//실패시 롤백
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		grade = dolldto.getDoll_grade();
		
		switch (grade) {
			case 2:
				core = 0;
				break;
			case 3:
				core = 1;
				break;
			case 4:
				core = 3;
				break;
			case 5:
				core = 5;
				break;
			default:
				core = 0;
				break;
		} 
		
		ResourcesDAO.GenerateResources(uid, 0, 0, 0, 0, core);
		System.out.println("코어" + core + "개 생성되었습니다.");
		System.out.println(count + "인형이 삭제되었습니다.");
			
		} //DeleteDoll				
				
} // Dolls_StorageDAO