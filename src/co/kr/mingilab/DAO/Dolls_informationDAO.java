package co.kr.mingilab.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kr.mingilab.DTO.Dolls_InformationDTO;
import co.kr.mingilab.DTO.ResourcesDTO;
import co.kr.mingilab.util.DBUtil;

public class Dolls_informationDAO {
	
	static Connection conn;
	static PreparedStatement st;
	static ResultSet rs;
	
	// 이름추출
	public static Dolls_InformationDTO dollsinfo(int dollno){
		
		Dolls_InformationDTO dto=null;
		String sql ="select DOLL_ID, DOLL_NAME from DOLLS_INFORMATION where DOLL_ID=?";	 
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, dollno);
			rs = st.executeQuery();
			if(rs.next()){
				dto = new Dolls_InformationDTO(rs.getInt(1),rs.getString(2));					
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		
		return dto;
	}
	
}
