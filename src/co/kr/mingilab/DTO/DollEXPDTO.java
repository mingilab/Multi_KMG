package co.kr.mingilab.DTO;

public class DollEXPDTO {
	
	/*
	 *  DOLL_LV                                   NOT NULL NUMBER(3)
	 *  DOLL_NEEDEXP                              NOT NULL NUMBER(10)
	 */
	
		
	int doll_lv;
	int doll_needexp;
		
	public DollEXPDTO(int doll_lv, int doll_needexp) {
		super();
		this.doll_lv = doll_lv;
		this.doll_needexp = doll_needexp;
	}
	
	public int getDoll_lv() {
		return doll_lv;
	}
	public void setDoll_lv(int doll_lv) {
		this.doll_lv = doll_lv;
	}
	public int getDoll_needexp() {
		return doll_needexp;
	}
	public void setDoll_needexp(int doll_needexp) {
		this.doll_needexp = doll_needexp;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DollEXPDTO [doll_lv=").append(doll_lv).append(", doll_needexp=").append(doll_needexp)
				.append("]");
		return builder.toString();
	}
	
}
