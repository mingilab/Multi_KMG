package co.kr.mingilab.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kr.mingilab.DTO.AccountDTO;
import co.kr.mingilab.util.DBUtil;

public class UserEXPDAO {
	
	static Connection conn;
	static PreparedStatement st;
	static ResultSet rs;
	
	public static int[] User_exptable(){
		int[] lvarr = new int[100];
		String sql ="SELECT USER_NEEDEXP FROM USEREXP";	 
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			int i = 0;
			while(rs.next()){
				lvarr[i] = rs.getInt(1);
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}		
		return lvarr;
	}
	
}
