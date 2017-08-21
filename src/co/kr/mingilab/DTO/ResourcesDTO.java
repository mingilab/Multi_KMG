package co.kr.mingilab.DTO;

public class ResourcesDTO {
	
	/*
	 *  USER_ID                                   NOT NULL VARCHAR2(30)
	 *  MANPOWER                           default 1000    NUMBER(10)
	 *  AMMUNITON                          default 1000    NUMBER(10)
	 *  FOOD                               default 1000    NUMBER(10)
	 *  PARTS                              default 1000    NUMBER(10)
 	 *  CORE                               default 1       NUMBER(5)
	 */
	
	String user_id;
	int manpower;
	int ammuniton;
	int food;
	int parts;
	int core;
	
	public ResourcesDTO(){
		
	}
	
	public ResourcesDTO(String user_id) {
		super();
		this.user_id = user_id;
	}
	
	public ResourcesDTO(String user_id, int manpower, int ammuniton, int food, int parts, int core) {
		super();
		this.user_id = user_id;
		this.manpower = manpower;
		this.ammuniton = ammuniton;
		this.food = food;
		this.parts = parts;
		this.core = core;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getManpower() {
		return manpower;
	}
	public void setManpower(int manpower) {
		this.manpower = manpower;
	}
	public int getAmmuniton() {
		return ammuniton;
	}
	public void setAmmuniton(int ammuniton) {
		this.ammuniton = ammuniton;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getParts() {
		return parts;
	}
	public void setParts(int parts) {
		this.parts = parts;
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResourcesDTO [user_id=").append(user_id).append(", manpower=").append(manpower)
				.append(", ammuniton=").append(ammuniton).append(", food=").append(food).append(", parts=")
				.append(parts).append(", core=").append(core).append("]");
		return builder.toString();
	}
	
}
