package ex05_exception_class;

/*
	예외 클래스 만들기
	1. Exception 클래스를 상속 받는다. (필수)
	2. Exception 클래스의 슈퍼 클래스인 Throwable 클래스가 Serializable 인터페이스를 
	   구현하기 때문에 serialVesionUID 값을 가질 수 있다.(선택)
*/

public class GunException extends Exception{ //gunException에 마우스 올리고 generate......선택

	private static final long serialVersionUID = 3700059434730916901L;
	
	private String exceptionCode;
	
	public GunException(String message, String exceptionCode) {
		super(message);
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	
}
