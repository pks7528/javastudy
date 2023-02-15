package ex04_builder;

//롬복 등록 
// 프로젝트 단위로 등록
//프로젝트 우클릭 -build path - configure build path - library 추가



public class User {
	
	// User 필드(Builder 객체가 가진 값을 받아온다.)
	private String id;
	private String pw;
	
	// User 생성자
	public User(Builder builder) {
		this.id = builder.id;
		this.pw = builder.pw;
	}
	
	// Builder 객체 반환
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	// Builder 클래스(내부 클래스)
	public static class Builder {
		
		// Builder 필드(여기로 값을 전달받아서 User 필드로 값을 전달한다.)
		private String id;
		private String pw;
		
		// 값을 받아오는 메소드
		// 1. 메소드명과 필드명 동일하게 구성
		// 2. 메소드 체이닝을 위해서 현재 객체를 반환한다.
			
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public Builder pw(String pw) {
			this.pw = pw;
			return this;
		}
		
		// User 객체 반환
		// Builder 필드 값을 가진 User 객체를 반환
		public User build() {
			return new User(this);
		}
		
	}
	
}
