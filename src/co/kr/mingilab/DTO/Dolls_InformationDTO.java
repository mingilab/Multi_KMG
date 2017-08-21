package co.kr.mingilab.DTO;

public class Dolls_InformationDTO {
	
	/*
	 * DOLL_ID                                            NUMBER(3)
	 * DOLL_NAME                                 NOT NULL VARCHAR2(20)
 	 * DOLL_GRADE                                NOT NULL NUMBER(1)
 	 * DOLL_CLASS                                NOT NULL VARCHAR2(3)
 	 * DOLL_HP                                   NOT NULL NUMBER(4)
 	 * DOLL_ATK                                  NOT NULL NUMBER(3)
 	 * DOLL_HIT                                  NOT NULL NUMBER(3)
 	 * DOLL_AVOID                                NOT NULL NUMBER(3)
 	 * DOLL_ATKSPEED                             NOT NULL NUMBER(3)
 	 * DOLL_MOV                                  NOT NULL NUMBER(3)
	 * DOLL_MAGAZINE                             NOT NULL NUMBER(2)
 	 * DOLL_ARMOR                                NOT NULL NUMBER(3)
 	 * DOLL_TIME                          향후 수정예정            VARCHAR2(5)
	 */
	
	int doll_id;
	String doll_name;
	int doll_grade;
	String doll_class;
	int doll_hp;
	int doll_atk;
	int doll_hit;
	int doll_avoid;
	int doll_atkspeed;
	int doll_mov;
	int doll_magazine;
	int doll_armor;
	String doll_time;
	
	public Dolls_InformationDTO(){
		
	}
		
	public Dolls_InformationDTO(int doll_id, String doll_name) {
		super();
		this.doll_id = doll_id;
		this.doll_name = doll_name;
	}

	public Dolls_InformationDTO(int doll_id, String doll_name, int doll_grade, String doll_class, int doll_hp,
			int doll_atk, int doll_hit, int doll_avoid, int doll_atkspeed, int doll_mov, int doll_magazine,
			int doll_armor, String doll_time) {
		super();
		this.doll_id = doll_id;
		this.doll_name = doll_name;
		this.doll_grade = doll_grade;
		this.doll_class = doll_class;
		this.doll_hp = doll_hp;
		this.doll_atk = doll_atk;
		this.doll_hit = doll_hit;
		this.doll_avoid = doll_avoid;
		this.doll_atkspeed = doll_atkspeed;
		this.doll_mov = doll_mov;
		this.doll_magazine = doll_magazine;
		this.doll_armor = doll_armor;
		this.doll_time = doll_time;
	}

	public int getDoll_id() {
		return doll_id;
	}

	public void setDoll_id(int doll_id) {
		this.doll_id = doll_id;
	}

	public String getDoll_name() {
		return doll_name;
	}

	public void setDoll_name(String doll_name) {
		this.doll_name = doll_name;
	}

	public int getDoll_grade() {
		return doll_grade;
	}

	public void setDoll_grade(int doll_grade) {
		this.doll_grade = doll_grade;
	}

	public String getDoll_class() {
		return doll_class;
	}

	public void setDoll_class(String doll_class) {
		this.doll_class = doll_class;
	}

	public int getDoll_hp() {
		return doll_hp;
	}

	public void setDoll_hp(int doll_hp) {
		this.doll_hp = doll_hp;
	}

	public int getDoll_atk() {
		return doll_atk;
	}

	public void setDoll_atk(int doll_atk) {
		this.doll_atk = doll_atk;
	}

	public int getDoll_hit() {
		return doll_hit;
	}

	public void setDoll_hit(int doll_hit) {
		this.doll_hit = doll_hit;
	}

	public int getDoll_avoid() {
		return doll_avoid;
	}

	public void setDoll_avoid(int doll_avoid) {
		this.doll_avoid = doll_avoid;
	}

	public int getDoll_atkspeed() {
		return doll_atkspeed;
	}

	public void setDoll_atkspeed(int doll_atkspeed) {
		this.doll_atkspeed = doll_atkspeed;
	}

	public int getDoll_mov() {
		return doll_mov;
	}

	public void setDoll_mov(int doll_mov) {
		this.doll_mov = doll_mov;
	}

	public int getDoll_magazine() {
		return doll_magazine;
	}

	public void setDoll_magazine(int doll_magazine) {
		this.doll_magazine = doll_magazine;
	}

	public int getDoll_armor() {
		return doll_armor;
	}

	public void setDoll_armor(int doll_armor) {
		this.doll_armor = doll_armor;
	}

	public String getDoll_time() {
		return doll_time;
	}

	public void setDoll_time(String doll_time) {
		this.doll_time = doll_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dolls_InformationDTO [doll_id=").append(doll_id).append(", doll_name=").append(doll_name)
				.append(", doll_grade=").append(doll_grade).append(", doll_class=").append(doll_class)
				.append(", doll_hp=").append(doll_hp).append(", doll_atk=").append(doll_atk).append(", doll_hit=")
				.append(doll_hit).append(", doll_avoid=").append(doll_avoid).append(", doll_atkspeed=")
				.append(doll_atkspeed).append(", doll_mov=").append(doll_mov).append(", doll_magazine=")
				.append(doll_magazine).append(", doll_armor=").append(doll_armor).append(", doll_time=")
				.append(doll_time).append("]");
		return builder.toString();
	}
		
}
