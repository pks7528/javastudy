package ex01_setter;

public class User {
	
	//필드
	private String id;
	private String pw;
	
	//메소드			
	//필드가 몇개일지 모르기 때문에 constructor보다 setter를 더 많이 쓴다
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	
}
