package co.kr.mingilab.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Choismap {
	
	static Connection conn;
	static PreparedStatement st;
	static ResultSet rs;
	
	public static Map<String, Double> choiceMap(String mapname){
		
		Map<String, Double> w = new HashMap<String, Double>();
		String sql ="SELECT DOLL_ID, " + mapname + " FROM DOLLS_CHOICE";	 
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				w.put(rs.getInt(1)+"", rs.getDouble(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.dbClose(conn, st, rs);
		}
		
		return w;
	}
}
