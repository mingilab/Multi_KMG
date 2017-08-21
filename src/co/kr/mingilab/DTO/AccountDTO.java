package co.kr.mingilab.DTO;

public class AccountDTO {
	
	/*
	 * USER_ID                                   NOT NULL VARCHAR2(30)
 	 * USER_PW                                   NOT NULL VARCHAR2(30)
 	 * USER_LV  (default 1)                               NUMBER(3)
 	 * USER_EXP (defualt 1)                               NUMBER(10)
 	 * CREATION_DATE (default sysdate)                    DATE
	 */
	
	String user_id;                                
 	String user_pw;                                  
 	int user_lv;                                       
 	int user_exp;                                 
 	String creation_date;
 	
 	public AccountDTO(){
 		
 	}
 	
	public AccountDTO(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	public AccountDTO(String user_id, String user_pw, int user_lv, int user_exp, String creation_date) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_lv = user_lv;
		this.user_exp = user_exp;
		this.creation_date = creation_date;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public int getUser_lv() {
		return user_lv;
	}
	public void setUser_lv(int user_lv) {
		this.user_lv = user_lv;
	}
	public int getUser_exp() {
		return user_exp;
	}
	public void setUser_exp(int user_exp) {
		this.user_exp = user_exp;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountDTO [user_id=").append(user_id).append(", user_pw=").append(user_pw).append(", user_lv=")
				.append(user_lv).append(", user_exp=").append(user_exp).append(", creation_date=").append(creation_date)
				.append("]");
		return builder.toString();
	}
	
}
