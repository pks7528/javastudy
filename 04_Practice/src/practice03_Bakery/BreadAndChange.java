package practice03_Bakery;

public class BreadAndChange {

	//필드
	private int breadCount;
	private int change;
	
	//생성자
	public BreadAndChange(int breadCount, int change) {
		super();
		this.breadCount = breadCount;
		this.change = change;
	}

	//메소드
	public int getBreadCount() {
		return breadCount;
	}

	public void setBreadCount(int breadCount) {
		this.breadCount = breadCount;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}
	
	
}
