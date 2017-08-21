package co.kr.mingilab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;

public class DBUtil {
	
	//연결
	public static Connection getConnect(){
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@70.12.110.77:1521:xe";
		String user ="dolls";
		String password ="dolls";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	} //getConnect()
	
	public static void dbClose(Connection conn, Statement st, ResultSet rs){
		
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // dbClose
	
	//java.util.Date -> java.sql.Date로 변환
	public static java.sql.Date convertDate(java.util.Date d){
		
		java.sql.Date sqld = new java.sql.Date(d.getTime());
		return sqld;
		
	}
	
	//Stirng을 java.tuil.Date로 변환
	public static java.sql.Date stringToDate(String sdate){
		
		java.sql.Date sqld=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		try {
			java.util.Date d2 = sdf.parse(sdate);
			sqld = convertDate(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqld;
	}
	
	public static <E> E getWeightedRandom(Map<E, Double> weights, Random random) {
		  E result = null;
		  double bestValue = Double.MAX_VALUE;
		 
		  for (E element : weights.keySet()) {
		    double value = -Math.log(random.nextDouble()) / weights.get(element);
		    if (value < bestValue) {
		      bestValue = value;
		      result = element;
		    }
		  }
		  return result;
		}	
}
