package co.kr.mingilab.DTO;

public class UserEXPDTO {
	
	/*
	 *  USER_LV                                   NOT NULL NUMBER(3)
	 *  USER_NEEDEXP                 default 1    NOT NULL NUMBER(10)
	 */
	
	int user_lv;
	int user_needexp;
		
	public UserEXPDTO() {
		super();
	}
	public UserEXPDTO(int user_lv, int user_needexp) {
		super();
		this.user_lv = user_lv;
		this.user_needexp = user_needexp;
	}
	public int getUser_lv() {
		return user_lv;
	}
	public void setUser_lv(int user_lv) {
		this.user_lv = user_lv;
	}
	public int getUser_needexp() {
		return user_needexp;
	}
	public void setUser_needexp(int user_needexp) {
		this.user_needexp = user_needexp;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserEXPDTO [user_lv=").append(user_lv).append(", user_needexp=").append(user_needexp)
				.append("]");
		return builder.toString();
	}
	
}
