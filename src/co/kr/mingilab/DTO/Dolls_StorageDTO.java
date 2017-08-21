package co.kr.mingilab.DTO;

public class Dolls_StorageDTO {
	
	/*
	 * USER_ID                                   NOT NULL VARCHAR2(30)
 	 * DOLL_SECNO                                NOT NULL NUMBER
 	 * DOLL_ID                                   NOT NULL NUMBER(3)
 	 * DOLL_LV								default 1     NUMBER(3)
	 */
	
	String user_id;
	int doll_secno;
	int doll_id;
	int doll_lv;
	
	public Dolls_StorageDTO(){
		
	}
	
	public Dolls_StorageDTO(String user_id, int doll_id) {
		super();
		this.user_id = user_id;
		this.doll_id = doll_id;
	}

	public Dolls_StorageDTO(String user_id, int doll_secno, int doll_id, int doll_lv) {
		super();
		this.user_id = user_id;
		this.doll_secno = doll_secno;
		this.doll_id = doll_id;
		this.doll_lv = doll_lv;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getDoll_secno() {
		return doll_secno;
	}

	public void setDoll_secno(int doll_secno) {
		this.doll_secno = doll_secno;
	}

	public int getDoll_id() {
		return doll_id;
	}

	public void setDoll_id(int doll_id) {
		this.doll_id = doll_id;
	}

	public int getDoll_lv() {
		return doll_lv;
	}

	public void setDoll_lv(int doll_lv) {
		this.doll_lv = doll_lv;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dolls_StorageDTO [user_id=").append(user_id).append(", doll_secno=").append(doll_secno)
				.append(", doll_id=").append(doll_id).append(", doll_lv=").append(doll_lv).append("]");
		return builder.toString();
	}
	
}
